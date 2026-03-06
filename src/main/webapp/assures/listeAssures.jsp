<%@ page import="java.util.List" %>
<%@ page import="com.esocial.model.Assure" %>

<h2>Liste des Assurés</h2>

<table>

<tr>
<th>ID</th>
<th>Nom</th>
<th>Salaire</th>
<th>Employeur</th>
</tr>

<%

List<Assure> list = (List<Assure>) request.getAttribute("assures");

for(Assure a : list){

%>

<tr>

<td><%= a.getId() %></td>
<td><%= a.getNom() %></td>
<td><%= a.getSalaire() %></td>
<td><%= a.getEmployeurId() %></td>

</tr>

<% } %>

</table>
