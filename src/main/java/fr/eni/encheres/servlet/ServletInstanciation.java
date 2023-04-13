package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInstanciation
 */
@WebServlet("/listeEncheres")
public class ServletInstanciation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInstanciation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des enchères
		// EnchereDAO enchereDAO = null;
		// try {
		// 	request.setAttribute("encheres", enchereDAO.getAllEncheres());
		// } catch (DALException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// } catch (SQLException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }
		request.setAttribute("isConnected", false);
		RequestDispatcher rd =  request.getRequestDispatcher("WEB-INF/jsp/ListEnchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
