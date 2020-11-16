package SistemSekolah07114;

public class Andre07114_SiskoEntity {

    String Nama;
    int NIP, NUPTK;
    String Mapel;

    public Andre07114_SiskoEntity(String Nama, int NIP, int NUPTK, String Mapel){
        this.Nama = Nama;
        this.NIP = NIP;
        this.NUPTK = NUPTK;
        this.Mapel = Mapel;
    }
    String getNama(){
        return this.Nama;
    }
    int getNIP(){
        return this.NIP;
    }
    int getNUPTK(){
        return this.NUPTK;
    }
    String getMapel(){
        return this.Mapel;
    }
}