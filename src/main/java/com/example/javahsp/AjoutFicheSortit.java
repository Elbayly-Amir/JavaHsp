package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AjoutFicheSortit {

    @FXML
    private TextField QteProduit;

    @FXML
    private TextField nomProduit;

    @FXML
    private TextField raisonDemande;

    @FXML
    void ajoutFicheSortit(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceMedecin");
    }
}
