package fr.eni.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.exceptions.DALException;

/**
 * Interface in charge of managing the RETRAITS table
 * @author VicoENI
 * @version 1.0
 */
public interface RetraitDAO {

    // Méthodes CRUD

    /**
     * Method in charge of creating a new withdrawal in the database
     * @param retrait Retrait
     * @throws DALException
     * @throws SQLException
     */
    void createRetrait(Retrait retrait) throws DALException, SQLException;
    
    /**
     * Method in charge of retrieving all the withdrawals from the database
     * @return List of withdrawals
     * @throws DALException
     * @throws SQLException
     */
    List<Retrait> getAllRetraits() throws DALException, SQLException;
    
    /**
     * Method in charge of retrieving a withdrawal from the database by its number
     * @param article Article
     * @return List of withdrawals
     * @throws DALException
     * @throws SQLException
     */
    Retrait getRetraitByArticle(Article article) throws DALException, SQLException;
    
    /**
     * Method in charge of updating a withdrawal in the database
     * @param retrait Retrait
     * @throws DALException
     * @throws SQLException
     */
    void updateRetrait(Retrait retrait) throws DALException, SQLException;
    
    /**
     * Method in charge of deleting a withdrawal from the database
     * @param article Article
     * @throws DALException
     * @throws SQLException
     */
    void deleteRetrait(Article article) throws DALException, SQLException;
    
}
