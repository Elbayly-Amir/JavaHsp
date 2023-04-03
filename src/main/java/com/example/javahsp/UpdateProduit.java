package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.FichePatient;
import modele.Produit;

import java.sql.SQLException;

public class UpdateProduit {

    @FXML
    private MenuItem faible;

    @FXML
    private MenuItem grave;

    @FXML
    private TextField modifDescription;

    @FXML
    private TextField modifLibelle;

    @FXML
    private MenuItem moyen;

    @FXML
    private SplitMenuButton nivDanger;

    public Produit produit;
    public int selectProduitId;

    public UpdateProduit( int produitId) throws SQLException {
        produit = Produit.getProduitById(produitId);
        this.selectProduitId = produitId;
    }

    @FXML
    void modfiProduit(ActionEvent event) throws SQLException {

        String libelle = modifLibelle.getText();
        String description = modifDescription.getText();
        String choixDanger = nivDanger.getText();



        produit.setLibelle(libelle);
        produit.setDescription(description);
        produit.setNivDanger(choixDanger);



        produit.updateProduit(produit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifications effectuées !");
        alert.setHeaderText(null);
        alert.setContentText("Le produit a été modifié avec succès !");
        alert.showAndWait();

    }


    @FXML
    void initialize() throws SQLException {
        faible.setOnAction(e -> nivDanger.setText("faible"));
        moyen.setOnAction(e -> nivDanger.setText("moyen"));
        grave.setOnAction(e -> nivDanger.setText("grave"));

    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceGestionnaire", new EspaceGestionnaire());
    }

}
