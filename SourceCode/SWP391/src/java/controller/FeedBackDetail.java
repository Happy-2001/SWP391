
package controller;

import dal.FeedbackDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MyFeedback;

public class FeedBackDetail extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String fid = request.getParameter("fid");      
        FeedbackDAO fd = new FeedbackDAO();
        MyFeedback mf = fd.getFeedbackById(Integer.parseInt(fid));
        request.setAttribute("mf", mf);
         request.setAttribute("fid", fid);
        request.getRequestDispatcher("Feedbackdetail.jsp").forward(request, response);  
    }
}
