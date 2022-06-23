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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.CartContact;
import model.Product;

/**
 *
 * @author Admin
 */
public class CartDAO {
    DBConnect mysqlConnect = new DBConnect();

    public ArrayList<Cart> listById(int id) {
        ArrayList<Cart> cart = new ArrayList<>();
        String sql = "SELECT p.product_id, p.product_name, \n" +
                    "p.category_id, p.unit_price, p.sale_price, \n" +
                    "p.unitsln_stock, p.brief_information, \n" +
                    "p.description, p.url, rs.userID, \n" +
                    "rs.item_id, rs.quantity, rs.cartID, rs.status \n" +
                    "FROM `products` as p JOIN\n" +
                    "(SELECT ci.item_id, ci.quantity, ci.productID, \n" +
                    "c.cartID, c.status, c.createDate, c.updateDate, c.userID \n" +
                    "FROM `cart_items` as ci JOIN `carts` as c\n" +
                    "ON ci.cartID = c.cartID) as rs\n" +
                    "ON p.product_id = rs.productID\n" +
                    "WHERE userID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setItemId(rs.getInt("rs.item_id"));
                c.setProduct(new Product(rs.getInt("p.product_id"), rs.getString("p.product_name"), 
                                        rs.getInt("p.category_id"), rs.getFloat("p.unit_price"),
                                        rs.getFloat("p.sale_price"), rs.getInt("p.unitsln_stock"),
                                        rs.getString("p.brief_information"), rs.getString("p.description"), rs.getString("p.url")));
                c.setQuantity(rs.getInt("rs.quantity"));
                c.setStatus(rs.getString("rs.status"));
                c.setUserId(rs.getInt("rs.userID"));
                cart.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return cart;
    }
    
     public ArrayList<Cart> listByItemId(String id) {
        ArrayList<Cart> cart = new ArrayList<>();
        String sql = "SELECT pd.product_id, pd.product_name,\n" +
                    "pd.category_id, pd.unit_price, pd.sale_price,\n" +
                    "pd.unitsln_stock, pd.brief_information,\n" +
                    "pd.description, pd.url, rs1.userID,\n" +
                    "rs1.item_id, rs1.quantity, rs1.cartID, rs1.status\n" +
                    "FROM `products` as pd JOIN\n" +
                    "(SELECT ci.item_id, ci.quantity, ci.productID,\n" +
                    "c.cartID, c.status, c.createDate, c.updateDate, c.userID\n" +
                    "FROM `cart_items` as ci JOIN `carts` as c\n" +
                    "ON ci.cartID = c.cartID) as rs1\n" +
                    "ON pd.product_id = rs1.productID\n" +
                    "WHERE item_id in (?)";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setItemId(rs.getInt("rs1.item_id"));
                c.setProduct(new Product(rs.getInt("pd.product_id"), rs.getString("pd.product_name"), 
                                        rs.getInt("pd.category_id"), rs.getFloat("pd.unit_price"),
                                        rs.getFloat("pd.sale_price"), rs.getInt("pd.unitsln_stock"),
                                        rs.getString("pd.brief_information"), rs.getString("pd.description"),
                                        rs.getString("pd.url")));
                c.setQuantity(rs.getInt("rs1.quantity"));
                c.setStatus(rs.getString("rs1.status"));
                c.setUserId(rs.getInt("rs1.userID"));
                cart.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return cart;
    }
    
    public void updateCart(int qty, int id) {
        try {
            String sql = "UPDATE `cart_items` SET `quantity`= ? WHERE item_id = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, qty);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    public void deleteCart(int id) {
        try {
            String sql = "DELETE FROM `cart_items` WHERE item_id = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public Cart getCartById(int id) {
        String sql = "SELECT `item_id`, `quantity`, `cartID`, `productID` FROM `cart_items` WHERE cartID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Cart c = new Cart();
                c.setItemId(rs.getInt("rs.item_id"));
                c.setProduct(new Product(rs.getInt("p.product_id"), rs.getString("p.product_name"), 
                                        rs.getInt("p.category_id"), rs.getFloat("p.unit_price"),
                                        rs.getFloat("p.sale_price"), rs.getInt("p.unitsln_stock"),
                                        rs.getString("p.brief_information"), rs.getString("p.description"), rs.getString("p.url")));
                c.setQuantity(rs.getInt("rs.quantity"));
                c.setStatus(rs.getString("rs.status"));
                c.setUserId(rs.getInt("rs.userID"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    
    public CartContact getCartContactById(int id) {
        String sql = "SELECT `user_id`, `status`, `full_name`, `phone`, `email`, `address` FROM `cart` WHERE user_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                CartContact c = new CartContact();
                c.setUser_id(rs.getInt("user_id"));
                c.setStatus(rs.getString("status"));
                c.setFull_name(rs.getString("full_name"));
                c.setPhone(rs.getInt("phone"));
                c.setEmail(rs.getString("email"));
                c.setAddress(rs.getString("address"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public int numOfItems(int cid){
        int num = 0;
        String sql = "SELECT COUNT(item_id) as num FROM `cart_items` WHERE cart_items.cartID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            num = rs.getInt("num");
 
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    
    public int checkId(int id, ArrayList<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

}
