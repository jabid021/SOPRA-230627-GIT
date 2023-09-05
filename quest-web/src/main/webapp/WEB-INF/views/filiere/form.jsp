<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- ETAPE 5 : Exécution de la View --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de la filière</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/css/bootstrap-icons.min.css"/>" />
</head>
<body>

	<div class="container">
		<div class="card mt-3">
			<c:url value="/filiere/saveBis" var="saveUrl"/>
			<form action="${saveUrl}" method="post">
				<div class="card-header bg-primary text-white display-6">Edition
					de la filière</div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" id="id" name="id" readonly value="${filiere.id}"/>
					</div>
					<div class="form-group">
						<label for="version">Version:</label> <input type="number"
							class="form-control" id="version" name="version" readonly value="${filiere.version}"/>
					</div>
					<div class="form-group">
						<label for="libelle">Libellé:</label> <input type="text"
							class="form-control" id="libelle" name="libelle" value="${filiere.libelle}"/>
					</div>
					<div class="form-group">
						<label for="debut">Date de début:</label> <input type="date"
							class="form-control" id="debut" name="debut" value="${filiere.debut}"/>
					</div>
					<div class="form-group">
						<label for="fin">Date de fin:</label> <input type="date"
							class="form-control" id="fin" name="fin" value="${filiere.fin}"/>
					</div>
				</div>
				<div class="card-footer">
					<div class="btn-group btn-group-lg float-right">
						<c:url value="/filiere/cancel" var="cancelUrl"/>
						<button type="submit" class="btn btn-success"><i class="bi bi-check-square-fill"></i></button>
						<a href="${cancelUrl}" class="btn btn-warning"><i class="bi bi-backspace-fill"></i></a>
					</div>
				</div>
			</form>
		</div>

	</div>

</body>
</html>