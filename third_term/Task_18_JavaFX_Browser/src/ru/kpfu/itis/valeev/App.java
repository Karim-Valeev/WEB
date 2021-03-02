package ru.kpfu.itis.valeev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("browser.fxml"));
        window.setTitle("MyBrowser");
        window.setMinWidth(700);
        window.setMinHeight(700);
        window.setResizable(true);
        window.setScene(new Scene(root));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
