package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exceptions.BLLException;
import fr.eni.encheres.exceptions.DALException;
import fr.eni.encheres.utils.PasswordManager;
import fr.eni.encheres.utils.Validator;

/**
 * Servlet implementation class UpdateProfilServlet
 */
@WebServlet("/modification")
public class UpdateProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/ModifierProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String pseudo = request.getParameter("pseudo");
		String firstName = request.getParameter("prenom");
		String lastName = request.getParameter("nom");
		String email = request.getParameter("email");
		String phone = request.getParameter("telephone");
		String city = request.getParameter("ville");
		String street = request.getParameter("rue");
		String zipcode = request.getParameter("codepostal");
		String password = request.getParameter("motdepasse");
		
		
		
		//Vérifier l'unicité du pseudonyme et de l'email
		//Vérifier la non-nullité des champs
		if(
				pseudo.length() == 0
				|| firstName.length() == 0
				|| lastName.length() == 0
				|| email.length() == 0
				|| city.length() == 0
				|| street.length() == 0
				|| zipcode.length() == 0
				|| password.length() == 0
				|| pseudo.isEmpty()
				|| firstName.isEmpty()
				|| lastName.isEmpty()
				|| email.isEmpty()
				|| city.isEmpty()
				|| street.isEmpty()
				|| zipcode.isEmpty()
				|| password.isEmpty()
				)
		{
			request.setAttribute("errorMessage", "Veuillez remplir les champs obligatoires");
			doGet(request, response);
			return;
		}
		
		//TODO Les patterns des champs
		if(!Validator.isValidEmail(email))
		{
			request.setAttribute("errorMessage", "L'email n'est pas valide");
			doGet(request, response);
			return;
		}
		
		if(!phone.isEmpty() && !Validator.isValidPhone(phone))
		{
			request.setAttribute("errorMessage", "Le téléphone n'est pas valide");
			doGet(request, response);
			return;
		}
		
		if(!Validator.isValidZipcode(zipcode))
		{
			request.setAttribute("errorMessage", "Le code postal n'est pas valide");
			doGet(request, response);
			return;
		}
		
		try 
		{
			UtilisateurManager manager = new UtilisateurManager();
			
			Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
			
			if(!PasswordManager.verifyPassword(password, utilisateur.getMotDePasse()))
			{
				request.setAttribute("errorMessage", "Le mot de passe n'est pas valide");
				doGet(request, response);
				return;
			}
			
			List<Utilisateur> users = manager.getlistUtilisateurs();
			
			if(users.stream().anyMatch(user -> user.getPseudo().contentEquals(pseudo) && !(user.getNoUtilisateur() == utilisateur.getNoUtilisateur()) ))
			{
				request.setAttribute("errorMessage", "Le pseudo est déjà utilisé");
				doGet(request, response);
				return;
			}
			
			if(users.stream().anyMatch(user -> user.getEmail().contentEquals(email) && !(user.getNoUtilisateur() == utilisateur.getNoUtilisateur())))
			{
				request.setAttribute("errorMessage", "L'email est déjà utilisé");
				doGet(request, response);
				return;
			}
			
			utilisateur.setPseudo(pseudo);
			utilisateur.setPrenom(firstName);
			utilisateur.setNom(lastName);
			utilisateur.setEmail(email);
			utilisateur.setCodePostal(zipcode);
			utilisateur.setVille(city);
			utilisateur.setRue(street);
			utilisateur.setAdministrateur(false);
			utilisateur.setTelephone(phone);
			
			manager.updateUtilisateur(utilisateur);
			
			
		} catch (BLLException | SQLException | DALException e) 
		{
			e.printStackTrace();
			
			request.setAttribute("errorMessage", "Une erreur inattendue est survenue");
			doGet(request, response);
			return;
		}
		
		response.sendRedirect( request.getContextPath() + "/ServletDispatcher?page=profil");
	}

}
