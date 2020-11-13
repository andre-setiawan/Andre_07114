package SISKO;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEntity {

    public ArrayList<Andre07114_SiswaEntity> data = new ArrayList();
    public Scanner input;
    private String nama;
    private int nis;

    public static void main(String[] args) {
        MainEntity m = new MainEntity();
        m.menu();
    }
    public void menu(){
        input = new Scanner(System.in);
        int selectMenu , nis;

        do{
            System.out.println("====================");
            System.out.println("[1] Lihat data");
            System.out.println("[2] Tambah data");
            System.out.println("[3] Edit data");
            System.out.println("[4] Hapus data");
            System.out.println("[5] Keluar");
            System.out.println("--------------------");
            System.out.print("Pilih : ");

            selectMenu = input.nextInt();

            switch (selectMenu){
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("masukkan npm :");
                    nis = input.nextInt();

                    update(nis);
                    break;
                case 4:
                    System.out.println("Masukkan npm : (masukkan 0 jika ingin menghapus semua data)");
                    nis = input.nextInt();
                    delete(nis);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println(" pilihan tidak ada dalam menu ");
            }

        }while (selectMenu != 5);
    }
    public void add(){
        System.out.println("Masukkan nama :");
        String Andre07114_nama = input.next();
        System.out.println("Masukkan kelas :");
        String kelas =input.next();
        System.out.println("Masukkan npm :");
        int npm = input.nextInt();


        Andre07114_SiswaEntity baru = new Andre07114_SiswaEntity(nama,kelas, nis );
        data.add(baru);
    }
    public void update(int nis){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getNis() == nis){
                System.out.println("--------------------");
                System.out.println("Nama: " + data.get(i).getNama());
                System.out.println("NIS: " + data.get(i).getNis());
                System.out.println("Kelas: " + data.get(i).getKelas());
                System.out.println("--------------------");

                System.out.println("Masukan nama: ");
                String nama = input.next();
                System.out.println("Masukan Kelas: ");
                String kelas = input.next();
                System.out.println("Masukan NIS: ");
                int nisBaru = input.nextInt();

                // Menggunakan add karena user harus menginputkan kembali semua data
                data.set(i, new Andre07114_SiswaEntity(nama, kelas, nisBaru));
            }
        }
    }

    public void read(){
        if (data.size() > 0){
            for(int i = 0; i < data.size(); i++){

            }
        }else{
            System.out.println(" data kosong ");
        }
    }

    public void delete(int nis){
        if(nis == 0){
            data.clear();
            System.out.println("data sudah terhapus");
        }else{
            for(int i = 0; i < data.size(); i++){
                if(data.get(i).getNis() == nis){
                    System.out.println("data milik : "+ data.get(i).getNama()+" berhasil terhapus dari sistem");
                    data.remove(i);
                }
            }
        }
    }
}
