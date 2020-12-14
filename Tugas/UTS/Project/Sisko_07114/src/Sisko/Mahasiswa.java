package Sisko; //

public class Mahasiswa extends PersonClass {
//enkapsulasi yaitu dimana data dibungkus dengan modifier (private) agar tidak bisa diakses secara langsung dari luar class
    protected String nama;
    protected String alamat;
    protected int nip;
    protected String nik;
    protected String notelp;
    protected Kelas kelas;
//jika class itu public maka class itu dapat diakses dari mana saja
    public Mahasiswa(int nip){
        this.nama   = super.nama;
        this.alamat = super.alamat;
        this.nip    = nip;
        this.nik    = nik;
        this.notelp = notelp;
        kelas = null;
    }

    public String getAlamat() {
        return this.alamat;
    }
//this untuk menunjuk variable yang akan diberi nilai.
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNip() {
        return this.nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNik(){
        return this.nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoTelp() {
        return this.notelp;
    }

    public void setNoTelp(String notelp) {
        this.notelp = notelp;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public String getNama(){
        return this.nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
}
