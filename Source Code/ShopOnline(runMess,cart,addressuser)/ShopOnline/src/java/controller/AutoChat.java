/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.GroupDAO;
import dal.MessageDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Group;
import model.User;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AutoChat", urlPatterns = {"/autochat"})
public class AutoChat extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MessageDAO mdao = new MessageDAO();
        UserDAO udao = new UserDAO();
        GroupDAO gdao = new GroupDAO();
        List<String> listUserAdminID = udao.listUserAdminID();

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("userlogged");
        if (u != null) {
            String userID = String.valueOf(u.getUserid());
            mdao.addMessage(userID, "Bắt đầu");
            String maxMessID = mdao.getMaxMessIDb(userID);
            String groupID = gdao.getGroupIDbyUserID(userID);
            mdao.addRecipientMessage(groupID, maxMessID);
            response.sendRedirect("home");

        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO udao = new UserDAO();
        GroupDAO gdao = new GroupDAO();
        MessageDAO mdao = new MessageDAO();
        User u = (User) session.getAttribute("userlogged");

        String autochat = request.getParameter("autochat");
        List<String> listUserAdminID = udao.listUserAdminID();
        String maxMessID = "";
        String groupID = gdao.getGroupIDbyUserID(String.valueOf(u.getUserid()));
        if (autochat.equals("start")) {

            mdao.addMessage(listUserAdminID.get(0), "ShopDep xin chào quý khách, chúng tôi có thể giúp gì cho quý khách");
            maxMessID = mdao.getMaxMessIDb(listUserAdminID.get(0));
            mdao.addRecipientMessage(groupID, maxMessID);
            response.sendRedirect("home");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
