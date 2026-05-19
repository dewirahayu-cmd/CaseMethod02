// Class Pesanan digunakan untuk menyimpan data makanan yang dipesan oleh pembeli
public class Pesanan08 {
    int kodePesanan;    
    String namaPesanan; 
    int harga;          
    String namaPembeli; 

    // konstruktor untuk menginisialisasi seluruh atribut pesanan
    public Pesanan08(int kodePesanan, String namaPesanan, int harga, String namaPembeli) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.namaPembeli = namaPembeli;
    }
}