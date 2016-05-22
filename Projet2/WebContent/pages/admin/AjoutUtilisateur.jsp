<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout d'un nouvel utilisateur</title>
</head>
<body>
	<h2>Ajout d'une nouvel Utilisateur</h2>
	<br> 
	<br>  
	<table>
	<tr>
		<td>Login : </td>
		<td><input type="text" name="login"></td> 
	</tr>
	<tr>
		<td>Mot de passe:</td> 
		<td><input type="password" name="mdp"></td> 
	</tr>
	<tr>
		<td>Nom:</td> 
		<td> <input type="text" name="nom"> </td> 
	</tr>
	<tr>
		<td>Prénom:</td> 
		<td> <input type="text" name="prenom"> </td> 
	</tr>
	<tr>
		<td>Société:</td> 
		<td> <input type="text" name="societe"> </td> 
	</tr>
	<tr>
		<td>Téléphone:</td> 
		<td> <input type="text" name="telephone"> </td> 
	</tr>
	<tr>
		<td>Email:</td> 
		<td> <input type="text" name="email"> </td> 
	</tr>
	<tr>
		<td>
			<input type="checkbox" id="cbox1" value="admin"> <label for="cbox1">Administrateur</label> 
			<input type="checkbox" id="cbox2" value="stagiaire"> <label for="cbox2">Stagiaire</label> 
		</td> 
	</tr>
	</table>
	<br> 
	<br> 
	<br> 
	<input type="button" value="Retour"> <input type="button" value="Valider">
</body>
</html>
