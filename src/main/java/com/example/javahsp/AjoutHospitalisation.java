package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Chambre;
import modele.Hospitalisation;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutHospitalisation {

    @FXML
    private TextField maladie;

    @FXML
    private SplitMenuButton liste;

    @FXML
    void ajoutHospitalisation(ActionEvent event) throws SQLException {
        Chambre chambre = new Chambre();
        int idChambre = chambre.getIdChambre(liste.getText());
        System.out.println("Nom de la chambre sélectionnée : " + liste.getText());
        System.out.println("ID de la chambre correspondante : " + idChambre);
        Hospitalisation ajout = new Hospitalisation(maladie.getText(), idChambre);
        ajout.ajoutHospitalisation(idChambre);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de l'hospitalisation");
        alert.setHeaderText(null);
        alert.setContentText("L'hospitalisation a été ajoutée avec succès !");
        alert.showAndWait();
    }


    @FXML
    void retour(ActionEvent event)  {
      HelloApplication.changeScene("espaceMedecin");
    }

    @FXML
    void initialize() throws SQLException {
        Chambre ch = new Chambre();
        for (Chambre nomChambre : ch.selectNomChambre()) {
            MenuItem item = new MenuItem(nomChambre.getNomChambre());
            item.setOnAction(event -> liste.setText(item.getText()));
            liste.getItems().add(item);
        }
    }


}
