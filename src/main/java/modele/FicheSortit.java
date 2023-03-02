package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FicheSortit {

    private int id_fichesorti;
    private String raisonDemande;
    private String nomProduit;
    private int quantiteProduit;
    private int ref_produit;

    public FicheSortit() {
        this.id_fichesorti = id_fichesorti;
        this.raisonDemande = raisonDemande;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.ref_produit = ref_produit;
    }
    public FicheSortit(String text, String text1, int parseInt) {

        this.raisonDemande=text;
        this.nomProduit=text1;
        this.quantiteProduit=parseInt;
    }

    public FicheSortit(int idFichesorti, String raisonDemande, String nomProduit, int quantiteProduit) {
        this.id_fichesorti = idFichesorti;
        this.raisonDemande = raisonDemande;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
    }


    public void ajoutFicheSortit()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO fichesorti (raisonDemande,nomProduit,quantiteProduit) VALUES (?,?,?)");

        maRequete.setString(1, raisonDemande);
        maRequete.setString(2, nomProduit);
        maRequete.setInt(3, quantiteProduit);
        int mesResultats = maRequete.executeUpdate();
    }

    public void deleteFicheSortit() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM fichesorti where id_fichesorti=?");
        maRequete.setInt(1, id_fichesorti);
        maRequete.executeUpdate();

    }

    public void updateFicheSortit() throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE fichesorti SET `raisonDemande`=?,`nomProduit`=?,`quantiteProduit`=?,`ref_produit`=? WHERE id_fichesorti=?");
        maRequete.setString(1, raisonDemande);
        maRequete.setString(2, nomProduit);
        maRequete.setInt(3, quantiteProduit);
        maRequete.setInt(4, ref_produit);
        maRequete.setInt(5, id_fichesorti);
        maRequete.executeUpdate();
    }
    public ArrayList<FicheSortit> getFicheSortit() throws SQLException {
        ArrayList<FicheSortit> fichesortit = new ArrayList<FicheSortit>();
        FicheSortit f;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("SELECT * FROM fichesorti");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                f = new FicheSortit(mesResultats.getInt("id_fichesorti"), mesResultats.getString("raisonDemande"), mesResultats.getString("nomProduit"), mesResultats.getInt("quantiteProduit"));
                fichesortit.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fichesortit;
    }


    public int getId_fichesorti() {
        return id_fichesorti;
    }

    public void setId_fichesorti(int id_fichesorti) {
        this.id_fichesorti = id_fichesorti;
    }

    public String getRaisonDemande() {
        return raisonDemande;
    }

    public void setRaisonDemande(String raisonDemande) {
        this.raisonDemande = raisonDemande;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public int getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(int ref_produit) {
        this.ref_produit = ref_produit;
    }
}
