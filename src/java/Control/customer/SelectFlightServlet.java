/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.customer;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class SelectFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String ticketType = request.getParameter("ticketType");
        session.setAttribute("ticketType", ticketType);
        String flightType = (String) session.getAttribute("FlightType");
        String idGo = request.getParameter("flightId");
        String ticketTypePriceGo = request.getParameter("typePriceA" + idGo);
        ticketTypePriceGo = ticketTypePriceGo.substring(0, 9);
        String ticketTotalAGo = request.getParameter("totalPriceA" + idGo);
        String numKid = (String) session.getAttribute("kid");
        if (numKid != null) {
            String ticketTotalKGo = request.getParameter("totalPriceK" + idGo);
            session.setAttribute("ticketTotalKGo", ticketTotalKGo);
        }
        session.setAttribute("ticketTypePrice", ticketTypePriceGo);
        session.setAttribute("ticketTotalAGo", ticketTotalAGo);
        session.setAttribute("flightId", idGo);
        if (flightType.equals("1")) {
            String idBack = request.getParameter("flightIdRound");
            String ticketTypePriceBack = request.getParameter("typePriceA" + idBack);
            ticketTypePriceBack = ticketTypePriceBack.substring(0, 9);
            String ticketTotalABack = request.getParameter("totalPriceA" + idBack);
            session.setAttribute("ticketTypePriceBack", ticketTypePriceBack);
            session.setAttribute("ticketTotalABack", ticketTotalABack);
            session.setAttribute("flightIdBack", idBack);
            if (numKid != null) {
                String ticketTotalKBack = request.getParameter("totalPriceK" + idBack);
                session.setAttribute("ticketTotalKBack", ticketTotalKBack);
            }
            request.getRequestDispatcher("detail_roundtrip.jsp").forward(request, response);
        } else if (flightType.equals("2")) {
            request.getRequestDispatcher("detail_onetrip.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
