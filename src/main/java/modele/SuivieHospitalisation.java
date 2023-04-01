package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuivieHospitalisation {

    private int ref_user;
    private int ref_hospitalisation;



    public void AjoutSuivieHospitalisation(int id_user,int id_hospitalisation)  throws SQLException {
        BDD mabdd = new BDD();
        User user = new User();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO suiviehospitalisation (ref_user,ref_hospitalisation) VALUES (?,?)");
        maRequete.setInt(1, id_user);
        maRequete.setInt(2, id_hospitalisation);
        int mesResultats = maRequete.executeUpdate();
    }



    public int getRef_user() {
        return ref_user;
    }

    public void setRef_user(int ref_user) {
        this.ref_user = ref_user;
    }

    public int getRef_hospitalisation() {
        return ref_hospitalisation;
    }

    public void setRef_hospitalisation(int ref_hospitalisation) {
        this.ref_hospitalisation = ref_hospitalisation;
    }
}
