package model;

/**
 *
 * @author anhvo
 */
public class Customers {
    User us;
    Address uad;

    public Customers() {
    }

    public Customers(User user, Address uad) {
        this.us = user;
        this.uad = uad;
    }

    public User getUs() {
        return us;
    }

    public void setUs(User user) {
        this.us = user;
    }

    public Address getUad() {
        return uad;
    }

    public void setUad(Address uad) {
        this.uad = uad;
    }
    
}
