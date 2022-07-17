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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Blog;
import model.BlogCategory;
import model.Post;

/**
 *
 * @author Manh_Hung
 */
public class PostEdit extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostEdit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostEdit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String productName = request.getParameter("productName");
        String categoryId = request.getParameter("categoryId");
        String productPrice = request.getParameter("productPrice");
        String productStock = request.getParameter("productStock");
        String description = request.getParameter("description");
        String image = request.getParameter("file");
        BlogDAO productDAO = new BlogDAO();
        HttpSession session = request.getSession();

        int uid = (int) session.getAttribute("userid");

        Blog p = new Blog();

        p.setCreatedDate(productName);
        p.setCategoryId(Integer.parseInt(categoryId));
        p.setContent(productPrice);
        p.setNoidung(productStock);
        p.setDescription(description);
        p.setUid(uid);
        switch (actionpage) {
            case "add":
                p.setImage("images/" + image);
                productDAO.addBlog(p);
                break;
            case "edit":
                String id = request.getParameter("id");
                PostDAO dao = new PostDAO();
                p.setImage("images/" + image);
                String a = p.getImage();
                //productDAO.update(p);
                dao.update(productName, productPrice, productStock, description, Integer.parseInt(categoryId), a, Integer.parseInt(id));
                break;
        }
        response.sendRedirect("PostEdit");
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
        request.getRequestDispatcher("postdelete.jsp").forward(request, response);
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
