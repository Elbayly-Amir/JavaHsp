package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EspaceAdmin {


    @FXML
    void crudMedecin(ActionEvent event) {
            HelloApplication.changeScene("crudMedecin");
    }

    @FXML
    void crudSecretaire(ActionEvent event) {
            HelloApplication.changeScene("crudSecretaire");
    }

    @FXML
    void crudgestionnaire(ActionEvent event) {
        HelloApplication.changeScene("crudGestionnaire");
    }

    @FXML
    void retourAdmin(ActionEvent event) {

    }
}
