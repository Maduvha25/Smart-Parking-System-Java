/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking;

import java.time.LocalDateTime;
import java.util.ArrayList;
    
/**
 *
 * @author USER
 */
public class ParkingManager {
    
    //list of all vehicle  records
    private ArrayList<VehicleRecord> records;
    
   //constructor runs when system starts
    public ParkingManager(){
        
        //load existing records from file into memory
        records=FileManager.loadRecords();
    }
    
    //method called when a vehicle enters parking
    public void vehicleEntry(String plate){
        
        // Loop through all existing records
        for(VehicleRecord r: records){
           
            //if the same vehicle is already inside
            if(r.getPlateNumber().equalsIgnoreCase(plate) && r.isInside()){ 
            System.out.println("Vehicle already inside!");
             return;
            }
        }
        
        records.add(new VehicleRecord(plate,LocalDateTime.now(),null));
        
        //save updated list to fle
       FileManager.saveRecords(records);
       System.out.println("Entry recorded");
       
        
    }
    
    //called when vehicle leaves
    public void vehicleExit(String plate){
      
        //
        for(VehicleRecord r: records){
          
            if(r.getPlateNumber().equalsIgnoreCase(plate) && r.isInside()){
                
                //set to cuurent time 
                r.setExitTime(LocalDateTime.now());
                
                //save updated data
                FileManager.saveRecords(records);
                
                //confrim
                System.out.println("Exit recorded");
                return;
            }
            
            
        }
       
        System.out.println("Vehicle not found");
        
    }
  
    public int countVehiclesInside(){
        int count=0;
        
        for(VehicleRecord r: records){
            
            if(r.isInside())
                
                count++;
            
        }
        
        return count;
        
    }
    
    //method to display all the records
    public void showAllRecords(){
        
        for(VehicleRecord r: records){
            
            //Print full records
            System.out.println(r.getPlateNumber() 
                + " | In: " + r.getEntryTime() 
                + " | Out: " + r.getExitTime()); 
            
        }
        
    }
  
}
