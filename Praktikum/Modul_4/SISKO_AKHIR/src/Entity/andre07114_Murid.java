package Entity;

public class andre07114_Murid extends andre07114_UserAbstract {
    private String kelas;
    private int nip;

    public andre07114_Murid(int nip, String nama, String kelas) {
        super(nama);
        this.kelas  = kelas;
        this.nip = nip;
    }

    @Override
    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
}
