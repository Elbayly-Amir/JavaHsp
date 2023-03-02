package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EspaceSuperAdmin {

    @FXML
    private Tab tabAdmin;

    @FXML
    private Tab tabGestionnaire;

    @FXML
    private Tab tabMedecin;

    @FXML
    private Tab tabSecretaire;

    @FXML
    private TableView<User> viewAdmin;

    @FXML
    private TableView<User> viewGest;

    @FXML
    private TableView<User> viewMedecin;

    @FXML
    private TableView<User> viewSecretaire;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"ID", "id_secretaire"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
                {"Mdp", "mdp"},
        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colonnes[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colonnes[i][1]));
            viewSecretaire.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        tabSecretaire.setOnSelectionChanged(event -> {
            if (tabSecretaire.isSelected()) {
                afficherSecretaires();
            }
        });

        String[][] colonne = {
                {"ID", "id_user"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
                {"Mdp", "mdp"},
        };
        for (int i = 0; i < colonne.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colonne[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colonne[i][1]));
            viewGest.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        tabGestionnaire.setOnSelectionChanged(event -> {
            if (tabGestionnaire.isSelected()) {
                afficherGestionnaire();
            }
        });

        String[][] colonn = {
                {"ID", "id_user"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
                {"Mdp", "mdp"},
        };
        for (int i = 0; i < colonne.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colonne[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colonne[i][1]));
            viewMedecin.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        tabMedecin.setOnSelectionChanged(event -> {
            if (tabMedecin.isSelected()) {
                afficherMedecin();
            }
        });

        String[][] colone = {
                {"ID", "id_user"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
                {"Mdp", "mdp"},
        };
        for (int i = 0; i < colonne.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colonne[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colonne[i][1]));
            viewAdmin.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        tabAdmin.setOnSelectionChanged(event -> {
            if (tabAdmin.isSelected()) {
                afficherAdmin();
            }
        });
    }

    private void afficherAdmin() {
        User m = new User();
        try {
            viewAdmin.getItems().addAll(m.getUsersAdmin());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void afficherMedecin() {
        User m = new User();
        try {
            viewMedecin.getItems().addAll(m.getUsersMedecin());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void afficherGestionnaire() {
        User g =  new User();
        try {
            viewGest.getItems().addAll(g.getUsersGestionnaiere());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherSecretaires() {
        User s = new User();
        try {
            viewSecretaire.getItems().addAll(s.getUsersSecretaire());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ajoutUser(ActionEvent event) {

    }
    @FXML
    void decoSuperAdmin(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez été déconnecté.");
        alert.showAndWait();
        HelloApplication.changeScene("connexionUser");


    }

}
