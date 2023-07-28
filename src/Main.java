import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        long waktuSekarang = System.currentTimeMillis() / 1000; // Waktu saat ini dalam detik
        int angkaRandom = random.nextInt(100) + 1; // Menghasilkan angka acak antara 1 dan 100
        int coba = 0; // Penghitung jumlah percobaan yang dilakukan oleh pemain
        int angka;

        System.out.println("Selamat datang di Permainan Tebak Angka!");
        System.out.println("Angka telah dipilih secara acak antara 1 hingga 100");
        System.out.println("Anda memiliki 1 menit untuk menebak angka tersebut.\n");
        System.out.println("Mulai tebak angka: ");

        while (true) {
            System.out.print("Tebak angka (1-100): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Maaf, input tidak sesuai"); // Jika input bukan angka, cetak pesan kesalahan
                scanner.next();
                continue; // Lewati iterasi ini dan minta input lagi
            }

            angka = scanner.nextInt();
            if(angka < 1 || angka > 100) {
                System.out.println("Masukkan angka dari 1 sampai 100"); // Validasi input agar angka berada dalam rentang yang valid
                continue; // Lewati iterasi ini dan minta input lagi
            }

            coba++;
            if (angka < angkaRandom) {
                System.out.println("Tebakan anda terlalu rendah"); // Tebakan pemain terlalu rendah
            } else if (angka > angkaRandom){
                System.out.println("Tebakan anda terlalu tinggi"); // Tebakan pemain terlalu tinggi
            } else {
                System.out.println("Selamat, tebakan Anda benar!");
                System.out.println("Anda berhasil menebak angka " + angkaRandom + " dalam " + coba + " kali percobaan");
                break; // Pemain berhasil menebak angka dengan benar, keluar dari perulangan
            }

            // Periksa apakah sudah 60 detik sejak permainan dimulai
            if ((System.currentTimeMillis() / 1000) - waktuSekarang > 60) {
                System.out.println("Waktu sudah habis, anda sudah melakukan percobaan sebanyak " + coba + " kali");
                System.out.println("Angka: " + angkaRandom);
                break; // Waktu habis, keluar dari perulangan
            }
        }
        System.out.println("Terima kasih telah bermain. Sampai jumpa!"); // Pesan akhir permainan
    }
}
