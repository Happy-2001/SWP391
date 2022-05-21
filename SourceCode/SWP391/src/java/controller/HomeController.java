package controller;

import dal.BlogDAO;
import dal.ProductDAO;
import dal.SlideDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.Product;
import model.Slide;

@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO pdb = new ProductDAO();
        BlogDAO bdb = new BlogDAO();
        SlideDAO slideDAO = new SlideDAO();

        List<Blog> blogs = bdb.getBlogForHomePage();
        List<Slide> slides = slideDAO.listSlide();
        List<Product> products = pdb.listTop(4);
        List<Product> newproducts = pdb.listTopNew(4);
        request.setAttribute("blogs", blogs);
        request.setAttribute("slides", slides);
        request.setAttribute("products", products);
        request.setAttribute("newproducts", newproducts);
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
    }
}
