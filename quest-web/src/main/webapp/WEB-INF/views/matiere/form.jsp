<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<c:url value="/matiere/saveBis" var="saveUrl"/>
			<form:form method = "POST" action = "${saveUrl}" commandName = "maMatiere" modelAttribute="maMatiere">
				<div class="card-header bg-primary text-white display-6">Edition
					de la matière</div>
				<div class="card-body">
					<div class="form-group">
						<form:label path="id">Identifiant:</form:label> 
						<form:input type="number" path="id"
							class="form-control" id="id" name="id" readonly="true"/>
					</div>
					<div class="form-group">
						<form:label path="version">Version:</form:label> <form:input type="number" path="version"
							class="form-control" id="version" name="version" readonly="true" />
							
					</div>
					<div class="form-group">
						<form:label path="libelle">Libellé:</form:label> <form:input type="text" path="libelle"
							class="form-control" id="libelle" name="libelle"/>
						<form:errors path="libelle" element="span" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<form:label path="quest">Code Quest:</form:label> <form:input type="number" path="quest"
							class="form-control" id="quest" name="quest"/>
						<form:errors path="quest" element="span" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label for="idFiliere">Filière:</label>
						<select id="idFiliere" name="idFiliere" class="form-control">
							<option value="">Veuillez sélectionner une filière</option>
							<c:forEach items="${filieres}" var="fil">
								<option value="${fil.id}">${fil.id} - ${fil.libelle}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="card-footer">
					<div class="btn-group btn-group-lg float-right">
						<c:url value="/matiere/cancel" var="cancelUrl"/>
						<button type="submit" class="btn btn-success"><i class="bi bi-check-square-fill"></i></button>
						<a href="${cancelUrl}" class="btn btn-warning"><i class="bi bi-backspace-fill"></i></a>
					</div>
				</div>
			</form:form>
		</div>

	</div>

</body>
</html>