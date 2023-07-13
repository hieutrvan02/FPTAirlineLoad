/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.admin;

import Model.Account;
import Model.dao.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

public class loginAdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        AccountDAO dao = new AccountDAO();
        ArrayList<Account> accountsAdmin = dao.getAccountAdmin(email, password);
        if (!accountsAdmin.isEmpty()) {
            String adminID = accountsAdmin.get(0).getAccID();
            HttpSession sessionAdmin = request.getSession();
            sessionAdmin.setAttribute("role", "admin");
            sessionAdmin.setAttribute("email", email);
            sessionAdmin.setAttribute("adminID", adminID);
            if (remember != null) {
                Cookie e = new Cookie("emailC", email);
                e.setMaxAge(60 * 15);
                Cookie p = new Cookie("passC", password);
                response.addCookie(e);
                p.setMaxAge(60 * 15);
            }
            response.sendRedirect("homepage.jsp");
        } else {
            request.setAttribute("mess", "Wrong username or password");
            request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
        }
    }

}
