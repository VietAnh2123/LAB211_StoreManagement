/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Manager;

import controller.FileManager.ProductFileManager;
import controller.Validate.Updater;
import controller.Validate.Validation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.ProductModel.Product;

/**
 *
 * @author AD
 */
public class ProductManager {

    private static List<Product> pList;
    private static String productFile = "src\\database\\product.dat";
    ProductFileManager pfm = new ProductFileManager();
    
    public ProductManager(ArrayList<Product> pList) {
        this.pList = pList;
    }

    public void addProduct() {
        while (true) {
            System.out.print("Enter Product ID: ");
            String productID = Validation.checkInputString();
            if (!Validation.checkIdExist((ArrayList<Product>) pList, productID)) {
                System.err.println("ID existed!\n");
                return;
            }
           
            System.out.print("Enter Product name: ");
            String productName = Validation.checkInputString();
            
            System.out.print("Enter manufacturing date: ");
            LocalDate manufacturingDate = Validation.checkInputDate("dd-MM-yyyy");
            
            System.out.print("Enter expiration date: ");
            LocalDate expirationDate = Validation.checkInputDate("dd-MM-yyyy");
            while(expirationDate.isBefore(manufacturingDate)){
                if(Validation.checkManufacturingExpirationDate(expirationDate, manufacturingDate) == 1){
                    System.out.print("Enter manufacturing date again: ");
                    manufacturingDate = Validation.checkInputDate("dd-MM-yyyy");
                }else{
                    System.out.print("Enter expiration date again: ");
                    expirationDate = Validation.checkInputDate("dd-MM-yyyy");
                }
            }
            
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
           
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            
            System.out.print("Enter type: ");
            String type = Validation.checkInputString();
            
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();

            pList.add(new Product(productID, productName, manufacturingDate, expirationDate, origin, price, type, quantity));
            pfm.saveDataToFile(pList, productFile);
            if (!Validation.checkInputYN()) {
                System.out.println(" *** Add success! ***\n");
                return;
            }
        }
    }
    
    public void updateProduct(){
        System.out.print("Enter ProductID to update: ");
        String uID = Validation.checkInputString();
        if(Validation.checkIdExist((ArrayList<Product>) pList, uID)){
            System.out.println("Product does not exist!\n");
            return;
        }
        
        Product p = Validation.getProduct(uID, pList);
        System.out.println(p);
        System.out.print("Enter new product name: ");
        String updatedName = Updater.checkInputName(p);
        p.setProductName(updatedName);
        
        System.out.print("Enter new manufacturing date: ");
        LocalDate updatedManufacturingDate = Updater.checkInputDate("dd-MM-yyyy", p, 1);
        p.setManufacturingDate(updatedManufacturingDate);
        
        System.out.print("Enter new expiration date: ");
        LocalDate updatedExpirationDate = Updater.checkInputDate("dd-MM-yyyy", p, 2);
        p.setExpirationDate(updatedExpirationDate);
        while(updatedExpirationDate.isBefore(updatedManufacturingDate)){
            if(Validation.checkManufacturingExpirationDate(updatedExpirationDate, updatedManufacturingDate) == 1){
                System.out.print("Enter new Manufacturing date again: ");
                updatedManufacturingDate = Updater.checkInputDate("dd-MM-yyyy", p, 1);
                p.setManufacturingDate(updatedManufacturingDate);
            }else{
                System.out.print("Enter new Expiration date again: ");
                updatedExpirationDate = Updater.checkInputDate("dd-MM-yyyy", p, 2);
                p.setExpirationDate(updatedExpirationDate);
            }
        }
        System.out.print("Enter new origin: ");
        String updatedOrigin = Updater.checkInputOrigin(p);
        p.setOrigin(updatedOrigin);
        
        System.out.print("Enter new price: ");
        double updatedPrice = Updater.checkInputPrice(p);
        p.setPrice(updatedPrice);
        
        System.out.print("Enter new type: ");
        String updatedType = Updater.checkInputType(p);
        p.setType(updatedType);
        
        System.out.print("Enter new quantity: ");
        int updatedQuantity = Updater.checkInputQuantity(p);
        p.setQuantity(updatedQuantity);
        
        pfm.saveDataToFile(pList, productFile);
        System.out.println(" *** Update Success! ***\n");
        
        
    }
    
    public void deleteProduct(){
        if(pList.isEmpty()){
            System.err.println("Empty List!\n");
        }else{
            System.out.print("Enter ProductID to DELETE: ");
            String rID = Validation.checkInputString();
            Product p = Validation.getProduct(rID, pList);
            if(p == null){
                System.out.println("Product " + rID + " not found!\n");
            }else{
                pList.remove(p);
                System.out.println("Product " + rID + " has been removed!\n\n");
                pfm.saveDataToFile(pList, productFile);
            }
        }
    }
    
    public void showAll() {
        if (pList.isEmpty()) {
            System.err.println("Empty List!\n");
        } else {
             System.out.println("ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Quantity");
            for (Product p : pList) {
                System.out.println(p);
            }
        }
        System.out.println("\n\n");
    }
}
