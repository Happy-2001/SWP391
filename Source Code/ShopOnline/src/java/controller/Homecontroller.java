/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import dal.MessengerDAO;
import dal.ProductDAO;
import dal.SlideDAO;
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

        List<Blog> blogs = bdb.getBlogForHomePage();
        List<Slide> slides = slideDAO.listSlide();
        List<Product> products = pdb.listTop(4);
        List<Product> newproducts = pdb.listTopNew(4);
        request.setAttribute("blogs", blogs);
        request.setAttribute("slides", slides);
        request.setAttribute("products", products);
        request.setAttribute("newproducts", newproducts);

        HttpSession session = request.getSession();
        Object user = session.getAttribute("userlogged");
        if (user != null) {
            User u = (User) user;
            MessengerDAO mdao = new MessengerDAO();
            ArrayList<Message> MessageYouSend = mdao.getAllMessageofUser( "1",String.valueOf(u.getUserid()));     /// list message
            ArrayList<Message> MessageYouReceive = mdao.getAllMessageofUser( String.valueOf(u.getUserid()),"1");

            if (!MessageYouReceive.isEmpty() && MessageYouSend.isEmpty()) {
                request.setAttribute("MYR", MessageYouReceive);
                request.setAttribute("MYS", null);
            }
            if (MessageYouReceive.isEmpty() && !MessageYouSend.isEmpty()) {
                request.setAttribute("MYR", null);
                request.setAttribute("MYS", MessageYouSend);
            }
            if (!MessageYouReceive.isEmpty() && !MessageYouSend.isEmpty()) {
                request.setAttribute("MYR", MessageYouReceive);
                request.setAttribute("MYS", MessageYouSend);
                request.setAttribute("messageAdmin", "none");
            }
            if (MessageYouReceive.isEmpty() && MessageYouSend.isEmpty()) {
                request.setAttribute("MYR", null);
                request.setAttribute("MYS", null);
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
