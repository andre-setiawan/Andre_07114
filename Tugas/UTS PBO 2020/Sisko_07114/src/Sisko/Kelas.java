package Sisko;


public class Kelas {

    public String code;
    public String kelas;
    public Mahasiswa siswa;

    public Kelas(String code, String kelas){
        this.code = code;
        this.kelas = kelas;
        siswa = null;
    }

    public void setSiswa(Mahasiswa mahasiswa){
        this.siswa = mahasiswa;
    }
}
