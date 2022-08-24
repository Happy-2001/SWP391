package controller;

import dal.CartDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Orders;

public class CartCompletion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("cartID");
        String total = request.getParameter("sum");

        CartDAO db = new CartDAO();
        OrderDAO odb = new OrderDAO();
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");  
        Date date = new Date();
        odb.insertOrder(fm.format(date), Integer.parseInt(id));
        Orders od = odb.getOrderLatest();
        
        ArrayList<Cart> carts = db.listById(Integer.parseInt(id));
        for (Cart o : carts) {
            odb.insertOrderD(o.getQuantity(), od.getOrderID(), o.getProduct().getId());
        }
        
        ArrayList<Orders> order = odb.getOrderById(od.getOrderID());
        db.deleteByCartID(Integer.parseInt(id));
        
        request.setAttribute("name", od.getUser().getFullname());
        request.setAttribute("orderDate", od.getOrderDate());
        request.setAttribute("orderNo", od.getOrderID());
        request.setAttribute("orders", order);
        request.setAttribute("total", total);
        
        
        request.getRequestDispatcher("cartCompletion.jsp").forward(request, response);
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
