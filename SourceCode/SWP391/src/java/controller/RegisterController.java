package controller;

import dal.UserDAO;
import emailverify.SendEmail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

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
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        UserDAO udao = new UserDAO();
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setFullname(fullname);
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
