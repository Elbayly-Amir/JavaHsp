package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CrudMedecin {


    @FXML
    void ajoutMedecin(ActionEvent event) {
        HelloApplication.changeScene("ajoutMedecin");
    }

    @FXML
    void retourAccueil(ActionEvent event) {

        HelloApplication.changeScene("espaceAdmin");
    }

    @FXML
    void visuMedecin(ActionEvent event) {

    }
}
