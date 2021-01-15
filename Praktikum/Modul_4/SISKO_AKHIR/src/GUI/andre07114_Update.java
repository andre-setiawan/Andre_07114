package GUI;

import Entity.andre07114_Murid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class andre07114_Update {
    JFrame updateFrame = new JFrame();
    JLabel title, nisLabel;
    JTextField nipText;
    JButton updateBtn;

    public andre07114_Update() {
        updateFrame.setSize(400,250);
        updateFrame.setTitle("Sisko - Edit Data");
        updateFrame.setLayout(null);
        updateFrame.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Edit Data");
        title.setBounds(120,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        updateFrame.add(title);

        nisLabel = new JLabel("NIS");
        nisLabel.setBounds(50, 80, 200, 50);
        nisLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateFrame.add(nisLabel);

        nipText = new JTextField();
        nipText.setBounds(150, 80, 200, 50);
        updateFrame.add(nipText);

        updateBtn = new JButton("Edit");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateBtn.setBounds(50, 140,300, 40);
        updateBtn.setFocusPainted(false);
        updateBtn.setBackground(Color.LIGHT_GRAY);
        updateFrame.add(updateBtn);

        updateFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        updateFrame.setVisible(true);
        updateFrame.setLocationRelativeTo(null);

        updateFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateFrame.dispose();
                andre07114_View view = new andre07114_View();
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nis = Integer.parseInt(nipText.getText());
                int result = andre07114_AllObjctrl.siswa.cekData(nis);

                if(result == -1) {
                    JOptionPane.showMessageDialog(updateFrame, "Data siswa masih kosong");
                } else if(result == -2) {
                    JOptionPane.showMessageDialog(updateFrame, "Data siswa tidak ditemukan / NIS salah.");
                } else {
                    andre07114_Murid siswaEntity = andre07114_AllObjctrl.siswa.getDataByNis(nis);
                    andre07114_UpdateGUI update = new andre07114_UpdateGUI(siswaEntity);
                }
            }
        });
    }
}
