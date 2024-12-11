package program;

import java.util.ArrayList;
import java.util.Scanner;

public class PengelolaanMahasiswa {
    // Inisialisasi ArrayList langsung di awal
    private ArrayList<String> daftarMahasiswa = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public PengelolaanMahasiswa() {
        // Menambahkan data awal (jika diperlukan)
        daftarMahasiswa.add("Budi");
        daftarMahasiswa.add("Ani");
        daftarMahasiswa.add("Joko");
    }

    public void tambahMahasiswa(String nama) {
        daftarMahasiswa.add(nama);
        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan.");
    }

    public void tampilkanMahasiswa() {
        System.out.println("\nDaftar Mahasiswa:");
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada mahasiswa yang terdaftar.");
        } else {
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                System.out.println((i + 1) + ". " + daftarMahasiswa.get(i));
            }
        }
    }

    public String ambilMahasiswa(int indeks) {
        if (indeks >= 0 && indeks < daftarMahasiswa.size()) {
            return daftarMahasiswa.get(indeks);
        } else {
            return "Indeks tidak valid.";
        }
    }

    public void ubahMahasiswa(int indeks, String namaBaru) {
        if (indeks >= 0 && indeks < daftarMahasiswa.size()) {
            daftarMahasiswa.set(indeks, namaBaru);
            System.out.println("Mahasiswa di indeks ke-" + indeks + " berhasil diubah menjadi " + namaBaru + ".");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public void hapusMahasiswa(int indeks) {
        if (indeks >= 0 && indeks < daftarMahasiswa.size()) {
            String nama = daftarMahasiswa.remove(indeks);
            System.out.println("Mahasiswa " + nama + " berhasil dihapus.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public int jumlahMahasiswa() {
        return daftarMahasiswa.size();
    }

    // Method untuk menampilkan menu
    public void menuPengelolaanMahasiswa() {
        int pilihan;
        do {
            System.out.println("\n=== Menu Pengelolaan Mahasiswa ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Ubah Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Jumlah Mahasiswa");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer setelah nextInt()

            switch (pilihan) {
                case 1:
                    tampilkanMahasiswa();
                    break;
                case 2:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = scanner.nextLine();
                    tambahMahasiswa(nama);
                    break;
                case 3:
                    tampilkanMahasiswa();
                    System.out.print("Masukkan indeks mahasiswa yang ingin diubah: ");
                    int indeksUbah = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.nextLine();
                    ubahMahasiswa(indeksUbah - 1, namaBaru);
                    break;
                case 4:
                    tampilkanMahasiswa();
                    System.out.print("Masukkan indeks mahasiswa yang ingin dihapus: ");
                    int indeksHapus = scanner.nextInt();
                    hapusMahasiswa(indeksHapus - 1);
                    break;
                case 5:
                    System.out.println("Jumlah mahasiswa: " + jumlahMahasiswa());
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 6);
    }
}