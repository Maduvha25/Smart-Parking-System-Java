package parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkingManager {

    private ArrayList<VehicleRecord> records;

    public ParkingManager() {
        records = FileManager.loadRecords();
    }

    public boolean vehicleEntry(String plate) {
    for (VehicleRecord record : records) {
        if (record.getPlate().equalsIgnoreCase(plate) && record.getExitTime() == null) {
            // Already inside
            return false;
        }
    }
    VehicleRecord newRecord = new VehicleRecord(plate, LocalDateTime.now(), null);
    records.add(newRecord);
    FileManager.saveRecords(records);
    return true;
}


    public boolean vehicleExit(String plate) {

    for (VehicleRecord r : records) {
        if (r.getPlate().equalsIgnoreCase(plate) && r.getExitTime() == null) {
            r.setExitTime(LocalDateTime.now());
            FileManager.saveRecords(records);
            return true;
        }
    }

    return false; 
}

    public int getParkedCount() {
        int count = 0;
        for (VehicleRecord r : records) {
            if (r.getExitTime() == null) {
                count++;
            }
        }
        return count;
    }

    public String showAllRecords() {
        StringBuilder sb = new StringBuilder();
        for (VehicleRecord r : records) {
            sb.append(r.getPlate())
              .append(" | Entry: ").append(r.getEntryTime())
              .append(" | Exit: ").append(r.getExitTime())
              .append("\n");
        }
        return sb.toString();
    }
}