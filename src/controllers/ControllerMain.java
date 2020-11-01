package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable {

    private final ControllerAdd controllerAdd;
    private final ControllerRemove controllerRemove;
    private final ControllerSearch controllerSearch;
    private final ControllerUpdate controllerUpdate;
    private final ControllerGenerate controllerGenerate;

    @FXML
    private BorderPane bp;

    @FXML
    private final Database db;

    public ControllerMain() {
        db = new Database();
        controllerAdd = new ControllerAdd(this);
        controllerRemove = new ControllerRemove(this);
        controllerSearch = new ControllerSearch(this);
        controllerUpdate = new ControllerUpdate(this);
        controllerGenerate = new ControllerGenerate(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void addWindow(ActionEvent event) throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("../windows/add.fxml"));
        fl.setController(controllerAdd);
        Pane pane = fl.load();
        bp.setCenter(pane);
    }

    @FXML
    void generateWindow(ActionEvent event) throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("../windows/generate.fxml"));
        fl.setController(controllerGenerate);
        Pane pane = fl.load();
        bp.setCenter(pane);
    }

    @FXML
    void removeWindow(ActionEvent event) throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("../windows/remove.fxml"));
        fl.setController(controllerRemove);
        Pane pane = fl.load();
        bp.setCenter(pane);
    }

    @FXML
    void searchWindow(ActionEvent event) throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("../windows/search.fxml"));
        fl.setController(controllerSearch);
        Pane pane = fl.load();
        bp.setCenter(pane);
    }

    @FXML
    void updateWindow(ActionEvent event) throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("../windows/update.fxml"));
        fl.setController(controllerUpdate);
        Pane pane = fl.load();
        bp.setCenter(pane);
    }

    public Database getDb() {
        return db;
    }

}