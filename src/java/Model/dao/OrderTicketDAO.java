/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import DBcontext.DB;
import Model.OrderTicket;
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
 * @author Lenovo
 */
public class OrderTicketDAO {

    private Connection connection;
    OrderTicket orderTicket = new OrderTicket();

    public OrderTicketDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<OrderTicket> readOrderTicket() throws ClassNotFoundException {
        List<OrderTicket> orderTickets = new ArrayList<>();
        try {
            ResultSet resultSet;
            String statement = "SELECT * FROM OrderTicket  ";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderTicket orderTicket = new OrderTicket();
                orderTicket.setOrderID(resultSet.getString(1));
                orderTicket.setUserID(resultSet.getString(2));
                orderTicket.setDate(resultSet.getDate(3));
                orderTicket.setPromotionID(resultSet.getString(4));
                orderTicket.setTax(resultSet.getFloat(5));
                orderTicket.setTotalAmount(resultSet.getString(6));
                orderTicket.setIsConfirmed(resultSet.getString(7));
                orderTickets.add(orderTicket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderTickets;
    }

    public void confirm(String orderTicketID) throws ClassNotFoundException {

        try {
            String statement = "UPDATE OrderTicket\n" +
"                               SET [IsConfirmed] = 'true'\n" +
"                               WHERE Order_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, orderTicketID);
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOrderTicekt(String orderTicketID) throws SQLException {

        String stmt = "DELETE FROM OrderTicket\n" +
"                      WHERE Order_ID=?";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, orderTicketID);
        ps.executeUpdate();
    }
//    public void updateInformation(String userIDPara, String namePara, String birthdayPara, String cccdPara, String nationalityPara, String phonePara, String addressPara) {
//        try {
//            String statement = "UPDATE Users SET Name=?,Birthday=?,CCCD=?,Nationality=?,Phone=?,Address=? WHERE UserID=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(statement);
//            preparedStatement.setString(1, namePara);
//            preparedStatement.setDate(2, java.sql.Date.valueOf(birthdayPara));
//            preparedStatement.setString(3, cccdPara);
//            preparedStatement.setString(4, nationalityPara);
//            preparedStatement.setString(5, phonePara);
//            preparedStatement.setString(6, addressPara);
//            preparedStatement.setString(7, userIDPara);
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(InformationDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void updatePassword(String userIDPara, String passwordPara) {
//        try {
//            String statement = "UPDATE Users SET Password=? "
//                    + "WHERE UserID=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(statement);
//            preparedStatement.setString(1, passwordPara);
//            preparedStatement.setString(2, userIDPara);
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(InformationDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
