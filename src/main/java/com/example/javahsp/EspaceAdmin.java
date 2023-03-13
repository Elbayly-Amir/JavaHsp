package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.User;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
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

    @FXML
    private Button suppBtn;

    @FXML
    private MenuItem suppGest;

    @FXML
    private MenuItem suppMed;

    @FXML
    private MenuItem suppSecre;

    @FXML
    private MenuButton suppUser;
    @FXML
    private Button mdfButton;

    private User user;

    private User userSelected;

    public EspaceAdmin() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"ID", "id_user"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},

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
        HelloApplication.changeScene("ajoutUser");
    }

    @FXML
    void retourAdmin(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez été déconnecté.");
        alert.showAndWait();
        HelloApplication.changeScene("connexionUser");
    }

    @FXML
    void modifier(ActionEvent event) {
        HelloApplication.changeScene("");
    }

    @FXML
    void suppGest(ActionEvent event) {
        User user = tableViewGestionnaire.getSelectionModel().getSelectedItem();
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    user.deleteUser(user);
                    tableViewGestionnaire.getItems().remove(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un gestionnaire à supprimer.");
            alert.showAndWait();
        }

    }


    @FXML
    void suppMed(ActionEvent event) {
        User user = tableViewMedecin.getSelectionModel().getSelectedItem();
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    user.deleteUser(user);
                    tableViewMedecin.getItems().remove(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un médecin à supprimer.");
            alert.showAndWait();
        }

    }


    @FXML
    void suppSecre(ActionEvent event) {
        User user = tableViewSecretaire.getSelectionModel().getSelectedItem();
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    user.deleteUser(user);
                    tableViewSecretaire.getItems().remove(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner une secrétaire à supprimer.");
            alert.showAndWait();
        }

    }
}