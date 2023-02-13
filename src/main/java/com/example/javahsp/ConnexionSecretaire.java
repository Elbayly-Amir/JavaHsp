package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Medecin;
import modele.Secretaire;

import java.sql.SQLException;

public class ConnexionSecretaire {

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    void connexion(ActionEvent event) throws SQLException {

        Secretaire s = new Secretaire(email.getText(), mdp.getText());
        Secretaire st = s.connexion();
        if(s == null){
            System.out.println("compte introuvable");
        }else{
            System.out.println("user connecté!");
        }
        System.out.println("connexion");
        HelloApplication.changeScene("espaceSecretaire");
    }

    @FXML
    void retour(ActionEvent event) {
        Accueil ac = new Accueil();
        HelloApplication.changeScene("Accueil");
    }
}
