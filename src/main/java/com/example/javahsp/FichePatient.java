package com.example.javahsp;

    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

    import java.net.URL;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ResourceBundle;

public class FichePatient implements Initializable {

        @FXML
        private TableColumn<?, ?> CpPatient;

        @FXML
        private TableColumn<?, ?> MailPatient;

        @FXML
        private TableColumn<?, ?> NomPatient;

        @FXML
        private TableColumn<?, ?> PrenomPatient;

        @FXML
        private TableColumn<?, ?> RuePatient;

        @FXML
        private TableColumn<?, ?> SecuPatient;

        @FXML
        private TableView<?> TableData;

        @FXML
        private TableColumn<?, ?> VillePatient;

        public void setNomPatient(TableColumn<?, ?> nomPatient) {
            NomPatient = nomPatient;
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        modele.FichePatient affiche = new modele.FichePatient();
        try {
            ResultSet stock = affiche.Selectpatient();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


