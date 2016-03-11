<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="linkBootstrap.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Réserver une oeuvre</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Réserver une oeuvre </STRONG></U></FONT>
	</P> 
	<TABLE class="table table-bordered" >
		<CAPTION></CAPTION>
		<TR>
			<TH>Id</TH>
			<TH>Titre</TH>
			<TH>Prix Oeuvre</TH>
			<TH>Id Propri�taire</TH>
			<TH>Nom Propri�taire</TH>
			<TH>Prenom Propri�taire</TH>

		</TR>
		<c:forEach items="${mesOeuvresReservable}" var="item">
			<tr>
				<td>${item.idOeuvrevente}</td>
				<td>${item.titreOeuvrevente}</td>
				<td>${item.prixOeuvrevente}</td>
				<td>${item.proprietaire.idProprietaire}</td>
                <td>${item.proprietaire.nomProprietaire}</td>
                <td>${item.proprietaire.prenomProprietaire}</td>
			</tr>
		</c:forEach>
	</TABLE>
</body>
</html>