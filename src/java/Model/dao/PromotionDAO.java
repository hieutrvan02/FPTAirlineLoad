package Model.dao;

import DBcontext.DB;
import Model.Promotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromotionDAO {

    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private ArrayList<Promotion> promotions = new ArrayList<>();

    public PromotionDAO() {
        try {
            connection = DB.makeConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Promotion> getPromotion() {
        ArrayList<Promotion> list = new ArrayList<>();
        String query = "SELECT * FROM Promotion";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String promotionID = rs.getString("Promotion_ID");
                String description = rs.getString("Description");
                Date startDate = rs.getDate("StartDate");
                Date endDate = rs.getDate("EndDate");
                float amount = rs.getFloat("Amount");

                list.add(new Promotion(promotionID, description, startDate, endDate, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void createPromotion(String id, String description, String startDay, String endDay, float price) throws SQLException {
        String stmt = "insert into Promotion values (?, ?, ?, ?, ? )";
        PreparedStatement ps = connection.prepareStatement(stmt);
        ps.setString(1, id);
        ps.setNString(2, description);
        ps.setString(3, startDay);
        ps.setString(4, endDay);
        ps.setFloat(5, price);
        ps.executeUpdate();
    }

    public LocalDate convertStringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newDate = LocalDate.parse(date, formatter);
        return newDate;
    }

    public Promotion isPromotionValid(String promotionId, String today) {
        today = today.substring(0, 10).trim();
        List<Promotion> pr = getPromotion();
        String[] arrTD = today.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrTD.length; i++) {
            sb.append(arrTD[i]);
            if (i < arrTD.length - 1) {
                sb.append("-");
            }
        }
        String today1 = sb.toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newToday = new Date();
        try {
            newToday = dateFormat.parse(today1);
        } catch (ParseException ex) {
            Logger.getLogger(PromotionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Promotion promotion : pr) {
            if (promotion.getId().equals(promotionId)) {
                Date startDate = promotion.getStartDate();
                Date endDate = promotion.getEndDate();
                if (startDate.before(endDate) || endDate.equals(newToday)) {
                    if (newToday.before(endDate) || newToday.equals(endDate)) {
                        return promotion;
                    }
                }
            }
        }
        return null;
    }

    public int convertStringToInt(String total) {
        String numericTotal = total.replaceAll("[^0-9]", "");
        int numTotal = Integer.parseInt(numericTotal);
        return numTotal;
    }

    public int convertFloatToInt(String total) {
        String numericTotal = total.substring(0, total.length() - 2);
        int numTotal = Integer.parseInt(numericTotal);
        return numTotal;
    }

    public String convertIntToString(int total) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        String result = format.format(total) + " VND";
        return result;
    }

    public static void main(String[] args) {
        PromotionDAO p = new PromotionDAO();
        for (Promotion ps : p.getPromotion()) {
            System.out.println(ps);
        }
    }
}
