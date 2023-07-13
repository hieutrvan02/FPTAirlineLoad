package Control.employee;

import Model.dao.OrderTicketDAO;
import Control.email.SendTicket;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfirmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            String orderTicketID = request.getParameter("orderTicketID");
            OrderTicketDAO orderTicket = new OrderTicketDAO();
            orderTicket.confirm(orderTicketID);
            SendTicket s = new SendTicket();
//            s.sendTicket(email);
            response.sendRedirect("OrderTicketServlet");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
