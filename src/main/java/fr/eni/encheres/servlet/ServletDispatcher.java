package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDispatcher
 */
@WebServlet("/ServletDispatcher")
public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "echeres":
			break;
		case "vendre":
			break;
		case "profil":
			// Récupération de l'utilisateur connecté
			
			// Redirection vers la page profil
			RequestDispatcher rd =  request.getRequestDispatcher("WEB-INF/jsp/ModifierProfil.jsp");
			rd.forward(request, response);
			break;
		case "deconnexion":
			// l'attribut isConnected est mis à false
			request.setAttribute("isConnected", false);
			// la session est détruite
			request.getSession().invalidate();
			// on redirige vers la page d'accueil
			RequestDispatcher rd =  request.getRequestDispatcher("WEB-INF/jsp/Accueil.jsp");
			rd.forward(request, response);
			break;
		doGet(request, response);
		}
	}
}
