
package controller;

import dal.BlogDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogDetailController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       BlogDAO bdb = new BlogDAO();
        String id = request.getParameter("id");
        request.setAttribute("postrecommend", bdb.getBlogRecommend(id, 2));
        request.setAttribute("post", bdb.getBlogById(id));
        request.getRequestDispatcher("blogdetail.jsp").forward(request, response);      
    }                                            
    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       BlogDAO bdb = new BlogDAO();
        String id = request.getParameter("id");
        request.setAttribute("postrecommend", bdb.getBlogRecommend(id, 2));
        request.setAttribute("post", bdb.getBlogById(id));
        request.getRequestDispatcher("blogdetail.jsp").forward(request, response);      
    */
}
