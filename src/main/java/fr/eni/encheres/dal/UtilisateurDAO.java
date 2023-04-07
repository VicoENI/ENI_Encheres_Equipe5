package fr.eni.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exceptions.DALException;

/**
 * Interface for the UtilisateurDAO class.
 * @author mkebeEni
 * @version 1.0
 */
public interface UtilisateurDAO {

    /**
     * Get the Utilisateur by its id
     * @param pseudo String
     * @return utilisateur Utilisateur
     * @throws SQLException
     * @throws DALException
     */
    Utilisateur getUtilisateurByPseudo(String pseudo) throws SQLException, DALException;

    /**
     * Get the Utilisateurs
     * @return List Utilisateur
     * @throws SQLException
     * @throws DALException
     */
    List<Utilisateur> getUtilisateurs() throws SQLException, DALException;

    /**
     * Add Utilisateur in the database
     * @param utilisateur Utilisateur
     * @throws SQLException
     * @throws DALException
     */
    void addUtilisateur(Utilisateur utilisateur) throws SQLException, DALException;

    /**
     * Update Utilisateur in the database
     * @param utilisateur Utilisateur
     * @throws SQLException
     * @throws DALException
     */
    void updateUtilisateur(Utilisateur utilisateur) throws SQLException, DALException;

    /**
     * Delete Utilisateur in the database
     * @param utilisateur Utilisateur
     * @throws SQLException
     * @throws DALException
     */
    void deleteUtilisateur(Utilisateur utilisateur) throws SQLException, DALException;
}
