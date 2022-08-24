/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.OrderDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Orders;
import model.User;

/**
 *
 * @author thund
 */
public class MyOrderController extends HttpServlet {

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
        OrderDAO udb = new OrderDAO();
        List<Orders> Orderlist = udb.listAllOder();
        request.setAttribute("Orderlist", Orderlist);
        request.getRequestDispatcher("MyOrder.jsp").forward(request, response);
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
        OrderDAO udb = new OrderDAO();
//        List<Orders> Orderlist = udb.listAllOder();
        List<Orders> Orderlist = new ArrayList<>();
        if (index == -2) {
           Orderlist = udb.listAllOderDESC();
        } else if(index == 1){
            Orderlist = udb.listAllOderASC();

        }else if(index == 2){
            Orderlist = udb.getStt2();

        }else if(index == 3){
            Orderlist = udb.getStt3();

        }else if(index == 4){
            Orderlist = udb.getStt4();

        }else if(index == 5){
            Orderlist = udb.getStt5();

        }else if(index == 6){
            Orderlist = udb.getStt6();

        }
        else{
            Orderlist = udb.listAllOder();
        }
        
        request.setAttribute("Orderlist", Orderlist);
        request.getRequestDispatcher("MyOrder.jsp").forward(request, response);
                
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
