/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.customer;

import Model.Flight;
import Model.dao.FlightDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lookUpFlight extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ticketId = request.getParameter("ticketId");
        String passengerName = request.getParameter("passengerName");
        FlightDAO flightDAO = new FlightDAO();
        try {
            List<Flight> flights = flightDAO.lookUpFlight(ticketId, passengerName);
            request.setAttribute("Name", passengerName);
            request.setAttribute("lookUpFlight", flights);
            request.getRequestDispatcher("lookUpFlight.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lookUpFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
