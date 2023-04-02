package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FicheSortit {

    private int id_fichesorti;
    private String raisonDemande;
    private String nomProduit;
    private int quantiteProduit;
    private String etat;

    public FicheSortit() {
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

    public FicheSortit(int idFichesorti, String raisonDemande, String nomProduit, int quantiteProduit, String etat) {

        this.id_fichesorti = idFichesorti;
        this.raisonDemande = raisonDemande;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;

        this.etat = etat;
    }

    public int ajoutFicheSortit(int id_user)  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO fichesorti (raisonDemande,nomProduit,quantiteProduit,etat) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

        maRequete.setString(1, raisonDemande);
        maRequete.setString(2, nomProduit);
        maRequete.setInt(3, quantiteProduit);
        maRequete.setString(4, "En cours");
        int mesResultats = maRequete.executeUpdate();

        ResultSet generatedKeys = maRequete.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id_fichesortit= generatedKeys.getInt(1);
            SuivieFichePatient sfp = new SuivieFichePatient();
            sfp.AjoutSuivieFichePatient(id_user, id_fichesortit);
            return id_fichesortit;
        } else {
            throw new SQLException("La création de la fiche patient a échoué, aucun ID généré.");
        }
    }

    public void deleteFicheSortit() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM fichesorti where id_fichesorti=?");
        maRequete.setInt(1, id_fichesorti);
        maRequete.executeUpdate();

    }

    public void updateFicheSortitValidation(FicheSortit ficheSortit) throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE fichesorti SET `etat`=? WHERE id_fichesorti=?");
        maRequete.setString(1, "Valider");
        maRequete.setInt(2, id_fichesorti);
        maRequete.executeUpdate();
    }

    public void updateFicheSortitRefus(FicheSortit ficheSorti) throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE fichesorti SET `etat`=? WHERE id_fichesorti=?");
        maRequete.setString(1, "Refuser");
        maRequete.setInt(2, id_fichesorti);
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
                f = new FicheSortit(mesResultats.getInt("id_fichesorti"), mesResultats.getString("raisonDemande"), mesResultats.getString("nomProduit"), mesResultats.getInt("quantiteProduit"),mesResultats.getString("etat"));
                fichesortit.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fichesortit;
    }

    public static FicheSortit getFicheSortitById(int id_fichesorti) throws SQLException {
        FicheSortit ficheSortit = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("SELECT * FROM fichesorti WHERE id_fichesorti = ?");

        try {
            maRequete.setInt(1, id_fichesorti);
            ResultSet mesResultats = maRequete.executeQuery();
            if (mesResultats.next()) {
                ficheSortit = new FicheSortit(mesResultats.getInt("id_fichesorti"), mesResultats.getString("raisonDemande"), mesResultats.getString("nomProduit"), mesResultats.getInt("quantiteProduit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ficheSortit;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
