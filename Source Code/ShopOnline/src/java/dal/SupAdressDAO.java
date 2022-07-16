/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.District;
import model.ElectronicAddress;
import model.Provinces;
import model.Street;
import model.SubDistrict;
import model.SupDetail;
import model.Supplier_address;
import model.Suppliers;
import model.Ward;
import model.project;

/**
 *
 * @author nguye
 */
public class SupAdressDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public SupDetail getSupAdressById(int id) {
        String sql = "SELECT sup.supplierID,sup.companyName, sup.contactName,sup.contactTitle,sup.DOB,sup.gender,sup.creator,sup.createOn,sup.updateOn,uad._name,supadd.districtID,supadd.wardID,supadd.streetID,supadd.projectID,supadd.addressDetail,eca.eaID,eca.telephone,eca.fax,eca.email from\n"
                + "(((`suppliers` AS sup INNER JOIN `supplier_address` AS supadd ON supadd.supplierID=sup.supplierID)\n"
                + "INNER JOIN\n"
                + "(SELECT * FROM `province` JOIN `supplier_address`\n"
                + "ON `province`.`id` = `supplier_address`.`provinceID`) AS uad\n"
                + "ON sup.`supplierID` = uad.`supplierID`)\n"
                + " INNER JOIN `electronicaddress` AS eca ON supadd.`eaID` = eca.`eaID`)\n"
                + " where sup.supplierID=?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                SupDetail u = new SupDetail();
                u.setSup(new Suppliers(rs.getInt("sup.supplierID"),rs.getString("sup.companyName"),rs.getString("sup.contactName"),
                                       rs.getString("sup.contactTitle"),rs.getDate("sup.DOB"),
                                       rs.getInt("sup.gender"),rs.getInt("sup.creator"),
                                       rs.getDate("sup.createOn"),rs.getDate("sup.updateOn")));
                u.setSup_add(new Supplier_address(new Provinces(rs.getString("uad._name")),
                                                  new District(rs.getInt("supadd.districtID")),
                                                  new SubDistrict(rs.getInt("supadd.wardID")),
                                                  new Street(rs.getInt("supadd.streetID")),
                                                  new project(rs.getInt("supadd.projectID")),
                                                  new ElectronicAddress(rs.getInt("eca.eaID")),
                                                    rs.getString("eca.telephone"),
                                                    rs.getString("eca.fax"),
                                                    rs.getString("eca.email"),
                                                    rs.getString("supadd.addressDetail")));
                
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupAdressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public static void main(String[] args) {
        SupAdressDAO dao = new SupAdressDAO();
        SupDetail a = dao.getSupAdressById(1);
        System.out.println(a.getSup_add().getFax());
    }
}
