<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des participants</title>
</head>

<div id="content">

	<h1>Liste des Participants</h1>
	<a href="home"><input type="button" class="btn btn-info"
		value="Retour"></a>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Client</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${participants}" var="participant">

				<tr>
					<td>${participant.id}</td>
					<td>${participant.nom}</td>
					<td>${participant.prenom}</td>
					<td>${participant.client.prenom} ${participant.client.nom}</td>
					<td><a href="participant?id=${participant.id}&delete"><input
							type="button" class="btn btn-danger" value="Supprimer"></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
</html>