/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import dal.PostDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.Post;

/**
 *
 * @author Admin
 */
@WebServlet(name = "PostManagerController", urlPatterns = {"/PostManagerController"})
public class PostManagerController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getParameter("action");
        switch (action) {
                case "add":
                    add(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                default:
                    break;
        }
        
        response.sendRedirect("PostManagerController");
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
        String actionpage = request.getParameter("actionpage");
        String date = request.getParameter("createdDate");
        String stringDate = "22/01/2016";
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1= null;
        try {
            date1 = (Date) formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(PostManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String content = request.getParameter("description");
        String description = request.getParameter("noidung");
        String noidung = request.getParameter("image");
        String image = request.getParameter("categoryId");
        
        BlogDAO blogDAO = new BlogDAO();
        Blog b = new Blog();
        b.setCreatedDate(date1);
        b.setContent(content);
        b.setDescription(description);
        b.setNoidung(noidung);
        b.setImage(image);
        switch (actionpage) {
            case "add":
                b.setImage("upload/" + image);
                blogDAO.addBlog(b);
                break;
            case "edit":
                b.setImage("upload/" + image);
                String pid = request.getParameter("id");
                b.setId(Integer.parseInt(pid));
                blogDAO.update(b);
                break;
        }
        response.sendRedirect("PostManagerController");
    }
    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addPost.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        PostDAO postDAO = new PostDAO();
        postDAO.deletePost(Integer.parseInt(id));
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PostDAO postDAO = new PostDAO();
        String productId = request.getParameter("id");
        Post post = postDAO.getPostByID(Integer.parseInt(productId));
        request.setAttribute("post", post);
        request.getRequestDispatcher("editproduct.jsp").forward(request, response);
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
