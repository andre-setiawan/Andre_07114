package SISKO;

public class Andre07114_SiswaEntity extends Kelas {
    protected String nama;
    protected int nis;
    protected String mKelas;

    Kelas kelas = new Kelas();

    public Andre07114_SiswaEntity(String nama,String mKelas, int npm){
        this.nama = nama;
        this.mKelas = mKelas;
        this.nis = npm;
    }
    String getNama(){
        return this.nama;
    }
    int getNis(){
        return this.nis;
    }
    String getKelas(){
        return this.mKelas;
    }
    String getJadwalKelas(){
        return kelas.cekTipe(mKelas);
    }
}
