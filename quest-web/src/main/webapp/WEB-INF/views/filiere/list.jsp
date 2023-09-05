<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- ETAPE 5 : Exécution de la View --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des filières</title>
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap-icons.min.css"/>"/>
</head>
<body>

<div class="container">
	<div class="card mt-3">
		<div class="card-header bg-primary text-white display-6">Liste des filières</div>
		<div class="card-body">
			<table class="table table-striped">
				<tr>
					<th>Identifiant</th>
					<th>Version</th>
					<th>Libellé</th>
					<th>Date de début</th>
					<th>Date de fin</th>
					<th></th>
				</tr>
				<c:forEach items="${filieres}" var="fil">
					<c:url value="/filiere/edit" var="editUrl">
						<c:param name="id" value="${fil.id}"/>
					</c:url>
					<c:url value="/filiere/delete/${fil.id}" var="deleteUrl"/>
					<tr>
						<td>${fil.id}</td>
						<td>${fil.version}</td>
						<td>${fil.libelle}</td>
						<td>${fil.debut}</td>
						<td>${fil.fin}</td>
						<td><div class="btn-group btn-group-sm">
							<a href="${editUrl}" class="btn btn-primary"><i class="bi bi-pencil-square"></i></a>
							<a href="${deleteUrl}" class="btn btn-danger"><i class="bi bi-trash"></i></a>
						</div></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="card-footer">
			<c:url value="/filiere/add" var="addUrl"/>
			<a href="${addUrl}" class="btn btn-success btn-lg"><i class="bi bi-plus-square"></i></a>
		</div>
	
	</div>

</div>

</body>
</html>