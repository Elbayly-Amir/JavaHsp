package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Chambre;

import java.sql.SQLException;

public class AjoutChambre {

    @FXML
    private SplitMenuButton dispo;

    @FXML
    private TextField nomdeChambre;

    @FXML
    private MenuItem nonOccupe;

    @FXML
    void ajoutChambre(ActionEvent event) throws SQLException {

        Chambre chm = new Chambre(nomdeChambre.getText(),nonOccupe.getText());
        chm.ajoutChambre();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de la chambre");
        alert.setHeaderText(null);
        alert.setContentText("La chambre a été ajouté avec succée !!");
        alert.showAndWait();


    }



    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceAdmin", new EspaceAdmin());
    }

}
