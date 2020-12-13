package ru.kpfu.itis.valeev;

import ru.kpfu.itis.valeev.listeners.MyMouseListener;

import javax.swing.*;
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
//            JDialog dialog = new JDialog(frame, "Modal window", true);
//            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            dialog.setSize(new Dimension(300, 300));
//            dialog.setResizable(false);
//            dialog.setVisible(true);
//
//            JLabel l = new JLabel();
//            JTextArea text = new JTextArea("This is a modal window.\nReally helpful information, isn't it?");
//            text.setEditable(false);
//            l.setText("info");
//            JPanel p = new JPanel();
//            p.add(l);
//            dialog.add(p);
////            dialog.add(text);
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
        buttons.setLayout(new GridLayout(3, 1, 5, 0));
        frame.add(buttons, BorderLayout.EAST);

        JButton square = new JButton("Square");
        square.setBackground(PURPLE);
        buttons.add(square);
        square.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(! sqrDisplayed){
                    frame.add(sqr);
                    sqrDisplayed = true;
                } else {
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
                    frame.getContentPane().remove(sqr);
                    frame.getContentPane().add(rotatedSqr);
                    rotatedSqrDisplayed = true;
                    System.out.println(rotatedSqrDisplayed);
                    frame.repaint();
                } else {
                    frame.getContentPane().remove(rotatedSqr);
                    frame.getContentPane().add(sqr);
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

        JLabel name=new JLabel();
        name.setText(" Name :");
        JTextField txt=new JTextField();
        txt.setText("Karim");
        JLabel pasLabel = new JLabel("Password");
        JPasswordField ps=new JPasswordField(8);
        JButton submit =new JButton();
        submit.setText("Submit");
        formPanel.add(name);
        formPanel.add(txt);
        formPanel.add(pasLabel);
        formPanel.add(ps);
        formPanel.add(submit);

        form.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!formDisplayed){
                    frame.add(formPanel, BorderLayout.CENTER);
                    formDisplayed = true;
                    frame.revalidate();
                } else {
                    frame.remove(formPanel);
                    formDisplayed = false;
                    frame.revalidate();
                }
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

}
