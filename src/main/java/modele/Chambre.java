package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Chambre {

    private int id_chambre;
    private String occupation;


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
