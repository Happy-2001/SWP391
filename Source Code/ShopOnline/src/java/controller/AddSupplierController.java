/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AddressDAO;
import dal.PostDAO;
import dal.ProductCategoryDAO;
import dal.SuppliersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.District;
import model.ElectronicAddress;
import model.Post;
import model.Post_Category;
import model.Provinces;
import model.SubDistrict;
import model.Supplier;
import model.Suppliers;
import model.Ward;

/**
 *
 * @author nguye
 */
public class AddSupplierController extends HttpServlet {

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

        response.sendRedirect("/admin/SuppliersController");
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
        String companyName = request.getParameter("companyName");
        String ccontactName = request.getParameter("contactName");
        String contactTitle = request.getParameter("contactTitle");
        String DOB = request.getParameter("DOB");
        String gender = request.getParameter("gender");
        String creator = request.getParameter("creator");
        SuppliersDAO supDAO = new SuppliersDAO();
        
        Supplier sup = new Supplier();
        sup.setName(companyName);
        sup.setContactName(ccontactName);
        sup.setContactTitle(contactTitle);
        sup.setDob(DOB);
        sup.setGender(Integer.parseInt(gender));
        sup.setCreator(Integer.parseInt(creator));
        switch (actionpage) {
            case "add":
                
                supDAO.addSuppliers(sup);
                break;
            case "edit":
//                String id = request.getParameter("id");
//                PostDAO dao = new PostDAO();
//                p.setImage("images/" + image);
//                String a = p.getImage();
                //productDAO.update(p);
//                dao.update(productName, productPrice, productStock, description, Integer.parseInt(categoryId), a, Integer.parseInt(id));
                break;
        }
        response.sendRedirect("SuppliersController");
    }
    
    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("AddSupplier.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        PostDAO postDAO = new PostDAO();
        postDAO.deleteBlog(Integer.parseInt(id));
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
