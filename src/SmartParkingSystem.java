
import java.util.Scanner;
import parking.ParkingManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class SmartParkingSystem {
    public static void main(String[] args) {

        ParkingManager manager = new ParkingManager();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- SMART PARKING SYSTEM ---");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Vehicles Inside");
            System.out.println("4. Show Records");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Plate number: ");
                    manager.vehicleEntry(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Plate number: ");
                    manager.vehicleExit(sc.nextLine());
                    break;

                case 3:
                    System.out.println("Cars inside: " + manager.countVehiclesInside());
                    break;

                case 4:
                    manager.showAllRecords();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
