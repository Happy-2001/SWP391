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
import model.Slide;

/**
 *
 * @author Administrator
 */
public class SlideDAO {
    DBConnect mysqlConnect = new DBConnect();

    public List<Slide> listSlide() {
        List<Slide> slides = new ArrayList<>();
        String sql = "SELECT * FROM `slide`";
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
                s.setStatus(rs.getBoolean("status"));
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
}
