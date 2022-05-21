package controller;

import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

public class ConfirmEmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("confirm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        UserDAO udb = new UserDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userlogged");

        if (code.equals(user.getCode())) {
            udb.updateCf(user, "1");
            user.setStatus(1);
            session.setAttribute("userlogged", user);
            response.sendRedirect("HomeController");
        } else {
            response.sendRedirect("confirm");
        }
    }
}
