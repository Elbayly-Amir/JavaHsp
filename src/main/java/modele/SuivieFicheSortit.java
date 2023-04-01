package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuivieFicheSortit {

    private int ref_user;
    private int ref_fichesortit;




    public void AjoutSuivieFicheSortit(int id_user,int id_fichesortit)  throws SQLException {
        BDD mabdd = new BDD();
        User user = new User();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO suiviefichesortit (ref_user,ref_fichesorti) VALUES (?,?)");
        maRequete.setInt(1, id_user);
        maRequete.setInt(2, id_fichesortit);
        int mesResultats = maRequete.executeUpdate();
    }


    public int getRef_user() {
        return ref_user;
    }

    public void setRef_user(int ref_user) {
        this.ref_user = ref_user;
    }

    public int getRef_fichesortit() {
        return ref_fichesortit;
    }

    public void setRef_fichesortit(int ref_fichesortit) {
        this.ref_fichesortit = ref_fichesortit;
    }
}
