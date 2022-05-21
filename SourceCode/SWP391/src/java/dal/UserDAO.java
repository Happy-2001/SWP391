package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public User getUser(String email, String password) {
        String sql = "SELECT * FROM `user_account` WHERE `email` = ? AND `password` = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(password);
                u.setFullname(rs.getString("full_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(email);
                u.setStatus(rs.getInt("status_id"));
                u.setCode(rs.getString("code"));
                u.setAuthorityid(rs.getInt("authority_id"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public User getUserById(String id) {
        String sql = "SELECT * FROM `user_account` WHERE `user_id` = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setFullname(rs.getString("full_name"));
                u.setGender(rs.getInt("gender"));
                u.setPassword(rs.getNString("password"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
                u.setAuthorityid(rs.getInt("authority_id"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public List<User> listUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM `user_account` WHERE authority_id = 2;";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setFullname(rs.getString("full_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setAuthorityid(rs.getInt("authority_id"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public List<User> listUserCustomer() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM `user_account` WHERE authority_id = 3;";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setFullname(rs.getString("full_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setAuthorityid(rs.getInt("authority_id"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    //false ton tai email hoac username
    public boolean existedMember(User user, List<User> listUser) {
        for (User u : listUser) {
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                return false;
            }
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                return false;
            }
        }
        return true;
    }

    public void insert(User u) {
        try {
            String sql = "INSERT INTO `user_account` (`user_name`, `password`, `full_name`, `gender`, `phone`, `email`, `status_id`, `code`, `authority_id`) \n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, u.getUsername());
            s.setString(2, u.getPassword());
            s.setString(3, u.getFullname());
            s.setInt(4, u.getGender());
            s.setString(5, u.getPhone());
            s.setString(6, u.getEmail());
            s.setInt(7, u.getStatus());
            s.setString(8, u.getCode());
            s.setInt(9, 3);
            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void updateCf(User u, String status) {
        try {
            String sql = "UPDATE `user_account` SET `status_id` = ? WHERE `user_account`.`user_id` = ?";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, status);
            s.setInt(2, u.getUserid());
            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void update(User u) {
        try {
            String sql = "UPDATE `user_account` SET"
                    + " `full_name` = ?,"
                    + " `gender` = ?,"
                    + " `phone` = ?,"
                    + " `status_id` = ?,"
                    + " `authority_id` = ?,"
                    + " `password` = ?"
                    + " WHERE `user_account`.`user_id` = ?";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, u.getFullname());
            s.setInt(2, u.getGender());
            s.setString(3, u.getPhone());
            s.setInt(4, u.getStatus());
            s.setInt(5, u.getAuthorityid());
            s.setString(6, u.getPassword());
            s.setInt(7, u.getUserid());

            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public List<User> searchUserByName(String name, String authority_id) {
        String s = "";
        if (authority_id.length() > 0) {
            s = "AND authority_id = " + authority_id;
        }
        String sql = "SELECT * FROM `user_account` WHERE `full_name` LIKE ? " + s;
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setFullname(rs.getString("full_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
                u.setAuthorityid(rs.getInt("authority_id"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    //Column count doesn't match value count at row 1
    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        System.out.println(udao.searchUserByName("dat", ""));
    }
}
