/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewer.SubMenu;

import controller.Manager.ProductManager;
import controller.Validate.Validation;
import java.util.ArrayList;
import java.util.Scanner;
import model.ProductModel.Product;

/**
 *
 * @author AD
 */
public class ProductManagerMenu {

    private static String[] productSubMenu = {
        "Add Product",
        "Update Product information",
        "Delete Product",
        "Show all Product",
        "Exit"
    };

    private static int getProductSubMenu() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < productSubMenu.length; i++) {
            System.out.println("  1." + (i + 1) + ". " + productSubMenu[i]);
        }
        return Validation.checkInputLimit("Your choice: ", 1, productSubMenu.length);
    }

    public static void displayProductMenu(ArrayList<Product> arr) {
        ProductManager m = new ProductManager(arr);
        int productSubMenuChoice;
        do {
            System.out.println(" ===== Product Management ===== ");
            productSubMenuChoice = getProductSubMenu();
            switch (productSubMenuChoice) {
                case 1:
                    m.addProduct();
                    break;
                case 2:
                    m.updateProduct();
                    break;
                case 3:
                    m.deleteProduct();
                    break;
                case 4:
                    m.showAll();
                    break;
                case 5:
                    break;
            }
        } while (productSubMenuChoice != 5);
        System.out.println("\n\n");
    }
}
