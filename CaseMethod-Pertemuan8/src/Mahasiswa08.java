public class Mahasiswa08 {
    int nim;
    String nama;
    String prodi;

    // Konstruktor 
    public Mahasiswa08(int nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    // Method tampil
    public void tampilMahasiswa() {
        // Sesuai format jobsheet output
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}
