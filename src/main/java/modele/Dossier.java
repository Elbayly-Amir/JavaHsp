package modele;

import BDD.BDD;
import javafx.util.StringConverter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Dossier {

    private int id_dossier;

    private Date dateDossier;
    private String description;
    private String nivGravite;
    private int ref_fichepatient;



    public Dossier(String text, String text1, int ref_fichepatient) {
        this.description=text;
        this.nivGravite=text1;
        this.ref_fichepatient= ref_fichepatient;
    }



    public Dossier() {

    }

    public Dossier(int id_dossier, java.sql.Date dateDossier, String description, String nivGravite, int ref_fichepatient) {
        this.id_dossier = id_dossier;
        this.dateDossier = dateDossier;
        this.description = description;
        this.nivGravite = nivGravite;
        this.ref_fichepatient = ref_fichepatient;
    }

    public Dossier(String text, String text1) {
        this.description = text;
        this.nivGravite =text1;
    }

    public Dossier(java.sql.Date dateDossier, String description, String nivGravite, int ref_fichepatient) {
        this.dateDossier = dateDossier;
        this.description = description;
        this.nivGravite = nivGravite;
        this.ref_fichepatient = ref_fichepatient;
    }


    public void ajoutDossierPatient(int idFichePatient)  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO dossier (description,nivGravite,ref_fichepatient) VALUES (?,?,?)");

        maRequete.setString(1, description);
        maRequete.setString(2, nivGravite);
        maRequete.setInt(3, ref_fichepatient);
        int mesResultats = maRequete.executeUpdate();
    }

    public void deleteDossierPatient(Dossier doss) throws SQLException {
        if(doss.getId_dossier() > 0 ) {
            BDD mabdd = new BDD();
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM dossier where id_dossier =?");
            maRequete.setInt(1, id_dossier);
            maRequete.executeUpdate();
        }
    }

    public void updateDossierPatient() throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE dossier SET `description`=?,`nivGravite`=?,`ref_fichepatient`=? WHERE id_dossier=?");
        maRequete.setString(1, description);
        maRequete.setString(2, nivGravite);
        maRequete.setInt(3, ref_fichepatient);
        maRequete.setInt(4, id_dossier);
        maRequete.executeUpdate();
    }


    public Dossier(int id_dossier, String description, String nivGravite, int ref_fichepatient) {
        this.id_dossier = id_dossier;
        this.description = description;
        this.nivGravite = nivGravite;
        this.ref_fichepatient = ref_fichepatient;
    }

    public ArrayList<Dossier> getDossier() throws SQLException {
        ArrayList<Dossier> dossiers = new ArrayList<Dossier>();
        Dossier d;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from dossier ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                d = new Dossier( mesResultats.getDate("dateDossier"), mesResultats.getString("description"),mesResultats.getString("nivGravite"), mesResultats.getInt("ref_fichepatient"));
                dossiers.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dossiers;
    }


    public ArrayList<Dossier> getDossiers() throws SQLException {
        ArrayList<Dossier> dossiers = new ArrayList<Dossier>();
        Dossier d;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from dossier ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                d = new Dossier( mesResultats.getInt("id_dossier"), mesResultats.getDate("dateDossier"), mesResultats.getString("description"),mesResultats.getString("nivGravite"), mesResultats.getInt("ref_fichepatient"));
                dossiers.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dossiers;
    }


    public static Dossier getDossierById(int id_dossier) throws SQLException {
        Dossier dossier = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("SELECT * FROM dossier WHERE id_dossier = ?");

        try {
            maRequete.setInt(1, id_dossier);
            ResultSet mesResultats = maRequete.executeQuery();
            if (mesResultats.next()) {
                dossier = new Dossier(mesResultats.getInt("id_dossier"), mesResultats.getDate("dateDossier"), mesResultats.getString("description"), mesResultats.getString("nivGravite"), mesResultats.getInt("ref_fichepatient"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dossier;
    }



    public int getId_dossier() {
        return id_dossier;
    }

    public void setId_dossier(int id_dossier) {
        this.id_dossier = id_dossier;
    }


    public Date getDateDossier() {
        return dateDossier;
    }

    public void setDateDossier(Date dateDossier) {
        this.dateDossier = dateDossier;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNivGravite() {
        return nivGravite;
    }

    public void setNivGravite(String nivGravite) {
        this.nivGravite = nivGravite;
    }

    public int getRef_fichepatient() {
        return ref_fichepatient;
    }

    public void setRef_fichepatient(int ref_fichepatient) {
        this.ref_fichepatient = ref_fichepatient;
    }
}
