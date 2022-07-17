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
import model.Blog;
import model.Category;
import model.Post;

/**
 *
 * @author Admin
 */
public class PostDAO extends DBConnect{
    DBConnect mysqlConnect = new DBConnect();
    public List<Category> listCategory() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM `blog_categories`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt("blog_id"), rs.getString("blog_name")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return categories;
    }
    public List<Blog> getBlogForHomePage() {
        List<Blog> lc = new ArrayList<>();
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
    public List<Post> listPost() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM 'posts' ";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);         
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPost_id(rs.getInt("post_id"));
                p.setContent(rs.getString("content"));
                p.setBrief_infor(rs.getString("brief_information"));
                p.setImage(rs.getString("image"));
                posts.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return posts;
    }
    public List<Post> listAllPost() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT post_id, create_date, content, brief_information, description, image FROM `posts`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPost_id(rs.getInt("post_id"));
                p.setDate(rs.getString("create_date"));
                p.setContent(rs.getString("content"));
                p.setBrief_infor(rs.getString("brief_information"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                posts.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return posts;
    }
    public Post getPostByID(int id) {
        String sql = "SELECT * FROM `posts` WHERE post_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Post(rs.getInt("post_id"), rs.getString("content"), rs.getString("brief_information"),
                        rs.getString("description"), rs.getString("create_date"), rs.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public Blog getBlogByID(int id) {
        String sql = "SELECT `blog_id`, `create_date`, `content`, `description`, `noidung`, `img`, "
                + "`category_blog_id` FROM `blog` WHERE blog_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Blog(rs.getInt("blog_id") ,rs.getString("create_date"), rs.getString("content"), rs.getString("description"), 
                        rs.getString("noidung"), rs.getString("img"), rs.getInt("category_blog_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public void deletePost(int id) {
        try {
            String sql = "DELETE FROM `blogs` WHERE `blog_id`= ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    public void addPost(String date, String content, String description, String noidung, int categoryId, String image) {
        try {
            String sql = "INSERT INTO `blog`(`create_date`, `content`, `description`, `noidung`,"
                    + " `User_Account_user_id`, `category_blog_id`, `img`) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, date); 
            statement.setString(2, content); 
            statement.setString(3, description); 
            statement.setString(4, noidung); 
            statement.setInt(5, 1);
            statement.setInt(6, categoryId);
            statement.setString(7, image);
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void update(String date, String content, String description, String noidung, int categoryId, String image, int id) {
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
            statement.setString(1, date); 
            statement.setString(2, content); 
            statement.setString(3, description); 
            statement.setString(4, noidung); 
            statement.setInt(5, categoryId);
            statement.setString(6, image);
            statement.setInt(7, id);
            statement.executeUpdate();

        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    public static void main(String[] args) {
        PostDAO p = new PostDAO();
         List<Post> posts = p.listAllPost();
        System.out.println(posts);
    }
}
