package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Chambre;
import modele.Hospitalisation;
import modele.SuivieHospitalisation;
import modele.User;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutHospitalisation {

    @FXML
    private TextField maladie;

    @FXML
    private SplitMenuButton liste;

    private int id_user;

    public AjoutHospitalisation(int id_user) {
        this.id_user = id_user;
    }

    @FXML
    void ajoutHospitalisation(ActionEvent event) throws SQLException {
        User user = new User(id_user);
        Chambre chambre = new Chambre();
        int idChambre = chambre.getIdChambre(liste.getText());
        System.out.println("Nom de la chambre sélectionnée : " + liste.getText());
        System.out.println("ID de la chambre correspondante : " + idChambre);
        Hospitalisation ajout = new Hospitalisation(maladie.getText(), idChambre);
        int id_hospitalisation =  ajout.ajoutHospitalisation(idChambre,id_user);

        // Mettre à jour l'occupation de la chambre en "Occupe"
        chambre.updateOccupation("Occupe", idChambre);
        SuivieHospitalisation sh = new SuivieHospitalisation();
        sh.AjoutSuivieHospitalisation(id_user,id_hospitalisation);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout de l'hospitalisation");
        alert.setHeaderText(null);
        alert.setContentText("L'hospitalisation a été ajoutée avec succès !");
        alert.showAndWait();
    }



    @FXML
    void retour(ActionEvent event)  {
      HelloApplication.changeScene("espaceMedecin",new EspaceMedecin());
    }

    @FXML
    void initialize() throws SQLException {
        Chambre ch = new Chambre();
        for (Chambre nomChambre : ch.selectNomChambre()) {
            MenuItem item = new MenuItem(nomChambre.getNomChambre());
            item.setOnAction(event -> liste.setText(item.getText()));
            liste.getItems().add(item);
        }
    }


}
