package modele;

import BDD.BDD;
import javafx.util.StringConverter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Dossier {

    private int id_dossier;

    private String descriprion;
    private String nivGravite;
    private int ref_fichepatient;



    public Dossier(String text, String text1, int ref_fichepatient) {
        this.descriprion=text;
        this.nivGravite=text1;
        this.ref_fichepatient= ref_fichepatient;
    }






    public void ajoutDossierPatient()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO dossier (description,nivGravite,ref_fichepatient) VALUES (?,?,?)");

        maRequete.setString(1, descriprion);
        maRequete.setString(2, nivGravite);
        maRequete.setInt(3, ref_fichepatient);
        int mesResultats = maRequete.executeUpdate();
    }



    public Dossier(int id_dossier, String descriprion, String nivGravite, int ref_fichepatient) {
        this.id_dossier = id_dossier;
        this.descriprion = descriprion;
        this.nivGravite = nivGravite;
        this.ref_fichepatient = ref_fichepatient;
    }

    public int getId_dossier() {
        return id_dossier;
    }

    public void setId_dossier(int id_dossier) {
        this.id_dossier = id_dossier;
    }





    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
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
