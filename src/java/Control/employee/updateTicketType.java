

package Control.employee;

import Model.dao.TicketTypeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class updateTicketType extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String S_id= request.getParameter("id");
        String S_type = request.getParameter("type");
        session.setAttribute("sId", S_id);
        
        request.setAttribute("id", S_id);
        request.setAttribute("type", S_type);
        request.getRequestDispatcher("updateTicketType.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("sId");
        String sPrice = request.getParameter("price");
        TicketTypeDAO ticketTypeDAO = new TicketTypeDAO();
        try {
            ticketTypeDAO.updateTicketTypePrice(id, sPrice);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateTicketType.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("ticketTypeServlet");
    }

}
