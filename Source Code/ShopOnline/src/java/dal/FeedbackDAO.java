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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MyFeedback;
import model.Product;
import model.User;

/**
 *
 * @author dungk
 */
public class FeedbackDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

//    public List<MyFeedback> getFeedbackByDes(String seach) {
//        List<MyFeedback> statuses = new ArrayList<>();
//        String sql = "SELECT\n"
//                + "    user_account.full_name,\n"
//                + "    user_account.email,\n"
//                + "    user_account.phone,\n"
//                + "    products.product_name,\n"
//                + "    products.url,\n"
//                + "    feedback.star_rating,\n"
//                + "    feedback.description,\n"
//                + "    feedback.feedback_id,\n"
//                + "    feedback.User_Account_user_id\n"
//                + "FROM\n"
//                + "    feedback\n"
//                + "JOIN products products ON\n"
//                + "    feedback.products_product_id = products.product_id\n"
//                + "JOIN user_account ON feedback.User_Account_user_id = user_account.user_id WHERE feedback.description LIKE ? ";
//        try {
//            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
//            statement.setString(1, "%" + seach + "%");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                MyFeedback s = new MyFeedback();
//                s.setFeedback_id(rs.getInt("feedback_id"));
//                s.setUserid(rs.getInt("User_Account_user_id"));
//                s.setFull_name(rs.getString("full_name"));
//                s.setUrl(rs.getString("url"));
//                s.setProduct_name(rs.getString("product_name"));
//                s.setStar_rating(rs.getInt("star_rating"));
//                s.setDescription(rs.getString("description"));
//                s.setUsemail(rs.getString("email"));
//                s.setPhone(rs.getInt("phone"));
//                statuses.add(s);
//            }
//            return statuses;
//        } catch (SQLException e) {
//            System.out.println(e);
//        } finally {
//            mysqlConnect.disconnect();
//        }
//        return null;
//    }

    public int countPage() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `feedbacks`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL") / 9;
                if (rs.getInt("TOTAL") % 9 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }

    public List<MyFeedback> ListAllFeedback(int pageNumber) {
        List<MyFeedback> listAll = new ArrayList<>();
        try {
            String sql = "SELECT * FROM\n" +
                    "(SELECT ROW_NUMBER() OVER (ORDER BY f.createDate DESC) as rownum,\n" +
                    "f.feedback_id, f.description,\n" +
                    "f.status, f.createDate, f.star_rating,\n" +
                    "f.user_id, f.first_name, f.middle_name,\n" +
                    "f.last_name FROM\n" +
                    "(SELECT fb.feedback_id, fb.description,\n" +
                    "fb.status, fb.createDate, fb.star_rating,\n" +
                    "ua.user_id, ua.first_name, ua.middle_name,\n" +
                    "ua.last_name FROM `feedbacks` AS fb\n" +
                    "INNER JOIN `user_accounts` AS ua\n" +
                    "ON fb.`userID` = ua.`user_id`) AS f) as pPaging\n" +
                    "WHERE rownum BETWEEN ? AND ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 9) + 1);
            statement.setInt(2, (pageNumber * 9));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MyFeedback mf = new MyFeedback();
                mf.setFbID(rs.getInt(2));
                mf.setDescription(rs.getString(3));
                mf.setStatus(rs.getInt(4));
                mf.setCreateDate(rs.getString(5));
                mf.setRating(rs.getInt(6));
                mf.setUser(new User(rs.getInt(7), rs.getString(8),
                                    rs.getString(9), rs.getString(10)));
                
                listAll.add(mf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return listAll;
    }
    
    public int CountTask() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `feedbacks`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL");
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }
    
    public int TaskWork(int num) {
        int countPage = 0;
        String sql = "SELECT COUNT(*) AS TOTAL FROM `feedbacks` WHERE `feedbacks`.`status` = ?";

        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, num);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                countPage = rs.getInt("TOTAL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return countPage;
    }
    
    //SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY star_rating DESC) AS seq FROM `feedback`) as x WHERE seq BETWEEN 1 AND 2
//    public List<MyFeedback> getFbBySortRatePaging(int pageNumber, String order, String sort) {
//        List<MyFeedback> statuses = new ArrayList<>();
//        String sql = "SELECT * FROM (SELECT user_account.full_name, user_account.email, user_account.phone, products.product_name, products.url, feedback.star_rating,feedback.status,feedback.description, feedback.feedback_id, feedback.User_Account_user_id, ROW_NUMBER() OVER (ORDER BY " + order + " " + sort + ") AS seq FROM feedback JOIN products products ON feedback.products_product_id = products.product_id JOIN user_account ON feedback.User_Account_user_id = user_account.user_id) as x WHERE seq BETWEEN ? AND ?";
//        try {
//            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
//            statement.setInt(1, ((pageNumber - 1) * 2) + 1);
//            statement.setInt(2, (pageNumber * 2));
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                MyFeedback s = new MyFeedback();
//                s.setFeedback_id(rs.getInt("feedback_id"));
//                s.setUserid(rs.getInt("User_Account_user_id"));
//                s.setFull_name(rs.getString("full_name"));
//                s.setUrl(rs.getString("url"));
//                s.setProduct_name(rs.getString("product_name"));
//                s.setStar_rating(rs.getInt("star_rating"));
//                s.setDescription(rs.getString("description"));
//                s.setUsemail(rs.getString("email"));
//                s.setPhone(rs.getInt("phone"));
//                s.setStatus(rs.getInt("status"));
//                statuses.add(s);
//            }
//            return statuses;
//        } catch (SQLException ex) {
//            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            mysqlConnect.disconnect();
//        }
//        return null;
//    }

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
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

//    public List<MyFeedback> getCourseByPageNumber(int pageNumber) {
//        List<MyFeedback> statuses = new ArrayList<>();
//        String sql = "SELECT\n"
//                + "    user_account.full_name,\n"
//                + "    user_account.email,\n"
//                + "    user_account.phone,\n"
//                + "    products.product_name,\n"
//                + "    products.url,\n"
//                + "    feedback.star_rating,\n"
//                + "    feedback.description,\n"
//                + "    feedback.feedback_id,\n"
//                + "    feedback.User_Account_user_id\n"
//                + "FROM\n"
//                + "    feedback\n"
//                + "JOIN products products ON\n"
//                + "    feedback.products_product_id = products.product_id\n"
//                + "JOIN user_account ON feedback.User_Account_user_id = user_account.user_id    ;";
//        try {
//            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                MyFeedback s = new MyFeedback();
//                s.setFeedback_id(rs.getInt("feedback_id"));
//                s.setUserid(rs.getInt("User_Account_user_id"));
//                s.setFull_name(rs.getString("full_name"));
//                s.setUrl(rs.getString("url"));
//                s.setProduct_name(rs.getString("product_name"));
//                s.setStar_rating(rs.getInt("star_rating"));
//                s.setDescription(rs.getString("description"));
//                s.setUsemail(rs.getString("email"));
//                s.setPhone(rs.getInt("phone"));
//                statuses.add(s);
//            }
//            return statuses;
//        } catch (SQLException ex) {
//            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            mysqlConnect.disconnect();
//        }
//        return null;
//    }

    public MyFeedback getFeedbackById(int id) {
        String sql = "SELECT fb.feedback_id, fb.image1, fb.image2, fb.description,\n" +
                    "fb.note, fb.status, fb.createDate, fb.updateDate, fb.star_rating,\n" +
                    "ua.user_id, ua.user_name, ua.first_name, ua.middle_name,\n" +
                    "ua.last_name, eca.photo, eca.email, od.order_id\n" +
                    "FROM `feedbacks` AS fb\n" +
                    "INNER JOIN `user_accounts` AS ua ON fb.userID = ua.user_id\n" +
                    "INNER JOIN `orders` AS od ON fb.orderID = od.order_id\n" +
                    "INNER JOIN `electronicaddress` AS eca ON fb.userID = eca.eaID\n" +
                    "WHERE fb.feedback_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                MyFeedback s = new MyFeedback();
                s.setFbID(rs.getInt(1));
                s.setPhoto1(rs.getString(2));
                s.setPhoto2(rs.getString(3));
                s.setDescription(rs.getString(4));
                s.setNote(rs.getString(5));
                s.setStatus(rs.getInt(6));
                s.setCreateDate(rs.getString(7));
                s.setUpdateDate(rs.getString(8));
                s.setRating(rs.getInt(9));
                s.setUser(new User(rs.getInt(10), rs.getString(11),
                                    rs.getString(12), rs.getString(13),
                                    rs.getString(14), rs.getString(15), rs.getString(16)));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
