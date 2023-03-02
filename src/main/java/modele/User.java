package modele;

import BDD.BDD;
import com.example.javahsp.HelloApplication;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {

    private int id_user;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String role;

    private int code;// PAS DANS LA BDD !!!

    public User(int id_user, String nom, String prenom, String email, String mdp, String role) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    public User() {
    }

    public User(String text, String text1) {
        this.email=text;
        this.mdp=text1;
    }

    public User(String nom, String prenom, String email, String mdp, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp= mdp;
        this.role = role;
    }


    public void connexionUser() throws SQLException {
        BDD mabdd = new BDD();

        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("SELECT * FROM user WHERE email = ? AND mdp = md5(?)");
        maRequete.setString(1, email);
        maRequete.setString(2, mdp);

        ResultSet mesResultats = maRequete.executeQuery();

        if (mesResultats.next()) {
            String role = mesResultats.getString("role");

            switch (role) {
                case "medecin":
                    HelloApplication.changeScene("espaceMedecin");
                    System.out.println("Connexion réussie en tant que médecin.");
                    break;
                case "secretaire":
                    HelloApplication.changeScene("espaceSecretaire");
                    System.out.println("Connexion réussie en tant que secrétaire.");
                    break;
                case "gestionnaire":
                    HelloApplication.changeScene("espaceGestionnaire");
                    System.out.println("Connexion réussie en tant que gestionnaire.");
                    break;
                case "admin":
                    HelloApplication.changeScene("espaceAdmin");
                    System.out.println("Connexion réussie en tant qu'administrateur.");
                    break;
                case "superadmin":
                    HelloApplication.changeScene("espaceSuperAdmin");
                    System.out.println("Connexion réussie en tant que super-administrateur.");
                    break;
                default:
                    System.out.println("Rôle inconnu : " + role);
                    break;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de connexion");
            alert.setHeaderText(null);
            alert.setContentText("Adresse email ou mot de passe incorrect !");
            alert.showAndWait();
            System.out.println("Votre email et/ou mot de passe est incorrect.");
        }
    }


    public void ajoutUser() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("INSERT INTO user (nom, prenom, email, mdp, role) VALUES (?, ?, ?, md5(?), ?)");
        maRequete.setString(1, nom);
        maRequete.setString(2, prenom);
        maRequete.setString(3, email);
        maRequete.setString(4, mdp);
        maRequete.setString(5, role);

        try {
            int mesResultats = maRequete.executeUpdate();
            System.out.println("User ajouté avec succès!");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur: " + e.getMessage());
        }
    }


    public void deleteUser(User user) throws SQLException {
        if (user.getId_user() >0){
            BDD mabdd = new BDD();
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("DELETE FROM user where id_user=?");
            maRequete.setInt(1, id_user);
            maRequete.executeUpdate();
        }
    }

    public void updateUser(User user) throws SQLException{
        if (user.getId_user() >0) {
            BDD mabdd = new BDD();
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE user SET `nom`=?,`prenom`=?,`email`=?,`mdp`=?,`role`=? WHERE id_user=?");
            maRequete.setString(1, nom);
            maRequete.setString(2, prenom);
            maRequete.setString(3, email);
            maRequete.setString(4, role);
            maRequete.setInt(5, id_user);
            maRequete.executeUpdate();
        }
    }

    public void changePassword() throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE user SET `mdp`=? WHERE id_user=?");
        maRequete.setString(1, mdp);
        maRequete.setInt(2, id_user);
        maRequete.executeUpdate();
    }

    public ArrayList<User> getUsersSecretaire() throws SQLException {
        ArrayList<User> user = new ArrayList<User>();
        User u;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from user where role = 'secretaire'");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                u = new User(mesResultats.getInt("id_user"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"),mesResultats.getString("role"));
                user.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public ArrayList<User> getUsersGestionnaiere() throws SQLException {
        ArrayList<User> user = new ArrayList<User>();
        User u;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from user where role = 'gestionnaire'");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                u = new User(mesResultats.getInt("id_user"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"),mesResultats.getString("role"));
                user.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public ArrayList<User> getUsersMedecin() throws SQLException {
        ArrayList<User> user = new ArrayList<User>();
        User u;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from user where role = 'medecin'");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                u = new User(mesResultats.getInt("id_user"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"),mesResultats.getString("role"));
                user.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public ArrayList<User> getUsersAdmin() throws SQLException {
        ArrayList<User> user = new ArrayList<User>();
        User u;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from user where role = 'admin'");
        ResultSet mesResultats = maRequete.executeQuery();

        try {
            while (mesResultats.next()) {
                u = new User(mesResultats.getInt("id_user"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"),mesResultats.getString("role"));
                user.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getUserByMail(String email) throws SQLException {
        User user = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("Select * from user where email = ?");

        try {
            maRequete.setString(1, email);
            ResultSet mesResultats = maRequete.executeQuery();
            if (mesResultats.next()) {

                user = new User(mesResultats.getInt("id_user"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"),  mesResultats.getString("mdp"),  mesResultats.getString("role"));
            }
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}