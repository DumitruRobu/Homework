package it.step.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class RegisterController {
    public TextField firstNameTxtField;
    public TextField secondNameTxtField;
    public TextField usernameTxtField;
    public PasswordField passwordTxtField;
    public Text req, req1, req2, req3, warningMess;
    boolean x;

    public void onSubmit(ActionEvent actionEvent) {
        String first_name = firstNameTxtField.getText();
        String second_name = secondNameTxtField.getText();
        String username = usernameTxtField.getText();
        String password = passwordTxtField.getText();

        if (first_name.isEmpty() || second_name.isEmpty() || username.isEmpty() || password.isEmpty() )
        {
            req1.setText("*");
            req2.setText("*");
            req3.setText("*");
            req.setText("*");
            warningMess.setText("Please complete all the fields marked with *");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registration has been completed!");
            alert.setHeaderText("Congratz! The registration process has been finished!");
            alert.setTitle("Registration finished!");
            alert.setContentText("Please, log in now with your new credentials!");

            alert.show();
            Node node = (Node) actionEvent.getSource(); //inscriem in nodul node sursa de unde a fost apasat butonul adauga
            Stage stage = (Stage) node.getScene().getWindow(); //in stage inscriem adresa ferestrei careia ii apartine but. adauga
            x = true;
            stage.close(); //inchidem fereastra cu asa buton.

        }
    }

    public void onCancel (ActionEvent actionEvent) {
            System.out.println("closing");
            firstNameTxtField.setText(null);
            secondNameTxtField.setText(null);
            usernameTxtField.setText(null);
            passwordTxtField.setText(null);

            Node node = (Node) actionEvent.getSource(); //inscriem in nodul node sursa de unde a fost apasat butonul adauga
            Stage stage = (Stage) node.getScene().getWindow(); //in stage inscriem adresa ferestrei careia ii apartine but. cancel
            stage.close(); //inchidem fereastra cu asa buton.
    }

    public boolean isX() {
        return x;
    }
}
