package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/CreerCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pseudo = request.getParameter("pseudo");
		String firstName = request.getParameter("prenom");
		String lastName = request.getParameter("nom");
		String email = request.getParameter("email");
		String phone = request.getParameter("telephone");
		String city = request.getParameter("ville");
		String street = request.getParameter("rue");
		String zipcode = request.getParameter("codepostal");
		String password = request.getParameter("motdepasse");
		String confPassword = request.getParameter("confirmationmdp");
		
		
		
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
				|| confPassword.length() == 0
				|| pseudo.isEmpty()
				|| firstName.isEmpty()
				|| lastName.isEmpty()
				|| email.isEmpty()
				|| city.isEmpty()
				|| street.isEmpty()
				|| zipcode.isEmpty()
				|| password.isEmpty()
				|| confPassword.isEmpty()
				)
		{
			request.setAttribute("errorMessage", "Veuillez remplir les champs obligatoires");
			doGet(request, response);
			return;
		}
		// Vérifier la conformité du mot de passe
		if(!password.contentEquals(confPassword))
		{
			request.setAttribute("errorMessage", "Le mot de passe n'est pas identique");
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
		
		password = PasswordManager.hashPassword(password);
		
		Utilisateur user = new Utilisateur(lastName, firstName, email, password, pseudo, phone, 0, false, city, street, zipcode);
		
		try
		{
			UtilisateurManager manager = new UtilisateurManager();
			manager.addUtilisateur(user);
		} 
		catch (BLLException | SQLException | DALException e)
		{
			request.setAttribute("errorMessage", e.getMessage());
			doGet(request, response);
			e.printStackTrace();
		}
		
		
		response.sendRedirect(request.getContextPath() + "/login");
	}

}
