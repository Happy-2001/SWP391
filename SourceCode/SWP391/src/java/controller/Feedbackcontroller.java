/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FeedbackDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MyFeedback;

/**
 *
 * @author dungk
 */
public class Feedbackcontroller extends HttpServlet {

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
            out.println("<title>Servlet Feedbackcontroller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Feedbackcontroller at " + request.getContextPath() + "</h1>");
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
        FeedbackDAO a = new FeedbackDAO();
        String sort = null;
        try {
            sort = request.getParameter("sort");
        } catch (Exception e) {

        }

        String page = request.getParameter("page");

        //Set page for root course page
        if (page == null || page.equals("")) {
            page = "" + 1;
        }
        //for style active
        request.setAttribute("PAGE", page);
        int pageNumber = Integer.parseInt(page);

        int countPage = a.countPage();
        request.setAttribute("countPage", countPage);

        List<MyFeedback> listfeefback;
        if (sort != null) {
            if (sort.equals("NAME")) {
                listfeefback = a.getFbBySortRatePaging(pageNumber, "full_name", "");
            } else {
                listfeefback = a.getFbBySortRatePaging(pageNumber, "star_rating", sort);
                
            }
        } else {
            sort = "";
            listfeefback = a.getFbBySortRatePaging(pageNumber, "star_rating", sort);
            
        }

        request.setAttribute("sort", sort);
        request.setAttribute("listfeefback", listfeefback);
        request.getRequestDispatcher("feedbackList.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
