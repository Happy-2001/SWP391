/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Favourite;

/**
 *
 * @author thund
 */
public class FavouriteDAO {
    DBConnect mysqlConnect = new DBConnect();
    
    public void addProductLike(int uid, String pid) {
        try {
            String sql = "INSERT INTO `favorite_products`(`userID`, `productID`) VALUES (?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, uid); //name
            statement.setString(2, pid); //category id
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    public static void main(String[] args) {
        FavouriteDAO f = new FavouriteDAO();
        f.addProductLike(1, "2");
    }
    
}
