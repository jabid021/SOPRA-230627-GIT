<%@ include file="/WEB-INF/include.jsp"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Fili�re</title>
</head>
<body>


<div id="content">

  <h3>Modifier Fili�re ${filiere.id}</h3>
  <form action="filiere" method="post">
  <input type="hidden" name="id" value="${filiere.id}">
      Libelle :<input name="libelle" type="text" placeholder="Saisir le libelle de la fili�re"><br>
      Debut :<input name="debut" type="date" placeholder="Saisir la date de d�but"><br>
      Fin :<input name="fin" type="date" placeholder="Saisir la date de fin"><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="filiere"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>