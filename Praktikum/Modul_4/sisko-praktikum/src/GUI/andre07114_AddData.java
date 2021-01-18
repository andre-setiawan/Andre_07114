package GUI;

import Entity.andre07114_Murid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class andre07114_AddData {
    JFrame add = new JFrame();
    JLabel title, nisLabel, namaLabel, kelasLabel, aslabLabel;
    JTextField nipText, namaText;
    JComboBox kelasCombo, aslabCombo;
    JButton createBtn;

    public andre07114_AddData() {
        int maxKelas = andre07114_AllObjctrl.kelas.maxData();

        add.setSize(400,400);
        add.setTitle("Sisko - Tambah Data");
        add.setLayout(null);
        add.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Tambah Data Baru");
        title.setBounds(70,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add.add(title);

        nisLabel = new JLabel("NIP");
        nisLabel.setBounds(50, 80, 200, 50);
        nisLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(nisLabel);

        nipText = new JTextField();
        nipText.setBounds(150, 80, 200, 50);
        add.add(nipText);

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 160, 200, 50);
        namaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(namaLabel);

        namaText = new JTextField();
        namaText.setBounds(150, 160, 200, 50);
        add.add(namaText);

        kelasLabel = new JLabel("Kelas");
        kelasLabel.setBounds(50, 240, 200, 50);
        kelasLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(kelasLabel);

        kelasCombo = new JComboBox();
        for(int i = 0; i < maxKelas; i++) {
            kelasCombo.addItem(andre07114_AllObjctrl.kelas.view(i).getNama());
        }
        kelasCombo.setBounds(150, 240, 200, 50);
        add.add(kelasCombo);

        createBtn = new JButton("Submit");
        createBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        createBtn.setBounds(50, 300,300, 40);
        createBtn.setFocusPainted(false);
        createBtn.setBackground(Color.LIGHT_GRAY);
        add.add(createBtn);

        add.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        add.setVisible(true);
        add.setLocationRelativeTo(null);

        add.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                add.setVisible(false);
                andre07114_GUI gui = new andre07114_GUI();
            }
        });

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kelasIndex = kelasCombo.getSelectedIndex();
                String kelas = andre07114_AllObjctrl.kelas.getDataByIndex(kelasIndex).getCode();
                String result = andre07114_AllObjctrl.siswa.insert(new andre07114_Murid(Integer.parseInt(nipText.getText()), namaText.getText(), kelas));
                kosong();
                JOptionPane.showMessageDialog(add, result);

                add.dispose();
                andre07114_View view = new andre07114_View();
            }
        });
    }

    public void kosong() {
        nipText.setText("");
        namaText.setText("");
        kelasCombo.setSelectedIndex(0);
    }
}
