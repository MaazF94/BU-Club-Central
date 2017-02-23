<!DOCTYPE HTML>


<%@ page import="edu.ben.bu_club_central.models.User"%>
<!--
	Introspect by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Introspect by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="inner">
					<a href="index.html" class="logo">introspect</a>
					<nav id="nav">
						<a href="HomeServlet">Home</a>
						<a href="generic.html">Clubs</a>
						<a href="LoginServlet">
							<%	if (session.getAttribute("user") == null) {
									%> Sign In <%
								} else {
							%>
							<%=((User) session.getAttribute("user")).getFirst_name()%>
							<%
								}
							%>
						
						</a>
					</nav>
				</div>
			</header>
			<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

		
		
		
		  <div class="container col-lg-6" align="center" >
    <form class="form-signin" method="POST" action="LoginServlet">       
      <h2 class="form-signin-heading">Please login</h2>
      <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
    </form>
  </div>
		
		
		<div class="container">
			<div class="row">
				<button>Register</button>
			</div>
		</div>
		
		
		
		
		
		
		
		


		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>