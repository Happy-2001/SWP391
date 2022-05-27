/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Returns the valid session object associated with the request
        HttpSession session = request.getSession();
        //Removes the object bound with the specified name from this session
        session.removeAttribute("userlogged");
        //Invalidates this session then unbinds any objects bound to it.
        session.invalidate();
        //Redirect to home page
        response.sendRedirect("home");
    }
}
