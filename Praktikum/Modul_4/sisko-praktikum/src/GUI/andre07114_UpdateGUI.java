package GUI;

import Controller.andre07114_AdminController;
import Controller.andre07114_KelasController;
import Entity.andre07114_Murid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class andre07114_UpdateGUI {
    JFrame updateGUI = new JFrame();
    JLabel title, nipLabel, namaLabel, kelasLabel, aslabLabel;
    JTextField nipText, namaText;
    JComboBox kelasCombo, aslabCombo;
    JButton updateBtn;

    private andre07114_KelasController kelasController = new andre07114_KelasController();
    private andre07114_AdminController aslabController = new andre07114_AdminController();

    public andre07114_UpdateGUI(andre07114_Murid siswaEntity) {
        int maxKelas = andre07114_AllObjctrl.kelas.maxData();

        updateGUI.setSize(400,400);
        updateGUI.setTitle("Sisko - Edit Data");
        updateGUI.setLayout(null);
        updateGUI.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Edit Data");
        title.setBounds(140,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        updateGUI.add(title);

        nipLabel = new JLabel("NIS");
        nipLabel.setBounds(50, 80, 200, 50);
        nipLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(nipLabel);

        nipText = new JTextField();
        nipText.setBounds(150, 80, 200, 50);
        nipText.setText(String.valueOf(siswaEntity.getNip()));
        updateGUI.add(nipText);

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 160, 200, 50);
        namaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(namaLabel);

        namaText = new JTextField();
        namaText.setBounds(150, 160, 200, 50);
        namaText.setText(siswaEntity.getNama());
        updateGUI.add(namaText);

        kelasLabel = new JLabel("Kelas");
        kelasLabel.setBounds(50, 240, 200, 50);
        kelasLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(kelasLabel);

        kelasCombo = new JComboBox();
        for(int i = 0; i < maxKelas; i++) {
            kelasCombo.addItem(andre07114_AllObjctrl.kelas.view(i).getNama());
        }
        kelasCombo.setBounds(150, 240, 200, 50);
        kelasCombo.setSelectedItem(kelasController.getDataByKode(siswaEntity.getKelas()).getNama());
        updateGUI.add(kelasCombo);

        updateBtn = new JButton("Submit");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateBtn.setBounds(50, 300,300, 40);
        updateBtn.setFocusPainted(false);
        updateBtn.setBackground(Color.LIGHT_GRAY);
        updateGUI.add(updateBtn);

        updateGUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        updateGUI.setVisible(true);
        updateGUI.setLocationRelativeTo(null);

        updateGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateGUI.dispose();
                andre07114_View view = new andre07114_View();
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nisLama = Integer.parseInt(nipText.getText());
                int kelasIndex = kelasCombo.getSelectedIndex();
                String kelas = andre07114_AllObjctrl.kelas.getDataByIndex(kelasIndex).getCode();
                String result = andre07114_AllObjctrl.siswa.update(new andre07114_Murid(Integer.parseInt(nipText.getText()), namaText.getText(), kelas), nisLama);
                kosong();
                JOptionPane.showMessageDialog(updateGUI, result);

                updateGUI.dispose();
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
