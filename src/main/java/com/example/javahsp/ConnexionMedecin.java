package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.example.javahsp.HelloApplication.changeScene;

public class ConnexionMedecin {


    @FXML
    private TextField emailMedecin;

    @FXML
    private TextField mdpMedecin;

    @FXML
    void connexionMedecin(ActionEvent event) {
        ConnexionMedecin cm = new ConnexionMedecin();
        changeScene("EspaceMedecin");

    }

    @FXML
    void retourMedecin(ActionEvent event) {
        Accueil ac = new Accueil();
        changeScene("Accueil");
    }
}
