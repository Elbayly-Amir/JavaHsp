package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modele.FichePatient;
import modele.SuivieFichePatient;
import modele.User;

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


    private int id_user;

    public AjoutFichePatient(int id_user) {
        this.id_user = id_user;
    }

    @FXML
    void ajoutFichePatient(ActionEvent event) throws SQLException {
        User user = new User(id_user); // Crée une instance de User avec l'ID de l'utilisateur
        FichePatient ajout = new FichePatient(nomPatient.getText(), prenomPatient.getText(), parseInt(numSecuPatient.getText()), emailPatient.getText(), ruePatient.getText(), parseInt(cpPatient.getText()), villePatient.getText());
        int idFichePatient = ajout.ajoutFichePatient(id_user);

        // Appeler la méthode AjoutSuivieFichePatient de la classe SuivieFichePatient
        SuivieFichePatient sfp = new SuivieFichePatient();
        sfp.AjoutSuivieFichePatient(id_user, idFichePatient);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de la fiche patient");
        alert.setHeaderText(null);
        alert.setContentText("La fiche patient a été ajoutée avec succès !");
        alert.showAndWait();
    }

    @FXML
    void retourFichePatient(ActionEvent event) {
        HelloApplication.changeScene("espaceSecretaire",new EspaceSecretaire());
    }

    }


