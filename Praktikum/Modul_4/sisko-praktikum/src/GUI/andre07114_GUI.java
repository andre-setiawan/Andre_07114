package GUI;

import Controller.andre07114_MuridController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

public class andre07114_GUI {
    JFrame LogReg = new JFrame();
    JLabel title, subtitle, menu;
    JButton create, view, update, delete;

    private andre07114_MuridController siswaController = new andre07114_MuridController();

    public andre07114_GUI() {
        LogReg.setSize(500,280);
        LogReg.setTitle("Sisko - Beranda");
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Sistem Informasi Sekolah");
        title.setBounds(80,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(title);

        subtitle = new JLabel("Data Informasi Akademik Siswa");
        subtitle.setBounds(130, 40, 600, 50);
        subtitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        LogReg.add(subtitle);
        create();
        view();
        LogReg.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        LogReg.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(LogReg,"Apakah anda yakin ingin keluar ? ") == JOptionPane.OK_OPTION) {
                    LogReg.setVisible(false);
                    LogReg.dispose();
                }
            }
        });
    }

    public void create() {
        create = new JButton("Tambah Data");
        create.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        create.setBounds(90, 120,300, 40);
        create.setFocusPainted(false);
        create.setBackground(Color.LIGHT_GRAY);

        try {
            Image addIcon = ImageIO.read(new FileInputStream("images/adddata.png"));
            Image newAddIcon = addIcon.getScaledInstance(30, 30, 30);
            create.setIcon(new ImageIcon(newAddIcon));
        } catch (Exception e) {
            System.out.println(e);
        }
        LogReg.add(create);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                andre07114_AddData add = new andre07114_AddData();
                LogReg.dispose();
            }
        });
    }

    public void view() {

        view = new JButton("Lihat Data");
        view.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        view.setBounds(90, 180,300, 40);
        view.setFocusPainted(false);
        view.setBackground(Color.LIGHT_GRAY);

        try {
            Image updateIcon = ImageIO.read(new FileInputStream("images/viewdata.png"));
            Image newAddIcon = updateIcon.getScaledInstance(30, 30, 30);
            view.setIcon(new ImageIcon(newAddIcon));
        } catch (Exception e) {
            System.out.println(e);
        }
        LogReg.add(view);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                andre07114_View view = new andre07114_View();
                LogReg.dispose();
            }
        });
    }
}
