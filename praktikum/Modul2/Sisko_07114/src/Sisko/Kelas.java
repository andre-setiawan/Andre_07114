package Sisko;


public class Kelas {

    public String code;
    public String kelas;
    public SistemSchool siswa;

    public Kelas(String code, String kelas){
        this.code = code;
        this.kelas = kelas;
        siswa = null;
    }

    public void setSiswa(SistemSchool sistemSchool){
        this.siswa = sistemSchool;
    }
}
