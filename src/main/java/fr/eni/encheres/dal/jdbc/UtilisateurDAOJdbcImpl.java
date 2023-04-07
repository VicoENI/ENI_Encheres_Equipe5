package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.exceptions.DALException;

/**
 * Class in charge of managing the UTILISATEURS table
 * @author VicoENI
 * @version 1.0
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

    // Attributs
    private Connection connection;

    // Requetes SQL
    private static final String GET_UTILISATEUR_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
    private static final String GET_UTILISATEURS = "SELECT * FROM UTILISATEURS";
    private static final String ADD_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, imageLien, administratrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, imageLien = ?, administrateur = ? WHERE no_utilisateur = ?";
    private static final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";

    /**
     * Constructor in charge of initializing the connection attribute with the connection passed in parameter
     * @param connection Connection
     */
    public UtilisateurDAOJdbcImpl() {
        // this.connection = connection;
    }

    /**
     * Methode in charge of get a user from the database by its pseudo
     * @param pseudo String
     * @return utilisateur Utilisateur
     * @throws DALException
     */
    @Override
    public Utilisateur getUtilisateurByPseudo(String pseudo) throws DALException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            connection = JdbcTools.getConnection();
            statement = connection.prepareStatement(GET_UTILISATEUR_BY_PSEUDO);
            statement.setString(1, pseudo);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                utilisateur = new Utilisateur();
            }
        } catch (Exception e) {
            throw new DALException("Echec getUtilisateurByPseudo", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            
                if (statement != null) {
                    statement.close();
                }
            
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return utilisateur;
    }

    /**
     * Methode in charge of retrieving users from the database
     * @return List of users
     * @throws DALException
     * @throws SQLException
     */
    @Override
    public List<Utilisateur> getUtilisateurs() throws DALException, SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_UTILISATEURS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Utilisateur utilisateur  = new Utilisateur();
                utilisateurs.add(utilisateur);
            }
        }
        return utilisateurs;
    }

    /**
     * Methode in charge of insert a new user in the database
     * @param utilisateur Utilisateur
     * @throws DALException
     * @throws SQLException
     */
    @Override
    public void addUtilisateur(Utilisateur utilisateur) throws DALException, SQLException {
        try (PreparedStatement statement = connection.prepareStatement(ADD_UTILISATEUR)) {
            statement.setString(1, utilisateur.getPseudo());
            statement.setString(2, utilisateur.getNom());
            statement.setString(3, utilisateur.getPrenom());
            statement.setString(4, utilisateur.getEmail());
            statement.setString(5, utilisateur.getTelephone());
            statement.setString(6, utilisateur.getRue());
            statement.setString(7, utilisateur.getCodePostal());
            statement.setString(8, utilisateur.getVille());
            statement.setString(9, utilisateur.getMotDePasse());
            statement.setInt(10, utilisateur.getCredit());
            statement.setBoolean(11, utilisateur.isAdministrateur());
            statement.executeUpdate();
        }
    }

    /**
     * Methode in charge of update a user in the database
     * @param utilisateur Utilisateur
     * @throws DALException
     * @throws SQLException
     */
    @Override
    public void updateUtilisateur(Utilisateur utilisateur) throws DALException, SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_UTILISATEUR)) {
            statement.setString(1, utilisateur.getPseudo());
            statement.setString(2, utilisateur.getNom());
            statement.setString(3, utilisateur.getPrenom());
            statement.setString(4, utilisateur.getEmail());
            statement.setString(5, utilisateur.getTelephone());
            statement.setString(6, utilisateur.getRue());
            statement.setString(7, utilisateur.getCodePostal());
            statement.setString(8, utilisateur.getVille());
            statement.setString(9, utilisateur.getMotDePasse());
            statement.setInt(10, utilisateur.getCredit());
            statement.setBoolean(11, utilisateur.isAdministrateur());
            statement.setInt(12, utilisateur.getNoUtilisateur());
            statement.executeUpdate();
        }
    }

    /**
     * Methode in charge of delete a user in the database
     * @param utilisateur Utilisateur
     * @throws DALException
     */
    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) throws DALException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JdbcTools.getConnection();
            statement = connection.prepareStatement(DELETE_UTILISATEUR);
            statement.setInt(1, utilisateur.getNoUtilisateur());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DALException("Echec deleteUtilisateur", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
