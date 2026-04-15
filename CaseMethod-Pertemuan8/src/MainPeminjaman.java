import java.util.Scanner;

public class MainPeminjaman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Kapasitas awal 0, akan melar sendiri dengan Array Expansion
        SistemPeminjaman08 perpustakaan08 = new SistemPeminjaman08(0); 

        // Data utama
        Mahasiswa08 mhs1 = new Mahasiswa08(22001, "Andi", "Teknik Informatika");
        Mahasiswa08 mhs2 = new Mahasiswa08(22002, "Budi", "Teknik Informatika");
        Mahasiswa08 mhs3 = new Mahasiswa08(22003, "Citra", "Sistem Informasi Bisnis");
        Mahasiswa08[] mhsUtama = {mhs1, mhs2, mhs3};

        Buku08 buku1 = new Buku08("B001", "Algoritma", 2020);
        Buku08 buku2 = new Buku08("B002", "Basis Data", 2019);
        Buku08 buku3 = new Buku08("B003", "Pemrograman", 2021);
        Buku08 buku4 = new Buku08("B004", "Fisika", 2024);
        Buku08[] bukuUtama = {buku1, buku2, buku3, buku4};

        perpustakaan08.tambah(new Peminjaman08(mhs1, buku1, 7));
        perpustakaan08.tambah(new Peminjaman08(mhs2, buku2, 3));
        perpustakaan08.tambah(new Peminjaman08(mhs3, buku3, 10));
        perpustakaan08.tambah(new Peminjaman08(mhs3, buku4, 6));
        perpustakaan08.tambah(new Peminjaman08(mhs1, buku2, 4));

        int menu;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Tambah Data Peminjaman Baru");
            System.out.println("7. Tampilkan Statistik");         
            System.out.println("0. Keluar");

            System.out.print("Pilih: ");
            menu = sc.nextInt();
            sc.nextLine(); // Membersihkan buffer enter

            switch (menu) {
                case 1:
                    System.out.println("--- Daftar Mahasiswa ---");
                    for (Mahasiswa08 mhs : mhsUtama) mhs.tampilMahasiswa();
                    break;
                case 2:
                    System.out.println("--- Daftar Buku ---");
                    for (Buku08 buku : bukuUtama) buku.tampilBuku();
                    break;
                case 3:
                    System.out.println("--- Data Peminjaman ---");
                    perpustakaan08.tampilSemua();
                    break;
                case 4:
                    System.out.println("Setelah diurutkan (Denda Terbesar): ");
                    perpustakaan08.urutkanDenda();
                    perpustakaan08.tampilSemua();
                    break;
                case 5:
                    System.out.print("\nMasukkan NIM: ");
                    int nimCari = sc.nextInt();
                    perpustakaan08.tampilDataSearch(nimCari);
                    break;

                    // Validasi data peminjaman
                case 6:
                    System.out.println("--- Tambah Data Peminjaman Baru ---");
                    System.out.print("Masukkan NIM: ");
                    int inputNim = sc.nextInt();
                    sc.nextLine(); // Clear buffer

                    // Cek NIM di Master Data
                    Mahasiswa08 mhsDitemukan = null;
                    for (Mahasiswa08 mhs : mhsUtama) {
                        if (mhs.nim == inputNim) {
                            mhsDitemukan = mhs;
                            break;
                        }
                    }
                    if (mhsDitemukan == null) {
                        System.out.println("NIM tidak ditemukan!");
                        break;
                    }

                    System.out.print("Masukkan Kode Buku: ");
                    String inputKode = sc.nextLine();
                    
                    // Cek Kode Buku di Data Utama
                    Buku08 bukuDitemukan = null;
                    for (Buku08 buku : bukuUtama) {
                        if (buku.kodeBuku.equalsIgnoreCase(inputKode)) {
                            bukuDitemukan = buku;
                            break;
                        }
                    }
                    
                    if (bukuDitemukan == null) {
                        System.out.println("Kode buku tidak ditemukan!");
                        break;
                    }

                    System.out.print("Masukkan Lama Pinjam: ");
                    int inputLama = sc.nextInt();

                    // Panggil tambah() (Array Expansion otomatis bekerja)
                    perpustakaan08.tambah(new Peminjaman08(mhsDitemukan, bukuDitemukan, inputLama));
                    System.out.println("Data peminjaman berhasil ditambahkan!");
                    break;
                case 7:
                    System.out.println();
                    perpustakaan08.tampilStatistik();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia, coba lagi.");
            } 
        } while (menu != 0);

        sc.close();
    }
}