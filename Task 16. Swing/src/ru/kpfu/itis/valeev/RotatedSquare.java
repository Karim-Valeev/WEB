package ru.kpfu.itis.valeev;

import javax.swing.*;
import java.awt.*;

public class RotatedSquare extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.magenta);
        Rectangle rect2 = new Rectangle(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2);

        g2d.rotate(Math.toRadians(45), rect2.getWidth(), rect2.getHeight());
        g2d.draw(rect2);
        g2d.fill(rect2);
    }

}
