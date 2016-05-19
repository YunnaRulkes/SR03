package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;

public class UtilisateurDao {
	Connection cnx = ConnexionBD.getInstance();
	private static PreparedStatement ps = null;
    private static ResultSet rs = null;

	public Utilisateur trouver( String login, String motDePasse ) {
		
        
        try{
            ps = cnx.prepareStatement("SELECT * FROM `UTILISATEUR` WHERE `login`= ? AND `motDePasse`= ? ");
            ps.setString(1, login);
            ps.setString(2, motDePasse);
            rs = ps.executeQuery();
 
            if ( rs.next() ){
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
        	System.err.println("SQLException 1: " + e.getMessage());
		    System.err.println("SQLState 1: " + e.getSQLState());
		    System.err.println("VendorError: 1 " + e.getErrorCode());
        }
        finally{
            if (rs != null ) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
            if (ps != null ) {
                try { ps.close(); } catch (SQLException e) { ; }
                ps = null;
            }
            if (cnx != null ) {
                try { cnx.close(); } catch (SQLException e) { ; }
                cnx = null;
            }
        }
        return null;
        }
}
