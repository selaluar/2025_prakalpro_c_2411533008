package pekan5_2411533008;

	import java.util.Scanner;

	public class Polabelahketupat_2411533008 {
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        int n;

	        System.out.print("Masukkan ukuran pola (contoh 5–10): ");
	        n = input.nextInt();

	        // Bagian atas bingkai
	        System.out.print("#");
	        for (int i = 0; i < 4 * n; i++) {
	            System.out.print("-");
	        }
	        System.out.println("#");

	        // Bagian atas pola
	        for (int i = 1; i <= n; i++) {
	            // Spasi kiri
	            for (int j = 0; j < (n - i); j++) {
	                System.out.print(" ");
	            }

	            // Pola kiri "<>"
	            for (int j = 0; j < i; j++) {
	                System.out.print("<>");
	            }

	            // Titik di tengah
	            for (int j = 0; j < 4 * (n - i); j++) {
	                System.out.print(".");
	            }

	            // Pola kanan "<>"
	            for (int j = 0; j < i; j++) {
	                System.out.print("<>");
	            }

	            System.out.println();
	        }

	        // Bagian bawah pola (kebalikan)
	        for (int i = n - 1; i >= 1; i--) {
	            // Spasi kiri
	            for (int j = 0; j < (n - i); j++) {
	                System.out.print(" ");
	            }

	            // Pola kiri "<>"
	            for (int j = 0; j < i; j++) {
	                System.out.print("<>");
	            }

	            // Titik di tengah
	            for (int j = 0; j < 4 * (n - i); j++) {
	                System.out.print(".");
	            }

	            // Pola kanan "<>"
	            for (int j = 0; j < i; j++) {
	                System.out.print("<>");
	            }

	            System.out.println();
	        }

	        // Bagian bawah bingkai
	        System.out.print("#");
	        for (int i = 0; i < 4 * n; i++) {
	            System.out.print("-");
	        }
	        System.out.println("#");

	        input.close();
	    }
	}
