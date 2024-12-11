package program;

import java.util.Scanner;

// Kelas untuk simpul (node) pohon biner
class Simpul {
    int data;
    Simpul kiri, kanan;

    Simpul(int nilai) {
        data = nilai;
        kiri = kanan = null;
    }
}

// Kelas untuk pohon biner
public class PohonBiner {
    private Simpul akar;
    private Scanner scanner = new Scanner(System.in);

    public PohonBiner() {
        akar = null;
    }

    public void tambahAkar(int nilai) {
        if (akar == null) {
            akar = new Simpul(nilai);
            System.out.println("Akar " + nilai + " berhasil ditambahkan.");
        } else {
            System.out.println("Akar sudah ada.");
        }
    }

    public void tambahSimpul(int nilai, int nilaiInduk, String posisi) {
        Simpul induk = cariSimpul(akar, nilaiInduk);
        if (induk != null) {
            if (posisi.equalsIgnoreCase("kiri") && induk.kiri == null) {
                induk.kiri = new Simpul(nilai);
                System.out.println("Simpul " + nilai + " berhasil ditambahkan di kiri dari " + nilaiInduk + ".");
            } else if (posisi.equalsIgnoreCase("kanan") && induk.kanan == null) {
                induk.kanan = new Simpul(nilai);
                System.out.println("Simpul " + nilai + " berhasil ditambahkan di kanan dari " + nilaiInduk + ".");
            } else {
                System.out.println("Posisi " + posisi + " sudah terisi atau tidak valid.");
            }
        } else {
            System.out.println("Simpul induk " + nilaiInduk + " tidak ditemukan.");
        }
    }

    public void preOrder() {
        System.out.println("\nPenelusuran Pre-order:");
        preOrderTraversal(akar);
        System.out.println();
    }

    private void preOrderTraversal(Simpul simpul) {
        if (simpul != null) {
            System.out.print(simpul.data + " ");
            preOrderTraversal(simpul.kiri);
            preOrderTraversal(simpul.kanan);
        }
    }

    public void inOrder() {
        System.out.println("\nPenelusuran In-order:");
        inOrderTraversal(akar);
        System.out.println();
    }

    private void inOrderTraversal(Simpul simpul) {
        if (simpul != null) {
            inOrderTraversal(simpul.kiri);
            System.out.print(simpul.data + " ");
            inOrderTraversal(simpul.kanan);
        }
    }

    public void postOrder() {
        System.out.println("\nPenelusuran Post-order:");
        postOrderTraversal(akar);
        System.out.println();
    }

    private void postOrderTraversal(Simpul simpul) {
        if (simpul != null) {
            postOrderTraversal(simpul.kiri);
            postOrderTraversal(simpul.kanan);
            System.out.print(simpul.data + " ");
        }
    }

    public void cari(int nilai) {
        Simpul hasil = cariSimpul(akar, nilai);
        if (hasil != null) {
            System.out.println("Simpul " + nilai + " ditemukan di pohon.");
        } else {
            System.out.println("Simpul " + nilai + " tidak ditemukan di pohon.");
        }
    }

    private Simpul cariSimpul(Simpul simpul, int nilai) {
        if (simpul == null) {
            return null;
        }
        if (simpul.data == nilai) {
            return simpul;
        }
        Simpul kiri = cariSimpul(simpul.kiri, nilai);
        if (kiri != null) {
            return kiri;
        }
        return cariSimpul(simpul.kanan, nilai);
    }

    // Method menu untuk menjalankan program
    public void menuPohonBiner() {
        int pilihan;
        do {
            System.out.println("\nMenu Pohon Biner:");
            System.out.println("1. Tambah Akar");
            System.out.println("2. Tambah Simpul");
            System.out.println("3. Pre-order Traversal");
            System.out.println("4. In-order Traversal");
            System.out.println("5. Post-order Traversal");
            System.out.println("6. Cari Simpul");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nilai untuk akar: ");
                    int nilaiAkar = scanner.nextInt();
                    tambahAkar(nilaiAkar);
                    break;
                case 2:
                    System.out.print("Masukkan nilai simpul baru: ");
                    int nilaiBaru = scanner.nextInt();
                    System.out.print("Masukkan nilai induk: ");
                    int nilaiInduk = scanner.nextInt();
                    System.out.print("Masukkan posisi (kiri/kanan): ");
                    String posisi = scanner.next();
                    tambahSimpul(nilaiBaru, nilaiInduk, posisi);
                    break;
                case 3:
                    preOrder();
                    break;
                case 4:
                    inOrder();
                    break;
                case 5:
                    postOrder();
                    break;
                case 6:
                    System.out.print("Masukkan nilai yang ingin dicari: ");
                    int nilaiCari = scanner.nextInt();
                    cari(nilaiCari);
                    break;
                case 7:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 7);
    }
}