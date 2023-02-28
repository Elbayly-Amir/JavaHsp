package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Admin;

import java.sql.SQLException;

public class CoAdmin {



    @FXML
    private Label erreur;
    @FXML
    private TextField emailAdmin;

    @FXML
    private PasswordField mdpAdmin;

    @FXML
    void connexionAdmin(ActionEvent event) throws SQLException {
        Admin adm = new Admin(emailAdmin.getText(), mdpAdmin.getText());
        Admin a = adm.connexion();
        if(a == null){

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setContentText("Careful with the next step!");
            erreur.setText("erreur");

            alert.showAndWait();

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Careful with the next step!");
            System.out.println("user connecté!");
            erreur.setText("erreur");

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
