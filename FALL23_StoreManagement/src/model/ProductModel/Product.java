/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ProductModel;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author AD
 */
public class Product implements Serializable,Comparable<Product>{
    private String productID;
    private String productName;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private String origin;
    private double price;
    private String type;
    private int quantity;

    public Product() {
    }

    public Product(String productID, String productName, LocalDate manufacturingDate, LocalDate expirationDate, String origin, double price, String type, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.origin = origin;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-8s |%-15s |%-20s |%-20s |%-15s |%-15.1f $|%-15s |%-15d ", getProductID(), getProductName(), getManufacturingDate(), getExpirationDate(), getOrigin(), getPrice(), getType(), getQuantity());
    }

    @Override
    public int compareTo(Product o) {
        if(this.getQuantity() < o.getQuantity()){
            return 1;
        }else if(this.getQuantity() > o.getQuantity()){
            return -1;
        }else{
            return 0;
        }
    }
}
