package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CrudGestionnaire {

    @FXML
    void ajoutGestionnaire(ActionEvent event) {
        HelloApplication.changeScene("ajoutGestionnaire");
    }

    @FXML
    void retourCrudgestionnaire(ActionEvent event) {
        HelloApplication.changeScene("espaceAdmin");
    }

    @FXML
    void visuGestionnaire(ActionEvent event) {

    }
}
