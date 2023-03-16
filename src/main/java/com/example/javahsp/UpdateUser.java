package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modele.User;

import java.sql.SQLException;

public class UpdateUser {

    @FXML
    private TextField emailUpdate;

    @FXML
    private TextField nomUpdate;

    @FXML
    private TextField prenomUpdate;

    public static int selectedUserId;

    @FXML
    void modification(ActionEvent event) throws SQLException {
        User user = new User(nomUpdate.getText(),prenomUpdate.getText(),emailUpdate.getText());
        selectedUserId = user.getId_user();


        System.out.println(user.getId_user());
        user.updateUser(user);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifications effectuées !");
        alert.setHeaderText(null);
        alert.setContentText("L'utilisateur a été modifié avec succès !");
        alert.showAndWait();
    }



    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceAdmin");
    }

}
