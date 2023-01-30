package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

public class EspaceAdmin {


    @FXML
    private TabPane admin;
    @FXML
    private Tab gestionnaire;

    @FXML
    private Tab medecin;

    @FXML
    private Tab secretaire;

    @FXML
    private TableView<?> tableViewGestionnaire;

    @FXML
    private TableView<?> tableViewMedecin;

    @FXML
    private TableView<?> tableViewSecretaire;

    @FXML
    void AjoutMedecin(ActionEvent event) {
        HelloApplication.changeScene("ajoutMedecin");
    }

    @FXML
    void AjoutSecretaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutSecretaire");
    }

    @FXML
    void Ajoutgestionnaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutGestionnaire");
    }

    @FXML
    void retourAdmin(ActionEvent event) {
        HelloApplication.changeScene("Accueil");
    }
}
