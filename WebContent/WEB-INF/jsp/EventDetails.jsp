<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ page import="edu.ben.bu_club_central.models.User"%>
<%@ page import="edu.ben.bu_club_central.models.Events"%>
<%@ page import="edu.ben.bu_club_central.models.Club"%>
<%@ page import="edu.ben.bu_club_central.models.Comment"%>
<%@ page import="edu.ben.bu_club_central.models.Post"%>
<%@ page import="edu.ben.bu_club_central.daos.UserDao"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubDao"%>
<%@ page import="edu.ben.bu_club_central.daos.EventsDao"%>
<%@ page import="edu.ben.bu_club_central.daos.PostDao"%>
<%@ page import="edu.ben.bu_club_central.daos.CommentDao"%>
<%@ page import="java.util.*"%>
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
				class="rd-navbar rd-navbar-default rd-navbar-transparent"
				data-lg-auto-height="true" data-md-layout="rd-navbar-fixed"
				data-lg-layout="rd-navbar-static" data-lg-stick-up="true">
			<div class="rd-navbar-inner">
				<!-- RD Navbar Panel-->
				<div class="rd-navbar-panel">
					<!-- RD Navbar Toggle-->
					<button data-rd-navbar-toggle=".rd-navbar, .rd-navbar-nav-wrap"
						class="rd-navbar-toggle">
						<span></span>
					</button>
					<!--Navbar Brand-->
					<div class="rd-navbar-brand">
						<a href="index.html"><img class='img-responsive' width='40'
							height='30' src='img/BURedTransparent.png' alt='' /></a>
					</div>
				</div>

				<div class="rd-navbar-menu-wrap">
					<div class="rd-navbar-nav-wrap">
						<div class="rd-navbar-mobile-scroll">

							<!--Navbar Brand Mobile-->
							<div class="rd-navbar-mobile-brand">
								<a href="index.html"><img class='img-responsive' width='238'
									height='30' src='img/BUred.png' alt='' /></a>
							</div>
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
								<li><a class="" href="LoginServlet"><span> <%
 	if (session.getAttribute("user") == null) {
 %> Sign In <%
 	} else {
 %> <%=((User) session.getAttribute("user")).getFirst_name()%> <%
 	}
 %>


									</span></a></li>

							</ul>
						</div>
					</div>
					<!--RD Navbar Search-->

				</div>
			</div>
			</nav>
		</div>
		<div class="context-dark">
			<!-- Modern Breadcrumbs-->
			<section class="breadcrumb-modern rd-parallax bg-gray-darkest">
			<div data-speed="0.2" data-type="media"
				data-url="images/background-04-1920x750.jpg"
				class="rd-parallax-layer"></div>
			<div data-speed="0" data-type="html" class="rd-parallax-layer">
				<div class="shell section-top-98   "></div>
			</div>
			</section>
		</div>
		</header>
		<!-- End of header -->
		<main class="page-content"> <!--  This is where the the page contents that you are adding should go -->

		<div class="row">
			<div class="jumbotron" style="background-color: white">
				<%
					ClubDao clubDao = new ClubDao();
					EventsDao eventDao = new EventsDao();
					Events event = eventDao.getEventByEventId(Integer.parseInt(request.getParameter("eventId")));
				%>
				<h1><%=event.getEvent_name()%></h1>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">


				<table class="table table-striped">
					<thead>
						<tr>
							<th>Description</th>
							<th>Location</th>
							<th>People Going</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%=event.getDescription()%></td>
							<td><%=event.getLocation()%></td>
							<td><%=event.getRsvp_count()%></td>
							<td>
								<form action="RSVPServlet" method="POST">

									<button class="btn btn-default " type="submit" name="eventId"
										value="<%=Integer.parseInt(request.getParameter("eventId"))%>">RSVP</button>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="container">
				<div class="col-lg-4"></div>
				<div class="col-sm-4 well">
					<form action="CommentServlet" method="POST">
						<textarea class="form-control"
							onkeyup="textCounter(this,'counter',250);" rows="4" cols="30"
							name="comment"
							placeholder="Enter your comment here... 250 Characters max"></textarea>

						<button class="btn btn-Info " type="submit"
							name="commentId_eventId"
							value="<%=Integer.parseInt(request.getParameter("eventId"))%>">Comment
						</button>
						<h6 class="pull-right">
							<input disabled maxlength="1" size="1" value="250" id="counter">
							Remaining
						</h6>
					</form>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="container" style="height:100px">
				<div class="col-lg-12"></div>
			</div>
		</div>

		<div class="row">
			<div class="container">
				<div class="col-lg-12">
								<table class="table table-striped">
									<tbody
										style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display: block">


										<%
											UserDao userDao = new UserDao();
												User user;
												LinkedList<Comment> commentList = new LinkedList<Comment>();
												CommentDao commentDao = new CommentDao();
												commentList = commentDao.getCommentsByEventId(Integer.parseInt(request.getParameter("eventId")));
												int commentListIndex = 0;
												int commentListSize = commentList.size();
										%>

										<%
											while (commentListIndex < commentListSize) {
										%>
										<tr>
											<td class="col-lg-12">
												<%
													user = userDao.getUserByIdNum(commentList.get(commentListIndex).getUserId());
												%> By: <%=user.getFirst_name()%><br> <%=commentList.get(commentListIndex).getComment()%>
											</td>
										</tr>
										<%
											commentListIndex++;
										%>
										<%
											}
										%>
									</tbody>
								</table>


							</div>





			</div>
		</div>






















		</main>
		<!--End of main page content -->






























		<!-- Page Footer-->
		<footer
			class="section-relative section-top-66 section-bottom-34 page-footer bg-gray-base context-dark">
		<div class="shell">
			<div class="range range-sm-center text-lg-left">
				<div class="cell-sm-12">
					<div class="range range-xs-center">


						<div
							class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">






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
									href="privacy.html">Privacy Policy</a>
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


	<script>
		function textCounter(field, field2, maxlimit) {
			var countfield = document.getElementById(field2);
			if (field.value.length > maxlimit) {
				field.value = field.value.substring(0, maxlimit);
				return false;
			} else {
				countfield.value = maxlimit - field.value.length;
			}
		}
	</script>
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>

</html>