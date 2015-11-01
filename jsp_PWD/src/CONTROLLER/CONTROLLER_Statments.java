package CONTROLLER;

import java.util.ArrayList;
import MODEL.AES_verschluesselung;

public class CONTROLLER_Statments {

	public enum caller {
		index {
			public String toString() {
				return "index";
			}
		},
		usermanagement {
			public String toString() {
				return "CREATE_User";
			}
		},

		Insert_Konto {
			public String toString() {
				return "INSERT_Konto_SQL";
			}
		},

		Update_Konto {
			public String toString() {
				return "UPDATE_Konto_SQL";
			}
		},
		Delete_Konto {
			public String toString() {
				return "DELETE_Konto_SQL";
			}
		},

		CONTROLLER_Import {
			public String toString() {
				return "CONTROLLER_Import";
			}
		},
		CONTROLLER_Export {
			public String toString() {
				return "CONTROLLER_Export";
			}
		}
	}

	public enum session {
		mvecModel {
			public String toString() {
				return "mvecMODEL";
			}
		},

		filename {
			public String toString() {
				return "filename";
			}
		},

		Insert_Konto {
			public String toString() {
				return "Insert_Konto";
			}
		},
		Update_Konto {
			public String toString() {
				return "Update_Konto";
			}
		},
		Delete_Konto {
			public String toString() {
				return "Delete_Konto";
			}
		}
	}

	public enum redirect {
	
		error {
			public String toString() {
				return "error.jsp";
			}
		},

		Controller {
			public String toString() {
				return "Controller";
			}
		},

		VIEW_Konto {
			public String toString() {
				return "VIEW_Konto.jsp";
			}
		},

		VIEW_UPDATE_Konto {
			public String toString() {
				return "VIEW_UPDATE_Konto.jsp";
			}
		},

		VIEW_INSERT_Konto {
			public String toString() {
				return "VIEW_INSERT_Konto.jsp";
			}
		}

	};

	public enum menu {
		login {
			public String toString() {
				return "index.jsp";
			}

		},
		Hauptmenue {
			public String toString() {
				return "login-success.jsp";
			}
		}

	};

	public static String ViewKonto() {
		return "select * from Konto k;";

	}

	public static ArrayList<String> createDB() {
		ArrayList<String> tmp = new ArrayList<String>();

		tmp.add("create database password_db;");
		tmp.add("use password_db;");
		tmp.add("create table konto(" + "mintID int NOT NULL AUTO_INCREMENT, " + " mstrDienst      varchar(255),"
				+ " mstrUsername varchar(255)," + " mstrantworta varchar(255)," + " mstrantwortb varchar(255),"
				+ " mstremail       varchar(255)," + " mstrerstellt    varchar(255)," + " mstrfragea varchar(255),"
				+ " mstrfrageb varchar(255)," + " mstrgeanertam   varchar(255)," + " mstrkontakt varchar(255),"
				+ " mstrpasswort varchar(255)," + " mstrresetemail  varchar(255)," + " mstrreseturl varchar(255),"
				+ " mstrwebseite    varchar(255)" + " PRIMARY KEY (mintID)" + ");");
		return tmp;
	}

	public static String AddKonto(String mstrDienst, String mstrUsername, String mstrantworta, String mstrantwortb,
			String mstremail, String mstrerstellt, String mstrfragea, String mstrfrageb, String mstrgeanertam,
			String mstrkontakt, String mstrpasswort, String mstrresetemail, String mstrreseturl, String mstrwebseite,
			AES_verschluesselung aes) {
		return "insert into Konto  (mstrDienst, mstrUsername,  mstrantworta,  mstrantwortb,"
				+ "mstremail,  mstrerstellt,  mstrfragea,  mstrfrageb,"
				+ "mstrgeanertam, mstrkontakt, mstrpasswort, mstrresetemail,"
				+ "mstrreseturl,   mstrwebseite ) VALUES( " + "\'" + aes.verschluesselnAES(mstrDienst) + "\', " + "\'"
				+ aes.verschluesselnAES(mstrUsername) + "\' ," + "\'" + aes.verschluesselnAES(mstrantworta) + "\' ,"
				+ "\'" + aes.verschluesselnAES(mstrantwortb) + "\' ," + "\'" + aes.verschluesselnAES(mstremail) + "\' ,"
				+ "\'" + aes.verschluesselnAES(mstrerstellt) + "\' ," + "\'" + aes.verschluesselnAES(mstrfragea)
				+ "\' ," + "\'" + aes.verschluesselnAES(mstrfrageb) + "\' ," + "\'"
				+ aes.verschluesselnAES(mstrgeanertam) + "\' ," + "\'" + aes.verschluesselnAES(mstrkontakt) + "\' ,"
				+ "\'" + aes.verschluesselnAES(mstrpasswort) + "\' ," + "\'" + aes.verschluesselnAES(mstrresetemail)
				+ "\' ," + "\'" + aes.verschluesselnAES(mstrreseturl) + "\' ," + "\'"
				+ aes.verschluesselnAES(mstrwebseite) + "\');";

	}

	public static String UpdateKonto(int id, String mstrDienst, String mstrUsername, String mstrantworta,
			String mstrantwortb, String mstremail, String mstrerstellt, String mstrfragea, String mstrfrageb,
			String mstrgeanertam, String mstrkontakt, String mstrpasswort, String mstrresetemail, String mstrreseturl,
			String mstrwebseite, AES_verschluesselung aes) {

		return "update Konto set " + "mstrDienst = " + "\'" + aes.verschluesselnAES(mstrDienst) + "\', "
				+ "mstrUsername =  " + "\'" + aes.verschluesselnAES(mstrUsername) + "\' ," + "mstrantworta =" + "\'"
				+ aes.verschluesselnAES(mstrantworta) + "\' ," + "mstrantwortb =" + "\'"
				+ aes.verschluesselnAES(mstrantwortb) + "\' ," + "mstremail =" + "\'" + aes.verschluesselnAES(mstremail)
				+ "\' ," + "  mstrerstellt = " + "\'" + aes.verschluesselnAES(mstrerstellt) + "\' ," + " mstrfragea = "
				+ "\'" + aes.verschluesselnAES(mstrfragea) + "\' ," + " mstrfrageb =" + "\'"
				+ aes.verschluesselnAES(mstrfrageb) + "\' ," + "mstrgeanertam = " + "\'"
				+ aes.verschluesselnAES(mstrgeanertam) + "\' ," + "mstrkontakt =" + "\'"
				+ aes.verschluesselnAES(mstrkontakt) + "\' ," + " mstrpasswort =" + "\'"
				+ aes.verschluesselnAES(mstrpasswort) + "\' ," + " mstrresetemail =" + "\'"
				+ aes.verschluesselnAES(mstrresetemail) + "\' ," + "mstrreseturl =" + "\'"
				+ aes.verschluesselnAES(mstrreseturl) + "\' ," + " mstrwebseite =" + "\'"
				+ aes.verschluesselnAES(mstrwebseite) + "\'" + "where mintID = " + id;

	}

	public static String DeleteKonto(int PK) {
		return "delete from Konto where mintID = " + PK + ";";

	}

	public static ArrayList<String> createDatenbank(String name) {
		ArrayList<String> mstrAttNew = new ArrayList<String>();

		return mstrAttNew;
	}

}


