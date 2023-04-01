package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import modele.Produit;
import modele.SuivieProduit;
import modele.User;

import java.sql.SQLException;



public class AjoutProduit {


    @FXML
    private TextField DescriptionProduit;

    @FXML
    private TextField LibelleProduit;

    @FXML
    private MenuItem faible;

    @FXML
    private MenuItem grave;

    @FXML
    private SplitMenuButton nivDanger;

    @FXML
    private MenuItem moyen;

    private int id_user;

    public AjoutProduit(int id_user) {
        this.id_user= id_user;
    }

    public AjoutProduit() {

    }

    @FXML
    void AjoutProduit(ActionEvent event) throws SQLException {
        User user = new User(id_user);
        Produit ajout = new Produit(DescriptionProduit.getText(), LibelleProduit.getText(), nivDanger.getText());
        SuivieProduit sp = new SuivieProduit();
        int id_produit = ajout.AjoutProduit(id_user);
        sp.AjoutSuivieProduit(id_user,id_produit);
        System.out.println("Produit ajouté !");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout du produit");
        alert.setHeaderText(null);
        alert.setContentText("Le produit a été ajoutée avec succès !");
        alert.showAndWait();
    }



    @FXML
    void initialize() throws SQLException {
        faible.setOnAction(e -> nivDanger.setText("faible"));
        moyen.setOnAction(e -> nivDanger.setText("moyen"));
        grave.setOnAction(e -> nivDanger.setText("grave"));

        }

    @FXML
    void retourProduit(ActionEvent event) {
        HelloApplication.changeScene("espaceGestionnaire",new EspaceGestionnaire());
    }

}
