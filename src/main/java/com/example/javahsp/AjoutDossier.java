package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Chambre;
import modele.Dossier;
import modele.FichePatient;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutDossier {




    @FXML
    private TextField descriptionDossier;

    @FXML
    private MenuItem faible;

    @FXML
    private MenuItem moyen;

    @FXML
    private MenuItem grave;

    @FXML
    private SplitMenuButton gravité;

    @FXML
    private SplitMenuButton liste;



    @FXML
    void ajoutDossier(ActionEvent event) throws SQLException {
        FichePatient fiche = new FichePatient();
        int idFichePatient = fiche.getIdFichePatient(liste.getText());
        System.out.println("Nom de la fiche patient : " + liste.getText());
        System.out.println("ID de la fiche patient correspondante : " + idFichePatient);

        String choixGravite = gravité.getText();
        Dossier doss = new Dossier(descriptionDossier.getText(), choixGravite, idFichePatient);

        doss.ajoutDossierPatient(idFichePatient);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de l'hospitalisation");
        alert.setHeaderText(null);
        alert.setContentText("L'hospitalisation a été ajoutée avec succès !");
        alert.showAndWait();
    }

    @FXML
    void retourDossier(ActionEvent event) {

        HelloApplication.changeScene("espaceSecretaire");
    }
    @FXML
    void initialize() throws SQLException {
        faible.setOnAction(e -> gravité.setText("faible"));
        moyen.setOnAction(e -> gravité.setText("moyen"));
        grave.setOnAction(e -> gravité.setText("grave"));

        FichePatient fichePatient = new FichePatient();
        for (FichePatient nom : fichePatient.selectNomFichePatient()) {
            MenuItem item = new MenuItem(nom.getNom());
            item.setOnAction(event -> liste.setText(item.getText()));
            liste.getItems().add(item);
        }
    }
}
