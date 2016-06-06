<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="vue.css"/>
		<script defer type="text/javascript" src="script.js"></script>
		<title>Le quizz du bonheur</title>
	</head>
	<body>
	<div id = choix>
	<form action="ControlerServlet" method="get">
	<p> Choisis ton theme ${login} : </p>
	<div class = "styled-select"> 
		<select name="theme">
			<option>histoire</option>
			<option>geographie</option>
		</select>
		</div>
			<input type="submit" name="choisir" value="Choisir" />
</div>

		<c:forEach var="i" items="${bean.liste}">
			<p>
				<c:out value="${i.intitule}" />
			</p>
			<section id="radioZone">
				<input type="radio" name="reponse${i}" value="${i.bonne_rep}"id="${i.bonne_rep}" class="bonne_rep" />  <label for="${i.bonne_rep}"><c:out value="${i.bonne_rep}" /></label><br />
				<input type="radio" name="reponse${i}" value="${i.mauv_rep1}"id="${i.mauv_rep1}" class="mauv_rep1"/>	<label for="${i.mauv_rep1}"><c:out value="${i.mauv_rep1}" /></label><br />
				<input type="radio" name="reponse${i}" value="${i.mauv_rep2}"id="${i.mauv_rep2}" class="mauv_rep2"/>	<label for="${i.mauv_rep2}"><c:out value="${i.mauv_rep2}" /></label><br />
				<input type="radio" name="reponse${i}" value="${i.mauv_rep3}"id="${i.mauv_rep3}" class="mauv_rep3" />	<label for="${i.mauv_rep3}"><c:out value="${i.mauv_rep3}" /></label><br />
			</section>
		</c:forEach>
		<input type="submit" value="Valider" onclick="validator()"/>
	</form>
</body>
</html>