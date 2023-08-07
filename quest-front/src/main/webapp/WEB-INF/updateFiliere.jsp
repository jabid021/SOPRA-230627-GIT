<%@ include file="/WEB-INF/include.jsp"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Filière</title>
</head>
<body>


<div id="content">

  <h3>Modifier Filière ${filiere.id}</h3>
  <form action="filiere" method="post">
  <input type="hidden" name="id" value="${filiere.id}">
      Libelle :<input name="libelle" type="text" placeholder="Saisir le libelle de la filière"><br>
      Debut :<input name="debut" type="date" placeholder="Saisir la date de début"><br>
      Fin :<input name="fin" type="date" placeholder="Saisir la date de fin"><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="filiere"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>