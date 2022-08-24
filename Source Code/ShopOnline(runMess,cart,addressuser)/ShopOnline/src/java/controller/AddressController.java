/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AddressDAO;
import dal.DetailAddressDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AddressDetail;
import model.District;
import model.Provinces;
import model.SubDistrict;
import model.User;
import model.UserAddress;
import model.project;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddressController", urlPatterns = {"/address"})
public class AddressController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddressController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddressController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        UserDAO udb = new UserDAO();
        AddressDAO adao = new AddressDAO();
        DetailAddressDAO dadao = new DetailAddressDAO();
        HttpSession session = request.getSession();

        String userid = request.getParameter("userid");
        User user = new User();

        Object objuser = session.getAttribute("userlogged");
        if (objuser != null) {
            user = (User) objuser;
            if (user.getUserid() == Integer.parseInt(userid)) {
                ArrayList<Provinces> listProvince = adao.getProvince();
                    ArrayList<District> listDistrict = adao.getDistrict();
                    ArrayList<SubDistrict> listSubDistrict = adao.getSubDistrict();
                    ArrayList<UserAddress> listUserAddress = adao.getUserAddress(String.valueOf(user.getUserid()));
                String accessType = request.getParameter("accesstype");
                if (accessType.equals("settings")) {
                    String settingtype = request.getParameter("settingtype");
                    if(settingtype.equalsIgnoreCase("editaddress")){
                        
                        String uaid = request.getParameter("uaid");
                        UserAddress uadd = null;
                        for (UserAddress ua : listUserAddress) {
                            if(ua.getUaID().equals(uaid)){
                                uadd = ua;
                            }
                        }
                    request.setAttribute("fullname", uadd.getFullname());
                    request.setAttribute("phone", uadd.getPhone());
                    request.setAttribute("listUserAddress", listUserAddress);
                    request.setAttribute("adddetail", uadd.getDetailAddress());
                    request.setAttribute("valueAddress", uadd.getPname()+" "+uadd.getDname()+" "+uadd.getWname());
                    
                    

                    request.getRequestDispatcher("addressDetail.jsp").forward(request, response);
                    
                    }else{
                        String idSetDefault = request.getParameter("idSetDefault");
                        String idDefault = request.getParameter("idDefault");
                        adao.updateStatusUserAddress2(idDefault);
                        adao.updateStatusUserAddress1(idSetDefault);
                        
                        response.sendRedirect("address?accesstype=access&&userid=" + userid);
                    }
                }else if(accessType.equals("delete")){
                    String uaID = request.getParameter("uaID");
                    adao.deleteUserAddress(uaID);
                    response.sendRedirect("address?accesstype=access&&userid=" + userid);
                }else{
                    String straddress = request.getParameter("straddress");
                    String adddetail = request.getParameter("straddressdetail");
                    String districtID = request.getParameter("districtID");
                    String provinceID = request.getParameter("provinceID");
                    String subDistrictID = request.getParameter("subDistrictID");
                    String fullname = request.getParameter("fullname");
                    String phone = request.getParameter("phone");

                    

                    Object objProvinceID = session.getAttribute("provinceID");
                    Object objdistrictID = session.getAttribute("districtID");
                    Object objsubDistrictID = session.getAttribute("subDistrictID");
                    Object objAdddetail = session.getAttribute("adddetail");
                    Object objStraddress = session.getAttribute("straddress");
                    Object objfullname = session.getAttribute("fullname");
                    Object objphone = session.getAttribute("phone");
                    //xử lý trong trường hợp address detail nhận được value

                    if (provinceID == null || districtID == null || subDistrictID == null) {
                        session.setAttribute("straddress", straddress);
                    } else {
                        session.setAttribute("provinceID", provinceID);
                        session.setAttribute("districtID", districtID);
                        session.setAttribute("subDistrictID", subDistrictID);
                    }
                    if (straddress != null) {

                        if (!straddress.trim().equals("")) {
                            ArrayList<AddressDetail> adList = dadao.getDetailAddress();
                            ArrayList<AddressDetail> adList2 = new ArrayList<>();
                            ArrayList<Integer> saveADLIST = new ArrayList<>();
                            String[] str = straddress.split("\\W+");

                            for (AddressDetail ad : adList) {
                                if (ad.getAddressDetail().toUpperCase().contains(straddress.toUpperCase())) {
                                    adList2.add(ad);

                                }
                            }
                            if (adddetail == null || districtID == null || provinceID == null) {
                                if (!adList2.isEmpty()) {
                                    request.setAttribute("selectaddress2Style", "height: 300px;display: block");
                                    request.setAttribute("ulBlock", "display:block");
                                }
                            }
                            request.setAttribute("adList", adList2);

                        }
                    } else {
                        ArrayList<AddressDetail> adList = dadao.getDetailAddress();
                        request.setAttribute("adList", adList);
                    }

                    if (districtID != null && provinceID != null) {
                        request.setAttribute("selectaddress2Style", "height: 0;display: none");
                        request.setAttribute("ulBlock", "display:none");
                        ArrayList<project> listProject = adao.getProjectWith(provinceID, districtID);
                        request.setAttribute("listProject", listProject);
                        request.setAttribute("selectaddress3Style", "height: 300px;display: block");
                        request.setAttribute("ulBlock3", "display:block");
                    }
                    if (adddetail != null && provinceID == null) {
                        response.getWriter().println(adddetail);
                        request.setAttribute("selectaddress2Style", "height: 0;display: none");
                        request.setAttribute("ulBlock", "display:none");
                        if (!adddetail.trim().equals("")) {
                            ArrayList<project> listProject = adao.getProject();
                            ArrayList<project> listProject2 = new ArrayList<>();

                            String[] str = adddetail.split("\\W+");

                            for (project ad : listProject) {
                                if (ad.getName().toUpperCase().contains(adddetail.toUpperCase())) {
                                    listProject2.add(ad);
                                    response.getWriter().println(ad.getName());

                                }
                            }

                            request.setAttribute("listProject", listProject2);
                            request.setAttribute("selectaddress3Style", "height: 400px;display: block");
                            request.setAttribute("ulBlock3", "display:block");
                        }
                    }

                    request.setAttribute("fullname", fullname);
                    request.setAttribute("phone", phone);
                    request.setAttribute("listUserAddress", listUserAddress);
                    request.setAttribute("adddetail", adddetail);
                    request.setAttribute("valueAddress", straddress);
                    request.setAttribute("listProvince", listProvince);
                    request.setAttribute("listDistrict", listDistrict);
                    request.setAttribute("listSubDistrict", listSubDistrict);

                    request.getRequestDispatcher("addressDetail.jsp").forward(request, response);
                }
                
                

            }
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.getWriter().print("hello");
        HttpSession session = request.getSession();
        AddressDAO adao = new AddressDAO();
        Object objProvinceID = session.getAttribute("provinceID");
        Object objdistrictID = session.getAttribute("districtID");
        Object objsubDistrictID = session.getAttribute("subDistrictID");
        String objAdddetail = request.getParameter("adddetail");
        String objStraddress = request.getParameter("straddress");
        String objfullname = request.getParameter("fullname");
        String objphone = request.getParameter("phone");
        Object objuserid = session.getAttribute("userid");

        Integer userid = (Integer) objuserid;
        String fullname = (String) objfullname;
        String phone = (String) objphone;
        String Adddetail = (String) objAdddetail;
        String provinceID = "";
        String districtID = "";
        String subDistrictID = "";
        String straddress = "";
        String eaID = adao.getEaIDbyUserID(String.valueOf(userid));
        if (objProvinceID == null || objdistrictID == null || objsubDistrictID == null) {
            straddress = (String) objStraddress;
            adao.insertUserAddress(String.valueOf(userid), fullname, eaID);

        } else {
            provinceID = (String) objProvinceID;
            districtID = (String) objdistrictID;
            subDistrictID = (String) objsubDistrictID;
            adao.insertUserAddress(String.valueOf(userid), fullname,  eaID);

        }
        response.sendRedirect("address?accesstype=access&&userid=" + userid);

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
