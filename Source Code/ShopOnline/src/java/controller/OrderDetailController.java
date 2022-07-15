/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.OrderDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Orders;


public class OrderDetailController extends HttpServlet {

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
        String id = request.getParameter("id");
        OrderDAO dao = new OrderDAO();
        ArrayList<Orders> o = dao.getOrderById(Integer.parseInt(id));
        Orders oder = dao.getLatestByID(Integer.parseInt(id));
        
        double total = 0;
        for (Orders od : o) {
            total = total + od.getQuantity()*od.getProduct().getSalePrice();
        }
        double vat = 0.1 * total;
        request.setAttribute("total", total);
        request.setAttribute("vat", vat);
        request.setAttribute("sum", total + vat);
        
        request.setAttribute("orderlist", o);
        request.setAttribute("order", oder);
        
        request.getRequestDispatcher("OrderDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String rdate = request.getParameter("rdate");
        String status = request.getParameter("status");
        
        OrderDAO dao = new OrderDAO();
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");  
        Date date = new Date();
        
        switch(status){
            case "completed" : 
                dao.updateStatusOrder(fm.format(date), null, status, Integer.parseInt(id));
                break;
            case "" :
                dao.updateStatusOrder(rdate, fm.format(date), status, Integer.parseInt(id));
                break;
            default: 
        }
        
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
