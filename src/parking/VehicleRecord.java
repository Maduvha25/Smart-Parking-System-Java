/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking;

import java.time.LocalDateTime;

/**
 *
 * @author USER
 */
public class VehicleRecord {
    
    private String plateNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public VehicleRecord(String plateNumber, LocalDateTime entryTime, LocalDateTime exitTime) {
        this.plateNumber = plateNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
    
    //Set exit time when the vehicles leaves
    public void setExitTime(LocalDateTime exitTime){
        this.exitTime=exitTime;
    }
    
    //check if vehicle is still inside(no exit time yet)
    public boolean isInside(){
        return exitTime ==null;
    }
    
    //convert object to text for saving into file
    @Override
    public String toString(){
        return plateNumber+","+ entryTime +","+ exitTime;
    }
   
}
