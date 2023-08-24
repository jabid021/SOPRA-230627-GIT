


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
        <td>Libelle : </td><td><input required name="libelle" type="text" placeholder="Saisir votre libelle"></td>
      </tr>
      <tr>
          <td>Etat</td>
          <td>
          <input required id="neuf" value="neuf" name="etat" type="radio" checked><label for="neuf"checked>Neuf</label>
          <input required id="standard" value="standard" name="etat" type="radio"><label for="standard">Standard</label>
          <input required id="abime" value="abime" name="etat" type="radio"><label for="abime">Abimé</label>
          <input required id="ko" value="ko" name="etat" type="radio"><label for="ko">KO</label>
        </td>
      </tr>
      <tr id="ligneCode">
        <td>Code : </td><td><input id="inputCode" name="code" value="5839" type="text" placeholder="Saisir le code"></td></tr>
        <tr id="ligneAttente">
        	<td>Attente : </td><td><input id="inputAttente" name="attente" type="number" placeholder="Saisir le temps"></td>
      </tr>
      <tr id="ligneElectrique">
        <td>Electrique ?</td><td>
        <input name="choix" type="checkbox" > Oui
      </td>
      </tr>
      <tr>
        <td>Salle</td>
        <td><select name="salle">
          <option value="" >Choisir la salle</option>
          <option value="1" selected >Salle 1</option>
          <option value="2" >Salle 2</option>
        </select></td>
      </tr>

      <tr><td><input class ="btn btn-warning" type="submit" value="Modifier">
        <a href="materiels.html"><input type="button" class ="btn btn-info" value="Retour"></a></td></tr>

  </form>
  </table>
</div>
</body>
</html>

<script>


 changeType("");
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