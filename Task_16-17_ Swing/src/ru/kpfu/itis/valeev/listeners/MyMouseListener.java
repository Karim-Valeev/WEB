package ru.kpfu.itis.valeev.listeners;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    private JLabel eLabel = new JLabel();

    public MyMouseListener(JLabel eventLabel) {
        this.eLabel = eventLabel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Point location = MouseInfo.getPointerInfo().getLocation();
        this.eLabel.setText("X: " + (int)location.getX() + " Y: " + (int) location.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
