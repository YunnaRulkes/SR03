package controleurs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import beans.Utilisateur;
import dao.UtilisateurDao;

public class ValideLoginControleur extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3191812674217304083L;
	public static final String SESSION_USER = "user";
	public static final String REQUEST_USER = "user";
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    	HttpSession session = request.getSession();
    	
    	Utilisateur user = new Utilisateur();
        String login_form = request.getParameter("user"); // Obtenez le login du formulaire
        String motDePasse_form = request.getParameter("password"); //Obtenez le mot de passe du formulaire
 
        try {
            UtilisateurDao dao = new UtilisateurDao(); //nouveau objet UtilisateurDao
            user = dao.trouver(login_form, motDePasse_form );
        }
        catch ( Exception e ){
        	System.err.println("Exception: " + e.getMessage());
        }
 
        //s'il n'existe pas un utilisateur, redirige vers la page d'erreur
        if ( user == null ) {
            session.invalidate();
            request.getRequestDispatcher("erreurLogin.jsp" ).forward(request, response);
        }
        else{
            //si le dao retourne un utilisateur, placez-le en session
            session.setAttribute("user", user);
            request.getRequestDispatcher("logado.jsp" ).forward(request, response);
        }
 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
	}
	
}
