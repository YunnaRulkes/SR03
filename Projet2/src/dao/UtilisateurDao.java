package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;
import dao.ConnexionBDD;

public class UtilisateurDao {

	public Utilisateur getPerson( String login, String motDePasse ){
        Connection cnx = new ConnexionBDD.getConnexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = cnx.prepareStatement("select id, nome from usuario where login = ? and motDePasse = ?");
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
                user.setStatus( rs.getString("status") );
                user.setType( rs.getBoolean("type") );
 
                return user;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
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
