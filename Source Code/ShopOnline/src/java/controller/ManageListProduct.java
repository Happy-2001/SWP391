/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductCategoryDAO;
import dal.ProductDAO;
import dal.SuppliersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import model.Suppliers;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ManageListProduct", urlPatterns = {"/listproduct"})
public class ManageListProduct extends HttpServlet {

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
        String shortdescription = request.getParameter("shortdescription");
        String supplier = request.getParameter("supplier");
        String productSalePrice = request.getParameter("productSalePrice");
        String brief_information = request.getParameter("brief_information");
        String image = request.getParameter("file");
        ProductDAO productDAO = new ProductDAO();

        Product p = new Product();

        p.setName(productName);
        p.setCategory(new Category(Integer.parseInt(categoryId)));
        p.setPrice(Float.parseFloat(productPrice));
        p.setStock(Integer.parseInt(productStock));
        p.setDescription(description);
        p.setSupplierID(supplier);
        p.setSortdesc(shortdescription);
        p.setSalePrice(Float.parseFloat(productSalePrice));
        p.setBrief_information(brief_information);
       
        

        switch (actionpage) {
            case "add":
                p.setImg("images/" + image);
                productDAO.addProduct(p);
                break;
            case "edit":
                p.setImg("images/" + image);
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
        SuppliersDAO supdao = new SuppliersDAO();
        List<Category> categories = categoryDAO.listAll();
        List<Suppliers> suppliers = supdao.listSupplier();
        request.setAttribute("categories", categories);
        request.setAttribute("suppliers", suppliers);
        request.getRequestDispatcher("admin/addproduct.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        String productId = request.getParameter("id");
        Product product = productDAO.findById(productId);
        ProductCategoryDAO categoryDAO = new ProductCategoryDAO();
        SuppliersDAO supdao = new SuppliersDAO();
        List<Category> categories = categoryDAO.listAll();
        List<Suppliers> suppliers = supdao.listSupplier();
        request.setAttribute("product", product);
        request.setAttribute("categories", categories);
        request.setAttribute("suppliers", suppliers);
        request.getRequestDispatcher("admin/editproduct.jsp").forward(request, response);
    }

}
