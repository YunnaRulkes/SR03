<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des utilisateurs</title>
</head>
<body>
	<br> 
	<br>  
	<input type="button" value="Ajouter"> 
	<input type="button" value="Supprimer"> 
	<br> 
	<br>  
	<form>
	<table>
	   <tr>
	  	   <th>Gestion des utilisateurs</th>
	   </tr>
	   <tr>
	   	   <td>ID</td>
	   	   <td>Login</td>
	   	   <td>Mot de Passe</td>
	   	   <td>Prénom</td>
	   	   <td>Nom</td>
	   	   <td>Societe</td>
	   	   <td>Telephone</td>
	   	   <td>Email</td>
	   	   <td>Date de Creation</td>
	   </tr>
	   <c:forEach var="usr" items="">
	   </c:forEach>
	   <tr>
	       <td><input type="checkbox" id="cbox1">  </td>
	       <td>Utilisateur x</td>
	   </tr>
	   <tr>
	       <td><input type="checkbox" id="cbox2"> </td>
	       <td>Utilisateur y</td>
	   </tr>
	</table>
	</form>
	<br> 
	<br> 
	<br> 
	<input type="button" value="Retour">
</body>
</html>
