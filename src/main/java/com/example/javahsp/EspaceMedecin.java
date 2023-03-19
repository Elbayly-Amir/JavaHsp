package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.*;
import modele.FichePatient;
import javafx.fxml.Initializable;

import java.util.Optional;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.SQLException;


public class EspaceMedecin implements Initializable{


    @FXML
    private MenuButton ajouter;

    @FXML
    private MenuButton suppression;

    @FXML
    private Tab tabChambre;

    @FXML
    private Tab tabDossier;

    @FXML
    private Tab tabHospitalisation;

    @FXML
    private TableView<Chambre> viewChambre;

    @FXML
    private TableView<Dossier> viewDossier;

    @FXML
    private TableView<Hospitalisation> viewHospitalisation;

    public EspaceMedecin(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"ID", "id_hospitalisation"},
                {"Date Hospitalisation", "date_hospitalisation"},
                {"Description de la maladie", "descriptionMaladie"},
                {"Chambre", "ref_chambre"},

        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Hospitalisation, String> myTble = new TableColumn<>(colonnes[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Hospitalisation, String>(colonnes[i][1]));
            viewHospitalisation.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        tabHospitalisation.setOnSelectionChanged(event -> {
            if (tabHospitalisation.isSelected()) {
                afficherHospitalisation();
            }
        });

        String[][] colonne= {
                {"ID", "id_chambre"},
                {"Nom de la chambre", "nomChambre"},
                {"Occupation", "occupation"},

        };
        for (int i = 0; i < colonne.length; i++) {
            TableColumn<Chambre, String> myTble = new TableColumn<>(colonne[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Chambre, String>(colonne[i][1]));
            viewChambre.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        tabChambre.setOnSelectionChanged(event -> {
            if (tabChambre.isSelected()) {
                afficherChambre();
            }
        });

        String[][] colonn = {
                {"ID", "id_dossier"},
                {"Date Dossier", "dateDossier"},
                {"Description de la maladie", "description"},
                {"Gravité", "nivGravite"},
                {"FichePatient", "ref_fichepatient"},

        };
        for (int i = 0; i < colonn.length; i++) {
            TableColumn<Dossier, String> myTble = new TableColumn<>(colonn[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Dossier, String>(colonn[i][1]));
            viewDossier.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        tabDossier.setOnSelectionChanged(event -> {
            if (tabDossier.isSelected()) {
                afficherDossier();
            }
        });
    }
    private void afficherHospitalisation() {
        Hospitalisation h = new Hospitalisation();

        try {
            viewHospitalisation.getItems().addAll(h.getHospitalisation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherChambre() {
        Chambre c = new Chambre();

        try {
            viewChambre.getItems().addAll(c.getChambre());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherDossier() {
        Dossier d = new Dossier();

        try {
            viewDossier.getItems().addAll(d.getDossier());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ajoutFicheSortit(ActionEvent event) {
        HelloApplication.changeScene("ajoutFicheSortit");
    }

    @FXML
    void ajoutHospitalisation(ActionEvent event) {
        HelloApplication.changeScene("ajoutHospitalisation");
    }

    @FXML
    void suppressionHospitalisation(ActionEvent event) {
        Hospitalisation hosp = viewHospitalisation.getSelectionModel().getSelectedItem();
        if (hosp != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    hosp.deleteHospitalisation(hosp);
                    viewHospitalisation.getItems().remove(hosp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner une hospitalisation à supprimer.");
            alert.showAndWait();
        }
    }

    @FXML
    void decoMedecin(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez été déconnecté.");
        alert.showAndWait();
        HelloApplication.changeScene("connexionUser");
    }
}
