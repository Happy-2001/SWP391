/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductCategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author thund
 */
public class SettingList extends HttpServlet {

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
            out.println("<title>Servlet SettingList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingList at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        int index = Integer.parseInt(request.getParameter("filter"));
        ProductDAO pdb = new ProductDAO();
        String page = request.getParameter("page");

        //Set page for root course page
        if (page == null || page.isEmpty()) {
            page = "" + 1;
        }
        //for style active
        request.setAttribute("PAGE", page);
        int pageNumber = Integer.parseInt(page);

        int countPage = pdb.countPage();
        request.setAttribute("countPage", countPage);
        List<Product> list = new ArrayList<>();
        if(index == -1){
            list = pdb.listProductDESC();
        }else if(index == 0){
            list = pdb.listProductASC();
        }else{
            list = pdb.getProductByPageNumber(pageNumber);
        }
             //get list courses for each pageNumber
        request.setAttribute("productsForEachPage", list);

        List<Product> products = pdb.listByPageNum(pageNumber);
        request.setAttribute("listByPage", products);
        ProductCategoryDAO dao = new ProductCategoryDAO();
        List<Category> listC = dao.listAll();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
        
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
