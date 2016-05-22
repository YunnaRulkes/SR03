package controleurs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class ValideLoginControleur
 */
//@WebServlet("/login")
public class ValideLoginControleur extends HttpServlet {

	private static final long serialVersionUID = -3191812674217304083L;
	public static final String SESSION_USER = "user";
	public static final String REQUEST_USER = "user";
	Utilisateur user = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    	HttpSession session = request.getSession();
    	
        String login_form = request.getParameter("user"); // Obtenez le login du formulaire
        String motDePasse_form = request.getParameter("password"); //Obtenez le mot de passe du formulaire
        Utilisateur user = new Utilisateur(login_form, motDePasse_form);
        try {
            UtilisateurDao dao = new UtilisateurDao();
            user = dao.trouver(login_form, motDePasse_form );
        }
        catch ( Exception e ){
        	System.err.println("Exception: " + e.getMessage());
        	System.err.println("Cause: " + e.getCause());
        }
        
 
        if (user == null) {
            session.invalidate();
            request.setAttribute("error", "Unknown login, please try again.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if(user.getStatusAdmin()) {
        	session.setAttribute(SESSION_USER, user);
        	request.getRequestDispatcher("pages/admin/accueil.jsp" ).forward(request, response);
        }
        else{
        	session.setAttribute(SESSION_USER, user);
            request.getRequestDispatcher("pages/participant/accueil.jsp" ).forward(request, response);
        }
 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
	}
	
}
