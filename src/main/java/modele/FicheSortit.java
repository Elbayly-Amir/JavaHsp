package modele;

public class FicheSortit {

    private int id_fichesorti;
    private String raisonDemande;
    private String nomProduit;
    private int quantiteProduit;
    private int ref_produit;


    public int getId_fichesorti() {
        return id_fichesorti;
    }

    public void setId_fichesorti(int id_fichesorti) {
        this.id_fichesorti = id_fichesorti;
    }

    public String getRaisonDemande() {
        return raisonDemande;
    }

    public void setRaisonDemande(String raisonDemande) {
        this.raisonDemande = raisonDemande;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public int getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(int ref_produit) {
        this.ref_produit = ref_produit;
    }
}
