/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import dal.GroupDAO;
import dal.MessengerDAO;
import dal.ProductDAO;
import dal.SlideDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Blog;
import model.Message;
import model.Product;
import model.Slide;
import model.User;

/**
 *
 * @author nguye
 */
public class Homecontroller extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        }
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
        ProductDAO pdb = new ProductDAO();
        BlogDAO bdb = new BlogDAO();
        SlideDAO slideDAO = new SlideDAO();
        MessengerDAO mdao = new MessengerDAO();
        HttpSession session = request.getSession();
        UserDAO udao = new UserDAO();
        GroupDAO gdao = new GroupDAO();

        List<Blog> blogs = bdb.getBlogForHomePage();
        List<Slide> slides = slideDAO.listSlide();
        List<Product> products = pdb.listTop(4);
        List<Product> newproducts = pdb.listTopNew(4);

        request.setAttribute("blogs", blogs);
        request.setAttribute("slides", slides);
        request.setAttribute("products", products);
        request.setAttribute("newproducts", newproducts);

        Object user = session.getAttribute("userlogged");

        if (user != null) {
            User u = (User) user;
            String userID = String.valueOf(u.getUserid());
            String groupCusID = gdao.getGroupIDbyUserID(userID);
            ArrayList<Message> listMessages = mdao.getAllMessageofUser(groupCusID, userID);
            List<String> listUserAdminID = udao.listUserAdminID();
          
            request.setAttribute("listMess", listMessages);
            request.setAttribute("listUserAdminID", listUserAdminID);
            
            if(gdao.getGroupIDbyUserID(userID).equals("")){
                String maxGroupID = gdao.getMaxGroupIDb();
                gdao.addGroup((u.getFullname()) +" CSKH"+u.getUserid());
                gdao.addUserGroup(userID,maxGroupID);
                for (String string : listUserAdminID) {
                    gdao.addUserGroup(string,maxGroupID);
                }
            }
        }

        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @par am request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
