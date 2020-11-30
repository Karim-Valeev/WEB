package ru.kpfu.itis.valeev.First;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class NioExample {
    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("src/ru/kpfu/itis/valeev/First/data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ArrayList<ByteBuffer> bufs = new ArrayList<>();

// создаем буфер размера 48 байтов (!)
        ByteBuffer buf = ByteBuffer.allocate(48);
// читаем из канала в буфер, возвращается реальное количество считанных байтов
        int b = inChannel.read(buf);
        int index = 0;
        while (b != -1) {
//            Здесь каждый раз наполняется буфер и выводится только его ненулевая часть
//            Так же создается буфер определенных размеров, чтобы его потом занести в список
            ArrayList<Byte> res = new ArrayList<>();

            // режим чтения полученных данных из буфера
            buf.flip();
            while(buf.hasRemaining()){
                b = buf.get();
                res.add((byte) b);
                System.out.println(b);
            }
            buf.clear();
            b = inChannel.read(buf);

            ByteBuffer buffer = ByteBuffer.allocate(res.size());
            for(Byte b2 : res) {
                buffer.put(b2);
            }
            System.out.println(buffer);
            bufs.add(buffer);
        }

        System.out.println("BUFS SIZE IS "+bufs.size());


        for(ByteBuffer buffer : bufs){
            buffer.flip();
            inChannel.write(buffer);
        }
        aFile.close();

    }
}