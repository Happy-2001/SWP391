package controller;

import dal.FeedbackDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditFeedbackcontroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fid = request.getParameter("fid");     
        String note = request.getParameter("feedback");
        FeedbackDAO fd = new FeedbackDAO();
         fd.updateFb(note,Integer.parseInt(fid));     
        response.sendRedirect("Feedbackcontroller");
    }

  
}
