package parking;

import java.time.LocalDateTime;

public class VehicleRecord {

    private String plate;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public VehicleRecord(String plate, LocalDateTime entryTime, LocalDateTime exitTime) {
        this.plate = plate;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String getPlate() {
        return plate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return plate + "," + entryTime + "," + exitTime;
    }
}