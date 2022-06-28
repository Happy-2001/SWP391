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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;

/**
 *
 * @author Administrator
 */
public class AutochatDAO {
    DBConnect mysqlConnect = new DBConnect();
    
    public ArrayList<Message> getAllMessageofUser(String groupID, String userID) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AutoChat";
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
                s.setCreateDate(rs.getString("createDate"));
                s.setIsread(rs.getString("isRead"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutochatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
}
