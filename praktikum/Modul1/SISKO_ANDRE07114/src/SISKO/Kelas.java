package SISKO;

import java.util.ArrayList;
import java.util.HashMap;

public class Kelas {
    public String kelas;
    public HashMap<String, String> jadwal = new HashMap<String, String>();

    public Kelas(){
        jadwal.put("v", "KELAS MALAM");
        jadwal.put("W","KELAS SORE");
        jadwal.put("Q","KELAS PAGI");
    }
    public String cekTipe(String kelas){
        return jadwal.getOrDefault(kelas, "salah jadwal");
    }
}
