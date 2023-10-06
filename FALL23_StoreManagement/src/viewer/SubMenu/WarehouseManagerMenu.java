/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewer.SubMenu;

import controller.Validate.Validation;
import controller.Manager.WarehouseManager;
import java.util.ArrayList;
import java.util.Scanner;
import model.ProductModel.Product;
import model.WarehouseModel.WarehouseExport;
import model.WarehouseModel.WarehouseImport;

/**
 *
 * @author AD
 */
public class WarehouseManagerMenu {

    private static String[] warehouseSubMenu = {
        "Create an import receipt",
        "Create an export receipt",
        "Exit"
    };

    private static int getWarehouseSubMenu() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < warehouseSubMenu.length; i++) {
            System.out.println("  2." + (i + 1) + ". " + warehouseSubMenu[i]);
        }
        return Validation.checkInputLimit("Your choice: ", 1, warehouseSubMenu.length);
    }

    public static void displayWarehouseMenu(ArrayList<WarehouseImport> listImport, ArrayList<WarehouseExport> listExport, ArrayList<Product> listProduct) {
        WarehouseManager wm = new WarehouseManager(listImport, listExport, listProduct);
        int warehouseSubMenuChoice;
        do {
            System.out.println(" ===== Warehouse Management ===== ");
            warehouseSubMenuChoice = getWarehouseSubMenu();
            switch (warehouseSubMenuChoice) {
                case 1:
                    wm.createImportReceipt();
                    break;
                case 2:
                    wm.createExportReceipt();
                    break;
                case 3:
                    break;
            }
        } while (warehouseSubMenuChoice != 3);
        System.out.println("\n\n");
    }
}
