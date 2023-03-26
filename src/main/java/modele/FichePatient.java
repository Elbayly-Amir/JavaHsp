package modele;

import BDD.BDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FichePatient {


    private int id_fichepatient;
    private String nom;
    private String prenom;
    private int securiteSocial;
    private String email;
    private String rue;
    private int cp;
    private String ville;


    public FichePatient(int id_fichepatient, String nom, String prenom, int securiteSocial, String email, String rue, int cp, String ville) {
        this.id_fichepatient = id_fichepatient;
        this.nom= nom;
        this.prenom=prenom;
        this.securiteSocial= securiteSocial;
        this.rue=rue;
        this.cp=cp;
        this.ville=ville;
    }



    public FichePatient(String nom) {
        this.nom = nom;
    }

    public FichePatient() {
    }


    public void ajoutFichePatient()  throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO fichepatient (nom,prenom,securiteSocial,email,rue,cp,ville) VALUES (?,?,?,?,?,?,?)");
        maRequete.setString(1, nom);
        maRequete.setString(2, prenom);
        maRequete.setInt(3, securiteSocial);
        maRequete.setString(4, email);
        maRequete.setString(5, rue);
        maRequete.setInt(6, cp);
        maRequete.setString(7, ville);
        int mesResultats = maRequete.executeUpdate();
    }

    public ResultSet Selectpatient() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete =  mabdd.getBDD().prepareStatement("SELECT * FROM fichepatient");
        ResultSet don=maRequete.executeQuery();
        return don;
    }

    public FichePatient(String nom, String prenom, int securiteSocial, String email, String rue, int cp, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.securiteSocial = securiteSocial;
        this.email = email;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
    }


    public void deleteFichePatient(FichePatient fiche) throws SQLException {
        if(fiche.getId_fichepatient() > 0) {
            BDD mabdd = new BDD();
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM fichepatient where id_fichepatient=?");
            maRequete.setInt(1, id_fichepatient);
            maRequete.executeUpdate();
        }
    }

    public void updateFichePatient(FichePatient fichePatient) throws SQLException{
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE fichepatient SET `nom`=?,`prenom`=?,`securiteSocial`=?,`email`=?,`rue`=?,`cp`=?,`ville`=? WHERE id_fichepatient=?");
        maRequete.setString(1, nom);
        maRequete.setString(2, prenom);
        maRequete.setInt(3, securiteSocial);
        maRequete.setString(4, email);
        maRequete.setString(5, rue);
        maRequete.setInt(6, cp);
        maRequete.setString(7, ville);
        maRequete.setInt(8, id_fichepatient);
        maRequete.executeUpdate();
    }

    public ArrayList<FichePatient> getFichePatient() throws SQLException {
        ArrayList<FichePatient> fichePatients = new ArrayList<FichePatient>();
        FichePatient f;
        try (BDD madd = new BDD();
             PreparedStatement maRequete = madd.getBDD().prepareStatement("SELECT * FROM fichepatient");
             ResultSet mesResultats = maRequete.executeQuery()) {
            while (mesResultats.next()) {
                f = new FichePatient(mesResultats.getInt("id_fichepatient"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getInt("securiteSocial"), mesResultats.getString("email"), mesResultats.getString("rue"), mesResultats.getInt("cp"), mesResultats.getString("ville"));
                fichePatients.add(f);
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }
        return fichePatients;
    }


    public ArrayList<FichePatient> selectNomFichePatient() throws SQLException {
        ArrayList<FichePatient> fiche = new ArrayList<FichePatient>();
        FichePatient f;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select nom from fichepatient ");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                f = new FichePatient(mesResultats.getString("nom"));
                fiche.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fiche;
    }

    public int getIdFichePatient(String nom) throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("SELECT id_fichepatient FROM fichepatient WHERE nom = ?");
        maRequete.setString(1, nom);
        ResultSet mesResultats = maRequete.executeQuery();
        if (mesResultats.next()) {
            return mesResultats.getInt("id_fichepatient");
        } else {
            return 0;
        }
    }


    public static FichePatient getFichePatientById(int id_fichepatient) throws SQLException {
        FichePatient fichePatient = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("SELECT * FROM fichepatient WHERE id_fichepatient = ?");

        try {
            maRequete.setInt(1, id_fichepatient);
            ResultSet mesResultats = maRequete.executeQuery();
            if (mesResultats.next()) {
                fichePatient = new FichePatient(mesResultats.getInt("id_fichepatient"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getInt("securiteSocial"), mesResultats.getString("email"), mesResultats.getString("rue"), mesResultats.getInt("cp"), mesResultats.getString("ville") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fichePatient;
    }



    public int getId_fichepatient() {
        return id_fichepatient;
    }

    public void setId_fichepatient(int id_fichepatient) {
        this.id_fichepatient = id_fichepatient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getSecuriteSocial() {
        return securiteSocial;
    }

    public void setSecuriteSocial(int securiteSocial) {
        this.securiteSocial = securiteSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


}
