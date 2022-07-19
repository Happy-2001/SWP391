/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FeedbackDAO;
import dal.ImageDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.MyFeedback;
import model.Orders;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "FeedbackController", urlPatterns = {"/Feedback"})
public class FeedbackController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("orderId");
        OrderDAO db = new OrderDAO();
        FeedbackDAO fb = new FeedbackDAO();
        
        Orders order = db.getOrderByID(Integer.parseInt(id));
        
        List<MyFeedback> list = fb.ListAllFeedback();
        
        int fbid = 0;
        for (MyFeedback feedb : list){
            if(feedb.getOrder().getOrderID() == Integer.parseInt(id)){
                fbid = feedb.getFbID();
            }
        }
        
        MyFeedback myfb = fb.getFeedbackById(fbid);
        
        request.setAttribute("myfb", myfb);
        request.setAttribute("order", order);
        request.getRequestDispatcher("myFeedback.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uid = request.getParameter("uid");
        String oid = request.getParameter("orderID");
        String rate = request.getParameter("rating");
        String reply = request.getParameter("reply");
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date = new Date();  
        
        OrderDAO db = new OrderDAO();
        FeedbackDAO fb = new FeedbackDAO();
        
        Orders order = db.getOrderByID(Integer.parseInt(oid));
        fb.addFB(reply, Integer.parseInt(uid), Integer.parseInt(oid), fm.format(date), Integer.parseInt(rate));
        
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

        request.getRequestDispatcher("myFeedback.jsp").forward(request, response);
    }
}
