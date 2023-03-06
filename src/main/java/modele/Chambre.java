package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Chambre {

    private int id_chambre;
    private String occupation;

    public Chambre(int id_chambre, String occupation) {
        this.id_chambre= id_chambre;
        this.occupation=occupation;
    }

    public Chambre() {

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
        ArrayList<Chambre> dossiers = new ArrayList<Chambre>();
        Chambre c;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from chambre ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                c = new Chambre(mesResultats.getInt("id_chambre"), mesResultats.getString("occupation"));
                dossiers.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dossiers;
    }
    public int getId_chambre() {
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
}
