package com.example.javahsp;

    import BDD.BDD;
    import javafx.beans.Observable;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
    import javafx.scene.control.cell.PropertyValueFactory;

    import java.net.URL;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ResourceBundle;



public class FichePatient implements Initializable {

    public FichePatient(){

    }

    @FXML
    private TableView<FichePatient>TableData;
        @FXML
        private TableColumn<FichePatient, String> NomPatient;

        @FXML
        private TableColumn<FichePatient, String> PrenomPatient;

        @FXML
        private TableColumn<FichePatient, String> SecuPatient;

        @FXML
        private TableColumn<FichePatient, String> MailPatient;

        @FXML
        private TableColumn<FichePatient, String> RuePatient;

        @FXML
        private TableColumn<FichePatient, String> CpPatient;

        @FXML
        public TableColumn<FichePatient, String> VillePatient;

        public ObservableList<FichePatient> data = FXCollections.observableArrayList();

    public FichePatient(String string1, String string2, String string3, String string4, String strin5, String string6, String string7) {
    }

    public void ViewPatient(){
            try {
                BDD mabdd = new BDD();
                Connection con;
                //con = BDD.();
                String sql = "SELECT * FROM fichepatient";
                PreparedStatement maRequete =  mabdd.getBDD().prepareStatement("SELECT * FROM fichepatient");
                ResultSet don=maRequete.executeQuery();
                while (don.next()){
                    data.add(new FichePatient(don.getString(1),don.getString(2),don.getString(3),don.getString(4),don.getString(5),don.getString(6),don.getString(7)));

                }
                don.close();
            } catch (Exception e){
                e.printStackTrace();

            }
            NomPatient.setCellValueFactory(new PropertyValueFactory<FichePatient, String>("NomPatient"));
        PrenomPatient.setCellValueFactory(new PropertyValueFactory<FichePatient, String>("PrenomPatient"));
        SecuPatient.setCellValueFactory(new PropertyValueFactory<FichePatient, String>("SecuPatient"));
        MailPatient.setCellValueFactory(new PropertyValueFactory<FichePatient, String>("MailPatient"));
        RuePatient.setCellValueFactory(new PropertyValueFactory<FichePatient, String>("RuePatient"));
        CpPatient.setCellValueFactory(new PropertyValueFactory<FichePatient, String>("CpPatient"));
        VillePatient.setCellValueFactory(new PropertyValueFactory<FichePatient, String>("VillePatient"));
        TableData.setItems(data);

        }

        public void setNomPatient(TableColumn<?, ?> nomPatient) {
            NomPatient = (TableColumn<FichePatient, String>) nomPatient;
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


