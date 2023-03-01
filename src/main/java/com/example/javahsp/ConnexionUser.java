package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.User;

import java.sql.SQLException;

public class ConnexionUser {

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    void connexion(ActionEvent event) throws SQLException {
        User user = new User(email.getText(),mdp.getText());
        user.connexionUser();

    }



    @FXML
    void retour(ActionEvent event) {

    }

}
