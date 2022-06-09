package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public User getUser(String email, String password) {  // cần update data cho table electoronicaddress, sau đó có thể sử dụng hàm này(sql hàm chưa làm lại)
        String sql = "SELECT * FROM `user_accounts` WHERE `email` = ? AND `password` = ?";   
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail("");
                u.setStatus(rs.getInt("status_id"));
                u.setCode(rs.getString("code"));
                u.setRole(rs.getString(4));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    
    public User getUserbyUserName(String username, String password) {  // cần update
        String sql = "SELECT * FROM `user_accounts` WHERE `user_name` = ? AND `password` = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone("");
                u.setEmail("");
                u.setStatus(rs.getInt("status_id"));
                u.setCode("");
                u.setRole("");
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
        String sql = "SELECT * FROM `user_accounts` WHERE `user_id` = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail("");
                u.setStatus(rs.getInt("status_id"));
                u.setCode("");
                u.setRole("");
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM `user_account` WHERE `email` = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail("");
                u.setStatus(rs.getInt("status_id"));
                u.setCode("");
                u.setRole("");
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
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail("");
                u.setStatus(rs.getInt("status_id"));
                u.setCode("");
                u.setRole("");
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
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail("");
                u.setStatus(rs.getInt("status_id"));
                u.setCode("");
                u.setRole("");
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
            String sql = "INSERT INTO `user_account` (`user_name`, `password`, `first_name`, `middle_name`, `last_name`, `gender`, `phone`, `email`, `status_id`, `code`, `authority_id`) \n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, u.getUsername());
            s.setString(2, u.getPassword());
            s.setString(3, u.getFirstname());
            s.setString(4, u.getMiddlename());
            s.setString(5, u.getLastname());
            s.setInt(6, u.getGender());
            s.setString(7, u.getPhone());
            s.setString(8, u.getEmail());
            s.setInt(9, u.getStatus());
            s.setString(10, u.getCode());
            s.setInt(11, 3);
            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void insertTimeLogin(String date) {
        try {
            String sql = "UPDATE `user_account` SET `lastLogin` = ? WHERE `user_account`.`user_id` = ?";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, date);
            s.setInt(2, u.getUserid());
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
                    + " `first_name` = ?,"
                    + " `middle_name` = ?,"
                    + " `last_name` = ?,"
                    + " `gender` = ?,"
                    + " `phone` = ?,"
                    + " `status_id` = ?,"
                    + " `authority_id` = ?,"
                    + " `password` = ?"
                    + " WHERE `user_account`.`user_id` = ?";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, u.getFirstname());
            s.setString(2, u.getMiddlename());
            s.setString(3, u.getLastname());
            s.setInt(4, u.getGender());
            s.setString(5, u.getPhone());
            s.setInt(6, u.getStatus());
            s.setInt(7, u.getAuthorityid());
            s.setString(8, u.getPassword());
            s.setInt(9, u.getUserid());

            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public List<User> searchUserByName(String name, String authority_id) {
        String[] wordName = name.split("\\s++");
        String firstName = wordName[0];
        String middleName = "";
        for (int i = 1; i < wordName.length - 1; i++) {
            middleName = wordName[i]+" ";

        }
        middleName = middleName.trim();
        String lastName = wordName[wordName.length - 1];

        String s = "";
        if (authority_id.length() > 0) {
            s = "AND authority_id = " + authority_id;
        }
        String sql = "SELECT * FROM `user_account` WHERE `first_name` LIKE ? AND `middle_name` LIKE ? AND `last_name` LIKE ?" + s;
        try {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, "%" + firstName + "%");
            statement.setString(2, "%" + middleName + "%");
            statement.setString(3, "%" + lastName + "%");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
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
        UserDAO udb = new UserDAO();
        User u = udb.getUserById(1); 
        System.out.println(u.getFullname());

    }
}
