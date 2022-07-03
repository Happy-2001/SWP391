/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AddressDAO;
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
        Object objUser = session.getAttribute("userlogged");
        String userID = "";
        if (objUser == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            User user = (User) objUser;

            UserDAO udao = new UserDAO();
            GroupDAO gdao = new GroupDAO();
            RoleDAO rdao = new RoleDAO();
            AddressDAO adao = new AddressDAO();
            
            List<String> listAdminID = udao.listUserAdminID();
            List<String> listUserAdminID = udao.listUserAdminID();
            ArrayList<GroupChat> listGroupChat = gdao.getGroupChat();
            String groupID = "";
            String mrID = request.getParameter("mrID");
            if (mrID == null) {
                mrID = listGroupChat.get(0).getId();
            }
            for (GroupChat groupChat : listGroupChat) {
                if (groupChat.getId().equals(mrID)) {
                    groupID = groupChat.getGroupID();
                }
                User creator = udao.getUserByMessageID(groupChat.getMessageID());
                if (listAdminID.contains(String.valueOf(creator.getUserid())) && creator.getUserid() != user.getUserid()) {
                    groupChat.setCreatorMessage(creator.getLastname() + ": ");
                }
                if (!listAdminID.contains(String.valueOf(creator.getUserid()))) {
                    groupChat.setCreatorMessage("");
                }
                if (creator.getUserid() == user.getUserid()) {
                    groupChat.setCreatorMessage("You: ");
                }
                if(groupChat.getContent().length() > 15){
                    String newContent = groupChat.getContent().substring(0, 15)+"...";
                    groupChat.setContent(newContent);
                }
                
               
                groupChat.setCustomerID(gdao.getCustomerIDbyGroupID(groupChat.getGroupID()));  /// truyền id khách hàng trong group chat
//                response.getWriter().println(groupChat.getGroupID() + " || "+ groupChat.getCustomerID());
                 groupChat.setEaID(adao.getEaIDbyUserID(groupChat.getCustomerID()));
//                                 response.getWriter().println(groupChat.getEaID() + " || "+ groupChat.getCustomerID());
                groupChat.setCreatorIDMessage(groupChat.getMessageID());
            }

            request.setAttribute("listGroupChat", listGroupChat);
            request.setAttribute("listUserAdminID", listUserAdminID);
            request.setAttribute("mrID", mrID);
            ArrayList<Message> listMessage = mdao.getAllMessageofUser(groupID, String.valueOf(user.getUserid()));
            request.setAttribute("listMess", listMessage);
            for (GroupChat m : listGroupChat) {
                response.getWriter().println(m.getCreatorMessage() + " 9");
            }
            request.getRequestDispatcher("admin/message.jsp").forward(request, response);
        }
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
            String parentMessageID = request.getParameter("parentMessageID");
            response.getWriter().print(parentMessageID);
            if(parentMessageID.equals("")){
                mdao.addMessage(fromid, content);
            }else{
                mdao.addMessageWithParent(fromid, content, parentMessageID);
            }
//            response.getWriter().print(fromid+"||"+toid+"||"+content+"|"+parentMessageID.equals(""));

            String maxMessID = mdao.getMaxMessIDb();
            mdao.addRecipientMessage(toid, maxMessID);
            
            if (getFROMandTOsplit.length == 4) {                 // check chuyển hướng sang message.jsp
                response.sendRedirect("message?mrID=" + getFROMandTOsplit[2]);
            } else {
                response.sendRedirect("home");

            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

    }

}
