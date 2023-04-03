package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modele.Dossier;
import modele.FichePatient;

import java.sql.SQLException;

public class UpdateFichePatient {

    @FXML
    private TextField cpPatient;

    @FXML
    private TextField emailPatient;

    @FXML
    private TextField nomPatient;

    @FXML
    private TextField prenomPatient;

    @FXML
    private TextField ruePatient;

    @FXML
    private TextField secuPatient;

    @FXML
    private TextField villePatient;

    public FichePatient fichePatient;
    public int selectFichePatientId;

    public UpdateFichePatient( int fichePatientId) throws SQLException {
        fichePatient = FichePatient.getFichePatientById(fichePatientId);
        this.selectFichePatientId = fichePatientId;
    }

    @FXML
    void modifierFichePatient(ActionEvent event) throws SQLException {
        String nom = nomPatient.getText();
        String prenom = prenomPatient.getText();
        int securiteSocial = Integer.parseInt(secuPatient.getText());
        String email = emailPatient.getText();
        String rue = ruePatient.getText();
        int cp = Integer.parseInt(cpPatient.getText());
        String ville = villePatient.getText();


        fichePatient.setNom(nom);
        fichePatient.setPrenom(prenom);
        fichePatient.setSecuriteSocial(securiteSocial);
        fichePatient.setEmail(email);
        fichePatient.setRue(rue);
        fichePatient.setCp(cp);
        fichePatient.setVille(ville);


        fichePatient.updateFichePatient(fichePatient);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifications effectuées !");
        alert.setHeaderText(null);
        alert.setContentText("L'utilisateur a été modifié avec succès !");
        alert.showAndWait();
    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceSecretaire", new EspaceSecretaire());
    }

}
