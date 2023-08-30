<html>
<head>

<title>Update Matiere</title>
</head>
<body>


<div id="content">

  <h3>Modifier Matiere ${matiere.id}</h3>
  <form action="matiere" method="post">
  <input type="hidden" name="id" value="${matiere.id}">
   <input type="hidden" name="version" value="${matiere.version}">
  Libelle :<input required value="${matiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>
  Quest :<input required value="${matiere.quest}" name="quest" type="number" min="0"  placeholder="Saisir code quest"><br>
  
    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="matiere"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>