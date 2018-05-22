/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import model.Doctor;
import model.Patient;
import model.Specialization;

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
    private TableView tableView, tableView2;
    @FXML
    private DatePicker patientDate;
    @FXML
    private Accordion doctorsAccordion;
    @FXML
    private TitledPane doctorTitledPane;

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
            return;
        }
        Specialization spec = (Specialization) specializations.getSelectionModel().getSelectedItem();
        if (spec == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Brak danych");
            alert.setHeaderText("Nie podano specjalności");
            alert.setContentText("Uzupełnij dane");
            Optional<ButtonType> result = alert.showAndWait();
            return;
        }
        Doctor doctor = new Doctor(name, lastname, spec);
        doctors.add(doctor);
        doctorLastname.clear();
        doctorName.clear();
        doctorsAccordion.setExpandedPane(doctorTitledPane);
    }

    @FXML
    private void addPatient(ActionEvent event) {
        String name = patientName.getText();
        String lastname = patientLastname.getText();
        LocalDate date = patientDate.getValue();
        if (name.isEmpty() || lastname.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Brak danych");
            alert.setHeaderText("Nie podano imienia lub nazwiska");
            alert.setContentText("Uzupełnij dane");
            Optional<ButtonType> result = alert.showAndWait();
        }
        LocalDate data = (LocalDate) patientDate.getValue();
        System.out.println(data);
        if (data == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Brak danych");
            alert.setHeaderText("Nie podano daty");
            alert.setContentText("Uzupełnij dane");
            Optional<ButtonType> result = alert.showAndWait();
            return;
        }
        Patient patient = new Patient(name, lastname, data);
        patients.add(patient);
        patientLastname.clear();
        patientName.clear();
    }

    private ObservableList<Doctor> doctors
            = FXCollections.observableArrayList(
                    new Doctor("Jan", "Kowalski", Specialization.NEUROLOGIST)
            );
    private ObservableList<Patient> patients
            = FXCollections.observableArrayList(
                    new Patient("Adam", "Nowak", LocalDate.of(2012, 3, 22))
            );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Specialization> sp
                = new ArrayList(Arrays.asList(
                                Specialization.values()));
        ObservableList<Specialization> options
                = FXCollections.observableArrayList(
                        sp
                );
        System.out.println(options);
        specializations.setItems(options);

        TableColumn<Doctor, String> c1 = (TableColumn<Doctor, String>) tableView.getColumns().get(0);
        c1.setCellValueFactory(cell -> cell.getValue().getName());

        TableColumn<Doctor, String> c2 = (TableColumn<Doctor, String>) tableView.getColumns().get(1);
        c2.setCellValueFactory(cell -> cell.getValue().getLastname());

        TableColumn<Doctor, Specialization> c3 = (TableColumn<Doctor, Specialization>) tableView.getColumns().get(2);
        c3.setCellValueFactory(cell -> cell.getValue().getSpec());

        tableView.setItems(doctors);

        TableColumn<Patient, String> c4 = (TableColumn<Patient, String>) tableView2.getColumns().get(0);
        c4.setCellValueFactory(cell -> cell.getValue().getName());

        TableColumn<Patient, String> c5 = (TableColumn<Patient, String>) tableView2.getColumns().get(1);
        c5.setCellValueFactory(cell -> cell.getValue().getLastname());

        TableColumn<Patient, LocalDate> c6 = (TableColumn<Patient, LocalDate>) tableView2.getColumns().get(2);
        c6.setCellValueFactory(cell -> cell.getValue().getDate());

        tableView2.setItems(patients);
    }

}
