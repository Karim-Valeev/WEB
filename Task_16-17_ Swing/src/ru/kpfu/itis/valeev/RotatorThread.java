package ru.kpfu.itis.valeev;

import javax.swing.*;

public class RotatorThread extends Thread{

    private JFrame frame;
    private JPanel sqr;
    private JPanel rotatedSqr;

    public RotatorThread(JFrame frame, JPanel sqr, JPanel rotatedSqr ){
        this.frame = frame;
        this.sqr = sqr;
        this.rotatedSqr = rotatedSqr;
    }

    @Override
    public void run() {
        frame.add(rotatedSqr);
        while(true){
            rotatedSqr.repaint();
//            frame.repaint();
            frame.revalidate();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Rotation ended");
            }
        }
    }
}