package Pekan7_2411533008;
import java.util.Scanner;

public class Registrasi_2411533008 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== REGISTRASI AKUN BARU =====");

        System.out.print("Masukkan Username: ");
        String username = input.nextLine();

        System.out.print("Masukkan Password: ");
        String password = input.nextLine();

        System.out.print("Masukkan Email: ");
        String email = input.nextLine();

        System.out.print("Masukkan PIN (8 digit): ");
        int pin = input.nextInt();

        Akun_2411533008 user = new Akun_2411533008();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPinAngka(pin);

        boolean passValid = user.isPasswordValid();
        boolean emailValid = user.isEmailValid();

        // Jika validasi gagal
        if (!passValid || !emailValid) {
            System.out.println("\n--- REGISTRASI GAGAL ---");

            if (!emailValid) {
                System.out.println("Email Anda \"" + email +
                        "\" tidak valid (harus mengandung '@' dan '.').");
            }

            if (!passValid) {
                System.out.println("Password Anda tidak valid (minimal 8 karakter).");
            }

            System.out.println("Silakan coba lagi.");
            return;
        }

       
        System.out.println("\n--- REGISTRASI BERHASIL ---");
        System.out.println("Akun untuk \"" + username + "\" telah berhasil dibuat.");

       
        System.out.println("\n--- Detail Akun ---");
        System.out.println("Username (Lowercase): " + user.getUsernameLowercase());
        System.out.println("Email (Uppercase)   : " + user.getEmailUppercase());

        
        String idPengguna = username + pin;
        System.out.println("ID Pengguna (Gabungan): " + idPengguna);

        
        System.out.println("\n--- Uji Tipe Data (PIN Anda: " + pin + ") ---");
        System.out.println("PIN (int) + 10     = " + (pin + 10));
        System.out.println("PIN (String) + \"10\" = " + (pin + "10"));
    }
}
