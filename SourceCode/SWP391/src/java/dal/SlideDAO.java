package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Slide;

public class SlideDAO extends DBConnect {

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

    public void insert(Slide slide) {
        try {
            String sql = "INSERT INTO `slide` (`img`, `heading`, `description`, `name_button`, `url`, `status`) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setString(1, slide.getImg());
            st.setString(2, slide.getHeading());
            st.setString(3, slide.getDescription());
            st.setString(4, slide.getNamebutton());
            st.setString(5, slide.getUrl());
            st.setBoolean(6, slide.isStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM `slide` WHERE `slide`.`slide_id` = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void update(Slide s) {
        try {
            String sql = "UPDATE `slide` SET `img` = ?, `heading` = ?, `description` = ?, `name_button` = ?, `url` = ?, `status` = ? WHERE `slide`.`slide_id` = ?";
            PreparedStatement st = mysqlConnect.connect().prepareStatement(sql);
            st.setString(1, s.getImg());
            st.setString(2, s.getHeading());
            st.setString(3, s.getDescription());
            st.setString(4, s.getNamebutton());
            st.setString(5, s.getUrl());
            st.setBoolean(6, s.isStatus());
            st.setInt(7, s.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    
        public Slide getById(String id) {
        try {
            String sql = "SELECT * FROM `slide` "
                    + "WHERE `slide`.`slide_id` = ?";
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
                s.setStatus(rs.getBoolean("status"));
                return s;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

}
