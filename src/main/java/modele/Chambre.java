package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Chambre {

    private int id_chambre;
    private String Occupation;


    public void deleteChambre() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM chambre where id_chambre =?");
        maRequete.setInt(1, id_chambre );
        maRequete.executeUpdate();

    }


    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }
}
