package model;

/**
 *
 * @author anhvo
 */
public class Customers {
    User user;
    Address uad;

    public Customers() {
    }

    public Customers(User user, Address uad) {
        this.user = user;
        this.uad = uad;
    }

    public User getUs() {
        return user;
    }

    public void setUs(User user) {
        this.user = user;
    }

    public Address getUad() {
        return uad;
    }

    public void setUad(Address uad) {
        this.uad = uad;
    }
    
}
