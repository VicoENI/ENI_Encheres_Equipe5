package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.jdbc.JdbcTools;
import fr.eni.encheres.exceptions.BLLException;
import fr.eni.encheres.utils.PasswordManager;

/**
 * Servlet qui implémente la classe ConnexionServlet
 */
@WebServlet("/login")
public class ConnectionServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * Le constructeur
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() 
    {
        super();
    }

	/**
	 * Méthode GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		request.getRequestDispatcher("/WEB-INF/jsp/PageConnexion.jsp").forward(request, response);
	}

	/**
	 * Méthode POST
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pseudo 	= request.getParameter("pseudo");
		String password = request.getParameter("password");
		
		boolean validCredentials = checkCredentials(pseudo, password);
		
		if(validCredentials)
		{
			HttpSession session = request.getSession();
			session.setAttribute("pseudo", pseudo);
			
			response.sendRedirect(request.getContextPath() + "/accueil");
		}
		else
		{
			request.setAttribute("errorMessage", "Pseudo ou mot de passe incorrect");
			request.getRequestDispatcher("WEB-INF/jsp/PageConnexion.jsp");
		}
		
		doGet(request, response);
	}
	
	private boolean checkCredentials(String pseudo, String password)
	{
		try
		{
			UtilisateurManager manager = new UtilisateurManager();
			List<Utilisateur> users = manager.getlistUtilisateurs();
			
			Utilisateur foundUser = null;
			
			for(Utilisateur user : users)
			{
				if(user.getPseudo().contentEquals(pseudo))
				{
					foundUser = user;
					break;
				}
			}
			
			if(foundUser != null && PasswordManager.verifyPassword(password, foundUser.getMotDePasse()))
				return true;
			
			
		} catch (BLLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
