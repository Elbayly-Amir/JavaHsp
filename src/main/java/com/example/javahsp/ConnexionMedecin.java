package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConnexionMedecin {


    @FXML
    private TextField emailMedecin;

    @FXML
    private TextField mdpMedecin;

    @FXML
    void connexionMedecin(ActionEvent event) {

    }

    @FXML
    void retourMedecin(ActionEvent event) {
        Accueil ac = new Accueil();
        HelloApplication.changeScene("Accueil");
    }
}
