package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class crudSecretaire {



    @FXML
    void ajoutSecretaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutSecretaire");
    }

    @FXML
    void retourAccueilAdmin(ActionEvent event) {
    HelloApplication.changeScene("espaceAdmin");
    }

    @FXML
    void visuSecretaire(ActionEvent event) {

    }

}
