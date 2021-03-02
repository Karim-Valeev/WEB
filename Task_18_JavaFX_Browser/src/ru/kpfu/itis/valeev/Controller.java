package ru.kpfu.itis.valeev;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    WebView webView;

    WebEngine engine;

    @FXML
    TextField address;

    String link;

    ObservableList<String> history;

    int cursor;

    @FXML
    ComboBox<String> historyDropDown;

    @FXML
    Label status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        history = FXCollections.observableArrayList();
        engine = webView.getEngine();
        engine.load("https://www.google.com/");
        initStatus();
        history.add("https://www.google.com/");
        historyDropDown.setItems(history);
        cursor = 0;
    }

    @FXML
    public void search(ActionEvent actionEvent){
        link = address.getText();
        link = "https://" + link;
        engine.load(link);
        address.setText(link);
        history.add(link);
        historyDropDown.setItems(history);
        cursor = history.size()-1;
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        if(cursor-1>=0){
            cursor--;
            link = history.get(cursor);
            address.setText(link);
            engine.load(link);
        }
    }

    @FXML
    public void forward(ActionEvent actionEvent) {
        if(cursor+1<history.size()){
            cursor++;
            link = history.get(cursor);
            address.setText(link);
            engine.load(link);
        }
    }

    private void initStatus(){
        Worker<Void> worker = engine.getLoadWorker();
        worker.stateProperty().addListener((observable, oldValue, newValue ) -> {
            status.setText("status: " + newValue.toString());
            if(newValue==Worker.State.SUCCEEDED){
                status.setText("Successfully loaded: " + link);
            }
            if(newValue==Worker.State.FAILED){
                status.setText("Failed to load: " + link);
            }
        });
    }

}
