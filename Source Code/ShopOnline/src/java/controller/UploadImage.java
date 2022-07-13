package controller;

import dal.ImageDAO;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
/**
 *
 * @author anhvo
 */

@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadImage extends HttpServlet {
  
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        InputStream inputStream = null; // input stream of the upload file
        String userid = request.getParameter("eaID");
        String cusid = request.getParameter("cusID"); 
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {       
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        
        ImageDAO upli = new ImageDAO();
        if (userid == null || userid.isEmpty()){
            upli.loadImg(inputStream, Integer.parseInt(cusid));
            response.sendRedirect("admin/CusDetail?cusID="+cusid);
        }else{
            upli.loadImg(inputStream, Integer.parseInt(userid));
            response.sendRedirect("ProfileUser?userid="+userid);
        }
        
   }        
}
