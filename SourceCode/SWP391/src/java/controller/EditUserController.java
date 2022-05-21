package controller;

import dal.StatusDAO;
import dal.UserDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Status;
import model.User;

public class EditUserController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userid = request.getParameter("userid");
        UserDAO udb = new UserDAO();
        User u = udb.getUserById(userid);
        
        StatusDAO sdb = new StatusDAO();
        List<Status> statuses = sdb.listStatus();
        
        request.setAttribute("statuses", statuses);
        request.setAttribute("userid", userid);
        request.setAttribute("user", u);
        request.getRequestDispatcher("edituser.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String status = request.getParameter("status");
        String userid = request.getParameter("userid");
        UserDAO udb = new UserDAO();
        User u = udb.getUserById(userid);
        
        u.setStatus(Integer.parseInt(status));
        u.setFullname(fullname);
        u.setPhone(phone);
        u.setGender(Integer.parseInt(gender));
        udb.update(u);
        response.sendRedirect("ListUserController");
        
    }
}
