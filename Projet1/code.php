<?php

if (isset($_GET['login'])) {
	$login = $_GET['login'];

	$url = "https://webapplis.utc.fr/Edt_ent_rest/myedt/result?login=".$login;

	$json = file_get_contents($url);
	echo $json;
}
?>
