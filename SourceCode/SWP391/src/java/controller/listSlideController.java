
package controller;

import dal.SlideDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Slide;

public class listSlideController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SlideDAO sld = new SlideDAO();
        List<Slide> slides =  sld.listSlide();
        request.setAttribute("slides", slides);
        request.getRequestDispatcher("listslide.jsp").forward(request, response);
    }
}
