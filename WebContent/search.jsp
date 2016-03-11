<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="linkBootstrap.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Résultats de la recherche</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Résultat de la recherche </STRONG></U></FONT>
	</P> 
	<TABLE class="table table-bordered" >
		<CAPTION>Tableau des Oeuvres prétées</CAPTION>
		<TR>
			<TH>Id</TH>
			<TH>Titre</TH>
			<TH>Etat Oeuvre</TH>
			<TH>Prix Oeuvre</TH>
			<TH>Id Proprio</TH>
			<TH>Nom Proprio</TH>
			<TH>Prenom Proprio</TH>

		</TR>
		<c:forEach items="${mesOeuvresPret}" var="item">
			<tr class="danger">
				<td>${item.idOeuvrepret}</td>
				<td>${item.titreOeuvrepret}</td>
				<td>Prêté</td>
				<td>Non vendable</td>
				<td>${item.proprietaire.idProprietaire}</td>
                <td>${item.proprietaire.nomProprietaire}</td>
                <td>${item.proprietaire.prenomProprietaire}</td>
			</tr>
		</c:forEach>
		<c:forEach items="${mesOeuvresVente}" var="item">
			<tr <c:if test="${item.etatOeuvrevente=='L'}"> class="success" </c:if>  class="warning">
				<td>${item.idOeuvrevente}</td>
				<td>${item.titreOeuvrevente}</td>
				<td>${item.etatOeuvrevente}</td>
				<td>${item.prixOeuvrevente}</td>
				<td>${item.proprietaire.idProprietaire}</td>
                <td>${item.proprietaire.nomProprietaire}</td>
                <td>${item.proprietaire.prenomProprietaire}</td>
			</tr>
		</c:forEach>
	</TABLE>
	<TABLE class="table table-bordered" >
		<CAPTION>Tableau des Adhérents</CAPTION>
		<TR>
			<TH>Numero</TH>
			<TH>Nom</TH>
			<TH>Prénom</TH>
			<TH>Ville</TH>

		</TR>

		<c:forEach items="${mesAdherents}" var="item">
			<tr>
				<td>${item.idAdherent}</td>
				<td>${item.nomAdherent}</td>
				<td>${item.prenomAdherent}</td>
                <td>${item.villeAdherent}</td>
			</tr>
		</c:forEach>
	</TABLE>
</body>
</html>