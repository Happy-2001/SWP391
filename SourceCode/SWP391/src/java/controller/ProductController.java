/*
 * Created: 05-24-2021 by truongnq2k.
 *
 * Github: https://github.com/truongnq2k
 * Facebook: https://www.facebook.com/truongnq2k
 * Zalo: https://zalo.me/0352918986
 *
 */

package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

public class ProductController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductDAO pdb = new ProductDAO();
        String page = request.getParameter("page");

        //Set page for root course page
        if (page == null || page.equals("")) {
            page = "" + 1;
        }
        //for style active
        request.setAttribute("PAGE", page);
        int pageNumber = Integer.parseInt(page);

        int countPage = pdb.countPage();
        request.setAttribute("countPage", countPage);

        //get list courses for each pageNumber
        List<Product> productsForEachPage = pdb.getCourseByPageNumber(pageNumber);

        request.setAttribute("productsForEachPage", productsForEachPage);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }
}
