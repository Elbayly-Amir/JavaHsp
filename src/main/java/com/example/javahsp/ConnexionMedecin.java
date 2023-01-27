package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Admin;
import modele.Medecin;

import java.sql.SQLException;

import static com.example.javahsp.HelloApplication.changeScene;

public class ConnexionMedecin {


    @FXML
    private TextField emailMedecin;

    @FXML
    private TextField mdpMedecin;

    @FXML
    void connexionMedecin(ActionEvent event) throws SQLException {
        ConnexionMedecin cm = new ConnexionMedecin();
        //changeScene("EspaceMedecin");

        Medecin mdc = new Medecin(emailMedecin.getText(), mdpMedecin.getText());
        Medecin m = mdc.connexion();
        if(m == null){
            System.out.println("compte introuvable");
        }else{
            System.out.println("user connecté!");
        }
        System.out.println("connexion");
        HelloApplication.changeScene("espaceMedecin");

    }

    @FXML
    void retourMedecin(ActionEvent event) {
        Accueil ac = new Accueil();
        changeScene("Accueil");
    }
}
