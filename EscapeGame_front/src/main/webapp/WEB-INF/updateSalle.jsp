
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Salle</title>
</head>
<body>


<div id="content">

  <h3>Modifier Salle ${salle.id}</h3>
  <form action="salle" method="post">
  <input type="hidden" name="id" value="${salle.id}">
  min :<input name="min" type="number" value="${salle.min}"  min="0" placeholder="Saisir votre nombre de joueur minimal"><br>
      max :<input name="max" type="number" value="${salle.max}" min="1"  placeholder="Saisir votre nombre de joueur maximal"><br>
      Titre :<input name="titre" type="text" value="${salle.titre}" placeholder="Saisir le titre de la salle"><br>
      Description :<input name="description" value="${salle.description}"type="textarea" placeholder="Description de la salle"><br>
      Duree :<input name="duree" type="number" value="${salle.duree}"  min="0" max="120" placeholder="Durée de la salle"><br>
      Prix :<input name="prix" type="number" value="${salle.prix}" min="0" placeholder="Prix de la salle"><br>
      Accessibilité :<input type="checkbox" checked name="accessibilite">oui<br>
      
       Difficulté :
      <c:forEach items="${difficultes}" var="difficulte">
      
       <c:choose>
     		 <c:when test="${salle.difficulte==difficulte}">
      			<input type="radio" name="difficulte" value="${difficulte}" checked > ${difficulte}  
      		</c:when>
      
      		<c:otherwise>
     			 <input type="radio" name="difficulte" value="${difficulte}"> ${difficulte}  
      		</c:otherwise>
      </c:choose>
      
      </c:forEach>
     
      <br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="salle"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>
