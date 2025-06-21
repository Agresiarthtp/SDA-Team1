package belajar;

import java.util.Scanner;

class Buku {
    String judul;
    String penulis;


    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;

    }

    public String toString() {
        return "Judul: " + judul + ", Penulis: " + penulis;
    }
}

//Kelas User (Parent Class)
class User {
 String nama;
 String id;

 public User(String nama, String id) {
     this.nama = nama;
     this.id = id;
 }

 public String toString() {
     return "Nama: " + nama + ", ID: " + id;
 }
}

//Kelas Admin (Child Class)
class Admin extends User {
 public Admin(String nama, String id) {
     super(nama, id);
 }

 public void tambahBuku(Perpustakaan perpustakaan, Buku buku) {
     perpustakaan.tambahBuku(buku);
 }

 public void hapusBuku(Perpustakaan perpustakaan, String judul) {
     perpustakaan.hapusBuku(judul);
 }
}

//Kelas Member (Child Class)
class Member extends User {
 public Member(String nama, String id) {
     super(nama, id);
 }

 public void cariBuku(Perpustakaan perpustakaan, String judul) {
     perpustakaan.cariBuku(judul);
 }

 public void tampilkanBuku(Perpustakaan perpustakaan) {
     perpustakaan.tampilkanBuku();
 }
}

//Kelas Perpustakaan Buku
class Perpustakaan {
    Buku[] daftarBuku;
    int jumlahBuku;

    public Perpustakaan(int kapasitas) {
        daftarBuku = new Buku[kapasitas];
        jumlahBuku = 0;
    }
    
 // Menambahkan buku
    public void tambahBuku(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku++] = buku;
            System.out.println("Buku berhasil ditambahkan.");
        } else {
            System.out.println("Perpustakaan penuh, tidak bisa menambahkan buku.");
        }
    }

 // Menghapus buku
    public void hapusBuku(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].judul.equalsIgnoreCase(judul)) {
                for (int j = i; j < jumlahBuku - 1; j++) {
                    daftarBuku[j] = daftarBuku[j + 1];
                }
                daftarBuku[--jumlahBuku] = null;
                System.out.println("Buku berhasil dihapus.");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

 // Mencari buku berdasarkan judul
    public void cariBuku(String judul) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].judul.equalsIgnoreCase(judul)) {
                System.out.println("Buku ditemukan: " + daftarBuku[i]);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Buku tidak ditemukan.");
        }
    }

 // Menampilkan semua buku
    public void tampilkanBuku() {
        if (jumlahBuku == 0) {
            System.out.println("Tidak ada buku di perpustakaan.");
        } else {
            for (int i = 0; i < jumlahBuku; i++) {
                System.out.println(daftarBuku[i]);
            }
        }
    }
}

//Kelas Main (Main Program)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan(100);

        Admin admin = new Admin("Admin1", "A001");
        Member member = new Member("Member1", "M001");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Menambahkan Buku Baru (Admin)");
            System.out.println("2. Menghapus Buku (Admin)");
            System.out.println("3. Mencari Buku Berdasarkan Judul (Member)");
            System.out.println("4. Tampilkan Semua Buku (Member)");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul Buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis Buku: ");
                    String penulis = scanner.nextLine();
                    Buku buku = new Buku(judul, penulis);
                    admin.tambahBuku(perpustakaan, buku);
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String judulHapus = scanner.nextLine();
                    admin.hapusBuku(perpustakaan, judulHapus);
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String judulCari = scanner.nextLine();
                    member.cariBuku(perpustakaan, judulCari);
                    break;
                case 4:
                	member.tampilkanBuku(perpustakaan);
                    break;
                case 5:
                    System.out.println("Keluar dari sistem.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

 }

