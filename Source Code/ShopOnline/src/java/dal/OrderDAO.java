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
import model.Orders;
import model.Product;

/**
 *
 * @author dungk
 */
public class OrderDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public List<Orders> listAllOder() {
        List<Orders> Orderlist = new ArrayList<>();
        String sql = "SELECT * FROM `orders` ORDER BY `order_id` ASC";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("order_id"));
                c.setOrderDate(rs.getString("order_date")); 
                c.setRequireDate(rs.getString("require_date"));
                c.setShippedDate(rs.getString("shipped_date"));
                c.setCustomer_id(rs.getInt("customerID"));
                c.setEmployee_id(rs.getInt("employee_id"));
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
     

    
    public ArrayList<Orders> getOrderById(int id) {
        ArrayList<Orders> listOrder =new  ArrayList<>();
        String sql = "select o.order_id, o.order_date, p.product_name,p.unit_price, d.quantity, d.amount from orders o "
                + "JOIN oder_details d on o.order_id = d.orderID "
                + "JOIN products p on p.product_id = d.productID "
                + " WHERE order_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("order_id"));
                c.setOrderDate(rs.getString("order_date")); 
                c.setProduct_name(rs.getString("product_name"));
                c.setUnit_price(rs.getInt("unit_price"));
                c.setQuantity(rs.getInt("quantity"));
                listOrder.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    public static void main(String[] args) {
         OrderDAO udb = new OrderDAO();
         ArrayList<Orders> Orderlist = udb.getOrderById(1);
         for (Orders orders : Orderlist) {
             System.out.println(orders.getProduct_name());
             
        }
         
    }
    
}
