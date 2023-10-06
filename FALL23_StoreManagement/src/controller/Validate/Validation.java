/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Validate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import model.ProductModel.Product;
import model.WarehouseModel.WarehouseExport;
import model.WarehouseModel.WarehouseImport;

/**
 *
 * @author AD
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int checkInputLimit(String msg, int min, int max) {
        int result;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (min <= result && result <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range: " + min + " - " + max);
                System.out.print("Please! Enter again: ");
            }
        }
        return result;
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine();
            if (result.trim().isEmpty()) {
                System.err.println("Not be empty");
                System.out.print("Please! Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() {
        boolean check = true;
        int result;
        try{
            while(check){
                result = Integer.parseInt(sc.nextLine());
                if(result < 0 || result > Integer.MAX_VALUE){
                    System.err.println("Number must be 0 to " + Integer.MAX_VALUE);
                    System.out.print("Enter again: ");
                    check = true;
                }else{
                    return result;
                }
            }
        }catch(NumberFormatException e){
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }

    public static double checkInputDouble() {
        boolean check = true;
        double result;
        try{
            while(check){
                result = Double.parseDouble(sc.nextLine());
                if(result < 0 || result > Double.MAX_VALUE){
                    System.err.println("Number must be 0 to " + Double.MAX_VALUE);
                    System.out.print("Enter again: ");
                    check = true;
                }else{
                    return result;
                }
            }
        }catch(NumberFormatException e){
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }

    public static boolean checkInputYN() {
        System.out.print("Do you want to continue Y/y or N/n: ");
        while (true) {
            String result = checkInputString();
            if (result.trim().equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.trim().equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y/y or N/n!");
            System.out.print("Please! Enter again: ");
        }
    }

    public static boolean checkIdExist(ArrayList<Product> productList, String id) {
        for (Product p : productList) {
            if (id.equalsIgnoreCase(p.getProductID())) {
                return false;
            }
        }
        return true;
    }

    public static Product getProduct(String id, List<Product> productList) {
        for (Product p : productList) {
            if (p.getProductID().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    public static Product searchProduct(ArrayList<Product> list, Product product){
        for (Product p : list) {
            if(p.getProductID().equals(product.getProductID())){
                return p;
            }
        }
        return null;
    }
    
    public static LocalDate checkInputDate(String pattern){
        boolean check = true;
        LocalDate date = null;
        while(check){
            try{
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                date = LocalDate.parse(sc.nextLine(), dtf);
                check = false;
            }catch(DateTimeException e){
                System.out.println("Format date must be dd-MM-yyyy");
                System.out.print("Please! Enter again: ");
                check = true;
            }
        }
        return date;
    }
    
    public static int checkManufacturingExpirationDate(LocalDate expirationDate, LocalDate manufacturingDate){
        int choice = 0;
        System.err.println("Expriration time can not before Manufacturing time!");
        System.out.println("What do you want to fix?");
        System.out.println("1. Manufacturing Date");
        System.out.println("2. Expiration Date");
        System.out.print("Choose 1 or 2: ");
        do{
            choice = checkInputInt();
        }while(choice > 2);
        return choice;
    }
    
    public static String checkExportID(ArrayList<WarehouseExport> list){
        String id;
        int countElement = list.size();
        if(countElement == 0){
            return "E0000001";
        }else{
            int index = list.size()-1;
            String getID = list.get(index).getExportID();
            StringTokenizer stk = new StringTokenizer(getID, "E");
            int lastNum = Integer.parseInt(stk.nextToken());
            id = String.format("E%07d", lastNum+1);
        }
        return id;
    }
    
    public static String checkImportID(ArrayList<WarehouseImport> list){
        String id;
        int countElement = list.size();
        if(countElement == 0){
            return "I0000001";
        }else{
            int index = list.size()-1;
            String getID = list.get(index).getImportID();
            StringTokenizer stk = new StringTokenizer(getID, "I");
            int lastNum = Integer.parseInt(stk.nextToken());
            id = String.format("I%07d", lastNum+1);
        }
        return id;
    }
    
    public static int int_getChocie(ArrayList options, int min, int max){
        int rep;
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%2d.", i+1);
            System.out.println(options.get(i));
        }
        rep = checkInputLimit("Please input integer " + min + " to " + max + ": ", min, max);
        return rep;
    }
    
    public static Object ref_getChoice(ArrayList options, int min, int max){
        int rep;
        do{
            rep = int_getChocie(options, min, max);
        }while(rep < min || rep > max);
        return options.get(rep-1);
    }
    
    public static WarehouseImport searchWarehouseImportID(ArrayList<WarehouseImport> list, String id){
        for (WarehouseImport warehouseImport : list) {
            if(warehouseImport.getImportID().equalsIgnoreCase(id)){
                return warehouseImport;
            }
        }
        return null;
    }
    
    public static WarehouseExport searchWarehouseExportID(ArrayList<WarehouseExport> list, String id){
        for (WarehouseExport warehouseExport : list) {
            if(warehouseExport.getExportID().equalsIgnoreCase(id)){
                return warehouseExport;
            }
        }
        return null;
    } 
}
