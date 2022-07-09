package controller;

import dal.CartDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;

/**
 *
 * @author anhvo
 */
public class CartContact extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("userID");

        CartDAO pdb = new CartDAO();
        ArrayList<Cart> carts = pdb.listById(Integer.parseInt(id));
        
        double total = 0;
        for (Cart o : carts) {
            total = total + o.getQuantity()*o.getProduct().getPrice();
        }
        double vat = 0.1 * total;
        request.setAttribute("sum", total + vat);
        request.setAttribute("carts", carts);
        
        
        request.getRequestDispatcher("cartContact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("userID");
        String code = request.getParameter("code");
        
        CartDAO pdb = new CartDAO();
        ArrayList<Cart> carts = pdb.listById(Integer.parseInt(id));
        
        double total = 0;
        for (Cart o : carts) {
            total = total + o.getQuantity()*o.getProduct().getPrice();
        }
        double sum = total;
        if(code.equalsIgnoreCase("KX42CQK2")){
            sum = total - total * 0.2;
        }
        request.setAttribute("sum", sum);
        request.setAttribute("carts", carts);
        
        request.getRequestDispatcher("cartContact.jsp").forward(request, response);
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
