public class Peminjaman08 {
    // Relasi Objeknya 
    Mahasiswa08 mhs;
    Buku08 buku;

    // Atribut
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;

    // Konstruktor
    public Peminjaman08(Mahasiswa08 mhs, Buku08 buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;

        // Digunakan untuk agar bisa memanggil otomatis denda disaat buat objek
        this.hitungDenda(); 
    }

    public void hitungDenda() {
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam - batasPinjam;
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }

    public void tampilPeminjaman() {
        System.out.println(mhs.nama + " | " + buku.judul + " | Lama: " + lamaPinjam + " | Terlambat: " + terlambat + " | Denda: " + denda);
    }
}
