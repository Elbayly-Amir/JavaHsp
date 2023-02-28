package modele;

import BDD.BDD;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
public class Admin {

    private String email;
    private String mdp;
    private int id_admin;

    boolean estConnecte = false;

    public Admin(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public Admin (Admin a){
    }

    public Admin connexion() throws SQLException {
        Admin a = null;
        while(!estConnecte){

        BDD mabdd = new BDD();


            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("Select * from admin where email=? and mdp=?");
            maRequete.setString(1,email);
            maRequete.setString(2,mdp);
            ResultSet mesResultats = maRequete.executeQuery();

            TextField email = null;
            TextField mdp = null;
            if (mesResultats.next()){
                a = new Admin(a);
                a.setId_admin(1);
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

    public void ajoutAdmin()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO admin (email, mdp) VALUES (?,md5(?))");
        maRequete.setString(1,email);
        maRequete.setString(2,mdp);

        int mesResultats = maRequete.executeUpdate();

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

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
}
