package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import modele.Admin;
import modele.Gestionnaire;
import modele.Medecin;
import modele.Secretaire;

public class EspaceSuperAdmin {

    @FXML
    private Tab tabAdmin;

    @FXML
    private Tab tabGestionnaire;

    @FXML
    private Tab tabMedecin;

    @FXML
    private Tab tabSecretaire;

    @FXML
    private TableView<Admin> viewAdmin;

    @FXML
    private TableView<Gestionnaire> viewGest;

    @FXML
    private TableView<Medecin> viewMedecin;

    @FXML
    private TableView<Secretaire> viewSecretaire;

    @FXML
    void ajoutAdmin(ActionEvent event) {
        HelloApplication.changeScene("ajoutAdmin");
    }

    @FXML
    void ajoutGestionnaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutGestionnaireSuperAdmin");
    }

    @FXML
    void ajoutMedecin(ActionEvent event) {
        HelloApplication.changeScene("ajoutMedecinSuperAdmin");
    }

    @FXML
    void ajoutSecretaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutSecretaireSuperAdmin");
    }

    @FXML
    void decoSuperAdmin(ActionEvent event) {
        HelloApplication.changeScene("Acceuil");
    }

}
