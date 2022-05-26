/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import emailverify.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        UserDAO udao = new UserDAO();
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setFirstname(firstname);
        u.setMiddlename(middlename);
        u.setLastname(lastname);
        u.setGender(Integer.parseInt(gender));
        u.setPhone(phone);
        u.setEmail(email);
        u.setStatus(2);
        SendEmail se = new SendEmail();
        u.setCode(se.getRandom());

        List<User> users = udao.listUser();

        if (!udao.existedMember(u, users)) {
            //ton tai tai khoan
            request.setAttribute("ms2", "Existed account!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            udao.insert(u);
            String subject = "ShopNamDat Email Verification";
            String message = "Registered successfully.Please verify your account using this code: " + u.getCode();
            boolean test = se.sendEmail(u, subject, message);
            if (test) {
                System.out.println("Send OK");
            } else {
                System.out.println("Send Faild");
            }
            HttpSession session = request.getSession();
            session.setAttribute("userlogged", u);
            response.sendRedirect("listproduct");
        }
    }

}
