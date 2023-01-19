package modele;
import java.sql.SQLException;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class Secretaire {
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
public Secretaire(Secretaire s){


}
    public Secretaire connexion() throws SQLException {
        Secretaire s = null;
        while(!estConnecte){

            Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hspjava?serverTimezone=UTC","hspjava","FK@dAYuHV9AUx89J");

            PreparedStatement maRequete = maConnection.prepareStatement("Select * from secretaire where email=? and mdp=?");
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
