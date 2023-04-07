/**
This class represents a Retrait object, which contains information about a withdrawal for an auction.
*/
package fr.eni.encheres.bo;

public class Retrait {
    
    private int id;
    private String rue;
    private String codePostal;
    private String ville;
    private Article article;
    /**
    * Default constructor for Retrait objects.
    */
    // Constructeur par défaut
    public Retrait() {}
    
    /**
    * Parameterized constructor for Retrait objects.
    * @param id int
    * @param rue String
    * @param codePostal String
    * @param ville String
    * @param article Article
    */
    // Constructeur avec paramètres
    public Retrait(String rue, String codePostal, String ville, Article article) {
        setRue(rue);
        setCodePostal(codePostal);
        setVille(ville);
        setArticle(article);
    }

    // Getters et setters

    /**
     * Get the article of the Retrait object.
     * @return article Article
     */
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
    public int getId() {
        return id;
    }

    /**
    * Setter method for the id attribute.
    * @param id The new id of the Retrait object.
    */
    public void setId(int id) {
        this.id = id;
    }
    
   
   

    /**
    * Getter method for the rue attribute.
    * @return The street name of the address where the item was withdrawn.
    */
    public String getRue() {
        return rue;
    }
     
    /**
    * Setter method for the rue attribute.
    * @param rue The new street name of the address where the item was withdrawn.
    */
    public void setRue(String rue) {
        this.rue = rue;
    }
    
    /**
    * Getter method for the CodePostal attribute.
    * @return The  name of the address where the item was withdrawn.
    */
    public String getCodePostal() {
        return codePostal;
    }
    
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    
    public String getVille() {
        return ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [getNoArticle()=");
		builder.append(getArticle());
		builder.append(", getArticle()=");
		builder.append(getArticle());
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getRue()=");
		builder.append(getRue());
		builder.append(", getCodePostal()=");
		builder.append(getCodePostal());
		builder.append(", getVille()=");
		builder.append(getVille());
		builder.append("]");
		return builder.toString();
	}
    
}
