package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<KepSek> dataKepsek = new ArrayList();
    static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int selectedMenu;

        do {
            System.out.println("====================="
            +"\n[1] view"
            +"\n[2] add"
            +"\n[3] update"
            +"\n[4] delete"
            +"\n[5] Login"
            +"\n[6] exit"
            +"\n----------------------"
            +"\nPilihan : ");

            selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    System.out.println("Masukkan NIS: (Jika hapus semua data masukkan 0) ");
                    int npk = input.nextInt();
                    delete(npk);
                    break;
                case 5:
                    login();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Kamu salah pilih menu!");
            }

        }while(selectedMenu != 6);
    }
    static void add() {
        System.out.println("Masukan Username: ");
        String username = input.next();
        System.out.println("Masukan Password: ");
        String password = input.next();
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan npk: ");
        int npk = input.nextInt();
        System.out.println("Masukan nuptk: ");
        int nuptk = input.nextInt();

        KepSek kepsek = new KepSek(nama, npk, nuptk, username, password);
        dataKepsek.add(kepsek);
        kepsek.save(username, password);

    }

    static void update() {
        System.out.println("Masukan Username: ");
        String username = input.next();
        System.out.println("Masukan Password: ");
        String password = input.next();
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan npk: ");
        int npk = input.nextInt();
        System.out.println("Masukan nuptk: ");
        int nuptk = input.nextInt();

        // Menggunakan add karena user harus menginputkan kembali semua data
        KepSek kepsek = new KepSek(nama, npk, nuptk, username, password);
        dataKepsek.add(kepsek);
        kepsek.save(username, password);
    }

    static void read() {
        for(int i = 0; i < dataKepsek.size(); i++) {
            System.out.println("--------------------"
            +"\nNama: " + dataKepsek.get(i).getNama()
            +"\nnpk: " + dataKepsek.get(i).getNpk()
            +"\nnuptk: " + dataKepsek.get(i).getNuptk()
            +"\n--------------------");
        }
    }

    static void delete(int npk) {
        if(npk == 0) {
            dataKepsek.clear();
            System.out.println("Data berhasil dihapus");
        } else {
            for(int i = 0; i < dataKepsek.size(); i++) {
                if(dataKepsek.get(i).getNpk() == npk) {
                    System.out.println("Data siswa milik: " + dataKepsek.get(i).getNama() + " berhasil terhapus");
                    dataKepsek.remove(i);
                }
            }
        }
    }

    static void login() {
        System.out.println("Masukan Username: ");
        String username = input.next();
        System.out.println("Masukan Password: ");
        String password = input.next();

        KepSek kepsek = new KepSek(username, password);
        boolean result = kepsek.login(username, password);

        if(result) {
            System.out.println("Login Berhasil !");
        } else {
            System.out.println("Login gagal !");
        }
    }
}
