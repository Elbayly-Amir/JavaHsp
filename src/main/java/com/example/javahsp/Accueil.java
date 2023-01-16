package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Accueil {

    @FXML
    void gestionnaire(ActionEvent event) {

    }

    @FXML
    void medecin(ActionEvent event) {

    }

    @FXML
    void secretaire(ActionEvent event) {
        ConnexionSecretaire cs= new ConnexionSecretaire();
        HelloApplication.changeScene("connexionSecretaire");
    }
    }

