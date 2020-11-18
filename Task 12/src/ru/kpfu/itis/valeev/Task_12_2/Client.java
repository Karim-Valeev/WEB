package ru.kpfu.itis.valeev.Task_12_2;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Client{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting client...");
        int port = 80;
//        http 80
//        https 443
        try{
            URL url = new URL("https://www.google.com/");
            String host = url.getHost();
            System.out.println(host);
            try (Socket socket = new Socket(host, port)) {
                System.out.println("SOCKET");
                try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){
                    writer.println("GET " + url.getPath() + " HTTP/1.1");
//                writer.println("Host: " + host);
//                writer.println("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//                writer.println("Accept: text/html");
//                writer.println("Accept-Language: en-US");
                    writer.println("Connection: close");
                    writer.println();

                    try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                        System.out.println("READING");
                        String line;
                        StringBuilder lines = new StringBuilder();
                        while((line = in.readLine()) != null){
                            System.out.println(line);
                            lines.append(line);
                        }
                        System.out.println("Считал все");
                        Path path = Paths.get("/home/walai_kami/Desktop/Task 12/src/ru/kpfu/itis/valeev/Task_12_2/data",host+".html");
//                        System.out.println(path.toAbsolutePath());
//                        System.out.println(path);
//                        File f = new File(String.valueOf(path));
                        try(FileWriter fw = new FileWriter(String.valueOf(path))){
//                            fw.write("<!doctype html>\n");
//                            Pattern p = Pattern.compile("(<html(.+?||\\n)+?<\\/html>)");
//                            Matcher m = p.matcher(lines);
//                            String html="";
//                            if(m.find()){
//                                html = m.group(1);
//                            }

//            Matcher m2 = p2.matcher(lines);
//
//            try(FileWriter fw = new FileWriter("hyperlinks.txt")){
//
//                while (m2.find()) {
//                    String str = m2.group(1);
//                    fw.write(str + "\n"+"\n");
//                }
                            fw.write(String.valueOf(lines));

                        }catch(IOException ex){
                            System.err.println(ex.getMessage());
                        }
                    } catch (IOException ex){
                        ex.printStackTrace();
                        System.out.println("Some I/O exception appeared.");
                    }
                } catch (IOException ex){
                    System.out.println("Can't get OutputStream");
                }


            } catch (UnknownHostException ex) {
                System.out.println("Server not found: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("I/O error: " + ex.getMessage());
            }
        } catch (MalformedURLException ex){
            System.out.println("Bad URL");
        }

    }
}