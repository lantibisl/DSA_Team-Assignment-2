// TUGAS KELOMPOK KE-2 DSA
// Group 1
// 1. GHEFIRA LA-AGNASRASYA GRACIANETTE (2902789852)
// 2. DEVITA NUR ARDIANA (2902795685)
// 3. LANTIB ISLAMI (2902789215)
// 4. GREENITA MANALU (2902783621)
// 5. FEBRY PRASETYA (2902787752)

import java.util.Scanner;

public class PlaylistArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        Lagu[] playlist = new Lagu[10];
        int jumlahLagu = 0;

        do {
            System.out.println("=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan berdasarkan durasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // buffer newline

            switch (pilihan) {
                case 1:
                    tampilkanSemuaLagu(playlist, jumlahLagu);
                    break;
                case 2:
                    System.out.print("Masukkan judul lagu: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan artis: ");
                    String artis = scanner.nextLine();
                    System.out.print("Masukkan durasi (dalam menit): ");
                    double durasi = scanner.nextDouble();
                    scanner.nextLine();
                    Lagu laguBaru = new Lagu(judul, artis, durasi);
                    jumlahLagu = tambahLagu(playlist, laguBaru, jumlahLagu);
                    System.out.println("Lagu berhasil ditambahkan!\n");
                    break;
                case 3:
                    System.out.print("Masukkan judul lagu yang ingin dihapus: ");
                    String judulHapus = scanner.nextLine();
                    jumlahLagu = hapusLagu(playlist, judulHapus, jumlahLagu);
                    break;
                case 4:
                    System.out.print("Masukkan judul lagu yang ingin dicari: ");
                    String judulCari = scanner.nextLine();
                    cariLagu(playlist, judulCari);
                    break;
                case 5:
                    urutkanLaguBerdasarkanDurasi(playlist, jumlahLagu);
                    break;
                case 6:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
            }
        } while (pilihan != 6);

        scanner.close();
    }

    // Fungsi untuk menampilkan semua lagu
    private static void tampilkanSemuaLagu(Lagu[] playlist, int jumlahLagu) {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong.\n");
            return;
        }
        System.out.println("\n=== DAFTAR LAGU ===");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.print((i + 1) + ". ");
            playlist[i].tampilkanInfo();
        }
    }

    // Fungsi untuk menambahkan lagu ke array
    private static int tambahLagu(Lagu[] playlist, Lagu laguBaru, int jumlahLagu) {
        playlist[jumlahLagu] = laguBaru;
        return jumlahLagu + 1;
    }

    // fungsi untuk menghapus lagu
    private static int hapusLagu(Lagu[] playlist, String judul, int jumlahLagu) {
        // looping array playlist
        for (int i = 0; i < playlist.length; i++) {
            // cek apakah lagu ada di array
            if (playlist[i] != null && playlist[i].getJudul().equalsIgnoreCase(judul)) {
                jumlahLagu--;
                // geser semua lagu setelahnya ke kiri
                for (int j = i; j < playlist.length - 1; j++) {
                    playlist[j] = playlist[j + 1];
                }
                playlist[playlist.length - 1] = null;
                System.out.println("Lagu berhasil dihapus.\n");
                return jumlahLagu;
            }
        }
        // print jika lagu tidak ditemukan
        System.out.println("Lagu tidak ditemukan.\n");
        return jumlahLagu;
    }

    // fungsi untuk mencari lagu
    private static void cariLagu(Lagu[] playlist, String judul) {
        // variable untuk menandai apakah lagu ditemukan
        boolean ditemukan = false;
        // looping array playlist
        for (int i = 0; i < playlist.length; i++) {
            // cek apakah lagu ada di array
            if (playlist[i] != null && playlist[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Lagu berhasil ditemukan");
                playlist[i].tampilkanInfo();
                ditemukan = true;
                // hentikan pencarian setelah lagu ditemukan
                break;
            }
        }
        // print jika lagu tidak ditemukan
        if (!ditemukan) {
            System.out.println("Lagu tidak ditemukan\n");
        }
    }

    // fungsi untuk mengurutkan lagu berdasarkan durasi
    private static void urutkanLaguBerdasarkanDurasi(Lagu[] playlist, int jumlahLagu) {
        System.out.print("\nDaftar lagu sebelum pengurutan:");
        tampilkanSemuaLagu(playlist, jumlahLagu);

        // salin playlist ke array baru agar data asli tidak berubah
        Lagu[] sortedPlaylist = new Lagu[jumlahLagu];
        for (int i = 0; i < jumlahLagu; i++) {
            sortedPlaylist[i] = playlist[i];
        }

        // bubble sort
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - i - 1; j++) {
                // bandingkan durasi lagu elemen saat ini dan sebelahnya
                if (sortedPlaylist[j].getDurasi() > sortedPlaylist[j + 1].getDurasi()) {
                    // tukar posisi jika durasi lagu lebih besar dari elemen sebelahnya
                    Lagu temp = sortedPlaylist[j];
                    sortedPlaylist[j] = sortedPlaylist[j + 1];
                    sortedPlaylist[j + 1] = temp;
                }
            }
        }

        System.out.print("Daftar lagu sesudah pengurutan:");
        tampilkanSemuaLagu(sortedPlaylist, jumlahLagu);
    }
}