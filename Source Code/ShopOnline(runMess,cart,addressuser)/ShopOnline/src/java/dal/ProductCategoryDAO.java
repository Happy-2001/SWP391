
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

public class ProductCategoryDAO extends DBConnect{
DBConnect mysqlConnect = new DBConnect();
    
    public List<Category> listAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM `product_categories`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("category_id"));
                c.setName(rs.getString("category_name"));
                c.setDescription(rs.getString("description"));
                categories.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return categories;
    }
    
    public static void main(String[] args) {
        ProductCategoryDAO p = new ProductCategoryDAO();
        System.out.println(p.listAll());
    }
}
