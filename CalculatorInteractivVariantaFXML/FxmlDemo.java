package fxml;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

public class FxmlDemo extends Application {
    public TextField textField1;
    public TextField textField2;
    public Text labelResult;

    public void start(Stage primaryStage) throws Exception {
            FXMLLoader loader = new FXMLLoader(); //D:\12Nov\src\fxml
            loader.setLocation(new URL("file:///D:/12Nov/src/fxml/FxmlDemo.fxml"));
            AnchorPane rezultatFinal = (AnchorPane) loader.load();
            Scene scena1 = new Scene(rezultatFinal);
            primaryStage.setScene(scena1);
            primaryStage.show();
    }

    public void onPlus(ActionEvent actionEvent) {
        try{
            if (textField1.getText()!=null && textField2.getText()!=null && !textField1.getText().isEmpty() && !textField1.getText().isEmpty()){
                String value = textField1.getText();
                String value2= textField2.getText();
                labelResult.setText(String.valueOf(Double.valueOf(value) + Double.valueOf(value2)));;
            }
            else{
                labelResult.setText("Introdu termenii!");
            }
        }
        catch(NumberFormatException ex){
            labelResult.setText("Populeaza toate casutele!");
        }
    }

    public void onDivide(ActionEvent actionEvent) {
        try{
            if (textField1.getText()!=null && textField2.getText()!=null && !textField1.getText().isEmpty() && !textField1.getText().isEmpty()){
                String value = textField1.getText();
                String value2= textField2.getText();
                labelResult.setText(String.valueOf(Double.valueOf(value) / Double.valueOf(value2)));;
            }
            else{
                labelResult.setText("Introdu deimpartitul/impartitorul!");
            }
        }
        catch(NumberFormatException ex){
            labelResult.setText("Populeaza toate casutele!");
        }
    }

    public void onMultiply(ActionEvent actionEvent) {
        try{
            if (textField1.getText()!=null && textField2.getText()!=null && !textField1.getText().isEmpty() && !textField1.getText().isEmpty()){
                String value = textField1.getText();
                String value2= textField2.getText();
                labelResult.setText(String.valueOf(Double.valueOf(value) * Double.valueOf(value2)));;
            }
            else{
                labelResult.setText("Introdu factorii!");
            }
        }
        catch(NumberFormatException ex){
            labelResult.setText("Populeaza toate casutele!");
        }
    }

    public void onMinus(ActionEvent actionEvent) {
        try{
            if (textField1.getText()!=null && textField2.getText()!=null && !textField1.getText().isEmpty() && !textField1.getText().isEmpty()){
                String value = textField1.getText();
                String value2= textField2.getText();
                labelResult.setText(String.valueOf(Double.valueOf(value) - Double.valueOf(value2)));;
            }
            else{
                labelResult.setText("Introdu descazutul/scazatorul!");
            }
        }
        catch(NumberFormatException ex){
            labelResult.setText("Populeaza toate casutele!");
        }
    }
}
