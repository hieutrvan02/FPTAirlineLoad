package Control.admin;

import Control.UpdatePasswordServlet;
import Model.dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO user = new UserDAO();
            request.setAttribute("emails", user.readEmails());
            request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdatePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String emailPara = request.getParameter("emailPara");
            String passwordPara = request.getParameter("passwordPara");
            UserDAO employee = new UserDAO();
            employee.createEmployee(emailPara, passwordPara);
            response.sendRedirect("EmployeeManagementServlet");
        } catch (SQLException ex) {
            Logger.getLogger(CreateEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        try {
            UserDAO user = new UserDAO();
            
            System.out.println( user.readEmails());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
