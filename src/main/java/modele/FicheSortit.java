package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FicheSortit {

    private int id_fichesorti;
    private String raisonDemande;
    private String nomProduit;
    private int quantiteProduit;
    private int ref_produit;



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
