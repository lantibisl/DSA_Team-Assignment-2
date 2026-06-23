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
            System.out.println("5. Keluar");
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
                    hapusLagu(playlist, judulHapus);
                    break;
                case 4:
                    System.out.print("Masukkan judul lagu yang ingin dicari: ");
                    String judulCari = scanner.nextLine();
                    cariLagu(playlist, judulCari);
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
            }
        } while (pilihan != 5);

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

    private static void hapusLagu(Lagu[] playlist, String judul) {
    }

    private static void cariLagu(Lagu[] playlist, String judul) {
    }

    private static void urutkanLaguBerdasarkanDurasi(Lagu[] playlist) {
    }
}