package CONTROLLER;

import java.util.ArrayList;

import MODEL.AES_verschluesselung;
import MODEL.MODEL_Konto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CONTROLLER_Access {

	private String mstrUserName;
	private String mstrPasswort;
	private  Connection mconCon;
	private final int mintPort = 3306;
	private  String mstrDatenbankName;
	private  String mstrHostName;

	private  ArrayList<MODEL_Konto> mvecModel;
	private  AES_verschluesselung aes;
	private static CONTROLLER_Access frame = null;
	
	public static CONTROLLER_Access init()
	{
	
			try {
				if (frame == null) {
					frame = new CONTROLLER_Access();
				}
				else
				{
					throw new Exception("Schon eine Instance vorhanden");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	return frame;
	}
	
	private CONTROLLER_Access() {
	}

	public void login(String username, String passwort, String db, String ip, String aes) {

		this.aes = new AES_verschluesselung();
		this.mvecModel = new ArrayList<MODEL_Konto>();
		
		try {
			// neuen Vector erstellen
			this.aes.setkey(aes);
			
			mstrUserName =  username;
			mstrPasswort = passwort;
			mstrDatenbankName = db;
			mstrHostName = ip;

			// Datenbanktreiber fuer JDBC Schnittstellen laden.
			Class.forName("com.mysql.jdbc.Driver");

			// Verbindung zur JDBC-Datenbank herstellen.
			mconCon = DriverManager.getConnection("jdbc:mysql://"
					+ mstrHostName + ":" + mintPort + "/" + mstrDatenbankName
					+ "?" + "user=" + mstrUserName + "&" + "password="
					+ mstrPasswort);
			
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean status()
	{
		return !mconCon.equals(null);
	
	}
	
	public void SQLAbfrage(String sql) {

		try {
			// abfrage statement erstellen
			Statement query = mconCon.createStatement();

			// Query bearbeiten
			ResultSet result = null;

			// executeQuerry nur fuer selects
			result = query.executeQuery(sql);
			
			
			// speichern in Klasse
			while (result.next()) {

				
					MODEL_Konto k = new MODEL_Konto(
							
							result.getInt("id"),
							aes.entschluesselnAES(result.getString("mstrDienst")), 
							aes.entschluesselnAES(result.getString("mstrUsername")),
							aes.entschluesselnAES(result.getString("mstrantworta")),
							aes.entschluesselnAES(result.getString("mstrantwortb")),
							aes.entschluesselnAES(result.getString("mstremail")),
							aes.entschluesselnAES(result.getString("mstrerstellt")), 
							aes.entschluesselnAES(result.getString("mstrfragea")),
							aes.entschluesselnAES(result.getString("mstrfrageb")),
							aes.entschluesselnAES(result.getString("mstrgeanertam")), 
							aes.entschluesselnAES(result.getString("mstrkontakt")),
							aes.entschluesselnAES(result.getString("mstrpasswort")),
							aes.entschluesselnAES(result.getString("mstrresetemail")),
							aes.entschluesselnAES(result.getString("mstrreseturl")),
							aes.entschluesselnAES(result.getString("mstrwebseite")));

					mvecModel.add(k);
			}
			
			
	

			// scliessen des streams
			result.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void SQLModifizieren(String sql) {
		try {

			// abfrage statement erstellen
			Statement query = mconCon.createStatement();

			// executeQuerry nur fuer insert/update/alter
			query.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		
		}
	}

	public void auslesen() {
		try{
		mvecModel.clear();
		SQLAbfrage(CONTROLLER_Statments.ViewKonto());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();

		}
	}


	
	
	
	
	public ArrayList<MODEL_Konto> getMvecModel() {
		return mvecModel;
	}

	

	public   AES_verschluesselung getAes() {
		return aes;
	}


}
