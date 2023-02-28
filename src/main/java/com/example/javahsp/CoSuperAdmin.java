package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Admin;
import modele.SuperAdmin;

import java.sql.SQLException;

public class CoSuperAdmin {

    @FXML
    private TextField emailSuperAdmin;

    @FXML
    private PasswordField mdpSuperAdmin;

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("Accueil");
    }

    @FXML
    void coSuperAdmin(ActionEvent event) throws SQLException {
        SuperAdmin a = new SuperAdmin(emailSuperAdmin.getText(), mdpSuperAdmin.getText());
        a.connexion();
        if(a == null){
            System.out.println("compte introuvable");
        }else{
            System.out.println("user connecté!");
        }
        System.out.println("connexion");
        HelloApplication.changeScene("espaceSuperAdmin");

    }

}
