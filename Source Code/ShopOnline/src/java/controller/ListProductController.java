package controller;

import dal.ProductCategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

public class ListProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    add(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "search":
                    search(request, response);
                    break;
                default:
                    break;
            }
            response.sendRedirect("listproduct");
        } else {
            String sort = request.getParameter("sort");
            ProductDAO productDAO = new ProductDAO();
            if (sort != null && !sort.equals("")) {
                String page = request.getParameter("page");
                //Set page for root course page
                if (page == null || page.equals("")) {
                    page = "" + 1;
                }
                //for style active
                request.setAttribute("PAGE", page);
                int pageNumber = Integer.parseInt(page);
                int countPage = productDAO.countPage();
                request.setAttribute("countPage", countPage);
                //get list courses for each pageNumber
                List<Product> productsForEachPage = productDAO.getProductByPageNumber(pageNumber, sort);
                request.setAttribute("sort", sort);
                request.setAttribute("products", productsForEachPage);
            } else {
                String page = request.getParameter("page");
                //Set page for root course page
                if (page == null || page.equals("")) {
                    page = "" + 1;
                }
                //for style active
                request.setAttribute("PAGE", page);
                int pageNumber = Integer.parseInt(page);
                int countPage = productDAO.countPage();
                request.setAttribute("countPage", countPage);
                //get list courses for each pageNumber
                List<Product> productsForEachPage = productDAO.getProductByPageNumber(pageNumber);
                request.setAttribute("sort", sort);
                request.setAttribute("products", productsForEachPage);
            }
            request.getRequestDispatcher("admin/listproduct.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionpage = request.getParameter("actionpage");
        String productName = request.getParameter("productName");
        String categoryId = request.getParameter("categoryId");
        String productPrice = request.getParameter("productPrice");
        String productStock = request.getParameter("productStock");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        ProductDAO productDAO = new ProductDAO();

        Product p = new Product(); 
        p.setName(productName);
        p.setCategoryid(Integer.parseInt(categoryId));
        p.setPrice(Float.parseFloat(productPrice));
        p.setStock(Integer.parseInt(productStock));
        p.setDescription(description);

        switch (actionpage) {
            case "add":
                p.setImg("upload/" + image);
                productDAO.addProduct(p);
                break;
            case "edit":
                p.setImg("upload/" + image);
                String pid = request.getParameter("id");
                p.setId(Integer.parseInt(pid));
                productDAO.update(p);
                break;
        }
        response.sendRedirect("listproduct");

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteProduct(Integer.parseInt(id));
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        String query = request.getParameter("search").trim();
        List<Product> products = productDAO.findByName(query);
        request.setAttribute("products", products);
        request.getRequestDispatcher("admin/listproduct.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductCategoryDAO categoryDAO = new ProductCategoryDAO();
        List<Category> categories = categoryDAO.listAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("admin/addproduct.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        String productId = request.getParameter("id");
        Product product = productDAO.findById(productId);
        ProductCategoryDAO categoryDAO = new ProductCategoryDAO();
        List<Category> categories = categoryDAO.listAll();
        request.setAttribute("product", product);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("admin/editproduct.jsp").forward(request, response);
    }

}
