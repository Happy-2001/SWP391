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
import model.Category;
import model.Orderlist;
import model.Product;

/**
 *
 * @author dungk
 */
public class OrderDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public List<Orderlist> listAllOder() {
        List<Orderlist> Orderlist = new ArrayList<>();
        String sql = "SELECT * FROM `order` ORDER BY `order_id` ASC";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orderlist c = new Orderlist();
                c.setOrder_id(rs.getInt("order_id"));
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setName_receiver(rs.getString("name_receiver"));
                c.setPhone(rs.getInt("phone"));
                c.setAddress(rs.getString("address"));
                c.setEmail(rs.getString("email"));
                c.setEmployee_id(rs.getInt("employee_id"));        
                c.setOrder_date(rs.getDate("order_date")); 
                c.setShipped_date(rs.getDate("shipped_date"));
                c.setNote(rs.getString("status"));
                c.setStatus(rs.getString("note"));
        
                Orderlist.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return Orderlist;
    }
     public List<Orderlist> searchOrderByName(String name) {
        List<Orderlist> Orderlist = new ArrayList<>();
        String sql = "SELECT * FROM `order` WHERE `name_receiver` LIKE ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);                       
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
          
            while (rs.next()) {
                Orderlist c = new Orderlist();
                c.setOrder_id(rs.getInt("order_id"));
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setName_receiver(rs.getString("name_receiver"));
                c.setPhone(rs.getInt("phone"));
                c.setAddress(rs.getString("address"));
                c.setEmail(rs.getString("email"));
                c.setEmployee_id(rs.getInt("employee_id"));        
                c.setOrder_date(rs.getDate("order_date")); 
                c.setShipped_date(rs.getDate("shipped_date"));
                c.setNote(rs.getString("status"));
                c.setStatus(rs.getString("note"));
        
                Orderlist.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return Orderlist;
    }
     // phân trang 
      public int countPage() {
        ArrayList<Product> dummies = new ArrayList<>();
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `feedback`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL") / 6;
                if (rs.getInt("TOTAL") % 6 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }
     
      public List<Orderlist> getFeedbackByPageNumber() {
        List<Orderlist> Orderlist = new ArrayList<>();
        String sql = "SELECT * FROM `order` ORDER BY `order_id` ASC";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orderlist c = new Orderlist();
                c.setOrder_id(rs.getInt("order_id"));
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setName_receiver(rs.getString("name_receiver"));
                c.setPhone(rs.getInt("phone"));
                c.setAddress(rs.getString("address"));
                c.setEmail(rs.getString("email"));
                c.setEmployee_id(rs.getInt("employee_id"));        
                c.setOrder_date(rs.getDate("order_date")); 
                c.setShipped_date(rs.getDate("shipped_date"));
                c.setNote(rs.getString("status"));
                c.setStatus(rs.getString("note"));
        
                Orderlist.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return Orderlist;
    }
    public Orderlist listOrderById(int id) {
        Orderlist c = new Orderlist();
        String sql = "SELECT `order_id`, `name_receiver`, `phone`, `order_date`, `email`, `address`, `note` \n" +
                    "FROM `order` \n" +
                    "WHERE order_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                
                c.setOrder_id(rs.getInt("order_id"));
                c.setName_receiver(rs.getString("name_receiver"));
                c.setPhone(rs.getInt("phone"));
                c.setOrder_date(rs.getDate("order_date")); 
                c.setAddress(rs.getString("address"));
                c.setEmail(rs.getString("email"));   
                c.setStatus(rs.getString("note"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return c;
    }
    public Orderlist getOrderById(int id) {
        Orderlist c = new Orderlist();
        String sql = "SELECT o.`order_id`, o.`order_date`, p.product_name, d.unit_price, d.quantity, o.`status`\n" +
                    "FROM `order` o\n" +
                    "JOIN `oder_details` d ON o.`order_id` = d.`order_id`\n" +
                    "JOIN `products` p ON p.product_id = d.product_id\n" +
                    "WHERE o.order_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                c.setOrder_id(rs.getInt("order_id"));
                c.setOrder_date(rs.getDate("order_date")); 
                c.setProduct_name(rs.getString("product_name"));
                c.setUnit_price(rs.getInt("unit_price"));
                c.setQuantity(rs.getInt("quantity"));
                c.setStatus(rs.getString("status"));   
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return c;
    }
    public static void main(String[] args) {
         OrderDAO udb = new OrderDAO();
        List<Orderlist> Orderlist = udb.searchOrderByName("Nguyen");
         System.out.println(Orderlist);
    }
}
