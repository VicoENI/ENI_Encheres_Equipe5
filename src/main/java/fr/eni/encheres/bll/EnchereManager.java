package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.encheres.exceptions.BLLException;
import fr.eni.encheres.exceptions.DALException;

/**
 * Class managing the Enchere.
 * @author mkebeEni
 * @version 1.0
 */
public class EnchereManager {

	// Liste des Enchere gérée par la classe EnchereManager
	private List<Enchere> listEncheres;
	
	// Accès aux données des Enchere
	private EnchereDAO daoEncheres;
	

	/**
	 * Constructor of the EnchereManager class. Initializes the list of Enchere and the connection to the database.
	 * @throws BLLException
	 * @throws DALException
	 */
	public EnchereManager() throws BLLException, DALException {
		//Instancier le Data Access Object
		daoEncheres = (EnchereDAO) new EnchereDAOJdbcImpl();
	
		//Charger le listUsers
		try {
			listEncheres = daoEncheres.getAllEncheres();
		} catch (Exception e) {
			throw new BLLException("Echec du chargement du listEnchere - ", e);
		}
	}
	
	/**
	 * Get the list of Enchere
	 * @return List of Enchere
	 */
	public List<Enchere> getlistEncheres() {
		return listEncheres;
	}
	
	/**
	 * Update an Enchere in the database
	 * @param enchere Enchere
	 * @throws BLLException
	 * @throws DALException
	 * @throws SQLException
	 */
	public void Enchere(Enchere enchere) throws BLLException, DALException, SQLException {
		Enchere existingEnchere;
		existingEnchere = daoEncheres.getEnchereById(enchere);
		if (existingEnchere==null){
			throw new BLLException("enchere inexistant.");
		}
		try {
			validerEnchere(enchere);
			daoEncheres.updateEnchereById(enchere);
			
		} catch (BLLException e) {
			throw new BLLException("Echec updateEnchere-enchere:"+enchere, e);
		}
	}

	// fait pour valider echange. 
	public void validerEnchere(Enchere enchere) throws BLLException {
		if (enchere.getMontantEnchere() <= enchere.getArticleVendu().getPrixVente()) {
			throw new BLLException("Le montant de l'enchère doit être supérieur au prix de vente de l'article !");
		}
		try {
			daoEncheres.updateEnchereById(enchere);
		} catch (DALException e) {
			throw new BLLException("Erreur lors de la validation de l'enchère : " + enchere, e);
		}
	}
	
	/**
	 * Get Enchere where position in list is the index
	 * @param index int
	 * @return enchere Enchere
	 */
	public Enchere getEnchere(int index) {
		return listEncheres.get(index);
	}
	
	/**
	 * Delete an Enchere in the database
	 * @param enchere Enchere
	 * @throws BLLException
	 * @throws DALException
	 */
	public void removeEnchere(Enchere enchere) throws BLLException, DALException {
		try {
			daoEncheres.deleteEnchereById(enchere);
		} catch (DALException e) {
			throw new BLLException("Echec deleteEnchere-enchere:"+enchere, e);
		}		
	}
	
}
