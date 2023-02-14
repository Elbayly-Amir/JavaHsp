package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Fournisseur;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutFournisseur {

    @FXML
    private TextField nomFournisseur;

    @FXML
    void ajoutFournisseur(ActionEvent event) throws SQLException {
        Fournisseur ajout = new Fournisseur(nomFournisseur.getText());
        ajout.ajoutFournisseur();
        System.out.println("Fournisseur ajouté !");
        HelloApplication.changeScene("AjoutFournisseur");

    }

    @FXML
    void retourFournisseur(ActionEvent event) {
        HelloApplication.changeScene("Fournisseur");

    }
}
