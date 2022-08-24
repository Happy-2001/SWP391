package model;

/**
 *
 * @author Administrator
 */
public class Provinces{
    private int id;
    private String name;
    private String code;

    public Provinces() {
    }

    public Provinces(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
    
    public Provinces(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
