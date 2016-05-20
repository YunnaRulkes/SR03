package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;

public class UtilisateurDao {
	private Connection cnx;
	private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public UtilisateurDao() {
    	this.cnx = ConnexionBD.getInstance();
    }
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
        	fermer();
        }
        return null;
        }

	public Utilisateur ajouter(Utilisateur user) {
		try{
            ps = cnx.prepareStatement("INSERT INTO UTILISATEUR(login, motDePasse, nom, prenom, email, statusAdmin) VALUES (?, ?, ?, ?, ?, ?);");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getMotDePasse());
            ps.setString(3, user.getNom());
            ps.setString(4, user.getPrenom());
            ps.setString(5, user.getEmail());
            ps.setBoolean(6, user.getStatusActif());
            ps.setBoolean(7, user.getStatusAdmin());
            ps.executeUpdate();
        }
        catch (SQLException e){
        	System.err.println("SQLException: " + e.getMessage());
		    System.err.println("SQLState: " + e.getSQLState());
		    System.err.println("VendorError: " + e.getErrorCode());
        }
        finally{
            fermer();
        }
        return null;		
	}
	
	public void supprimer(Utilisateur user) {
		try{
            ps = cnx.prepareStatement("DELETE FROM `UTILISATEUR` WHERE `login` = ?");
            ps.setString(1, user.getLogin());
            ps.executeUpdate();
        }
        catch (SQLException e){
        	System.err.println("SQLException: " + e.getMessage());
		    System.err.println("SQLState: " + e.getSQLState());
		    System.err.println("VendorError: " + e.getErrorCode());
        }
        finally{
            if (rs != null ) {
                try { rs.close(); } catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
                rs = null;
            }
            if (ps != null ) {
                try { ps.close(); } catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
                ps = null;
            }
            if (cnx != null ) {
                try { cnx.close(); } catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
                cnx = null;
            }
        }
	}
	public void modifier(Utilisateur userOriginal, Utilisateur userNouveau) {
		try{
            ps = cnx.prepareStatement("UPDATE `UTILISATEUR` SET `login`=?,`motDePasse`=?,`nom`=?,`prenom`=?,`societe`=?,`telephone`=?,`email`=?,`statusActif`=?  WHERE `login`=?");
            ps.setString(1, userNouveau.getLogin());
            ps.setString(2, userNouveau.getMotDePasse());
            ps.setString(3, userNouveau.getNom());
            ps.setString(4, userNouveau.getPrenom());
            ps.setString(5, userNouveau.getEmail());
            ps.setBoolean(6, userNouveau.getStatusActif());
            ps.setString(8, userOriginal.getLogin());
            ps.executeUpdate();
        }
        catch (SQLException e){
        	System.err.println("SQLException: " + e.getMessage());
		    System.err.println("SQLState: " + e.getSQLState());
		    System.err.println("VendorError: " + e.getErrorCode());
        }
        finally{
        	fermer();
        }	
	}
	
	public void fermer() {
		if (rs != null ) {
            try { rs.close(); } catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            rs = null;
        }
        if (ps != null ) {
            try { ps.close(); } catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            ps = null;
        }
        if (cnx != null ) {
            try { cnx.close(); } catch (SQLException e) { System.err.println("SQLException: " + e.getMessage()); }
            cnx = null;
        }
	}
}
