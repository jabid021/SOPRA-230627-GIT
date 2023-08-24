<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des reservations</title>
</head>

<div id="content">

	<h1>Liste des Réservations</h1>
	<a href="home"><input type="button" class="btn btn-info"
		value="Retour"></a>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Date réservation</th>
				<th>Heure réservation</th>
				<th>Timer</th>
				<th>Prix</th>
				<th>Equipe</th>
				<th>Client</th>
				<th>Salle</th>
				<th>Gm</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${reservations}" var="reservation">

				<tr>
					<td>${reservation.id}</td>
					<td>${reservation.dateReservation}</td>
					<td>${reservation.heureReservation}</td>

					<c:choose>
						<c:when test="${reservation.dateReservation < today}">
							<td>${reservation.timer}</td>
							<td>${reservation.prix}</td>
							<td>${reservation.equipe}</td>
							<td>${reservation.client.id}-${reservation.client.nom}
								${reservation.client.prenom}</td>
							<td>${reservation.salle.id}-${reservation.salle.titre}</td>
							<td>${reservation.gameMaster.id}-
								${reservation.gameMaster.nom} ${reservation.gameMaster.prenom}</td>
						</c:when>
						<c:otherwise>
							<td>/</td>
							<td>${reservation.prix}</td>
							<td>${reservation.equipe}</td>
							<td>${reservation.client.id}-${reservation.client.nom}
								${reservation.client.prenom}</td>
							<td>${reservation.salle.id}-${reservation.salle.titre}</td>
							<td><select id="gameMaster-${reservation.id}" onchange="changeGm(${reservation.id})">
								<option value="0">Pas de GameMaster</option>
									<c:forEach items="${gameMasters}" var="gameMaster">
										<c:choose>
											<c:when test="${gameMaster.id == reservation.gameMaster.id}">
												<option selected value="${gameMaster.id}">${gameMaster.nom}
													${gameMaster.prenom}</option>
											</c:when>
											<c:otherwise>
												<option value="${gameMaster.id}">${gameMaster.nom}
													${gameMaster.prenom}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select></td>
						</c:otherwise>
					</c:choose>
					<td><a href="reservation?id=${reservation.id}&delete"><input
							type="button" class="btn btn-danger" value="Supprimer"></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
</html>


<script>

function changeGm(idResa)
{

var idGameMasterJS = document.getElementById("gameMaster-"+idResa).value;


	$.ajax("reservation", 
		{
			type: "POST",
			data: {
				idGameMaster:idGameMasterJS,
				idReservation: idResa
		},
		success: function () {
			alert("Changement de gamemaster pour la resa "+idResa);
		}
	});


}

</script>