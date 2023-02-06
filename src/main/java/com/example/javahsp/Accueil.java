package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Accueil {

    @FXML
    void admin(ActionEvent event) {
        CoAdmin cad = new CoAdmin();
        HelloApplication.changeScene("coAdmin");
    }

    @FXML
    void gestionnaire(ActionEvent event) {
        ConnexionGestionnaire cs= new ConnexionGestionnaire();
        HelloApplication.changeScene("ConnexionGestionnaire");
    }

    @FXML
    void medecin(ActionEvent event) {
        ConnexionMedecin cm = new ConnexionMedecin();
        HelloApplication.changeScene("connexionMedecin");
    }

    @FXML
    void secretaire(ActionEvent event) {
        ConnexionSecretaire cs= new ConnexionSecretaire();
        HelloApplication.changeScene("connexionSecretaire");
    }
    }

