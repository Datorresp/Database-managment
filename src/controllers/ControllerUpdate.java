package controllers;

import exceptions.SomethingMissingException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Database;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUpdate implements Initializable {

    private final ControllerMain cm;

    @FXML
    private TextField tf;

    @FXML
    private ComboBox<String> cb;

    private ObservableList<String> obCb = FXCollections.observableArrayList("Name", "Last Name", "Full Name", "ID");

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField id;

    @FXML
    private DatePicker birthday;

    @FXML
    private TextField country;

    @FXML
    private ComboBox<String> gender;

    private ObservableList<String> obGender = FXCollections.observableArrayList("Male", "Female");

    @FXML
    private TextField height;


    public ControllerUpdate(ControllerMain controllerMain) {
        cm = controllerMain;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (cb != null) {
            cb.setItems(obCb);
        }
        if (gender != null) {
            gender.setItems(obGender);
        }
    }

    @FXML
    void update() {
        try {
            Database db = cm.getDb();
            BorderPane bp = cm.getBp();
            String fn = firstName.getText();
            String ln = lastName.getText();
            String ids = id.getText();
            String phot = "";
            String b = birthday.getValue().toString();
            String c = country.getText();

            String key = tf.getText();

            if (fn.equals("") || ln.equals("") || ids.equals("") || b.equals("") || c.equals("") || key.equals("")) {
                throw new SomethingMissingException();
            }

            int g;
            if (gender.getValue().equals("Male"))
                g = Person.MALE;
            else
                g = Person.FEMALE;
            double h = Double.parseDouble(height.getText());

            Person newp = new Person(fn, ln, ids, phot, b, c, g, h);

            String op = cb.getValue();
            switch (op) {
                case "Name":
                    db.updateName(key, newp);
                    break;
                case "Last Name":
                    db.updateLastName(key, newp);
                    break;
                case "Full Name":
                    db.updateFullName(key, newp);
                    break;
                case "ID":
                     db.updateId(key, newp);
                    break;
            }
            Database.serializacion(db);

            bp.setCenter(new Pane());

            alert1();

        } catch (SomethingMissingException e) {
            e.printStackTrace();
        }
    }

    private void alert1() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("IT WAS SATISFACTORY UPDATED");
        a.setContentText("THE OBJECT WAS SATISFACTORY UPDATED");
        a.showAndWait();
    }
}