/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.employee;

import Control.customer.BillServlet;
import Model.dao.OrderTicketDAO;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class OrderTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            HttpSession session = request.getSession();
//            int flightTypeSession = (int) session.getAttribute("FlightType");
//            if (flightTypeSession == 1) {
//                request.setAttribute("flightType", "Khứ hồi");
//            } else{
//                request.setAttribute("flightType", "Một chiều");
//            }
            OrderTicketDAO orderTicket = new OrderTicketDAO();
            request.setAttribute("orderTicket", orderTicket.readOrderTicket());
            request.getRequestDispatcher("orderTicket.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//        try {
//            OrderTicketDAO orderTicket = new OrderTicketDAO();
//            System.out.println(   orderTicket.readOrderTicket());
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(OrderTicketServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     
//    }
}
