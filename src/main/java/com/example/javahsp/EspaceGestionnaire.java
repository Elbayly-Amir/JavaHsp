package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modele.FicheSortit;
import modele.Hospitalisation;
import modele.Produit;
import modele.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class EspaceGestionnaire implements Initializable {

        @FXML
        private MenuButton ajout;

        @FXML
        private MenuButton modif;
        @FXML
        private Tab tabDemande;
        @FXML
        private Tab tabProduit;
        @FXML
        private MenuButton supp;
        @FXML
        private TableView<FicheSortit> viewDemande;
        @FXML
        private TableView<Produit> viewProduit;

        private int id_user;

        public EspaceGestionnaire(int id_user) {

                this.id_user = id_user;
    }

        public EspaceGestionnaire() {

        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                String[][] colonne = {
                        {"RaisonDemande", "raisonDemande"},
                        {"NomProduit", "nomProduit"},
                        {"QuantiteProduit", "QuantiteProduit"},
                        {"Etat", "etat"},
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

        @FXML
        void modifProduit(ActionEvent event) throws SQLException {
                Produit produit = null;
                TableView<Produit> tableView = null;
                if (tabProduit.isSelected()) {
                        tableView = viewProduit;
                }
                if (tableView != null) {
                        produit = tableView.getSelectionModel().getSelectedItem();
                }

                // Vérifier si un utilisateur a été sélectionné
                if (produit == null) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sélectionner un produit");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez sélectionner un produit à modifier.");
                        alert.showAndWait();
                        return;
                } else {
                        // Récupérer l'ID de l'utilisateur sélectionné
                        int produitId = produit.getId_produit();

                        // Passer l'ID de l'utilisateur sélectionné à votre formulaire de modification
                        UpdateProduit updateProduit = new UpdateProduit(produitId);
                        HelloApplication.changeScene("updateProduit", new UpdateProduit(produitId));
                }
        }

        @FXML
        void validerFiche(ActionEvent event) {
            FicheSortit ficheSortit = viewDemande.getSelectionModel().getSelectedItem();
            if (ficheSortit != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de validation");
                alert.setHeaderText(null);
                alert.setContentText("Êtes-vous sûr de vouloir valider cette demande ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    try {
                        ficheSortit.updateFicheSortitValidation(ficheSortit);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Aucune sélection");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez sélectionner une demande à valider.");
                alert.showAndWait();
            }
        }

        @FXML
        void refusFiche(ActionEvent event) {
            FicheSortit ficheSorti = viewDemande.getSelectionModel().getSelectedItem();
            if (ficheSorti != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de refus");
                alert.setHeaderText(null);
                alert.setContentText("Êtes-vous sûr de vouloir refuser cette demande ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    try {
                        ficheSorti.updateFicheSortitRefus(ficheSorti);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Aucune sélection");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez sélectionner une demande à refuser.");
                alert.showAndWait();
            }
        }

        @FXML
        void suppression(ActionEvent event) {
                Produit produit = viewProduit.getSelectionModel().getSelectedItem();
                if (produit != null) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation de suppression");
                        alert.setHeaderText(null);
                        alert.setContentText("Êtes-vous sûr de vouloir supprimer ce produit ?");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.isPresent() && result.get() == ButtonType.OK) {
                                try {
                                        produit.deleteProduit(produit);
                                        viewProduit.getItems().remove(produit);
                                } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                }
                        }
                } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Aucune sélection");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez sélectionner un produit à supprimer.");
                        alert.showAndWait();
                }
        }

        @FXML
        void ajoutProduit(ActionEvent event) {
                int id_user = this.id_user;
                HelloApplication.changeScene("ajoutProduit", new AjoutProduit(id_user));
        }


        private void afficherFicheSortit() {
                FicheSortit f = new FicheSortit();
                try {
                        viewDemande.getItems().clear();
                        viewDemande.getItems().addAll(f.getFicheSortit());
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        private void afficherProduit() {
                Produit p = new Produit();
                try {
                        viewProduit.getItems().clear();
                        viewProduit.getItems().addAll(p.getProduit());
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }


        @FXML
        void deco(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Déconnexion");
                alert.setHeaderText(null);
                alert.setContentText("Vous avez été déconnecté.");
                alert.showAndWait();
                HelloApplication.changeScene("connexionUser");
        }


}
