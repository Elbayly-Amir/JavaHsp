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
                Connection con;
                con = BDD.cnx();
                String sql = "SELECT * FROM fichepatient";
                PreparedStatement stat = con.prepareStatement(sql);;
                ResultSet rs = stat.executeQuery();
                while (rs.next()){
                    data.add(new FichePatient(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));

                }
                con.close();
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


