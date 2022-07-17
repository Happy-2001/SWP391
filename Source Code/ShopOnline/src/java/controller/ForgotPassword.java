/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import emailverify.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author nguye
 */
public class ForgotPassword extends HttpServlet {

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
            out.println("<title>Servlet ForgotPassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            //
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
        request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
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
        String mail = request.getParameter("email");
        SendMail sendmail = new SendMail();
        UserDAO userDAO = new UserDAO();
        User acc = userDAO.getUserByEmail(mail);
        if(acc==null){
            request.setAttribute("ms1", "Check your Email!");
            request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
        }
        String subject = "Your account has been processing.";
        String message = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <h3 style=\"color: blue;\">Your account has been processing.</h3>\n"
                + "    <div>User Name : " + acc.getUsername() + "</div>\n"
                + "    <div>Password : " + acc.getPassword() + "</div>\n"
                + "    <div>Name : " + acc.getFirstname() +acc.getMiddlename() +acc.getLastname() + "</div>\n"
                + "    <div>Gender : " + acc.getGender() + "</div>\n"
                + "    <div>Phone : " + acc.getPhone() + "</div>\n"
                + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                + "\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        SendMail.send(mail, subject, message, "thachdphe151521@fpt.edu.vn", "Phucthach2k1");
        response.sendRedirect("login");
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
