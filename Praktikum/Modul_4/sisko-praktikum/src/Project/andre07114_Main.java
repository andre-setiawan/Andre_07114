package Project;

import Controller.andre07114_AdminController;
import Controller.andre07114_KelasController;
import Controller.andre07114_MuridController;
import Entity.andre07114_Murid;
import Model.andre07114_MuridModel;

import java.util.Scanner;

public class andre07114_Main {
    /* Menerapkan Controller pada main */
    private andre07114_MuridController siswaController = new andre07114_MuridController();
    private andre07114_AdminController aslabController = new andre07114_AdminController();
    private andre07114_KelasController kelasController = new andre07114_KelasController();

    private andre07114_MuridModel siswaModel   = new andre07114_MuridModel();
    private Scanner input;

    public static void main(String[] args) {
        andre07114_Main m = new andre07114_Main();
        m.menu();
    }

    public void menu() {
        input = new Scanner(System.in);
        int selectedMenu, nis, max;

        do {
            System.out.println("==== SISTEM MANAJEMEN SEKOLAH ====");
            System.out.println("[1] Lihat data");
            System.out.println("[2] Tambah data");
            System.out.println("[3] Edit data");
            System.out.println("[4] Hapus data");
            System.out.println("[5] Lihat data kelas");
            System.out.println("[6] Lihat data aslab");
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
                            System.out.println("Kode: " + kelasController.view(i).getCode());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Data masih kosong");
                    }
                    break;
                case 6:
                    max = aslabController.maxData();
                    if(max > 0) {
                        System.out.println("------------------------------------");
                        System.out.println("Daftar Asisten Lab yang tersedia: ");
                        System.out.println("------------------------------------");
                        for(int i = 0; i < max; i++) {
                            System.out.println("Nama: " + aslabController.view(i).getNama());
                            System.out.println("Kode: " + aslabController.view(i).getCode());
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
            String msg = siswaController.insert(new andre07114_Murid(nis, nama, kelas));

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
        int max = siswaController.maxData();
        if(max > 0) {
            System.out.println("------------------------------------");
            System.out.println("Daftar Data Siswa:");
            System.out.println("------------------------------------");
            for(int i = 0; i < max; i++) {
                System.out.println("Nama: " + siswaController.view(i).getNama());
                System.out.println("NIS: " + siswaController.view(i).getNip());
                System.out.println("Kelas: " + siswaController.view(i).getKelas());
                System.out.println("Asisten: " + aslabController.getDataByKode(siswaController.view(i).getKelas()).getNama());
                System.out.println("Pelajaran: " + kelasController.getDataByKode(siswaController.view(i).getKelas()).getNama());
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("------------------------------------");
            System.out.println("Data masih kosong");
            System.out.println("------------------------------------");
        }
    }

    public void update(int nis) {
        int result = siswaController.cekData(nis);

        if(result == -1) {
            System.out.println("------------------------------------");
            System.out.println("Data siswa masih kosong");
            System.out.println("------------------------------------");
        } else if(result == -2) {
            System.out.println("------------------------------------");
            System.out.println("Data siswa tidak ditemukan / NIS salah.");
            System.out.println("------------------------------------");
        } else {
            andre07114_Murid siswa = siswaController.view(result);

            System.out.println("--------------------");
            System.out.println("Nama: " + siswa.getNama());
            System.out.println("NIS: " + siswa.getNip());
            System.out.println("Kelas: " + siswa.getKelas());
            System.out.println("--------------------");

            System.out.println("Masukan nama: ");
            String nama = input.next();
            System.out.println("Masukan Kelas: ");
            String kelas = input.next();
            System.out.println("Masukan NIS: ");
            int nisBaru = input.nextInt();

            String msg = siswaController.update(new andre07114_Murid(nisBaru, nama, kelas), siswa.getNip());

            System.out.println("------------------------------------");
            System.out.println(msg);
            System.out.println("------------------------------------");
        }
    }

    public void delete(int nis) {
        int result = siswaModel.delete(nis);
        if(result != 0) {
            System.out.println("Gagal menghapus data, NIS salah.");
        } else {
            System.out.println("Data berhasil terhapus");
        }
    }
}