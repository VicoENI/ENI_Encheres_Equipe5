package fr.eni.encheres.bo;

public class Categorie {

    // Attributs
    private int noCategorie;
    private String libelle;
 
    /**
     * Default constructor
     */
    public Categorie() {}

    /**
     * Constructor with parameters
     * @param libelle String
     */
    public Categorie(String libelle) {
        setLibelle(libelle);
    }
    
    // Getters et setters
    /**
     * Get the number of the category
     * @return noCategorie int
     */
    public int getNoCategorie() {
        return noCategorie;
    }
    
    /**
     * Get the label of the category
     * @return libelle String
     */
    public String getLibelle() {
        return libelle;
    }
    
    /**
     * Set the label of the category
     * @param libelle String
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    // Méthodes utilitaires
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categories [noCategorie=");
        sb.append(noCategorie);
        sb.append(", libelle=");
        sb.append(libelle);
        sb.append("]");
        return sb.toString();
    }
    
}
