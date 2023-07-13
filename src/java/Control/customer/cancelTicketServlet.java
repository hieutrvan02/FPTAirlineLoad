/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.customer;

import Control.email.SendEmail;
import Model.dao.TicketDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ADMIN
 */
public class cancelTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailUser = (String) session.getAttribute("email");
        SendEmail email = new SendEmail();
        String ticketID = request.getParameter("ticketId");
        TicketDAO ticketDAO = new TicketDAO();
        try {
            ticketDAO.addSeat(ticketID);
            ticketDAO.cancelTicket(ticketID);
            email.sendEmailCancel(emailUser);
            response.sendRedirect("cancelTicket.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(cancelTicketServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
