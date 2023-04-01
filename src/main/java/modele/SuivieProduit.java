package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuivieProduit {

    private int ref_user;
    private int ref_produit;



    public void AjoutSuivieProduit(int id_user,int id_produit)  throws SQLException {
        BDD mabdd = new BDD();
        User user = new User();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO suivieproduit (ref_user,ref_produit) VALUES (?,?)");
        maRequete.setInt(1, id_user);
        maRequete.setInt(2, id_produit);
        int mesResultats = maRequete.executeUpdate();
    }


    public int getRef_user() {
        return ref_user;
    }

    public void setRef_user(int ref_user) {
        this.ref_user = ref_user;
    }

    public int getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(int ref_produit) {
        this.ref_produit = ref_produit;
    }
}
