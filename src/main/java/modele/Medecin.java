package modele;

import BDD.BDD;
import javafx.scene.control.TextField;

import java.sql.*;

public class Medecin {


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

    public Medecin connexion() throws SQLException {
        Medecin m = null;
        while(!estConnecte){

            BDD mabdd = new BDD();
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("Select * from medecin where email=? and mdp=?");
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
    public void ajoutMedecin()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO medecin (email,mdp) VALUES (?,?)");
        maRequete.setString(1,email);
        maRequete.setString(2,mdp);
        int mesResultats = maRequete.executeUpdate();

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
