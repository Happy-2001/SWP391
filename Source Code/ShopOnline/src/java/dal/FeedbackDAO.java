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
import model.MyFeedback;
import model.Product;

/**
 *
 * @author dungk
 */
public class FeedbackDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public List<MyFeedback> getAllFeedback() {
        List<MyFeedback> statuses = new ArrayList<>();
        String sql = "SELECT\n"
                + "    user_account.full_name,\n"
                + "    user_account.email,\n"
                + "    user_account.phone,\n"
                + "    products.product_name,\n"
                + "    products.url,\n"
                + "    feedback.star_rating,\n"
                + "    feedback.description,\n"
                + "    feedback.feedback_id,\n"
                + "    feedback.User_Account_user_id\n"
                + "FROM\n"
                + "    feedback\n"
                + "JOIN products products ON\n"
                + "    feedback.products_product_id = products.product_id\n"
                + "JOIN user_account ON feedback.User_Account_user_id = user_account.user_id;";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MyFeedback s = new MyFeedback();
                s.setFeedback_id(rs.getInt("feedback_id"));
                s.setUserid(rs.getInt("User_Account_user_id"));
                s.setFull_name(rs.getString("full_name"));
                s.setUrl(rs.getString("url"));
                s.setProduct_name(rs.getString("product_name"));
                s.setStar_rating(rs.getInt("star_rating"));
                s.setDescription(rs.getString("description"));
                s.setUsemail(rs.getString("email"));
                s.setPhone(rs.getInt("phone"));
                statuses.add(s);
            }
            return statuses;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public List<MyFeedback> getFeedbackByDes(String seach) {
        List<MyFeedback> statuses = new ArrayList<>();
        String sql = "SELECT\n"
                + "    user_account.full_name,\n"
                + "    user_account.email,\n"
                + "    user_account.phone,\n"
                + "    products.product_name,\n"
                + "    products.url,\n"
                + "    feedback.star_rating,\n"
                + "    feedback.description,\n"
                + "    feedback.feedback_id,\n"
                + "    feedback.User_Account_user_id\n"
                + "FROM\n"
                + "    feedback\n"
                + "JOIN products products ON\n"
                + "    feedback.products_product_id = products.product_id\n"
                + "JOIN user_account ON feedback.User_Account_user_id = user_account.user_id WHERE feedback.description LIKE ? ";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, "%" + seach + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MyFeedback s = new MyFeedback();
                s.setFeedback_id(rs.getInt("feedback_id"));
                s.setUserid(rs.getInt("User_Account_user_id"));
                s.setFull_name(rs.getString("full_name"));
                s.setUrl(rs.getString("url"));
                s.setProduct_name(rs.getString("product_name"));
                s.setStar_rating(rs.getInt("star_rating"));
                s.setDescription(rs.getString("description"));
                s.setUsemail(rs.getString("email"));
                s.setPhone(rs.getInt("phone"));
                statuses.add(s);
            }
            return statuses;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public int countPage() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `feedback`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL") / 2;
                if (rs.getInt("TOTAL") % 2 != 0) {
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

    //SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY star_rating DESC) AS seq FROM `feedback`) as x WHERE seq BETWEEN 1 AND 2
    public List<MyFeedback> getFbBySortRatePaging(int pageNumber, String order, String sort) {
        List<MyFeedback> statuses = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT user_account.full_name, user_account.email, user_account.phone, products.product_name, products.url, feedback.star_rating,feedback.status,feedback.description, feedback.feedback_id, feedback.User_Account_user_id, ROW_NUMBER() OVER (ORDER BY " + order + " " + sort + ") AS seq FROM feedback JOIN products products ON feedback.products_product_id = products.product_id JOIN user_account ON feedback.User_Account_user_id = user_account.user_id) as x WHERE seq BETWEEN ? AND ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 2) + 1);
            statement.setInt(2, (pageNumber * 2));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MyFeedback s = new MyFeedback();
                s.setFeedback_id(rs.getInt("feedback_id"));
                s.setUserid(rs.getInt("User_Account_user_id"));
                s.setFull_name(rs.getString("full_name"));
                s.setUrl(rs.getString("url"));
                s.setProduct_name(rs.getString("product_name"));
                s.setStar_rating(rs.getInt("star_rating"));
                s.setDescription(rs.getString("description"));
                s.setUsemail(rs.getString("email"));
                s.setPhone(rs.getInt("phone"));
                s.setStatus(rs.getInt("status"));
                statuses.add(s);
            }
            return statuses;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    //INSERT INTO `feedback` (`feedback_id`, `description`, `User_Account_user_id`, `products_product_id`, `star_rating`) VALUES (NULL, 'FUC', '2', '9', '4');
    public void addFB(String des, int uid, int pid, int rate) {
        String sql = "INSERT INTO `feedback` (`description`, `User_Account_user_id`, `products_product_id`, `star_rating`,`note`, `status` ) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, des);
            statement.setInt(2, uid);
            statement.setInt(3, pid);
            statement.setInt(4, rate);
            statement.setString(5, "");
            statement.setInt(6, 0);
            statement.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public List<MyFeedback> getCourseByPageNumber(int pageNumber) {
        List<MyFeedback> statuses = new ArrayList<>();
        String sql = "SELECT\n"
                + "    user_account.full_name,\n"
                + "    user_account.email,\n"
                + "    user_account.phone,\n"
                + "    products.product_name,\n"
                + "    products.url,\n"
                + "    feedback.star_rating,\n"
                + "    feedback.description,\n"
                + "    feedback.feedback_id,\n"
                + "    feedback.User_Account_user_id\n"
                + "FROM\n"
                + "    feedback\n"
                + "JOIN products products ON\n"
                + "    feedback.products_product_id = products.product_id\n"
                + "JOIN user_account ON feedback.User_Account_user_id = user_account.user_id    ;";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MyFeedback s = new MyFeedback();
                s.setFeedback_id(rs.getInt("feedback_id"));
                s.setUserid(rs.getInt("User_Account_user_id"));
                s.setFull_name(rs.getString("full_name"));
                s.setUrl(rs.getString("url"));
                s.setProduct_name(rs.getString("product_name"));
                s.setStar_rating(rs.getInt("star_rating"));
                s.setDescription(rs.getString("description"));
                s.setUsemail(rs.getString("email"));
                s.setPhone(rs.getInt("phone"));
                statuses.add(s);
            }
            return statuses;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public MyFeedback getFeedbackById(int id) {
        String sql = "SELECT\n"
                + "    user_account.full_name,\n"
                + "    user_account.email,\n"
                + "    user_account.phone,\n"
                + "    products.product_name,\n"
                + "    products.url,\n"
                + "    feedback.star_rating,\n"
                + "    feedback.description,\n"
                + "    feedback.feedback_id,\n"
                + "    feedback.note,\n"
                + "    feedback.User_Account_user_id\n"
                + "FROM\n"
                + "    feedback\n"
                + "JOIN products products ON\n"
                + "    feedback.products_product_id = products.product_id\n"
                + "JOIN user_account ON feedback.User_Account_user_id = user_account.user_id "
                + "WHERE feedback.feedback_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                MyFeedback s = new MyFeedback();
                s.setFeedback_id(rs.getInt("feedback_id"));
                s.setUserid(rs.getInt("User_Account_user_id"));
                s.setFull_name(rs.getString("full_name"));
                s.setUrl(rs.getString("url"));
                s.setProduct_name(rs.getString("product_name"));
                s.setStar_rating(rs.getInt("star_rating"));
                s.setDescription(rs.getString("description"));
                s.setUsemail(rs.getString("email"));
                s.setPhone(rs.getInt("phone"));
                s.setNote(rs.getString("note"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public void updateFb(String note, int id) {
        try {
            String sql = "UPDATE `feedback` SET `note` = ? WHERE `feedback`.`feedback_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, note);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void updateFbStatus(int id, int st) {
        String query = "UPDATE `feedback` SET `status` = ? WHERE `feedback`.`feedback_id` = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
            statement.setInt(1, st);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        FeedbackDAO dao = new FeedbackDAO();
        List<MyFeedback> statuses = dao.getFbBySortRatePaging(1, "full_name", "");
        for (MyFeedback o : statuses) {
            System.out.println(o);
        }
    }
}
