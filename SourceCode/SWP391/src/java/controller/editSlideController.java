
package controller;

import dal.SlideDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Slide;

public class editSlideController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SlideDAO sdb = new SlideDAO();
        String id = request.getParameter("id");
        request.setAttribute("s", sdb.getById(id));
        request.setAttribute("id", id);
        request.getRequestDispatcher("editslide.jsp").forward(request, response);
    }
    
    
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        String image = request.getParameter("image");
        String heading = request.getParameter("heading");
        String description = request.getParameter("description");
        String url = request.getParameter("url");
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        if (status == null) {
            status = "0";
        }

        Slide s = new Slide();
        s.setNamebutton(button);
        s.setImg(image);
        s.setHeading(heading);
        s.setDescription(description);
        s.setUrl(url);
        s.setStatus(status.equals("1"));
        s.setId(Integer.parseInt(id));
        SlideDAO sdb = new SlideDAO();

        sdb.update(s);

        response.sendRedirect("listslide");

    }
}
