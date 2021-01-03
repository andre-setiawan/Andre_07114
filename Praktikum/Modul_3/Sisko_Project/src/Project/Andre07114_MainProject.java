package Project;

import Controller.Andre07114_AdminController;
import Controller.Andre07114_KelasController;
import Controller.Andre07114_MuridController;
import Entity.Andre07114_MuridEntity;
import Model.Andre07114_MuridModel;

import java.util.Scanner;

public class Andre07114_MainProject {
    // Menerapkan Controller pada main
    private Andre07114_MuridController muridController = new Andre07114_MuridController();
    private Andre07114_AdminController adminController = new Andre07114_AdminController();
    private Andre07114_KelasController kelasController = new Andre07114_KelasController();

    private Andre07114_MuridModel muridModel = new Andre07114_MuridModel();
    private Scanner input;

    public static void main(String[] args) {
        Andre07114_MainProject m = new Andre07114_MainProject();
        m.menu();
    }

    public void menu() {
        input = new Scanner(System.in);
        int selectedMenu, nis, max;

        do {
            System.out.println("==== Manajemen Data Siswa ====");
            System.out.println("[1] Lihat data");
            System.out.println("[2] Tambah data");
            System.out.println("[3] Edit data");
            System.out.println("[4] Hapus data");
            System.out.println("==== Manajemen Data Kelas ====");
            System.out.println("[5] Lihat data");
            System.out.println("==== Manajemen Data Asisten Lab ====");
            System.out.println("[6] Lihat data");
            System.out.println("[7] Exit Program");
            System.out.println("--------------------");
            System.out.print("Pilih menu> ");

            selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Masukan NIS: ");
                    nis = input.nextInt();
                    update(nis);
                    break;
                case 4:
                    System.out.println("Masukkan NIS: ");
                    nis = input.nextInt();
                    delete(nis);
                    break;
                case 5:
                    max = kelasController.maxData();
                    if(max > 0) {
                        System.out.println("------------------------------------");
                        System.out.println("Daftar Kelas yang tersedia: ");
                        System.out.println("------------------------------------");
                        for(int i = 0; i < max; i++) {
                            System.out.println("Pelajaran: " + kelasController.view(i).getNama());
                            System.out.println("Kode: " + kelasController.view(i).getKode());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Data masih kosong");
                    }
                    break;
                case 6:
                    max = adminController.maxData();
                    if(max > 0) {
                        System.out.println("------------------------------------");
                        System.out.println("Daftar Asisten Lab yang tersedia: ");
                        System.out.println("------------------------------------");
                        for(int i = 0; i < max; i++) {
                            System.out.println("Nama: " + adminController.view(i).getNama());
                            System.out.println("Kode: " + adminController.view(i).getKode());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Data masih kosong");
                    }
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Anda salah memilih menu!");
            }
        } while(selectedMenu != 7);
    }

    public void add() {
        try {
            System.out.println("Masukan nama: ");
            String nama = input.next();
            System.out.println("Masukan Kelas: ");
            String kelas = input.next();
            System.out.println("Masukan NIS: ");
            int nis = input.nextInt();
            String msg = muridController.insert(new Andre07114_MuridEntity(nis, nama, kelas));

            System.out.println("------------------------------------");
            System.out.println(msg);
            System.out.println("------------------------------------");
        } catch(Exception e) {
            System.out.println("------------------------------------");
            System.out.println("Silahkan coba lagi.");
            System.out.println("------------------------------------");
        }
    }

    public void read() {
        int max = muridController.maxData();
        if(max > 0) {
            System.out.println("------------------------------------");
            System.out.println("Daftar Data Siswa:");
            System.out.println("------------------------------------");
            for(int i = 0; i < max; i++) {
                System.out.println("Nama: " + muridController.view(i).getNama());
                System.out.println("NIS: " + muridController.view(i).getNis());
                System.out.println("Kelas: " + muridController.view(i).getKelas());
                System.out.println("Asisten: " + adminController.getDataByKode(muridController.view(i).getKelas()).getNama());
                System.out.println("Pelajaran: " + kelasController.getDataByKode(muridController.view(i).getKelas()).getNama());
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("------------------------------------");
            System.out.println("Data masih kosong");
            System.out.println("------------------------------------");
        }
    }

    public void update(int nis) {
        int result = muridController.cekData(nis);

        if(result == -1) {
            System.out.println("------------------------------------");
            System.out.println("Data siswa masih kosong");
            System.out.println("------------------------------------");
        } else if(result == -2) {
            System.out.println("------------------------------------");
            System.out.println("Data siswa tidak ditemukan / NIS salah.");
            System.out.println("------------------------------------");
        } else {
            Andre07114_MuridEntity siswa = muridController.view(result);

            System.out.println("--------------------");
            System.out.println("Nama: " + siswa.getNama());
            System.out.println("NIS: " + siswa.getNis());
            System.out.println("Kelas: " + siswa.getKelas());
            System.out.println("--------------------");

            System.out.println("Masukan nama: ");
            String nama = input.next();
            System.out.println("Masukan Kelas: ");
            String kelas = input.next();
            System.out.println("Masukan NIS: ");
            int nisBaru = input.nextInt();

            String msg = muridController.update(new Andre07114_MuridEntity(nisBaru, nama, kelas), siswa.getNis());

            System.out.println("------------------------------------");
            System.out.println(msg);
            System.out.println("------------------------------------");
        }
    }

    public void delete(int nis) {
        int result = muridModel.delete(nis);
        if(result != 0) {
            System.out.println("Gagal menghapus data, NIS salah.");
        } else {
            System.out.println("Data berhasil terhapus");
        }
    }
}