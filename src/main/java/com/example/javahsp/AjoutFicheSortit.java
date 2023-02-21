package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.FichePatient;
import modele.FicheSortit;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutFicheSortit {

    @FXML
    private TextField QteProduit;

    @FXML
    private TextField nomProduit;

    @FXML
    private TextField raisonDemande;

    @FXML
    void ajoutFicheSortit(ActionEvent event) throws SQLException {
       FicheSortit ajout = new FicheSortit(raisonDemande.getText(),nomProduit.getText(),parseInt(QteProduit.getText()));
        ajout.ajoutFicheSortit();
        System.out.println("Demande de produit effectué !");
        HelloApplication.changeScene("ajoutFicheSortit");
    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceMedecin");
    }
}
