package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EspaceSecretaire {


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
