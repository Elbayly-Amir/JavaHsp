package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import modele.User;
import java.util.regex.Pattern;


import java.sql.SQLException;

public class UpdatePassword {

    @FXML
    private PasswordField mdp;

    @FXML
    private PasswordField mdpConfirm;

    private static final String SPECIAL_CHARS = "!@&_-+|\\:\".?/";

    private User userConnecte;
    private boolean estConnecte;


    public UpdatePassword(User userConnecte,boolean estConnecte){
        this.userConnecte = userConnecte;
        this.estConnecte = estConnecte;
    }


    @FXML
    void confirmer(ActionEvent event) throws SQLException {
        User user = new User();
        if (mdpConfirm.getText().equals(mdp.getText()) &&
                mdp.getText().length() >= 12 &&
                Pattern.compile("[A-Z]").matcher(mdp.getText()).find() &&
                Pattern.compile("[a-z]").matcher(mdp.getText()).find() &&
                Pattern.compile("\\d").matcher(mdp.getText()).find() &&
                Pattern.compile("[" + Pattern.quote(SPECIAL_CHARS) + "]").matcher(mdp.getText()).find()) {
            this.userConnecte.setMdp(mdp.getText());
            System.out.println(mdp.getText());
            System.out.println(this.userConnecte);
            user.changePassword(this.userConnecte);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mot de passe changé !!!");
            alert.setHeaderText(null);
            alert.setContentText("Votre mot de passe a été changé !!!");
            alert.showAndWait();
            HelloApplication.changeScene("connexionUser");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mots de passe différents ou mot de passe non conforme !");
            alert.setHeaderText(null);
            alert.setContentText("Les mots de passe ne correspondent pas ou le mot de passe ne respecte pas les critères de sécurité (au moins une majuscule, une minuscule, un chiffre et un caractère spécial parmi " + SPECIAL_CHARS + ")");
            alert.showAndWait();
        }

    }




    }



