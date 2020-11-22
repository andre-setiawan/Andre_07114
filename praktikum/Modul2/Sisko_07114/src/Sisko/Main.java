package Sisko;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //update penambahan ArrayList
    public ArrayList<SistemSchool> dataSistemSchool = new ArrayList();
    public ArrayList<Kelas> dataKelas = new ArrayList();
    public Scanner input;

    public static void main(String[] args) {

        Main m = new Main();
        m.menu();
    }

    public void menu() {

        init();
        input = new Scanner(System.in);
        int selectedMenu, nip;

        do {

            System.out.println("==================="
                            +"\n [1] View Data"
                            +"\n [2] Add Data"
                            +"\n [3] Update Data"
                            +"\n [4] Delete Data"
                            +"\n [5] Exit"
                            +"\n ==================="
                            +"\n masukkan pilihan anda : ");

            selectedMenu = input.nextInt();

            switch(selectedMenu){
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println(" masukkan nip : ");
                    nip = input.nextInt();

                    update(nip);
                    break;
                case 4:
                    System.out.println(" masukkan nip : ( jika hapus semua data maka masukkan 0) ");
                    nip = input.nextInt();

                    delete(nip);
                    break;
                case 5:
                    System.exit(0);
                default :
                    System.out.println("maaf pilihan tidak tersedia di menu ");
            }
        }while(selectedMenu != 5);

    }

    public void add(){
        String selectedKelas;

        System.out.println(" masukkan nama : ");
        String nama = input.next();
        System.out.println(" masukkan alamat : ");
        String alamat = input.next();
        System.out.println(" masukkan nip : ");
        int nip = input.nextInt();
        System.out.println(" masukkan nik : ");
        String nik = input.next();
        System.out.println(" masukkan notelp : ");
        String notelp = input.next();

        System.out.println(" pilih kode kelas : ");
        for (int i = 0; i <dataKelas.size(); i++){
            System.out.print("[ " + dataKelas.get(i).code + "]");
            System.out.print(dataKelas.get(i).kelas + "\n");
        }
        System.out.println(" masukkan kelas yang anda pilih : ");
        selectedKelas = input.next();
        SistemSchool siswa = new SistemSchool(nip);

        for(int i = 0; i < dataKelas.size(); i++){
            if(dataKelas.get(i).code.equals(selectedKelas)){
                Kelas kelas = new Kelas(dataKelas.get(i).code, dataKelas.get(i).kelas);

                dataKelas.get(i).setSiswa(siswa);
                siswa.setKelas(kelas);
            }
        }

        siswa.setNama(nama);
        siswa.setAlamat(alamat);
        dataSistemSchool.add(siswa);
    }

    public void update(int nip){
        for(int i = 0; i <dataSistemSchool.size(); i++){
            if(dataSistemSchool.get(i).getNip() == nip){
                System.out.println("====================="
                +"\n Nama : "+dataSistemSchool.get(i).getNama()
                +"\n Nip  : "+dataSistemSchool.get(i).getNip()
                +"\n =====================");

                System.out.println(" masukkan nama : ");
                String nama = input.next();
                System.out.println(" masukkan alamat : ");
                String alamat = input.next();
                System.out.println(" masukkan nip : ");
                int nipBaru = input.nextInt();
                System.out.println(" masukkan nik : ");
                String nik = input.next();
                System.out.println(" masukkan notelp : ");
                String notelp = input.next();

                dataSistemSchool.get(i).setNama(nama);
                dataSistemSchool.get(i).setAlamat(alamat);
                dataSistemSchool.get(i).setNip(nipBaru);
            }
        }
    }

    public void read() {

        if(dataSistemSchool.size() > 0){
            for(int i = 0; i< dataSistemSchool.size(); i++){
                System.out.println(" ===================== "
                +"\n Nama     : "+dataSistemSchool.get(i).getNama()
                +"\n Alaamat  : "+dataSistemSchool.get(i).getAlamat()
                +"\n Nip      : "+dataSistemSchool.get(i).getNip());

                if(dataSistemSchool.get(i).kelas == null){
                    System.out.println(" Kelas : -");
                }else{
                    System.out.println("Kelas : "+dataKelas.get(i).kelas +"["+dataSistemSchool.get(i).kelas.code+"]");
                }
                System.out.println("====================");
            }
        }else{
            System.out.println(" DATA KOSONG (BELUM TERISI) ");
        }
    }

    public void delete(int nip){
        if(nip == 0){
            dataSistemSchool.clear();
            System.out.println(" success delete data ");
        }else{
            for(int i = 0; i <dataSistemSchool.size(); i++){
                if(dataSistemSchool.get(i).getNip() == nip){
                    System.out.println(" data milik : " +dataSistemSchool.get(i).getNama() +" success delete ");
                    dataSistemSchool.remove(i);
                }
            }
        }
    }

    public void init(){
        dataKelas.add(new Kelas("KWU"    ,"KEWIRAUSAHAAN"));
        dataKelas.add(new Kelas("KOMNUM" ,"KOMPUTASI NUMERIK"));
        dataKelas.add(new Kelas("PAA"    ,"ANALISA PROGRAM"));
        dataKelas.add(new Kelas("GRAFKOM","GRAFIKA KOMPUTER"));
        dataKelas.add(new Kelas("SO"     ,"SISTEM OPERASI"));
        dataKelas.add(new Kelas("GRAF"   ,"TEORI GRAF"));
    }
}
