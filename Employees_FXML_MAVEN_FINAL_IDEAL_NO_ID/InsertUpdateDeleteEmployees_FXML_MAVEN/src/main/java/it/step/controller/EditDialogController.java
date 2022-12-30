package it.step.controller;

import it.step.model.Person;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditDialogController {
    private Person copy;

//    public TextField idField;
    public TextField numeField;
    public TextField prenumeField;
    public TextField emailField;
    public DatePicker dataField;

    public void setPerson(Person person){
        //read name
        copy=person;

//        String idFin = Integer.toString(person.getId());
//        idField.setText(idFin);
        numeField.setText(person.getName());
        prenumeField.setText(person.getSurname());
        emailField.setText(person.getEmail());
        dataField.setValue(person.getBirthdate());
        //read birthdate
    }

    public Person getResult(){
         return new Person(copy.getId(), numeField.getText(), prenumeField.getText(), emailField.getText(),dataField.getValue());
    }

    public void onEdit(ActionEvent event) {

        if (/*idField.getText().isEmpty() ||*/ numeField.getText().isEmpty() || prenumeField.getText().isEmpty() || emailField.getText().isEmpty() || dataField.getValue() ==null){
            String dataFin = Integer.toString(copy.getId());
//            idField.setText(dataFin);
            numeField.setText(copy.getName());
            prenumeField.setText(copy.getSurname());
            emailField.setText(copy.getEmail());
            dataField.setValue(copy.getBirthdate());
        }
        else{

        }
            Node node = (Node) event.getSource(); //inscriem in nodul node sursa de unde a fost apasat butonul adauga
            Stage stage = (Stage) node.getScene().getWindow(); //in stage inscriem adresa ferestrei careia ii apartine but. adauga
            stage.close(); //inchidem fereastra cu asa buton.
        }
    }

