package modele;

import BDD.BDD;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;

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

    public Gestionnaire connexion() throws SQLException {
        Gestionnaire g = null;
        while (!estConnecte) {

            BDD madd = new BDD();

            PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from gestionnaire where email=? and mdp=?");
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
                System.out.println("erreur");
            }
        }
        return g;
    }

    public void ajoutGest()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO gestionnaire (email,mdp) VALUES (?,?)");
        maRequete.setString(1,email);
        maRequete.setString(2,mdp);
        int mesResultats = maRequete.executeUpdate();

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
