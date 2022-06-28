package controller;

import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;

/**
 *
 * @author anhvo
 */
public class CartContact extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] itemID = request.getParameterValues("item");
        
        StringBuilder sb = new StringBuilder(itemID[0]);
        for(int i=1; i<itemID.length; i++){
            sb.append(",").append(itemID[i]);
        }
        
        CartDAO pdb = new CartDAO();
        List<Cart> cart = pdb.listByItemId(sb.toString());
        
        double total = 0;
        for (Cart o : cart) {
            total = total + o.getQuantity()*o.getProduct().getPrice();
        }
        request.setAttribute("total", total);
        request.setAttribute("carts", cart);
        request.getRequestDispatcher("cartContact.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
