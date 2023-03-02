package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import modele.User;

import java.sql.SQLException;

public class UpdatePassword {

    @FXML
    private PasswordField mdp;

    @FXML
    private PasswordField mdpConfirm;


    @FXML
    void confirmer(ActionEvent event) throws SQLException {
        User user = new User();
        if ( mdpConfirm.getText().equals(mdp.getText())){
            System.out.println(mdp.getText());
            user.changePassword();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mot de passe changé !!!");
            alert.setHeaderText(null);
            alert.setContentText("Votre mot de passe a été changé !!!");
            alert.showAndWait();
            HelloApplication.changeScene("connexionUser");

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de changement de mot de passe !!");
            alert.setHeaderText(null);
            alert.setContentText("Les mot de passe ne corresponde pas !! ");
            alert.showAndWait();
            System.out.println("Les mot de passe ne corresponde pas !!");
        }


    }

}
