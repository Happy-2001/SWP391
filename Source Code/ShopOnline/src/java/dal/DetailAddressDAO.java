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
import model.AddressDetail;
import model.Provinces;

/**
 *
 * @author Administrator
 */
public class DetailAddressDAO {
     DBConnect mysqlConnect = new DBConnect();
     
     public ArrayList<AddressDetail> getDetailAddress() {
        ArrayList<AddressDetail> list = new ArrayList<>();
        try {
            String sql = "SELECT concat(p._name,', ',tb1.fullDistrict,', ',tb1.fullWard)AS fulladdress, tb1.provinceID, tb1.districtID,tb1.wardID FROM (SELECT w.id as wardID,d.id as districtID,d._province_id as provinceID,concat(w._prefix,' ',w._name)as fullWard,concat(d._prefix,' ',d._name) AS fullDistrict FROM ward w LEFT JOIN district d ON d.id = w._district_id AND w._province_id = d._province_id) as tb1 LEFT JOIN province p ON p.id = tb1.provinceID "; //WHERE concat(p._name,', ',tb1.fullDistrict,', ',tb1.fullWard) LIKE ?
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
//            strSearch = "%"+strSearch+"%";
//            statement.setString(1, strSearch);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               AddressDetail p = new AddressDetail();
               p.setAddressDetail((rs.getString(1)));
               p.setProvinceID(rs.getString(2));
               p.setDistrictID(rs.getString(3));
               p.setSubDistrictID(rs.getString(4));
               list.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
     public static void main(String[] args) {
         DetailAddressDAO d = new DetailAddressDAO();
         ArrayList<AddressDetail> list = d.getDetailAddress();
         for (AddressDetail addressDetail : list) {
             if(addressDetail.getAddressDetail().contains("Hà Nội, Huyện Thạch Thất, Xã Thạch Hòa")){
                              System.out.println(addressDetail.getProvinceID());
                                                            System.out.println(addressDetail.getDistrictID());
                              System.out.println(addressDetail.getSubDistrictID());

                                                            
             }
         }
    }
}
