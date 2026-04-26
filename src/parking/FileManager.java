/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author USER
 */

//handles saving and loading records from file
public class FileManager {
    
    private static final String FILE_NAME = "Parking_Log.txt";
    
    //reads dtata from file and loads into memory
    public static  ArrayList<VehicleRecord> loadRecords(){
    
        ArrayList<VehicleRecord> list = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            
            //variable will store each line fromthe file
            String line;
            
            while((line=br.readLine()) != null){
                
                //Split line into parts using comma (plate,entry,exit)
                 String[] p = line.split(",");
                 
                 //first part is plate
                 String plate=p[0];
                 
                 //2nd part is entry time (convert text to date)
                 LocalDateTime entry = LocalDateTime.parse(p[1]);
                 
                 //if null the car is still insde
                LocalDateTime exit;
if (p[2].equals("null")) {
    exit = null;
} else {
    exit = LocalDateTime.parse(p[2]);
}
                 
                 //add rexord to the list
                 list.add(new VehicleRecord(plate,entry,exit));
                 
            }
                
        } 
        
        //if file does not exist or error happens
        //(first time running the program)
        catch(IOException e){
            
        }
        
           //return recorded records
           return list;
        }
    
    //method that saves all records into file
    public static void saveRecords(ArrayList<VehicleRecord> records){
        
        //OPENS FILE FOR WRITING
        try(PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))){
            
            //LOOP THROUGH EVERY VEHICLE RECORD
            for(VehicleRecord r: records){
                
                //save record as a line in a file
                pw.println(r.toString());
            }
        }
        
        //handle file errors
        catch(IOException e){
            
            //print error detail in console
             e.printStackTrace();
            
        }
       
        
    }
    
}
