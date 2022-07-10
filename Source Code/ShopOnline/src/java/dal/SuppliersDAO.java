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
import model.SupDetail;
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

    public SupDetail getSupById(int id) {
        String sql = "SELECT sup.supplierID,sup.companyName,sup.contactName,sup.contactTitle,sup.DOB,sup.gender,sup.creator,sup_add.provinceID,sup_add.districtID,sup_add.wardID,sup_add.streetID,sup_add.projectID,sup_add.eaID,sup_add.addressDetail\n"
                + "FROM `suppliers` as sup\n"
                + "inner JOIN supplier_address as sup_add on sup_add.supplierID=sup.supplierID\n"
                + "WHERE sup.supplierID=?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                SupDetail c = new SupDetail();
                c.setSup(new Suppliers(rs.getInt("sup.supplierID"), rs.getString("sup.companyName"),
                        rs.getString("sup.contactName"),rs.getString("sup.contactTitle"), rs.getDate("sup.DOB"),
                        rs.getInt("sup.gender"), rs.getInt("sup.creator")));
                c.setSup_add(new Supplier_address(rs.getInt("sup_add.provinceID"),rs.getInt("sup_add.districtID") ,
                        rs.getInt("sup_add.wardID"),rs.getInt("sup_add.streetID"), rs.getInt("sup_add.projectID"),
                        rs.getInt("sup_add.eaID"), rs.getString("sup_add.addressDetail")));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public static void main(String[] args) {
        SuppliersDAO dao =new SuppliersDAO();
        SuppliersDAO db = new SuppliersDAO();
        SupDetail sup = db.getSupById(1);
        
            System.out.println(sup);
        
    }
}
