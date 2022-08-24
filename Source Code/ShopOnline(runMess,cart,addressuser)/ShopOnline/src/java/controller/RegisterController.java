/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AddressDAO;
import dal.ElectronicAddressDAO;
import dal.UserDAO;
import emailverify.SendEmail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ElectronicAddress;
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
        String password_confirmation = request.getParameter("password_confirmation");
        String gender = request.getParameter("gender");

        ElectronicAddressDAO eaDAO = new ElectronicAddressDAO();
        UserDAO udao = new UserDAO();
        AddressDAO addao = new AddressDAO();
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

        ElectronicAddress e = new ElectronicAddress();
        e.setEmail(email);
        e.setTelephone(phone);
        List<User> users = udao.listUser();
//        response.getWriter().println("Full: "+u.getFullname());
//        response.getWriter().println("gender: "+u.getGender());
//        response.getWriter().println("un: "+u.getUsername());
//        response.getWriter().println("pw: "+u.getPassword());
//        response.getWriter().println("rpw: "+password_confirmation);
//        response.getWriter().println("phone: "+e.getTelephone());
//        response.getWriter().println("email: "+e.getEmail());
//        
            if(u.getGender() == 1){
                request.setAttribute("gender1", "checked");
            }else{
                request.setAttribute("gender0", "checked");
            }
        if (username == null || firstname == null || middlename == null || lastname == null || phone == null || email == null || password == null || password_confirmation == null) {
           // khi return register sẽ kèm theo data cũ
            
            request.setAttribute("username", u.getUsername());
            request.setAttribute("password", u.getPassword());
            request.setAttribute("firstname", u.getFirstname());
            request.setAttribute("middlename", u.getMiddlename());
            request.setAttribute("lastname", u.getLastname());
            
            request.setAttribute("email", u.getEmail());
            request.setAttribute("phone", u.getPhone());
            request.setAttribute("password_confirmation", password_confirmation);

            request.setAttribute("ms2", "No blank");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        if (!udao.existedMember(u, users)) {
            //ton tai tai khoan
            request.setAttribute("username", u.getUsername());
            request.setAttribute("password", u.getPassword());
            request.setAttribute("firstname", u.getFirstname());
            request.setAttribute("middlename", u.getMiddlename());
            request.setAttribute("lastname", u.getLastname());
           
            request.setAttribute("email", u.getEmail());
            request.setAttribute("phone", u.getPhone());
            request.setAttribute("password_confirmation", password_confirmation);

            request.setAttribute("ms2", "Existed account!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            
            udao.insert(u);
            eaDAO.insert(e);
            String userID = udao.getUserByUserName(username);
            String NeweaID = eaDAO.getEaIDbyEmail(email);
            addao.insertUserAddress(String.valueOf(userID), firstname+" "+middlename+" "+lastname, NeweaID);
            
            HttpSession session = request.getSession();
            session.setAttribute("userlogged", u);
            response.sendRedirect("login");
        }
    }

}
