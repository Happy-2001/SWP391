package controller;

import dal.FeedbackDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MyFeedback;

/**
 *
 * @author anhvo
 */
public class FeedbackDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fid = request.getParameter("fbID");
        
        FeedbackDAO db = new FeedbackDAO();
        MyFeedback mfb = db.getFeedbackById(Integer.parseInt(fid));
        
        request.setAttribute("mfb", mfb);
        
        request.getRequestDispatcher("FeedbackDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String fid = request.getParameter("fbID");
        String reply = request.getParameter("reply");
        
        FeedbackDAO db = new FeedbackDAO();
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date = new Date();  
        db.updateFb(reply, fm.format(date), Integer.parseInt(fid));
        
        MyFeedback mfb = db.getFeedbackById(Integer.parseInt(fid));
        
        request.setAttribute("mfb", mfb);
        
        request.getRequestDispatcher("FeedbackDetails.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
