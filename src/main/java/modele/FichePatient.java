package modele;

public class FichePatient {


    private int id_fichepatient;
    private String nom;
    private String prenom;
    private int securiteSocial;
    private String email;
    private String rue;
    private int cp;
    private String ville;


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
