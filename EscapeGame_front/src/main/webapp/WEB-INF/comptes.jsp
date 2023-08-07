
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
    
    
    <tr onClick = "clickSurLigne(${compte.id})">
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
      <tr><td>Type de compte : </td><td><input required type="radio" name="type" value="Gerant">Gerant <input type="radio" name="type" value="GameMaster">GameMaster <input type="radio" name="type" checked value="Client"> Client </td></tr>
      <tr><td>Login : </td><td><input required name="login" type="login" placeholder="Saisir votre Login"> </td></tr>
      <tr><td>Password : </td><td><input required name="password" type="password" placeholder="Saisir votre Password"> </td></tr>
      <tr><td>Nom  : </td><td><input required name="nom" type="text" placeholder="Saisir votre nom"> </td></tr>
      <tr><td>Prénom  : </td><td><input required name="prenom" type="text" placeholder="Saisir votre prénom"> </td></tr>
      <tr><td>Tel : </td> <td><input  name="tel" type="tel" placeholder="Saisir votre tel"> </td></tr>
      <tr><td>Mail : </td> <td><input  name="mail" type="Mail" placeholder="Saisir votre mail"> </td></tr>
     <tr>  <td>Numero :  </td><td><input  name="numero" type="numero" placeholder="Saisir votre numero"> </td></tr>
      <tr><td>Voie : </td><td><input  name="voie" type="text" placeholder="Saisir votre voie"> </td></tr>
      <tr><td>Ville : </td><td><input  name="ville" type="text" placeholder="Saisir votre ville"> </td></tr>
    <tr>  <td>CP :</td><td><input  name="cp" type="text" placeholder="Saisir votre cp"> </td></tr>
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
  
  
  	function clickSurLigne(id)
  	{
  	alert("click sur "+id);	
  	}
  

</script>