package Model.dao;

import DBcontext.DB;
import Control.format.Format;
import Model.TicketType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketTypeDAO {

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    List<TicketType> tickets;

    public List<TicketType> getTickets() {
        tickets = new ArrayList<>();
        Format format = new Format();
        String query = "SELECT TicketType.TicketType_ID,TicketType_Name, Unit_Price\n"
                + "FROM TicketType\n"
                + "INNER JOIN Price\n"
                + "ON TicketType.TicketType_ID = Price.TicketType_ID;";
        try {
            connection = DB.makeConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TicketType ticket = new TicketType(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                tickets.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public void updateTicketTypePrice(String id, String price) throws ClassNotFoundException {
        try {
            String statement = "UPDATE Price SET Unit_Price = ? WHERE TicketType_ID = ?";
            connection = DB.makeConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, price);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
