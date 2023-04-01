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
    private MenuButton modification;

    private int id_user;


    public EspaceSecretaire(int id_user) throws SQLException {
        this.id_user = id_user;
    }

    public EspaceSecretaire() {

    }


    @FXML
    void ajoutDossierPatient(ActionEvent event) {
        int id_user = this.id_user;
        HelloApplication.changeScene("ajoutDossier",new AjoutDossier(id_user));
    }

    @FXML
    void ajoutFichePatient(ActionEvent event) throws SQLException {
        int id_user = this.id_user;
        HelloApplication.changeScene("ajoutFichePatient", new AjoutFichePatient(id_user));
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
            fichePatient.getItems().clear();
            fichePatient.getItems().addAll(f.getFichePatient());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void afficherDossier() {
        Dossier d = new Dossier();
        try {
            dossierPatient.getItems().clear();
            dossierPatient.getItems().addAll(d.getDossiers());
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
    void modifDossier(ActionEvent event) throws SQLException {
// récupérer l'utilisateur sélectionné
        Dossier doss = null;
        TableView<Dossier> tableView = null;
        if (dossier.isSelected()) {
            tableView = dossierPatient;
        }
        if (tableView != null) {
            doss = tableView.getSelectionModel().getSelectedItem();
        }

        // Vérifier si un utilisateur a été sélectionné
        if (doss == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sélectionner un utilisateur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un utilisateur à modifier.");
            alert.showAndWait();
            return;
        } else {
            // Récupérer l'ID de l'utilisateur sélectionné
            int dossId = doss.getId_dossier();

            if (dossId > 0) {
                System.out.println(dossId);
                UpdateDossier updateDossier = new UpdateDossier(dossId);
                HelloApplication.changeScene("updateDossier", new UpdateDossier(dossId));
            }
        }
    }

    @FXML
    void modifPatient(ActionEvent event) throws SQLException {
// récupérer l'utilisateur sélectionné
        FichePatient fiche = null;
        TableView<FichePatient> tableView = null;
        if (patient.isSelected()) {
            tableView = fichePatient;
        }
        if (tableView != null) {
            fiche = tableView.getSelectionModel().getSelectedItem();
        }

        // Vérifier si un utilisateur a été sélectionné
        if (fiche == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sélectionner un utilisateur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un utilisateur à modifier.");
            alert.showAndWait();
            return;
        } else {
            // Récupérer l'ID de l'utilisateur sélectionné
            int fichePatientId = fiche.getId_fichepatient();

            // Passer l'ID de l'utilisateur sélectionné à votre formulaire de modification
            UpdateFichePatient updateFichePatient = new UpdateFichePatient(fichePatientId);
            HelloApplication.changeScene("updateFichePatient", new UpdateFichePatient(fichePatientId));
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
