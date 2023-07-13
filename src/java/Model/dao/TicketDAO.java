/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Control.customer.orderServlet;
import DBcontext.DB;
import Model.Ticket;
import Model.TicketType;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class TicketDAO {

    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    Connection connection;

    public TicketDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTicket(String ticketID, String orderID, String flightID, String ticketTypeID, String luggageID, String seat) throws SQLException {
        String stmt = "insert into Ticket values" + " (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, ticketID);
        ps.setString(2, orderID);
        ps.setString(3, flightID);
        ps.setString(4, ticketTypeID);
        ps.setString(5, luggageID);
        ps.setString(6, seat);
        ps.executeUpdate();
    }

    public ArrayList<String> getSeats(String TicketTypeID, String flightID) throws SQLException {
        ArrayList<String> seats = new ArrayList<>();
        String stmt = "SELECT t.Seat\n"
                + "FROM Ticket t\n"
                + "WHERE t.TicketType_ID = ? and t.Flight_ID = ?";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, TicketTypeID);
        ps.setString(2, flightID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getString(1) != null) {
                seats.add(rs.getString(1));
            }
        }
        return seats;
    }

    public String createSeats(String TicketTypeID, String flightID) {
        String seat = null;
        TicketTypeDAO ttD = new TicketTypeDAO();
        try {
            ArrayList<String> seats = getSeats(TicketTypeID, flightID);
            List<TicketType> ticketTypes = ttD.getTickets();
            for (TicketType ticketType : ticketTypes) {
                if (ticketType.getTicketTypeId().equals(TicketTypeID)) {
                    seat = ticketType.getTicketType() + (seats.size() + 1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seat;
    }

    public ArrayList<String[]> getTicket() throws SQLException {
        ArrayList<String[]> tickets = new ArrayList<>();
        String stmt = "SELECT \n"
                + "  t.[Ticket_ID], t.[Seat], f.[StartDate], f.[StartTime], f.[Departure],f.[Destination],f.[Gate], l.[Luggage], p.[Passenger_Name], tt.[TicketType_Name],ot.[Date]\n"
                + "FROM \n"
                + "  Ticket t\n"
                + "JOIN \n"
                + "  Flight f ON t.[Flight_ID] = f.[Flight_ID]\n"
                + "JOIN \n"
                + "  Luggage l ON t.[Luggage_ID] = l.[Luggage_ID]\n"
                + "JOIN \n"
                + "  Passenger p ON t.[Ticket_ID] = p.[Ticket_ID]\n"
                + "JOIN \n"
                + "  TicketType tt ON t.[TicketType_ID] = tt.[TicketType_ID]\n"
                + "JOIN\n"
                + "  OrderTicket ot ON t.[Order_ID] = ot.[Order_ID]";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String[] ticketStatic = {rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getNString(5), rs.getNString(6), rs.getString(7),
                rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
            tickets.add(ticketStatic);
        }
        return tickets;
    }

    public ArrayList<String[]> getTicketByPage(String page) throws SQLException {
        ArrayList<String[]> tickets = new ArrayList<>();
        String stmt = "SELECT t.[Ticket_ID], t.[Seat], f.[StartDate], f.[StartTime], f.[Departure], \n"
                + "  f.[Destination], f.[Gate], l.[Luggage],  p.[Passenger_Name], tt.[TicketType_Name],ot.[Date]\n"
                + "FROM \n"
                + "  Ticket t\n"
                + "JOIN \n"
                + "  Flight f ON t.[Flight_ID] = f.[Flight_ID]\n"
                + "JOIN \n"
                + "  Luggage l ON t.[Luggage_ID] = l.[Luggage_ID]\n"
                + "JOIN \n"
                + "  Passenger p ON t.[Ticket_ID] = p.[Ticket_ID]\n"
                + "JOIN \n"
                + "  TicketType tt ON t.[TicketType_ID] = tt.[TicketType_ID]\n"
                + "JOIN\n"
                + "  OrderTicket ot ON t.[Order_ID] = ot.[Order_ID]\n"
                + "ORDER BY ot.Date DESC\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT 5 ROWS ONLY;";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setInt(1, (Integer.parseInt(page) - 1) * 5);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String[] ticketStatic = {rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4).substring(0, 8), rs.getNString(5), rs.getNString(6), rs.getString(7),
                rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
            tickets.add(ticketStatic);
        }
        return tickets;
    }

    public String[] getTicketByID(String ticketID) throws SQLException {
        String[] ticketStatic = null;
        String stmt = "SELECT t.[Ticket_ID], t.[Seat], f.[StartDate], f.[StartTime], f.[Departure],f.[Destination],f.[Gate], l.[Luggage], p.[Passenger_Name], tt.[TicketType_Name],ot.[Date]\n"
                + "Into TicketStatistic\n"
                + "FROM Ticket t\n"
                + "JOIN Flight f ON t.[Flight_ID] = f.[Flight_ID]\n"
                + "JOIN Luggage l ON t.[Luggage_ID] = l.[Luggage_ID]\n"
                + "JOIN Passenger p ON t.[Ticket_ID] = p.[Ticket_ID]\n"
                + "JOIN TicketType tt ON t.[TicketType_ID] = tt.[TicketType_ID]\n"
                + "JOIN OrderTicket ot ON t.[Order_ID] = ?";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, ticketID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ticketStatic = new String[]{rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getNString(5), rs.getNString(6), rs.getString(7),
                rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
        }
        return ticketStatic;
    }

    public void cancelTicket(String ticketID) throws SQLException {
        String stmt = "ALTER TABLE dbo.Passenger\n"
                + "DROP CONSTRAINT fk_tblPassenger2;\n"
                + "\n"
                + "ALTER TABLE dbo.Passenger\n"
                + "ADD CONSTRAINT fk_tblPassenger2 \n"
                + "    FOREIGN KEY (Ticket_ID) REFERENCES dbo.Ticket(Ticket_ID)\n"
                + "    ON DELETE CASCADE;\n"
                + "\n"
                + "DELETE FROM Ticket WHERE Ticket_ID = ?;\n"
                + "\n"
                + "DELETE FROM Passenger WHERE Ticket_ID = ?;";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, ticketID);
        ps.setString(2, ticketID);
        ps.executeUpdate();
    }

    public void addSeat(String ticketID) throws SQLException {
        String smtEco = "UPDATE Flight\n"
                + "SET \n"
                + "    SeatsB = CASE WHEN Ticket.TicketType_ID = 'TT2' THEN SeatsB + 1 ELSE SeatsB END,\n"
                + "    SeatsC = CASE WHEN Ticket.TicketType_ID = 'TT1' THEN SeatsC + 1 ELSE SeatsC END        \n"
                + "FROM (\n"
                + "    SELECT Flight_ID, TicketType_ID\n"
                + "    FROM Ticket\n"
                + "    WHERE Ticket_ID = ?\n"
                + ") AS Ticket \n"
                + "INNER JOIN Flight ON Ticket.Flight_ID = Flight.Flight_ID\n"
                + "WHERE Ticket.TicketType_ID IN ('TT1', 'TT2');";
        PreparedStatement ps = connection.prepareStatement(smtEco);
        ps.setString(1, ticketID);
        ps.executeUpdate();
    }

    public ArrayList<String[]> getTicketByOrder_ID(String Order_ID) throws SQLException {
        ArrayList<String[]> tickets = new ArrayList<>();
        String stmt = "SELECT t.[Ticket_ID], t.[Seat], f.[StartDate], f.[StartTime], f.[Departure], \n"
                + "  f.[Destination], f.[Gate], l.[Luggage],  p.[Passenger_Name], tt.[TicketType_Name],ot.[Date]\n"
                + "FROM \n"
                + "  Ticket t\n"
                + "JOIN \n"
                + "  Flight f ON t.[Flight_ID] = f.[Flight_ID]\n"
                + "JOIN \n"
                + "  Luggage l ON t.[Luggage_ID] = l.[Luggage_ID]\n"
                + "JOIN \n"
                + "  Passenger p ON t.[Ticket_ID] = p.[Ticket_ID]\n"
                + "JOIN \n"
                + "  TicketType tt ON t.[TicketType_ID] = tt.[TicketType_ID]\n"
                + "JOIN\n"
                + "  OrderTicket ot ON t.[Order_ID] = ot.[Order_ID]\n"
                + "where ot.Order_ID = ? ";

        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, Order_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String[] ticketStatic = {rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4).substring(0, 8),
                rs.getNString(5),
                rs.getNString(6),
                rs.getString(7),
                rs.getString(
                8), rs.getString(9),
                rs.getString(10),
                rs.getString(11)
            };
            tickets.add(ticketStatic);
        }
        return tickets;
    }

    public static void main(String[] args) {
        TicketDAO td = new TicketDAO();
        try {
            for (String[] arg : td.getTicketByOrder_ID("qdvtsn")) {
                for (int i = 0; i < arg.length; i++) {
                    System.out.print(arg[i] + ",");
                }
                System.out.println("\n");

            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
