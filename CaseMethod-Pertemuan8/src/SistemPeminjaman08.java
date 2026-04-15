public class SistemPeminjaman08 {
    Peminjaman08[] listPinjam;
    int index;

    // Konstruktor
    public SistemPeminjaman08(int kuota) {
        // Kapasitas awal bisa 0, nanti akan otomatis membesar 
        listPinjam = new Peminjaman08[kuota];
        index = 0;
    }

    public void tambah(Peminjaman08 pinjam) {
        // Membuat array baru yang ukurannya lebih besar 1 dari array lama
        Peminjaman08[] arrayBaru = new Peminjaman08[index + 1];
        
        // Menyalin data lama ke array baru
        for (int i = 0; i < index; i++) {
            arrayBaru[i] = listPinjam[i];
        }
        
        // Memasukkan data baru yang ada di posisi terakhir
        arrayBaru[index] = pinjam;

        // Menjadikan array baru disini sebagai array utama
        listPinjam = arrayBaru;
        index++;
    }

    // Method tampil semua data peminjaman
    public void tampilSemua() {
        for (int i = 0; i < index; i++) {
            listPinjam[i].tampilPeminjaman();
        }
    }

    // Method tuk mengurutkan berdasarkan denda (terbesar ke terkecil) (Insertion Sort)
    public void urutkanDenda() {
        for (int i = 1; i < index; i++) {
            Peminjaman08 temp = listPinjam[i];
            int j = i - 1;
            // Mencari posisi temp dengan denda terbesar
            while (j >= 0 && listPinjam[j].denda < temp.denda) {
                listPinjam[j + 1] = listPinjam[j];
                j--;
            }
            listPinjam[j + 1] = temp;
        }
    }

    // Method tuk mengurutkan berdasarkan NIM (terkecil ke terbesar) 
    public void urutkanNIM() {
        for (int i = 0; i < index - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < index; j++) {
                if (listPinjam[j].mhs.nim < listPinjam[minIndex].mhs.nim) {
                    minIndex = j;
                }
            }
            Peminjaman08 temp = listPinjam[i];
            listPinjam[i] = listPinjam[minIndex];
            listPinjam[minIndex] = temp;
        }
    }

    // Setelah diurutkan atau disorting selanjutnya cari NIM menggunakan binary search
    public int cariNIM(int nimCari, int awal, int akhir) {
        // Mencari NIM Binary Search
        if (awal <= akhir) {
            int tengah = (awal + akhir) / 2;
            if (listPinjam[tengah].mhs.nim == nimCari) {
                return tengah;
            } else if (listPinjam[tengah].mhs.nim < nimCari) {
                return cariNIM(nimCari, tengah + 1, akhir);
            } else {
                return cariNIM(nimCari, awal, tengah - 1);
            }
        }
        return -1;
    }

    // Method pembungkus cariNIM dan urutkanNIM dan tampil data search
    public void tampilDataSearch(int nimCari) {
        urutkanNIM();
        int indexCari = cariNIM(nimCari, 0, index - 1);
        if (indexCari != -1) {
            listPinjam[indexCari].tampilPeminjaman();
        } else {
            System.out.println("NIM " + nimCari + " tidak ditemukan!");
        }
    }

    public void tampilStatistik() {
        int totalDendaKeseluruhan = 0;
        int jumlahTerlambat = 0;
        int jumlahTepatWaktu = 0;

        for (int i = 0; i < index; i++) {
            totalDendaKeseluruhan += listPinjam[i].denda;

            if (listPinjam[i].terlambat > 0) {
                jumlahTerlambat++;
            } else {
                jumlahTepatWaktu++;
            }
        }

        System.out.println("=== STATISTIK PEMINJAMAN ===");
        System.out.println("Total Denda Keseluruhan: Rp " + totalDendaKeseluruhan);
        System.out.println("Jumlah Peminjaman Terlambat: " + jumlahTerlambat);
        System.out.println("Jumlah Peminjaman Tepat Waktu: " + jumlahTepatWaktu);
    }
}