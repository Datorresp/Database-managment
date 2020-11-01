package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Database;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSearch implements Initializable {

    private final ControllerMain cm;

    @FXML
    private TextField tf;
    @FXML
    private VBox vb;
    @FXML
    private ComboBox<String> cb;

    private final ObservableList<String> olCB = FXCollections.observableArrayList("Name", "Last Name", "Full Name", "ID");


    public ControllerSearch(ControllerMain controllerMain) {
        cm = controllerMain;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (cb != null) {
            cb.setItems(olCB);
        }
    }

    @FXML
    void search() {
        try {
            Database db = cm.getDb();
            String sToSearch = tf.getText();
            String op = cb.getValue();
            String msg = "";
            switch (op) {
                case "Name":
                    msg = db.searchByFirstName(sToSearch);
                    break;
                case "Last Name":
                    msg = db.searchByLastName(sToSearch);
                    break;
                case "Full Name":
                    msg = db.searchByFullName(sToSearch);
                    break;
                case "ID":
                    msg = db.searchById(sToSearch);
                    break;
            }
            HBox hb = convert(msg);

            vb.getChildren().add(hb);

            vb.getChildren().clear();
            vb.getChildren().add(hb);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private HBox convert(String msg) {
        HBox hb = new HBox();
        Label l = new Label(msg);
        l.setFont(Font.font(20));
        hb.getChildren().add(l);
        return hb;
    }
}