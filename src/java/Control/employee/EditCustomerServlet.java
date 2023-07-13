/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.employee;

import Model.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class EditCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("id");
        UserDAO userD = new UserDAO();
        userD.invalidUser(userID);
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("id");
        String email = request.getParameter("email");
        String fullName = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        if (gender.equals("Male")) {
            gender = "M";
        } else gender = "F";
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String nation = request.getParameter("nation");
        String cccd = request.getParameter("cccd");
        UserDAO userD = new UserDAO();
        userD.updateCustomer(userID, email, fullName, gender, birthday, cccd, nation, phone, address);
        request.getRequestDispatcher("editCustomer.jsp?id=" + userID).forward(request, response);
    }

}
