package GUI;

import javax.swing.*;
import java.awt.*;

public class ImageBaground extends JPanel {
    private Image image;

    public ImageBaground(String file) {
        image = new ImageIcon(getClass().getResource(file)).getImage();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D gd = (Graphics2D) grphcs.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
}
