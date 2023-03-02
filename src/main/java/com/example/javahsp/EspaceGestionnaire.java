package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modele.FicheSortit;
import modele.Produit;
import modele.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EspaceGestionnaire implements Initializable {


        @FXML
        private Tab tabDemande;

        @FXML
        private Tab tabProduit;


        @FXML
        private TableView<FicheSortit> viewDemande;

        @FXML
        private TableView<Produit> viewProduit;

        @FXML
        void ajouterProduit(ActionEvent event) {
                HelloApplication.changeScene("ajoutProduit");
        }

        @FXML
        void deco(ActionEvent event) {
                HelloApplication.changeScene("Acceuil");
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                String[][] colonne = {
                        {"ID", "id_fichesorti"},
                        {"RaisonDemande", "raisonDemande"},
                        {"NomProduit", "nomProduit"},
                        {"QuantiteProduit", "QuantiteProduit"},
                };
                for (int i = 0; i < colonne.length; i++) {
                        TableColumn<FicheSortit, String> myTble = new TableColumn<>(colonne[i][0]);
                        myTble.setCellValueFactory(new PropertyValueFactory<FicheSortit, String>(colonne[i][1]));
                        viewDemande.getColumns().add(myTble);
                }
                // afficher les
                tabDemande.setOnSelectionChanged(event -> {
                        if (tabDemande.isSelected()) {
                                afficherFicheSortit();
                        }
                });

                String[][] colonnee = {
                        {"Id", "id_produit"},
                        {"Libelle", "libelle"},
                        {"Description", "description"},
                        {"NivDanger", "nivDanger"},
                };
                for (int i = 0; i < colonnee.length; i++) {
                        TableColumn<Produit, String> myTbles = new TableColumn<>(colonnee[i][0]);
                        myTbles.setCellValueFactory(new PropertyValueFactory<Produit, String>(colonnee[i][1]));
                        viewProduit.getColumns().add(myTbles);
                }
                // afficher les secrétaires lorsque l'onglet est sélectionné
                tabProduit.setOnSelectionChanged(event -> {
                        if (tabProduit.isSelected()) {
                                afficherProduit();
                        }
                });
        }


        private void afficherFicheSortit() {
                FicheSortit f = new FicheSortit();
                try {
                        viewDemande.getItems().addAll(f.getFicheSortit());
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        private void afficherProduit() {
                Produit p = new Produit();
                try {
                        viewProduit.getItems().addAll(p.getProduit());
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
}
