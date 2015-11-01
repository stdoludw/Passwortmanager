<%@page import="CONTROLLER.CONTROLLER_Access"%>
<%@page import="CONTROLLER.CONTROLLER_Statments"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODEL.MODEL_Konto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<link rel="stylesheet" href="w3-theme-red.css">

<body w3-white-grey>

<nav class="w3-sidenav w3-white w3-card-2 w3-animate-left" style="display:none">
  <a href="javascript:void(0)"
  onclick="w3_close()"
	    class="w3-closenav w3-large">Close</a>
 <a href="<%=CONTROLLER_Statments.menu.login.toString()%>"  >Login</a>
  <a href="<%=CONTROLLER_Statments.menu.Hauptmenue.toString()%>">Hauptmenue</a>
  
</nav>

<header class="w3-container w3-blue-grey">
  <span class="w3-opennav w3-large" onclick="w3_open()">&#9776; Menue </span>
</header>

<body>

<div class="w3-container">
  <hr>
  <div class="w3-center">
    <h2>Konten</h2>	
    <p w3-class="w3-large">Konten ändern</p>
  </div>
<div class="w3-responsive w3-card-4">
<table class="w3-table w3-striped w3-bordered">
<thead>

<%
int ID = Integer.valueOf(request.getParameter("k_ID"));
ArrayList<MODEL_Konto> tmp = (ArrayList<MODEL_Konto>)session.getAttribute(CONTROLLER_Statments.session.mvecModel.toString());
MODEL_Konto konto = null;

for (int i = 0;i<tmp.size();i++)
{	

		if(tmp.get(i).getMintID() == ID)
		{
			konto = tmp.get(i);
			
		}	
		
	}

%>


      	  
<form action="<%=CONTROLLER_Statments.caller.Update_Konto.toString() %>" method="POST">
Konto ID<input class="w3-input" style="width:95%" type="text" name="mintID" size="20" 
value="<%= konto.getMintID() %>">

Name des Dienst<input class="w3-input" style="width:95%" type="text" name="mstrDienst" size="20"> 
value="<%= konto.getMstrDienst() %>">

Webseite des Dienst<input class="w3-input" style="width:95%" type="text" name="mstrwebseite" size="20" >
value="<%= konto.getMstrwebseite() %>">

Reset E-Mail<input class="w3-input" style="width:95%" type="text" name="mstrresetemail" size="20" >
value="<%= konto.getMstrresetemail() %>">

Kontakadresse<input class="w3-input" style="width:95%" type="text" name="mstrkontakt" size="20" >
value="<%= konto.getMstrkontakt() %>">

Reset URL<input class="w3-input" style="width:95%" type="text" name="mstrreseturl" size="20" >
value="<%= konto.getMstrreseturl() %>">

Username<input class="w3-input" style="width:95%" type="text" name="mstrUsername" size="20" >
value="<%= konto.getMstrUsername() %>">

Passwort<input class="w3-input" style="width:95%" type="text" name="mstrpasswort" size="20" >
value="<%= konto.getMstrpasswort() %>">

E-Mail<input class="w3-input" style="width:95%" type="text" name="mstremail" size="20" >
value="<%= konto.getMstremail() %>">

Geändert am<input class="w3-input" style="width:95%" type="text" name="mstrerstellt" size="20" >
value="<%= konto.getMstrerstellt() %>">

Erstellt am<input class="w3-input" style="width:95%" type="text" name="mstrgeanertam" size="20" >
value="<%= konto.getMstrgeanertam() %>">

Reset Frage A<input class="w3-input" style="width:95%" type="text" name="mstrfragea" size="20" >
value="<%= konto.getMstrfragea() %>">

Reset Antwort A<input class="w3-input" style="width:95%" type="text" name="mstrantworta" size="20" >
value="<%= konto.getMstrantworta() %>">

Reset Frage B<input class="w3-input" style="width:95%" type="text" name="mstrfrageb" size="20" >
value="<%= konto.getMstrfrageb() %>">

Reset Antwort B<input class="w3-input" style="width:95%" type="text" name="mstrantwortb" size="20" >
value="<%= konto.getMstrantwortb() %>">





	<br>
	<center>
<input class="w3-btn w3-light-green" type="submit" value="Konten Ändern">
</center>

</form>

<script>
function w3_open() {
    document.getElementsByClassName("w3-sidenav")[0].style.display = "block";
}
function w3_close() {
    document.getElementsByClassName("w3-sidenav")[0].style.display = "none";
}
</script>

</body>
</html>