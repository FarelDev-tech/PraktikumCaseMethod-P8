import java.util.Scanner;

public class MainPeminjaman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SistemPeminjaman08 perpustakaan08 = new SistemPeminjaman08(10);
        
        // DATA TEST Mahasiswa
        Mahasiswa08 mhs1 = new Mahasiswa08(22001, "Andi", "Teknik Informatika");
        Mahasiswa08 mhs2 = new Mahasiswa08(22002, "Budi", "Teknik Informatika");
        Mahasiswa08 mhs3 = new Mahasiswa08(22003, "Citra", "Sistem Informasi Bisnis");

        // DATA TEST Buku
        Buku08 buku1 = new Buku08("B001", "Algoritma", 2020);
        Buku08 buku2 = new Buku08("B002", "Basis Data", 2019);
        Buku08 buku3 = new Buku08("B003", "Pemrograman", 2021);
        Buku08 buku4 = new Buku08("B004", "Fisika", 2024);

        // DATA TEST Peminjaman
        perpustakaan08.tambah(new Peminjaman08(mhs1, buku1, 7));
        perpustakaan08.tambah(new Peminjaman08(mhs2, buku2, 3));
        perpustakaan08.tambah(new Peminjaman08(mhs3, buku3, 10));
        perpustakaan08.tambah(new Peminjaman08(mhs3, buku4, 6));
        perpustakaan08.tambah(new Peminjaman08(mhs1, buku2, 4));

        // Pilihan Menu Perpustakaan
        int menu;
        do {
            System.out.println("=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");

            System.out.print("Pilih: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Daftar Mahasiswa: ");
                    mhs1.tampilMahasiswa();
                    mhs2.tampilMahasiswa();
                    mhs3.tampilMahasiswa();
                    break;
                case 2:
                    System.out.println("Daftar Buku: ");
                    buku1.tampilBuku();
                    buku2.tampilBuku();
                    buku3.tampilBuku();
                    buku4.tampilBuku();
                    break;
                case 3:
                    System.out.println("Data Peminjaman: ");

                    perpustakaan08.tampilSemua();
                    break;
                case 4:
                    System.out.println("Setelah diurutkan (Denda Terbesar): ");
                    perpustakaan08.urutkanDenda();
                    perpustakaan08.tampilSemua();
                    break;
                case 5:
                    System.out.print("Masukkan NIM: ");
                    int nimCari = sc.nextInt();
                    perpustakaan08.tampilDataSearch(nimCari);
                    break;
                case 0:
                    System.out.println("Terima kasih atas kunjungannya!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia, coba lagi!");
            } 
        } while (menu != 0);

        sc.close();
    }
}
