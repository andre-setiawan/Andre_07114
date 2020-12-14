package com.company;

public class Kepsek extends Kelas {
    protected String nama;
    protected int nik;
    protected String nuptk;
    protected String kelas;

    public Kepsek(String nama, String nuptk, String kelas, int nik) {
        super(null , nama);
        this.nama = nama;
        this.kelas = kelas;
        this.nik = nik;
        this.nuptk = nuptk;
    }
    String getNama() {
        return this.nama;
    }
    int getNik() {
        return this.nik;
    }
    String getNuptk() {
        return this.nuptk;
    }
    String getKelas() {
        return this.kelas;
    }

    public String cekTipe(String kelas) {
        return jadwal.getOrDefault(kelas, "jadwal belum terisi");
    }
}