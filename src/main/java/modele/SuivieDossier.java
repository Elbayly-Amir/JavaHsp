package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuivieDossier {

    private int ref_user;
    private int ref_dossier;

    public SuivieDossier() {

    }

    public void AjoutSuivieDossier(int id_user,int id_doss)  throws SQLException {
        BDD mabdd = new BDD();
        User user = new User();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO suiviedossierpatient (ref_user,ref_dossier) VALUES (?,?)");
        maRequete.setInt(1, id_user);
        maRequete.setInt(2, id_doss);

        int mesResultats = maRequete.executeUpdate();
    }


    public int getRef_user() {
        return ref_user;
    }

    public void setRef_user(int ref_user) {
        this.ref_user = ref_user;
    }

    public int getRef_dossier() {
        return ref_dossier;
    }

    public void setRef_dossier(int ref_dossier) {
        this.ref_dossier = ref_dossier;
    }
}
