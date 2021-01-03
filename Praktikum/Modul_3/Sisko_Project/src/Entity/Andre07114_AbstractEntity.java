package Entity;

public abstract class Andre07114_AbstractEntity {
    protected String nama;

    public Andre07114_AbstractEntity(String nama) {
        this.nama = nama;
    }

    public abstract String getNama();

    public void setNama(String nama) {
        this.nama = nama;
    }
}
