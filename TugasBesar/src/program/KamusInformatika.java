package program;

import java.util.Hashtable;
import java.util.Scanner;

public class KamusInformatika {
    // Deklarasi hashtable untuk menyimpan istilah dan artinya
    private Hashtable<String, String> kamus;

    // Konstruktor untuk inisialisasi hashtable
    public KamusInformatika() {
        kamus = new Hashtable<>();
        isiKamusAwal(); // Tambahkan data awal ke kamus
    }

    // Method untuk menambah entri ke dalam kamus
    public void tambahEntri(String istilah, String arti) {
        kamus.put(istilah.toLowerCase(), arti);
        System.out.println("Istilah '" + istilah + "' berhasil ditambahkan.");
    }

    // Method untuk mencari arti istilah
    public String cariArti(String istilah) {
        String arti = kamus.get(istilah.toLowerCase());
        if (arti != null) {
            return istilah + ": " + arti;
        } else {
            return "Istilah '" + istilah + "' tidak ditemukan di kamus.";
        }
    }

    // Method untuk menampilkan semua istilah dalam kamus
    public void tampilkanSemua() {
        if (kamus.isEmpty()) {
            System.out.println("Kamus masih kosong.");
        } else {
            System.out.println("Daftar istilah di kamus:");
            for (String istilah : kamus.keySet()) {
                System.out.println("- " + istilah + ": " + kamus.get(istilah));
            }
        }
    }

    // Method untuk menambahkan entri awal ke dalam kamus
    private void isiKamusAwal() {
        kamus.put("algoritma", "Langkah-langkah logis untuk memecahkan masalah.");
        kamus.put("array", "Struktur data yang menyimpan elemen dalam urutan indeks.");
        kamus.put("kompilator", "Program yang mengubah kode sumber menjadi kode mesin.");
        kamus.put("debugging", "Proses menemukan dan memperbaiki kesalahan pada program.");
        kamus.put("hashing", "Metode untuk memetakan data ke nilai unik menggunakan fungsi hash.");
        kamus.put("inheritance", "Konsep OOP di mana sebuah kelas mewarisi properti dan metode dari kelas lain.");
        kamus.put("looping", "Proses pengulangan blok kode hingga kondisi tertentu terpenuhi.");
        kamus.put("stack", "Struktur data LIFO (Last In, First Out).");
        kamus.put("queue", "Struktur data FIFO (First In, First Out).");
        kamus.put("polimorfisme", "Kemampuan objek untuk mengambil banyak bentuk dalam OOP.");
    }

    // Program utama
    public void menuKamus() {
        Scanner scanner = new Scanner(System.in);
        KamusInformatika kamus = new KamusInformatika();

        System.out.println("Selamat datang di Kamus Informatika!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah istilah");
            System.out.println("2. Cari arti istilah");
            System.out.println("3. Tampilkan semua istilah");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan istilah: ");
                    String istilah = scanner.nextLine();
                    System.out.print("Masukkan arti: ");
                    String arti = scanner.nextLine();
                    kamus.tambahEntri(istilah, arti);
                    break;
                case 2:
                    System.out.print("Masukkan istilah yang ingin dicari: ");
                    String cariIstilah = scanner.nextLine();
                    System.out.println(kamus.cariArti(cariIstilah));
                    break;
                case 3:
                    kamus.tampilkanSemua();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan Kamus Informatika!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}