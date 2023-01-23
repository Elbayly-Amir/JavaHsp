package com.example.javahsp;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class gestionnaire_stock {


        @FXML
        private Menu deconnexion;

        @FXML
        private TableColumn<?, ?> etat;

        @FXML
        private Menu ficheproduit;

        @FXML
        private Menu fournisseurs;

        @FXML
        private MenuBar menu;

        @FXML
        private Pane pane;

        @FXML
        private TableColumn<?, ?> produit;

        @FXML
        private TableColumn<?, ?> quantite;

        @FXML
        private TableColumn<?, ?> stock;

        @FXML
        private TableView<?> tableview;

        @FXML
        private Text text;

    }

