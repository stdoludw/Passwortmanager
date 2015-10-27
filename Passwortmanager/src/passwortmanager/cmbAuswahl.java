package passwortmanager;
import java.util.ArrayList;

public class cmbAuswahl
{
    public cmbAuswahl() {
    }
    
    public static String getGUI_Abfrage_BtnAnmelden()
    {
        return "GUI_Abfrage_BtnAnmelden";
    }
        
    public static String getGUI_Anzeigen_BtnHinzufuegen()
    {
        return "getGUI_Anzeigen_BtnHinzufuegen";
    }
    public static String getGUI_Anzeigen_BtnUpdate()
    {
        return "getGUI_Anzeigen_BtnUpdate";
    }
    public static String getGUI_Hinzufuegen_BtnHinzufuegen()
    {
        return "getGUI_Hinzufuegen_BtnHinzufuegen";
    }

public static ArrayList<String> createDB()
{
ArrayList<String> tmp = new ArrayList<String>();

tmp.add("create database password_db;");
tmp.add("use password_db;");
tmp.add("create table konto("+
   " mstrDienst      varchar(255),"+
  " mstrUsername varchar(255),"+
  " mstrantworta varchar(255),"+
  " mstrantwortb varchar(255),"+
  " mstremail       varchar(255),"+
  " mstrerstellt    varchar(255),"+
  " mstrfragea varchar(255),"+
  " mstrfrageb varchar(255),"+
  " mstrgeanertam   varchar(255),"+
  " mstrkontakt varchar(255),"+
  " mstrpasswort varchar(255),"+
  " mstrresetemail  varchar(255),"+
  " mstrreseturl varchar(255),"+
  " mstrwebseite    varchar(255));");
return tmp;
}

}