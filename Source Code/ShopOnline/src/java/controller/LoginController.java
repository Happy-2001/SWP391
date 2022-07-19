package controller;

import dal.RoleDAO;
import dal.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
            int b = u.getUserid();
            if (remember != null) {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);
                Cookie r_pass = new Cookie("remember", remember);
                c_user.setMaxAge(3600 * 24 * 30);
                c_pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(c_pass);
                response.addCookie(c_user);
                response.addCookie(r_pass);
            }
            
            //phan nay da chay k can fix lai
            RoleDAO roledb = new RoleDAO();
            UserDAO udao = new UserDAO();
            User ur = udao.getUserRole(username);
            
            HttpSession session = request.getSession();

            ArrayList<Role> getRoleList = roledb.getRoleList();
            ArrayList<Role> listRole = roledb.getRoleUser(String.valueOf(u.getUserid()));
            
            for (Role role : getRoleList) {                                   // xác nhận Admin có roleid là bao nhiêu 
                if(role.getNameRole().equalsIgnoreCase("Admin")){
                    session.setAttribute("roleadmin", role.getId());
                    response.getWriter().print(role.getId());
                    break;
                }
            }
            for (Role role : listRole) {
                session.setAttribute("role", role.getId());
                if (!role.getNameRole().equals("User")) {                   //get hightest role user(Admin,Customer,User)desc
                    break;
                }

            }
            
            session.setAttribute("userid",u.getUserid());
            System.out.println(u.getUserid());
            session.setAttribute("userlogged", u);
            session.setAttribute("Arole", ur);
            session.setAttribute("namez", b);
            response.sendRedirect("home");
           
                  
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
