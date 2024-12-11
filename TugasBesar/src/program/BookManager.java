package program;

import java.util.Scanner;

// Class Node untuk menyimpan data buku
class Node {
    String title;
    String author;
    int year;
    Node prev;
    Node next;

    // Konstruktor untuk Node
    public Node(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.prev = null;
        this.next = null;
    }
}

// Class DoublyLinkedList untuk mengelola daftar buku
class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Konstruktor untuk DoublyLinkedList
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Menambah buku baru ke akhir daftar
    public void addBook(String title, String author, int year) {
        Node newNode = new Node(title, author, year);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Buku '" + title + "' berhasil ditambahkan.");
    }

    // Menghapus buku berdasarkan judul
    public void removeBook(String title) {
        Node current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Buku '" + title + "' berhasil dihapus.");
                return;
            }
            current = current.next;
        }
        System.out.println("Buku dengan judul '" + title + "' tidak ditemukan.");
    }

    // Menampilkan seluruh daftar buku
    public void displayBooks() {
        if (head == null) {
            System.out.println("Tidak ada buku dalam daftar.");
            return;
        }

        Node current = head;
        System.out.println("Daftar Buku:");
        while (current != null) {
            System.out.println("Judul: " + current.title + ", Penulis: " + current.author + ", Tahun: " + current.year);
            current = current.next;
        }
    }

    // Mencari buku berdasarkan judul
    public void searchBook(String title) {
        Node current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                System.out.println("Buku ditemukan! Judul: " + current.title + ", Penulis: " + current.author + ", Tahun: " + current.year);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku dengan judul '" + title + "' tidak ditemukan.");
    }
}

// Class utama untuk menjalankan program
public class BookManager {
    public void menuBuku() {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList bookList = new DoublyLinkedList();
        int pilihan;

        do {
            System.out.println("\nMenu Manajemen Buku:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Tampilkan Daftar Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Untuk membersihkan buffer input

            switch (pilihan) {
                case 1:
                    // Menambah buku
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // membersihkan buffer
                    bookList.addBook(title, author, year);
                    break;
                case 2:
                    // Menghapus buku berdasarkan judul
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String removeTitle = scanner.nextLine();
                    bookList.removeBook(removeTitle);
                    break;
                case 3:
                    // Mencari buku berdasarkan judul
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String searchTitle = scanner.nextLine();
                    bookList.searchBook(searchTitle);
                    break;
                case 4:
                    // Menampilkan seluruh daftar buku
                    bookList.displayBooks();
                    break;
                case 5:
                    // Keluar dari program
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}