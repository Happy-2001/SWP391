package model;

/**
 *
 * @author Administrator
 */
public class Address {
    private int userID;
    private int countryID;
    Provinces province;
    private int districtID;
    private int subDistrictID;
    private int eaID;
    private String addressDetail;

    public Address() {
    }
    
    public Address(Provinces province) {
        this.province = province;
    }
    
    public Address(int userID, int countryID, Provinces province, int districtID, int subDistrictID, int eaID, String addressDetail) {
        this.userID = userID;
        this.countryID = countryID;
        this.province = province;
        this.districtID = districtID;
        this.subDistrictID = subDistrictID;
        this.eaID = eaID;
        this.addressDetail = addressDetail;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public Provinces getProvince() {
        return province;
    }

    public void setProvince(Provinces province) {
        this.province = province;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public int getSubDistrictID() {
        return subDistrictID;
    }

    public void setSubDistrictID(int subDistrictID) {
        this.subDistrictID = subDistrictID;
    }

    public int getEaID() {
        return eaID;
    }

    public void setEaID(int eaID) {
        this.eaID = eaID;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

}
