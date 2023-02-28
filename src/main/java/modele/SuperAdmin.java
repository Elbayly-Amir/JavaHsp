package modele;

import BDD.BDD;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuperAdmin {

    private String email;
    private String mdp;
    private int id_superAdmin;
    boolean estConnecte;

    public SuperAdmin(String email, String mdp, int id_superAdmin) {
        this.email = email;
        this.mdp = mdp;
        this.id_superAdmin = id_superAdmin;
    }

    public SuperAdmin(SuperAdmin a) {
    }

    public SuperAdmin(String text, String text1) {
    }

    public SuperAdmin connexion() throws SQLException {
        SuperAdmin a = null;
       
        while(!estConnecte){

            BDD mabdd = new BDD();
            
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("Select * from superAdmin where email=? and mdp=?");
            maRequete.setString(1,email);
            maRequete.setString(2,mdp);
            ResultSet mesResultats = maRequete.executeQuery();

            TextField email = null;
            TextField mdp = null;
            if (mesResultats.next()){
                a = new SuperAdmin(a);
                a.setId_superAdmin(1);
                a.setEmail(mesResultats.getString("email"));

                estConnecte = true;
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setContentText("Careful with the next step!");
                System.out.println("erreur");
            }
        }
        return a;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getId_superAdmin() {
        return id_superAdmin;
    }

    public void setId_superAdmin(int id_superAdmin) {
        this.id_superAdmin = id_superAdmin;
    }
    
}
