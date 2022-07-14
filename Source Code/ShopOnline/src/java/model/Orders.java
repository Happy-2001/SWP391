package model;

/**
 *
 * @author anhvo
 */
public class Orders {
    private int orderID;
    private String orderDate;
    private String requireDate;
    private String shippedDate;
    private String status;
    private int customerId;
    User user;
    private int shiperId;
    Product product;
    private float amount;
    private int quantity;

    public Orders() {
    }
    
    public Orders(int orderID) {
        this.orderID = orderID;
    }

    public Orders(int orderID, String orderDate, String requireDate, String shippedDate, String status, int customerId, int shiperId, Product product, float amount, int quantity) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.requireDate = requireDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.customerId = customerId;
        this.shiperId = shiperId;
        this.product = product;
        this.amount = amount;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(String requireDate) {
        this.requireDate = requireDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getShiperId() {
        return shiperId;
    }

    public void setShiperId(int shiperId) {
        this.shiperId = shiperId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}