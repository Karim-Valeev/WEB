package ru.kpfu.itis.valeev.Task_12_1;

import java.awt.*;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Throwable {
        System.out.println("Starting client...");
        Socket s = new Socket(InetAddress.getLocalHost(), 11903);
        OutputStream out = s.getOutputStream();
        Scanner sc = new Scanner(System.in);
        String[] colorChars = new String[3];
        short r;
        short g;
        short b;
        while(true){
            Thread.sleep(1000);
            System.out.println("Enter three values representing R G B divided by whitespace: ");
            String color = sc.nextLine();
            colorChars = color.split(" ");
            if(colorChars.length > 3){
                System.out.println("Too many parameters!");
                continue;
            }
            try{
                r = Short.parseShort(colorChars[0]);
                g = Short.parseShort(colorChars[1]);
                b = Short.parseShort(colorChars[2]);
            } catch (NumberFormatException ex){
                System.out.println("Wrong format!");
                continue;
            }
            if( r<0 || r>255 || g<0 || g>255 || b<0 || b>255){
                System.out.println("Color values are out of range!");
                continue;
            }
            Color c = new Color(r, g, b);
            ByteBuffer buf = ByteBuffer.allocate(12);
            buf.putInt(r).putInt(g).putInt(b);
            System.out.println(">> " + c);
            System.out.println(Arrays.toString(buf.array()));
            out.write(buf.array());
            out.flush();
        }
    }
}