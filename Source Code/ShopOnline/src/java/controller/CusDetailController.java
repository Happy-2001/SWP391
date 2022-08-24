package controller;

import dal.AddressDAO;
import dal.CustomerDAO;
import dal.OrderDAO;
import dal.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customers;
import model.District;
import model.Orders;
import model.Provinces;
import model.SubDistrict;

/**
 *
 * @author anhvo
 */
public class CusDetailController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("cusID");
        
        CustomerDAO db = new CustomerDAO();
        Customers cus = db.getCusByUserId(Integer.parseInt(id));
        
        AddressDAO dbb = new AddressDAO();
        ArrayList<Provinces> province = dbb.getProvince();
        
        int prvid = 0;
        for(Provinces pv : province){
            if(pv.getName().equals(cus.getUad().getProvince().getName())){
                prvid = pv.getId();
            }
        }
        ArrayList<District> district = dbb.getDistrict(prvid);
        
        int wid = 0;
        for(District ds : district){
            if(ds.getDistrictID() == cus.getUad().getDistrict().getDistrictID()){
                wid = ds.getDistrictID();
            }
        }
        ArrayList<SubDistrict> ward = dbb.getSubDistrict(wid);
        
        OrderDAO odb = new OrderDAO();
        Orders od = odb.getLatestByCusID(Integer.parseInt(id));
        ArrayList<Orders> order = odb.listOrderById(od.getOrderID());
        
        request.setAttribute("cus", cus);
        request.setAttribute("province", province);
        request.setAttribute("district", district);
        request.setAttribute("ward", ward);
        request.setAttribute("orders", order);
        request.setAttribute("orderDate", od.getOrderDate());
        
        request.getRequestDispatcher("CustomerDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("cusID");
        String fname = request.getParameter("fname");
        String mdname = request.getParameter("mdname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String pass = request.getParameter("pass");
        String date = request.getParameter("date");
        
        UserDAO udb = new UserDAO();
        
        udb.updateProfile(Integer.parseInt(id), pass, fname, mdname, lname, Integer.parseInt(gender), date);
        
        response.sendRedirect("CusDetail?cusID="+Integer.parseInt(id));
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
