

<title>Gestion Materiel</title>
<html>
<head>
  <meta charset="utf-8">
  <title>Materiels</title>
</head>
<body>

  <div id="content">
    <h1>Liste des Materiels</h1>
    <input id="btnAddMateriel" type="button" class ="btn btn-success" value="Ajouter">
    <a href="gerant.html"><input type="button" class ="btn btn-info" value="Retour"></a>

    <table class="table table-striped">
      <thead>
        <tr>
          <th>Id</th>
          <th>Type de Materiels</th>
          <th>Libelle</th>
          <th>Etat</th>
          <th>Code</th>
          <th>Attente (min)</th>
          <th>Electrique</th>
          <th>Salle</th>
        </tr>
      </thead>

      <tbody>
      
       <c:forEach items="${materiels}" var="materiel">
        <tr>
          <td>${materiel.id}</td>
          <td>${materiel.getClass().getSimpleName()}</td>
          <td>${materiel.libelle}</td>
          <td>${materiel.etat}</td>
          <c:choose>
          	<c:when test="${materiel.getClass().getSimpleName()=='Cadenas'  || materiel.getClass().getSimpleName()=='Coffre'}"> 
          		<td>${materiel.code}</td>
          	</c:when>
          	<c:otherwise>
          		<td>/</td>
          	</c:otherwise>
          </c:choose>
          
          <c:choose>
          	<c:when test="${materiel.getClass().getSimpleName()=='Coffre'}">
          		<td>${materiel.attente}</td>
          	</c:when>
          	<c:otherwise>
          		<td>/</td>
          	</c:otherwise>
          </c:choose>
          
          <c:choose>
          	<c:when test="${materiel.getClass().getSimpleName()=='Mecanisme'}"> 
          		<td>${materiel.electrique}</td>
         	</c:when>
          	<c:otherwise>
          		<td>/</td>
          	</c:otherwise>
          </c:choose>
          
          <c:choose>
          	<c:when test="${materiel.salle!=null}">
          		<td>${materiel.salle.id}-</td> 
          	</c:when>
          <c:otherwise>
          		<td>En réserve</td>
          </c:otherwise>
          </c:choose>
          <td>
            <a href="materiel?id=${materiel.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
            <a href="materiel?id${materiel.id}"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
          </td>
        </tr>
        </c:forEach>
        </tbody>
        </table>

      

    <div id="addFormMateriel" class="formAjout">
      <table>
        <h3>Ajouter Materiel</h3>
        <form action="materiel" method="post">
          <tr>
            <td>Type de Matériel</td>
            <td>
              <input onChange="changeType('cadenas')" checked required id="cadenas" value="cadenas" name="type" type="radio"><label for="cadenas" checked>Cadenas</label>
              <input onChange="changeType('mecanisme')" required id="mecanisme" value="mecanisme" name="type" type="radio"><label for="mecanisme">Mécanisme</label>
              <input onChange="changeType('coffre')" required id="coffre" value="coffre" name="type" type="radio"><label for="coffre">Coffre</label>
            </td>
          </tr>
          <tr>
            <td>Libelle : </td><td><input required name="libelle" type="text" placeholder="Saisir votre libelle"></td>
          </tr>
          <tr>
            <td>Etat</td>
            <td>
              <input required id="neuf" value="neuf" name="etat" type="radio"><label for="neuf" checked >Neuf</label>
              <input required id="standard" value="standard" name="etat" type="radio"><label for="standard">Standard</label>
              <input required id="abime" value="abime" name="etat" type="radio"><label for="abime">Abimé</label>
              <input required id="ko" value="ko" name="etat" type="radio"><label for="ko">KO</label>
            </td>
          </tr>
          <tr id="ligneCode">
            <td>Code : </td><td><input required id="inputCode" name="code" type="text" placeholder="Saisir le code"></td></tr>
            <tr id="ligneAttente"><td>Attente : </td><td><input id="inputAttente" name="attente" type="number" placeholder="Saisir le temps"></td>
            </tr>
            <tr id="ligneElectrique">
              <td>Electrique ?</td><td>
                <input name="choix" type="checkbox"> Oui
              </td>
            </tr>
            <tr>
              <td>Salle</td>
              <td><select  required name="salle">
                <option value="" >Choisir la salle</option>
                <option value="1" >Salle 1</option>
                <option value="2" >Salle 2</option>
              </select></td>
            </tr>


            <tr><td><input class ="btn btn-success" type="submit" value="Ajouter"></td></tr>
          </form>
        </table>
      </div>

    </div>

    <script>
	  ligneAttente.style.display="none";
      ligneElectrique.style.display="none";
      
      btnAddMateriel.onclick=function()
      {
        addFormMateriel.style.display="block";
      }
      
      function changeType(label)
      {
    	  ligneAttente.style.display="none";
          ligneElectrique.style.display="none";
          ligneCode.style.display="none";
          inputAttente.removeAttribute("required");
          inputCode.removeAttribute("required");
         
          
    	  if(label=="cadenas")
    	  {
              ligneCode.style.display="table-row";
              inputCode.setAttribute("required","required");;
    	  }
    	  else if(label=="coffre")
    	  {
    		  ligneCode.style.display="table-row";
              inputCode.setAttribute("required","required");;
    		  ligneAttente.style.display="table-row";
              inputAttente.setAttribute("required","required");
    	  }
    	  else
    	  {
    		  ligneElectrique.style.display="table-row";
    	  }
      }

    </script>