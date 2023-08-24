<html>
<head>

<title>Update Stagiaire</title>
</head>
<body>


<div id="content">

  <h3>Modifier Stagiaire ${stagiaire.id}</h3>
  <form action="stagiaire" method="post">
  <input type="hidden" name="id" value="${stagiaire.id}">
  Nom :<input required value="${stagiaire.nom}" name="nom" type="text" placeholder="Saisir votre nom"><br>
  Prenom :<input required value="${stagiaire.prenom}" name="prenom" type="text" placeholder="Saisir votre prenom"><br>
  Email :<input required value="${stagiaire.email}" name="email" type="email" placeholder="Saisir votre email"><br>
  Filiere
    <select name="filiere">
        <c:forEach items="${filieres}" var="filiere">
        
        	<c:choose>
	        	<c:when test="${filiere.id == stagiaire.filiere.id}">
	        		<option selected value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
	        	</c:when>
	        	
	        	<c:otherwise>
	        		<option value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
	        	</c:otherwise>
        	</c:choose>
      	</c:forEach>
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="stagiaire"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>