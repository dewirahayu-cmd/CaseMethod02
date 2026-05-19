// Class PesananDLL08 mengimplementasikan struktur data Double Linked List
// untuk mengelola seluruh pesanan makanan yang masuk dari pembeli
public class PesananDLL08 {
    NodePesanan08 head;   
    NodePesanan08 tail;  

    // konstruktor menginisialisasi list pesanan dalam kondisi kosong
    public PesananDLL08() {
        head = null;
        tail = null;
    }

    // method isEmpty() mengecek apakah list pesanan kosong atau tidak
    public boolean isEmpty() {
        return head == null;
    }

    // method tambahPesanan() menambahkan pesanan baru ke bagian akhir list
    public void tambahPesanan(Pesanan08 pesanan) {
        NodePesanan08 newNode = new NodePesanan08(pesanan);

        // jika list masih kosong, node baru langsung menjadi head sekaligus tail
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // sambungkan node baru ke belakang tail yang ada saat ini
            tail.next = newNode;   
            newNode.prev = tail;   
            tail = newNode;        
        }
    }

    // method sortByNamaPesanan() mengurutkan pesanan berdasarkan nama pesanan secara alfabetis
    public void sortByNamaPesanan() {
        if (isEmpty()) return;

        boolean swapped;
        do {
            swapped = false;
            NodePesanan08 current = head;

            // traversal dari head, bandingkan current dengan node berikutnya
            while (current.next != null) {
                // compareToIgnoreCase membandingkan nama secara alfabetis tanpa case sensitive
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    // swap data antar node (tukar isi data, bukan posisi node-nya)
                    Pesanan08 temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true; 
                }
                current = current.next;
            }
            // jika dalam satu putaran tidak ada pertukaran (swapped = false),
            // berarti data sudah terurut dan loop berhenti
        } while (swapped);
    }

    // method cetakLaporan() menampilkan seluruh pesanan yang sudah diurutkan
    // beserta total pendapatan restoran
    public void cetakLaporan() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan masuk.");
            return;
        }

        // panggil sortByNamaPesanan() terlebih dahulu sebelum ditampilkan
        sortByNamaPesanan();

        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");
        System.out.printf("%-14s %-20s %s%n", "Kode Pesanan", "Nama Pesanan", "Harga");

        int total = 0;

        // traversal dari head ke tail untuk menampilkan semua pesanan yang sudah terurut
        NodePesanan08 current = head;
        while (current != null) {
            System.out.printf("%-14d %-20s %d%n",
                current.data.kodePesanan,
                current.data.namaPesanan,
                current.data.harga);
            total += current.data.harga; 
            current = current.next;
        }

        System.out.println("--------------------------------------");
        System.out.println("Total Pendapatan : Rp " + total);
    }
}