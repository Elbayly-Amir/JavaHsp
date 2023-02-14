package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FichePatient {


    private int id_fichepatient;
    private String nom;
    private String prenom;
    private int securiteSocial;
    private String email;
    private String rue;
    private int cp;
    private String ville;


    public FichePatient() {
        this.nom= nom;
        this.prenom=prenom;
        this.securiteSocial=securiteSocial;
        this.rue=rue;
        this.cp=cp;
        this.ville=ville;
    }

    public void ajoutFichePatient()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO fichepatient (nom,prenom,securiteSocial,email,rue,cp,ville) VALUES (?,?,?,?,?,?,?)");
        maRequete.setString(1, nom);
        maRequete.setString(2, prenom);
        maRequete.setInt(3, securiteSocial);
        maRequete.setString(4, email);
        maRequete.setString(5, rue);
        maRequete.setInt(6, cp);
        maRequete.setString(7, ville);
        int mesResultats = maRequete.executeUpdate();
    }

    public ResultSet Selectpatient() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete =  mabdd.getBDD().prepareStatement("SELECT * FROM fichepatient");
        ResultSet don=maRequete.executeQuery();
        return don;
    }

    public FichePatient(String nom, String prenom, int securiteSocial, String email, String rue, int cp, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.securiteSocial = securiteSocial;
        this.email = email;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
    }

    public int getId_fichepatient() {
        return id_fichepatient;
    }

    public void setId_fichepatient(int id_fichepatient) {
        this.id_fichepatient = id_fichepatient;
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

    public int getSecuriteSocial() {
        return securiteSocial;
    }

    public void setSecuriteSocial(int securiteSocial) {
        this.securiteSocial = securiteSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
