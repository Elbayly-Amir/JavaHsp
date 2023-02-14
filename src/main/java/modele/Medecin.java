package modele;

import BDD.BDD;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Medecin  {


    private int id_medecin;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    boolean estConnecte = false;


    public Medecin(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }
    public Medecin(Medecin m){


    }

    

    public Medecin() {

    }

    public Medecin(int id_medecin, String nom, String prenom, String email, String mdp) {
    }

    public Medecin connexion() throws SQLException {
        Medecin m = null;
        while(!estConnecte){

            BDD mabdd = new BDD();
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("Select * from medecin where email=? and mdp=md5(?)");
            maRequete.setString(1,email);
            maRequete.setString(2,mdp);
            ResultSet mesResultats = maRequete.executeQuery();

            TextField email = null;
            TextField mdp = null;
            if (mesResultats.next()){
                m = new Medecin(m);
                m.setId_medecin(1);
                m.setEmail(mesResultats.getString("email"));

                estConnecte = true;
            }else{
                System.out.println("erreur");
            }
        }
        return m;
    }

    public Medecin(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    public void ajoutMedecin()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO medecin (nom,prenom,email,mdp) VALUES (?,?,?,md5(?))");
        maRequete.setString(1,nom);
        maRequete.setString(2,prenom);
        maRequete.setString(3,email);
        maRequete.setString(4,mdp);
        int mesResultats = maRequete.executeUpdate();

    }
    public Medecin getUser() throws SQLException {
        Medecin med = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from medecin ");

        ResultSet mesResultats = maRequete.executeQuery();


        return med;
    }

    public void deleteMedecin() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM medecin where id_medecin=?");
        maRequete.setInt(1, id_medecin);
        maRequete.executeUpdate();

    }

    public void updateMedecin() throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE medecin SET `nom`=?,`prenom`=?,`email`=? WHERE id_medecin=?");
        maRequete.setString(1, nom);
        maRequete.setString(2, prenom);
        maRequete.setString(3, email);
        maRequete.setInt(4, id_medecin);
        maRequete.executeUpdate();
    }

    public void changePassword() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE medecin SET `mdp`=? WHERE id_medecin=?");
        maRequete.setString(1, mdp);
        maRequete.setInt(2, id_medecin);
        maRequete.executeUpdate();
    }

    public ArrayList<Medecin> getUsers() throws SQLException {
        ArrayList<Medecin> me = new ArrayList<Medecin>();
        Medecin m;
        BDD mabdd = new BDD();

        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("Select * from medecin ");
        ResultSet mesResultats = maRequete.executeQuery();
        while (mesResultats.next()) {
            m = new Medecin(mesResultats.getInt("id_medecin"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"));
            me.add(m);
        }

        System.out.println(me.size());
        return me;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
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