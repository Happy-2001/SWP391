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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.District;
import model.ElectronicAddress;
import model.Provinces;
import model.Shipper;
import model.Shipper_Address;
import model.Shipper_all;
import model.Street;
import model.SubDistrict;
import model.project;

/**
 *
 * @author nguye
 */
public class ShipperDAO extends DBConnect {

    DBConnect mysqlConnect = new DBConnect();

    public ArrayList<Shipper> listShipper() {
        ArrayList<Shipper> shipper = new ArrayList<>();
        String sql = "SELECT * FROM `shippers`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Shipper u = new Shipper();
                u.setId(rs.getInt("shipperID"));
                u.setName(rs.getString("shipperName"));
                u.setDob(rs.getDate("DOB"));
                u.setGender(rs.getInt("gender"));
                u.setCreator(rs.getInt("creator"));
                u.setCreateOn(rs.getDate("createOn"));
                u.setUpdateOn(rs.getDate("updateOn"));
                shipper.add(u);
            }
            return shipper;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public Shipper_all getShipperById(int id) {
        String sql = "SELECT ship.shipperID,ship.shipperName,ship.DOB,ship.gender,ship.creator,ship.createOn,ship.updateOn,uad._name,shipadd.districtID,shipadd.wardID,shipadd.streetID,shipadd.projectID,eca.telephone,eca.fax,eca.email,shipadd.addressDetail from\n"
                + "(((`shippers` AS ship INNER JOIN `shipper_address` AS shipadd ON shipadd.shipperID=ship.shipperID)\n"
                + "INNER JOIN\n"
                + "(SELECT * FROM `province` JOIN `shipper_address`\n"
                + "ON `province`.`id` = `shipper_address`.`provinceID`) AS uad\n"
                + "ON ship.`shipperID` = uad.`shipperID`)\n"
                + "INNER JOIN `electronicaddress` AS eca ON shipadd.`eaID` = eca.`eaID`)\n"
                + "where ship.shipperID=?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Shipper_all u = new Shipper_all();
                u.setShip(new Shipper(rs.getInt("ship.shipperID"), rs.getString("ship.shipperName"),
                        rs.getDate("ship.DOB"), rs.getInt("ship.gender"),
                        rs.getInt("ship.creator"), rs.getDate("ship.createOn"),
                        rs.getDate("ship.updateOn")));
//                u.setShip_add(new Shipper_Address(new Provinces(rs.getString("uad._name")),
//                        new District(rs.getInt("shipadd.districtID")),
//                        new SubDistrict(rs.getInt("shipadd.wardID")),
//                        new Street(rs.getInt("shipadd.streetID")),
//                        new project(rs.getInt("shipadd.projectID")),
//                        rs.getString("eca.telephone"),
//                        rs.getString("eca.fax"),
//                        rs.getString("eca.email"),
//                        rs.getString("shipadd.addressDetail")));
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
        ShipperDAO dao = new ShipperDAO();
        Shipper_all s = dao.getShipperById(1);
        System.out.println(s.getShip_add().getStreetID().getProvine_id());
    }
}
