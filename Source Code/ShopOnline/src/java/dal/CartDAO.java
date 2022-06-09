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
import model.Cart;
import model.CartContact;

/**
 *
 * @author Admin
 */
public class CartDAO {
    DBConnect mysqlConnect = new DBConnect();
    public List<Cart> listAll() {
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `item_id`, `product_id`, `product_name`, `url`, "
                + "`unit_price`, `quantity`, `Cart_user_id` FROM `cart_item`\n";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setItem_id(rs.getInt("item_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setUrl(rs.getString("url"));
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCart_user_id(rs.getInt("Cart_user_id"));
                cart.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return cart;
    }
    public List<Cart> listById(int id) {
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `item_id`, `product_id`, `product_name`, `url`, "
                + "`unit_price`, `quantity`, `Cart_user_id` FROM `cart_item`\n" +
                   "WHERE Cart_user_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setItem_id(rs.getInt("item_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setUrl(rs.getString("url"));
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCart_user_id(rs.getInt("Cart_user_id"));
                cart.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return cart;
    }
    public void updateCart(int qty, int id) {
        try {
            String sql = "UPDATE `cart_item` SET `quantity`= ? WHERE cart_item.item_id = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, qty);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public int getAmount(){
        int sum = 0;
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `unit_price`, `quantity` FROM `cart_item`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                sum = sum + (p.getUnit_price() * p.getQuantity());
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return sum;
    }
    public int getAmountByID(int id){
        int sum = 0;
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `unit_price`, `quantity` FROM `cart_item` WHERE cart_item.Cart_user_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                sum = sum + (p.getUnit_price() * p.getQuantity());
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return sum;
    }
    public void deleteCart(int id) {
        try {
            String sql = "DELETE FROM `cart_item` WHERE cart_item.item_id = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public Cart getCartById(int id) {
        String sql = "SELECT `item_id`, `quantity` FROM `cart_item` WHERE item_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Cart u = new Cart();
                u.setQuantity(rs.getInt("qty"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
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
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
}
/*public class CartDAO {
    DBConnect mysqlConnect = new DBConnect();
    public List<Cart> listAll() {
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `item_id`, `product_id`, `product_name`, `url`, "
                + "`unit_price`, `quantity`, `Cart_user_id` FROM `cart_item`\n";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setItem_id(rs.getInt("item_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setUrl(rs.getString("url"));
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCart_user_id(rs.getInt("Cart_user_id"));
                cart.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return cart;
    }
    public List<Cart> listById(int id) {
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `item_id`, `product_id`, `product_name`, `url`, "
                + "`unit_price`, `quantity`, `Cart_user_id` FROM `cart_item`\n" +
                   "WHERE Cart_user_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setItem_id(rs.getInt("item_id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setUrl(rs.getString("url"));
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCart_user_id(rs.getInt("Cart_user_id"));
                cart.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return cart;
    }
    public void updateCart(int qty, int id) {
        try {
            String sql = "UPDATE `cart_item` SET `quantity`= ? WHERE cart_item.item_id = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, qty);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public int getAmount(){
        int sum = 0;
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `unit_price`, `quantity` FROM `cart_item`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                sum = sum + (p.getUnit_price() * p.getQuantity());
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return sum;
    }
    public int getAmountByID(int id){
        int sum = 0;
        List<Cart> cart = new ArrayList<>();
        String sql = "SELECT `unit_price`, `quantity` FROM `cart_item` WHERE cart_item.Cart_user_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart p = new Cart();
                p.setUnit_price(rs.getInt("unit_price"));
                p.setQuantity(rs.getInt("quantity"));
                sum = sum + (p.getUnit_price() * p.getQuantity());
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return sum;
    }
    public void deleteCart(int id) {
        try {
            String sql = "DELETE FROM `cart_item` WHERE cart_item.item_id = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public Cart getCartById(int id) {
        String sql = "SELECT `item_id`, `quantity` FROM `cart_item` WHERE item_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Cart u = new Cart();
                u.setQuantity(rs.getInt("qty"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
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
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
}*/
