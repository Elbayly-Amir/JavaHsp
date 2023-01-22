package modele;

public class Dossier {

    private int id_dossier;
    private int dateDossier;
    private int heure;
    private String descriprion;
    private String nivGravite;
    private int ref_fichepatient;














    public int getId_dossier() {
        return id_dossier;
    }

    public void setId_dossier(int id_dossier) {
        this.id_dossier = id_dossier;
    }

    public int getDateDossier() {
        return dateDossier;
    }

    public void setDateDossier(int dateDossier) {
        this.dateDossier = dateDossier;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public String getNivGravite() {
        return nivGravite;
    }

    public void setNivGravite(String nivGravite) {
        this.nivGravite = nivGravite;
    }

    public int getRef_fichepatient() {
        return ref_fichepatient;
    }

    public void setRef_fichepatient(int ref_fichepatient) {
        this.ref_fichepatient = ref_fichepatient;
    }
}
