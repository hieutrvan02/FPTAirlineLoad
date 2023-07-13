
package Control.customer;

import Model.dao.PromotionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class promotionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startDateString = request.getParameter("startDay");
        LocalDate startDay = LocalDate.parse(startDateString);
        String startDayString = startDay.toString();

        String endDateString = request.getParameter("endDay");
        LocalDate endDay = LocalDate.parse(endDateString);
        String endDayString = endDay.toString();
        
        String promotionID = request.getParameter("promotionID");
        String price = request.getParameter("price");
        float Float_price = Float.parseFloat(price);
        String description = request.getParameter("description");
        
        PromotionDAO promotionDAO = new PromotionDAO();
        try {
            promotionDAO.createPromotion(promotionID, description, startDayString, endDayString, Float_price);
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(promotionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
