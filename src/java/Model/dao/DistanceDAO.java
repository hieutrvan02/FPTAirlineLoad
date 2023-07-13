package Model.dao;

import Control.format.Format;
import DBcontext.DB;
import Model.Distance;
import Model.DistanceV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DistanceDAO {

    private List<Distance> distanceList = new ArrayList<>();

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public DistanceDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Distance> getDistances(String startDate, String departure, String destination) {
        Format format = new Format();
        String query = "SELECT *\n"
                + "FROM Flight as f, Distance\n"
                + "WHERE f.Distance_ID = Distance.Distance_ID "
                + "and f.StartDate = ? and f.Departure = ? and f.Destination = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, startDate);
            statement.setString(2, departure);
            statement.setString(3, destination);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Distance distance = new Distance(resultSet.getString(10), resultSet.getString(11), resultSet.getFloat(12),
                        resultSet.getString(1), format.formatDate(resultSet.getString(2)),
                        format.formatDate(resultSet.getString(3)), format.formatTime(resultSet.getString(4)),
                        format.formatTime(resultSet.getString(5)), resultSet.getString(6), resultSet.getString(7));
                distanceList.add(distance);
            }
            //Only for Minh
//            while (resultSet.next()) {
//                Distance distance = new Distance(resultSet.getString(12), resultSet.getString(13), resultSet.getFloat(14),
//                        resultSet.getString(1), format.addTwoDays(format.formatDate(resultSet.getString(2))),
//                        format.addTwoDays(format.formatDate(resultSet.getString(3))), format.formatTime(resultSet.getString(4)),
//                        format.formatTime(resultSet.getString(5)), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(9),
//                        resultSet.getInt(10));
//                distanceList.add(distance);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return distanceList;
    }

    public ArrayList<DistanceV2> getAllDistance() {
        ArrayList<DistanceV2> getAllDistance = new ArrayList<>();
        String query = "Select * from Distance";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                getAllDistance.add(new DistanceV2(resultSet.getString(1), resultSet.getFloat(2), resultSet.getFloat(3)));
            }
        } catch (Exception e) {
        }
        return getAllDistance;
    }

    //tim 1 distance by ID
    public DistanceV2 getDistanceById(String Distance_ID) {
        String query = "Select * from Distance where Distance_ID = ?";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, Distance_ID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                DistanceV2 d = new DistanceV2(resultSet.getString(1), resultSet.getFloat(2), resultSet.getFloat(3));
                return d;
            }
        } catch (Exception e) {
        }
        return null;
    }

    //insert distance
    public void insert(DistanceV2 d) {
        String query = "INSERT [dbo].[Distance] ([Distance_ID], [Distance], [Price]) VALUES (?, ?, ?)";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, d.getDistanceID());
            statement.setFloat(2, d.getDistance());
            statement.setFloat(3, d.getPrice());

            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void update(DistanceV2 d) {
        String query = "UPDATE [dbo].[Distance]\n"
                + "   SET [Distance] = ? ,[Price] = ?\n"
                + " WHERE [Distance_ID] = ?";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            statement.setFloat(1, d.getDistance());
            statement.setFloat(2, d.getPrice());
            statement.setString(3, d.getDistanceID());

            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    //tim distanceID by flightId
    public String getDistanceID_ByFlightId(String flightId) {
        String distanceId = null;
        String query = "select Distance.Distance_ID\n"
                + "from Flight \n"
                + "inner join Distance\n"
                + "on Flight.Distance_ID = Distance.Distance_ID where Flight.Flight_ID = ?";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, flightId);
            resultSet = statement.executeQuery();
            distanceId = resultSet.getString(11);
        } catch (Exception e) {
        }
        return distanceId;
    }
    
    public static void main(String[] args) {
        Distance distance = new Distance();
        DistanceDAO distanceDAO = new DistanceDAO();
        List<Distance> distances = distanceDAO.getDistances("2023-05-25", "Đà Nẵng", "Hồ Chí Minh");
        for (Distance distance1 : distances) {
            System.out.println(distance1);
        }
    }
}