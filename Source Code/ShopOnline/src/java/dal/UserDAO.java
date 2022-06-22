package dal;
//test merge

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public User getUser(String email, String password) {  // cần update data cho table electoronicaddress, sau đó có thể sử dụng hàm này(sql hàm chưa làm lại) done
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "ON ua.userID = ac.user_id) AS rs1\n"
                + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID\n"
                + "WHERE email = ? AND password = ?";
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
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public User getUserbyUserName(String username, String password) {  // cần update   Ok updated
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "ON ua.userID = ac.user_id) AS rs1\n"
                + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID\n"
                + "WHERE user_name = ? AND password = ?";
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
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
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
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "ON ua.userID = ac.user_id) AS rs1\n"
                + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID\n"
                + "WHERE user_id = ?";
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
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "ON ua.userID = ac.user_id) AS rs1\n"
                + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID\n"
                + "WHERE email = ?";
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
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
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
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id AS status_id FROM\n"
                + "(SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "ON ua.userID = ac.user_id) AS rs1\n"
                + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) AS rs2\n"
                + "INNER JOIN user_role AS  ur ON ur.userID = rs2.user_id \n"
                + "WHERE ur.roleID = 2";
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
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
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
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id FROM\n"
                + "(SELECT roleID,user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id AS status_id FROM\n"
                + "                (SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "                (SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "                ON ua.userID = ac.user_id) AS rs1\n"
                + "                INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) AS rs2\n"
                + "                INNER JOIN user_role AS  ur ON ur.userID = rs2.user_id )AS rs3\n"
                + "                INNER JOIN roles ON roles.roleID = rs3.roleID\n"
                + "                WHERE roles.name LIKE \"%customer%\"";
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
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
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

    public List<User> listUserAdmin() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id FROM\n"
                + "(SELECT roleID,user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id AS status_id FROM\n"
                + "                (SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "                (SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "                ON ua.userID = ac.user_id) AS rs1\n"
                + "                INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) AS rs2\n"
                + "                INNER JOIN user_role AS  ur ON ur.userID = rs2.user_id )AS rs3\n"
                + "                INNER JOIN roles ON roles.roleID = rs3.roleID\n"
                + "                WHERE roles.name LIKE \"%admin%\"";
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
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
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
    //get list Admin id
    public List<String> listUserAdminID() {
        List<String> listUserAdminID = new ArrayList<>();
        String sql = "SELECT user_id FROM\n"
                + "(SELECT roleID,user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id AS status_id FROM\n"
                + "                (SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "                (SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "                ON ua.userID = ac.user_id) AS rs1\n"
                + "                INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) AS rs2\n"
                + "                INNER JOIN user_role AS  ur ON ur.userID = rs2.user_id )AS rs3\n"
                + "                INNER JOIN roles ON roles.roleID = rs3.roleID\n"
                + "                WHERE roles.name LIKE \"%admin%\"";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                
                listUserAdminID.add(rs.getString(1));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return listUserAdminID;
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
            s.setInt(11, 3);
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
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void updateProfile(int id, String pass, String fname, String dname, String lname, int gender) {
        try {
            String sql = "UPDATE `user_accounts` SET \n"
                    + "`password` = ?,         \n"
                    + "`first_name` = ?,       \n"
                    + "`middle_name` = ?,      \n"
                    + "`last_name` = ?,        \n"
                    + "`gender` = ?            \n"
                    + "WHERE user_id = ?;";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, pass);
            s.setString(2, fname);
            s.setString(3, dname);
            s.setString(4, lname);
            s.setInt(5, gender);
            s.setInt(6, id);

            s.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> searchUserByName(String name, String authority_id) {
        String[] wordName = name.split("\\s++");
        String firstName = wordName[0];
        String middleName = "";
        for (int i = 1; i < wordName.length - 1; i++) {
            middleName = wordName[i] + " ";

        }
        middleName = middleName.trim();
        String lastName = wordName[wordName.length - 1];

        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "ON ua.userID = ac.user_id) AS rs1\n"
                + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID\n"
                + "WHERE  `first_name` LIKE ? AND `middle_name` LIKE ? AND `last_name` LIKE ?";
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
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
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

    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        List<String> list = udao.listUserAdminID();
        for (String string : list) {
            System.out.println(string);
        }
    }
}
