/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Control.format.Format;
import DBcontext.DB;
import Model.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class BillDAO {

    private Connection connection;
    Bill bill = new Bill();

    public BillDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Bill readBill(String userID) throws ClassNotFoundException {
        Format format = new Format();
        try {
            ResultSet resultSet;
            String statement = "SELECT SubQuery.*\n" +
"                                FROM (\n" +
"                                    SELECT OT.Order_ID, OT.TotalAmount, F.Departure, F.StartDate, F.StartTime, F.Destination, F.EndDate, F.EndTime, ROW_NUMBER() OVER (ORDER BY OT.date DESC) AS RowNum\n" +
"                                    FROM Users U\n" +
"                                    FULL OUTER JOIN OrderTicket OT ON U.UserID = OT.UserID\n" +
"                                    FULL OUTER JOIN Ticket T ON OT.Order_ID = T.Order_ID\n" +
"                                    FULL OUTER JOIN Flight F ON T.Flight_ID = F.Flight_ID\n" +
"                                    WHERE U.UserID = ?\n" +
"                                ) AS SubQuery\n" +
"                                WHERE SubQuery.RowNum = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bill.setOrderID(resultSet.getString(1));
                bill.setTotalAmount(resultSet.getString(2));
                bill.setDeparture(resultSet.getString(3));
                bill.setStartDate(resultSet.getDate(4));
                bill.setStartTime(format.formatTime(resultSet.getString(5)));
                bill.setDestination(resultSet.getString(6));
                bill.setEndDate(resultSet.getDate(7));
                bill.setEndTime(format.formatTime(resultSet.getString(8)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bill;
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
        BillDAO test = new BillDAO();
        try {
            test.readBill("221608");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
