package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	
	private  static Connection cnx = null;
	
	private ConnexionBD() {}
	public static Connection getInstance() {
		if (cnx == null) {
			try{
				Class.forName("com.mysql.jdbc.Driver"); 
		        cnx = DriverManager.getConnection("jdbc:mysql://tuxa.sme.utc/sr03p037?user=sr03p037&password=Swn7EhZr");
	        } catch (SQLException e) { //il capture l'erreur SQL s'il existe 
	        	System.err.println("SQLException: " + e.getMessage());
			    System.err.println("SQLState: " + e.getSQLState());
			    System.err.println("VendorError: " + e.getErrorCode());
	        } catch (ClassNotFoundException e) { //s'il n'existe pas sur le driver 
	            System.err.println("ClassNotFoundException: " + e.getMessage());
	        }        
	        return cnx; // Retourne la connexion ouverte	
		}
		else {
			return cnx;
		}
	}
	

	
}

