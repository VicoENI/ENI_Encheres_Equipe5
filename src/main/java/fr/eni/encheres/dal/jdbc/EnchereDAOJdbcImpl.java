 package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.exceptions.DALException;

import fr.eni.encheres.bo.Utilisateur;
/**
 * Class in charge of managing SQL queries for the ENCHERES table
 * @author VicoENI
 * @version 1.0
*/
public class EnchereDAOJdbcImpl implements EnchereDAO {

    // Création des requêtes SQL
    private static final String CREATE_ENCHERE   = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
    private static final String GET_ALL_ENCHERES = "SELECT * FROM ENCHERES";
    private static final String GET_ENCHERE_BY_NO_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article = ?";
    private static final String UPDATE_ENCHERE   = "UPDATE ENCHERES SET no_utilisateur = ?, date_enchere = ?, montant_enchere = ? WHERE no_article = ?";
    private static final String DELETE_ENCHERE   = "DELETE FROM ENCHERES WHERE no_article = ?";
    
    
    // Objet Connection pour la connexion à la base de données
    private Connection connection;
    
    /**
     * Constructor of the class EnchereDAOJdbcImpl which takes a connection as a parameter
     */
    public EnchereDAOJdbcImpl() {
        // this.connection = connection;
    }

    /**
     * Method in charge of creating a new bid in the database
     * @param enchere Enchere
     * @throws DALException
     * @throws SQLException
     */
    @Override
    public void createEnchere(Enchere enchere) throws DALException, SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // connexion à la base de données
            connection = ConnectionProvider.getConnection();
            // création de la requête
            statement = connection.prepareStatement(CREATE_ENCHERE);
            // remplacement des paramètres
            statement.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
            statement.setInt(2, enchere.getArticleVendu().getNoArticle());
            statement.setTimestamp(3, new java.sql.Timestamp(enchere.getDateEnchere().getTime()));
            statement.setInt(4, enchere.getMontantEnchere());
            // exécution de la requête
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la création de l'enchère", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DALException("Erreur lors de la création de l'enchère", e);
            }
        }
    }

    /**
     * Method in charge of retrieving all the bids from the database
     * @return List of bids
     * @throws DALException
     * @throws SQLException
     */
    @Override
    public List<Enchere> getAllEncheres() throws DALException, SQLException {
        List<Enchere> encheres = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_ENCHERES)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Utilisateur utilisateur = ((Enchere) resultSet).getUtilisateur();
                Article article = ((Enchere) resultSet).getArticle();
                java.util.Date dateEnchere = new java.util.Date(resultSet.getTimestamp("date_enchere").getTime());
                int montantEnchere = resultSet.getInt("montant_enchere");
                Enchere enchere = new Enchere(utilisateur, article, dateEnchere, montantEnchere);
                encheres.add(enchere);
            }
        }
        return encheres;
    }

    /**
     * Method in charge of updating a bid in the database
     * @param enchere Enchere
     * @throws DALException
     * @throws SQLException
     */
    @Override
    public Enchere getEnchereById(Enchere enchere) throws DALException, SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // connexion à la base de données
            connection = ConnectionProvider.getConnection();
            // création de la requête
            statement = connection.prepareStatement(GET_ENCHERE_BY_NO_ARTICLE);
            // remplacement des paramètres
            statement.setInt(1, enchere.getArticleVendu().getNoArticle());
            // exécution de la requête
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la mise à jour de l'enchère", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DALException("Erreur lors de la mise à jour de l'enchère", e);
            }
        }
        return enchere;
    }

    @Override
    public void updateEnchereById(Enchere enchere) throws DALException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // connexion à la base de données
            connection = ConnectionProvider.getConnection();
            // création de la requête
            statement = connection.prepareStatement(UPDATE_ENCHERE);
            // remplacement des paramètres
            statement.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
            statement.setTimestamp(2, new java.sql.Timestamp(enchere.getDateEnchere().getTime()));
            statement.setInt(3, enchere.getMontantEnchere());
            statement.setInt(4, enchere.getArticleVendu().getNoArticle());
            // exécution de la requête
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la mise à jour de l'enchère", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DALException("Erreur lors de la mise à jour de l'enchère", e);
            }
        }
    }

    @Override
    public void deleteEnchereById(Enchere enchere) throws DALException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // connexion à la base de données
            connection = ConnectionProvider.getConnection();
            // création de la requête
            statement = connection.prepareStatement(DELETE_ENCHERE);
            // remplacement des paramètres
            statement.setInt(1, enchere.getArticleVendu().getNoArticle());
            // exécution de la requête
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DALException("Erreur lors de la suppression de l'enchère", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DALException("Erreur lors de la suppression de l'enchère", e);
            }
        }
    }
}

