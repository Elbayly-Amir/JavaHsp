package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Secretaire;

import java.sql.SQLException;

public class AjoutSecretaire {

    @FXML
    private TextField emailSecretaire;

    @FXML
    private TextField mdpSecretaire;

    @FXML
    private TextField nomSecretaire;

    @FXML
    private TextField prenomSecretaire;

    @FXML
    void ajoutSecretaire(ActionEvent event) throws SQLException {
    Secretaire ajout = new Secretaire(nomSecretaire.getText(), prenomSecretaire.getText(),emailSecretaire.getText(), mdpSecretaire.getText());
    ajout.ajoutSecretaire();
    System.out.println("utilisateur ajouté !");
    HelloApplication.changeScene("ajoutSecretaire");
    }
}
