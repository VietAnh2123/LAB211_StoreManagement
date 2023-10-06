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
public class WarehouseExport extends Warehouse implements Serializable{
    private String exportID;

    public WarehouseExport() {
        super(null, null);
    }

    public WarehouseExport(String exportID, ArrayList<Product> pList, LocalDateTime Date) {
        super(pList, Date);
        this.exportID = exportID;
    }

    public String getExportID() {
        return exportID;
    }

    public void setExportID(String exportID) {
        this.exportID = exportID;
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
        sb.append("ID Export: " + exportID + "\n")
          .append("ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Export Quantity\n")
          .append(listAllProduct())
          .append("Export Date: " + getDate() + "\n"); 
        return sb.toString();
    }
}
