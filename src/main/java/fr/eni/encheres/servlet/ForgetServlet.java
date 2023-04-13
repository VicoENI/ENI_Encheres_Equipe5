//package fr.encheres.servlets;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import fr.encheres.bll.UtilisateurManager;
//import fr.encheres.bo.Utilisateur;
//import fr.encheres.exceptions.BLLException;
//import fr.encheres.exceptions.DALException;
//import fr.encheres.utils.PasswordManager;
//
///**
// * Servlet implementation class ForgetServlet
// */
//@WebServlet("/forget")
//public class ForgetServlet extends HttpServlet
//{
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public ForgetServlet()
//	{
//		super();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		request.getRequestDispatcher("WEB-INF/forgetPassword.jsp").forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		String email = request.getParameter("email");
//		
//		if(email.isEmpty())
//		{
//			request.setAttribute("errorMessage", "Veuillez saisir une adresse e-mail");
//			doGet(request, response);
//			return;
//		}
//		
//		
//		// Verifier si l'adresse existe
//		try
//		{
//			UtilisateurManager manager = new UtilisateurManager();
//			
//			Utilisateur foundUser = null;
//			
//			for(Utilisateur user : manager.getlistUtilisateurs())
//			{
//				if(user.getEmail().contentEquals(email))
//				{
//					foundUser = user;
//					break;
//				}					
//			}
//			
//			if(foundUser != null)
//			{
//				// TODO Envoi email
//				Properties props = new Properties();
//				props.put("mail.smtp.host", "host");
//				props.put("mail.smtp.auth", "auth");
//				props.put("mail.smtp.port", "port");
//				props.put("mail.smtp.starttls.enable", "true");
//
//				Session session = Session.getInstance(props, new Authenticator() {
//					protected PasswordAuthentication getPasswordAuthentication()
//					{
//						return new PasswordAuthentication("emailServer", "password");
//					}
//				});
//				
//				
//				String newPassword = PasswordManager.generatePassword();
//				
//				
//				Message message = new MimeMessage(session);
//				message.setFrom(new InternetAddress("emailServer"));
//				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//		        message.setSubject("Envoi nouveau mot de passe");
//		        message.setText("Cher ..., voici votre nouveau mot de passe: " + newPassword);
//
//		        Transport.send(message);
//		        
//		        HttpSession httpSession = request.getSession();
//		        httpSession.setAttribute("password", newPassword);
//		        httpSession.setAttribute("email", email);
//				
//				
//		        
//		        request.getRequestDispatcher("WEB-INF/confirmationPassword.jsp").forward(request, response);
//
//			}
//			else
//			{
//				request.setAttribute("errorMessage", "L'adresse email est associée à aucun utilisateur du site");
//				doGet(request, response);
//			}
//		} 
//		catch (BLLException | MessagingException e)
//		{
//			request.setAttribute("errorMessage", e.getMessage());
//			doGet(request, response);
//			e.printStackTrace();
//		}
//	}
//
//}
