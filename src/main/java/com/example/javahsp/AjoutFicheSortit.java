package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

       FicheSortit ajout = new FicheSortit(raisonDemande.getText(),nomProduit.getText(), Integer.parseInt(QteProduit.getText()));

       if(raisonDemande.getText().isEmpty() || nomProduit.getText().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Champ vide");
           alert.setHeaderText(null);
           alert.setContentText("Veuillez saisir des informations !!");
           alert.showAndWait();
       }else if(Integer.parseInt(QteProduit.getText()) <= 0){
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Champ vide");
           alert.setHeaderText(null);
           alert.setContentText("Veuillez une quantité valide !!");
           alert.showAndWait();
       }else{
            ajout.ajoutFicheSortit();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout d'utilisateur");
            alert.setHeaderText(null);
            alert.setContentText("L'utilisateur a été ajouté avec succès !");
            alert.showAndWait();
        }
    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceMedecin");
    }
}
