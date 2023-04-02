package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Chambre;
import modele.Dossier;
import modele.Hospitalisation;

import java.sql.SQLException;

public class UpdateHospitalisation {

    @FXML
    private SplitMenuButton modifChambre;

    @FXML
    private TextField mofifMaladie;

    public Hospitalisation hosp;
    public int selectHospitalisationId;

    public UpdateHospitalisation( int hospitalisationId) throws SQLException {
        hosp = Hospitalisation.getHospitalisationById(hospitalisationId);
        this.selectHospitalisationId = hospitalisationId;
    }

    @FXML
    void modifHosp(ActionEvent event) throws SQLException {
        Chambre chambre = new Chambre();
        int idChambre = chambre.getIdChambre(modifChambre.getText());

        hosp.setDescriptionMaladie(mofifMaladie.getText());
        hosp.setRef_chambre(idChambre);

        hosp.updateHospitalisation();

        chambre.updateOccupation("Occupe", idChambre);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifications effectuées !");
        alert.setHeaderText(null);
        alert.setContentText("L'hospitalisation a été modifié avec succès !");
        alert.showAndWait();

    }


    @FXML
    void initialize() throws SQLException {



        Chambre ch = new Chambre();
        for (Chambre nomChambre : ch.selectNomChambre()) {
            MenuItem item = new MenuItem(nomChambre.getNomChambre());
            item.setOnAction(event -> modifChambre.setText(item.getText()));
            modifChambre.getItems().add(item);
        }
    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceMedecin",new EspaceMedecin());
    }

}
