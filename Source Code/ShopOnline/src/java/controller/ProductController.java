package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author thund
 */
public class ProductController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO pdb = new ProductDAO();
        String page = request.getParameter("page");

        //Set page for root course page
        if (page == null || page.isEmpty()) {
            page = "" + 1;
        }
        //for style active
        request.setAttribute("PAGE", page);
        int pageNumber = Integer.parseInt(page);

        int countPage = pdb.countPage();
        request.setAttribute("countPage", countPage);

        //get list courses for each pageNumber
        List<Product> productsForEachPage = pdb.getProductByPageNumber(pageNumber);
        request.setAttribute("productsForEachPage", productsForEachPage);

        List<Product> products = pdb.listByPageNum(pageNumber);
        request.setAttribute("listByPage", products);

        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
