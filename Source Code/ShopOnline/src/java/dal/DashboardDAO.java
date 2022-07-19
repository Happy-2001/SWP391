
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Orders;
import model.Product;

/**
 *
 * @author anhvo
 */
public class DashboardDAO {
    
    DBConnect mysqlConnect = new DBConnect();
    
    public List<Orders> listOrderCategory() {
        List<Orders> list = new ArrayList<>();
        String sql = "SELECT COUNT(rs1.category_name) AS num, rs1.category_id, rs1.category_name, rs1.order_date FROM\n" +
"                   (SELECT p.product_id, p.product_name, pc.category_id,\n" +
"                   pc.category_name, pc.description, rs.orderID, rs.order_date\n" +
"                   FROM `products` AS p\n" +
"                   INNER JOIN `product_categories` AS pc ON p.category_id = pc.category_id\n" +
"                   INNER JOIN \n" +
"                   (SELECT * FROM `oder_details` AS od \n" +
"                   INNER JOIN `orders` as o\n" +
"                   ON od.orderID = o.order_id) AS rs\n" +
"                   ON p.product_id = rs.productID) AS rs1\n" +
"                   GROUP BY rs1.category_name";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setQuantity(rs.getInt("num"));
                o.setProduct(new Product(new Category(rs.getInt("rs1.category_id"), rs.getString("rs1.category_name"))));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public List<Orders> listCrderCateByDate(String from, String to) {
        List<Orders> list = new ArrayList<>();
        String sql = "SELECT COUNT(rs1.category_name) AS num, rs1.category_id, rs1.category_name, rs1.order_date FROM\n" +
                    "(SELECT p.product_id, p.product_name, pc.category_id,\n" +
                    "pc.category_name, pc.description, rs.orderID, rs.order_date\n" +
                    "FROM `products` AS p\n" +
                    "INNER JOIN `product_categories` AS pc ON p.category_id = pc.category_id\n" +
                    "INNER JOIN \n" +
                    "(SELECT * FROM `oder_details` AS od \n" +
                    "INNER JOIN `orders` as o\n" +
                    "ON od.orderID = o.order_id) AS rs\n" +
                    "ON p.product_id = rs.productID) AS rs1\n" +
                    "WHERE rs1.order_date BETWEEN ? AND ?\n" +
                    "GROUP BY rs1.category_name";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, from);
            statement.setString(2, to);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setProduct(new Product(new Category(rs.getInt("rs1.category_id"), rs.getString("rs1.category_name"))));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public int feedbackNum() {
        try {
            String sql = "SELECT COUNT(*) as total FROM `feedbacks`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("total");
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }
    
    public int StartNum() {
        try {
            String sql = "SELECT SUM(star_rating) as sum FROM `feedbacks`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("sum");
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }
    
    public int countOrder() {
        try {
            String sql = "SELECT COUNT(*) as total FROM `orders`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("total");
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }
    
    public int orderShipped() {
        try {
            String sql = "SELECT COUNT(*) as total FROM `orders` WHERE status = 'shipped'";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("total");
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }
}
