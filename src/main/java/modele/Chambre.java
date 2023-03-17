package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Chambre {

    private int id_chambre;
    private String nomChambre;
    private String occupation;

    public Chambre(int id_chambre, String nomChambre, String occupation) {
        this.id_chambre = id_chambre;
        this.nomChambre = nomChambre;
        this.occupation = occupation;
    }

    public Chambre(String nomChambre, String occupation) {
        this.nomChambre = nomChambre;
        this.occupation = occupation;
    }

    public Chambre() {

    }

    public Chambre(String nomChambre) {
        this.nomChambre = nomChambre;
    }

    public void ajoutChambre()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO chambre (nomChambre,occupation) VALUES (?,?)");

        maRequete.setString(1, nomChambre);
        maRequete.setString(2, occupation);
        int mesResultats = maRequete.executeUpdate();
    }

    public void deleteChambre() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM chambre where id_chambre =?");
        maRequete.setInt(1, id_chambre );
        maRequete.executeUpdate();
    }


    public void updateChambre() throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE chambre SET `occupation`=? WHERE id_chambre=?");
        maRequete.setString(1, occupation);
        maRequete.setInt(2, id_chambre);
        maRequete.executeUpdate();
    }

    public ArrayList<Chambre> getChambre() throws SQLException {
        ArrayList<Chambre> chambre = new ArrayList<Chambre>();
        Chambre c;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from chambre ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                c = new Chambre(mesResultats.getInt("id_chambre"), mesResultats.getString("nomChambre"), mesResultats.getString("occupation"));
                chambre.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chambre;
    }

    public ArrayList<Chambre> selectNomChambre() throws SQLException {
        ArrayList<Chambre> chambre = new ArrayList<Chambre>();
        Chambre c;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select nomChambre from chambre where occupation = 'Oui' ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                c = new Chambre(mesResultats.getString("nomChambre"));
                chambre.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chambre;
    }

    public int getIdChambre(String nomChambre) throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("SELECT id_chambre FROM chambre WHERE nomChambre = ?");
        maRequete.setString(1, nomChambre);
        ResultSet mesResultats = maRequete.executeQuery();
        if (mesResultats.next()) {
            return mesResultats.getInt("id_chambre");
        } else {
            return 0;
        }
    }


    public int getId_chambre(String text) {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNomChambre() {
        return nomChambre;
    }

    public void setNomChambre(String nomChambre) {
        this.nomChambre = nomChambre;
    }
}
