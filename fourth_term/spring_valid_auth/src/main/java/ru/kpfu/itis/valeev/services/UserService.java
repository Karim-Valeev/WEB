package ru.kpfu.itis.valeev.services;

import com.opencsv.CSVWriter;
import ru.kpfu.itis.valeev.models.User;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class UserService {
    FileWriter writer;
    CSVWriter CsvWriter;
    public UserService() throws IOException {
        this.writer = new FileWriter("/Users/musa/Desktop/Informatics_4_sem/АА_github/kfu-programming-java4/Controllers/database.csv");
        this.CsvWriter = new CSVWriter(writer);
    }

    public void writeUser(User user) throws IOException {
        try (FileWriter fileWriter = new FileWriter("/Users/musa/Desktop/Informatics_4_sem/АА_github/kfu-programming-java4/Controllers/database.txt")) {
            fileWriter.write(user.getEmail());
            fileWriter.write(user.getUserName());
            fileWriter.write(user.getPassword());
            fileWriter.append("test");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void writeUserCsv(User user) throws IOException {
        String[] userData = { user.getUserName(), user.getEmail(), user.getPassword() };
        CsvWriter.writeNext(userData);
        writer.close();
    }
}
