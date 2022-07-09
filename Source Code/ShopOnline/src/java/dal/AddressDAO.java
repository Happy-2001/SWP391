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
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog;
import model.District;
import model.Provinces;
import model.SubDistrict;
import model.UserAddress;
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

    public void insertUserAddress(String userID, String fullname, String provinceID, String districtID, String wardID, String projectID, String streetID, String eaID, String otherPhone, String detailAddress) {
        String sql = "INSERT INTO `user_address` ( `userID`,`fullname`, `provinceID`, `districtID`, `wardID`, `streetID`, `projectID`, `eaID`,`otherPhone`, `addressDetail`) VALUES\n"
                + "(?,?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, fullname);
            ps.setString(3, provinceID);
            ps.setString(4, districtID);
            ps.setString(5, wardID);
            ps.setString(6, streetID);
            ps.setString(7, projectID);
            ps.setString(8, eaID);
            ps.setString(9, otherPhone);
            ps.setString(10, detailAddress);

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

    public ArrayList<project> getProjectWith(String provinceID, String districtID) {
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
    
    
    public ArrayList<UserAddress> getUserAddress(String userID) {
        ArrayList<UserAddress> list = new ArrayList<>();
        try {
            String sql = "SELECT uaID,userID,pname,dname,wname, prname,strname,addressDetail,ela.telephone,ela.email,fullname,otherPhone,status FROM\n"
                    + "(SELECT status,fullname,otherPhone,eaID,uaID,userID,pname,dname,wname, prname,concat(str._prefix,' ',str._name) AS strname,addressDetail FROM\n"
                    + "(SELECT status,fullname,otherPhone,eaID,uaID,userID,pname,dname,wname,(pr._name) as prname,streetID,addressDetail FROM\n"
                    + "(SELECT status,fullname,otherPhone,eaID,uaID,userID,pname,dname,concat(w._prefix,' ',w._name) as wname,projectID,streetID,addressDetail FROM\n"
                    + "(SELECT  status,fullname,otherPhone,eaID,uaID,userID,provinceID,pname,concat(d._prefix,' ',d._name) as dname,wardID,projectID,streetID,addressDetail FROM \n"
                    + "(SELECT ua.status,ua.fullname,ua.otherPhone,ua.eaID,ua.uaID,ua.userID,p._name as pname,ua.provinceID,ua.districtID  ,ua.wardID,ua.projectID,ua.streetID,ua.addressDetail FROM user_address ua LEFT JOIN province p ON p.id = ua.provinceID) AS tb1 LEFT JOIN district d \n"
                    + "ON d.id = tb1.districtID) AS tb2 LEFT JOIN ward w ON w.id = tb2.wardID) AS tb3 LEFT JOIN project pr ON pr.id = tb3.projectID) AS tb4\n"
                    + "LEFT JOIN street str ON str.id = tb4.streetID)AS tb5 LEFT JOIN electronicaddress ela ON ela.eaID =tb5.eaID WHERE userID = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, userID);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                UserAddress p = new UserAddress();
                p.setUaID((rs.getString(1)));
                p.setUserID(rs.getString(2));
                p.setPname(rs.getString(3));
                p.setDname(rs.getString(4) == null ? "" : rs.getString(4) + ",");
                p.setWname(rs.getString(5) == null ? "" : rs.getString(5) + ",");
                p.setPrname(rs.getString(6) == null ? "" : rs.getString(6) + ",");
                p.setStrname(rs.getString(7) == null ? "" : rs.getString(7) + ",");
                p.setDetailAddress(rs.getString(8) == null ? "" : rs.getString(8) + ",");
                p.setPhone(rs.getString(9) == null ? "" : rs.getString(9));
                p.setEmail(rs.getString(10) == null ? "" : rs.getString(10));
                p.setFullname(rs.getString(11) == null ? "" : rs.getString(11));
                p.setOtherPhone(rs.getString(12) == null ? "" : rs.getString(12));
                p.setStatus(rs.getString(13).equals("") ? null : rs.getString(13));

                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(0).getStatus() != null) {
                continue;
            }
            if (list.get(i).getStatus() != null) {
                
                Collections.swap(list, 0, i);
            }
        }
        return list;
    }
    public void updateStatusUserAddress1( String idSetDefault) {
        try {
            String sql = "UPDATE `user_address` SET `status` = 'default' WHERE `user_address`.`uaID` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            statement.setString(1, idSetDefault);
            
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public void updateStatusUserAddress2( String idDefault) {
        try {
            String sql = "UPDATE `user_address` SET `status` = '' WHERE `user_address`.`uaID` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            
            statement.setString(1, idDefault);
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            mysqlConnect.disconnect();
        }
    }
   public void deleteUserAddress( String id) {
        try {
            String sql = "DELETE FROM user_address WHERE uaID = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        } finally {
            mysqlConnect.disconnect();
        }
    }
    public static void main(String[] args) {
        AddressDAO adao = new AddressDAO();
        ArrayList<UserAddress> list = adao.getUserAddress("1");
        adao.insertUserAddress("3", "Đào Phúc Thạch", "24", "333", "5154", null, null, "3", "012312454543", "KTX HL");
    }

}
