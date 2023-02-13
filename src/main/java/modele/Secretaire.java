package modele;
import java.sql.SQLException;

import BDD.BDD;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

public class Secretaire  {
    private int id_secretaire;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    boolean estConnecte = false;

    public Secretaire(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public Secretaire(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    public Secretaire(Secretaire s){


}

    public Secretaire() {

    }

    public Secretaire(int id_user, String nom, String prenom, String mail, String mdp) {
    }

    public Secretaire connexion() throws SQLException {
        Secretaire s = null;
        while(!estConnecte){


            BDD mabdd = new BDD();

            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("Select * from secretaire where email=? and mdp=md5(?)");
            maRequete.setString(1,email);
            maRequete.setString(2,mdp);
            ResultSet mesResultats = maRequete.executeQuery();

            TextField email = null;
            TextField mdp = null;
            if (mesResultats.next()){
                s = new Secretaire(s);
                s.setId_secretaire(1);
                s.setEmail(mesResultats.getString("email"));

                estConnecte = true;
            }else{
                System.out.println("erreur");
            }
        }
        return s;
    }
    public void ajoutSecretaire()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO secretaire (nom,prenom,email,mdp) VALUES (?,?,?,md5(?))");
        maRequete.setString(1,nom);
        maRequete.setString(2,prenom);
        maRequete.setString(3,email);
        maRequete.setString(4,mdp);
        int mesResultats = maRequete.executeUpdate();

    }

    public ArrayList<Secretaire> getUsers() throws SQLException {
        ArrayList<Secretaire> sec = new ArrayList<Secretaire>();
        Secretaire s;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from secretaire where id_secretaire=?");
        maRequete.setInt(1,id_secretaire);
        ResultSet mesResultats = maRequete.executeQuery();

        try {

            while (mesResultats.next()) {
                s = new Secretaire( mesResultats.getInt("id_secretaire"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"));
                sec.add(s);
            }
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sec;
    }


    public int getId_secretaire() {
        return id_secretaire;
    }

    public void setId_secretaire(int id_secretaire) {
        this.id_secretaire = id_secretaire;
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
