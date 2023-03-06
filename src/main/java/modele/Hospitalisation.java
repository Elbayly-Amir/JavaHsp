package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Hospitalisation {

    private int id_hospitalisation;
    private Date date_hospitalisation;
    private String descriptionMaladie;
    private int ref_chambre;

    public Hospitalisation(String text, int parseInt) {
        this.descriptionMaladie=text;
        this.ref_chambre =parseInt;
    }

    public Hospitalisation(int id_hospitalisation, Date date_hospitalisation, String descriptionMaladie, int ref_chambre) {
        this.id_hospitalisation = id_hospitalisation;
        this.date_hospitalisation = date_hospitalisation;
        this.descriptionMaladie = descriptionMaladie;
        this.ref_chambre = ref_chambre;

    }

    public Hospitalisation() {

    }


    public void ajoutHospitalisation()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO hospitalisation (descriptionMaladie,ref_chambre) VALUES (?,?)");

        maRequete.setString(1, descriptionMaladie);
        maRequete.setInt(2, ref_chambre);
        int mesResultats = maRequete.executeUpdate();
    }

    public void deleteHospitalisation() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM hospitalisation where id_hospitalisation=?");
        maRequete.setInt(1, id_hospitalisation);
        maRequete.executeUpdate();

    }

    public void updateHospitalisation() throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE hospitalisation SET `date_hospitalisation`=?,`descriptionMaladie`=?,`ref_chambre`=? WHERE id_hospitalisation=?");
        maRequete.setObject(1, date_hospitalisation);
        maRequete.setString(2, descriptionMaladie);
        maRequete.setInt(3, ref_chambre);
        maRequete.setInt(4, id_hospitalisation);
        maRequete.executeUpdate();
    }

    public ArrayList<Hospitalisation> getHospitalisation() throws SQLException {
        ArrayList<Hospitalisation> hospitalisations = new ArrayList<Hospitalisation>();
        Hospitalisation h;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from hospitalisation ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                h = new Hospitalisation(mesResultats.getInt("id_hospitalisation"), mesResultats.getDate("date_hospitalisation"), mesResultats.getString("descriptionMaladie"), mesResultats.getInt("ref_chambre"));
                hospitalisations.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospitalisations;
    }


    public int getId_hospitalisation() {
        return id_hospitalisation;
    }

    public void setId_hospitalisation(int id_hospitalisation) {
        this.id_hospitalisation = id_hospitalisation;
    }

    public Date getDate_hospitalisation() {
        return date_hospitalisation;
    }

    public void setDate_hospitalisation(Date date_hospitalisation) {
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
