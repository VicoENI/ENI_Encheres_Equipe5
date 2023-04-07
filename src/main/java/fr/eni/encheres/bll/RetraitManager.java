package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.encheres.exceptions.BLLException;
import fr.eni.encheres.exceptions.DALException;

/**
 * Class managing the Retrait.
 * @author mkebeEni
 * @version 1.0
 */
public class RetraitManager {

	// Liste des Retrait gérée par la classe RetraitManager
	private List<Retrait> listRetraits;
	
	// Accès aux données des Retrait
	private RetraitDAO daoRetraits;
	

	/**
	 * Constructor of the RetraitManager class. Initializes the list of Retrait and the connection to the database.
	 * @throws BLLException
	 */
	public RetraitManager() throws BLLException {
			//Instancier le Data Access Object
		daoRetraits = (RetraitDAO) new RetraitDAOJdbcImpl();
		
		//Charger la liste des catégories
		try {
			listRetraits = daoRetraits.getAllRetraits();
		} catch (Exception e) {
			throw new BLLException("Echec du chargement du listRetraits - ", e);
		}
	}
	
	/**
	 * Get the list of Retrait
	 * @return List of Retrait
	 */
	public List<Retrait> getlistRetraits() {
		return listRetraits;
	}
	
	/**
	 * Add a new Retrait in the database
	 * @param newRetrait Retrait
	 * @return index of new retrait
	 * @throws BLLException 
	 * @throws SQLException
	 * @throws DALException
	 */
	public int addRetrait(Retrait newRetrait) throws BLLException, DALException, SQLException {
		Retrait retrait;
		try {
			retrait = daoRetraits.getRetraitByArticle(newRetrait.getArticle());
		} catch (Exception e) {
			throw new BLLException("Echec selectById dans addRetrait", e);
		}
		if (retrait!= null){
			throw new BLLException("retrait deja existante.");
		}
		try {
			daoRetraits.createRetrait(newRetrait);
			listRetraits.add(newRetrait);
		} catch (Exception e) {
			throw new BLLException("Echec addRetrait", e);
		}
		return listRetraits.size()-1;
		}
	
	/**
	 * Update a retrait in the database
	 * @param retrait Retrait
	 * @throws BLLException
	 */
	public void updateRetrait(Retrait retrait) throws BLLException {
		Retrait existingRetrait;
		try {
			existingRetrait = daoRetraits.getRetraitByArticle(retrait.getArticle());
		} catch (Exception e) {
			throw new BLLException("Echec selectById dans updateCategorie", e);
		}
		if (existingRetrait==null){
			throw new BLLException("retrait inexistant.");
		}
		try {
			daoRetraits.updateRetrait(retrait);
			
		} catch (Exception e) {
			throw new BLLException("Echec updateRetrait -retrait:" + e);
		}
	}
	
	/**
	 * Extract retrait from the database
	 * @param index int
	 * @return Retrait
	 */
	public Retrait getRetrait(int index) {
		return listRetraits.get(index);
	}
	
	/**
	 * Delete a retrait from the database
	 * @param index int
	 * @throws BLLException
	 * @throws DALException
	 */
	public void removeRetrait(Article article) throws BLLException, DALException {
		try {
			daoRetraits.deleteRetrait(article);
		} catch (SQLException e) {
			throw new BLLException("Echec deleteRetrait - retrait:"+ e);
		}
		
	}

}
