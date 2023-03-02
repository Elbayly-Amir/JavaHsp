package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Chambre;
import modele.Dossier;
import modele.FichePatient;
import modele.FicheSortit;
import modele.Hospitalisation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EspaceMedecin {

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
