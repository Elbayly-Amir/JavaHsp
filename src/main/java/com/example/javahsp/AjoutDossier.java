package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Dossier;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutDossier {




    @FXML
    private TextField descriptionDossier;

    @FXML
    private TextField graviteDossier;

    @FXML
    private TextField numeroDeFichePatient;




    @FXML
    void ajoutDossier(ActionEvent event) throws SQLException {
        Dossier doss = new Dossier(descriptionDossier.getText(), graviteDossier.getText(), parseInt(numeroDeFichePatient.getText()));
        doss.ajoutDossierPatient();
        System.out.println("Dossier ajouté !");
        HelloApplication.changeScene("espaceSecretaire");
    }

    @FXML
    void retourDossier(ActionEvent event) {

        HelloApplication.changeScene("espaceSecretaire");
    }

}
