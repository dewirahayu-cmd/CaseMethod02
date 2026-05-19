// Class NodeAntrian adalah node untuk Double Linked List antrian pembeli
public class NodeAntrian08 {
    Pembeli08 data;       
    NodeAntrian08 prev;   
    NodeAntrian08 next;   

    // konstruktor node, prev dan next diinisialisasi null karena belum terhubung ke node lain
    public NodeAntrian08(Pembeli08 data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}