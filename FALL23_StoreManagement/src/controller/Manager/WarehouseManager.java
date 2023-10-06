/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Manager;

import controller.Validate.Validation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.ProductModel.Product;
import model.WarehouseModel.WarehouseExport;
import model.WarehouseModel.WarehouseImport;

/**
 *
 * @author AD
 */
public class WarehouseManager {
    private ArrayList<WarehouseImport> listImport;
    private ArrayList<WarehouseExport> listExport;
    private ArrayList<Product> listProduct;

    public WarehouseManager(ArrayList<WarehouseImport> listImport, ArrayList<WarehouseExport> listExport, ArrayList<Product> listProduct) {
        this.listImport = listImport;
        this.listExport = listExport;
        this.listProduct = listProduct;
    }
    
    public void createImportReceipt(){
        String id = Validation.checkImportID(listImport);
        ArrayList<Product> pList = new ArrayList<>();
        boolean choice = true;
        while(choice){
            System.out.println("Enter NO of product you want to IMPORT: ");
            System.out.println("NO|ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Quantity");
            Product product = (Product) Validation.ref_getChoice(listProduct, 1, listProduct.size());
            System.out.println("");
            System.out.print("- Enter quantity of import product: ");
            int importQty = Validation.checkInputInt();
            product.setQuantity(product.getQuantity() + importQty);
            if(Validation.searchProduct(pList, product) == null){
                pList.add(new Product(product.getProductID(), product.getProductName(), product.getManufacturingDate(), product.getExpirationDate(), product.getOrigin(), product.getPrice(), product.getType(), importQty));
            }else{
                Product temp = Validation.searchProduct(pList, product);
                pList.get(pList.indexOf(temp)).setQuantity(pList.get(pList.indexOf(temp)).getQuantity()+1);
            }
            choice = Validation.checkInputYN();
        }
        LocalDateTime time = LocalDateTime.now();
        listImport.add(new WarehouseImport(id, pList, time));
        System.out.println("  *** Successfully! *** \n\n");
    }
    
    public void createExportReceipt(){
        String id = Validation.checkExportID(listExport);
        ArrayList<Product> pList = new ArrayList<>();
        boolean choice = true;
        while(choice){
            System.out.println("Enter NO of product you want to EXPORT");
            System.out.println("NO|ID        Name             Manufacturing Date    Expiration Date       Origin           Price             Type             Quantity");
            Product product = (Product) Validation.ref_getChoice(listProduct, 1, listProduct.size());
            System.out.println("");
            if(product.getQuantity() == 0){
                System.out.println("This item is out of stock");
                return;
            }else{
                System.out.print("- Enter quantity of export product: ");
                int exportQty = Validation.checkInputInt();
                if(exportQty > product.getQuantity()){
                    System.err.println(" Export Quantity must less than Product Quantity!");
                    return;
                }
                product.setQuantity(product.getQuantity() - exportQty);
                if(Validation.searchProduct(pList, product) == null){
                    pList.add(new Product(product.getProductID(), product.getProductName(), product.getManufacturingDate(), product.getExpirationDate(), product.getOrigin(), product.getPrice(), product.getType(), exportQty));
                }else{
                    Product temp = Validation.searchProduct(pList, product);
                    pList.get(pList.indexOf(temp)).setQuantity(pList.get(pList.indexOf(temp)).getQuantity()+1);
                }
            }
            choice = Validation.checkInputYN();
        }
        LocalDateTime time = LocalDateTime.now();
        listExport.add(new WarehouseExport(id, pList, time));
        System.out.println(" *** Successfully! *** \n\n");
    }
}
