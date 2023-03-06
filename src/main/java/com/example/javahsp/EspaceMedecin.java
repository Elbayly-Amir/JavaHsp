package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.*;
import modele.FichePatient;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.SQLException;


public class EspaceMedecin implements Initializable{

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

    @FXML
    void ajoutHospitalisation(ActionEvent event) {
        HelloApplication.changeScene("ajoutHospitalisation");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"ID", "id_hospitalisation"},
                {"Date Hospitalisation", "date_hospitalisation"},
                {"Description de la maladie", "descriptionMaladie"},
                {"Chambre", "Ref_chambre"},

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
                {"Occupation", "occupation"},

        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Chambre, String> myTble = new TableColumn<>(colonnes[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Chambre, String>(colonnes[i][1]));
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
                {"FichePatient", "refFichepatient"},

        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Dossier, String> myTble = new TableColumn<>(colonnes[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Dossier, String>(colonnes[i][1]));
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
    void ajoutOrdonnance(ActionEvent event) {

    }

    @FXML
    void decoMedecin(ActionEvent event) {
        HelloApplication.changeScene("Accueil");
    }

    @FXML
    void ajoutFicheSortit(ActionEvent event) {
        HelloApplication.changeScene("ajoutFicheSortit");
    }


}
