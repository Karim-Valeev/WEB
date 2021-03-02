package ru.kpfu.itis.valeev.Second;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NioStudent {

//    Todo add validation

    private Student readStudentFromChannel(FileChannel channel) throws IOException {
        String name;
        String gender;
        LocalDate birthdate;

        ArrayList<ByteBuffer> bufs = new ArrayList<>();
        ByteBuffer buf = ByteBuffer.allocate(32);

        int b = channel.read(buf);
        while (b != -1) {
            bufs.add(buf);
            buf.flip();
            buf.clear();
            b = channel.read(buf);
        }

        StringBuilder builder = new StringBuilder();
        for(ByteBuffer buffer : bufs){
            builder.append(StandardCharsets.UTF_8.decode(buffer).toString());
        }

        String strStudent = builder.toString();
        String[] fields = strStudent.split("\n");

        name = fields[0];
        gender = fields[1];
        birthdate = LocalDate.parse(fields[2],DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return new Student(name,gender, birthdate);

    }

    private void writeStudentToChannel(FileChannel channel, Student student) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(student.getName());
        builder.append('\n');
        builder.append(student.getGender());
        builder.append('\n');
        builder.append(student.getBirthDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        builder.append('\n');
        String strStud = builder.toString();
        ByteBuffer buff = ByteBuffer.wrap(strStud.getBytes(StandardCharsets.UTF_8));
        channel.write(buff);
    }

    public static void main(String[] args) throws IOException {
        NioStudent ns = new NioStudent();

//        Reading Student from the file:
        try(RandomAccessFile file = new RandomAccessFile("src/ru/kpfu/itis/valeev/Second/data/input.txt", "rw")){
            FileChannel channel = file.getChannel();
            Student student = ns.readStudentFromChannel(channel);
            System.out.println(student);
        } catch (IOException ex) {
            System.out.println("IOException occurred" + ex.getMessage());
        }

//        Creating Student instance
        Student student = new Student(
                "Josephine",
                "female",
                LocalDate.parse("01.01.2001", DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        );

//        Writing Student to the file:
        try(RandomAccessFile file = new RandomAccessFile("src/ru/kpfu/itis/valeev/Second/data/output.txt", "rw")){
            FileChannel channel = file.getChannel();
            ns.writeStudentToChannel(channel, student);
        } catch (IOException ex) {
            System.out.println("IOException occurred" + ex.getMessage());
        }

    }

}
