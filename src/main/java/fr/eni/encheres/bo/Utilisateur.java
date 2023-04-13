package fr.eni.encheres.bo;

import java.util.Date;

public class Utilisateur {
    
    private int 	noUtilisateur;
    private String 	nom;
    private String 	prenom;
    private String 	email;
    private String 	motDePasse;
    private String 	pseudo;
    private String 	telephone;
    private String 	rue;
    private String 	codePostal;
    private String 	ville;
    private int 	credit;
    private boolean administrateur;
    
    /**
	 * Default constructor
	 */
    public Utilisateur() {}
    
    /**
	 * Constructor with all attributes
	 * @param nom String
	 * @param prenom String
	 * @param email String
	 * @param motDePasse String
	 * @param dateInscription Date
	 * @param pseudo String
	 * @param telephone String
	 * @param credit int
	 * @param administrateur boolean
	 * @param ville String
	 * @param rue String
	 * @param codePostal String
	 */
    public Utilisateur(String nom, String prenom, String email, String motDePasse, String pseudo, String telephone,int credit, boolean administrateur, String ville, String rue, String codePostal) {
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
        setMotDePasse(motDePasse);
        setPseudo(pseudo);
        setTelephone(telephone);
        setCredit(credit);
        setAdministrateur(administrateur);
        setRue(rue);
        setVille(ville);
        setCodePostal(codePostal);
    }
    
	// Getters et setters

	/**
	 * Get the number of the user
	 * @return noUtilisateur int
	 */
    public int getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * Get the phone number of the user
	 * @return telephone String
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Set the phone number of the user
	 * @param telephone String
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Get the street of the user
	 * @return rue String
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Set the street of the user
	 * @param rue String
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Get the postal code of the user
	 * @return codePostal String
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Set the postal code of the user
	 * @param codePostal String
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Get the city of the user
	 * @return ville String
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Set the city of the user
	 * @param ville String
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Get the credit of the user
	 * @return credit int
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * Set the credit of the user
	 * @param credit int
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * Get the admin status of the user
	 * @return administrateur boolean
	 */
	public boolean isAdministrateur() {
		return administrateur;
	}

	/**
	 * Set the admin status of the user
	 * @param administrateur boolean
	 */
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	/**
	 * Get the pseudo of the user
	 * @return pseudo String
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Set the pseudo of the user
	 * @param pseudo String
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Get the id of the user
	 * @return noUtilisateur int
	*/
    public int getId() {
        return noUtilisateur;
    }
    
	/**
	 * Get the name of the user
	 * @return nom String
	 */
    public String getNom() {
        return nom;
    }
    
	/**
	 * Set the name of the user
	 * @param nom String
	 */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
	/**
	 * Get the last name of the user
	 * @return prenom String
	 */
    public String getPrenom() {
        return prenom;
    }
    
	/**
	 * Set the first name of the user
	 * @param prenom String
	 */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
	/**
	 * Get the email of the user
	 * @return email String
	 */
    public String getEmail() {
        return email;
    }
    
	/**
	 * Set the email of the user
	 * @param email String
	 */
    public void setEmail(String email) {
        this.email = email;
    }
    
	/**
	 * Get the password of the user
	 * @return motDePasse String
	 */
    public String getMotDePasse() {
        return motDePasse;
    }
    
	/**
	 * Set the password of the user
	 * @param motDePasse String
	 */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [getNoUtilisateur()=");
		builder.append(getNoUtilisateur());
		builder.append(", getTelephone()=");
		builder.append(getTelephone());
		builder.append(", getRue()=");
		builder.append(getRue());
		builder.append(", getCodePostal()=");
		builder.append(getCodePostal());
		builder.append(", getVille()=");
		builder.append(getVille());
		builder.append(", getCredit()=");
		builder.append(getCredit());
		builder.append(", isAdministrateur()=");
		builder.append(isAdministrateur());
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getNom()=");
		builder.append(getNom());
		builder.append(", getPrenom()=");
		builder.append(getPrenom());
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append(", getMotDePasse()=");
		builder.append(getMotDePasse());
		builder.append(", getPseudo()=");
		builder.append(getPseudo());
		builder.append("]");
		return builder.toString();
	}
}
