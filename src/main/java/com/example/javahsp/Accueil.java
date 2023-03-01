package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modele.User;

public class Accueil {



    @FXML
    void connexion(ActionEvent event) {
        HelloApplication.changeScene("connexionUser");
    }

}
