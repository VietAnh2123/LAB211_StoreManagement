/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewer.SubMenu;

import controller.Manager.ReportManager;
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
public class ReportManagerMenu {

    private static String[] reportSubMenu = {
        "Products that have expired",
        "The products that the store is selling",
        "Products that are running out of stock",
        "Import receipt of a product",
        "Export receipt of a product",
        "Exit"
    };

    private static int getReportSubMenu() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < reportSubMenu.length; i++) {
            System.out.println("  3." + (i + 1) + ". " + reportSubMenu[i]);
        }
        return Validation.checkInputLimit("Your choice: ", 1, reportSubMenu.length);
    }

    public static void displayReportMenu(ArrayList<Product> listProduct, ArrayList<WarehouseExport> listExport, ArrayList<WarehouseImport> listImport) {
        ReportManager rm = new ReportManager(listProduct, listExport, listImport);
        int reportSubMenuChoice;
        do {
            System.out.println(" ===== Report Management =====");
            reportSubMenuChoice = getReportSubMenu();
            switch (reportSubMenuChoice) {
                case 1:
                    rm.expiredProducts();
                    break;
                case 2:
                    rm.productsSelling();
                    break;
                case 3:
                    rm.outOfStockProducts();
                    break;
                case 4:
                    rm.getImportReceipt();
                    break;
                case 5:
                    rm.getExportReceipt();
                    break;
                case 6:
                    break;
            }
        } while (reportSubMenuChoice != 6);
        System.out.println("\n\n");
    }
}
