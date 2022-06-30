
package controller;

import dal.BlogDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogSearch extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");
        request.setAttribute("search", search);
        request.setAttribute("blogs", new BlogDAO().getBlogSearch(search));
        request.getRequestDispatcher("blog.jsp").forward(request, response);
        
    }
    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");
        request.setAttribute("search", search);
        request.setAttribute("blogs", new BlogDAO().getBlogSearch(search));
        request.getRequestDispatcher("blog.jsp").forward(request, response);
    */
}
