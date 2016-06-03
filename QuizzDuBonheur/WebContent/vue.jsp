<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ControlerServlet" method="get">
<input type="text" name="theme" value="${bean.theme}"/>


<c:forEach var="i" items="${bean.liste}" >
   <c:out value="${i.intitule}"/>
   <c:out value="${i.bonne_rep;}"/>
   <c:out value="${i.mauv_rep1;}"/>
   <c:out value="${i.mauv_rep2;}"/>
   <c:out value="${i.mauv_rep3;}"/>
</c:forEach>


<input type="submit" value="+"/>
</form>
</body>
</html>