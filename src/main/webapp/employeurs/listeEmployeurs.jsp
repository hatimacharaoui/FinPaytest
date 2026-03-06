<%@ page import="java.util.List" %>
<%@ page import="com.esocial.model.Employeur" %>

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
