/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.WarehouseModel;

import model.ProductModel.Product;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author AD
 */
public class Warehouse {
    protected ArrayList<Product> pList;
    private LocalDateTime Date;

    public Warehouse(ArrayList<Product> pList, LocalDateTime Date) {
        this.pList = pList;
        this.Date = Date;
    }

    public ArrayList<Product> getpList() {
        return pList;
    }

    public void setpList(ArrayList<Product> pList) {
        this.pList = pList;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime Date) {
        this.Date = Date;
    }
    
}
