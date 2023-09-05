<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- ETAPE 5 : Exécution de la View --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des matières</title>
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap-icons.min.css"/>"/>
</head>
<body>

<div class="container">
	<div class="card mt-3">
		<div class="card-header bg-primary text-white display-6">Liste des matières</div>
		<div class="card-body">
			<table class="table table-striped">
				<tr>
					<th>Identifiant</th>
					<th>Version</th>
					<th>Libellé</th>
					<th>Quest</th>
					<th></th>
				</tr>
				<c:forEach items="${mesMatieres}" var="mat">
					<c:url value="/matiere/edit" var="editUrl">
						<c:param name="id" value="${mat.id}"/>
					</c:url>
					<c:url value="/matiere/delete/${mat.id}" var="deleteUrl"/>
					<tr>
						<td>${mat.id}</td>
						<td>${mat.version}</td>
						<td>${mat.libelle}</td>
						<td>${mat.quest}</td>
						<td><div class="btn-group btn-group-sm">
							<a href="${editUrl}" class="btn btn-primary"><i class="bi bi-pencil-square"></i></a>
							<a href="${deleteUrl}" class="btn btn-danger"><i class="bi bi-trash"></i></a>
						</div></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="card-footer">
			<c:url value="/matiere/add" var="addUrl"/>
			<a href="${addUrl}" class="btn btn-success btn-lg"><i class="bi bi-plus-square"></i></a>
		</div>
	
	</div>

</div>

</body>
</html>