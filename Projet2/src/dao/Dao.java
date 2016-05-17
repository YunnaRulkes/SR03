package dao;

import java.sql.Connection;

public abstract class Dao {
	private Connection cnx;
	
	public Dao(Connection c) {
		this.cnx = c;
	}
	protected Connection getCnx() {
		return this.cnx;
	}
}
