/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Student
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox specializations;

    @FXML
    private TextField doctorName, doctorLastname, patientName, patientLastname;

    @FXML
    private void addDoctor(ActionEvent event) {
        String name = doctorName.getText();
        String lastname = doctorLastname.getText();
        if (name.isEmpty() || lastname.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Brak danych");
            alert.setHeaderText("Nie podano imienia lub nazwiska");
            alert.setContentText("Uzupełnij dane");
            Optional<ButtonType> result = alert.showAndWait();
        }
        String spec = (String) specializations.getSelectionModel().getSelectedItem();
        if(spec == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Brak danych");
            alert.setHeaderText("Nie podano specjalności");
            alert.setContentText("Uzupełnij dane");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void addPatient(ActionEvent event) {
        String name = patientName.getText();
        String lastname = patientLastname.getText();
        if (name.isEmpty() || lastname.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Brak danych");
            alert.setHeaderText("Nie podano imienia lub nazwiska");
            alert.setContentText("Uzupełnij dane");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Pediatra",
                        "Laryngolog",
                        "Okulista"
                );
        specializations.setItems(options);
    }

}
