package controller;

import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();
        User u = userDAO.getUser(email, password);
        HttpSession session = request.getSession();
        if (u == null) {
            //show error
            request.setAttribute("ms1", "Check your account!");
           request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            
            session.setAttribute("userlogged", u);
            response.sendRedirect("home");
          
        }
    }
}
