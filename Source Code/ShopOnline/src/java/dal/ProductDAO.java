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
import java.util.logging.Level;
import java.util.logging.Logger;

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
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setCategoryid(rs.getInt(3));
                p.setPrice(rs.getFloat(4));
                p.setSalePrice(rs.getFloat(5));
                p.setStock(rs.getInt(6));
                p.setBrief_information(rs.getString(8));
                p.setDescription(rs.getString(9));
                p.setImg(rs.getString(10));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public List<Product> listProductASC() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` order by unit_price ASC";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setCategoryid(rs.getInt(3));
                p.setPrice(rs.getFloat(4));
                p.setSalePrice(rs.getFloat(5));
                p.setStock(rs.getInt(6));
                p.setBrief_information(rs.getString(8));
                p.setDescription(rs.getString(9));
                p.setImg(rs.getString(10));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public List<Product> listProductDESC() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` order by unit_price DESC";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setCategoryid(rs.getInt(3));
                p.setPrice(rs.getFloat(4));
                p.setSalePrice(rs.getFloat(5));
                p.setStock(rs.getInt(6));
                p.setBrief_information(rs.getString(8));
                p.setDescription(rs.getString(9));
                p.setImg(rs.getString(10));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public List<Product> listProductByCate(String cid) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` WHERE category_id =?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, cid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }
    public List<Product> listProductBySupID(int supid) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` WHERE `products`.`supplierID`=?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, supid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }
    

    public List<Product> listProductByColor(String cid) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `product_color` pc \n"
                + "JOIN products p on p.product_id = pc.productID\n"
                + "WHERE colorID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, cid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public int countPage() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `products`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL") / 9;
                if (rs.getInt("TOTAL") % 9 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }

    public List<Product> getProductByPageNumber(int pageNumber, String sort) {
        List<Product> lc = new ArrayList<>();
        try {
            String sql = "SELECT product_id , product_name, unit_price, url "
                    + "FROM(SELECT product_id , product_name, unit_price, url, ROW_NUMBER() OVER (ORDER BY unit_price " + sort + " ) AS Seq FROM  `products`) as x \n"
                    + "WHERE Seq BETWEEN ? AND ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 9) + 1);
            statement.setInt(2, (pageNumber * 9));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                lc.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }

    public List<Product> getProductByPageNumber(int pageNumber) {
        List<Product> lc = new ArrayList<>();
        try {
            String sql = "SELECT product_id , product_name, unit_price, url "
                    + "FROM(SELECT product_id , product_name, unit_price, url, "
                    + "ROW_NUMBER() OVER (ORDER BY product_id) AS Seq FROM  `products`) as x "
                    + "WHERE Seq BETWEEN ? AND ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 9) + 1);
            statement.setInt(2, (pageNumber * 9));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                lc.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }

    public List<Product> listByPageNum(int pageNum) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM\n"
                + "(SELECT * , ROW_NUMBER() OVER (ORDER BY product_id) AS Seq FROM  `products`) as x\n"
                + "WHERE Seq BETWEEN ? AND ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNum - 1) * 9) + 1);
            statement.setInt(2, (pageNum * 9));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setCategoryid(rs.getInt(3));
                p.setPrice(rs.getFloat(4));
                p.setSalePrice(rs.getFloat(5));
                p.setStock(rs.getInt(6));
                p.setBrief_information(rs.getString(8));
                p.setDescription(rs.getString(9));
                p.setImg(rs.getString(10));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM `products` WHERE `products`.`product_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void addProduct(Product p) {
        try {
            String sql = "INSERT INTO `products` ( `product_name`, `category_id`, `unit_price`, `sale_price`, `unitsln_stock`, `discontinued`, `brief_information`, `description`, `url`, `description-short`, `views`, `quantityLike`, `supplierID`) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?);";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setInt(2, p.getCategoryid());
            statement.setFloat(3, p.getPrice());
            statement.setFloat(4, p.getSalePrice());
            statement.setInt(5, p.getStock());
            statement.setString(6, null);
            statement.setString(7, p.getBrief_information());
            statement.setString(8, p.getDescription());
            statement.setString(9, p.getImg());
            statement.setString(10, p.getSortdesc());
            statement.setString(11, "0");
            statement.setString(12, "0");
            statement.setString(13, p.getSupplierID());
            
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }

    public Product findById(String id) {
        Product p = new Product();
        try {
            String sql = "SELECT * FROM `products` WHERE `products`.`product_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setCategoryid(rs.getInt("category_id"));
                p.setSalePrice(rs.getFloat("sale_price"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setStock(rs.getInt("unitsln_stock"));
                p.setDescription(rs.getString("description"));
                p.setImg(rs.getString("url"));
                p.setSortdesc(rs.getString("description-short"));
                p.setSupplierID(rs.getString("supplierID "));
                p.setBrief_information(rs.getString("brief_information"));
                
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return p;
    }

    public void update(Product p) {
        try {
            String sql = "UPDATE `products` SET "
                    + "`product_name` = ?, "
                    + "`category_id` = ? , "
                    + "`unit_price` = ?, "
                    + "`unitsln_stock` = ?, "
                    + "`description` = ?, "
                    + "`url` = ?, "
                    + "`description-short` = ? "
                    + "`supplierID` = ? "
                    + "WHERE `products`.`product_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setInt(2, p.getCategoryid());
            statement.setFloat(3, p.getPrice());
            statement.setInt(4, p.getStock());
            statement.setString(5, p.getDescription());
            statement.setString(6, p.getImg());
            statement.setString(7, p.getSortdesc());
            statement.setString(8, p.getSupplierID());
            statement.setInt(9, p.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
     public static void main(String[] args) {

        ProductDAO product = new ProductDAO();
        Product p = new Product();
        p.setName("ok");
        p.setId(1);
        product.update(p);
                
     }

    public ArrayList<Product> findByName(String query) {
        ArrayList<Product> lc = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `products` WHERE product_name LIKE ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, "%" + query + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setSupplierID(rs.getString("supplierID"));
                p.setView(rs.getString("views"));
                p.setLike(rs.getString("quantityLike"));
                p.setImg(rs.getString("url"));
                lc.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }

    public Product getProductByID(int id) {
        String sql = "SELECT * FROM `products` WHERE product_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setCategoryid(rs.getInt("category_id"));
                p.setSalePrice(rs.getFloat("sale_price"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setStock(rs.getInt("unitsln_stock"));
                p.setDescription(rs.getString("description"));
                p.setImg(rs.getString("url"));
                p.setSortdesc(rs.getString("description-short"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

   

    public List<Product> getCourseByPageNumber(int pageNumber, String sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
