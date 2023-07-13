package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DBcontext.DB;
import Model.Account;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    public ArrayList<User> result = new ArrayList<>();

    private User users = new User();
    private Connection connection;

    public UserDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User readUser(String userID) throws ClassNotFoundException {
        try {
            ResultSet resultSet;
            String statement = "SELECT * FROM Users WHERE Users.UserID = ? and isValid = 'true'";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.setUserID(resultSet.getString(1));
                users.setEmail(resultSet.getString(2));
                users.setPassword(resultSet.getString(3));
                users.setName(resultSet.getString(4));
                users.setGender(resultSet.getString(5));
                users.setBirthday(resultSet.getDate(6));
                users.setPhone(resultSet.getString(7));
                users.setAddress(resultSet.getString(8));
                users.setNationality(resultSet.getString(9));
                users.setCccd(resultSet.getString(10));
                users.setRole(resultSet.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public void updateUser(String userIDPara, String namePara, String birthdayPara, String cccdPara, String nationalityPara, String phonePara, String addressPara) {
        try {
            String statement = "UPDATE Users SET Name=?,Birthday=?,CCCD=?,Nationality=?,Phone=?,Address=? WHERE UserID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, namePara);
            preparedStatement.setDate(2, java.sql.Date.valueOf(birthdayPara));
            preparedStatement.setString(3, cccdPara);
            preparedStatement.setString(4, nationalityPara);
            preparedStatement.setString(5, phonePara);
            preparedStatement.setString(6, addressPara);
            preparedStatement.setString(7, userIDPara);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCustomer(String userIDPara, String email, String namePara, String gender, String birthdayPara, String cccdPara, String nationalityPara, String phonePara, String addressPara) {
        try {
            String statement = "UPDATE Users SET Email=?, Name=?, Gender=?, Birthday=?,CCCD=?,Nationality=?,Phone=?,Address=? WHERE UserID=? and isValid = 'true'";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, namePara);
            preparedStatement.setString(3, gender);
            preparedStatement.setDate(4, java.sql.Date.valueOf(birthdayPara));
            preparedStatement.setString(5, cccdPara);
            preparedStatement.setString(6, nationalityPara);
            preparedStatement.setString(7, phonePara);
            preparedStatement.setString(8, addressPara);
            preparedStatement.setString(9, userIDPara);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePassword(String userIDPara, String passwordPara) {
        try {
            String statement = "UPDATE Users SET Password=? "
                    + "WHERE UserID=? and isValid = 'true'";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, passwordPara);
            preparedStatement.setString(2, userIDPara);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> readEmployee() throws ClassNotFoundException {
        List<User> employees = new ArrayList<>();
        try {
            ResultSet resultSet;
            String statement = "SELECT * FROM Users WHERE Role='employee' and isValid = 'true'";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User employee = new User();
                employee.setUserID(resultSet.getString(1));
                employee.setEmail(resultSet.getString(2));
                employee.setPassword(resultSet.getString(3));
                employee.setName(resultSet.getString(4));
                employee.setGender(resultSet.getString(5));
                employee.setBirthday(resultSet.getDate(6));
                employee.setPhone(resultSet.getString(7));
                employee.setAddress(resultSet.getString(8));
                employee.setNationality(resultSet.getString(9));
                employee.setCccd(resultSet.getString(10));
                employee.setRole(resultSet.getString(11));
                employees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    public List<String> readEmails() throws ClassNotFoundException {
        List<String> emails = new ArrayList<>();
        try {
            ResultSet resultSet;
            String statement = "SELECT Users.Email FROM Users where isValid = 'true'";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString(1);
                emails.add(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emails;
    }

    public void createEmployee(String email, String password) throws SQLException {
        String id = randomString();
        String stmt = "INSERT INTO Users VALUES" + " (?,?,?,'','','','','','','',?, 'true')";

        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, id);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setNString(4, "employee");
        ps.executeUpdate();
    }

    public void deleteEmployee(String id) throws SQLException {

        String stmt = "DELETE FROM Users\n"
                + "                      WHERE UserID=?";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, id);
        ps.executeUpdate();
    }

    public void invalidUser(String id) {
        try {
            String statement = "UPDATE Users SET isValid = 'false' "
                    + "WHERE UserID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public ArrayList<User> getAccount(String email, String pass) {
//        String query = "select UserID, Email, PassWord , Role\n"
//                + "from Users\n"
//                + "where Email = ? and PassWord = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, email);
//            ps.setString(2, pass);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                result.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//            }
//        } catch (Exception e) {
//        }
//        return result;
//    }
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

    public void createCustomer(String email, String password, String role, String fullName) throws SQLException {
        String id = randomString();
        String stmt = "insert into Users values" + " (?,?,?,?,'','','','','','',?,'true')";

        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, id);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setNString(4, fullName);
        ps.setString(5, role);
        ps.executeUpdate();
    }

    public ArrayList<User> getCustomer() throws SQLException {
        ArrayList<User> customers = new ArrayList<>();
        String query = "select UserID, Email, Name, Gender, Birthday, Phone, Address, Nationality, CCCD \n"
                + "from Users where Role = 'cus' and isValid = 'true'\n"
                + "order by UserID";

        PreparedStatement ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            customers.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getDate(5), rs.getString(1), rs.getString(6),
                    rs.getString(7), rs.getString(8)));
        }
        return customers;
    }

    public ArrayList<User> getCustomerByPage(String page) throws SQLException {
        ArrayList<User> custs = new ArrayList<>();
        String query = "select UserID, Email, Name, Gender, Birthday, Phone, Address, Nationality, CCCD \n"
                + "from Users where Role = 'cus' and isValid = 'true'\n"
                + "order by UserID\n"
                + "offset ? rows fetch next 5 rows only";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, (Integer.parseInt(page) - 1) * 5);
        rs = ps.executeQuery();
        while (rs.next()) {
            custs.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getDate(5), rs.getString(1), rs.getString(6),
                    rs.getString(7), rs.getString(8)));
        }
        return custs;
    }

    public int getMaxPage(int pageSize, int Listsize) {
        try {
            int size = Listsize / pageSize;
            if (Listsize % pageSize != 0) {
                size++;
            }
            if (size == 0) {
                return 1;
            }
            return size;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}
