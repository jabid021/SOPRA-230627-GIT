<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hopital.model.*" %>	
<%@ page import="hopital.context.Singleton" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
out.println(request.getMethod());

Integer id = Integer.parseInt(request.getParameter("id"));	
Patient  p = Singleton.getInstance().getDaoPatient().findById(id);

%>

	<h1>Fiche du patient <%= id %></h1>
	<table border>
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
		</tr>


	<% 
	if(p==null)
	{
		out.println("<tr><td colspan='2'>CE PATIENT N'EXISTE PAS</td><tr>");
	} 
	else
	{
		out.println("<tr><td>"+p.getNom()+"</td><td>"+p.getPrenom()+"</td></tr>");
	}
	
	%>

	</table>



	<form action='fichePatientV2.jsp?id=1' method='post'>
		<input type='hidden' name='id' value='1'> 
		<input type='text' name='prenom' placeholder='Saisir prenom' value='prenom'> 
		<input type='text' name='nom' placeholder='Saisir nom' value='nom'> 
		<input type='submit' value='Modifier Patient'>
	</form>
	
	
	
	
</body>
</html>