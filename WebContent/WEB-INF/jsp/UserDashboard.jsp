<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="edu.ben.bu_club_central.models.User"%>
<%@ page import="edu.ben.bu_club_central.daos.UserDao"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
<head>
<!-- Site Title-->
<title>Events</title>

<meta name="format-detection" content="telephone=no">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="keywords" content="intense web design multipurpose template">
<meta name="date" content="Dec 26">
<link rel="icon" type="image/png" href="img/favicon-16x16.png"
	sizes="16x16" />
<!-- Stylesheets-->
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Ubuntu:400,400italic,500,700,700italic">
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]-->
</head>
<body>
	<!-- Page-->
	<div class="page text-center">
		<!-- Page Head-->
		<header class="page-head slider-menu-position"> <!-- RD Navbar Transparent-->
		<div class="rd-navbar-wrap">
			<nav data-md-device-layout="rd-navbar-fixed"
				data-lg-device-layout="rd-navbar-static"
				class="rd-navbar container rd-navbar-floated rd-navbar-dark"
				data-lg-auto-height="true" data-md-layout="rd-navbar-fixed"
				data-lg-layout="rd-navbar-static" data-lg-stick-up="true">
			<div class="rd-navbar-inner">
				<!-- RD Navbar Top Panel-->
				<div class="rd-navbar-top-panel context-dark bg-danger"></div>
				<!-- RD Navbar Panel -->
				<div class="rd-navbar-panel">
					<!-- RD Navbar Toggle-->
					<button data-rd-navbar-toggle=".rd-navbar, .rd-navbar-nav-wrap"
						class="rd-navbar-toggle">
						<span></span>
					</button>
					<!-- RD Navbar Top Panel Toggle-->
					<button data-rd-navbar-toggle=".rd-navbar, .rd-navbar-top-panel"
						class="rd-navbar-top-panel-toggle">
						<span></span>
					</button>
					<!--Navbar Brand-->

				</div>
				<div class="rd-navbar-menu-wrap">
					<div class="rd-navbar-nav-wrap">
						<div class="rd-navbar-mobile-scroll">
							<!--Navbar Brand Mobile-->

							<div class="form-search-wrap">
								<!-- RD Search Form-->
								<form action="search-results.html" method="GET"
									class="form-search rd-search">
									<div class="form-group">
										<label for="rd-navbar-form-search-widget"
											class="form-label form-search-label form-label-sm">Search</label>
										<input id="rd-navbar-form-search-widget" type="text" name="s"
											autocomplete="off"
											class="form-search-input input-sm form-control form-control-gray-lightest input-sm" />
									</div>
									<button type="submit" class="form-search-submit">
										<span class="mdi mdi-magnify"></span>
									</button>
								</form>
							</div>
							<!-- RD Navbar Nav-->
							<ul class="rd-navbar-nav">

								<li class=""><a href="HomeServlet"><span>Home</span></a></li>
								<li><a href="EventServlet"><span>Events</span></a></li>
								<li><a href="ClublistServlet"><span>clubs</span></a></li>

								<li><a href="MeetTheAdminsServlet"><span>About
											Us</span></a></li>
								<li><a href="ContactUsServlet"><span>Contact Us</span></a>
								 <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="LoginSevlet"><%
					if (session.getAttribute("user") == null) {
 						%> <a  href="LoginServlet"> Sign In <%
 					} else {
 							%> <%=((User) session.getAttribute("user")).getFirst_name()%>
 							  <span class="caret"></span></a>
 							
											<%
					}
											%>
      
        <ul class="dropdown-menu">
        
 							    <li><a href="LogoutServlet"><span class="text-danger">logout</span></a>
 							
      
        
          
        </ul>
      </li>
								
								
                      
                          </ul>
						</div>
					</div>
					<!--RD Navbar Search-->
					<div class="rd-navbar-search rd-navbar-search-top-panel">
						<a data-rd-navbar-toggle=".rd-navbar-inner,.rd-navbar-search"
							href="#" class="rd-navbar-search-toggle mdi"><span></span></a>
						<form action="search-results.html" method="GET"
							class="rd-navbar-search-form search-form-icon-right rd-search">
							<div class="form-group">
								<label for="rd-navbar-search-form-input" class="form-label">Type
									and hit enter...</label> <input id="rd-navbar-search-form-input"
									type="text" name="s" autocomplete="off"
									class="rd-navbar-search-form-input form-control form-control-gray-lightest" />
							</div>
						</form>
					</div>
				</div>
			</div>
			</nav>
		</div>
		<div class="context-dark"></div>
		</header>

		<div class="container">
			<div class="row" style="height: 200px; background: black"></div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-lg-12" style="height: 500px">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>

						</ol>

						<h1>Upcoming Events</h1>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="img/snowBU2.jpg" alt="Chania">
							</div>

							<div class="item">
								<img src="img/kindlonSnowy.jpg" alt="Chania">
							</div>

							<div class="item">
								<img src="img/snowyBU.jpg" alt="Flower">
							</div>


						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" role="button"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>


				</div>
			</div>
		</div>


		<div class="container">
			<div class="row">
				<div class="col" style="height: 300px"></div>
			</div>
		</div>








		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1>Messages</h1>
						</div>
						<div class="panel-body"></div>
						<div>

							<!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active"><a href="#inbox"
									aria-controls="inbox" role="tab" data-toggle="tab">Inbox</a></li>
								<li role="presentation"><a href="#sent"
									aria-controls="sent" role="tab" data-toggle="tab">Sent</a></li>

							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="inbox">
									inbox that displays all messages</div>
								<div role="tabpanel" class="tab-pane" id="sent">send
									messages to other users</div>

							</div>

						</div>



					</div>
				</div>


				<div class="col-lg-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1>Club Central</h1>
						</div>
						<div class="panel-body"></div>
						<div>

							<!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active"><a href="#activeClubs"
									aria-controls="activeClubs" role="tab" data-toggle="tab">Active Clubs</a></li>
								<li role="presentation"><a href="#editClubs"
									aria-controls="editClubs" role="tab" data-toggle="tab">Edit Clubs</a></li>
								
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="activeClubs">
									Display clubs that you are in
								</div>
								<div role="tabpanel" class="tab-pane" id="editClubs">
									tab to where you request to join club or leave club
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>















		<!-- Page Footer-->
		<footer
			class="section-relative section-top-66 section-bottom-34 page-footer bg-gray-base context-dark">
		<div class="shell">
			<div class="range range-sm-center text-lg-left">
				<div class="cell-sm-12">
					<div class="range range-xs-center">
						<div
							class="cell-xs-10 cell-sm-3 text-left cell-sm-push-4 cell-sm-10 cell-lg-3 offset-sm-top-50 offset-lg-top-0 cell-lg-push-2">
							<!-- Twitter Feed-->
							<p
								class="text-uppercase text-spacing-60 text-bold text-center text-lg-left">Twitter
								Feed</p>
							<div class="offset-top-20">
								<div data-twitter-username="templatemonster"
									data-twitter-date-hours=" hours ago"
									data-twitter-date-minutes=" minutes ago" class="twitter">
									<div data-twitter-type="tweet" class="twitter-sm">
										<div class="twitter-date text-dark small">
											<span class="icon icon-xxs mdi mdi-twitter text-middle"></span>
											<span data-date="text" class="text-middle"></span>
										</div>
										<div data-tweet="text" class="twitter-text"></div>
										<div data-screen_name="text"
											class="twitter-name text-bold big"></div>
									</div>
									<div data-twitter-type="tweet" class="twitter-sm">
										<div class="twitter-date text-dark small">
											<span class="icon icon-xxs mdi mdi-twitter text-middle"></span>
											<span data-date="text" class="text-middle"></span>
										</div>
										<div data-tweet="text" class="twitter-text"></div>
										<div data-screen_name="text"
											class="twitter-name text-bold big"></div>
									</div>
								</div>
							</div>
						</div>


						<div
							class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
							<!-- Footer brand-->
							<div class="footer-brand">
								<a href="../index.html"><img width='175' height='50'
									src='img/logo_benedictinetransparentwhite.png' alt='' /></a>
							</div>
							<div class="offset-top-50 text-xs-center text-lg-left">
								<ul class="list-inline">
									<li><a href="https://www.facebook.com/BenedictineUniversity/" target="_blank"
										class="icon fa fa-facebook icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a href="https://twitter.com/BenU1887" target="_blank"
										class="icon fa fa-twitter icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a href="https://plus.google.com/106737408889171586664" target="_blank"
										class="icon fa fa-google-plus icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a href="https://www.linkedin.com/edu/benedictine-university-18245" target="_blank"
										class="icon fa fa-linkedin icon-xxs icon-circle icon-darkest-filled"></a></li>
								</ul>
							</div>
							<p class="text-darker offset-top-20">
								The F.I.R.M &copy; <span id="copyright-year"></span> . <a
									href="#">Privacy Policy</a>
								<!-- {%FOOTER_LINK}-->
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		</footer>
	</div>



	<!-- Java script-->
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>
</html>