// Class AntrianDLL08 mengimplementasikan struktur data Double Linked List
public class AntrianDLL08 {
    NodeAntrian08 head;   
    NodeAntrian08 tail;  
    int counterAntrian;   

    // konstruktor menginisialisasi antrian dalam kondisi kosong
    public AntrianDLL08() {
        head = null;
        tail = null;
        counterAntrian = 0;
    }

    // method isEmpty() mengecek apakah antrian kosong atau tidak
    public boolean isEmpty() {
        return head == null;
    }

    // method generateNo() digunakan untuk membuat nomor antrian otomatis
    public int generateNo() {
        counterAntrian++;
        return counterAntrian;
    }

    // method tambahAntrian() menambahkan pembeli baru ke bagian akhir antrian
    public void tambahAntrian(Pembeli08 pembeli) {
        NodeAntrian08 newNode = new NodeAntrian08(pembeli);

        // jika antrian masih kosong, node baru langsung menjadi head sekaligus tail
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // sambungkan node baru ke belakang tail yang ada saat ini
            tail.next = newNode;   
            newNode.prev = tail;   
            tail = newNode;        
        }
    }

    // method cetakAntrian() menampilkan seluruh antrian yang ada
    public void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("==============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("==============================");
        System.out.printf("%-12s %-15s %s%n", "No Antrian", "Nama", "No HP");

        // mulai dari head, telusuri setiap node sampai current bernilai null
        NodeAntrian08 current = head;
        while (current != null) {
            System.out.printf("%-12d %-15s %s%n",
                current.data.noAntrian,
                current.data.namaPembeli,
                current.data.noHp);
            current = current.next; // pindah ke node berikutnya
        }
    }

    // method hapusAntrian() menghapus node antrian berdasarkan nomor antrian
    public Pembeli08 hapusAntrian(int noAntrian) {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }

        // cari node dengan nomor antrian yang sesuai, mulai dari head
        NodeAntrian08 current = head;
        while (current != null && current.data.noAntrian != noAntrian) {
            current = current.next;
        }

        // jika nomor antrian tidak ditemukan setelah traversal selesai
        if (current == null) {
            System.out.println("Nomor antrian " + noAntrian + " tidak ditemukan.");
            return null;
        }

        // kasus 1: hanya ada satu node dalam antrian
        // head dan tail langsung diset null karena antrian menjadi kosong
        if (head == tail) {
            head = tail = null;
        }
        // kasus 2: node yang dihapus adalah head
        // head dipindahkan ke node berikutnya, lalu prev head baru diset null
        else if (current == head) {
            head = head.next;
            head.prev = null;
        }
        // kasus 3: node yang dihapus adalah tail
        // tail dipindahkan ke node sebelumnya, lalu next tail baru diset null
        else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // kasus 4: node yang dihapus berada di tengah
        // sambungkan langsung node sebelum dan sesudah node yang dihapus
        else {
            current.prev.next = current.next; 
            current.next.prev = current.prev; 
        }

        return current.data;
    }
}