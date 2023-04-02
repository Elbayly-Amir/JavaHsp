package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modele.User;
import java.util.regex.Pattern;

import java.sql.SQLException;

public class AjoutUser {

    private static final String SPECIAL_CHARS = "!@#$%^&*()_-+=[]{}|\\:;\"'<>,.?/";

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
    private MenuItem admin;


    @FXML
    private void initialize() {
        // Ajouter des gestionnaires d'événements aux éléments du menu
        gestionnaire.setOnAction(e -> choix.setText("Gestionnaire"));
        secretaire.setOnAction(e -> choix.setText("Secrétaire"));
        medecin.setOnAction(e -> choix.setText("Médecin"));
        admin.setOnAction(e -> choix.setText("Admin"));
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
            case "Admin" -> "admin";
            default -> "";
        };

        // Création d'un nouvel utilisateur
        User nouveauUser = new User(nom, prenom, email, mdp, role);


        if (mdpUser.getText().length() >= 12 &&
                Pattern.compile("[A-Z]").matcher(mdpUser.getText()).find() &&
                Pattern.compile("[a-z]").matcher(mdpUser.getText()).find() &&
                Pattern.compile("\\d").matcher(mdpUser.getText()).find() &&
                Pattern.compile("[" + Pattern.quote(SPECIAL_CHARS) + "]").matcher(mdpUser.getText()).find()) {
            nouveauUser.ajoutUser();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mot de passe non conforme !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez indérer un mot de passe contenant au moins une majuscule, une minuscule, un chiffre et un caractère spécial parmi " + SPECIAL_CHARS);
            alert.showAndWait();
        }


        // Réinitialisation des champs de l'interface utilisateur
        nomUser.setText("");
        prenomUser.setText("");
        emailUser.setText("");
        mdpUser.setText("");
        choix.setText("Choisir le rôle");
    }



    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceAdmin", new EspaceAdmin());
    }

}
