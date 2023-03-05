package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modele.User;

import java.sql.SQLException;

public class AjoutUser {

    @FXML
    private SplitMenuButton choix;

    @FXML
    private TextField emailUser;

    @FXML
    private MenuItem gestionnaire;

    @FXML
    private PasswordField mdpUser;

    @FXML
    private MenuItem medecin;

    @FXML
    private TextField nomUser;

    @FXML
    private TextField prenomUser;

    @FXML
    private MenuItem secretaire;


    @FXML
    private void initialize() {
        // Ajouter des gestionnaires d'événements aux éléments du menu
        gestionnaire.setOnAction(e -> choix.setText("Gestionnaire"));
        secretaire.setOnAction(e -> choix.setText("Secrétaire"));
        medecin.setOnAction(e -> choix.setText("Médecin"));
    }
    @FXML
    void ajoutUser(ActionEvent event) throws SQLException {
        // Récupération des valeurs des champs de l'interface utilisateur
        String nom = nomUser.getText();
        String prenom = prenomUser.getText();
        String email = emailUser.getText();
        String mdp = mdpUser.getText();

        String role = switch ((choix.getText())) {
            case "Gestionnaire" -> "gestionnaire";
            case "Médecin" -> "medecin";
            case "Secrétaire" -> "secretaire";
            default -> "";
        };

        // Création d'un nouvel utilisateur
        User nouveauUser = new User(nom, prenom, email, mdp, role);

        nouveauUser.ajoutUser();

        // Affichage d'un message de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout d'utilisateur");
        alert.setHeaderText(null);
        alert.setContentText("L'utilisateur a été ajouté avec succès !");
        alert.showAndWait();

        // Réinitialisation des champs de l'interface utilisateur
        nomUser.setText("");
        prenomUser.setText("");
        emailUser.setText("");
        mdpUser.setText("");
        choix.setText("Choisir le rôle");
    }



    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceAdmin");
    }

}
