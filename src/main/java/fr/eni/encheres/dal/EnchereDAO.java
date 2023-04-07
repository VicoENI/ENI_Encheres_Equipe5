package fr.eni.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.exceptions.DALException;

/**
 * Interface in charge of managing the ENCHERES table
 * @author VicoENI
 * @version 1.0
 */
public interface EnchereDAO {

    // Méthodes CRUD

    /**
     * Method in charge of creating a new bid in the database
     * @param enchere Enchere
     * @throws DALException
     * @throws SQLException
     */
    void createEnchere(Enchere enchere) throws DALException, SQLException;
    
    /**
     * Method in charge of retrieving all the bids from the database
     * @return List of bids
     * @throws DALException
     * @throws SQLException
     */
    List<Enchere> getAllEncheres() throws DALException, SQLException;
    
    /**
     * Method in charge of retrieving a bid from the database by its number
     * @param enchere Enchere
     * @return List of bids
     * @throws DALException
     * @throws SQLException
     */
    Enchere getEnchereById(Enchere enchere) throws DALException, SQLException;

    /**
     * Method in charge of updating a bid in the database
     * @param enchere Enchere
     * @throws DALException
     * @throws SQLException
     */
    public void updateEnchereById(Enchere enchere) throws DALException;

    /**
     * Method in charge of deleting a bid from the database
     * @param enchere Enchere
     * @throws DALException
     * @throws SQLException
     */
    public void deleteEnchereById(Enchere enchere) throws DALException;
}
