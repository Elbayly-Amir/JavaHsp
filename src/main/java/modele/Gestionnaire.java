package modele;

import BDD.BDD;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Gestionnaire {

    private int id_gestionnaire;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    boolean estConnecte = false;

    public Gestionnaire(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public Gestionnaire(Gestionnaire g) {
    }

    

    public Gestionnaire() {

    }

    public Gestionnaire(int id_gestionnaire, String nom, String prenom, String email, String mdp) {
    }

    public Gestionnaire connexion() throws SQLException {
        Gestionnaire g = null;
        while (!estConnecte) {

            BDD madd = new BDD();

            PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from gestionnaire where email=? and mdp=md5(?)");
            maRequete.setString(1, email);
            maRequete.setString(2, mdp);
            ResultSet mesResultats = maRequete.executeQuery();

            TextField email = null;
            TextField mdp = null;
            if (mesResultats.next()) {
                g = new Gestionnaire(g);
                g.setEmail(mesResultats.getString("email"));

                estConnecte = true;
            } else {
                System.out.println("erreur login ou mot de passe");
            }
        }
        return g;
    }

    public Gestionnaire(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    public void ajoutGest()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO gestionnaire (nom, prenom,email,mdp) VALUES (?,?,?,md5(?))");
        maRequete.setString(1,nom);
        maRequete.setString(2,prenom);
        maRequete.setString(3,email);
        maRequete.setString(4,mdp);
        int mesResultats = maRequete.executeUpdate();

    }

    public Gestionnaire getUser() throws SQLException {
        Gestionnaire gest = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from gestionnaire ");

        ResultSet mesResultats = maRequete.executeQuery();


        return gest;
    }

    public void deleteGestionnaire() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM gestionnaire where id_gestionnaire=?");
        maRequete.setInt(1, id_gestionnaire);
        maRequete.executeUpdate();

    }

    public void updateGestionnaire() throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE gestionnaire SET `nom`=?,`prenom`=?,`email`=? WHERE id_gestionnaire=?");
        maRequete.setString(1, nom);
        maRequete.setString(2, prenom);
        maRequete.setString(3, email);
        maRequete.setInt(4, id_gestionnaire);
        maRequete.executeUpdate();
    }

    public void changePassword() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE gestionnaire SET `mdp`=? WHERE id_gestionnaire=?");
        maRequete.setString(1, mdp);
        maRequete.setInt(2, id_gestionnaire);
        maRequete.executeUpdate();
    }

    public ArrayList<Gestionnaire> getUsers() throws SQLException {
        ArrayList<Gestionnaire> sec = new ArrayList<Gestionnaire>();
        Gestionnaire g;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from gestionnaire ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                g = new Gestionnaire(mesResultats.getInt("id_gestionnaire"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"));
                sec.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sec;
    }

    public int getId_gestionnaire() {
        return id_gestionnaire;
    }

    public void setId_gestionnaire(int id_gestionnaire) {
        this.id_gestionnaire = id_gestionnaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


}
