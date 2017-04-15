<!DOCTYPE html>
<html lang="en">
<head>
	<meta charsset="UTF-8">
	<title>nodeLightes</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<script>
		$(document).ready(function()
		{
			$('#get').click(function()
			{
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function(){
					if (this.readyState == 4 && this.status == 200) {
					document.getElementById("servedRes").innerHTML += this.responseText + "<br>";
					}
				};
				xhttp.open("GET", "/light13", true);
				xhttp.send();
			});
			$('.lightSelect').click(function()
                        {
				//document.getElementById("servedRes").innerHTML += this.value + "<br>";
                                var xhttp = new XMLHttpRequest();
                                xhttp.onreadystatechange = function(){
                                        if (this.readyState == 4 && this.status == 200) {
                                        document.getElementById("servedRes").innerHTML += this.responseText + "<br>";
                                        }
                                };
                                xhttp.open("POST", "/light13", true);
				xhttp.setRequestHeader("Content-type", "application/json");
                                var obj = { "lightNum":this.value };
				var JsonObj = JSON.stringify(obj);
				xhttp.send(JsonObj);
                        });
		});
	</script>
	<script>
	function getTime()
	{
		var d = new Date();
		var day = d.getDay() + 1;
		var month = d.getMonth() + 1;
		var year = d.getFullYear();
		document.getElementById("timeShow").innerHTML = d
	}

	</script>
</head>

<body onload = "getTime()">

<h1 id = "timeShow">The date didnt work:(</h1>
<button type = "button" id = "get" value = "get">Get this</button>
<br>
<button type = "button" id = "button01" class = "lightSelect" value = "11">Post 1 </button>
<br>
<button type = "button" id = "button02" class = "lightSelect" value = "10">Post 2</button>
<br>
<button type = "button" id = "button03" class = "lightSelect" value = "22">Post 3</button>
<br>
<button type = "button" id = "button04" class = "lightSelect" value = "17">Post 4</button>
<br>
<button type = "button" id = "button01" class = "lightSelect" value = "09">Post 5</button>
<br>
<button type = "button" id = "button02" class = "lightSelect" value = "04">Post 6</button>
<br>
<button type = "button" id = "button03" class = "lightSelect" value = "03">Post 7</button>
<br>
<button type = "button" id = "button04" class = "lightSelect" value = "02">Post 8</button>
<br>
<button type = "button" id = "clear">Clear Console<button>

<div id = "respInfo">
	<h3>Response from server</h3>
	<div id = "servedRes">
	</div>
</div>


</body>
</html>
