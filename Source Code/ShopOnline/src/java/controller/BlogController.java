package controller;

import dal.BlogDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;

public class BlogController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BlogDAO bdb = new BlogDAO();
        String page = request.getParameter("page");
        //Set page for root course page
        if (page == null || page.equals("")) {
            page = "" + 1;
        }
        request.setAttribute("PAGE", page);
        int pageNumber = Integer.parseInt(page);
        int countPage = bdb.countPage();
        request.setAttribute("countPage", countPage);
        //get list courses for each pageNumber
        List<Blog> blogsForEachPage = bdb.getBlogByPageNumber(pageNumber);
        request.setAttribute("blogs", blogsForEachPage);
        request.getRequestDispatcher("blog.jsp").forward(request, response);
    }
}
