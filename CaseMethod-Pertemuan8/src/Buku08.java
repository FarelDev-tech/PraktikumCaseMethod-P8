public class Buku08 {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    // Konstruktor
    public Buku08(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Method tampil
    public void tampilBuku() {
        // Sesuai format jobsheet output
        System.out.println("Kode: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
    }
}
