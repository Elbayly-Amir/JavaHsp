package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Hospitalisation;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutHospitalisation {

    @FXML
    private TextField maladie;

    @FXML
    private TextField numChambre;

    @FXML
    void ajoutHospitalisation(ActionEvent event) throws SQLException {
        Hospitalisation ajout = new Hospitalisation(maladie.getText(), parseInt(numChambre.getText()));
        ajout.ajoutHospitalisation();
        System.out.println("Hospitalisation ajouté !");
        HelloApplication.changeScene("ajoutHospitalisation");
    }

    @FXML
    void retour(ActionEvent event)  {
      HelloApplication.changeScene("espaceMedecin");
    }


}
