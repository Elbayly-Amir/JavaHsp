package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.*;
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

    private int id_user;

    public AjoutDossier(int id_user) {
        this.id_user = id_user;
    }


    @FXML
    void ajoutDossier(ActionEvent event) throws SQLException {

        User user = new User(id_user);
        FichePatient fiche = new FichePatient();

        int idFichePatient = fiche.getIdFichePatient(liste.getText());
        System.out.println("Nom de la fiche patient : " + liste.getText());
        System.out.println("ID de la fiche patient correspondante : " + idFichePatient);

        String choixGravite = gravité.getText();
        Dossier doss = new Dossier(descriptionDossier.getText(), choixGravite, idFichePatient);

        doss.ajoutDossierPatient(idFichePatient);
        SuivieDossier svd = new SuivieDossier();
        svd.AjoutSuivieDossier(id_user, idFichePatient);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de l'hospitalisation");
        alert.setHeaderText(null);
        alert.setContentText("L'hospitalisation a été ajoutée avec succès !");
        alert.showAndWait();
    }

    @FXML
    void retourDossier(ActionEvent event) throws SQLException {

        HelloApplication.changeScene("espaceSecretaire", new EspaceSecretaire());
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
