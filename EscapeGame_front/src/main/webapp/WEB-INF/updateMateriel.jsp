


<html>
  <head>
    <title>Update Materiel ${materiel.id}</title>
  </head>
  <body>

<div id="content">
  <table>
  <h3>Modifier Materiel ${materiel.id}</h3>
  <form action="materiel" method="post">
    <input type="hidden" name="id" value="${materiel.id}">
      <tr>
        <td>Type de Matériel</td>
        <td>
        <input onChange="changeType('cadenas')" required id="cadenas" value="cadenas" name="type" type="radio"checked><label for="cadenas">Cadenas</label>
        <input onChange="changeType('mecanisme')" required id="mecanisme" value="mecanisme" name="type" type="radio"><label for="mecanisme">Mécanisme</label>
        <input onChange="changeType('coffre')" required id="coffre" value="coffre" name="type" type="radio"><label for="coffre">Coffre</label>
      </td>
      </tr>
      <tr>
        <td>Libelle : </td><td><input required name="libelle" value="${materiel.libelle}" type="text" placeholder="Saisir votre libelle"></td>
      </tr>
      <tr>
          <td>Etat</td>
          <td>
          <c:forEach items="${etats}" var="etat">
           	<c:choose>
           		<c:when test="${etat==materiel.etat}"> <input required id="${etat}" value="${etat}" name="etat" type="radio" checked><label for="${etat}">${etat}</label></c:when>
           		<c:otherwise><input required id="${etat}" value="${etat}" name="etat" type="radio"><label for="${etat}">${etat}</label></c:otherwise>
           	</c:choose>
          
          </c:forEach>
        </td>
      </tr>
      <tr id="ligneCode">
        <td>Code : </td><td><input id="inputCode" name="code" type="text" placeholder="Saisir le code"></td></tr>
        <tr id="ligneAttente">
        	<td>Attente : </td><td><input id="inputAttente" name="attente" type="number" placeholder="Saisir le temps"></td>
      </tr>
      <tr id="ligneElectrique">
        <td>Electrique ?</td><td>
        <input id="inputElectrique" name="choix" type="checkbox" > Oui
      </td>
      </tr>
      <tr>
        <td>Salle</td>
        <td><select name="salle">
          <option value="" >En réserve</option>
        	 <c:forEach items="${salles}" var="salle">
        		 <c:choose> 
                	<c:when test="${salle.id==materiel.salle.id}">
                		<option selected value="${salle.id}" >${salle.titre}</option>
                	</c:when>
                	
                	<c:otherwise>
                		<option value="${salle.id}" >${salle.titre}</option>
                	</c:otherwise>
                	</c:choose>
                </c:forEach>   
        </select></td>
      </tr>

      <tr><td><input class ="btn btn-warning" type="submit" value="Modifier">
        <a href="materiel"><input type="button" class ="btn btn-info" value="Retour"></a></td></tr>

  </form>
  </table>
</div>
</body>
</html>

<script>

<c:if test="${materiel.getClass().getSimpleName()=='Cadenas'}">
	changeType("cadenas");
	inputCode.value="${materiel.code}";
</c:if>


<c:if test="${materiel.getClass().getSimpleName()=='Coffre'}">
	changeType("coffre");
	inputCode.value="${materiel.code}";
	inputAttente.value="${materiel.attente}";
</c:if>


<c:if test="${materiel.getClass().getSimpleName()=='Mecanisme'}">
	changeType("mecanisme");
	inputElectrique.checked=${materiel.electrique};
</c:if>

 
 function changeType(label)
      {
    	  ligneAttente.style.display="none";
          ligneElectrique.style.display="none";
          ligneCode.style.display="none";
          inputAttente.removeAttribute("required");
          inputCode.removeAttribute("required");
         
          
    	  if(label=="cadenas")
    	  {
    		  cadenas.checked=true;
              ligneCode.style.display="table-row";
              inputCode.setAttribute("required","required");;
    	  }
    	  else if(label=="coffre")
    	  {
    		  coffre.checked=true;
    		  ligneCode.style.display="table-row";
              inputCode.setAttribute("required","required");;
    		  ligneAttente.style.display="table-row";
              inputAttente.setAttribute("required","required");
    	  }
    	  else
    	  {
    		  mecanisme.checked=true;
    		  ligneElectrique.style.display="table-row";
    	  }
      }

      
</script>