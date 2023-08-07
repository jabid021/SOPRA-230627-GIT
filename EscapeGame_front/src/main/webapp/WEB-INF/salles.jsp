
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Salles</title>
</head>
<body>
<div id="content">
  <h1>Liste des Salles</h1>
  <input id="btnAddSalle" type="button" class ="btn btn-success" value="Ajouter">
  <a href="gerant.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>min</th>
        <th>max</th>
        <th>Titre</th>
        <th>Description</th>
        <th>Durée</th>
        <th>Prix</th>
        <th>Accessibilité</th>
        <th>Difficulté</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${salles}" var="salle">
    	
      <tr>
        <td>${salle.id}</td>
        <td>${salle.min}</td>
        <td>${salle.max}</td>
        <td>${salle.titre}</td>
        <td>${salle.description}</td>
        <td>${salle.duree}</td>
        <td>${salle.prix}</td>
        <td>${salle.accessibilite}</td>
        <td>${salle.difficulte}</td>
        <td>
          <a href="salle?id=${salle.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="salle?id=${salle.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
   
      </c:forEach>
    </tbody>
  </table>





  <div id="addFormSalle" class="formAjout">
    <h3>Ajouter Salle</h3>
    <form action="salle" method="post">
      min :<input name="min" type="number" value="1"  min="0" placeholder="Saisir votre nombre de joueur minimal"><br>
      max :<input name="max" type="number" value="1" min="1"  placeholder="Saisir votre nombre de joueur maximal"><br>
      Titre :<input name="titre" type="text" placeholder="Saisir le titre de la salle"><br>
      Description :<input name="description" type="textarea" placeholder="Description de la salle"><br>
      Duree :<input name="duree" type="number" value="60"  min="0" max="120" placeholder="Durée de la salle"><br>
      Prix :<input name="prix" type="number" value="25"  min="0" placeholder="Prix de la salle"><br>
      Accessibilité :<input type="checkbox" name="accessibilite">oui  <br>
      Difficulté :<input type="radio" name="difficulte" value="Debutant" checked > Debutant   <input type="radio" name="difficulte" value="Intermediaire">Intermediaire   <input type="radio" name="difficulte" value="Expert"> Expert <br>

      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

</body>
</html>

<script>

  btnAddSalle.onclick=function()
  {
    addFormSalle.style.display="block";
  }

</script>


