package ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.ControllerMain;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author diegoa.torres
 * @author JuanGuerra
 */
public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("../windows/rear.fxml"));
        fl.setController(new ControllerMain());
        Parent p = fl.load();
        primaryStage.setScene(new Scene(p));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
