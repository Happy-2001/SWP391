/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.GroupDAO;
import dal.MessageDAO;
import dal.RoleDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Group;
import model.GroupChat;
import model.Message;
import model.User;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "MessageController", urlPatterns = {"/message"})
public class MessageController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        MessageDAO mdao = new MessageDAO();
        HttpSession session = request.getSession();
        UserDAO udao = new UserDAO();
        GroupDAO gdao = new GroupDAO();
        List<String> listUserAdminID = udao.listUserAdminID();
        ArrayList<GroupChat> listGroupChat = gdao.getGroupChat();
        
        request.setAttribute("listGroupChat", listGroupChat);
        request.setAttribute("listUserAdminID", listUserAdminID);

        ArrayList<Message> listMessage = mdao.getAllMessageofUser("1", "1");
        request.setAttribute("listMess", listMessage);
        for (Message message : listMessage) {
            response.getWriter().print(message.getContent());
        }
        request.getRequestDispatcher("admin/Dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        String content = new
        MessageDAO mdao = new MessageDAO();
        GroupDAO gdao = new GroupDAO();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("userlogged");
        if (u != null) {

            String getFROMandTO = request.getParameter("getFROMandTO");
            String content = request.getParameter("contentsend");
            String[] getFROMandTOsplit = getFROMandTO.split(";"); //to;from get from value BUTTON
            String toid = getFROMandTOsplit[1];
            String fromid = getFROMandTOsplit[0];

            mdao.addMessage(fromid, content);

            String maxMessID = mdao.getMaxMessIDb();
            mdao.addRecipientMessage(toid, maxMessID);

//            response.sendRedirect("HomeController");
        response.sendRedirect("home");
        
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

    }

   

}
