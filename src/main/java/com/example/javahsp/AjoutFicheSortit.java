package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modele.FichePatient;
import modele.FicheSortit;
import modele.SuivieFicheSortit;
import modele.User;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AjoutFicheSortit {

    @FXML
    private TextField QteProduit;

    @FXML
    private TextField nomProduit;

    @FXML
    private TextField raisonDemande;

    private int id_user;

    public AjoutFicheSortit(int id_user) {
        this.id_user= id_user;
    }

    @FXML
    void ajoutFicheSortit(ActionEvent event) throws SQLException {
        User user = new User(id_user);
       FicheSortit ajout = new FicheSortit(raisonDemande.getText(),nomProduit.getText(), Integer.parseInt(QteProduit.getText()));
        SuivieFicheSortit sf = new SuivieFicheSortit();
       if(raisonDemande.getText().isEmpty() || nomProduit.getText().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Champ vide");
           alert.setHeaderText(null);
           alert.setContentText("Veuillez saisir des informations !!");
           alert.showAndWait();
       }else if(Integer.parseInt(QteProduit.getText()) <= 0){
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Champ vide");
           alert.setHeaderText(null);
           alert.setContentText("Veuillez une quantité valide !!");
           alert.showAndWait();
       }else{
            int id_fichesortit = ajout.ajoutFicheSortit(id_user);
            sf.AjoutSuivieFicheSortit(id_user, id_fichesortit);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout d'utilisateur");
            alert.setHeaderText(null);
            alert.setContentText("L'utilisateur a été ajouté avec succès !");
            alert.showAndWait();
        }
    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("espaceMedecin",new EspaceMedecin());
    }
}
