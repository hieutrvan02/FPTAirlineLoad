/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.customer;

import Model.dao.AccountDAO;
import Model.Flight;
import Model.dao.FlightDAO;
import Model.dao.OrderDAO;
import Model.dao.PassengerDAO;
import Model.Promotion;
import Model.dao.PromotionDAO;
import Model.dao.TicketDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class orderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountDAO accdao = new AccountDAO();
        OrderDAO orderdao = new OrderDAO();
        TicketDAO ticketdao = new TicketDAO();
        PassengerDAO passdao = new PassengerDAO();
        PromotionDAO prodao = new PromotionDAO();

        String userID = (String) session.getAttribute("userID");
        int numAdult = Integer.parseInt((String) session.getAttribute("adult"));
        int numKid = Integer.parseInt((String) session.getAttribute("kid"));
        int numBaby = Integer.parseInt((String) session.getAttribute("baby"));
        String ticketType = (String) session.getAttribute("ticketType");
        String flightID = (String) session.getAttribute("flightId");
        String flightIDBack = (String) session.getAttribute("flightIdBack");
        String totalAmount = request.getParameter("totalAmountGo");
        int numTotalGo = prodao.convertStringToInt(totalAmount);
        String total = request.getParameter("total");
        String orderID = accdao.randomString();
        String promotionId = request.getParameter("promotions");
        Date currentDate = new Date();
        // Định dạng chuỗi mong muốn
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // Chuyển đổi thành chuỗi
        String currentDateTimeString = dateFormat.format(currentDate);
        try {
            if (total != null) {
                int numTotal = prodao.convertStringToInt(total);
                if (!promotionId.isBlank()) {
                    Promotion promotion = prodao.isPromotionValid(promotionId, currentDateTimeString);
                    if (promotion != null) {
                        int newTotal = numTotal - (int) promotion.getAmount();
                        orderdao.createOrder(orderID, userID, currentDateTimeString, promotionId, "1.1", prodao.convertIntToString(newTotal));
                    } else {
                        request.setAttribute("promotionInvalid", "Promotion is not valid");
                        request.getRequestDispatcher("detail_roundtrip.jsp").forward(request, response);
                        return;
                    }
                } else {
                    orderdao.createOrder(orderID, userID, currentDateTimeString, promotionId, "1.1", total);

                }
                for (int i = 1; i <= numAdult; i++) {
                    String luggageA = null;
                    String passengerID = accdao.randomString();
                    String passFullName = request.getParameter("nameAdult" + i);
                    String birthDay = request.getParameter("txtDateA" + i);
                    String ticketID = accdao.randomString();
                    String cccd = request.getParameter("cccd" + i);
                    String seat = ticketdao.createSeats(ticketType, flightIDBack);
                    luggageA = request.getParameter("luggageBackA" + i);
                    try {
                        ticketdao.createTicket(ticketID, orderID, flightIDBack, ticketType, luggageA, seat);
                        passdao.createPassengerCCCD(passengerID, ticketID, passFullName, birthDay, cccd);
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
                for (int i = 1; i <= numKid; i++) {
                    String luggageK = null;
                    String passengerID = accdao.randomString();
                    String passFullName = request.getParameter("nameKid" + i);
                    String birthDay = request.getParameter("txtDateK" + i);
                    String ticketID = accdao.randomString();
                    String seat = ticketdao.createSeats(ticketType, flightIDBack);
                    luggageK = request.getParameter("luggageBackK" + i);
                    try {
                        ticketdao.createTicket(ticketID, orderID, flightIDBack, ticketType, luggageK, seat);
                        passdao.createPassenger(passengerID, ticketID, passFullName, birthDay);
                    } catch (SQLException ex) {
                        Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                if (!promotionId.isBlank()) {
                    Promotion promotion = prodao.isPromotionValid(promotionId, currentDateTimeString);
                    if (promotion != null) {
                        int newTotal = numTotalGo - (int) promotion.getAmount();
                        orderdao.createOrder(orderID, userID, currentDateTimeString, promotionId, "1.1", prodao.convertIntToString(newTotal));
                    } else {
                        request.setAttribute("promotionInvalid", "Promotion is not valid");
                        request.getRequestDispatcher("detail_onetrip.jsp").forward(request, response);
                        return;
                    }
                } else {
                    orderdao.createOrder(orderID, userID, currentDateTimeString, promotionId, "1.1", totalAmount);
                }
                session.setAttribute("orderId", orderID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 1; i <= numAdult; i++) {
            String luggageA = null;
            String passengerID = accdao.randomString();
            String passFullName = request.getParameter("nameAdult" + i);
            String birthDay = request.getParameter("txtDateA" + i);
            String ticketID = accdao.randomString();
            String cccd = request.getParameter("cccd" + i);
            String seat = ticketdao.createSeats(ticketType, flightID);
            luggageA = request.getParameter("luggageGoA" + i);
            try {
                ticketdao.createTicket(ticketID, orderID, flightID, ticketType, luggageA, seat);
                passdao.createPassengerCCCD(passengerID, ticketID, passFullName, birthDay, cccd);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        for (int i = 1; i <= numKid; i++) {
            String luggageK = null;
            String passengerID = accdao.randomString();
            String passFullName = request.getParameter("nameKid" + i);
            String birthDay = request.getParameter("txtDateK" + i);
            String ticketID = accdao.randomString();
            String seat = ticketdao.createSeats(ticketType, flightID);
            luggageK = request.getParameter("luggageGoK" + i);
            try {
                ticketdao.createTicket(ticketID, orderID, flightID, ticketType, luggageK, seat);
                passdao.createPassenger(passengerID, ticketID, passFullName, birthDay);
            } catch (SQLException ex) {
                Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Trừ ghế trong chuyến bay
        FlightDAO flightDAO = new FlightDAO();
        int sumPassenger = numAdult + numKid;
        try {
            flightDAO.updateSeatFlight(sumPassenger, flightID, ticketType);
            if (flightIDBack != null) {
                flightDAO.updateSeatFlight(sumPassenger, flightIDBack, ticketType);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("verify.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
