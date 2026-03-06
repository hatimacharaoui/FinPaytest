<%@ page import="java.util.List" %>
<%@ page import="com.esocial.model.Employeur" %>
<html>

<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<h2>Liste des Employeurs</h2>

<table>

<tr>
<th>ID</th>
<th>Raison Sociale</th>
<th>Secteur</th>
</tr>

<%

List<Employeur> list = (List<Employeur>) request.getAttribute("employeurs");

for(Employeur e : list){

%>

<tr>

<td><%= e.getId() %></td>
<td><%= e.getRaisonSociale() %></td>
<td><%= e.getSecteurActivite() %></td>

</tr>

<% } %>

</table>
</body>
</html>
