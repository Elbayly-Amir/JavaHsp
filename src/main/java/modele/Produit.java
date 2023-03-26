package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Produit {



    private int id_produit;
    private String libelle;
    private String description;
    private String nivDanger;

    public Produit(int idProduit, String libelle, String description, String nivDanger) {
        this.id_produit = idProduit;
        this.libelle=libelle;
        this.description=description;
        this.nivDanger=nivDanger;
    }

    public Produit(String text, String text1, String text2) {
        this.libelle = text;
        this.description = text1;
        this.nivDanger = text2;
    }

    public void AjoutProduit()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO produit (libelle,description,nivDanger) VALUES (?,?,?)");
        maRequete.setString(1, libelle);
        maRequete.setString(2, description);
        maRequete.setString(3, nivDanger);
        int mesResultats = maRequete.executeUpdate();
    }

    public void updateProduit(Produit produit) throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE produit SET `libelle`=?,`description`=?,`nivDanger`=? WHERE id_produit=?");
        maRequete.setObject(1, libelle);
        maRequete.setString(2, description);
        maRequete.setString(3, nivDanger);
        maRequete.setInt(4, id_produit);
        maRequete.executeUpdate();
    }

    public ResultSet SelectProduit() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete =  mabdd.getBDD().prepareStatement("SELECT * FROM produit");
        ResultSet produit=maRequete.executeQuery();
        return produit;
    }

    public void deleteProduit(Produit produit) throws SQLException {
        if (produit.getId_produit()>0) {
            BDD mabdd = new BDD();
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM produit where id_produit=?");
            maRequete.setInt(1, id_produit);
            maRequete.executeUpdate();
        }
    }

    public Produit() {

    }

    public ArrayList<Produit> getProduit() throws SQLException {
        ArrayList<Produit> produit = new ArrayList<Produit>();
        Produit p;
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("SELECT * FROM produit");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                p = new Produit(mesResultats.getInt("id_produit"), mesResultats.getString("libelle"), mesResultats.getString("description"), mesResultats.getString("nivDanger"));
                produit.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }


    public static Produit getProduitById(int id_produit) throws SQLException {
        Produit produit = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("SELECT * FROM produit WHERE id_produit = ?");

        try {
            maRequete.setInt(1, id_produit);
            ResultSet mesResultats = maRequete.executeQuery();
            if (mesResultats.next()) {
                produit = new Produit(mesResultats.getInt("id_produit"), mesResultats.getString("libelle"), mesResultats.getString("description"), mesResultats.getString("nivDanger"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
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

    public String getNivDanger() {
        return nivDanger;
    }

    public void setNivDanger(String nivDanger) {
        this.nivDanger = nivDanger;
    }
}
