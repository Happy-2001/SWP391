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
    private int status;
    private int customer_id;
    private int employee_id;
    Product product;
    private int quantity;
    private double amount;

    public Orders() {
    }

    public Orders(int orderID, String orderDate, String requireDate, String shippedDate, int status, int customer_id, int employee_id, Product product, int quantity, double amount) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.requireDate = requireDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
    