package modele;

public class Hospitalisation {

    private int id_hospitalisation;
    private int date_hospitalisation;
    private String descriptionMaladie;
    private int ref_chambre;


    public int getId_hospitalisation() {
        return id_hospitalisation;
    }

    public void setId_hospitalisation(int id_hospitalisation) {
        this.id_hospitalisation = id_hospitalisation;
    }

    public int getDate_hospitalisation() {
        return date_hospitalisation;
    }

    public void setDate_hospitalisation(int date_hospitalisation) {
        this.date_hospitalisation = date_hospitalisation;
    }

    public String getDescriptionMaladie() {
        return descriptionMaladie;
    }

    public void setDescriptionMaladie(String descriptionMaladie) {
        this.descriptionMaladie = descriptionMaladie;
    }

    public int getRef_chambre() {
        return ref_chambre;
    }

    public void setRef_chambre(int ref_chambre) {
        this.ref_chambre = ref_chambre;
    }
}
