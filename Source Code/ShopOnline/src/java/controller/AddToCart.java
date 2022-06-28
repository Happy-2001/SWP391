package controller;

import dal.CartDAO;
import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;

/**
 *
 * @author anhvo
 */
public class AddToCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cid = request.getParameter("cid");
        String pid = request.getParameter("pid");
        
        CartDAO db = new CartDAO();
        List<Cart> list = db.listAllCart();
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        for (Cart c : list) {
            if(Integer.parseInt(cid) != c.getUserId()){
                db.addCart(Integer.parseInt(cid), fm.format(date), fm.format(date));
            }
        }
        db.addItemByCID(Integer.parseInt(cid), Integer.parseInt(pid));
        response.sendRedirect("home");
      
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
