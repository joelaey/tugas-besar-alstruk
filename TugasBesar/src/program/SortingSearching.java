package program;

import java.util.Scanner;
import java.util.ArrayList;

public class SortingSearching {
    static ArrayList<Integer> mahasiswaList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public void displaySortingSearching(){
        setDataNIM();
        int pilihan;

        do{
            System.out.println("Pengurutan dan Pencarian NIM");
            System.out.println("1. Tampilkan NIM");
            System.out.println("2. Tambahkan NIM");
            System.out.println("3. Hapus NIM");
            System.out.println("4. Urutkan NIM");
            System.out.println("5. Cari NIM");
            System.out.println("6. Keluar");
            System.out.print("Masukkan Pilihan : ");

            pilihan = in.nextInt();
            in.nextLine();
            switch (pilihan) {
                case 1:
                    displayNIM();
                    break;
                case 2:
                    tambahNIM();
                    break;
                case 3:
                    hapusNIM();
                    break;
                case 4:
                    urutkanNIM();
                    break;
                case 5:
                    cariNIM();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }while(pilihan != 6);
    }

    public static void setDataNIM(){
        for(int i = 0; i <= 10; i ++){
            int nim = 1237050000 + i;
            mahasiswaList.add(nim);
        }
    }

    public static void displayNIM(){
        if(mahasiswaList.isEmpty()){
            System.out.println("Data NIM kosong !");
        }else{
            for (Integer nim : mahasiswaList) {
                System.out.println(nim);
            }
        }
    }

    public static void tambahNIM() {
        boolean tambahNIM = true;
    
        while (tambahNIM) {
            System.out.print("Masukkan NIM / ketik 'selesai' untuk keluar: ");
            String input = in.nextLine();
            
            if (input.equalsIgnoreCase("selesai")) {
                System.out.println("Keluar dari menu tambah NIM...");
                tambahNIM = false;
            } else {
                try {
                    int nim = Integer.parseInt(input);
                    mahasiswaList.add(nim);
                    System.out.println("NIM berhasil ditambahkan.");
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka.");
                }
            }
        }
    }

    public static void hapusNIM() {
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        int nim = in.nextInt();
        if (mahasiswaList.remove(Integer.valueOf(nim))) {
            System.out.println("NIM berhasil dihapus.");
        } else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    public static void urutkanNIM() {
        System.out.println("Pilih metode pengurutan:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Masukkan pilihan: ");
        int pilihan = in.nextInt();

        if (pilihan == 1) {
            bubbleSortAscending();
            System.out.println("Daftar NIM berhasil diurutkan secara ascending.");
        } else if (pilihan == 2) {
            bubbleSortDescending();
            System.out.println("Daftar NIM berhasil diurutkan secara descending.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        displayNIM();
    }

    public static void bubbleSortAscending() {
        int n = mahasiswaList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mahasiswaList.get(j) > mahasiswaList.get(j + 1)) {
                    int temp = mahasiswaList.get(j);
                    mahasiswaList.set(j, mahasiswaList.get(j + 1));
                    mahasiswaList.set(j + 1, temp);
                }
            }
        }
    }

    public static void bubbleSortDescending() {
        int n = mahasiswaList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mahasiswaList.get(j) < mahasiswaList.get(j + 1)) {
                    int temp = mahasiswaList.get(j);
                    mahasiswaList.set(j, mahasiswaList.get(j + 1));
                    mahasiswaList.set(j + 1, temp);
                }
            }
        }
    }

    public static void cariNIM() {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Daftar NIM kosong. Tidak dapat melakukan pencarian.");
            return;
        }

        System.out.print("Masukkan NIM yang ingin dicari: ");
        int nim = in.nextInt();

        bubbleSortAscending();

        int hasil = binarySearch(mahasiswaList, nim);
        if (hasil != -1) {
            System.out.println("NIM ditemukan pada indeks: " + hasil);
        } else {
            System.out.println("NIM tidak ditemukan di daftar.");
        }
    }

    public static int binarySearch(ArrayList<Integer> list, int target) {
        int kiri = 0;
        int kanan = list.size() - 1;

        while (kiri <= kanan) {
            int tengah = kiri + (kanan - kiri) / 2;
            int nilaiTengah = list.get(tengah);

            if (nilaiTengah == target) {
                return tengah;
            }

            if (nilaiTengah < target) {
                kiri = tengah + 1;
            } else {
                kanan = tengah - 1;
            }
        }

        return -1; 
    }
}
