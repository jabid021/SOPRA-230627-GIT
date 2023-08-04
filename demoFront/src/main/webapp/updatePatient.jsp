<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">


<html>
  <head>
    <meta charset="utf-8">
    <title>Modifier Patient ${patient.id}</title>
  </head>
  <body>





<div id="content">
  <h3>Modifier le patient ${patient.id}</h3>
  <form action="patient" method="post">
   	<input type="hidden" name="tache" value="update">
  <input type="hidden" name="id" value="${patient.id}">
 	<input type="text" name="nom" value="${patient.nom}" placeholder="Saisir nom"><br>
 	<input type="text" name="prenom" value="${patient.prenom}" placeholder="Saisir prenom"><br>
 	
    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="patient"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>
