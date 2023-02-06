package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Gestionnaire;
import modele.Medecin;
import modele.Secretaire;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EspaceAdmin implements Initializable {


    @FXML
    private TabPane admin;
    @FXML
    private Tab gestionnaire;

    @FXML
    private Tab medecin;

    @FXML
    private Tab secretaire;

    @FXML
    private TableView<Gestionnaire> tableViewGestionnaire;

    @FXML
    private TableView<Medecin> tableViewMedecin;

    @FXML
    private TableView<Secretaire> tableViewSecretaire;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"ID", "id_secretaire"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Secretaire, String> myTble = new TableColumn<>(colonnes[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Secretaire,String>(colonnes[i][1]));
            tableViewSecretaire.getColumns().add(myTble);
        }
        Secretaire s =  new Secretaire();
        try {
            tableViewSecretaire.getItems().addAll(s.getUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String[][] colonne = {
                {"ID", "id_gestionnaire"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Gestionnaire, String> firstNameColumn = new TableColumn<>(colonnes[i][0]);
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));

            tableViewGestionnaire.getColumns().add(firstNameColumn);
        }
        Gestionnaire g =  new Gestionnaire();
        try {
            tableViewGestionnaire.getItems().addAll(g.getUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String[][] colonn = {
                {"ID", "id_medecin"},
                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},
        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Medecin, String> firstNameColumn = new TableColumn<>(colonnes[i][0]);
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));

            tableViewMedecin.getColumns().add(firstNameColumn);
    }
        Medecin m =  new Medecin();
        try {
            tableViewMedecin.getItems().addAll(m.getUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
    @FXML
    void AjoutMedecin(ActionEvent event) {
        HelloApplication.changeScene("ajoutMedecin");
    }

    @FXML
    void AjoutSecretaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutSecretaire");
    }

    @FXML
    void Ajoutgestionnaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutGestionnaire");
    }

    @FXML
    void retourAdmin(ActionEvent event) {
        HelloApplication.changeScene("Accueil");
    }
}
