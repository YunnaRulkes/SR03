<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Espace Participant</title>
</head>
<body>
	<c:choose>
	    <c:when test="${user eq null}">
	        <jsp:forward page="erreur.jsp" />
	    </c:when>
	    <c:otherwise>
	        <p>Bienvenue ${user.prenom} !</p>
	        <ul>
				<li>Liste des questionnaires</li>
				<li>Résultats obtenus</li>
			</ul>
	    </c:otherwise>
	</c:choose>
</body>
</html>