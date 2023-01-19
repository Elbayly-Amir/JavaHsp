package modele;

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

    public Gestionnaire(Gestionnaire g){
    }

    public Gestionnaire connexion() throws SQLException {
        Gestionnaire g = null;
        while(!estConnecte){

            Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hspjava?serverTimezone=UTC","hspjava","FK@dAYuHV9AUx89J");

            PreparedStatement maRequete = maConnection.prepareStatement("Select * from gestionnaire where email=? and mdp=?");
            maRequete.setString(1,email);
            maRequete.setString(2,mdp);
            ResultSet mesResultats = maRequete.executeQuery();

            TextField email = null;
            TextField mdp = null;
            if (mesResultats.next()){
                g = new Gestionnaire(g);
                g.setId_gestionnaire(1);
                g.setEmail(mesResultats.getString("email"));

                estConnecte = true;
            }else{
                System.out.println("erreur");
            }
        }
        return g;
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
