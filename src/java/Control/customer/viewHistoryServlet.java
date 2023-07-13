package Control.customer;

import Model.Order;
import Model.dao.OrderDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class viewHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userIDSession = (String) session.getAttribute("userID");

        OrderDAO orderDAO = new OrderDAO();
        try {
            List<Order> orders = orderDAO.getListOrder(userIDSession);
            request.setAttribute("listOrder", orders);
            request.getRequestDispatcher("viewHistory.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(viewHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
