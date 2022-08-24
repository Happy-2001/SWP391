/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AddressDAO;
import dal.ProductDAO;
import dal.SupAdressDAO;
import dal.SuppliersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.District;
import model.ElectronicAddress;
import model.Product;
import model.Provinces;
import model.Street;
import model.SubDistrict;
import model.SupDetail;
import model.Supplier_address;
import model.Suppliers;
import model.project;

/**
 *
 * @author nguye
 */
public class SupplierDetailController extends HttpServlet {

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
         
        String id = request.getParameter("supID");
        
        SuppliersDAO supDAO = new SuppliersDAO();
        Suppliers sup = supDAO.getSupById(Integer.parseInt(id));
        
        SupAdressDAO supaddressDAO = new SupAdressDAO();
        SupDetail supAdd  = supaddressDAO.getSupAdressById(sup.getId());
        
        AddressDAO dbb = new AddressDAO();
        ArrayList<Provinces> province = dbb.getProvince();
        
        int prvid = 0;
        for(Provinces pv : province){
            if(pv.getName().equals(supAdd.getSup_add().getProID().getName())){
                prvid = pv.getId();
            }
        }
        ArrayList<District> district = dbb.getDistrict(prvid);
        
        int wid = 0;
        for(District ds : district){
            if(ds.getDistrictID() == supAdd.getSup_add().getDisID().getDistrictID()){
                wid = ds.getDistrictID();
            }
        }
        ArrayList<SubDistrict> ward = dbb.getSubDistrict(wid);
        
//        ArrayList<Street> street = dbb.getStreet(wid);
//        
//        ArrayList<project> project = dbb.getProjectByDisID(wid);
        
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> prolist = dao.listProductBySupID(sup.getId());
        
        request.setAttribute("sup", sup);
        request.setAttribute("supAdd", supAdd);
        request.setAttribute("district", district);
        request.setAttribute("ward", ward);
        request.setAttribute("prolist", prolist);
//        request.setAttribute("street", street);
//        request.setAttribute("project", project);
        request.setAttribute("province", province);
        
        request.getRequestDispatcher("SupplierDetail.jsp").forward(request, response);
         
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
