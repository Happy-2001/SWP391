package controller;

import dal.BlogDAO;
import dal.GroupDAO;
import dal.MessageDAO;
import dal.ProductDAO;
import dal.SlideDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Blog;
import model.Message;
import model.Product;
import model.Slide;
import model.User;

/**
 *
 * @author anhvo
 */
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO pdb = new ProductDAO();
        BlogDAO bdb = new BlogDAO();
        SlideDAO slideDAO = new SlideDAO();
        MessageDAO mdao = new MessageDAO();
        HttpSession session = request.getSession();
        UserDAO udao = new UserDAO();
        GroupDAO gdao = new GroupDAO();

        List<Blog> blogs = bdb.getBlogForHomePage();
        List<Slide> slides = slideDAO.listSlide();
        List<Product> products = pdb.listTop(4);
        List<Product> newproducts = pdb.listTopNew(4);

        request.setAttribute("blogs", blogs);
        request.setAttribute("slides", slides);
        request.setAttribute("products", products);
        request.setAttribute("newproducts", newproducts);

        Object user = session.getAttribute("userlogged");

        if (user != null) {
            User u = (User) user;
            String userID = String.valueOf(u.getUserid());
            String groupCusID = gdao.getGroupIDbyUserID(userID);
            ArrayList<Message> listMessages = mdao.getAllMessageofUser(groupCusID, userID);
            List<String> listUserAdminID = udao.listUserAdminID();
          
            request.setAttribute("listMess", listMessages);
            request.setAttribute("listUserAdminID", listUserAdminID);
            
            if(gdao.getGroupIDbyUserID(userID).equals("") && !listUserAdminID.contains(String.valueOf(u.getUserid()))){  // only for Customer role
                String maxGroupID = gdao.getMaxGroupIDb();
                gdao.addGroup((u.getFullname()) +" CSKH"+u.getUserid());
                gdao.addUserGroup(userID,maxGroupID);
                for (String string : listUserAdminID) {
                    gdao.addUserGroup(string,maxGroupID);
                }
            }
        }

        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
