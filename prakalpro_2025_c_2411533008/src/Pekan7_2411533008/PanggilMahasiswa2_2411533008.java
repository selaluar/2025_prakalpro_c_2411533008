package Pekan7_2411533008;
import java.util.Scanner; 
public class PanggilMahasiswa2_2411533008 {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.print("NIM: ");
		String x= input.nextLine();
		System.out.print("Nama: ");
		String y= input.nextLine();
		Mahasiswa_2411533008 a= new Mahasiswa_2411533008();
		a.setNIm2(x);
		a.setNama(y);
		
		if (x.startsWith("25")) {
			System.out.println(y + " anda angkatan 2025");
		}
		
		if(x.contains("1153")) {
			System.out.println("Anda Mahasiswa Informatika");
		}
		
		a.cetak2();
		input.close();
		
	}
}