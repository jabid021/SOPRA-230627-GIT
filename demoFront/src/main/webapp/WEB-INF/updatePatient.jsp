<html>
<head>
<meta charset="utf-8">
<title>Modifier Patient ${patient.id}</title>
</head>
<body>

	<c:choose>
		
		<c:when test="${patient==null}">

			<h1>Pas de patient avec cet id</h1>
		</c:when>
		<c:otherwise>


			<div id="content">
				<h3>Modifier le patient ${patient.id}</h3>
				<form action="patient" method="post">
					<input type="hidden" name="tache" value="update"> 
					<input type="hidden" name="id" value="${patient.id}"> 
					<input type="text" name="nom" value="${patient.nom}" placeholder="Saisir nom"><br> 
					<input type="text" name="prenom" value="${patient.prenom}" placeholder="Saisir prenom"><br> 
						<input class="btn btn-warning" type="submit" value="Modifier"> 
						
				</form>
			</div>

		</c:otherwise>

	</c:choose>
	<a href="patient"><input type="button" class="btn btn-info" value="Retour"></a>



</body>
</html>
