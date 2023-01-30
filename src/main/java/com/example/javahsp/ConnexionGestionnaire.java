package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Admin;
import modele.Gestionnaire;

import java.sql.SQLException;

import static com.example.javahsp.HelloApplication.changeScene;

public class ConnexionGestionnaire {

    @FXML
    private TextField emailGest;

    @FXML
    private TextField mdpGest;

    @FXML
    void ConnexionGestionnaire(ActionEvent event) throws SQLException {
        Gestionnaire gest = new Gestionnaire(emailGest.getText(), mdpGest.getText());
        Gestionnaire g = gest.connexion();
        if(g == null){
            System.out.println("compte introuvable");
        }else{
            System.out.println("user connecté!");
        }
        System.out.println("connexion");
        changeScene("gestionnaire_stock");

    }

    @FXML
    void retourGestionnaire(ActionEvent event) {
        Accueil ac = new Accueil();
        changeScene("Accueil");
    }


}


