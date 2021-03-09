//menu lateral filtro
function openFil() {
    closeOrd()
    document.getElementById("sideFilter").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}
function closeFil() {
    document.getElementById("sideFilter").style.width = "0";
    document.getElementById("main").style.marginLeft = "auto";
}

//menu lateral Orden
function openOrd() {
    closeFil()
    document.getElementById("sideOrder").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}
function closeOrd() {
    document.getElementById("sideOrder").style.width = "0";
    document.getElementById("main").style.marginLeft = "auto";
}

//Like & dislike
function like(){
	
	if($('#like').css('display') === 'block') {
		//do something
		document.getElementById("dislike").style.display = "block";
		document.getElementById("like").style.display = "none";
	} else {
		document.getElementById("dislike").style.display = "none";
		document.getElementById("like").style.display = "block";
	}
}
/*function dislike(){
    document.getElementById("titelAll").style.display = "none";
}*/


//Geolocalizacion
/*
function localizar(){
	var content = document.getElementById("geolocation-test");

	if (navigator.geolocation)
	{
		navigator.geolocation.getCurrentPosition(function(objPosition)
		{
			var lon = objPosition.coords.longitude;
			var lat = objPosition.coords.latitude;

			content.innerHTML = "<p><strong>Latitud:</strong> " + lat + "</p><p><strong>Longitud:</strong> " + lon + "</p>";

		}, function(objPositionError)
		{
			switch (objPositionError.code)
			{
				case objPositionError.PERMISSION_DENIED:
					content.innerHTML = "No se ha permitido el acceso a la posición del usuario.";
				break;
				case objPositionError.POSITION_UNAVAILABLE:
					content.innerHTML = "No se ha podido acceder a la información de su posición.";
				break;
				case objPositionError.TIMEOUT:
					content.innerHTML = "El servicio ha tardado demasiado tiempo en responder.";
				break;
				default:
					content.innerHTML = "Error desconocido.";
			}
		}, {
			maximumAge: 75000,
			timeout: 15000
		});
	}
	else
	{
		content.innerHTML = "Su navegador no soporta la API de geolocalización.";
	}
}*/

