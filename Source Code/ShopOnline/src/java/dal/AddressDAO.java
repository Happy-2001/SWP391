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
import model.Blog;
import model.District;
import model.Provinces;
import model.SubDistrict;
import model.project;

/**
 *
 * @author Administrator
 */
public class AddressDAO {

    DBConnect mysqlConnect = new DBConnect();

    public void insertCountry(String name) {
        String sql = "";
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void insertAddress(String table, String name, String containerID) {
        String sql = "";
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, table);
            ps.setString(2, name);
            ps.setString(3, containerID);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public String getEaIDbyUserID(String UserID) {
        String eaID = "";
        String sql = "SELECT ea.eaID FROM `electronicaddress` ea INNER JOIN user_address ua \n"
                + "ON ua.eaID = ea.eaID WHERE ua.userID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, UserID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                eaID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return eaID;
    }

    public ArrayList<Provinces> getProvince() {
        ArrayList<Provinces> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM province";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Provinces p = new Provinces();
                p.setId(Integer.parseInt(rs.getString(1)));
                p.setName(rs.getString(2));
                p.setCode(rs.getString(3));
                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }

    public ArrayList<District> getDistrict() {
        ArrayList<District> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `district` ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                District p = new District();
                p.setDistrictID(Integer.parseInt(rs.getString(1)));
                p.setName(rs.getString(2));
                p.setPrefix(rs.getString(3));
                p.setProvinceID(rs.getString(4));
                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }

    public ArrayList<SubDistrict> getSubDistrict() {
        ArrayList<SubDistrict> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `ward`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SubDistrict p = new SubDistrict();
                p.setSubDistrictID((rs.getString(1)));
                p.setName(rs.getString(2));
                p.setPrefix(rs.getString(3));
                p.setProvinceID(rs.getString(4));
                p.setDistrictID(rs.getString(5));
                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }

    public ArrayList<project> getProject() {
        ArrayList<project> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `project`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                project p = new project();
                p.setId((rs.getString(1)));
                p.setName(rs.getString(2));
                p.setProvinceID(rs.getString(3));
                p.setDistrictID(rs.getString(4));
                p.setLat(rs.getString(5));
                p.setIng(rs.getString(6));

                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public ArrayList<project> getProjectWith(String provinceID,String districtID) {
        ArrayList<project> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `project` WHERE _province_id = ? AND _district_id = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, provinceID);
            statement.setString(2, districtID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                project p = new project();
                p.setId((rs.getString(1)));
                p.setName(rs.getString(2));
                p.setProvinceID(rs.getString(3));
                p.setDistrictID(rs.getString(4));
                p.setLat(rs.getString(5));
                p.setIng(rs.getString(6));

                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    public static void main(String[] args) {
        AddressDAO adao = new AddressDAO();
        ArrayList<project> list = adao.getProjectWith("2", "49");
        for (project object : list) {
            System.out.println(object.getName());
        }
    }
}
