/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.WarehouseModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.ProductModel.Product;

/**
 *
 * @author AD
 */
public class WarehouseImport extends Warehouse implements Serializable{
    private String importID;

    public WarehouseImport() {
        super(null, null);
    }

    public WarehouseImport(String importID, ArrayList<Product> pList, LocalDateTime Date) {
        super(pList, Date);
        this.importID = importID;
    }

    public String getImportID() {
        return importID;
    }

    public void setImportID(String importID) {
        this.importID = importID;
    }
    
    public String listAllProduct(){
        StringBuilder sb = new StringBuilder();
        for (Product item : pList) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Import: " + importID + "\n")
           .append("ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Import Quantity\n")
           .append(listAllProduct())
           .append("Import Date Time: " + getDate() + "\n");
        return sb.toString();
    }
}
