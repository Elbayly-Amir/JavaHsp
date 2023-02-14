package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        System.out.println(nomPatient.getText());
        FichePatient ajout = new FichePatient();
        ajout.ajoutFichePatient();
        System.out.println("Fiche Patient ajouté !");
        HelloApplication.changeScene("espaceSecretaire");

    }

}
