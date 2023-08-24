<html>
<head>

<title>Update Filiere</title>
</head>
<body>


<div id="content">

  <h3>Modifier Filiere ${filiere.id}</h3>
  <form action="filiere" method="post">
  <input type="hidden" name="id" value="${filiere.id}">
  Libelle :<input required value="${filiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>
  Début :<input required value="${filiere.debut}" name="debut" type="date"><br>
  Fin :<input required value="${filiere.fin}" name="fin" type="date" ><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="filiere"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>