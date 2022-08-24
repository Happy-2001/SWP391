/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FeedbackDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.User;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "FeedbackController", urlPatterns = {"/Feedback"})
public class FeedbackController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         
        request.setAttribute("pid", request.getParameter("pid"));
        request.getRequestDispatcher("myFeedback.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        Product p = new ProductDAO().findById(request.getParameter("pid"));
        String des = request.getParameter("des");
        String rating1 = request.getParameter("rating1");
        FeedbackDAO fd = new FeedbackDAO();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("userlogged");
        if (u != null) {
            fd.addFB(des, u.getUserid(), p.getId(), Integer.parseInt(rating1));
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login");
        }
    }

}
