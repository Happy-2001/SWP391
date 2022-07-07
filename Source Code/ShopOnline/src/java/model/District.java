package model;

/**
 *
 * @author anhvo
 */
public class District {
    private int districtID;
    private String name;
    private String prefix;
    private String provinceID;
    public District() {
    }

    public District(int districtID, String name, String prefix,String provinceID) {
        this.districtID = districtID;
        this.name = name;
        this.prefix = prefix;
        this.provinceID = provinceID;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }
    
    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
