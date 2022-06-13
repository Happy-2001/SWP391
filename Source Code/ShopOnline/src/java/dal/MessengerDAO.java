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
public class MessengerDAO {
        DBConnect mysqlConnect = new DBConnect();

        public void addMessage(String fromid, String toid, String content) {
        try {
            String sql = "insert into [Messages] (fromID,toID,content) values\n"
                    + "(?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, fromid);
            statement.setString(2, toid);
            statement.setString(3, content);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Message> getAllMessageofUser1M() {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select AllMessUser.id, AllMessUser.content,AllMessUser.usersend,AllMessUser.[time],AllMessUser.toid,AllMessUser.isread  from\n"
                    + "(select m.fromid, max([time]) as maxTime  from [Messages] m inner join Account acc on acc.id = m.fromid where toid = 45 group by m.fromid) as MessLastOfUser\n"
                    + "INNER JOIN\n"
                    + "(select m.id,acc.name as usersend,toid,[time],content,isread from [Messages] m inner join Account acc on acc.id = m.fromid where toid = 45) as AllMessUser \n"
                    + "on AllMessUser.[time] = MessLastOfUser.maxTime where usersend != 'Admin'";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message s = new Message();
                s.setId(rs.getString("id"));
                s.setFrom(rs.getString("usersend"));
                s.setTo(rs.getString("toid"));
                s.setContent(rs.getString("content"));
                s.setTime(rs.getString("time"));
                s.setIsread(rs.getString("isread"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Message> getAllMessageofUser(String toid, String fromid) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select m.id,acc.name as usersend,toid,[time],content,isread from [Messages] m inner join Account acc on acc.id = m.fromid where toid = ? and fromid = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, toid);
            statement.setString(2, fromid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message s = new Message();
                s.setId(rs.getString("id"));
                s.setFrom(rs.getString("usersend"));
                s.setTo(rs.getString("toid"));
                s.setContent(rs.getString("content"));
                s.setTime(rs.getString("time"));
                s.setIsread(rs.getString("isread"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
