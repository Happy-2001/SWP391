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
import model.Slide;

/**
 *
 * @author Administrator
 */
public class SlideDAO {

    DBConnect mysqlConnect = new DBConnect();

    public List<Slide> listSlide() {
        List<Slide> slides = new ArrayList<>();
        String sql = "SELECT * FROM `slides`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Slide s = new Slide();
                s.setId(rs.getInt("slide_id"));
                s.setImg(rs.getString("img"));
                s.setHeading(rs.getString("heading"));
                s.setDescription(rs.getString("description"));
                s.setNamebutton(rs.getString("name_button"));
                s.setUrl(rs.getString("url"));
                s.setStatus(rs.getInt("status"));
                slides.add(s);
            }
            return slides;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
public void insert(Slide slide) {
        try {
            String sql = "INSERT INTO `slides` (`img`, `heading`, `description`, `name_button`, `url`,`productID`, `status`) "
                    + "VALUES (?, ?, ?, ?, ?,1, ?)";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setString(1, slide.getImg());
            st.setString(2, slide.getHeading());
            st.setString(3, slide.getDescription());
            st.setString(4, slide.getNamebutton());
            st.setString(5, slide.getUrl());
            st.setInt(6, slide.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM `slides` WHERE `slide`.`slide_id` = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SlideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void update(String heading, String description, String button, String url, int status, int id) {
        try {
            String sql = "UPDATE `slides` SET `heading` = ?, `description` = ?, `name_button` = ?, `url` = ?, `status` = ? WHERE slide_id = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setString(1, heading);
            st.setString(2, description);
            st.setString(3, button);
            st.setString(4, url);
            st.setInt(5, status);
            st.setInt(6, id);
            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SlideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    
        public Slide getById(String id) {
        try {
            String sql = "SELECT * FROM `slides` "
                    + "WHERE `slides`.`slide_id` = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Slide s = new Slide();
                s.setId(rs.getInt("slide_id"));
                s.setImg(rs.getString("img"));
                s.setHeading(rs.getString("heading"));
                s.setDescription(rs.getString("description"));
                s.setNamebutton(rs.getString("name_button"));
                s.setUrl(rs.getString("url"));
                s.setStatus(rs.getInt("status"));
                return s;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public static void main(String[] args) {
        SlideDAO slideDAO = new SlideDAO();

        Slide s = slideDAO.getById("1");
        System.out.println(s.getId());

    }
}
