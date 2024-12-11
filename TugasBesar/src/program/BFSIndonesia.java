package program;

import java.util.*;

public class BFSIndonesia {

    private final Map<Integer, List<Integer>> graf;
    private final Scanner scanner = new Scanner(System.in);

    public BFSIndonesia() {
        graf = new HashMap<>();
    }

    public void tambahEdge(int sumber, int tujuan) {
        graf.putIfAbsent(sumber, new ArrayList<>());
        graf.get(sumber).add(tujuan);
    }

    public void tampilkanGraf() {
        System.out.println("\nRepresentasi Graf (Adjacency List):");
        for (Map.Entry<Integer, List<Integer>> entry : graf.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void bfs(int simpulAwal) {
        Queue<Integer> antrian = new LinkedList<>();
        Set<Integer> sudahDikunjungi = new HashSet<>();
        antrian.add(simpulAwal);
        sudahDikunjungi.add(simpulAwal);

        System.out.println("\nHasil Penelusuran BFS dari simpul " + simpulAwal + ":");
        while (!antrian.isEmpty()) {
            int simpul = antrian.poll();
            System.out.print(simpul + " ");
            for (int tetangga : graf.getOrDefault(simpul, new ArrayList<>())) {
                if (!sudahDikunjungi.contains(tetangga)) {
                    antrian.add(tetangga);
                    sudahDikunjungi.add(tetangga);
                }
            }
        }
        System.out.println();
    }

    // Method menu untuk menjalankan program
    public void menuBFS() {
        int pilihan;
        do {
            System.out.println("\nMenu BFS Indonesia:");
            System.out.println("1. Tambah Edge");
            System.out.println("2. Tampilkan Graf");
            System.out.println("3. Lakukan BFS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan simpul sumber: ");
                    int sumber = scanner.nextInt();
                    System.out.print("Masukkan simpul tujuan: ");
                    int tujuan = scanner.nextInt();
                    tambahEdge(sumber, tujuan);
                    System.out.println("Edge dari " + sumber + " ke " + tujuan + " berhasil ditambahkan.");
                    break;
                case 2:
                    tampilkanGraf();
                    break;
                case 3:
                    System.out.print("Masukkan simpul awal untuk BFS: ");
                    int simpulAwal = scanner.nextInt();
                    bfs(simpulAwal);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }
}