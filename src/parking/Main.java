/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking;
import javax.swing.JFrame;
/**
 *
 * @author USER
 */
public class Main {
    
    
    public static void main(String[] args) {

        JFrame frame = new JFrame("Smart Parking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.add(new ParkingGUI());

        frame.setVisible(true);
    }
    
}
