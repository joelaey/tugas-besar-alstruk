import program.BookManager;
import program.PengelolaanMahasiswa;
import program.SortingSearching;
import program.PohonBiner;
import program.KamusInformatika;
import program.BFSIndonesia;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        SortingSearching sortingSearching = new SortingSearching();
        PengelolaanMahasiswa pengelolaanMahasiswa = new PengelolaanMahasiswa();
        BookManager bookManager = new BookManager();
        PohonBiner pohonBiner = new PohonBiner();
        KamusInformatika kamusInformatika = new KamusInformatika();
        BFSIndonesia bfsIndonesia = new BFSIndonesia();

        int pilihan;

        do{
            System.out.println("Menu Tugas Besar AlStrukData");
            System.out.println("1. Sorting dan Searching NIM");
            System.out.println("2. Pengelolaan Mahasiswa dengan ArrayList");
            System.out.println("3. Book Manager dengan LinkedList");
            System.out.println("4. Pohon Biner");
            System.out.println("5. Kamus Informatika dengan HashTable");
            System.out.println("6. BFS Indonesia");
            System.out.println("7. Keluar");
            System.out.print("Masukkan Pilihan : ");

            pilihan = in.nextInt();
            in.nextLine();
            switch (pilihan) {
                case 1:
                    sortingSearching.displaySortingSearching();
                    break;
                case 2:
                    pengelolaanMahasiswa.menuPengelolaanMahasiswa();
                    break;
                case 3:
                    bookManager.menuBuku();
                    break;
                case 4:
                    pohonBiner.menuPohonBiner();
                    break;
                case 5:
                    kamusInformatika.menuKamus();
                    break;
                case 6:
                    bfsIndonesia.menuBFS();
                    break;
                case 7:
                    System.out.println("Keluar dari program...");
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }while(pilihan != 7);
    }
}