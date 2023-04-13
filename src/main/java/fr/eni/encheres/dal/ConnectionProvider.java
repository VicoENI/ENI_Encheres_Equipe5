package fr.eni.encheres.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Classe abstraite permettant de fournir un accès à une base de données
 * @author JeffSurf
 */
public abstract class ConnectionProvider 
{
	private static DataSource dataSource;
	
	static
	{
		Context context;
		
		try 
		{
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/encheres");
		} 
		catch (NamingException e) 
		{			
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}
	
	/**
	 * Récupérer une connexion opérationnelle
	 * @return une {@link Connection connexion} à une base de données (META-INF/context.xml)
	 * @throws SQLException - Si des erreurs se produisent lors de la connexion (port TCP/IP, ...)
	 */
	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.dataSource.getConnection();
	}
	
	public static void close(Connection con) throws SQLException
	{
		if(con != null)
			con.close();
	}
	
	public static void close(PreparedStatement statement) throws SQLException
	{
		if(statement != null)
			statement.close();
	}
	
	public static void close(CallableStatement statement) throws SQLException
	{
		if(statement != null)
			statement.close();
	}
	
	public static void close(Statement statement) throws SQLException
	{
		if(statement != null)
			statement.close();
	}
}
