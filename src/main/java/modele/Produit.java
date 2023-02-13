package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produit {

    private int id_produit;
    private String libelle;
    private String description;
    private int nivDanger;


    public Produit(String text, String text1, int nivDanger) {
        this.libelle= text;
        this.description=text1;
        this.nivDanger=nivDanger;

    }


    public void AjoutProduit()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO produit (libelle,description,nivDanger) VALUES (?,?,?)");
        maRequete.setString(1, libelle);
        maRequete.setString(2, description);
        maRequete.setInt(3, nivDanger);
        int mesResultats = maRequete.executeUpdate();
    }

    public ResultSet SelectProduit() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete =  mabdd.getBDD().prepareStatement("SELECT * FROM produit");
        ResultSet produit=maRequete.executeQuery();
        return produit;
    }

    public Produit() {
        this.libelle= libelle;
        this.description=description;
        this.nivDanger=nivDanger;
    }



    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNivDanger() {
        return nivDanger;
    }

    public void setNivDanger(int nivDanger) {
        this.nivDanger = nivDanger;
    }
}
