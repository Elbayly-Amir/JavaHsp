package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modele.FicheSortit;

public class EspaceGestionnaire {



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

    }

