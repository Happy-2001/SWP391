/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author thund
 */
public class Orderlist {
     private int order_id;
    private int customer_id;
    private String name_receiver;
    private int phone;
    private String email;
    private String address;
    private int employee_id;
    private Date order_date;
    private Date shipped_date;
    private  String status;
    private String note;
    private String product_name;
    private int unit_price;
    private int quantity;

    public Orderlist() {
    }

    public Orderlist(int order_id, int customer_id, String name_receiver, int phone, String email, String address, int employee_id, Date order_date, Date shipped_date, String status, String note) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.name_receiver = name_receiver;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.employee_id = employee_id;
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.status = status;
        this.note = note;
    }
    public Orderlist(int order_id, Date order_date, String status, String product_name, int unit_price, int quantity) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.status = status;
        this.product_name = product_name;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName_receiver() {
        return name_receiver;
    }

    public void setName_receiver(String name_receiver) {
        this.name_receiver = name_receiver;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Orderlist{" + "order_id=" + order_id + ", customer_id=" + customer_id + ", name_receiver=" + name_receiver + ", phone=" + phone + ", email=" + email + ", address=" + address + ", employee_id=" + employee_id + ", order_date=" + order_date + ", shipped_date=" + shipped_date + ", status=" + status + ", note=" + note + '}';
    }
    
}
