package controller;

import dal.CartDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String iid = request.getParameter("id");
        String qty = request.getParameter("qty");

        int newQty = Integer.parseInt(qty) - 1;
        
        CartDAO pdb = new CartDAO();
        pdb.updateCart(newQty, Integer.parseInt(iid));
        
        response.sendRedirect("CartController?userID="+uid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String iid = request.getParameter("id");
        String qty = request.getParameter("qty");

        int newQty = Integer.parseInt(qty) + 1;
        
        CartDAO pdb = new CartDAO();
        pdb.updateCart(newQty, Integer.parseInt(iid));
        
        response.sendRedirect("CartController?userID="+uid);
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
