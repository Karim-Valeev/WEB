package ru.kpfu.itis.valeev;

import ru.kpfu.itis.valeev.listeners.MyMouseListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingTest {


    private static JPanel sqr = new Square();
    private static boolean sqrDisplayed = false;
    private static JPanel rotatedSqr = new RotatedSquare();
    private  static  boolean rotatedSqrDisplayed = false;
    private static JPanel formPanel = new JPanel();
    private static boolean formDisplayed = false;
    private static Rotator r;


    public static void main(String[] args) {
        final Color PURPLE = new Color(215, 141, 214);


        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(750,250,500,500);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);
        frame.setVisible(true);


        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        mb.setBackground(PURPLE);
        frame.add(BorderLayout.NORTH, mb);

        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        JMenu about = new JMenu("About");
        mb.add(file);
        mb.add(help);
        mb.add(about);

        file.add("New");
        file.add("Open...");
        file.add("Open Recent");
        file.add("Settings...");

        help.add("Help!!!");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        about.add(exit);
        JMenuItem info = new JMenuItem("Info");
        info.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(frame, "You opened modal window!", "info", JOptionPane.INFORMATION_MESSAGE);
        });
        about.add(info);


//      Creating status
        JPanel status = new JPanel();
        status.setLayout(new BorderLayout());
        status.setBackground(PURPLE);
        frame.add(status, BorderLayout.SOUTH);
        JLabel eventLabel = new JLabel("STATUS");
        status.add(eventLabel, BorderLayout.WEST);


//        Creating buttons on East
        JPanel buttons = new JPanel();
        buttons.setBackground(PURPLE);
        buttons.setLayout(new GridLayout(3, 1));
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        flow.add(buttons);
        frame.add(flow, BorderLayout.EAST);

        JButton square = new JButton("Square");
        square.setPreferredSize(new Dimension(90,90));
        square.setBackground(PURPLE);
        buttons.add(square);
        square.addMouseListener(new MouseAdapter()  {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(! sqrDisplayed){
                    frame.remove(formPanel);
                    frame.add(sqr);
                    sqrDisplayed = true;
                } else {
                    frame.remove(formPanel);
                    frame.remove(rotatedSqr);
                    frame.remove(sqr);
                    sqrDisplayed = false;
                }
                frame.repaint();
                frame.revalidate();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                eventLabel.setText("drawing square");
            }
        });

        JButton rotate = new JButton("Rotate");
        rotate.setBackground(PURPLE);
        buttons.add(rotate);
        rotate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(! rotatedSqrDisplayed){
                    rotatedSqrDisplayed = true;
                    System.out.println(rotatedSqrDisplayed);
                    r = new Rotator(frame, sqr,rotatedSqr);
                    r.start();
                } else {
                    r.interrupt();
                    frame.remove(rotatedSqr);
                    frame.remove(sqr);
                    frame.remove(formPanel);
                    rotatedSqrDisplayed = false;
                    System.out.println(rotatedSqrDisplayed);
                }
                frame.repaint();
                frame.revalidate();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                eventLabel.setText("rotating square");
            }
        });

        JButton form = new JButton("Form");
        form.setBackground(PURPLE);
        buttons.add(form);

        formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel formContent = new JPanel(new GridLayout(3  , 1));
        formContent.setBorder(BorderFactory.createLineBorder(PURPLE));
        JLabel name=new JLabel();
        name.setText(" Name :");
        JTextField txt=new JTextField();
        txt.setSize(20,20);
        JLabel pasLabel = new JLabel("Password");
        JPasswordField ps=new JPasswordField(8);
        JButton submit =new JButton();
        submit.setText("Submit");
        formContent.add(name);
        formContent.add(txt);
        formContent.add(pasLabel);
        formContent.add(ps);
        formContent.add(submit);
        formPanel.add(formContent);

        form.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!formDisplayed){
                    frame.remove(sqr);
                    frame.remove(rotatedSqr);
                    frame.add(formPanel);
                    formDisplayed = true;
                } else {
                    frame.remove(sqr);
                    frame.remove(rotatedSqr);
                    frame.remove(formPanel);
                    formDisplayed = false;
                }
                frame.repaint();
                frame.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                eventLabel.setText("showing form");
            }
        });

//        Adding event listeners
        frame.addMouseListener(new MyMouseListener(eventLabel));

//        Necessary for colors
        frame.revalidate();

    }

//    private static class Rotator extends Thread{
//
//        JFrame frame;
//        JPanel sqr;
//        JPanel rotatedSqr;
//
//        public Rotator(JFrame frame,JPanel sqr, JPanel rotatedSqr ){
//            this.frame = frame;
//            this.sqr = sqr;
//            this.rotatedSqr = rotatedSqr;
//        }
//
//        @Override
//        public void run() {
//            frame.add(rotatedSqr);
//            while(true){
//                rotatedSqr.repaint();
//                frame.repaint();
//                frame.revalidate();
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    System.out.println("Rotation ended");
//                }
//            }
//        }
//    }

}
