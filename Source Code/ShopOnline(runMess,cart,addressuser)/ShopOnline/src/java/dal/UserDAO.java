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
import model.Address;
import model.Customers;
import model.Provinces;
import model.Role;
import model.RoleUser;
import model.User;
import model.UserAddress;

public class UserDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String getTime = (dtf.format(now));

    public User getUserRole(String username) { //phan nay can dung, dung ai xoa      Ok toi se khong xoa dau!!!
        try {
            String sql = "SELECT ua.user_id, ua.user_name, roleID, name FROM `user_accounts` as ua JOIN\n"
                    + "(SELECT ur.roleID, name, ur.userID FROM `user_role` as ur \n"
                    + "JOIN `roles` as r ON ur.roleID = r.roleID) as rs\n"
                    + "ON ua.user_id = rs.userID WHERE ua.user_name = ?";

            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("ua.user_id"));
                u.setUsername(rs.getString("ua.user_name"));
                u.setAuthority(new Role(rs.getInt("roleID"), rs.getString("name")));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public User getUserByMessageID(String messageID) {
        User u = new User();
        try {
            String sql = "SELECT ua.* FROM messages m INNER JOIN user_accounts ua \n"
                    + "ON ua.user_id = m.creatorID \n"
                    + "INNER JOIN user_role ur \n"
                    + "ON ur.userID = ua.user_id\n"
                    + "INNER JOIN roles r\n"
                    + "ON r.roleID = ur.roleID\n"
                    + "WHERE r.name LIKE 'Admin' and messageID = ?";

            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, messageID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {

                u.setUserid(rs.getInt(1));
                u.setLastname(rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return u;
    }

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
        String sql = "SELECT ua.user_name,ua.password,ua.first_name,ua.middle_name,ua.last_name,ua.gender,ea.telephone FROM user_accounts as ua\n"
                + "INNER JOIN user_address as uad on ua.user_id=uad.userID\n"
                + "INNER JOIN electronicaddress as ea on ea.eaID=uad.eaID\n"
                + "where ea.email like ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUsername(rs.getString("ua.user_name"));
                u.setPassword(rs.getString("ua.password"));
                u.setFirstname(rs.getString("ua.first_name"));
                u.setMiddlename(rs.getString("ua.middle_name"));
                u.setLastname(rs.getString("ua.last_name"));
                u.setGender(rs.getInt("ua.gender"));
                u.setPhone(rs.getString("ea.telephone"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public String getUserByUserName(String username) {
        String userID = "";
        String sql = "SELECT user_id FROM `user_accounts` WHERE user_name  = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userID = rs.getString(1);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return userID;
    }

    public List<User> listUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id FROM\n"
                + "(SELECT roleID,user_id,user_name,`password`,first_name,middle_name,last_name,gender,phone,email,status_id AS status_id FROM\n"
                + "                (SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                + "                (SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                + "                ON ua.userID = ac.user_id) AS rs1\n"
                + "                INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) AS rs2\n"
                + "                INNER JOIN user_role AS  ur ON ur.userID = rs2.user_id )AS rs3\n"
                + "                INNER JOIN roles ON roles.roleID = rs3.roleID\n"
                + "";
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

    public List<User> listUserRoleUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT ua.user_id,ua.user_name,ua.password,ua.first_name,ua.middle_name,ua.last_name,ua.gender,ua.DOB,ea.telephone,ea.email FROM `user_accounts` as ua \n"
                + "inner join user_role as ur on ua.user_id=ur.userID\n"
                + "inner join user_address as uad on ua.user_id=uad.uaID\n"
                + "inner join electronicaddress as ea on ea.eaID=uad.eaID\n"
                + "inner join roles on roles.roleID=ur.roleID\n"
                + "where roles.roleID=3";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("ua.user_id"));
                u.setUsername(rs.getString("ua.user_name"));
                u.setPassword(rs.getString("ua.password"));
                u.setFirstname(rs.getString("ua.first_name"));
                u.setMiddlename(rs.getString("ua.middle_name"));
                u.setLastname(rs.getString("ua.last_name"));
                u.setGender(rs.getInt("ua.gender"));
                u.setDob(rs.getDate("ua.DOB"));
                u.setPhone(rs.getString("ea.telephone"));
                u.setEmail(rs.getString("ea.email"));
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
            String sql = "INSERT INTO `user_accounts` "
                    + "(`user_name`, `password`, `first_name`, `middle_name`, `last_name`, `gender`,  `status_id`, `createdDate`) VALUES"
                    + "( ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1, u.getUsername());
            s.setString(2, u.getPassword());
            s.setString(3, u.getFirstname());
            s.setString(4, u.getMiddlename());
            s.setString(5, u.getLastname());
            s.setInt(6, u.getGender());
            s.setInt(7, 1);
            s.setString(8, getTime);
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

    public List<RoleUser> listAll() {
        List<RoleUser> cus = new ArrayList<>();
        String sql = "SELECT ur.roleID, ua.user_id, ua.user_name, ua.first_name,\n"
                + "ua.middle_name, ua.last_name, ua.gender, ua.DOB, ua.status_id,\n"
                + "uad._name, eca.email, eca.telephone, eca.photo\n"
                + "FROM\n"
                + "(((`user_accounts` AS ua INNER JOIN `user_role` AS ur ON ua.`user_id` = ur.`userID`)\n"
                + "INNER JOIN\n"
                + "(SELECT * FROM `province` JOIN `user_address`\n"
                + "ON `province`.`id` = `user_address`.`provinceID`) AS uad\n"
                + "ON ua.`user_id` = uad.`userID`)\n"
                + "INNER JOIN `electronicaddress` AS eca ON ua.`user_id` = eca.`eaID`)\n"
                + "WHERE ur.roleID = 3 ";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                RoleUser c = new RoleUser();
                c.setUser(new User(rs.getInt("ua.user_id"), rs.getString("ua.user_name"),
                        rs.getString("ua.first_name"), rs.getString("ua.middle_name"),
                        rs.getString("ua.last_name"), rs.getInt("ua.gender"),
                        rs.getDate("ua.DOB"), rs.getInt("ua.status_id"),
                        rs.getString("eca.email"), rs.getString("eca.telephone"),
                        rs.getString("eca.photo"), new Role(rs.getInt("ur.roleID"))));
//                c.setUser_add(new UserAddress(new Provinces(rs.getString("uad._name"))));
                cus.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return cus;
    }

    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
//        List<String> list = udao.listUserAdminID();
//        List<User> listU = udao.listUser();
//        User u = new User(0, "", "", "", "", "", "");
//        u.setUsername("hoangadma");
//        u.setEmail("hoangliu@gmail.com");
//        System.out.println(udao.getUserByUserName("hoangadma"));
//        User a = udao.getUserByEmail("thachdp2808@gmail.com");
//        System.out.println(a.getPassword());
        System.out.println(udao.getUserByEmail("hoangnvliu@gmail.com").toString());
    }
}
