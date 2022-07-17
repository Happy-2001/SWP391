/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
import model.User;

/**
 *
 * @author Administrator
 */
public class MessageDAO {

    DBConnect mysqlConnect = new DBConnect();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String getTime = (dtf.format(now));

    public ArrayList<User> getMesstoAdmin(String adminID) {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "SELECT  DISTINCT infUSER.* FROM\n"
                    + "(SELECT DISTINCT user_accounts.* from messengers INNER JOIN user_accounts ON user_accounts.user_id = messengers.fromID WHERE messengers.toID = ? ) as listUSERsend INNER join\n" // ? in this line
                    + "(SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                    + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                    + " ON ua.userID = ac.user_id) AS rs1\n"
                    + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) as infUSER WHERE infUSER.user_id = listUSERsend.user_id";

            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, adminID);
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
                list.add(u);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public ArrayList<Message> getAllMessageofUser(String groupID, String userID) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "SELECT rs1.* FROM\n"
                    + "(SELECT mess.messageID,creatorID,recipientGroupID,messageBody,mess.parentMessageID,createDate,isRead FROM messages AS mess INNER JOIN message_recipient AS mr \n"
                    + "ON mess.messageID = mr.messageID) as rs1 INNER JOIN \n"
                    + "(SELECT ug.groupID,ug.userID FROM `group` INNER JOIN user_group AS ug ON ug.groupID = `group`.groupID\n"
                    + "WHERE ug.groupID = ? AND userID = ?)as rs2\n"
                    + "ON rs1.recipientGroupID = rs2.groupID ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, groupID);
            statement.setString(2, userID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message s = new Message();
                s.setId(rs.getString("messageID"));
                s.setFromID(rs.getString("creatorID"));
                s.setToID(rs.getString("recipientGroupID"));
                s.setContent(rs.getString("messageBody"));
                s.setParentMessageID(rs.getString("parentMessageID"));
                s.setCreateDate(rs.getString("createDate"));
                s.setIsread(rs.getString("isRead") == null ? "0" : "1");
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    
    
    public Message getLastMessage(String groupID, String userID) {
        Message s = new Message();
        try {
            String sql = "SELECT  * FROM\n"
                    + "(SELECT rs1.* FROM\n"
                    + "(SELECT mess.messageID,creatorID,recipientGroupID,messageBody,createDate,isRead FROM messages AS mess INNER JOIN message_recipient AS mr \n"
                    + "ON mess.messageID = mr.messageID ) as rs1 INNER JOIN \n"
                    + "(SELECT ug.groupID,ug.userID FROM `group` INNER JOIN user_group AS ug ON ug.groupID = `group`.groupID\n"
                    + "WHERE ug.groupID = ? AND userID = ?)as rs2\n"
                    + "ON rs1.recipientGroupID = rs2.groupID) AS rs3 \n"
                    + "\n"
                    + "WHERE messageID = \n"
                    + "(SELECT MAX(messageID) FROM\n"
                    + "(SELECT mess.messageID,creatorID,recipientGroupID,messageBody,createDate,isRead FROM messages AS mess INNER JOIN message_recipient AS mr \n"
                    + "ON mess.messageID = mr.messageID ) as rs1 INNER JOIN \n"
                    + "(SELECT ug.groupID,ug.userID FROM `group` INNER JOIN user_group AS ug ON ug.groupID = `group`.groupID\n"
                    + "WHERE ug.groupID = ? AND userID = ?)as rs2\n"
                    + "ON rs1.recipientGroupID = rs2.groupID) ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, groupID);
            statement.setString(2, userID);
            statement.setString(3, groupID);
            statement.setString(4, userID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                s.setId(rs.getString("messageID"));
                s.setFromID(rs.getString("creatorID"));
                s.setToID(rs.getString("recipientGroupID"));
                s.setContent(rs.getString("messageBody"));
                s.setCreateDate(rs.getString("createDate"));
                s.setIsread(rs.getString("isRead"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return s;
    }
    
    // add message
    public void addMessage(String creatorID, String messageBody) {
        String sql = "INSERT INTO messages(creatorID,messageBody,createDate) VALUES\n"
                + "(?,?,?)";

        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, creatorID);
            ps.setNString(2, messageBody);
            ps.setString(3, getTime);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    // add message with parent
    public void addMessageWithParent(String creatorID, String messageBody,String parentID) {
        
        String sql = "INSERT INTO messages(creatorID,messageBody,createDate,parentMessageID) VALUES\n"
                + "(?,?,?,?)";

        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, creatorID);
            ps.setString(2, messageBody);
            ps.setString(3, getTime);
            ps.setString(4, parentID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    // addRecipientMessage!!!
    public void addRecipientMessage(String recipientGroupID, String messageID) {
        String sql = "INSERT INTO message_recipient(recipientGroupID,messageID) VALUES\n"
                + "(?,?)";

        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, recipientGroupID);
            ps.setString(2, messageID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    //get max groupID 
    public String getMaxMessIDb () {
        String messageID = "";
        String sql = "SELECT MAX(messageID) FROM  `Messages`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                messageID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return messageID;
    }
    
    public ArrayList<String> getMrIDbyMessageID(String messageID) {
        ArrayList<String> listMrID = new ArrayList<>();
        String sql = "SELECT * FROM `message_recipient` mr WHERE mr.messageID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, messageID);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                listMrID.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return listMrID;
    }
    
    //get max mrID 
    public String getMaxmrID () {
        String mrID = "";
        String sql = "SELECT MAX(mrID) FROM `message_recipient` ";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                mrID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return mrID;
    }
    
    public String getCreatorbyMessageID (String messageID) {
        String creatorID = "";
        String sql = "SELECT creatorID FROM messages WHERE messageID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, messageID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                creatorID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return creatorID;
    }
    public void deleteMessages2( String id) {       // chỉ xóa nội dung
        try {
            String sql = "UPDATE `messages` SET `messageBody` = NULL WHERE `messageID` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void readMess( String groupID,String messageID) {       // chỉ xóa nội dung
        try {
            String sql = "UPDATE `message_recipient` SET `isRead` = '1' WHERE `recipientGroupID` = ? and `messageID` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            
            statement.setString(1, groupID);
            statement.setString(2, messageID);
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void deleteRecipientMessages(String id) {
        try {
            String sql = "DELETE FROM message_recipient WHERE mrID = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void deleteMessages( String id) {
        try {
            String sql = "DELETE FROM messages WHERE messageID = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public static void main(String[] args) {
        MessageDAO mdao = new MessageDAO();
        String list = mdao.getCreatorbyMessageID("3");
        
           Message result = mdao.getLastMessage("2", "2");
           System.out.println(result.getIsread() == null);
           Message ex = new Message("83","1","2","xin chào quý khách", "2022-07-17 15:45:36", null, null);
           System.out.println(ex == result);
           System.out.println(result.getId()+ " | "+ result.getFromID()+ " | "+ result.getToID()+ " | "+ result.getContent()+ " | "+ result.getCreateDate()+ " | "+ result.getParentMessageID()+ " | "+ result.getIsread() );
        
    }
}
