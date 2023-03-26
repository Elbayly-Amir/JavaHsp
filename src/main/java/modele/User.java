package modele;

import BDD.BDD;
import com.example.javahsp.EspaceAdmin;
import com.example.javahsp.EspaceMedecin;
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

    public User(String text, String text1, String text2) {
        this.nom = text;
        this.prenom = text1;
        this.email = text2;
    }

    public User(int id_user, String nom, String prenom, String email) {
        this.id_user=id_user;
        this.nom = nom;
        this.prenom=prenom;
        this.email= email;
    }


    public void connexionUser() throws SQLException {
        BDD mabdd = new BDD();

        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("SELECT * FROM user WHERE email = ? AND mdp = md5(?)");
        maRequete.setString(1, email);
        maRequete.setString(2, mdp);

        ResultSet mesResultats = maRequete.executeQuery();

        if (mesResultats.next()) {
            String roleUtilisateur = mesResultats.getString("role");
            String nomUtilisateur = mesResultats.getString("nom");
            String prenomUtilisateur = mesResultats.getString("prenom");

            PreparedStatement maRequeteInsert = mabdd.getBDD().prepareStatement("INSERT INTO infocouser ( nomUtilisateur, prenomUtilisateur, roleUtilisateur) VALUES (?, ?, ?)");
            maRequeteInsert.setString(1, nomUtilisateur);
            maRequeteInsert.setString(2, prenomUtilisateur);
            maRequeteInsert.setString(3, roleUtilisateur);
            maRequeteInsert.executeUpdate();


            switch (roleUtilisateur) {
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
                    HelloApplication.changeScene("espaceAdmin", new EspaceAdmin());
                    System.out.println("Connexion réussie en tant qu'administrateur.");
                    break;
                default:
                    System.out.println("Rôle inconnu : " + roleUtilisateur);
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
        PreparedStatement maRequeteVerification = mabdd.getBDD().prepareStatement("SELECT COUNT(*) FROM user WHERE email = ?");
        maRequeteVerification.setString(1, email);
        ResultSet resultat = maRequeteVerification.executeQuery();
        resultat.next();
        int count = resultat.getInt(1);

        if (count > 0) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'ajout");
            alert.setHeaderText(null);
            alert.setContentText("Email déjà existant dans la base de données!");
            alert.showAndWait();
            System.out.println("L'Email existe déjà dans la base de données.");

        }
        else {


        PreparedStatement maRequeteInsertion = mabdd.getBDD().prepareStatement("INSERT INTO user (nom, prenom, email, mdp, role) VALUES (?, ?, ?, md5(?), ?)");
        maRequeteInsertion.setString(1, nom);
        maRequeteInsertion.setString(2, prenom);
        maRequeteInsertion.setString(3, email);
        maRequeteInsertion.setString(4, mdp);
        maRequeteInsertion.setString(5, role);

        try {
            int mesResultats = maRequeteInsertion.executeUpdate();
            System.out.println("User ajouté avec succès!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout d'utilisateur");
            alert.setHeaderText(null);
            alert.setContentText("L'utilisateur a été ajouté avec succès !");
            alert.showAndWait();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur: " + e.getMessage());
        }
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
            PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE user SET `nom`=?,`prenom`=?,`email`=? WHERE id_user=?");
            maRequete.setString(1, user.getNom());
            maRequete.setString(2, user.getPrenom());
            maRequete.setString(3, user.getEmail());
            maRequete.setInt(4, user.getId_user());
            maRequete.executeUpdate();
        }
    }

    public void changePassword(User user) throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("UPDATE user SET `mdp`= md5(?) WHERE id_user=?");
        maRequete.setString(1, user.getMdp());
        maRequete.setInt(2, user.getId_user());
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


    public static User getUserById(int id_user) throws SQLException {
        User user = null;
        BDD madd = new BDD();
        PreparedStatement maRequete = madd.getBDD().prepareStatement("SELECT * FROM user WHERE id_user = ?");

        try {
            maRequete.setInt(1, id_user);
            ResultSet mesResultats = maRequete.executeQuery();
            if (mesResultats.next()) {
                user = new User(mesResultats.getInt("id_user"), mesResultats.getString("nom"), mesResultats.getString("prenom"), mesResultats.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    public int getUserIdByEmail(String email) throws SQLException {
        BDD mabdd = new BDD();
        PreparedStatement maRequete = mabdd.getBDD().prepareStatement("SELECT id_user FROM user WHERE email=?");
        maRequete.setString(1, email);
        ResultSet resultat = maRequete.executeQuery();
        if (resultat.next()) {
            return resultat.getInt("id_user");
        } else {
            return -1; // l'email n'est pas associé à un utilisateur existant
        }
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