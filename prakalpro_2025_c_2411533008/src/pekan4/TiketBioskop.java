package pekan4;
import java.util.Scanner;

public class TiketBioskop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Masukkan Nama Pembeli : ");
        String nama = input.nextLine();

        System.out.print("Masukkan Jumlah Tiket : ");
        int jumlahTiket = input.nextInt();

        System.out.print("Masukkan Hari (1=Senin-Kamis, 2=Jumat, 3=Sabtu-Minggu) : ");
        int hari = input.nextInt();

        System.out.print("Masukkan Waktu Tayang (1=Pagi, 2=Siang, 3=Malam) : ");
        int waktu = input.nextInt();

        System.out.print("Masukkan Jenis Studio (1=Regular, 2=Deluxe, 3=Premium) : ");
        int studio = input.nextInt();

        // Harga dasar
        int hargaDasar = 0;
        switch (studio) {
            case 1: hargaDasar = 35000; break; // Regular
            case 2: hargaDasar = 50000; break; // Deluxe
            case 3: hargaDasar = 75000; break; // Premium
        }

        // Biaya tambahan hari
        double biayaHari = 0;
        String ketHari = "";
        if (hari == 1) { 
            biayaHari = 0; 
            ketHari = "Senin-Kamis"; 
        }
        else if (hari == 2) { 
            biayaHari = 0.10; 
            ketHari = "Jumat"; 
        }
        else if (hari == 3) { 
            biayaHari = 0.30; 
            ketHari = "Sabtu-Minggu"; 
        }

        // Biaya tambahan waktu
        double biayaWaktu = 0;
        String ketWaktu = "";
        if (waktu == 1) { 
            biayaWaktu = 0; 
            ketWaktu = "Pagi"; 
        }
        else if (waktu == 2) { 
            biayaWaktu = 0.10; 
            ketWaktu = "Siang"; 
        }
        else if (waktu == 3) { 
            biayaWaktu = 0.20; 
            ketWaktu = "Malam"; 
        }

        // Jenis studio
        String ketStudio = "";
        if (studio == 1) ketStudio = "Regular";
        else if (studio == 2) ketStudio = "Deluxe";
        else if (studio == 3) ketStudio = "Premium";

        // Hitung harga per tiket
        double hargaPerTiket = hargaDasar + (hargaDasar * biayaHari) + (hargaDasar * biayaWaktu);

        // Subtotal
        double subtotal = hargaPerTiket * jumlahTiket;

        // Diskon 20% jika beli >= 5 tiket
        double diskon = 0;
        if (jumlahTiket >= 5) {
            diskon = subtotal * 0.20;
        }

        // Total bayar
        double totalBayar = subtotal - diskon;

        // Output
        System.out.println("\n===== PEMBELIAN TIKET BIOSKOP =====");
        System.out.println("Nama Pembeli\t: " + nama);
        System.out.println("Jumlah Tiket\t: " + jumlahTiket);
        System.out.println("Hari\t\t: " + ketHari);
        System.out.println("Waktu Tayang\t: " + ketWaktu);
        System.out.println("Jenis Studio\t: " + ketStudio);
        System.out.println("-----------------------------------");
        System.out.println("Harga Dasar\t: Rp " + hargaDasar + "/tiket");
        System.out.println("Biaya Hari\t: +" + (int)(biayaHari*100) + "%");
        System.out.println("Biaya Waktu\t: +" + (int)(biayaWaktu*100) + "%");
        System.out.println("Harga per Tiket\t: Rp " + (int)hargaPerTiket);
        System.out.println("Subtotal\t: Rp " + (int)subtotal);
        System.out.println("Diskon (20%)\t: Rp " + (int)diskon);
        System.out.println("-----------------------------------");
        System.out.println("TOTAL BAYAR\t: Rp " + (int)totalBayar);

        input.close();
    }
}
