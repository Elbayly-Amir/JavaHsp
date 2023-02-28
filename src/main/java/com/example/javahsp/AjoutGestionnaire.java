package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Gestionnaire;
import modele.Medecin;

import java.sql.SQLException;

public class AjoutGestionnaire {

    @FXML
    private TextField emailGestionnaire;

    @FXML
    private PasswordField mdpGestionnaire;

    @FXML
    private TextField nomGestionnaire;

    @FXML
    private TextField prenomGestionnaire;

    @FXML
    void ajoutGestionnaire(ActionEvent event) throws SQLException {
        Gestionnaire ajout = new Gestionnaire(nomGestionnaire.getText(), prenomGestionnaire.getText(),emailGestionnaire.getText(), mdpGestionnaire.getText());
        ajout.ajoutGest();
        System.out.println("utilisateur ajouté !");
        HelloApplication.changeScene("ajoutGestionnaire");
    }

    @FXML
    void retourAccueil(ActionEvent event) {
        HelloApplication.changeScene("espaceAdmin");
    }
}
