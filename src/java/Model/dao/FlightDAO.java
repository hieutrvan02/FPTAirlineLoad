package Model.dao;

import DBcontext.DB;
import Control.format.Format;
import Model.Flight;
import Model.FlightV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightDAO {

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    List<Flight> flights;

    public List<Flight> getListFlight(String startDate, String departure, String destination) {
        flights = new ArrayList<>();
        Format format = new Format();
        String query = "SELECT \n"
                + "    Flight.Flight_ID,\n"
                + "    Flight.StartDate,\n"
                + "    Flight.EndDate,\n"
                + "    Flight.StartTime,\n"
                + "    Flight.EndTime,\n"
                + "    Flight.Departure,\n"
                + "    Flight.Destination,\n"
                + "    SUM(TicketType_Flight.Seats) AS TotalSeats\n"
                + "FROM \n"
                + "    Flight\n"
                + "JOIN \n"
                + "    TicketType_Flight ON Flight.Flight_ID = TicketType_Flight.Flight_ID\n"
                + "WHERE \n"
                + "    Flight.StartDate = ?\n"
                + "    AND Flight.Departure = ?\n"
                + "    AND Flight.Destination = ?\n"
                + "GROUP BY \n"
                + "    Flight.Flight_ID,\n"
                + "    Flight.StartDate,\n"
                + "    Flight.EndDate,\n"
                + "    Flight.StartTime,\n"
                + "    Flight.EndTime,\n"
                + "    Flight.Departure,\n"
                + "    Flight.Destination\n"
                + "ORDER BY \n"
                + "    Flight.StartTime ASC;";
        try {
            connection = new DB().makeConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, startDate);
            statement.setString(2, departure);
            statement.setString(3, destination);
            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Flight flight = new Flight(resultSet.getString(1), format.formatDate(resultSet.getString(2)),
//                        format.formatDate(resultSet.getString(3)), format.formatTime(resultSet.getString(4))
//                        , format.formatTime(resultSet.getString(5)), resultSet.getString(6), resultSet.getString(7));
//                flights.add(flight);
//            }
            //Only for Minh
            while (resultSet.next()) {
                Flight flight = new Flight(resultSet.getString(1), format.addTwoDays(format.formatDate(resultSet.getString(2))),
                        format.addTwoDays(format.formatDate(resultSet.getString(3))), format.formatTime(resultSet.getString(4)),
                        format.formatTime(resultSet.getString(5)), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getInt(8));
                flights.add(flight);
            }
            return flights;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSeatFlight(int seats, String FlightID, String ticketTypeID) throws SQLException, ClassNotFoundException {
        connection = new DB().makeConnection();
        try {
            flights = new ArrayList<>();
            String query = "UPDATE TicketType_Flight\n"
                    + "Set Seats = Seats - ?\n"
                    + "WHERE Flight_ID = ? And TicketType_ID = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, seats);
            statement.setString(2, FlightID);
            statement.setString(3, ticketTypeID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Flight> lookUpFlight(String ticketId, String passengerName) throws ClassNotFoundException {
        flights = new ArrayList<>();
        Format format = new Format();
        try {
            String query = "SELECT Ticket.Flight_ID, Flight.StartDate, Flight.StartTime, Flight.Departure, Flight.Destination,Ticket.Seats, TicketType.TicketType_Name\n"
                    + "FROM Passenger\n"
                    + "JOIN Ticket ON Passenger.Ticket_ID = Ticket.Ticket_ID\n"
                    + "JOIN Flight ON Ticket.Flight_ID = Flight.Flight_ID\n"
                    + "JOIN TicketType ON TicketType.TicketType_ID = Ticket.TicketType_ID\n"
                    + "WHERE Passenger.Passenger_Name = ? AND Passenger.Ticket_ID = ? ";
            connection = new DB().makeConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, passengerName);
            statement.setString(2, ticketId);
            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Flight flight = new Flight(resultSet.getString(1), format.formatDate(resultSet.getString(2)), format.formatTime(resultSet.getString(3)), resultSet.getString(4),
//                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
//                flights.add(flight);
//            }
            //Only for Minh
            while (resultSet.next()) {
                Flight flight = new Flight(resultSet.getString(1), format.addTwoDays(format.formatDate(resultSet.getString(2))), format.formatTime(resultSet.getString(3)),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                flights.add(flight);
            }
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Flight> getAllFlight() {
        ArrayList<Flight> getAllFlight = new ArrayList<>();
        String query = "select * from Flight";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                getAllFlight.add(new Flight(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8), resultSet.getInt(9),
                        resultSet.getInt(10), resultSet.getString(11)));
            }
        } catch (Exception e) {
        }
        return getAllFlight;
    }

    public ArrayList<FlightV2> getAll() {
        ArrayList<FlightV2> getAll = new ArrayList<>();
        Format format = new Format();
        String query = "select  Flight.Flight_ID, Flight.StartDate, Flight.EndDate, Flight.StartTime, Flight.EndTime, Flight.Departure, \n"
                + "		Flight.Destination, Flight.Gate, Flight.SeatsB, Flight.SeatsC, Distance.Price \n"
                + "from Flight \n"
                + "inner join Distance\n"
                + "on Flight.Distance_ID = Distance.Distance_ID";

        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FlightV2 flightv2 = new FlightV2(resultSet.getString(1), format.formatDate(resultSet.getString(2)),
                        format.formatDate(resultSet.getString(3)), format.formatTime(resultSet.getString(4)),
                        format.formatTime(resultSet.getString(5)),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getInt(9), resultSet.getInt(10), resultSet.getFloat(11));

                getAll.add(flightv2);
            }
        } catch (Exception e) {
        }
        return getAll;
    }

    public void insert(Flight f) {
        String query = "Insert into Flight \n"
                + "values \n"
                + "(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, f.getFlightId());
            statement.setString(2, f.getStartDate());
            statement.setString(3, f.getEndDate());
            statement.setString(4, f.getStartTime());
            statement.setString(5, f.getEndTime());
            statement.setString(6, f.getDeparture());
            statement.setString(7, f.getDestination());
            statement.setInt(8, f.getGate());
            statement.setInt(9, f.getSeatB());
            statement.setInt(10, f.getSeatC());
            statement.setString(11, f.getDistanceID());

            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    //tim 1 flight by ID
    public Flight getFlightById(String Flight_ID) {
        String query = "Select * from Flight where Flight_ID = ?";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, Flight_ID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Flight f = new Flight(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8), resultSet.getInt(9),
                        resultSet.getInt(10), resultSet.getString(11));
                return f;
            }
        } catch (Exception e) {
        }
        return null;
    }

    //delete Flight
    public void deleteFlight(String id) {
        String query = "DELETE FROM [dbo].[Flight]\n"
                + "      WHERE Flight_ID = ?";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Flight flights = new Flight();
        FlightDAO flightDAO = new FlightDAO();
        List<Flight> flightsOne = flightDAO.getListFlight("2023-05-25", "Đà Nẵng", "Hồ Chí Minh");
        for (Flight flight : flightsOne) {
            System.out.println(flight);
//            System.out.println(flight.getSeatB());
        }
//        flightDAO.updateSeatFlight(50, 50, "DM1", "Economic");

    }
}