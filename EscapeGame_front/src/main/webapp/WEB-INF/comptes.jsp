
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des comptes</title>
</head>
<body>
<div id="content">
  <h1>Liste des Comptes</h1>
  <input id="btnAddCompte" type="button" class ="btn btn-success" value="Ajouter">
  <a href="home"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Tel</th>
        <th>Mail</th>
        <th>Numero</th>
        <th>Voie</th>
        <th>Ville</th>
        <th>CP</th>
        <th>Type de compte</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${comptes}" var="compte">
    
    
    <tr>
        <td>${compte.id}</td>
        <td>${compte.login}</td>
        <td>${compte.password}</td>
        <td>${compte.nom}</td>
        <td>${compte.prenom}</td>
        
        <c:choose>
        
	        <c:when test="${compte.getClass().getSimpleName()=='Client'}">
		        <td>${compte.tel}</td>
		        <td>${compte.mail}</td>
		        <td>${compte.adresse.numero}</td>
		        <td>${compte.adresse.voie}</td>
		        <td>${compte.adresse.ville}</td>
		        <td>${compte.adresse.cp}</td>
	        </c:when>
        
        
	        <c:otherwise>
		        <td>/</td>
		        <td>/</td>
		        <td>/</td>
		        <td>/</td>
		        <td>/</td>
		        <td>/</td>
	        </c:otherwise>
        </c:choose>
        
        
        <td>${compte.getClass().getSimpleName()}</td>
        <td>
          <a href="compte?id=${compte.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="compte?id=${compte.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    
    </c:forEach>
      
    </tbody>
  </table>





  <div id="addFormCompte" class="formAjout">
    <h3>Ajouter Compte</h3>
    <form action="compte" method="post">
      <table>
      <tr><td>Type de compte : </td><td><input onchange="changeType('Gerant')" required type="radio" name="type" value="Gerant">Gerant <input onchange="changeType('GameMaster')" type="radio" name="type" value="GameMaster">GameMaster <input onchange="changeType('Client')" type="radio" name="type" checked value="Client"> Client </td></tr>
      <tr><td>Login : </td><td><input required name="login" type="text" placeholder="Saisir votre Login"> </td></tr>
      <tr><td>Password : </td><td><input required name="password" type="password" placeholder="Saisir votre Password"> </td></tr>
      <tr><td>Nom  : </td><td><input required name="nom" type="text" placeholder="Saisir votre nom"> </td></tr>
      <tr><td>Prénom  : </td><td><input required name="prenom" type="text" placeholder="Saisir votre prénom"> </td></tr>
      <tr class="ligneClient"><td>Tel : </td> <td><input required class="inputClient" name="tel" type="tel" placeholder="Saisir votre tel"> </td></tr>
      <tr class="ligneClient"><td>Mail : </td> <td><input required class="inputClient"  name="mail" type="email" placeholder="Saisir votre mail"> </td></tr>
      <tr class="ligneClient"><td>Numero :  </td><td><input required class="inputClient" name="numero" type="text" placeholder="Saisir votre numero"> </td></tr>
      <tr class="ligneClient"><td>Voie : </td><td><input required class="inputClient" name="voie" type="text" placeholder="Saisir votre voie"> </td></tr>
      <tr class="ligneClient"><td>Ville : </td><td><input required class="inputClient" name="ville" type="text" placeholder="Saisir votre ville"> </td></tr>
      <tr class="ligneClient"><td>CP :</td><td><input  required class="inputClient" name="cp" type="text" placeholder="Saisir votre cp"> </td></tr>
      </table>


      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>


</body>
</html>
<script>


  btnAddCompte.onclick=function()
  {
    addFormCompte.style.display="block";
  }
  
  function changeType(typeCompte)
  {
	  if(typeCompte=="Client")
	  {
		  $(".ligneClient").css("display","table-row");
		  $(".inputClient").attr("required","required");
	  }
	  else
	  {
		  $(".ligneClient").css("display","none");
		  $(".inputClient").removeAttr("required");
	  }
  }
  
  

</script>