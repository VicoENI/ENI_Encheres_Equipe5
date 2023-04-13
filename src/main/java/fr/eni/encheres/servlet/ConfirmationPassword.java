package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exceptions.BLLException;
import fr.eni.encheres.exceptions.DALException;

/**
 * Servlet implementation class ConfirmationPassword
 */
@WebServlet("/confirmation")
public class ConfirmationPassword extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmationPassword()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("WEB-INF/confirmationPassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		String passwordSend = (String)session.getAttribute("password");
		
		String passwordUser = request.getParameter("mot_de_passe");
		
		if(passwordSend.contentEquals(passwordUser))
		{
			String email = (String)request.getAttribute("email");
			boolean isPasswordUpdated = updatePassword(email, passwordUser);
			
			if(isPasswordUpdated)
			{
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errorMessage", "une erreur est survenue");
				request.getRequestDispatcher("WEB-INF/confirmationPassword.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorMessage", "Le mot de passe est incorrect");
			request.getRequestDispatcher("WEB-INF/confirmationPassword.jsp").forward(request, response);
		}
	}
	
	private boolean updatePassword(String email, String password)
	{
		boolean isSuccess = false;
		try
		{
			UtilisateurManager manager = new UtilisateurManager();
			Utilisateur user = manager.getlistUtilisateurs().stream().filter(u -> u.getEmail().contentEquals(email)).findFirst().get();
			
			user.setMotDePasse(password);
			
			manager.updateUtilisateur(user);
			isSuccess = true;
		} 
		catch (BLLException | SQLException | DALException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{			
			e.printStackTrace();
		}
		
		return isSuccess;
	}

}
