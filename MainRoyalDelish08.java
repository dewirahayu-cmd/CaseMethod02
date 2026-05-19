import java.util.Scanner;

// Class MainRoyalDelish08 adalah class utama yang menjalankan sistem antrian
public class MainRoyalDelish08 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AntrianDLL08 antrian = new AntrianDLL08();

        PesananDLL08 pesananList = new PesananDLL08();

        int pilihan;

        // struktur do-while agar menu terus berjalan sampai pengguna memilih keluar
        do {
            System.out.println("\n==============================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("==============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {

                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = scan.nextLine();
                    System.out.print("No HP        : ");
                    String noHp = scan.nextLine();
                    antrian.tambahAntrian(nama, noHp);
                    break;

                case 2:
                    antrian.cetakAntrian();
                    break;

                case 3:
                    System.out.print("Nomor Antrian yang dipanggil : ");
                    int noAntrian = scan.nextInt();
                    scan.nextLine();
                    Pembeli08 pembeli = antrian.hapusAntrian(noAntrian);

                    if (pembeli != null) {
                        System.out.print("Kode Pesanan  : ");
                        int kode = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Nama Pesanan  : ");
                        String namaPesanan = scan.nextLine();
                        System.out.print("Harga         : ");
                        int harga = scan.nextInt();
                        scan.nextLine();

                        // buat objek Pesanan menggunakan konstruktor
                        // lalu tambahkan ke DLL pesanan menggunakan addLast
                        Pesanan08 pesanan = new Pesanan08(kode, namaPesanan, harga, pembeli.namaPembeli);
                        pesananList.tambahPesanan(pesanan);

                        System.out.println(pembeli.namaPembeli + " telah memesan " + namaPesanan);
                    }
                    break;

                case 4:
                    pesananList.cetakLaporan();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid.");
            }

        } while (pilihan != 0);

        scan.close();
    }
}