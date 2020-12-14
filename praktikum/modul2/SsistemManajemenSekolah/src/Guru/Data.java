package Guru;

import java.util.HashMap;

public class Data {
    public HashMap<String , String> dataGuru = new HashMap<>();

    public Data() {
        dataGuru.put("1","guru1");
        dataGuru.put("2","guru2");
        dataGuru.put("3","guru3");
    }

    public String cekGuru(String kelas) {
        return dataGuru.getOrDefault(kelas, "data tidak ada");
    }
}
