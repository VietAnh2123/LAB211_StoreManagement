/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Validate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.ProductModel.Product;

/**
 *
 * @author AD
 */
public class Updater {
    private static Scanner sc = new Scanner(System.in);
    
    public static String checkInputName(Product p){
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+$");
        do{
            result = sc.nextLine();
            if(result.trim().isEmpty()){
                result = p.getProductName();
            }
        }while(!pattern.matcher(result).matches());
        return result;
    }
    
    public static LocalDate checkInputDate(String pattern, Product p, int x){
        boolean check = true;
        LocalDate date = null;
        while(check){
            try{
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
                String result = sc.nextLine();
                if(result.trim().isEmpty()){
                    if(x==1){
                        date = p.getManufacturingDate();
                        return date;
                    }else{
                        date = p.getExpirationDate();
                        return date;
                    }
                }
                date = LocalDate.parse(result, dtf);
                check = false;
            }catch(DateTimeException e){
                System.out.println("Format must be dd-MM-yyyy");
                check = true;
            }
        }
        return date;
    }
    
    public static String checkInputOrigin(Product p){
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+$");
        do{
            result = sc.nextLine();
            if(result.trim().isEmpty()){
                result = p.getOrigin();
            }
        }while(!pattern.matcher(result).matches());
        return result;
    }
    
    public static double checkInputPrice(Product p){
        boolean check = true;
        double result;
        try{
            while(check){
                String input = sc.nextLine();
                if(input.trim().isEmpty()){
                    result = p.getPrice();
                    return result;
                }else{
                    result = Double.parseDouble(input);
                }
                if(result < 0 || result > Double.MAX_VALUE){
                    System.out.println("Must be 0 to " + Double.MAX_VALUE);
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
    
    public static String checkInputType(Product p){
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+$");
        do{
            result = sc.nextLine();
            if(result.trim().isEmpty()){
                result = p.getType();
            }
        }while(!pattern.matcher(result).matches());
        return result;
    }
    
    public static int checkInputQuantity(Product p){
        boolean check = true;
        int result;
        try{
            while(check){
                String input = sc.nextLine();
                if(input.trim().isEmpty()){
                    result = p.getQuantity();
                    return result;
                }else{
                    result = Integer.parseInt(input);
                }
                if(result < 0 || result > Integer.MAX_VALUE){
                    System.out.println("Number must be 0 to " + Integer.MAX_VALUE);
                    check = true;
                }else{
                    return result;
                }
            }
        } catch(NumberFormatException e){
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }
}
