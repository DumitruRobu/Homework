package it.step.controller;
import it.step.db.EmployeeManagerDB;
import it.step.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    public TableColumn<Person, Integer> idCol;
    public TableColumn<Person, String> numeCol;
    public TableColumn<Person, String> prenumeCol;
    public TableColumn<Person, String> emailCol;
    public TableColumn<Person, LocalDate> dataCol;

    public TableView<Person> table;
    private EmployeeManagerDB db = new EmployeeManagerDB();

    public void onAdd(ActionEvent event) throws IOException { //adul de pe principala

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/add.fxml"));
        AnchorPane parent = loader.load();
        //Parent parent = FXMLLoader.load(getClass().getResource("/fxml/add.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Add employee"); //setam titlul ferestrei
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //facem fereastra modala
        stage.showAndWait(); //nu trece la urm instructiune pina fereastra "add employee" nu s-a inchis


        AddDialogController dialogController = loader.getController();

//            String id = dialogController.idField.getText();
            String name = dialogController.numeField.getText();
            String surname = dialogController.prenumeField.getText();
            String email = dialogController.emailField.getText();

            LocalDate birthdate = dialogController.dataField.getValue();

        if(dialogController.flagAdd){ //IFUL E PENTRU A EVITA EROAREA ATUNCI CIND INCHIDEM FEREASTRA DE ADAUGARE PE "x"
            //table.getItems().add(new Person(name, surname, email, birthdate));
            db.create(new Person(name, surname, email, birthdate));

////----------------------------------------------------------------------------------------------------------
//FACEM REFRESHUL PE TABELA END-USERULUI CU ANGAJATII DUPA APASAREA BUTONULUI DE ADAUGA (ADD A NEW EMPLOYEE)--
            ObservableList<Person> list = FXCollections.observableArrayList();
            List<Person> persons = db.selectAll();

            for(Person p: persons) {
                list.add(p);
            }
            //Link person list with table
            table.setItems(list);
        }
}
////-----------------------------------------------------------------------------------------------------------
////-----------------------------------------------------------------------------------------------------------

    public void onDelete(ActionEvent event) {
        //getselected index
        int idx = table.getSelectionModel().getSelectedIndex();
        if (idx != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please confirm deletion!");
            alert.setTitle("Delete?");//table.getItems().get(idx).setName("edited name");
            alert.setHeaderText("Are you sure you want to delete " + table.getItems().get(idx).toString());
            alert.setContentText("Please, hit 'yes' if you are sure that you want to delete the selected employee.");
            Optional<ButtonType> result = alert.showAndWait();  //returneaza un obiect de tip optional si primeste un parametru tip buttontype
            if (result.isPresent()) {
                if (result.get() == ButtonType.OK) { //daca a apasat OK
                    db.delete(table.getItems().get(idx).getId());
                    table.getItems().remove(idx);

                    //Poti sterge linia asta: cva gresit aici: db.delete(table.getItems().get(idx).getId());
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select an employee!");
            alert.setHeaderText("Selection required!");
            alert.setTitle("Please, select!");
            alert.setContentText("Please, select an employee!");
            alert.show();
        }


        //delete selected index
    }

    public void onEdit(ActionEvent event) throws IOException {
        int idx = table.getSelectionModel().getSelectedIndex();
        if (idx != -1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/edit.fxml"));
            AnchorPane parent = loader.load();

            //acest bloc din 2 linii de cod citeste indexul selectat si pre-populeaza deja cimpurile editeaza cu inf despre angajatorul selectat
            EditDialogController controller = loader.getController();
            controller.setPerson(table.getItems().get(idx));

            //Parent parent = FXMLLoader.load(getClass().getResource("/fxml/add.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Edit employee"); //setam titlul ferestrei
            stage.setScene(scene);
            stage.showAndWait(); //nu trece la urm instructiune pina fereastra "add employee" nu s-a inchis

//            String id = controller.idField.getText();

//            Integer idFinn = Integer.parseInt(id);
            String name = controller.numeField.getText();
            String surname = controller.prenumeField.getText();
            String email = controller.emailField.getText();
            LocalDate birthdate = controller.dataField.getValue();

            Person person = controller.getResult();


            //INTRODUCEM UPDATEUL IN BD:
            db.update(person);
            //fin la INTRODUCEM UPDATEUL IN BD:

            table.getItems().set(idx, person);
            table.refresh();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select an employee!");
            alert.setHeaderText("Selection required!");
            alert.setTitle("Please, select!");
            alert.setContentText("Please, select an employee!");
            alert.show();
        }
//        table.getItems().get(idx).setId(999);
//        table.getItems().get(idx).setName("edited name");
//        table.getItems().get(idx).setSurname("edited surname");
//        table.getItems().get(idx).setEmail("edited email");
//        table.getItems().get(idx).setBirthdate(LocalDate.now());
//        table.refresh();
    }

    public void onClose(ActionEvent event) {//butonu close a meniului file>close
        System.out.println("closing");
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Create person list
        ObservableList<Person> list = FXCollections.observableArrayList();
        List<Person> persons = db.selectAll();

        for(Person p: persons) {
            list.add(p);
        }
//        list.add(new Person(1, "Jade", "Smith", "js@js.com", LocalDate.of(1989, 9, 14)));
//        list.add(new Person(2, "John", "Smith", "jhns@jhns.com", LocalDate.of(1989, 9, 14)));
//        list.add(new Person(3, "James", "Symons", "jsy@jsy.com", LocalDate.of(1989, 6, 19)));
        //Link person list with table
        table.setItems(list);
        //Link id with idCol
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        //Link name with nameCol
        numeCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        //Link surname with surnameCol
        prenumeCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        //Link birthdate with birthdateCol
        dataCol.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        //Link email with emailCol
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    }
}


//if(dialogController.dataField.getValue().isEqual(null) || dialogController.numeField.getText().isEmpty()
//        || dialogController.prenumeField.getText().isEmpty() || dialogController.emailField.getText().isEmpty()
//        || dialogController.numeField.getText().equals(null) || dialogController.prenumeField.getText().equals(null)
//        || dialogController.idField.getText().equals(null) || dialogController.idField.getText().isEmpty()
//        || dialogController.emailField.getText().equals(null)|| dialogController.dataField.getValue().equals(null) )
//        {
//        }