/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SupDetail;
import model.Supplier;
import model.Supplier_address;
import model.Suppliers;

/**
 *
 * @author nguye
 */
public class SuppliersDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public List<Suppliers> listSupplier() {
        List<Suppliers> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM `suppliers`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Suppliers u = new Suppliers();
                u.setId(rs.getInt("supplierID"));
                u.setName(rs.getString("companyName"));
                u.setContactName(rs.getString("contactName"));
                u.setContactTitle(rs.getString("contactTitle"));
                u.setDob(rs.getDate("DOB"));
                u.setGender(rs.getInt("gender"));
                u.setCreator(rs.getInt("creator"));
                u.setCreateOn(rs.getDate("createOn"));
                u.setUpdateOn(rs.getDate("updateOn"));
                suppliers.add(u);
            }
            return suppliers;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public List<Suppliers> listSupplierTop5() {
        List<Suppliers> suppliers = new ArrayList<>();
        String sql = "SELECT `suppliers`.`supplierID`,`suppliers`.`companyName`,`suppliers`.`contactName`,`suppliers`.`contactTitle`,`suppliers`.`DOB`,`suppliers`.`gender`,`suppliers`.`creator` FROM `suppliers`\n"
                + "inner JOIN `products` on `products`.`supplierID` = `suppliers`.`supplierID`\n"
                + "group by `products`.supplierID LIMIT 5";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Suppliers u = new Suppliers();
                u.setId(rs.getInt("supplierID"));
                u.setName(rs.getString("companyName"));
                u.setContactName(rs.getString("contactName"));
                u.setContactTitle(rs.getString("contactTitle"));
                u.setDob(rs.getDate("DOB"));
                u.setGender(rs.getInt("gender"));
                u.setCreator(rs.getInt("creator"));
                suppliers.add(u);
            }
            return suppliers;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public Suppliers getSupById(int id) {
        String sql = "SELECT * FROM `suppliers` WHERE supplierID=?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Suppliers u = new Suppliers();
                u.setId(rs.getInt("supplierID"));
                u.setName(rs.getString("companyName"));
                u.setContactName(rs.getString("contactName"));
                u.setContactTitle(rs.getString("contactTitle"));
                u.setDob(rs.getDate("DOB"));
                u.setGender(rs.getInt("gender"));
                u.setCreator(rs.getInt("creator"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public void addSuppliers(Supplier p) {
        try {
            String sql = "INSERT INTO `suppliers`( `companyName`, `contactName`, `contactTitle`, `DOB`, `gender`, `creator`)\n"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setString(2, p.getContactName());
            statement.setString(3, p.getContactTitle());
            statement.setString(4, p.getDob());
            statement.setInt(5, p.getGender());
            statement.setInt(6, p.getCreator());
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    public void deleteSupplier(int id) {
        try {
            String sql = "DELETE FROM `suppliers` WHERE `suppliers`.`supplierID`=?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    public static void main(String[] args) {
        SuppliersDAO dao = new SuppliersDAO();

        //        List<Suppliers> a = dao.listSupplierTop5();
//        for (Suppliers o : a) {
//            System.out.println(o.getName());
//        }
//        dao.addSuppliers(new Supplier("a", "a", "a", "2022-09-20", 1, 1));
        dao.deleteSupplier(17);

    }
}
