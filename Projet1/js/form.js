$(document).ready(function() {
        createTable();
});
function checkServer() {
	$.ajax({
		url: "https://webapplis.utc.fr",
		dataType: "jsonp",
		statusCode: {
		    200: function (response) {
		        alert('Serveur disponible');
		    },
		    404: function (response) {
		        alert('Serveur indisponible ');
	            }
		}
	    });
}

function getData(success){
	var httpRequest = new XMLHttpRequest();

	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState === 4) {
			if (httpRequest.status === 200) {
				success(httpRequest.responseText);
			}
		}
	};
	httpRequest.open('GET', "code.php?login=" + $('#login').val() , true);
	httpRequest.send();
}

function valide() {
	$("form").on("submit", function (event) {
		event.preventDefault();
		event.stopImmediatePropagation();
		if( ! $("#login").val() || $("#login").val().length != 8) {
			alert("Login invalid");
			$("#login").focus();
		}
		else {
			getData(function(response){
				fillTable(response, createTable());
			});
		}
		//return false
	});
}

function createTable() {
	if(typeof timetable == 'undefined'){
		var timetable = new Timetable();
		timetable.setScope(8,20); //la ligne du temps
		timetable.addLocations(['Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi']);

		var renderer = new Timetable.Renderer(timetable);
		renderer.draw('.timetable');
	}
	return timetable;
}
function fillTable(data, timetable) {
	if(data != null){
		var data = JSON.parse(data);
			for (var i = 0; i < data.length; i++) {
				var event = data[i];
				console.log(event);
				timetable.addEvent(event.uv+" "+event.type, 
						   capitalizeFirstLowerRest(event.day),
						   new Date(2016,4,8,event.begin.split(":")[0],event.begin.split(":")[1]),
						   new Date(2016,4,8,event.end.split(":")[0],event.end.split(":")[1])
						  );
				console.log(timetable);
					
			}
	}
	var renderer = new Timetable.Renderer(timetable);
        renderer.draw('.timetable');
}

function capitalizeFirstLowerRest(string) {
	return string.charAt(0).toUpperCase() + string.slice(1).toLowerCase();
}
