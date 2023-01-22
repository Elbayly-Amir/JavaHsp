package modele;

public class Produit {

    private int id_produit;
    private String libelle;
    private String description;
    private String nivDanger;


    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNivDanger() {
        return nivDanger;
    }

    public void setNivDanger(String nivDanger) {
        this.nivDanger = nivDanger;
    }
}
