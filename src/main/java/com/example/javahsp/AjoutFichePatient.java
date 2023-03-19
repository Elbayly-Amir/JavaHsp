package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modele.FichePatient;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutFichePatient {

    @FXML
    private TextField cpPatient;

    @FXML
    private TextField emailPatient;

    @FXML
    private TextField nomPatient;

    @FXML
    private TextField numSecuPatient;

    @FXML
    private TextField prenomPatient;

    @FXML
    private TextField ruePatient;

    @FXML
    private TextField villePatient;

    @FXML
    void retourFichePatient(ActionEvent event) {
        HelloApplication.changeScene("espaceSecretaire");
    }


    @FXML
    void ajoutFichePatient(ActionEvent event) throws SQLException {

        FichePatient ajout = new FichePatient(nomPatient.getText(),prenomPatient.getText(),parseInt(numSecuPatient.getText()),emailPatient.getText(),ruePatient.getText(),parseInt(cpPatient.getText()),villePatient.getText());
        ajout.ajoutFichePatient();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de la fiche patient");
        alert.setHeaderText(null);
        alert.setContentText("La fiche patient a été ajoutée avec succès !");
        alert.showAndWait();
    }

}
