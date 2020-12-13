package ru.kpfu.itis.valeev;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.magenta);
        g.fillRect(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2);
    }
}
