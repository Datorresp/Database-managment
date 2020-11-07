package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import model.Database;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGenerate implements Initializable  {

    private ControllerMain cm;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    public ControllerGenerate(ControllerMain controllerMain) {
        cm = controllerMain;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void generate(ActionEvent ae) throws IOException {
        Database db = cm.getDb();
        String st1 = tf1.getText();
        String st2 = tf2.getText();
        String st3 = tf3.getText();
        int n = Integer.parseInt(tf4.getText());
        db.loadTextFile(st1, st2, st3,",", n);
        System.out.println("Generate");
    }
}