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
	public static final String SESSION_USER = "user";
	public static final String REQUEST_USER = "user";
	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	HttpSession session = request.getSession();
    	
    	Utilisateur user = null;
        String login_form = request.getParameter("login"); // Obtenez le login du formulaire
        String motDePasse_form = request.getParameter("motDePasse"); //Obtenez le mot de passe du formulaire
 
        try {
            UtilisateurDao dao = new UtilisateurDao(); //nouveau objet UtilisateurDao
            user = dao.trouver(login_form, motDePasse_form );
        }
        catch ( Exception e ){
 
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
 
}
