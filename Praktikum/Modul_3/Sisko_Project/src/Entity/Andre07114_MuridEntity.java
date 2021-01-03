package Entity;

public class Andre07114_MuridEntity extends Andre07114_AbstractEntity {
    private String kelas;
    private int nis;

    public Andre07114_MuridEntity(int nis, String nama, String kelas) {
        super(nama);
        this.kelas  = kelas;
        this.nis    = nis;
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

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }
}
