package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.FichePatient;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutProduit {


    @FXML
    private TextField DescriptionProduit;

    @FXML
    private TextField LibelleProduit;

    @FXML
    private TextField NivDangerProduit;

    @FXML
    void AjoutProduit(ActionEvent event) throws SQLException {
        Produit ajout = new Produit(DescriptionProduit.getText(), LibelleProduit.getText(),parseInt(NivDangerProduit.getText()));
        ajout.ajoutProduit();
        System.out.println("Produit ajouté !");
        HelloApplication.changeScene("AjoutProduit");

    }

    @FXML
    void retourProduit(ActionEvent event) {
        HelloApplication.changeScene("Produit");

    }
}
