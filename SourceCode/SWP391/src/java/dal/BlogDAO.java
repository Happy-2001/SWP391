package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Blog;

public class BlogDAO {

    DBConnect mysqlConnect = new DBConnect();

    public int countPage() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `blog`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL") / 2;
                if (rs.getInt("TOTAL") % 2 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }

    public ArrayList<Blog> getBlogByPageNumber(int pageNumber) {
        ArrayList<Blog> lc = new ArrayList<>();
        try {
            String sql = "SELECT blog_id , create_date, content, description, img "
                    + "FROM(SELECT blog_id , create_date, content, description, img, "
                    + "ROW_NUMBER() OVER (ORDER BY create_date DESC) AS Seq FROM  `blog`) as x "
                    + "WHERE Seq BETWEEN ? AND ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 2) + 1);
            statement.setInt(2, (pageNumber * 2));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"),
                        rs.getDate("create_date"),
                        rs.getString("content"),
                        rs.getString("description"),
                        rs.getString("img"), pageNumber);
                lc.add(b);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }
    
    
    
    public ArrayList<Blog> getBlogForHomePage() {
        ArrayList<Blog> lc = new ArrayList<>();
        try {
            String sql = "SELECT blog_id , create_date, content, description, img FROM blog ORDER BY create_date DESC";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"),
                        rs.getDate("create_date"),
                        rs.getString("content"),
                        rs.getString("description"),
                        rs.getString("img")
                );
                lc.add(b);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }

    public Blog getBlogById(String id) {
        try {
            String sql = "SELECT * FROM `blog` WHERE blog_id = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"), rs.getDate("create_date"), rs.getString("content"), rs.getString("description"), rs.getString("noidung"), rs.getString("img"), rs.getInt("category_blog_id"));
                return b;
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public List<Blog> getBlogRecommend(String id, int number) {
        try {
            List<Blog> blogs = new ArrayList<>();
            String sql = "SELECT * FROM `blog` WHERE blog_id != ? LIMIT ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            statement.setInt(2, number);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"), rs.getDate("create_date"), rs.getString("content"), rs.getString("description"), rs.getString("noidung"), rs.getString("img"), rs.getInt("category_blog_id"));
                blogs.add(b);
            }
            return blogs;
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    
    public List<Blog> getBlogSearch(String search) {
        try {
            List<Blog> blogs = new ArrayList<>();
            String sql = "SELECT * FROM blog WHERE content LIKE ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, "%"+search+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"), rs.getDate("create_date"), rs.getString("content"), rs.getString("description"), rs.getString("noidung"), rs.getString("img"), rs.getInt("category_blog_id"));
                blogs.add(b);
            }
            return blogs;
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    
    public void addBlog(Blog p) {
        try {
            String sql = "INSERT INTO `blog`(`create_date`, `content`, `description`, `noidung`, "
                    + "`User_Account_user_id`, `category_blog_id`, `img`) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setDate(1, p.getCreatedDate()); 
            statement.setString(2, p.getContent()); 
            statement.setString(3, p.getDescription()); 
            statement.setString(4, p.getNoidung()); 
            statement.setString(5, p.getImage());
            statement.setInt(6, 1);
            statement.setInt(7, p.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void deleteBlog(int id) {
        try {
            String sql = "DELETE FROM `blog` WHERE `blog`.`blog_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void update(Blog p) {
        try {
            String sql = "UPDATE `blog` SET "
                    + "`create_date`= ?,"
                    + "`content`= ?,"
                    + "`description`= ?,"
                    + "`noidung`= ?,"
                    + "`User_Account_user_id`= ?,"
                    + "`category_blog_id`= ?,"
                    + "`img`= ? "
                    + "WHERE `blog`.`blog_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setDate(1, p.getCreatedDate()); 
            statement.setString(2, p.getContent()); 
            statement.setString(3, p.getDescription()); 
            statement.setString(4, p.getNoidung()); 
            statement.setString(5, p.getImage());
            statement.setInt(6, 1);
            statement.setInt(7, p.getCategoryId());
            statement.executeUpdate();

        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    public static void main(String[] args) {
    }

}
