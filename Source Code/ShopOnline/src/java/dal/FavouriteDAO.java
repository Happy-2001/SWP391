/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Favourite;
import model.Orders;

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
        FavouriteDAO product = new FavouriteDAO();
        List<Favourite> Product = product.getOrderByCusID(4);
        System.out.println(Product); 
    }
    public ArrayList<Favourite> getOrderByCusID(int cid) {
        ArrayList<Favourite> listOrder =new  ArrayList<>();
        String sql = "SELECT * FROM `favorite_products` f "
                + "join products p on p.product_id = f.productID "
                + "join user_accounts u on u.user_id = f.userID "
                + "where userID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Favourite c = new Favourite();
                c.setProductID(rs.getString("product_id"));
                c.setName(rs.getString("product_name"));
                c.setPrice(rs.getFloat("unit_price"));
                c.setSalePrice(rs.getFloat("sale_price"));
                
                listOrder.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    
}
