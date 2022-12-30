package it.step.controller;

import it.step.db.EmployeeManagerDB;
import it.step.db.UsersManagerDB;
import it.step.model.Person;
import it.step.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController{

    private UsersManagerDB db1 = new UsersManagerDB();

    public TextField usernameTxtField;
    public TextField passwordTxtField;
    public Text warningMessage;
    public Text warningMessage2;


    public void onLogin(ActionEvent actionEvent) throws IOException {
        boolean flagLog = false;
        if (usernameTxtField.getText().isEmpty() || passwordTxtField.getText().isEmpty()){
            warningMessage2.setText("");
            warningMessage.setText("Please fill in the login and password fields!");
        }
        else{

            ObservableList<User> list = FXCollections.observableArrayList();
            UsersManagerDB db = new UsersManagerDB();
            List<User> users = db.selectAll();

            for(User p: users) {
                list.add(p);
            }

            for(int i=0; i<list.toArray().length; i++){
                if(String.valueOf(list.get(i)).equals(usernameTxtField.getText()+passwordTxtField.getText())){
                    warningMessage.setText("");
                    warningMessage2.setText("Access granted!");
                    flagLog=true;
                }
            }
            if(!flagLog){
                warningMessage2.setText("");
                warningMessage.setText("Username or Password is incorrect!");
            }
            else{
                Node node = (Node) actionEvent.getSource(); //inscriem in nodul node sursa de unde a fost apasat butonul 'login', adica fereastra de logare
                Stage stage = (Stage) node.getScene().getWindow(); //in stage inscriem adresa ferestrei careia ii apartine but. logare, adica inscriem fereastra de logare
                stage.close(); //inchidem fereastra cu asa buton.

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/manager.fxml"));
                AnchorPane parent = loader.load();
                Scene scene = new Scene(parent);
                Stage stage2 = new Stage();
                stage2.setTitle("Welcome!"); //setam titlul ferestrei
                stage2.setScene(scene);
                //stage.initModality(Modality.APPLICATION_MODAL); //facem fereastra modala
                stage2.showAndWait(); //nu trece la urm instructiune pina fereastra "add employee" nu s-a inchis
            }
        }
    /*
    0. Adaugam ID pentru campurile username si password
    1. Citim datele introduse in text field-uri
    2. Validam datele - daca sunt complete
    3. Daca datele nu sunt corecte - afisam o alerta (#see main scene controller - delete)
    4. Cream o clasa noua: User (campuri: firstname/last name/username/password/boolean isActive)
    5.SELECT user din baza de date unde username = usernameTxtField.getText() si parola = password.getText()
    6.Daca utilizatorul a fost gasit = deschidem fereastra principala
      Daca nu a fost gasit = afisam mesaj de eroare!
    7.
     */
    }

    public void onRegister(ActionEvent actionEvent) throws IOException {
        /*
        1. Adaugam o fereastra noua, register.fxml
        2. De afisat cimpurile necesare pt clasa user
        3. Cind facem clcik pe register- salvam in bd utilizatorul nou
        4. Inchidem dialogul de inregistrare
        5. Afisam loginul
         */

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        AnchorPane parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Register a new user!"); //setam titlul ferestrei
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //facem fereastra modala
        stage.showAndWait(); //nu trece la urm instructiune pina fereastra "add employee" nu s-a inchis

            RegisterController dialogController = loader.getController();
            //CONTROLEZ DACA INREGISTRAREA A FOST COMPLETATA SI DOAR ATUNCI INSCRIU DATELE!
            boolean flag1 = dialogController.isX();

            if(flag1){
                String name = dialogController.firstNameTxtField.getText();
                String surname = dialogController.secondNameTxtField.getText();
                String username = dialogController.usernameTxtField.getText();
                String password = dialogController.passwordTxtField.getText();

                db1.create(new User(name, surname, username, password));
            }
    }
}