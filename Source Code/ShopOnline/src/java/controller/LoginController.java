package controller;

import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
<<<<<<< HEAD

        
        if (u != null) { // login successfully!
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("email", email);
                Cookie c_pass = new Cookie("password", password);
                c_user.setMaxAge(3600 * 24 * 30);
                c_pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(c_pass);
                response.addCookie(c_user);
            }
            
            HttpSession session = request.getSession();
       
=======
        HttpSession session = request.getSession();
>>>>>>> 7833b43e0f75183d417907403d9b702c273fb9aa
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
}
