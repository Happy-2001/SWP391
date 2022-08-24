package controller;

import dal.CartDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;

/**
 *
 * @author anhvo
 */
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("userID");

        CartDAO pdb = new CartDAO();
        ArrayList<Cart> carts = pdb.listById(Integer.parseInt(id));

        double total = 0;
        int count = 0;
        for (Cart o : carts) {
            if (o.getSelected().equals("1")) {
                total = total + o.getQuantity() * o.getProduct().getPrice();
            }
            if(o.getSelected().equals("1")){
                count++;
            }
        }
        if(count == carts.size()){
            request.setAttribute("selectAll", "checked");
        }
        double vat = 0.1 * total;
        request.setAttribute("total", total);
        request.setAttribute("vat", vat);
        request.setAttribute("sum", total + vat);
        request.setAttribute("carts", carts);

        request.getRequestDispatcher("cartDetail.jsp").forward(request, response);
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
