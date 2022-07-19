/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import controller.ManagePost;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog;
import model.BlogCategory;
import model.Category;
import model.Post;
import model.Product;

/**
 *
 * @author Administrator
 */
public class BlogDAO {

    DBConnect mysqlConnect = new DBConnect();

    public void addBlog(Blog p) {
        try {
            String sql = "INSERT INTO `blogs`(`create_date`,`userID` ,`content`, `description`, `noidung`, `blogCategoryID`, `img`) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getCreatedDate()); //name
            statement.setInt(2, p.getUid()); //category id
            statement.setString(3, p.getContent()); //category id
            statement.setString(4, p.getDescription()); //unit price
            statement.setString(5, p.getNoidung()); //stock
            statement.setInt(6, p.getCategoryId()); //description
            statement.setString(7, p.getImage()); // image
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    public void addPost(Post p) {
        try {
            String sql = "INSERT INTO `blogs`(`create_date`,`userID` ,`content`, `description`, `noidung`, `blogCategoryID`, `img`) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getCreatedDate()); //name
            statement.setInt(2, p.getUid()); //category id
            statement.setString(3, p.getContent()); //category id
            statement.setString(4, p.getDescription()); //unit price
            statement.setString(5, p.getNoidung()); //stock
            statement.setInt(6, p.getCategoryId()); //description
            statement.setString(7, p.getImage()); // image
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void update(Blog p, int id) {
        try {
            String sql = "UPDATE `blogs` SET `create_date`= ?,"
                    + "`content`= ?, "
                    + "`description`= ?,"
                    + "`noidung`= ?,"
                    + "`userID`= 1,"
                    + "`blogCategoryID`= ?,"
                    + "`img`= ? "
                    + "WHERE blog_id = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getCreatedDate());
            statement.setString(2, p.getContent());
            statement.setString(3, p.getDescription());
            statement.setString(4, p.getNoidung());
            statement.setString(5, p.getImage());
            statement.setInt(6, 1);
            statement.setInt(7, p.getCategoryId());
            statement.setInt(8, id);
            statement.executeUpdate();

        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }

    public static void main(String[] args) {
        BlogDAO b = new BlogDAO();
        String stringDate = "22/01/2016";
        String a = "ok";
        int e = 4;
        Blog p = new Blog();
        p.setCreatedDate(stringDate);
        p.setCategoryId(1);
        p.setContent(a);
        p.setDescription(a);
        p.setNoidung(a);
        p.setId(40);
                
        b.update(p,40);
    }

    public int countPage() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `blogs`";
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
                    + "ROW_NUMBER() OVER (ORDER BY create_date DESC) AS Seq FROM  `blogs`) as x "
                    + "WHERE Seq BETWEEN ? AND ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 2) + 1);
            statement.setInt(2, (pageNumber * 2));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"),
                        rs.getString("create_date"),
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

    public List<BlogCategory> listAll() {
        List<BlogCategory> categories = new ArrayList<>();
        String sql = "SELECT * FROM `blog_categories`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                BlogCategory c = new BlogCategory();
                c.setCategoryId(rs.getInt("blogCategoryID"));
                c.setCategoryName(rs.getString("blogCategoryName"));
                categories.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return categories;
    }

    public ArrayList<Blog> getBlogForHomePage() {
        ArrayList<Blog> lc = new ArrayList<>();
        try {
            String sql = "SELECT blog_id , create_date, content, description, img FROM blogs ORDER BY create_date DESC";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"),
                        rs.getString("create_date"),
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

    public List<Blog> getBlogRecommend(String id, int number) {
        try {
            List<Blog> blogs = new ArrayList<>();
            String sql = "SELECT * FROM `blogs` WHERE blog_id != ? LIMIT ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            statement.setInt(2, number);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"), rs.getString("create_date"), rs.getString("content"), rs.getString("description"), rs.getString("noidung"), rs.getString("img"), rs.getInt("blogCategoryID"));
                blogs.add(b);
            }
            return blogs;
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public Blog getBlogById(String id) {
        try {
            String sql = "SELECT * FROM `blogs` WHERE blog_id = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"), rs.getString("create_date"), rs.getString("content"), rs.getString("description"), rs.getString("noidung"), rs.getString("img"), rs.getInt("blogCategoryID"));
                return b;
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public Object getBlogSearch(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
/*
public ArrayList<Blog> getBlogForHomePage() {
        ArrayList<Blog> lc = new ArrayList<>();
        try {
            String sql = "SELECT blog_id , create_date, content, description, img FROM blogs ORDER BY create_date DESC";
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

    public List<Blog> getBlogRecommend(String id, int number) {
        try {
            List<Blog> blogs = new ArrayList<>();
            String sql = "SELECT * FROM `blogs` WHERE blog_id != ? LIMIT ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            statement.setInt(2, number);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"), rs.getDate("create_date"), rs.getString("content"), rs.getString("description"), rs.getString("noidung"), rs.getString("img"), rs.getInt("blogCategoryID"));
                blogs.add(b);
            }
            return blogs;
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    
 */
