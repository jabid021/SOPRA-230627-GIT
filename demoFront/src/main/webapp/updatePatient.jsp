<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Modifier Patient</title>
</head>

<body>


	<h1>Fiche du patient ${patient.id}</h1>
	<table border>
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
		</tr>
		<tr>
		
		<td>${patient.nom}</td>
		<td>${patient.prenom}</td>
		
		</tr>

	</table>

	<form action='fichePatient' method='post'>
		<input type='hidden' name='id' value='${patient.id}'> 
		<input type='text' name='prenom' placeholder='Saisir prenom' value='${patient.prenom}'> 
		<input type='text' name='nom' placeholder='Saisir nom' value='${patient.nom}'> 
		<input type='submit' value='Modifier Patient'>
	</form>
	
</body>
</html>