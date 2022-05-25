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
import model.Product;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class ProductDAO {
    DBConnect mysqlConnect = new DBConnect();

    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public List<Product> listAll(String sort) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` ORDER BY `products`.`unit_price` " + sort;
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public List<Product> listTop(int quantity) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` LIMIT ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, quantity);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }
    
    
    public List<Product> listTopNew(int quantity) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` ORDER BY product_id DESC LIMIT ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, quantity);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }
}
