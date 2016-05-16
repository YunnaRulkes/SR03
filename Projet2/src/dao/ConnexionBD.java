package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	private static final String LOGIN = "sr03p037";
	private static final String PASSWORD = "Swn7EhZr";
	private static final String URL = "jdbc:mysql://tuxa.sme.utc:5432/sr03p037";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public Connection openConnexion() throws Exception {
		Connection cnx = null;
		
		try{
			Class.forName(DRIVER); // Registrez le driver
	        cnx = DriverManager.getConnection(URL, LOGIN, PASSWORD); // Faitez la connexion
        } catch (SQLException e) { //il capture l'erreur SQL s'il existe 
        	System.err.println("SQLException: " + e.getMessage());
		    System.err.println("SQLState: " + e.getSQLState());
		    System.err.println("VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException e) { //s'il n'existe pas sur le driver 
            e.printStackTrace();
        }        
        return cnx; // Retourne la connexion ouverte	
    }

	
}

