package controller;

import dal.ProductDAO;
import emailverify.SendEmail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.User;

public class BuyNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product p = new ProductDAO().findById(pid);
        HttpSession session = request.getSession();
        SendEmail se = new SendEmail();
        
        String h = getBaseUrl(request);
        
        String subject = "ShopNamDat Thanks For Bought !";
        //String message = "Thank you for your purchase product:" + p.getName() + ", please leave us feedback! \n" + "http://localhost:8080/shopnamdat/Feedback?pid=" + pid;
        String message = "Thank you for your purchase product:" + p.getName() + ", please leave us feedback! \n" + h + "/Feedback?pid=" + pid;
        boolean test = false;
        try {
            User u = (User) session.getAttribute("userlogged");
            test = se.sendEmail(u, subject, message);
        } catch (Exception e) {
            response.sendRedirect("login");
        }

        if (test) {
            System.out.println("Send OK");
        } else {
            System.out.println("Send Faild");
        }
        response.sendRedirect("productDetail?product_id=" + pid);
    }
    
    public static String getBaseUrl(HttpServletRequest request) {
    String scheme = request.getScheme() + "://";
    String serverName = request.getServerName();
    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
    String contextPath = request.getContextPath();
    return scheme + serverName + serverPort + contextPath;
  }
}
