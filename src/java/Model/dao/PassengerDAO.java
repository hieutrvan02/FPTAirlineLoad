/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import DBcontext.DB;
import Model.Passenger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class PassengerDAO {
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    Connection connection;

    public PassengerDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void createPassengerCCCD(String passengerID, String ticketID, String passName, String birthday, String cccd) throws SQLException {
        String stmt = "insert into Passenger (Passenger_ID,Ticket_ID,Passenger_Name,Birthday, CCCD)\n"
                + "values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, passengerID);
        ps.setString(2, ticketID);
        ps.setString(3, passName);
        ps.setString(4, birthday);
        ps.setString(5, cccd);
        ps.executeUpdate();
    }
    public void createPassenger(String passengerID, String ticketID, String passName, String birthday) throws SQLException {
        String stmt = "insert into Passenger (Passenger_ID,Ticket_ID,Passenger_Name,Birthday, CCCD)\n"
                + "values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, passengerID);
        ps.setString(2, ticketID);
        ps.setString(3, passName);
        ps.setString(4, birthday);
        ps.setNull(5, java.sql.Types.INTEGER);
        ps.executeUpdate();
    }
}
