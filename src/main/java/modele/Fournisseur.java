package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fournisseur {

    private int id_fournisseur;
    private String nom;

    public Fournisseur(String text) {

    }

    public void ajoutFournisseur()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO fournisseur (nom) VALUES (?)");
        maRequete.setString(1, nom);
        int mesResultats = maRequete.executeUpdate();
    }

    public ResultSet SelectFournisseur() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete =  mabdd.getBDD().prepareStatement("SELECT * FROM fournisseur");
        ResultSet fournit=maRequete.executeQuery();
        return fournit;
    }

    public void deleteGestionnaire() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM fournisseur where id_fournisseur=?");
        maRequete.setInt(1, id_fournisseur);
        maRequete.executeUpdate();

    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
