package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;

public class UtilisateurDao{
	private Connection cnx;
	
	public UtilisateurDao() {}

	//private Connection cnx; //ouvre la connexion avec le BD

	public Utilisateur trouver( String login, String motDePasse ){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = cnx.prepareStatement("SELECT * FROM UTILISATEUR WHERE login = ? and motDePasse = ?");
            ps.setString(2, login);
            ps.setString(3, motDePasse);
 
            rs = ps.executeQuery();
 
            if ( rs.first() ){
                Utilisateur user = new Utilisateur();
                user.setId( rs.getInt("id") );
                user.setLogin(login);
                user.setMotDePasse(motDePasse);
                user.setPrenom( rs.getString("prenom") );
                user.setNom( rs.getString("nom") );
                user.setSociete( rs.getString("societe") );
                user.setTelephone( rs.getString("telephone") );
                user.setEmail( rs.getString("email") );
                user.setStatusActif( rs.getBoolean("statusActif") );
                user.setStatusAdmin( rs.getBoolean("statusAdmin") );
 
                return user;
            }
        }
        catch (SQLException e){
        	System.err.println("SQLException: " + e.getMessage());
		    System.err.println("SQLState: " + e.getSQLState());
		    System.err.println("VendorError: " + e.getErrorCode());
        }
        return null;
        }
}
