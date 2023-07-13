package Control;

import Model.dao.TicketTypeDAO;
import Model.dao.DistanceDAO;
import Control.format.Format;
import Model.*;
import Model.dao.FlightDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchFlight", value = "/SearchFlight")
public class SearchFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Format format = new Format();

        String selectFlight = request.getParameter("flight");

        String sdeparture = request.getParameter("departure");
        String sdestination = request.getParameter("destination");
        String sstartDate = request.getParameter("startDate");
        String sendDate = request.getParameter("endDate");

        String sadult = request.getParameter("adult");
        String skid = request.getParameter("kid");
        String sbaby = request.getParameter("baby");

        HttpSession session = request.getSession();
        String userIDSession = (String) session.getAttribute("userID");
        String emailSession = (String) session.getAttribute("email");

        //Xóa session cũ khi gọi đến servlet
        session.invalidate();
        //Tạo session mới
        session = request.getSession(true);

        session.setAttribute("userID", userIDSession);
        session.setAttribute("email", emailSession);
        session.setAttribute("FlightType", selectFlight);
        session.setAttribute("Departure", sdeparture);
        session.setAttribute("Destination", sdestination);
        session.setAttribute("StartDate", format.formatDate(sstartDate));

        session.setAttribute("adult", sadult);
        session.setAttribute("kid", skid);
        session.setAttribute("baby", sbaby);

        FlightDAO flightDao = new FlightDAO();
        List<Flight> flightsOne = flightDao.getListFlight(sstartDate, sdeparture, sdestination);
        request.setAttribute("listFlightOne", flightsOne);
        if (sendDate != null) {
            session.setAttribute("EndDate", format.formatDate(sendDate));
            List<Flight> flightsRound = flightDao.getListFlight(sendDate, sdestination, sdeparture);
            request.setAttribute("listFlightRound", flightsRound);
        }

        TicketTypeDAO ticketDao = new TicketTypeDAO();
        List<TicketType> ticketTypes = ticketDao.getTickets();

        DistanceDAO distanceDAO = new DistanceDAO();
        List<Distance> distances = distanceDAO.getDistances(sstartDate, sdeparture, sdestination);
        if (distances != null) {
            for (TicketType ticketType : ticketTypes) {
                float tickPrice = Float.parseFloat(ticketType.getTicketPrice());
                float priceAdult = Float.parseFloat(sadult);
                float priceKid = Float.parseFloat(skid);
                float distancePrice = distances.get(0).getDistancePrice();
                float newPrice = tickPrice + distancePrice;
//            Tính Tổng tiền vé
                float sumAdult = Float.parseFloat("1.1") * priceAdult * newPrice;
                float sumKid = Float.parseFloat("1.1") * priceKid * newPrice;
//            Format tiền vé
                String Price = String.valueOf(newPrice);
                String PriceAdult = String.valueOf(sumAdult);
                String PriceKid = String.valueOf(sumKid);

                ticketType.setTicketPrice(format.formatPrice(Price));
                ticketType.setTicketSumAdult(format.formatPrice(PriceAdult));
                ticketType.setTicketSumKid(format.formatPrice(PriceKid));
            }
        }
        request.setAttribute("listTicket", ticketTypes);

        request.getRequestDispatcher("select-flights.jsp").forward(request, response);

    }

}