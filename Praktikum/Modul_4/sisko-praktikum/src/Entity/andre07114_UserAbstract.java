package Entity;

public abstract class andre07114_UserAbstract {
    protected String nama;

    public andre07114_UserAbstract(String nama) {
        this.nama = nama;
    }

    public abstract String getNama();

    public void setNama(String nama) {
        this.nama = nama;
    }
}
