package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EspaceAdmin implements Initializable {



    @FXML
    private Tab gestionnaire;

    @FXML
    private Tab medecin;

    @FXML
    private Tab secretaire;

    @FXML
    private TableView<User> tableViewGestionnaire;

    @FXML
    private TableView<User> tableViewMedecin;

    @FXML
    private TableView<User> tableViewSecretaire;


    @Override
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
            tableViewSecretaire.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        secretaire.setOnSelectionChanged(event -> {
            if (secretaire.isSelected()) {
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
            tableViewGestionnaire.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        gestionnaire.setOnSelectionChanged(event -> {
            if (gestionnaire.isSelected()) {
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
            tableViewMedecin.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        medecin.setOnSelectionChanged(event -> {
            if (medecin.isSelected()) {
                afficherMedecin();
            }
        });
    }

    private void afficherMedecin() {
        User m = new User();
        try {
            tableViewMedecin.getItems().addAll(m.getUsersMedecin());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void afficherGestionnaire() {
        User g =  new User();
        try {
            tableViewGestionnaire.getItems().addAll(g.getUsersGestionnaiere());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherSecretaires() {
        User s = new User();
        try {
            tableViewSecretaire.getItems().addAll(s.getUsersSecretaire());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ajoutUser(ActionEvent event) {

    }

    @FXML
    void retourAdmin(ActionEvent event) {
        HelloApplication.changeScene("connexionUser");
    }
}
