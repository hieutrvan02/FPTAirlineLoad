package Control.admin;

import Model.dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            UserDAO employee = new UserDAO();
            employee.deleteEmployee(id);
            response.sendRedirect("EmployeeManagementServlet");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
