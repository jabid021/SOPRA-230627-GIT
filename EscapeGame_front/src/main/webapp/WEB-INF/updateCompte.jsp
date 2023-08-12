<html>
<head>

<title>Fiche Compte ${compte.id}</title>
</head>
<body>
	<div id="content">

		<h3>Modifier Compte ${compte.id}</h3>
		<form action="compte" method="post">
			<input type="hidden" name="id" value="${compte.id}">
			<table>
				<tr>
					<td>Type de compte :</td>
					<td>
						<c:forEach items="${types}" var="type">
							<c:choose>
								<c:when test="${type==typeAccount}">
									<input required onChange="changeType('${type}')" type="radio" value="${type}" checked name="type">${type}
								</c:when>
								
								<c:otherwise>
									<input required onChange="changeType('${type}')" type="radio" value="${type}" name="type">${type}
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>Login :</td>
					<td><input required value="${compte.login}" name="login" type="texte"
						placeholder="Saisir votre Login"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input required value="${compte.password}" name="password"
						type="password" placeholder="Saisir votre Password"></td>
				</tr>
				<tr>
					<td>Nom :</td>
					<td><input required value="${compte.nom}" name="nom" type="text"
						placeholder="Saisir votre nom"></td>
				</tr>
				<tr>
					<td>Prénom :</td>
					<td><input required value="${compte.prenom}" name="prenom" type="text"
						placeholder="Saisir votre prénom"></td>
				</tr>
					<tr class="ligneClient">
						<td>Tel :</td>
						<td><input required id="inputTel" class="inputClient" name="tel" type="tel" placeholder="Saisir votre tel"></td>
					</tr>
					<tr class="ligneClient">
						<td>Mail :</td>
						<td><input required id="inputMail" class="inputClient"  name="mail" type="email" placeholder="Saisir votre mail"></td>
					</tr>
					<tr class="ligneClient">
						<td>Numero :</td>
						<td><input required id="inputNumero" class="inputClient" name="numero" type="text" placeholder="Saisir votre numero"></td>
					</tr>
					<tr class="ligneClient">
						<td>Voie :</td>
						<td><input required id="inputVoie" class="inputClient" name="voie" type="text" placeholder="Saisir votre voie"></td>
					</tr>
					<tr class="ligneClient">
						<td>Ville :</td>
						<td><input required id="inputVille" class="inputClient" name="ville" type="text" placeholder="Saisir votre ville"></td>
					</tr>
					<tr class="ligneClient">
						<td>CP :</td>
						<td><input required id="inputCp" class="inputClient" name="cp" type="text" placeholder="Saisir votre cp"></td>
					</tr>
			</table>



			<input class="btn btn-warning" type="submit" value="Modifier">
			<a href="compte"><input type="button" class="btn btn-info"
				value="Retour"></a>
		</form>
	</div>
</body>
</html>

<script>

<c:if test="${typeAccount=='Client'}">

	$("#inputTel").val("${compte.tel}");
	$("#inputMail").val("${compte.mail}");
	$("#inputNumero").val("${compte.adresse.numero}");
	$("#inputVoie").val("${compte.adresse.voie}");
	$("#inputVille").val("${compte.adresse.ville}");
	$("#inputCp").val("${compte.adresse.cp}");

</c:if>

changeType('${typeAccount}');

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