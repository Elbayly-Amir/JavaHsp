package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

public class EspaceSecretaire {

    @FXML
    private Tab dossier;

    @FXML
    private TableView<?> dossierPatient;

    @FXML
    private TableView<?> fichePatient;

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
        HelloApplication.changeScene("Accueil");
    }
}
