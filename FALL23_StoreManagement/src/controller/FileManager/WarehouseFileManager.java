/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.FileManager;

import java.util.ArrayList;
import java.util.List;
import model.WarehouseModel.WarehouseExport;
import model.WarehouseModel.WarehouseImport;

/**
 *
 * @author AD
 */
public class WarehouseFileManager {
    final FileManager fm;

    public WarehouseFileManager() {
        this.fm = new FileManager();
    }
    
    public void loadDataFromFile(List<WarehouseExport> warehouseExport, List<WarehouseImport> warehouseImport, String fileName){
        List<Object> object = new ArrayList<>();
        fm.loadDataFromFile(object, fileName);
        for (Object o : object) {
            if(o instanceof WarehouseExport){
                warehouseExport.add((WarehouseExport)o);
            }else if(o instanceof WarehouseImport){
                warehouseImport.add((WarehouseImport) o);
            }
        }
    }
    
    public void savaDataToFile(List<WarehouseExport> warehouseExport, List<WarehouseImport> warehouseImport, String fileName){
        List<Object> object = new ArrayList<>();
        for (WarehouseExport whe : warehouseExport) {
            object.add(whe);
        }
        for (WarehouseImport whi : warehouseImport) {
            object.add(whi);
        }
        fm.saveDataToFile(object, fileName, "Warehouse File saved!");
    }
}
