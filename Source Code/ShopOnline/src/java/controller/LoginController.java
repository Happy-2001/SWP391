package controller;

import dal.MessengerDAO;
import dal.RoleDAO;
import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Message;
import model.Role;
import model.User;

public class LoginController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserDAO userDAO = new UserDAO();
        User u = null;
        if(username.contains("@")){
             u = userDAO.getUser(username, password);
        }else{
             u = userDAO.getUserbyUserName(username, password);
        }
        
        if (u != null) { // login successfully!
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);
                c_user.setMaxAge(3600 * 24 * 30);
                c_pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(c_pass);
                response.addCookie(c_user);
            }
            
            RoleDAO roledb = new RoleDAO();
            User ur = roledb.getUserRole(username);
            
            HttpSession session = request.getSession();
            session.setAttribute("userlogged", u);
            session.setAttribute("role", ur);
            request.getRequestDispatcher("home").forward(request, response);
             
        } else { //login fail
            request.setAttribute("ms1", "Check your account!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
