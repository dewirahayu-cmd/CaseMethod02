// Class Pembeli digunakan untuk menyimpan data pembeli yang masuk ke antrian
public class Pembeli08 {
    int noAntrian;      // nomor antrian pembeli, dibuat otomatis oleh sistem
    String namaPembeli; 
    String noHp;        

    // konstruktor untuk menginisialisasi seluruh atribut pembeli
    public Pembeli08(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }
}