package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Dossier;
import modele.FichePatient;
import modele.FicheSortit;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EspaceSecretaire implements Initializable {

    @FXML
    private Tab dossier;

    @FXML
    private TableView<Dossier> dossierPatient;

    @FXML
    private TableView<FichePatient> fichePatient;

    @FXML
    private Tab patient;

    @FXML
    void ajoutDossierPatient(ActionEvent event) {
        HelloApplication.changeScene("ajoutDossier");
    }

    @FXML
    void ajoutFichePatient(ActionEvent event) {
        HelloApplication.changeScene("ajoutFichePatient");
    }

    @FXML
    void decoSec(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez été déconnecté.");
        alert.showAndWait();
        HelloApplication.changeScene("connexionUser");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonne = {
                {"ID", "id_fichepatient"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"SecuriteSociale", "securiteSociale"},
                {"Email", "email"},
                {"Rue", "rue"},
                {"Cp", "cp"},
                {"Ville", "ville"},
        };

        for (int i = 0; i < colonne.length; i++) {
            TableColumn<FichePatient, String> myTble = new TableColumn<>(colonne[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<FichePatient, String>(colonne[i][1]));
            fichePatient.getColumns().add(myTble);
        }
        // afficher les secrétaires lorsque l'onglet est sélectionné
        dossier.setOnSelectionChanged(event -> {
            if (dossier.isSelected()) {
                afficherFichePatient();
            }
        });
    }


    private void afficherFichePatient() {
        FichePatient f = new FichePatient();
        try {
            fichePatient.getItems().addAll(f.getFichePatient());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
