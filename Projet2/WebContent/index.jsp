<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projet Global</title>
</head>
<body>
	<form name="login" action="ServletValideLogin.java" method="post">
	    
	        <label for="user">User</label>
	        <input type="text" name="user" required>
	        <label for="password">Mot de passe</label>
	        <input type="password" name="password" required>
	        <input type="submit" value="Login">
	</form>
</body>
</html>