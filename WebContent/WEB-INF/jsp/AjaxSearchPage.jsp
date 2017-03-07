<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ page import="servlets.SearchPageServlet"%>
	<%@ page import="java.util.*"%>
	<%@ page import="edu.ben.bu_club_central.models.Events"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	var request = new XMLHttpRequest();
	function searchInfo() {
		var name = document.vinform.name.value;
		var url = "/Club-Central/SearchPageServlet?val=" + name;

		try {
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					var val = request.responseText;
					document.getElementById('mylocation').innerHTML = val;
				}
			}//end of function  
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
</script>
</head>
<body>
	<h1>Search for an Event</h1>
	<form name="vinform">
		<input type="text" name="name" onkeyup="searchInfo()">
	</form>

	<span id="mylocation"></span>
	
	
	


















</body>
</html>
