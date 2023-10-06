/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.FileManager;

import java.util.List;

/**
 *
 * @author AD
 */
public interface IFileManager {
    public <T> boolean loadDataFromFile(List<T> list, String fileName);
    public <T> boolean saveDataToFile(List<T> list, String fileName, String msg);
}
