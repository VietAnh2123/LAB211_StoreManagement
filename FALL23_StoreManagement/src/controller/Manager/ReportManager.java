/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Manager;

import controller.Validate.Validation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.ProductModel.Product;
import model.WarehouseModel.WarehouseExport;
import model.WarehouseModel.WarehouseImport;

/**
 *
 * @author AD
 */
public class ReportManager {
    private ArrayList<Product> listProduct;
    private ArrayList<WarehouseExport> listExport;
    private ArrayList<WarehouseImport> listImport;
    private static Scanner sc = new Scanner(System.in);
    public ReportManager() {
    }

    public ReportManager(ArrayList<Product> listProduct, ArrayList<WarehouseExport> listExport, ArrayList<WarehouseImport> listImport) {
        this.listProduct = listProduct;
        this.listExport = listExport;
        this.listImport = listImport;
    }
    
    public void expiredProducts(){
        System.out.println("PRODUCTS THAT HAVE BEEN EXPIRED");
        System.out.println("ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Quantity");
        for (Product product : listProduct) {
            if(product.getExpirationDate().isBefore(LocalDate.now())){
                System.out.println(product);
                System.out.println("\n\n");
            }
        }
        System.out.println("No item expired in store!");
        System.out.println("\n\n");
    }
    
    public void outOfStockProducts(){
        Collections.sort(listProduct);
        System.out.println("PRODUCTS RUNNNING OUT OF STOCK");
        System.out.println("ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Quantity");
        for (Product product : listProduct) {
            if(product.getQuantity() < 5){
                System.out.println(product);
                System.out.println("\n\n");
            }
        }
        System.out.println("No Item is running out of stock!");
        System.out.println("\n\n");
    }
    
    public void productsSelling(){
        System.out.println("SELLING PRODUCTS");
        System.out.println("ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Quantity");
        for (Product product : listProduct) {
            if(product.getExpirationDate().isAfter(LocalDate.now())){
                System.out.println(product);
                System.out.println("\n\n");
            }
        }
        System.out.println("\n\n");
    }
    
    public void searchReceipt(){
        System.out.println("Input EXPORT or IMPORT ID you want to search (format: E000000X or I000000X): ");
        String id = sc.nextLine();
        if(id.startsWith("E")){
            if(Validation.searchWarehouseExportID(listExport, id) != null){
                System.out.println("Found!");
                System.out.println(Validation.searchWarehouseExportID(listExport, id));
            }else{
                System.out.println("Not Found!");
            }
        }else if(id.startsWith("I")){
            if(Validation.searchWarehouseImportID(listImport, id) != null){
                System.out.println("Found!");
                System.out.println(Validation.searchWarehouseImportID(listImport, id));
            }else{
                System.out.println("Not Found!");
            }
        }else{
            System.err.println("Not Found!");
        }
        System.out.println("\n\n");
    }
    
    public void getImportReceipt(){
        System.out.println("IMPORT RECEIPT");
        for (WarehouseImport warehouseImport : listImport) {
            System.out.println(warehouseImport);
        }
        System.out.println("\n\n");
    }
    
    public void getExportReceipt(){
        System.out.println("EXPORT RECEIPT");
        for (WarehouseExport warehouseExport : listExport) {
            System.out.println(warehouseExport);
        }
        System.out.println("\n\n");
    }
}
