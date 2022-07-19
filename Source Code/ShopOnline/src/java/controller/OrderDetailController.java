package controller;

import dal.AddressDAO;
import dal.CustomerDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customers;
import model.District;
import model.Orders;
import model.Provinces;
import model.SubDistrict;

public class OrderDetailController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String cid = request.getParameter("cid");

        OrderDAO dao = new OrderDAO();
        CustomerDAO db = new CustomerDAO();
        Customers cus = db.getCusByUserId(Integer.parseInt(cid));

        AddressDAO dbb = new AddressDAO();
        ArrayList<Provinces> p = dbb.getProvince();

        int prvid = 0;
        for (Provinces pv : p) {
            if (pv.getName().equals(cus.getUad().getProvince().getName())) {
                prvid = pv.getId();
            }
        }
        Provinces province = dbb.getProvince(prvid);
        District district = dbb.getDistrictByID(cus.getUad().getDistrict().getDistrictID());
        SubDistrict ward = dbb.getWard(cus.getUad().getWard().getSubDistrictID());

        ArrayList<Orders> o = dao.listOrderById(Integer.parseInt(id));
        Orders oder = dao.getLatestByID(Integer.parseInt(id));

        double total = 0;
        for (Orders od : o) {
            total = total + od.getQuantity() * od.getProduct().getSalePrice();
        }
        double vat = 0.1 * total;
        request.setAttribute("total", total);
        request.setAttribute("vat", vat);
        request.setAttribute("sum", total + vat);

        request.setAttribute("orderlist", o);
        request.setAttribute("order", oder);
        request.setAttribute("cus", cus);
        request.setAttribute("province", province);
        request.setAttribute("district", district);
        request.setAttribute("ward", ward);

        request.getRequestDispatcher("OrderDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String rdate = request.getParameter("rdate");
        String sdate = request.getParameter("sdate");
        String status = request.getParameter("status");

        OrderDAO dao = new OrderDAO();

        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        Date date = new Date();

        switch (status) {
            case "completed":
                dao.updateStatusOrder(fm.format(date), null, status, Integer.parseInt(id));
                break;
            case "shipped":
                dao.updateStatusOrder(rdate, fm.format(date), status, Integer.parseInt(id));
                break;
            default:
                dao.updateStatusOrder(rdate, sdate, status, Integer.parseInt(id));
                break;
        }

        Orders oder = dao.getLatestByID(Integer.parseInt(id));
        ArrayList<Orders> o = dao.listOrderById(Integer.parseInt(id));

        double total = 0;
        for (Orders od : o) {
            total = total + od.getQuantity() * od.getProduct().getSalePrice();
        }
        double vat = 0.1 * total;

        request.setAttribute("total", total);
        request.setAttribute("vat", vat);
        request.setAttribute("sum", total + vat);
        request.setAttribute("orderlist", o);
        request.setAttribute("order", oder);

        request.getRequestDispatcher("OrderDetails.jsp").forward(request, response);
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
