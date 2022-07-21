package dal;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhvo
 */
public class ImageDAO {
    DBConnect mysqlConnect = new DBConnect();
    
    public void loadImg(InputStream inputStream, int id) {
        String sql = "UPDATE `electronicaddress` SET `photo` = ? WHERE eaID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, inputStream);
                statement.setInt(2, id);
            }
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSliderImg(InputStream inputStream, int id) {
        String sql = "UPDATE `slides` SET `img`=? WHERE slide_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, inputStream);
                statement.setInt(2, id);
            }
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addFeedbackImg(String img, InputStream inputStream) {
        String sql = "INSERT INTO `feedbacks`(`"+img+"`, `status`) VALUES (?,0)";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, inputStream);
            }
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateFeedbackImg(String img, InputStream inputStream, int id) {
        String sql = "UPDATE `feedbacks` SET `"+img+"`= ? WHERE feedback_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, inputStream);
            }
            
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public byte[] Retrieve(int id){
        String sql = "SELECT photo FROM `electronicaddress` WHERE eaID = ?";
        byte[] byteArray = null;
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("photo");
                byteArray = blob.getBytes(1, (int) blob.length());
            }
            return byteArray;
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public byte[] SliderImg(int id){
        String sql = "SELECT img FROM `slides` WHERE slide_id = ?";
        byte[] byteArray = null;
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("img");
                byteArray = blob.getBytes(1, (int) blob.length());
            }
            return byteArray;
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public byte[] FeedbackImg(String img, int id){
        String sql = "SELECT `"+img+"` FROM `feedbacks` WHERE feedback_id = ?";
        byte[] byteArray = null;
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob(img);
                byteArray = blob.getBytes(1, (int) blob.length());
            }
            return byteArray;
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
