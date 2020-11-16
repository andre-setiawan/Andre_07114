package SistemSekolah07114;

import java.util.ArrayList;
import java.util.Scanner;

public class Sisko_Main07114 {
    static ArrayList<Andre07114_SiskoEntity> newData = new ArrayList();
    static Scanner input;

    public static void main(String[] args) {
        Sisko_Main07114 menu = new Sisko_Main07114();
        menu.Menu();
    }

    public void Menu() {
        int selectedMenu;
        input = new Scanner(System.in);

        do {
            System.out.println(" pilihan menu "
                    + "\n 1. lihat data"
                    + "\n 2. tambah data"
                    + "\n 3. hapus data"
                    + "\n 4. update data"
                    + "\n 5. exit"
                    + "\n"
                    + "\n pilihan anda : ");
            selectedMenu = input.nextInt();
            input.nextLine();

            switch (selectedMenu) {
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Masukkan nis : (atau hapus semua data langsung dengan angka 0 )");
                    int nis = input.nextInt();
                    deleteData(nis);
                    break;
                case 4:
                    System.out.println("Masukkan Nis : ");
                    nis = input.nextInt();
                    updateData(nis);
                    break;

                default:
                    System.out.println(" pilihan tidak tersedia ");
                    // kembali ke menu utama
                    break;
            }
        } while (selectedMenu != 5);
    }

    public void add() {
        System.out.print("Masukkan Nama : ");
        String nama = input.next();
        System.out.print("Masukkan Nip  : ");
        int nip = input.nextInt();
        System.out.print("Masukkan NUPTK: ");
        int nuptk = input.nextInt();
        System.out.print("Masukkan Mapel: ");
        String mapel = input.next();

        newData.add(new Andre07114_SiskoEntity(nama, nip, nuptk, mapel));
    }

    public void read() {
        for (int i = 0; i < newData.size(); i++) {
            System.out.println("============");
            System.out.println("Nama  :  " + newData.get(i).getNama());
            System.out.println("NIP   :  " + newData.get(i).getNIP());
            System.out.println("NUPTK :  " + newData.get(i).getNUPTK());
            System.out.println("Mapel :  " + newData.get(i).getMapel());
            System.out.println("============");
        }
    }

    public void deleteData(int nip) {
        if (nip == 0) {
            newData.clear();
            System.out.println("Data Semua Guru Berhasil Dihapus");
        } else {
            for (int i = 0; i < newData.size(); i++) {
                if (newData.get(i).getNIP() == nip) {
                    System.out.println("Data guru milik: " + newData.get(i).getNama() + " berhasil terhapus");
                    newData.remove(i);
                }
            }
        }
    }
    public void updateData(int nip) {
        for (int i = 0; i < newData.size(); i++) {
            if (newData.get(i).getNIP() == nip) {
                System.out.print("Masukkan Nama : ");
                String nama = input.next();
                System.out.print("Masukkan Nis  : ");
                int nis = input.nextInt();
                System.out.print("Masukkan NUPTK: ");
                int nuptk = input.nextInt();
                System.out.print("Masukkan Mapel: ");
                String mapel = input.next();

                //replace
                newData.get(i).Nama = nama;
                newData.get(i).NIP = nip;
                newData.get(i).NUPTK = nuptk;
                newData.get(i).Mapel = mapel;
            }
        }
    }
}
