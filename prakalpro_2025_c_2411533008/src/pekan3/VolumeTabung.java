package pekan3;
import java.util.Scanner;

public class VolumeTabung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input
        System.out.print("Masukkan jari-jari tabung: ");
        double r = input.nextDouble();
        
        System.out.print("Masukkan tinggi tabung: ");
        double t = input.nextDouble();
        
        // Hitung volume
        double phi = 3.14;
        double volume = phi * r * r * t;
        
        // Output
        System.out.println("Volume tabung = " + volume);
    }
}