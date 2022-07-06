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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AddressDetail;
import model.District;
import model.Provinces;
import model.SubDistrict;
import model.User;

/**
 *
 * @author nguye
 */
public class ProfileUserController extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userid = request.getParameter("userid");  
        
        UserDAO udb = new UserDAO();
        AddressDAO adao = new AddressDAO();
        DetailAddressDAO dadao = new DetailAddressDAO();
        User user = udb.getUserById(userid);
        ArrayList<Provinces> listProvince = adao.getProvince();
        ArrayList<District> listDistrict = adao.getDistrict();
        ArrayList<SubDistrict> listSubDistrict = adao.getSubDistrict();
                
        request.setAttribute("listProvince", listProvince);
        request.setAttribute("listDistrict", listDistrict);
        request.setAttribute("listSubDistrict", listSubDistrict);
//        for (AddressDetail addressDetail : adList) {
//            response.getWriter().print(addressDetail.getAddressDetail());
//        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
//         response.getWriter().print(user.getEmail());
        request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
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
