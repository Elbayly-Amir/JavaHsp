package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Admin;

import java.sql.SQLException;

public class CoAdmin {




    @FXML
    private TextField emailAdmin;

    @FXML
    private PasswordField mdpAdmin;

    @FXML
    void connexionAdmin(ActionEvent event) throws SQLException {
        Admin adm = new Admin(emailAdmin.getText(), mdpAdmin.getText());
        Admin a = adm.connexion();
        if(a == null){
            System.out.println(" id introuvable");
        }else{
            System.out.println("user connecté!");
        }
        System.out.println("connexion");
        HelloApplication.changeScene("espaceAdmin");

    }

    @FXML
    void retourAdmin(ActionEvent event) {
        CoAdmin cad = new CoAdmin();
        HelloApplication.changeScene("Accueil");
    }
}
