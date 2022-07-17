package controller;

import dal.SlideDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anhvo
 */
public class SliderDetailController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SlideDAO sdb = new SlideDAO();
        String id = request.getParameter("id");
        request.setAttribute("s", sdb.getById(id));
        request.setAttribute("id", id);
        request.getRequestDispatcher("SliderDetails.jsp").forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String id = request.getParameter("id");
        String heading = request.getParameter("heading");
        String button = request.getParameter("button");
        String url = request.getParameter("url");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        
        if (status == null || status.isEmpty()) {
            status = "0";
        }
        SlideDAO sdb = new SlideDAO();
        sdb.update(heading, description, button, url, Integer.parseInt(status), Integer.parseInt(id));

        request.setAttribute("s", sdb.getById(id));
        request.setAttribute("id", id);

        request.getRequestDispatcher("SliderDetails.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
