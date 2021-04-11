package travels.management.web.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;

public class DataBaseHelper 
{
	private  Connection cnx;
	private PreparedStatement pstmt;
	private static DataBaseHelper db;
	public static DataBaseHelper getInstance()
	{
		if(db == null)
		{
			db = new DataBaseHelper();
		}
		return db;
	}
	private DataBaseHelper()
	{
		
	}

	private void openConnection() throws Exception 
	{
		try {
			if (cnx == null || cnx.isClosed()) 
			{
				// Charger les drivres
				Class.forName("com.mysql.jdbc.Driver");
				// les parametres de connexion
				String user = "root", password = "";
				String url = "jdbc:mysql://localhost:3306/travel";
				// connexion à la BD
				cnx = DriverManager.getConnection(url, user, password);
			}
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}

	// fonction qui prepare les requetes
	public void myPrepareStatement(String sql) throws Exception {
		try {
			openConnection();
			pstmt = cnx.prepareStatement(sql);
		} catch (Exception e) {
			
			throw e;
		}
	}

	// fonction pour passer les parametres de la requete
	public void addParameters(Object[] parameters) throws SQLException {
		try {
			for (int i = 0; i < parameters.length; i++) 
			{
				pstmt.setObject(i + 1, parameters[i]);
			}
		} catch (SQLException e) {
			
			throw e;
		}
	}

	// fonction pour executer les requetes selection
	public ResultSet myExecuteQuery() throws Exception {
		try {
			return pstmt.executeQuery();
		} catch (Exception e) {
			
			throw e;
		}
	}

	// fonction pour executer les requetes mise à jour
	public int myExecuteUpdate() throws Exception {
		try {
			return pstmt.executeUpdate();
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	// fonction qui prepare les requetes
	public void myPrepareStatement1(String sql) throws Exception {
		try {

			openConnection();
			if (sql.trim().toLowerCase().startsWith("insert")) {
				pstmt = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			} else {
				pstmt = cnx.prepareStatement(sql);
			}

		} catch (Exception e) {
			throw e;
		}
	}
	
	// fonction pour recuperer l'id
	public int getkey() throws SQLException {
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		return -1;
	}

	// fonction pour fermer la connexion
	public void closeConnection() throws Exception
	{
		try 
		{
			pstmt.close();
			pstmt=null;
			cnx.close();
			cnx=null;
		} 
		catch (Exception e) {
			
			throw e;
		}
	}

}
