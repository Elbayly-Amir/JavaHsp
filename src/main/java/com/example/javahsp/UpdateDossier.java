package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Dossier;
import modele.FichePatient;
import modele.User;

import java.sql.SQLException;

public class UpdateDossier {

    @FXML
    private TextField description;

    @FXML
    private MenuItem faible;

    @FXML
    private MenuItem grave;

    @FXML
    private MenuItem moyen;

    @FXML
    private SplitMenuButton nivGravite;

    @FXML
    private SplitMenuButton patient;

    public Dossier dossier;
    public int selectDossierId;

    public UpdateDossier( int dossierId) throws SQLException {
       dossier = Dossier.getDossierById(dossierId);
        this.selectDossierId = dossierId;
    }

    @FXML
    void modifierDossier(ActionEvent event) throws SQLException {
        FichePatient fiche = new FichePatient();
        int idFichePatient = fiche.getIdFichePatient(patient.getText());

        String choixGravite = nivGravite.getText();


        dossier.setDescription(description.getText());
        dossier.setNivGravite(choixGravite);
        dossier.setRef_fichepatient(idFichePatient);

        dossier.updateDossierPatient();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifications effectuées !");
        alert.setHeaderText(null);
        alert.setContentText("Le dossier a été modifié avec succès !");
        alert.showAndWait();

    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceSecretaire",new EspaceSecretaire());
    }

    @FXML
    void initialize() throws SQLException {

        Dossier dossier = Dossier.getDossierById(selectDossierId);
        description.setText(dossier.getDescription());
        nivGravite.setText(dossier.getNivGravite());
        patient.setText(String.valueOf(dossier.getRef_fichepatient()));

        faible.setOnAction(e -> nivGravite.setText("faible"));
        moyen.setOnAction(e -> nivGravite.setText("moyen"));
        grave.setOnAction(e -> nivGravite.setText("grave"));

        modele.FichePatient fichePatient = new modele.FichePatient();
        for (FichePatient nom : fichePatient.selectNomFichePatient()) {
            MenuItem item = new MenuItem(nom.getNom());
            item.setOnAction(event -> patient.setText(item.getText()));
            patient.getItems().add(item);
        }
    }
}
