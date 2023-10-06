/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewer.MainMenu;

import controller.FileManager.ProductFileManager;
import controller.FileManager.WarehouseFileManager;
import viewer.SubMenu.ProductManagerMenu;
import viewer.SubMenu.WarehouseManagerMenu;
import viewer.SubMenu.ReportManagerMenu;
import controller.Validate.Validation;
import java.util.ArrayList;
import java.util.Scanner;
import model.ProductModel.Product;
import model.WarehouseModel.WarehouseExport;
import model.WarehouseModel.WarehouseImport;

/**
 *
 * @author AD
 */
public class Menu {
    
    private static String[] ops ={
        "Manage Products",
        "Manage Warehouse",
        "Report",
        "Store data to file",
        "Exit"
    };
    
    private static int getChoice(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println("\t" + (i+1) + ". " + ops[i]);
        }
        return Validation.checkInputLimit("Your choice: ", 1, ops.length);
    }
    
    public static void display(){
        ArrayList<WarehouseImport> listImport = new ArrayList<>();
        ArrayList<WarehouseExport> listExport = new ArrayList<>();
        ArrayList<Product> listProduct = new ArrayList<>();
        String productFile = "src\\database\\product.dat";
        String warehouseFile = "src\\database\\warehouse.dat";
        ProductFileManager pfm = new ProductFileManager();
        WarehouseFileManager wfm = new WarehouseFileManager();
        
        pfm.loadDataFromFile(listProduct, productFile);
        wfm.loadDataFromFile(listExport, listImport, warehouseFile);
        int choice;
        do{
            System.out.println("     -----     STORE MANAGEMENT     -----     ");
            choice = getChoice();
            System.out.println("\n\n");
            switch (choice) {
                case 1:
                    ProductManagerMenu.displayProductMenu(listProduct);
                    break;
                case 2:
                    WarehouseManagerMenu.displayWarehouseMenu(listImport, listExport, listProduct);
                    break;
                case 3:
                    ReportManagerMenu.displayReportMenu(listProduct, listExport, listImport);
                    break;
                case 4:
                    pfm.saveDataToFile(listProduct, productFile);
                    wfm.savaDataToFile(listExport, listImport, warehouseFile);
                    break;
                case 5:
                    
                    break;
            }
        }while(choice != 5);
    }
}
