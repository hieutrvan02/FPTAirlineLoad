/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import DBcontext.DB;
import Model.Account;

/**
 *
 * @author admin
 */
public class AccountDAO {

    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public ArrayList<Account> result = new ArrayList<>();

    public AccountDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Account> getAccount(String email, String pass) {
        String query = "select UserID, Email, PassWord , Role\n"
                + "from Users\n"
                + "where Email = ? and PassWord = ? and isValid = 'true'";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return result;
    }

    public String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        System.out.println(generatedString);
        return generatedString;
    }

    public Account checkExist(String email) {
        ResultSet resultSet;
        String q = "select * from Users\n"
                + "where [Email] = ? and isValid = 'true'\n";
        try {
            PreparedStatement statement = connection.prepareStatement(q);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new Account(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Account> getAccountAdmin(String email, String pass) {
        String query = "select UserID, Email, PassWord , Role from Users "
                + "where Email = ? and PassWord = ? and Role = 'admin' and isValid = 'true'";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return result;
    }

    public ArrayList<Account> getAccountEmployee(String email, String pass) {
        String query = "select UserID, Email, PassWord , Role from Users "
                + "where Email = ? and PassWord = ? and Role = 'employee' and isValid = 'true'";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return result;
    }
}
