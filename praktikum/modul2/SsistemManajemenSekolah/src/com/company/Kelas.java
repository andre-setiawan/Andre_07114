package com.company;

import java.util.HashMap;

public class Kelas {
    public HashMap<String , String> jadwal = new HashMap<>();
    public String nama, kode;

    public Kelas(String kode, String nama) {
        jadwal.put("1","PBO");
        jadwal.put("2", "SO");
        jadwal.put("3", "STRUKTUR DATA");

    }
    public void addKelas(String kode, String nama) {

        Kepsek kepsek = new Kepsek (null,null,null,0);
        kepsek.addKelas(kode, nama);
    }
    @Override
    public abstract String cekTipe(String kelas);
}
