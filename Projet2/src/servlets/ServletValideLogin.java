package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import beans.Utilisateur;
import dao.UtilisateurDao;

public class ServletValideLogin extends HttpServlet {
	private static final long serialVersionUID = 7633293501883840556L;
	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	HttpSession session = request.getSession();
    	
    	Utilisateur user = null;
        String login_form = request.getParameter("username"); // Obtenez le login du formulaire
        String motDePasse_form = request.getParameter("motDePasse"); //Obtenez le mot de passe du formulaire
 
        try {
            UtilisateurDao dao = new UtilisateurDao(); //nouveau objet DaoPerson
            user = dao.getPerson(login_form, motDePasse_form );
        }
        catch ( Exception e ){
 
        }
 
        //se nao encontrou usuario no banco, redireciona para a pagina de erro!
        if ( user == null ) {
            session.invalidate();
            request.getRequestDispatcher("erreurLogin.jsp" ).forward(request, response);
        }
        else{
            //se o dao retornar um usuario, coloca o mesmo na sessao
            session.setAttribute("user", user);
            request.getRequestDispatcher("logado.jsp" ).forward(request, response);
        }
 
    }
 
}
