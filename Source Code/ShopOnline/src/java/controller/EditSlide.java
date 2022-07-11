/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.SlideDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Slide;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "EditSlide", urlPatterns = {"/editslide"})
public class EditSlide extends HttpServlet {

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
            out.println("<title>Servlet EditSlide</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditSlide at " + request.getContextPath() + "</h1>");
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
        SlideDAO sdb = new SlideDAO();
        String id = request.getParameter("id");
        request.setAttribute("s", sdb.getById(id));
        request.setAttribute("id", id);
        request.getRequestDispatcher("editslide.jsp").forward(request, response);
    }
    
    
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        String image = request.getParameter("image");
        String heading = request.getParameter("heading");
        String description = request.getParameter("description");
        String url = request.getParameter("url");
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        if (status == null) {
            status = "0";
        }

        Slide s = new Slide();
        s.setNamebutton(button);
        s.setImg(image);
        s.setHeading(heading);
        s.setDescription(description);
        s.setUrl(url);
        s.setStatus(status.equals("1"));
        s.setId(Integer.parseInt(id));
        SlideDAO sdb = new SlideDAO();

        sdb.update(s);

        response.sendRedirect("listslide");

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
