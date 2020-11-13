package com.company;
import java.util.Scanner;

public class KepSek extends Auth{
    protected String nama;
    protected int npk;
    protected int nuptk;

    public KepSek(String nama, int nuptk, int npk, String username, String password) {
        super(username, password);
        this.nama = nama;
        this.npk = npk;
        this.nuptk = nuptk;
    }

    public KepSek(String username, String password) {
        super(username, password);
        this.nama = nama;
        this.npk = npk;
        this.nuptk = nuptk;
    }

    String getNama() {
        return this.nama;
    }

    int getNpk() {
        return this.npk;
    }

    int getNuptk() {
        return this.nuptk;
    }
}

