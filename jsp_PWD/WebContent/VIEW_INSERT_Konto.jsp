<%@page import="CONTROLLER.CONTROLLER_Access"%>
<%@page import="MODEL.MODEL_Konto"%>
<%@page import="CONTROLLER.CONTROLLER_Statments"%>


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
    <p w3-class="w3-large">Konten Hinzufügen</p>
  </div>
<div class="w3-responsive w3-card-4">
<table class="w3-table w3-striped w3-bordered">
<thead>

	        	  
<form action="<%=CONTROLLER_Statments.caller.Insert_Konto.toString() %>" method="POST">
Dienst Name<input class="w3-input" style="width:95%" type="text" name="mstrDienst" size="20"> 
Dienst Webseite<input class="w3-input" style="width:95%" type="text" name="mstrwebseite" size="20" >
Resetemail Adresse<input class="w3-input" style="width:95%" type="text" name="mstrresetemail" size="20" >
Dienst Kontakt<input class="w3-input" style="width:95%" type="text" name="mstrkontakt" size="20" >
Reset URL<input class="w3-input" style="width:95%" type="text" name="mstrreseturl" size="20" >

Username<input class="w3-input" style="width:95%" type="text" name="mstrUsername" size="20" >
Passwort<input class="w3-input" style="width:95%" type="text" name="mstrpasswort" size="20" >
E-Mail<input class="w3-input" style="width:95%" type="text" name="mstremail" size="20" >
Geaendert am<input class="w3-input" style="width:95%" type="text" name="mstrgeanertam" size="20" >
Erstellt am<input class="w3-input" style="width:95%" type="text" name="mstrerstellt" size="20" >
Frage A<input class="w3-input" style="width:95%" type="text" name="mstrfragea" size="20" >
Antwort A<input class="w3-input" style="width:95%" type="text" name="mstrantworta" size="20" >
Frage B<input class="w3-input" style="width:95%" type="text" name="mstrfrageb" size="20" >
Antwort B<input class="w3-input" style="width:95%" type="text" name="mstrantwortb" size="20" >

<p></p>
	
	<br>
	<center>
<input class="w3-btn w3-light-green" type="submit" value="Konto Hinzufügen">
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