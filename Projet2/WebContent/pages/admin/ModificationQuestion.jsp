<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification de la question</title>
</head>
<body>
	<h2>Modification de la question</h2> 
	<br>  
	<table>
		<tr>
			<td>Nouvelle Question :</td>
			<td><input type="text" name="question"></input></td>
		</tr>
		<tr>
			<td>Réponse vraie :</td>
			<td><input type="text" name="true"></input></td>
		</tr>
		<tr>
			<td>Réponse fausse 1:</td>
			<td><input type="text" name="false1"></input></td>
		</tr>
		<tr>
			<td>Réponse fausse 2:</td>
			<td><input type="text" name="false2"></input></td>
		</tr>
		<tr>
			<td>Réponse fausse 3:</td>
			<td><input type="text" name="false3"></input></td>
		</tr>
		</table>
	<br> 
	<br> 
	<br> 
	<input type="button" value="Retour"> <input type="button" value="Valider">
</body>
</html>
