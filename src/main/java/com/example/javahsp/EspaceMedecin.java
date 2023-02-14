package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class EspaceMedecin {

    @FXML
    private MenuItem DossierPatient;

    @FXML
    private MenuBar MenuMedecin;

    public void DossierPatient(ActionEvent actionEvent) {
    }


    public void FichePatient(ActionEvent actionEvent) {
        System.out.println("Accès fiche patient ");
        HelloApplication.changeScene("FichePatient");
    }
}
