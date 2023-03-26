package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Produit;

import java.sql.SQLException;



public class AjoutProduit {


    @FXML
    private TextField DescriptionProduit;

    @FXML
    private TextField LibelleProduit;

    @FXML
    private MenuItem faible;

    @FXML
    private MenuItem grave;

    @FXML
    private SplitMenuButton nivDanger;

    @FXML
    private MenuItem moyen;


    @FXML
    void AjoutProduit(ActionEvent event) throws SQLException {
        Produit ajout = new Produit(DescriptionProduit.getText(), LibelleProduit.getText(), nivDanger.getText());
        ajout.AjoutProduit();
        System.out.println("Produit ajouté !");
        HelloApplication.changeScene("ajoutProduit");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout du produit");
        alert.setHeaderText(null);
        alert.setContentText("Le produit a été ajoutée avec succès !");
        alert.showAndWait();
    }



    @FXML
    void initialize() throws SQLException {
        faible.setOnAction(e -> nivDanger.setText("faible"));
        moyen.setOnAction(e -> nivDanger.setText("moyen"));
        grave.setOnAction(e -> nivDanger.setText("grave"));

        }

    @FXML
    void retourProduit(ActionEvent event) {
        HelloApplication.changeScene("espaceGestionnaire");
    }

}
