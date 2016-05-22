<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" />
<title>Espace Admin</title>
</head>
<body>
<p>Bienvenue ${user.prenom} !</p> 
	<ul>
	    <li><a href="menu/questionnaires">Liste des questionnaires</a></li>
	</ul>
		<br> 
		<br> 
		<br> 
		<a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a> 

</body>
</html>