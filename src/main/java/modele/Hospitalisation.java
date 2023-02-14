package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hospitalisation {

    private int id_hospitalisation;
    private int date_hospitalisation;
    private String descriptionMaladie;
    private int ref_chambre;


    public void deleteHospitalisation() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM hospitalisation where id_hospitalisation=?");
        maRequete.setInt(1, id_hospitalisation);
        maRequete.executeUpdate();

    }

    public void updateHospitalisation() throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE hospitalisation SET `date_hospitalisation`=?,`descriptionMaladie`=?,`ref_chambre`=? WHERE id_hospitalisation=?");
        maRequete.setInt(1, date_hospitalisation);
        maRequete.setString(2, descriptionMaladie);
        maRequete.setInt(3, ref_chambre);
        maRequete.setInt(4, id_hospitalisation);
        maRequete.executeUpdate();
    }

    public int getId_hospitalisation() {
        return id_hospitalisation;
    }

    public void setId_hospitalisation(int id_hospitalisation) {
        this.id_hospitalisation = id_hospitalisation;
    }

    public int getDate_hospitalisation() {
        return date_hospitalisation;
    }

    public void setDate_hospitalisation(int date_hospitalisation) {
        this.date_hospitalisation = date_hospitalisation;
    }

    public String getDescriptionMaladie() {
        return descriptionMaladie;
    }

    public void setDescriptionMaladie(String descriptionMaladie) {
        this.descriptionMaladie = descriptionMaladie;
    }

    public int getRef_chambre() {
        return ref_chambre;
    }

    public void setRef_chambre(int ref_chambre) {
        this.ref_chambre = ref_chambre;
    }
}
