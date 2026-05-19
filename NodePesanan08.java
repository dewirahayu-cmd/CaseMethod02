// Class NodePesanan adalah node untuk Double Linked List list pesanan
// Setiap node menyimpan data pesanan dan dua pointer yaitu prev dan next
public class NodePesanan08 {
    Pesanan08 data;       
    NodePesanan08 prev;  
    NodePesanan08 next;  

    // konstruktor node, prev dan next diinisialisasi null karena belum terhubung ke node lain
    public NodePesanan08(Pesanan08 data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}