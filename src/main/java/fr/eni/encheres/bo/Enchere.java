package fr.eni.encheres.bo;

//import java.sql.Date;
import java.util.Date;

/**
 * Class representing the bid of an article
 * @author BaptistePoupet
 * @version 1.0
 */
public class Enchere {
    // Attributs
    private int         id;
    private Utilisateur utilisateur;
    private Article     articleVendu;
    private Date        dateEnchere;
    private int         montantEnchere;
    
    /**
     * Default constructor
     */
    public Enchere() {}
    
    /**
     * Constructor with parameters
     * @param articleVendu Article
     * @param utilisateur Utilisateur
     * @param dateEnchere Date
     * @param montantEnchere int
     */
    public Enchere(Utilisateur utilisateur, Article articleVendu, Date dateEnchere, int montantEnchere) {
        setUtilisateur(utilisateur);
        setArticleVendu(articleVendu);
        setDateEnchere(dateEnchere);
        setMontantEnchere(montantEnchere);
    }
   

	// Getters et setters
    /**
     * Get the user who made the bid
     * @return utilisateur Utilisateur
     */
    public Utilisateur getUtilisateur() {
		return utilisateur;
	}

    /**
     * Set the user who made the bid
     * @param utilisateur Utilisateur
     */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

    /**
     * Get the article on which the bid was made
     * @return articleVendu Article
     */
	public Article getArticleVendu() {
		return articleVendu;
	}

    /**
     * Set the article on which the bid was made
     * @param articleVendu Article
     */
	public void setArticleVendu(Article articleVendu) {
		this.articleVendu = articleVendu;
	}
	
    /**
     * Get the id of the bid
     * @return id int
     */
    public int getId() {
        return id;
    }
    
    /**
     * Get the id of the article on which the bid was made
     * @return article Article
     */
    public Article getArticle() {
        return articleVendu;
    }
    
    /**
     * Set the article on which the bid was made
     * @param articleVendu Article
     */
    public void setArticle(Article articleVendu) {
        this.articleVendu = articleVendu;
    }
    
    /**
     * Get the date of the bid
     * @return dateEnchere Date
     */
    public Date getDateEnchere() {
        return dateEnchere;
    }
    
    /**
     * Set the date of the bid
     * @param dateEnchere Date
     */
    public void setDateEnchere(Date dateEnchere) {
        this.dateEnchere = dateEnchere;
    }
    
    /**
     * Get the amount of the bid
     * @return montantEnchere int
     */
    public int getMontantEnchere() {
        return montantEnchere;
    }
    
    /**
     * Set the amount of the bid
     * @param montantEnchere int
     */
    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }
    
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [getUtilisateur()=");
		builder.append(getUtilisateur());
		builder.append(", getArticleVendu()=");
		builder.append(getArticleVendu());
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getIdArticle()=");
		builder.append(getArticle());
		builder.append(", getIdUtilisateur()=");
		builder.append(getUtilisateur());
		builder.append(", getDateEnchere()=");
		builder.append(getDateEnchere());
		builder.append(", getMontantEnchere()=");
		builder.append(getMontantEnchere());
		builder.append("]");
		return builder.toString();
	}
}
