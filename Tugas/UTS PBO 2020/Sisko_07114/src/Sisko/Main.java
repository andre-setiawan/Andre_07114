package Sisko;

import java.util.ArrayList; //memanggil fungsi dari arraylist
import java.util.Scanner; //memanggil fungsi dari input Scanner

public class Main {

    //update penambahan ArrayList
    public ArrayList<Mahasiswa> dataMahasiswa = new ArrayList();
    //ArrayList dapat menambah data baru secara dinamis tanpa harus menentukan ukurannya di awal
    public ArrayList<Kelas> dataKelas = new ArrayList();
    public Scanner input; //Scanner merupakan class yang menyediakan fungsi-fungsi untuk
    // mengambil input dari keyboard. Agar kita bisa menggunakan Scanner

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
                    System.out.println(" masukkan nip :  ( jika hapus semua data maka masukkan 0) ");
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
        Mahasiswa siswa = new Mahasiswa(nip);

        for(int i = 0; i < dataKelas.size(); i++){
            if(dataKelas.get(i).code.equals(selectedKelas)){
                Kelas kelas = new Kelas(dataKelas.get(i).code, dataKelas.get(i).kelas);

                dataKelas.get(i).setSiswa(siswa);
                siswa.setKelas(kelas);
            }
        }

        siswa.setNama(nama);
        siswa.setAlamat(alamat);
        dataMahasiswa.add(siswa);
    }

    public void update(int nip){
        for(int i = 0; i < dataMahasiswa.size(); i++){
            if(dataMahasiswa.get(i).getNip() == nip){
                System.out.println("====================="
                +"\n Nama : "+ dataMahasiswa.get(i).getNama()
                +"\n Nip  : "+ dataMahasiswa.get(i).getNip()
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

                dataMahasiswa.get(i).
                        setNama(nama);
                dataMahasiswa.get(i).
                        setAlamat(alamat);
                dataMahasiswa.get(i).
                        setNip(nipBaru);
            }
        }
    }

    public void read() {

        if(dataMahasiswa.size() > 0){
            for(int i = 0; i< dataMahasiswa.size(); i++){
                System.out.println(" ===================== "
                +"\n Nama     : "+ dataMahasiswa.get(i).getNama()
                +"\n Alamat  : "+ dataMahasiswa.get(i).getAlamat()
                +"\n Nip      : "+ dataMahasiswa.get(i).getNip());

                if(dataMahasiswa.get(i).kelas == null){
                    System.out.println(" Kelas : tidak tersedia !! ");
                }else{
                    System.out.println("Kelas : "+dataKelas.get(i).kelas +"["+ dataMahasiswa.get(i).kelas.code+"]");
                }
                System.out.println("====================");
            }
        }else{
            System.out.println(" DATA KOSONG (BELUM TERISI) ");
        }
    }

    public void delete(int nip){
        if(nip == 0){
            dataMahasiswa.clear();
            System.out.println(" success delete data ");
        }else{
            for(int i = 0; i < dataMahasiswa.size(); i++){
                if(dataMahasiswa.get(i).getNip() == nip){
                    System.out.println(" data milik : " + dataMahasiswa.get(i).getNama() +" success delete ");
                    dataMahasiswa.remove(i);
                }
            }
        }
    }

    public void init(){
        dataKelas.add(new Kelas("KWU"    ,"KEWIRAUSAHAAN"));
        dataKelas.add(new Kelas("PBO"    ,"OO PROGRAMMING"));
        dataKelas.add(new Kelas("KOMNUM" ,"KOMPUTASI NUMERIK"));
        dataKelas.add(new Kelas("PAA"    ,"ANALISA PROGRAM"));
        dataKelas.add(new Kelas("GRAFKOM","GRAFIKA KOMPUTER"));
        dataKelas.add(new Kelas("SO"     ,"SISTEM OPERASI"));
        dataKelas.add(new Kelas("GRAF"   ,"TEORI GRAF"));
    }
}
