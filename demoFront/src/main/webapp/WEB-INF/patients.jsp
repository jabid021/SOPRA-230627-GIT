<title>Gestion des patients</title>

<html>
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>



<div id="content">
  <h1>Liste des Patients</h1>
  <input id="btnAddPatient" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
  
    <c:forEach items="${patients}" var="p">
    <tr>
      	<td>${p.id}</td>
        <td>${p.nom}</td>
        <td>${p.prenom}</td>
        <td>
          <a href="patient?id=${p.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="patient?id=${p.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    </c:forEach>
      
    </tbody>
  </table>



  <div id="addFormPatient" class="formAjout">
    <h3>Ajouter Patient</h3>
   <form action="patient" method="post">
   	<input type="hidden" name="tache" value="insert">
  	<input type="number" name="id" placeholder="Saisir id"><br>
 	<input type="text" name="nom" placeholder="Saisir nom"><br>
 	<input type="text" name="prenom" placeholder="Saisir prenom"><br>
 	
    <input class ="btn btn-success" type="submit" value="Ajouter">
  </form>
  </div>

</div>



<script>

  btnAddPatient.onclick=function()
  {
	 addFormPatient.style.display="block";
  }

</script>

</body>
</html>
