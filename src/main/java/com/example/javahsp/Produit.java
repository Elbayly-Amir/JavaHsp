package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modele.FichePatient;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class Produit {
    @FXML
    private TableColumn<?, ?> descriptionProduit;

    @FXML
    private TableColumn<?, ?> libelleProduit;

    @FXML
    private TableColumn<?, ?> nivDangerProduit;

    @FXML
    private TableView<?> tableProduit;

    public Produit(String text, String text1, int parseInt) {

    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        modele.Produit affiche = new modele.Produit();
        try {
            ResultSet stock = affiche.SelectProduit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void ajoutProduit() {
    }
}
