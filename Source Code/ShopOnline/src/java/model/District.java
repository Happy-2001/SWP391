package model;

/**
 *
 * @author anhvo
 */
public class District {
    private int districtID;
    private String name;
    private String prefix;

    public District() {
    }

    public District(int districtID, String name, String prefix) {
        this.districtID = districtID;
        this.name = name;
        this.prefix = prefix;
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
