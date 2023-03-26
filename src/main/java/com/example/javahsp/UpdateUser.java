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


    public User user;
    public int selectedUserId;

    public UpdateUser(int userId) throws SQLException {
        user = User.getUserById(userId);
        selectedUserId = userId;
    }

    @FXML
    void initialize() throws SQLException {

        User user = User.getUserById(selectedUserId);
        nomUpdate.setText(user.getNom());
        prenomUpdate.setText(user.getPrenom());
        emailUpdate.setText(user.getEmail());
    }

    @FXML
    void modification(ActionEvent event) throws SQLException {
        String nom = nomUpdate.getText();
        String prenom = prenomUpdate.getText();
        String email = emailUpdate.getText();

        user.setNom(nom);
        user.setPrenom(prenom);
        user.setEmail(email);

        user.updateUser(user);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifications effectuées !");
        alert.setHeaderText(null);
        alert.setContentText("L'utilisateur a été modifié avec succès !");
        alert.showAndWait();
    }



    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceAdmin",new EspaceAdmin());
    }

}
