package controller;

import dal.UserDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class SearchUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("search");
        String authorityid = request.getParameter("authorityid");
        UserDAO udb = new UserDAO();
        List<User> users = udb.searchUserByName(name, authorityid);
        request.setAttribute("search", name);
        request.setAttribute("users", users);
        request.getRequestDispatcher("listuser.jsp").forward(request, response);
    }
}
