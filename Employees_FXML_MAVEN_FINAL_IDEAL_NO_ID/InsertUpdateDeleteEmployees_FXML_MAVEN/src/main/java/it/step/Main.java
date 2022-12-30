package it.step;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(new URL("file:///D:\\manager-class-demo\\src\\main\\resources\\fxml\\manager.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));

        AnchorPane anchorpane = (AnchorPane) loader.load();
        Scene scena1 = new Scene(anchorpane);

        primaryStage.setScene(scena1);
        primaryStage.setTitle("Baza de Date Angajat");
        primaryStage.show();
    }
}