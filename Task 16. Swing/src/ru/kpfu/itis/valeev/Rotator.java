package ru.kpfu.itis.valeev;

import javax.swing.*;

public class Rotator extends Thread{

    JFrame frame;
    JPanel sqr;
    JPanel rotatedSqr;

    public Rotator(JFrame frame,JPanel sqr, JPanel rotatedSqr ){
        this.frame = frame;
        this.sqr = sqr;
        this.rotatedSqr = rotatedSqr;
    }

    @Override
    public void run() {
        frame.add(rotatedSqr);
        while(true){
            rotatedSqr.repaint();
            frame.repaint();
            frame.revalidate();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Rotation ended");
            }
        }
    }
}