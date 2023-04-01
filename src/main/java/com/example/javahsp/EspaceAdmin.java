package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Chambre;
import modele.User;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class EspaceAdmin implements Initializable {


    @FXML
    private MenuButton ajout;

    @FXML
    private Tab gestionnaire;

    @FXML
    private Tab medecin;

    @FXML
    private Tab secretaire;

    @FXML
    private Tab adminPan;

    @FXML
    private Tab chambreP;

    @FXML
    private TableView<User> tableViewGestionnaire;

    @FXML
    private TableView<User> tableViewMedecin;

    @FXML
    private TableView<User> tableViewSecretaire;

    @FXML
    private TableView<User> viewAdmin;

    @FXML
    private TableView<Chambre> chambrView;

    @FXML
    private Button suppBtn;

    @FXML
    private MenuItem suppGest;

    @FXML
    private MenuItem suppMed;

    @FXML
    private MenuItem suppSecre;

    @FXML
    private MenuItem suppAdmin;

    @FXML
    private MenuButton suppUser;
    @FXML
    private Button mdfButton;

    private User user;

    private User userSelected;

    public static int selectedUserId;

    public EspaceAdmin(int selectedUserId){
        EspaceAdmin.selectedUserId = selectedUserId;
    }

    public EspaceAdmin() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {

                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},

        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colonnes[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colonnes[i][1]));
            tableViewSecretaire.getColumns().add(myTble);
        }

        // afficher les secrétaires lorsque l'onglet est sélectionné
        secretaire.setOnSelectionChanged(event -> {
            if (secretaire.isSelected()) {
                afficherSecretaires();
            }
        });

        String[][] colonne = {

                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},

        };
        for (int i = 0; i < colonne.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colonne[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colonne[i][1]));
            tableViewGestionnaire.getColumns().add(myTble);
        }


        gestionnaire.setOnSelectionChanged(event -> {
            if (gestionnaire.isSelected()) {
                afficherGestionnaire();
            }
        });

        String[][] colonn = {

                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},

        };
        for (int i = 0; i < colonn.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colonn[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colonn[i][1]));
            tableViewMedecin.getColumns().add(myTble);
        }


        medecin.setOnSelectionChanged(event -> {
            if (medecin.isSelected()) {
                afficherMedecin();
            }
        });
        String[][] colon = {

                {"Nom", "nom"},
                {"Prenom", "prenom"},
                {"Email", "email"},

        };
        for (int i = 0; i < colon.length; i++) {
            TableColumn<User, String> myTble = new TableColumn<>(colon[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<User, String>(colon[i][1]));
            viewAdmin.getColumns().add(myTble);
        }


        adminPan.setOnSelectionChanged(event -> {
            if (adminPan.isSelected()) {
                afficherAdmin();
            }
        });

        String[][] colo = {

                {"Nom de la chambre", "nomChambre"},
                {"Occupation", "occupation"},

        };
        for (int i = 0; i < colo.length; i++) {
            TableColumn<Chambre, String> myTble = new TableColumn<>(colo[i][0]);
            myTble.setCellValueFactory(new PropertyValueFactory<Chambre, String>(colo[i][1]));
            chambrView.getColumns().add(myTble);
        }


        chambreP.setOnSelectionChanged(event -> {
            if (chambreP.isSelected()) {
                afficherChambre();
            }
        });
    }

    private void afficherMedecin() {
        User m = new User();
        try {
            tableViewMedecin.getItems().clear();
            tableViewMedecin.getItems().addAll(m.getUsersMedecin());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void afficherGestionnaire() {
        User g =  new User();
        try {
            tableViewGestionnaire.getItems().clear();
            tableViewGestionnaire.getItems().addAll(g.getUsersGestionnaiere());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherSecretaires() {
        User s = new User();
        try {
            tableViewSecretaire.getItems().clear();
            tableViewSecretaire.getItems().addAll(s.getUsersSecretaire());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherAdmin() {
        User a =  new User();
        try {
            viewAdmin.getItems().clear();
            viewAdmin.getItems().addAll(a.getUsersAdmin());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherChambre(){
        Chambre c = new Chambre();
        try {
            chambrView.getItems().clear();
            chambrView.getItems().addAll(c.getChambree());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ajoutChambre(ActionEvent event) {
       HelloApplication.changeScene("ajoutChambre");
    }

    @FXML
    void ajoutUser(ActionEvent event) {
        HelloApplication.changeScene("ajoutUser");
    }

    @FXML
    void modifChambre(ActionEvent event) {
        Chambre chambre = chambrView.getSelectionModel().getSelectedItem();
        if (chambre != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de modification");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir modifier l'occupation de cette chambre ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    chambre.updateChambre(chambre);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner une chambre à mofifier.");
            alert.showAndWait();
        }
    }


    @FXML
    void modifUser(ActionEvent event) throws SQLException {
// récupérer l'utilisateur sélectionné
        User user = null;
        TableView<User> tableView = null;
        if (secretaire.isSelected()) {
            tableView = tableViewSecretaire;
        } else if (gestionnaire.isSelected()) {
            tableView = tableViewGestionnaire;
        } else if (medecin.isSelected()) {
            tableView = tableViewMedecin;
        }else if (adminPan.isSelected()){
            tableView = viewAdmin;
        }
        if (tableView != null) {
            user = tableView.getSelectionModel().getSelectedItem();
        }

        // Vérifier si un utilisateur a été sélectionné
        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sélectionner un utilisateur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un utilisateur à modifier.");
            alert.showAndWait();
            return;
        } else {
            // Récupérer l'ID de l'utilisateur sélectionné
            int userId = user.getId_user();

            // Passer l'ID de l'utilisateur sélectionné à votre formulaire de modification
            UpdateUser updateUser = new UpdateUser(userId);
            HelloApplication.changeScene("updateUser", new UpdateUser(userId));
        }
    }





    @FXML
    void suppGest(ActionEvent event) {
        User user = tableViewGestionnaire.getSelectionModel().getSelectedItem();
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    user.deleteUser(user);
                    tableViewGestionnaire.getItems().remove(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un gestionnaire à supprimer.");
            alert.showAndWait();
        }

    }


    @FXML
    void suppMed(ActionEvent event) {
        User user = tableViewMedecin.getSelectionModel().getSelectedItem();
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    user.deleteUser(user);
                    tableViewMedecin.getItems().remove(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un médecin à supprimer.");
            alert.showAndWait();
        }

    }


    @FXML
    void suppSecre(ActionEvent event) {
        User user = tableViewSecretaire.getSelectionModel().getSelectedItem();
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    user.deleteUser(user);
                    tableViewSecretaire.getItems().remove(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner une secrétaire à supprimer.");
            alert.showAndWait();
        }

    }


    @FXML
    void suppAdmin(ActionEvent event) {
        User user = viewAdmin.getSelectionModel().getSelectedItem();
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    user.deleteUser(user);
                    viewAdmin.getItems().remove(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un admin à supprimer.");
            alert.showAndWait();
        }
    }

    @FXML
    void retourAdmin(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Déconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez été déconnecté.");
        alert.showAndWait();
        HelloApplication.changeScene("connexionUser");
    }
}