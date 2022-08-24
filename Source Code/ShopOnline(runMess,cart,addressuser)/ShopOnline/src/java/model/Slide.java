/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class Slide {
    private int id;
    private String heading;
    private String description;
    private String namebutton;
    private String img;
    private String url;
    private int status;

    public Slide() {
    }

    public Slide(int id, String heading, String description, String namebutton, String img, String url, int status) {
        this.id = id;
        this.heading = heading;
        this.description = description;
        this.namebutton = namebutton;
        this.img = img;
        this.url = url;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNamebutton() {
        return namebutton;
    }

    public void setNamebutton(String namebutton) {
        this.namebutton = namebutton;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }   
}
