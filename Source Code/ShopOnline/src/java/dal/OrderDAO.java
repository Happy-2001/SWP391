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
import model.User;

public class OrderDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();
    public List<Orders> findByName(String query) {
        List<Orders> Orderlist = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `orders` WHERE status LIKE ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, "%" + query + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("order_id"));
                c.setOrderDate(rs.getString("order_date"));
                c.setRequireDate(rs.getString("require_date"));
                c.setShippedDate(rs.getString("shipped_date"));
                c.setCustomerId(rs.getInt("customerID"));
                c.setStatus(rs.getString("status"));
                Orderlist.add(c);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return Orderlist;
    }
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
                c.setCustomerId(rs.getInt("customerID"));
                c.setStatus(rs.getString("status"));
                Orderlist.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return Orderlist;
    }

    public List<Orders> listAllOderASC() {
        List<Orders> Orderlist = new ArrayList<>();
        String sql = "SELECT * FROM `orders` ORDER BY `order_id` DESC";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("order_id"));
                c.setOrderDate(rs.getString("order_date"));
                c.setRequireDate(rs.getString("require_date"));
                c.setShippedDate(rs.getString("shipped_date"));
                c.setCustomerId(rs.getInt("customerID"));
                c.setStatus(rs.getString("status"));
                Orderlist.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return Orderlist;
    }

    public List<Orders> listAllOderDESC() {
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
                c.setCustomerId(rs.getInt("customerID"));
                c.setStatus(rs.getString("status"));
                Orderlist.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<Orders> listOrderById(int id) {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT o.order_id, o.order_date, o.require_date,\n"
                + "o.shipped_date, o.status, o.shipperID, o.customerID,\n"
                + "d.quantity, p.product_name, p.sale_price, p.url\n"
                + "FROM orders o\n"
                + "INNER JOIN oder_details d on o.order_id = d.orderID\n"
                + "INNER JOIN products p on p.product_id = d.productID\n"
                + "WHERE order_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("o.order_id"));
                c.setOrderDate(rs.getString("o.order_date"));
                c.setRequireDate(rs.getString("o.require_date"));
                c.setShippedDate(rs.getString("o.shipped_date"));
                c.setStatus(rs.getString("o.status"));
                c.setShiperId(rs.getInt("o.shipperID"));
                c.setCustomerId(rs.getInt("o.customerID"));
                c.setQuantity(rs.getInt("d.quantity"));
                c.setProduct(new Product(rs.getString("p.product_name"),
                        rs.getFloat("p.sale_price"), rs.getString("p.url")));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }

    public ArrayList<Orders> getOrderByCusID(int cid) {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT * FROM orders o WHERE customerID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("o.order_id"));
                c.setOrderDate(rs.getString("o.order_date"));
                c.setRequireDate(rs.getString("o.require_date"));
                c.setShippedDate(rs.getString("o.shipped_date"));
                c.setStatus(rs.getString("o.status"));
                c.setShiperId(rs.getInt("o.shipperID"));
                c.setCustomerId(rs.getInt("o.customerID"));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    
    public Orders getOrderByID(int oid) {
        String sql = "SELECT o.order_id, o.order_date, o.require_date,\n" +
                    "o.shipped_date, o.status, o.shipperID, o.customerID,\n" +
                    "ua.first_name, ua.middle_name, ua.last_name\n" +
                    "FROM orders o\n" +
                    "INNER JOIN user_accounts ua ON o.customerID = ua.user_id\n" +
                    "WHERE order_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, oid);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("o.order_id"));
                c.setOrderDate(rs.getString("o.order_date"));
                c.setRequireDate(rs.getString("o.require_date"));
                c.setShippedDate(rs.getString("o.shipped_date"));
                c.setStatus(rs.getString("o.status"));
                c.setShiperId(rs.getInt("o.shipperID"));
                c.setUser(new User(rs.getInt("o.customerID"), rs.getString("ua.first_name"),
                        rs.getString("ua.middle_name"), rs.getString("ua.last_name")));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public Orders getOrderLatest() {
        String sql = "SELECT o.order_id, o.order_date, o.require_date,\n"
                + "o.shipped_date, o.status, o.shipperID, o.customerID,\n"
                + "ua.first_name, ua.middle_name, ua.last_name\n"
                + "FROM `orders` AS o\n"
                + "INNER JOIN `user_accounts` AS ua\n"
                + "ON o.customerID = ua.user_id\n"
                + "ORDER BY order_date DESC LIMIT 1";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("o.order_id"));
                c.setOrderDate(rs.getString("o.order_date"));
                c.setRequireDate(rs.getString("o.require_date"));
                c.setShippedDate(rs.getString("o.shipped_date"));
                c.setStatus(rs.getString("o.status"));
                c.setShiperId(rs.getInt("o.shipperID"));
                c.setUser(new User(rs.getInt("o.customerID"), rs.getString("ua.first_name"),
                        rs.getString("ua.middle_name"), rs.getString("ua.last_name")));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public Orders getLatestByCusID(int cid) {
        String sql = "SELECT o.order_id, o.order_date, o.require_date,\n"
                + "o.shipped_date, o.status, o.shipperID, o.customerID,\n"
                + "ua.first_name, ua.middle_name, ua.last_name\n"
                + "FROM `orders` AS o\n"
                + "INNER JOIN `user_accounts` AS ua\n"
                + "ON o.customerID = ua.user_id\n"
                + "WHERE o.customerID = ?\n"
                + "ORDER BY order_date DESC LIMIT 1";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("o.order_id"));
                c.setOrderDate(rs.getString("o.order_date"));
                c.setRequireDate(rs.getString("o.require_date"));
                c.setShippedDate(rs.getString("o.shipped_date"));
                c.setStatus(rs.getString("o.status"));
                c.setShiperId(rs.getInt("o.shipperID"));
                c.setUser(new User(rs.getInt("o.customerID"), rs.getString("ua.first_name"),
                        rs.getString("ua.middle_name"), rs.getString("ua.last_name")));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public Orders getLatestByID(int id) {
        String sql = "SELECT o.order_id, o.order_date, o.require_date,\n"
                + "o.shipped_date, o.status, o.shipperID, o.customerID,\n"
                + "ua.first_name, ua.middle_name, ua.last_name\n"
                + "FROM `orders` AS o\n"
                + "INNER JOIN `user_accounts` AS ua\n"
                + "ON o.customerID = ua.user_id\n"
                + "WHERE o.order_id = ?\n"
                + "ORDER BY order_date DESC LIMIT 1";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt("o.order_id"));
                c.setOrderDate(rs.getString("o.order_date"));
                c.setRequireDate(rs.getString("o.require_date"));
                c.setShippedDate(rs.getString("o.shipped_date"));
                c.setStatus(rs.getString("o.status"));
                c.setShiperId(rs.getInt("o.shipperID"));
                c.setUser(new User(rs.getInt("o.customerID"), rs.getString("ua.first_name"),
                        rs.getString("ua.middle_name"), rs.getString("ua.last_name")));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public void insertOrder(String date, int cid) {
        String sql = "INSERT INTO `orders`(`order_date`,`status`, `customerID`) VALUES (?, 'pending', ?)";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, date);
            statement.setInt(2, cid);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertOrderD(int qty, int oid, int pid) {
        String sql = "INSERT INTO `oder_details`(`quantity`, `orderID`, `productID`) VALUES (?,?,?)";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, qty);
            statement.setInt(2, oid);
            statement.setInt(3, pid);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatusOrder(String rdate, String sdate, String status, int cid) {
        String sql = "UPDATE `orders` SET `require_date`=?,`shipped_date`=?,`status`=? WHERE order_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, rdate);
            statement.setString(2, sdate);
            statement.setString(3, status);
            statement.setInt(4, cid);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Orders> getNotification(int id) {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT * FROM `orders` WHERE customerID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt(1));
                c.setOrderDate(rs.getString(2));
                c.setRequireDate(rs.getString(3));
                c.setShippedDate(rs.getString(4));
                c.setStatus(rs.getString(5));
                c.setShiperId(rs.getInt(7));
                c.setCustomerId(rs.getInt(8));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    public ArrayList<Orders> getStt2() {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT * FROM `orders` WHERE status = 'pending'";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt(1));
                c.setOrderDate(rs.getString(2));
                c.setRequireDate(rs.getString(3));
                c.setShippedDate(rs.getString(4));
                c.setStatus(rs.getString(5));
                c.setShiperId(rs.getInt(7));
                c.setCustomerId(rs.getInt(8));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    public ArrayList<Orders> getStt3() {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT * FROM `orders` WHERE status = 'completed'";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt(1));
                c.setOrderDate(rs.getString(2));
                c.setRequireDate(rs.getString(3));
                c.setShippedDate(rs.getString(4));
                c.setStatus(rs.getString(5));
                c.setShiperId(rs.getInt(7));
                c.setCustomerId(rs.getInt(8));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    public ArrayList<Orders> getStt4() {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT * FROM `orders` WHERE status = 'shipped'";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt(1));
                c.setOrderDate(rs.getString(2));
                c.setRequireDate(rs.getString(3));
                c.setShippedDate(rs.getString(4));
                c.setStatus(rs.getString(5));
                c.setShiperId(rs.getInt(7));
                c.setCustomerId(rs.getInt(8));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    public ArrayList<Orders> getStt5() {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT * FROM `orders` WHERE status = 'refunded'";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt(1));
                c.setOrderDate(rs.getString(2));
                c.setRequireDate(rs.getString(3));
                c.setShippedDate(rs.getString(4));
                c.setStatus(rs.getString(5));
                c.setShiperId(rs.getInt(7));
                c.setCustomerId(rs.getInt(8));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }
    public ArrayList<Orders> getStt6() {
        ArrayList<Orders> listOrder = new ArrayList<>();
        String sql = "SELECT * FROM `orders` WHERE status = 'canceled'";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders c = new Orders();
                c.setOrderID(rs.getInt(1));
                c.setOrderDate(rs.getString(2));
                c.setRequireDate(rs.getString(3));
                c.setShippedDate(rs.getString(4));
                c.setStatus(rs.getString(5));
                c.setShiperId(rs.getInt(7));
                c.setCustomerId(rs.getInt(8));

                listOrder.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listOrder;
    }

}
