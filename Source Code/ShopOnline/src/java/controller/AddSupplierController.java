/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AddressDAO;
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
import model.Provinces;
import model.SubDistrict;
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
        AddressDAO dao = new AddressDAO();
        List<Provinces> provinces = dao.getProvince();
        List<District> District = dao.getDistrict();
        List<SubDistrict> Ward = dao.getSubDistrict();
        
        request.setAttribute("provinces", provinces);
        request.setAttribute("district", District);
        request.setAttribute("ward", Ward);
        request.getRequestDispatcher("AddSupplier.jsp").forward(request, response);
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
        String companyName = request.getParameter("companyName");
        String ccontactName = request.getParameter("contactName");
        String contactTitle = request.getParameter("contactTitle");
        String DOB = request.getParameter("DOB");
        String gender = request.getParameter("gender");
        String creator = request.getParameter("creator");
        String createOn = request.getParameter("createOn");
        SuppliersDAO supDAO = new SuppliersDAO();
        
        Suppliers sup = new Suppliers();
        sup.setName(companyName);
        sup.setContactName(ccontactName);
        sup.setContactTitle(contactTitle);
        sup.setDob(Date.valueOf(DOB));
        sup.setGender(Integer.parseInt(gender));
        sup.setCreator(Integer.parseInt(creator));
        sup.setCreateOn(Date.valueOf(createOn));
        supDAO.addSuppliers(sup);
        response.sendRedirect("SuppliersController");
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
