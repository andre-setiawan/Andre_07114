package com.company;

import Guru.Data;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public Data dataGuru = new Data();
    public ArrayList dataKepala = new ArrayList();
    public Scanner input;

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public void menu() {
        input = new Scanner(System.in);
        int selectedMenu, nik;

        do{
            System.out.println("==== Manajemen Data Siswa ====");
            System.out.println("[1] Lihat data");
            System.out.println("[2] Tambah data");
            System.out.println("[3] Edit data");
            System.out.println("[4] Hapus data");
            System.out.println("[5] Keluar");
            System.out.println("--------------------");
            System.out.print(" masukkan pilihan  ");

            selectedMenu = input.nextInt();
            switch (selectedMenu) {
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Masukan nik: ");
                    nik = input.nextInt();

                    update(nik);
                    break;
                case 4:
                    System.out.println("masukkan nik (jika ingin hapus semua data inputkan 0 :");
                    nik = input.nextInt();

                    delete(nik);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println(" pilihan tidak tersedia di menu");
            }
        }while (selectedMenu != 5);

    }

    public void add() {
        System.out.println("masukkan nama  :");
        String nama = input.next();
        System.out.println("masukkan nik   :");
        int nik = input.nextInt();
        System.out.println("masukkan nuptk :");
        String nuptk = input.next();
        System.out.println("masukkan kelas :");
        String kelas = input.next();
        Kepsek kepsek = new Kepsek(nama,kelas,nuptk,nik);
        dataKepala.add(kepsek);
    }

    public void update(int nik) {
        for(int i = 0; i < dataKepala.size(); i++) {
            if(dataKepala.get(i).getNik() == nik) {
                System.out.println("======================");
                System.out.println("nama  : "+ dataKepala.get(i).getNama());
                System.out.println("nik   : "+ dataKepala.get(i).getNik());
                System.out.println("nuptk : "+ dataKepala.get(i).getNuptk());
                System.out.println("kelas : "+ dataKepala.get(i).getKelas());
                System.out.println("=======================");
                System.out.println("masukkan nama  :");
                String nama = input.next();
                System.out.println("masukkan nik   :");
                int nikBaru = input.nextInt();
                System.out.println("masukkan nuptk :");
                String nuptk = input.next();
                System.out.println("masukkan kelas :");
                String kelas = input.next();

                dataKepala.set(i, new Kepsek(nama,kelas,nuptk,nikBaru));
            }
        }
    }

    public void read() {
        if(dataKepala.size() > 0) {
            for(int i = 0; i < dataKepala.size(); i++) {
                System.out.println("======================");
                System.out.println("nama  : "+ dataKepala.get(i).getNama());
                System.out.println("nik   : "+ dataKepala.get(i).getNik());
                System.out.println("nuptk : "+ dataKepala.get(i).getNuptk());
                System.out.println("kelas : "+ dataKepala.get(i).getKelas());
                System.out.println(" [ "+ dataKepala.get(i).cekTipe(dataKepala.getKelas()) +"]\n");
                System.out.println("Guru  :"+ dataKepala.cekGuru(dataKepala.get(i).getKelas()));
                System.out.println("=======================");
            }
        }else{
            System.out.println("belum ada data");
        }
    }

    public void delete(int nik) {
        if(nik == 0) {
            dataKepala.clear();
            System.out.println(" data sukses dihapus");
        }else{
            for(int i = 0; i < dataKepala.size(); i++) {
                if(dataKepala.get(i).getNik() == nik) {
                    System.out.println(" data milik siswa :"+ dataKepala.get(i).getNama() +"berhasil dihapus");
                    dataKepala.remove(i);
                }
            }
        }
    }
}
