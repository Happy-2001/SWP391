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
import model.District;
import model.Provinces;
import model.Street;
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

    public void insertUserAddress(String userID, String fullname, String eaID) {
        String sql = "INSERT INTO `user_address` ( `userID`,`fullname`, `eaID`) VALUES\n"
                + "(?,?, ?);";
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, fullname);
           
            ps.setString(3, eaID);
          

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
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return eaID;
    }

    public ArrayList<Provinces> getProvince() {
        ArrayList<Provinces> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `province`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Provinces p = new Provinces();
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setName(rs.getString("_name"));
                p.setCode(rs.getString("_code"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public Provinces getProvince(int id) {
        try {
            String sql = "SELECT * FROM `province` WHERE id = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Provinces p = new Provinces();
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setName(rs.getString("_name"));
                p.setCode(rs.getString("_code"));
                
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public ArrayList<District> getDistrict() {
        ArrayList<District> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `district` ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                District p = new District();
                p.setDistrictID((rs.getInt("id")));
                p.setName(rs.getString("_name"));
                p.setPrefix(rs.getString("_prefix"));
                p.setProvinceID(rs.getString("_province_id"));
                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }

    public ArrayList<District> getDistrict(int prvID) {
        ArrayList<District> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `district` WHERE `district`.`_province_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, prvID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                District p = new District();
                p.setDistrictID((rs.getInt("id")));
                p.setName(rs.getString("_name"));
                p.setPrefix(rs.getString("_prefix"));
                p.setProvinceID(rs.getString("_province_id"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public District getDistrictByID(int id) {
        try {
            String sql = "SELECT * FROM `district` WHERE id = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                District p = new District();
                p.setDistrictID(Integer.parseInt(rs.getString("id")));
                p.setName(rs.getString("_name"));
                p.setPrefix(rs.getString("_prefix"));
                
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    
    public ArrayList<SubDistrict> getSubDistrict() {
        ArrayList<SubDistrict> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `ward`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SubDistrict p = new SubDistrict();
                p.setSubDistrictID((rs.getInt("id")));
                p.setName(rs.getString("_name"));
                p.setPrefix(rs.getString("_prefix"));
                p.setProvinceID(rs.getInt("_province_id"));
                p.setDistrictID(rs.getInt("_district_id"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public ArrayList<SubDistrict> getSubDistrict(int wid) {
        ArrayList<SubDistrict> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `ward` WHERE `ward`.`_district_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, wid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SubDistrict p = new SubDistrict();
                p.setSubDistrictID((rs.getInt("id")));
                p.setName(rs.getString("_name"));
                p.setPrefix(rs.getString("_prefix"));
                p.setProvinceID(rs.getInt("_province_id"));
                p.setDistrictID(rs.getInt("_district_id"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public SubDistrict getWard(int id) {
        try {
            String sql = "SELECT * FROM `ward` WHERE id = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SubDistrict p = new SubDistrict();
                p.setSubDistrictID(Integer.parseInt(rs.getString("id")));
                p.setName(rs.getString("_name"));
                p.setPrefix(rs.getString("_prefix"));
                
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public ArrayList<project> getProject() {
        ArrayList<project> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `project`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                project p = new project();
                p.setId((rs.getString("id")));
                p.setName(rs.getString("_name"));
                p.setProvinceID(rs.getString("_province_id"));
                p.setDistrictID(rs.getString("_district_id"));
                p.setLat(rs.getString("_lat"));
                p.setIng(rs.getString("_lng"));

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
                p.setId((rs.getString("id")));
                p.setName(rs.getString("_name"));
                p.setProvinceID(rs.getString("_province_id"));
                p.setDistrictID(rs.getString("_district_id"));
                p.setLat(rs.getString("_lat"));
                p.setIng(rs.getString("_lng"));

                list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    
    public ArrayList<Street> getStreet(int strid) {
        ArrayList<Street> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `ward` WHERE `ward`.`_district_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, strid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Street p = new Street();
                p.setId((rs.getInt("id")));
                p.setName(rs.getString("_name"));
                p.setPrefix(rs.getString("_prefix"));
                p.setProvine_id(rs.getInt("_province_id"));
                p.setDistrict_id(rs.getInt("_district_id"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                p.setUaID((rs.getString("uaID")));
                p.setUserID(rs.getString("userID"));
                p.setPname(rs.getString("pname"));
                p.setDname(rs.getString("dname") == null ? "" : rs.getString("dname") + ",");
                p.setWname(rs.getString("wname") == null ? "" : rs.getString("wname") + ",");
                p.setPrname(rs.getString("prname") == null ? "" : rs.getString("prname") + ",");
                p.setStrname(rs.getString("strname") == null ? "" : rs.getString("strname") + ",");
                p.setDetailAddress(rs.getString("addressDetail") == null ? "" : rs.getString("addressDetail") + ",");
                p.setPhone(rs.getString("telephone") == null ? "" : rs.getString("telephone"));
                p.setEmail(rs.getString("email") == null ? "" : rs.getString("email"));
                p.setFullname(rs.getString("fullname") == null ? "" : rs.getString("fullname"));
                p.setOtherPhone(rs.getString("otherPhone") == null ? "" : rs.getString("otherPhone"));
                p.setStatus(rs.getString("status").equals("") ? null : rs.getString("status"));

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
        ArrayList<District> list2 = adao.getDistrict();
        System.out.println(list2.get(0).getName());
    }

}
