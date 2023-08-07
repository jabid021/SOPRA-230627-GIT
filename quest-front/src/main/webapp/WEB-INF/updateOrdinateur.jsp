
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="content">

  <h3>Modifier Ordinateur ${ordinateur.id}</h3>
  <form action="ordinateur" method="post">
  <input type="hidden" name="id" value="${ordinateur.id}">
  Marque :<input value="${ordinateur.marque}" name="marque" type="text" placeholder="Saisir votre marque"><br>
  RAM :<input value="${ordinateur.ram}" name="ram" type="number" placeholder="Saisir votre RAM"><br>
Stagiaire
      <select name="stagiaire">
      <c:forEach items="${stagiaires}" var="stagiaire">
      <c:choose>
	        	<c:when test="${stagiaire.id == ordinateur.stagiaire.id}">
	        		<option selected value="${stagiaire.id}" >${stagiaire.nom} - ${stagiaire.prenom}</option>
	        	</c:when>
	        	
	        	<c:otherwise>
	        		<option value="${stagiaire.id}" >${stagiaire.id} - ${stagiaire.nom} - ${stagiaire.prenom}</option>
	        	</c:otherwise>
        	</c:choose>
 
        </c:forEach>
      </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="ordinateur"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
</body>
</html>