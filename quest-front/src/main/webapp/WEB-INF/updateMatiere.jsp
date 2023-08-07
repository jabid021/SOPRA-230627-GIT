
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Matière</title>
</head>
<body>


<div id="content">

  <h3>Modifier Matière ${matiere.id}</h3>
  <form action="matiere" method="post">
  <input type="hidden" name="id" value="${matiere.id}">
  Libelle :<input value="${matiere.libelle}" name="libelle" type="text" placeholder="Saisir Le libelle"><br>
  Quest :<input value="${matiere.quest}" name="quest" type="text" placeholder="Saisir le code Quest"><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="matiere"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>