/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.FileManager;

import java.util.List;
import model.ProductModel.Product;

/**
 *
 * @author AD
 */
public class ProductFileManager {
    final FileManager fm;

    public ProductFileManager() {
        this.fm = new FileManager();
    }
    
    public boolean loadDataFromFile(List<Product> product, String fileName){
        return fm.loadDataFromFile(product, fileName);
    }
    
    public boolean saveDataToFile(List<Product> product, String fileName){
        return fm.saveDataToFile(product, fileName, "Product file saved!");
    }
    
}
