package controllers;

import exceptions.SomethingMissingException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Database;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdd implements Initializable {

    private final ControllerMain cm;

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
    private TextField height;

    @FXML
    private ComboBox<String> gender;

    private final ObservableList<String> olgender = FXCollections.observableArrayList("Male", "Female");

    public ControllerAdd(ControllerMain controllerMain) {
        cm =  controllerMain;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (gender != null) {
            gender.setItems(olgender);
        }
    }

    @FXML
    void addPerson(ActionEvent event) {
        try {
            Database db = cm.getDb();
            String fn = firstName.getText();
            String ln = lastName.getText();
            String ids = id.getText();
            String phot = "";
            String b = birthday.getValue().toString();
            String c = country.getText();

            if (fn.equals("") || ln.equals("") || ids .equals("") || b .equals("") || c .equals("")) {
                throw new SomethingMissingException();
            }

            int g;
            if (gender.getValue().equals("Male"))
                g = Person.MALE;
            else
                g= Person.FEMALE;
            double h = Double.parseDouble(height.getText());

            Person newp = new Person(fn, ln, ids, phot, b, c, g, h);
            db.addPerson(newp);

         } catch (NumberFormatException | NullPointerException | SomethingMissingException e) {
            alert1();
        }


    }

    private void alert1() {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText("Something is missing");
        a.showAndWait();
    }
}
