package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

public class andre07114_View {
    JFrame view = new JFrame();
    JLabel title;
    JTable daftarSiswa = new JTable();
    JScrollPane scrollSiswa = new JScrollPane(daftarSiswa);
    JButton deleteBtn, updateBtn;

    public andre07114_View() {
        view.setSize(600,500);
        view.setTitle("Sisko - Lihat Data");
        view.setLayout(null);
        view.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Tambah Data Baru");
        title.setBounds(180,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        view.add(title);

        scrollSiswa.setBounds(40, 100, 500, 200);
        daftarSiswa.setModel(dataTable());
        view.add(scrollSiswa);
        delete();
        update();
        view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                view.dispose();
                andre07114_GUI gui = new andre07114_GUI();
            }
        });
    }

    public DefaultTableModel dataTable() {
        DefaultTableModel daftarSiswa = new DefaultTableModel();
        Object[] kolomTabel = {"NIS", "Nama", "Kelas", "Asisten"};
        daftarSiswa.setColumnIdentifiers(kolomTabel);
        int maxSiswa = andre07114_AllObjctrl.siswa.maxData();

        for(int i = 0; i < maxSiswa; i++) {
            Object[] data = new Object[4];
            data[0] = andre07114_AllObjctrl.siswa.view(i).getNip();
            data[1] = andre07114_AllObjctrl.siswa.view(i).getNama();
            data[2] = andre07114_AllObjctrl.kelas.getDataByKode(andre07114_AllObjctrl.siswa.view(i).getKelas()).getNama();
            data[3] = andre07114_AllObjctrl.aslab.getDataByKode(andre07114_AllObjctrl.siswa.view(i).getKelas()).getNama();
            daftarSiswa.addRow(data);
        }
        return daftarSiswa;
    }

    public void delete() {

        deleteBtn = new JButton("Hapus Data");
        deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deleteBtn.setBounds(140, 320,300, 40);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setBackground(Color.LIGHT_GRAY);

        try {
            Image updateIcon = ImageIO.read(new FileInputStream("images/delete.png"));
            Image newAddIcon = updateIcon.getScaledInstance(30, 30, 30);
            deleteBtn.setIcon(new ImageIcon(newAddIcon));
        } catch (Exception e) {
            System.out.println(e);
        }
        view.add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                andre07114_Delete delete = new andre07114_Delete();
            }
        });
    }

    public void update() {

        updateBtn = new JButton("Edit Data");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateBtn.setBounds(140, 380,300, 40);
        updateBtn.setFocusPainted(false);
        updateBtn.setBackground(Color.LIGHT_GRAY);

        try {
            Image updateIcon = ImageIO.read(new FileInputStream("images/edit.png"));
            Image newAddIcon = updateIcon.getScaledInstance(30, 30, 30);
            updateBtn.setIcon(new ImageIcon(newAddIcon));
        } catch (Exception e) {
            System.out.println(e);
        }
        view.add(updateBtn);

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                andre07114_Update update = new andre07114_Update();
            }
        });
    }

    public void refresh() {
        daftarSiswa.revalidate();
    }

}
