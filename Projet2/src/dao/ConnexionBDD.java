package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionBDD {
	private static final String USER = "sr03p037";
	private static final String PASSWORD = "Swn7EhZr";
	private static final String URL = "jdbc:postgresql://tuxa.sme.utc:5432/sr03p037";
	private static final String DRIVER = "org.postgresql.Driver";
	
	public static Connection openConnexion() throws Exception {
		Connection cnx = null;
		
		try{
			Class.forName(DRIVER); // Registrez le driver
	        cnx = DriverManager.getConnection(URL, USER, PASSWORD); // Faitez la connexion
        } catch (SQLException e) { //il capture l'erreur SQL s'il existe 
            e.printStackTrace();
        } catch (ClassNotFoundException e) { //s'il n'existe pas sur le driver 
            e.printStackTrace();
        }        
        return cnx; // Retourne la connexion ouverte	
    }

	
}

