package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConnexionSecretaire {

    @FXML
    private TextField email;

    @FXML
    private TextField mdp;

    @FXML
    void connexion(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {

        HelloApplication.changeScene("Acceuil");
    }
}
