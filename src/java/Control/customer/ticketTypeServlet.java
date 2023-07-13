
package Control.customer;

import Model.TicketType;
import Model.dao.TicketTypeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class ticketTypeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        TicketTypeDAO ticketDao = new TicketTypeDAO();
        List<TicketType> ticketTypes = ticketDao.getTickets();
        request.setAttribute("listTicketType", ticketTypes);
        request.getRequestDispatcher("listTicketTypePrice.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

}

