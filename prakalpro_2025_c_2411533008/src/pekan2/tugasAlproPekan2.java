package pekan2;
public class tugasAlproPekan2 {
    public static void main(String[] args) {
        // Deklarasi variabel dengan 4 tipe data
        int jumlahKopi = 50;            // int → jumlah stok kopi
        float hargaKopi = 25000.5f;     // float → harga per bungkus kopi
        char ukuran = 'L';              // char → ukuran kopi (S, M, L)
        boolean tersedia = true;        // boolean → status ketersediaan kopi

        // Menampilkan data dengan format rapi
        System.out.println("===== Data Kopi =====");
        System.out.println("Jumlah Stok   : " + jumlahKopi + " bungkus");
        System.out.println("Harga Kopi    : Rp " + hargaKopi);
        System.out.println("Ukuran Kopi   : " + ukuran);
        System.out.println("Tersedia      : " + tersedia);
    }
}