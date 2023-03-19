package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Dossier;
import modele.FichePatient;
import modele.User;


import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class EspaceSecretaire implements Initializable {

    @FXML
    private MenuButton ajout;

    @FXML
    private MenuButton suppSecretaire;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonne = {
                {"ID", "id_fichepatient"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"SecuriteSocial", "securiteSocial"},
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

        patient.setOnSelectionChanged(event -> {
            if (patient.isSelected()) {
                afficherFichePatient();
            }
        });

        String[][] colonn = {
                {"ID", "id_dossier"},
                {"DateDossier", "dateDossier"},
                {"Description", "description"},
                {"NivGravite", "nivGravite"},
                {"RefFichePatient", "ref_fichepatient"},

        };

        for (int i = 0; i < colonn.length; i++) {
            TableColumn<Dossier, String> myTble = new TableColumn<>(colonn[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Dossier, String>(colonn[i][1]));
            dossierPatient.getColumns().add(myTble);
        }

        dossier.setOnSelectionChanged(event -> {
            if (dossier.isSelected()) {
                afficherDossier();
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

    private void afficherDossier() {
        Dossier d = new Dossier();
        try {
            dossierPatient.getItems().addAll(d.getDossier());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void suppDossier(ActionEvent event) {
        Dossier doss = dossierPatient.getSelectionModel().getSelectedItem();
        if (doss != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    doss.deleteDossierPatient(doss);
                    dossierPatient.getItems().remove(doss);
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
    void suppFichePatient(ActionEvent event) {
        FichePatient fiche = fichePatient.getSelectionModel().getSelectedItem();
        if (fiche != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    fiche.deleteFichePatient(fiche);
                    fichePatient.getItems().remove(fiche);
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
    void decoSec(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez été déconnecté.");
        alert.showAndWait();
        HelloApplication.changeScene("connexionUser");
    }
}
