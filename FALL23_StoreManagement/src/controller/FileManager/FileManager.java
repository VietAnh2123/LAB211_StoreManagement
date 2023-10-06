/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.FileManager;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author AD
 */
public class FileManager implements IFileManager{

    @Override
    public <T> boolean loadDataFromFile(List<T> list, String fileName) {
        try{
            File f = new File(fileName);
            if(!f.exists()){
                return false;
            }
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if(f.length() == 0){
                System.err.println("File is empty!");
            }
            boolean check = true;
            while(check){
                try{
                    T c = (T) ois.readObject();
                    list.add(c);
                }catch(EOFException e){
                    break;
                }
            }
            fis.close();
            ois.close();
        }catch(FileNotFoundException e){
            System.err.println("File " + fileName + " not found!"); //log error or throw exception
            return false;
        }catch(IOException | ClassNotFoundException e){
            System.err.println("Error reading from file " + fileName + " " +  e); 
            return false;
        }catch(NumberFormatException e){
            System.err.println("Error parsing double value from input: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public <T> boolean saveDataToFile(List<T> list, String fileName, String msg) {
        try{
            File f = new File(fileName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (T item : list) {
                oos.writeObject(item);
            }
            fos.close();
            oos.close();
            System.out.println(msg);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
}
