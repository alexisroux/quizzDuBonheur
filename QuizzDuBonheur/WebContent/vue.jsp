<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="style_annuaire.css"/>
		<script defer type="text/javascript" src="model.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
	<form action="ControlerServlet" method="get">
		<input type="text" name="theme" value="histoire" />
		<c:if test="${bean.theme}">
			<p>${bean.theme}</p>
		</c:if>

		<c:forEach var="i" items="${bean.liste}">
			<p>
				<c:out value="${i.intitule}" />
			</p>
			<input onclick="this.style='background-color:green'" type="radio" name="reponse" value="${i.bonne_rep}"id="${i.bonne_rep}" /><label for="${i.bonne_rep}"><c:out value="${i.bonne_rep}" /></label><br />
			<input type="radio" name="reponse" value="${i.mauv_rep1}"id="${i.mauv_rep1}" />	<label for="${i.mauv_rep1}"><c:out value="${i.mauv_rep1}" /></label><br />
			<input type="radio" name="reponse" value="${i.mauv_rep2}"id="${i.mauv_rep2}" />	<label for="${i.mauv_rep2}"><c:out value="${i.mauv_rep2}" /></label><br />
			<input type="radio" name="reponse" value="${i.mauv_rep3}"id="${i.mauv_rep3}" />	<label for="${i.mauv_rep3}"><c:out value="${i.mauv_rep3}" /></label><br />
		</c:forEach>
		<input type="submit" value="Valider" />
		
	</form>
</body>
</html>