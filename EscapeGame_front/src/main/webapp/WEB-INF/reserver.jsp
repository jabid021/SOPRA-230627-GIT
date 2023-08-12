
<html>
<head>
<title>Catalogue</title>
</head>
<body>
	<div id="content">
		<h1 align="center">Voici notre catalogue :</h1>


		<div class="container">

			<div class="row">
			<c:forEach items="${salles}" var="salle">
				<div class="col-4">
					<div class="card" style="width: 25rem; margin-top: 15px;">
						<img src="assets/img/salle-${salle.id}.jpg" class="card-img-top" alt="${salle.titre}">
						<div class="card-body">
							<h5 class="card-title">${salle.titre}</h5>
							<p title="${salle.description}" class="card-text">
								${salle.description}
							</p>
							<p>Joueur(s) : ${salle.min}-${salle.max} Joueur(s)</p>
							<p>Duree - Prix : ${salle.duree} minutes - ${salle.prix} &#8364; / joueur </p>
							<button class="btn btn-primary"
								onClick="formParticipants(${salle.id},${salle.min},${salle.max},${salle.prix})">Reserver</button>
						</div>
					</div>
				</div>
			
			</c:forEach>
				
			</div>
		</div>

		<div id="formReservation" class="formAjout">
			<select id="nombreParticipant"></select> <input type="checkbox"
				id="checkSelf"> Je participe
			<form action="reserver" method="post"
				id="formulaireResaParticipant"></form>
		</div>
		<br>
		<br> <a href="home"><input type="button"
			class="btn btn-info" value="Retour menu Client"></a>
	</div>
</body>
</html>


<script>
var mesParticipants = [];
  mesParticipants.push({nom :'${compte.nom}', prenom:'${compte.prenom}', id:'0'});
	  <c:forEach items="${participants}" var="p">
	  	mesParticipants.push({nom :'${p.nom}', prenom:'${p.prenom}', id:'${p.id}'});
	  </c:forEach>
 </script>
<script src="reserver.js"></script>