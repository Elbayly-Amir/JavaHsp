package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuivieFichePatient {


    private int ref_user;
    private int ref_fichepatient;

    public SuivieFichePatient() {

    }

    public void AjoutSuivieFichePatient(int id_user,int id_fiche) throws SQLException {
        BDD mabdd = new BDD();
        User user = new User();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO suiviefichepatient (ref_user,ref_fichepatient) VALUES (?,?)");
        maRequete.setInt(1, id_user); // récupérer l'id de l'utilisateur à partir de l'instance de User
        maRequete.setInt(2, id_fiche);
        int mesResultats = maRequete.executeUpdate();
    }



    public int getRef_user() {
        return ref_user;
    }

    public void setRef_user(int ref_user) {
        this.ref_user = ref_user;
    }

    public int getRef_fichepatient() {
        return ref_fichepatient;
    }

    public void setRef_fichepatient(int ref_fichepatient) {
        this.ref_fichepatient = ref_fichepatient;
    }
}
