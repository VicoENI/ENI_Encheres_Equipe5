package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String page = request.getParameter("page");

		switch (page) {
			case "encheres":
				request.getRequestDispatcher("/WEB-INF/jsp/ListEnchere.jsp").forward(request, response);
				break;
			case "creer_article":
				request.getRequestDispatcher("/WEB-INF/jsp/NouvelleVente.jsp").forward(request, response);
				break;
			case "modifier_article":
				request.getRequestDispatcher("/WEB-INF/jsp/DetailVente.jsp").forward(request, response);
				break;
			case "profil":
				request.getRequestDispatcher("/WEB-INF/jsp/AfficherProfil.jsp").forward(request, response);
				break;
			case "deconnexion":
				request.getRequestDispatcher("/WEB-INF/jsp/PageConnexion.jsp").forward(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
