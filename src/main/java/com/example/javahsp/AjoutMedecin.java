package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Medecin;


import java.sql.SQLException;

public class AjoutMedecin {

    @FXML
    private TextField emailMedecin;

    @FXML
    private TextField mdpMedecin;

    @FXML
    private TextField nomMedecin;

    @FXML
    private TextField prenomMedecin;

    @FXML
    void ajoutMedecin(ActionEvent event) throws SQLException {
        Medecin ajout = new Medecin(emailMedecin.getText(), mdpMedecin.getText());
        ajout.ajoutMedecin();
        System.out.println("utilisateur ajouté !");
        HelloApplication.changeScene("ajoutMedecin");
    }

    public void DossierPatient(ActionEvent actionEvent) {
    }
}
