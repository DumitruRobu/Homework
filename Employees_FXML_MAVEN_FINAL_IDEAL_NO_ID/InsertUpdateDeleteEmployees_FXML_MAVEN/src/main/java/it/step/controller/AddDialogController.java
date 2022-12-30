package it.step.controller;

import it.step.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class AddDialogController {
    public TextField idField;
    public TextField numeField;
    public TextField prenumeField;
    public TextField emailField;
    public DatePicker dataField;

    public ChoiceBox choiceBox;
    public RadioButton maleRadioBtn;
    public RadioButton femaleRadioBtn;
    public boolean flagAdd=false;

    public void onAdd(ActionEvent event) {

//        String id = idField.getText();
        String name = numeField.getText();
        String surname = prenumeField.getText();
        String email = emailField.getText();
        LocalDate data = dataField.getValue();
        if (name.isEmpty() || data == null || /*id.isEmpty() ||*/ surname.isEmpty() || email.isEmpty() ) {        }
        else{
            Node node = (Node) event.getSource(); //inscriem in nodul node sursa de unde a fost apasat butonul adauga
            Stage stage = (Stage) node.getScene().getWindow(); //in stage inscriem adresa ferestrei careia ii apartine but. adauga
            stage.close(); //inchidem fereastra cu asa buton.
            flagAdd=true;
        }
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        choiceBox.getItems().add("Negri");
//        choiceBox.getItems().add("Caprui");
//        choiceBox.getItems().add("Albastri");
//        choiceBox.getItems().add("Verzi");
//        choiceBox.getItems().add("Gri");
//    }

//    public void onMaleSelect(){
//        if(this.femaleRadioBtn.isSelected()) {
//            this.femaleRadioBtn.setSelected(false);
//        }
//
//    }
//    public void onFemaleSelect(){
//        if(this.maleRadioBtn.isSelected()) {
//            this.maleRadioBtn.setSelected(false);
//        }
//    }
}







