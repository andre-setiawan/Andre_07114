package Sisko;

public class SistemSchool extends PersonClass {

    protected String nama;
    protected String alamat;
    protected int nip;
    protected String nik;
    protected String notelp;
    protected Kelas kelas;

    public SistemSchool(int nip){
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
