<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- ETAPE 5 : Exécution de la View --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de la matière</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/css/bootstrap-icons.min.css"/>" />
</head>
<body>

	<div class="container">
		<div class="card mt-3">
			<form action="" method="post">
				<div class="card-header bg-primary text-white display-6">Edition
					de la matière</div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" id="id" name="id" readonly value="${maMatiere.id}"/>
					</div>
					<div class="form-group">
						<label for="version">Version:</label> <input type="number"
							class="form-control" id="version" name="version" readonly value="${maMatiere.version}"/>
					</div>
					<div class="form-group">
						<label for="libelle">Libellé:</label> <input type="text"
							class="form-control" id="libelle" name="libelle" value="${maMatiere.libelle}"/>
					</div>
					<div class="form-group">
						<label for="quest">Code Quest:</label> <input type="number"
							class="form-control" id="quest" name="quest" value="${maMatiere.quest}"/>
					</div>
				</div>
				<div class="card-footer">
					<div class="btn-group btn-group-lg float-right">
						<c:url value="/matiere/cancel" var="cancelUrl"/>
						<button type="submit" class="btn btn-success"><i class="bi bi-check-square-fill"></i></button>
						<a href="${cancelUrl}" class="btn btn-warning"><i class="bi bi-backspace-fill"></i></a>
					</div>
				</div>
			</form>
		</div>

	</div>

</body>
</html>