package controller;

import dal.FeedbackDAO;
import dal.ImageDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.MyFeedback;
import model.Orders;

/**
 *
 * @author anhvo
 */
@MultipartConfig(maxFileSize = 16177215) 
public class FeedbackUploadImage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String image = request.getParameter("act");
        String fid = request.getParameter("fbid");
        ImageDAO upli = new ImageDAO();
        try {
            response.setContentType("image/gif");
            OutputStream os = response.getOutputStream();
            os.write(upli.FeedbackImg(image, Integer.parseInt(fid)));
            
            os.flush();
            os.close();
        }catch (Exception e){
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oid = request.getParameter("orderID");
        OrderDAO db = new OrderDAO();
        FeedbackDAO fb = new FeedbackDAO();
        
        Orders order = db.getOrderByID(Integer.parseInt(oid));
        
        List<MyFeedback> list = fb.ListAllFeedback();
        
        int fbid = 0;
        for (MyFeedback feedb : list){
            if(feedb.getOrder().getOrderID() == Integer.parseInt(oid)){
                fbid = feedb.getFbID();
            }
        }
        
        MyFeedback myfb = fb.getFeedbackById(fbid);
        request.setAttribute("myfb", myfb);
        request.setAttribute("order", order);
        
        ImageDAO upli = new ImageDAO();
        
        Part filePart1 = request.getPart("img1");
        Part filePart2 = request.getPart("img2");
        String img1 = request.getParameter("img1");
        String img2 = request.getParameter("img2");
        response.getWriter().print(img1+"|"+img2);
        if (img1 == null && img2 != null && fbid == 0) {    
            upli.addFeedbackImg("image1", filePart1.getInputStream());
response.getWriter().print("case1");
        }
         if(img1 == null && img2 != null && fbid != 0){
            upli.updateFeedbackImg("image1", filePart1.getInputStream(), fbid);
response.getWriter().print("case2");
        }
        
        if (img1 != null && img2 == null && fbid == 0) {    
            upli.addFeedbackImg("image2", filePart2.getInputStream());
response.getWriter().print("case3");
        }
        
         if(img1 != null && img2 == null && fbid != 0){
           
            upli.updateFeedbackImg("image2", filePart2.getInputStream(), fbid);
response.getWriter().print("case4");
        }

        request.getRequestDispatcher("myFeedback.jsp").forward(request, response);
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
