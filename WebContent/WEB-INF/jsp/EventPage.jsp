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
<%@ page import="edu.ben.bu_club_central.daos.EventRSVPListDao"%>
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
						<a href="HomeServlet"><img class='img-responsive' width='40'
							height='30' src='img/BURedTransparent.png' alt='' /></a>
					</div>


					<div class="rd-navbar-menu-wrap">
						<div class="rd-navbar-nav-wrap">
							<div class="rd-navbar-mobile-scroll">


								<!--Navbar Brand Mobile-->
								<div class="rd-navbar-mobile-brand">
									<a href="HomeServlet"><img class='img-responsive'
										width='238' height='30' src='img/BUred.png' alt='' /></a>
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
									<li><a href="ClublistServlet"><span>Clubs</span></a></li>

									<li><a href="MeetTheAdminsServlet"><span>About
												Us</span></a></li>
									<li><a href="ContactUsServlet"><span>Contact Us</span></a>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="LoginSevlet"> <%
 	if (session.getAttribute("user") == null) {
 %> Sign In <%
 	} else {
 %> <%=((User) session.getAttribute("user")).getFirst_name()%>
											<span class="caret"></span>
									</a> <%
 	}
 %>

										<ul class="dropdown-menu">
											<li><a href="LogoutServlet"><span
													class="text-danger">logout</span></a>
										</ul></li>



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

		<main class="page-content"> <!--  This is where the the page contents that you are adding should go -->

		<!-- Page Contents-->
		<div class="jumbotron" style="background-color: white">
			<!-- Page Contents-->
			<div class="jumbotron" style="background-color: white">
				<h1>Events Page</h1>

			</div>
			<div class="row" style="height: 500px">
				<div class="container">
					<div class="col-lg-12">
						<div class="jumbotron" style="background-color: white">
							<h2>Search for an Event</h2>
							<form name="vinform">
								<input placeholder="Enter title of event" type="text"
									name="name" onkeyup="searchInfo()">
							</form>


						</div>
					</div>
				</div>

				<div class="row">
					<div class="container">
						<div class="col-4-lg"></div>

						<div class="col-4-lg">
							<table class="table table-hover" >
								<thead>
									<tr>
										<td></td>
										<td></td>
										<td>Event name <span class="glyphicon glyphicon-calendar"></span></td>
										<td>Event Location <span class="glyphicon glyphicon-globe"></span></td>
										<td></td>
									</tr>
								</thead>
								<tbody id="mylocation">

								</tbody>

							</table>
						</div>

					</div>
				</div>






			</div>
			<div class="row">
				<h3>Event List</h3>
				<div class="container col-lg-12">


					<%
						EventsDao eventDao = new EventsDao();
						LinkedList<Events> eventList = new LinkedList<Events>();

						eventList = eventDao.getAllEvents();
						int eventListSize = eventList.size();
						int eventListIndex = 0;
						ClubDao cDao = new ClubDao();
					%>
					<%
						while (eventListIndex < eventListSize) {
					%>

					<div class="container">

						<div class="col-lg-3"></div>
						<table class="table table-hover col-lg-6">
							<thead>
								<tr>
									<th>Event Title</th>
									<th>Event Location</th>
									<th>People Going</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>

									<td><%=eventList.get(eventListIndex).getEvent_name()%></td>
									<td><%=eventList.get(eventListIndex).getLocation()%></td>
									<td><%=eventList.get(eventListIndex).getRsvp_count()%></td>
									<td><form action="EventDetailsServlet" method="GET">

											<button class="btn btn-default " type="submit" name="eventId"
												value="<%=eventList.get(eventListIndex).getEventId()%>">More
												Info</button>
										</form></td>
									
									<%EventRSVPListDao rsvpDao = new EventRSVPListDao(); 
										
										boolean rsvpBoolean = rsvpDao.checkUserRsvpForEvent(eventList.get(eventListIndex).getEventId(), ((User)session.getAttribute("user")).getId_num());
									%>
									
									<%if(!rsvpBoolean) { %>
										<td>
										<form action="RSVPServlet" method="POST">

											<button class="btn btn-default " type="submit" name="eventId"
												value="<%=eventList.get(eventListIndex).getEventId()%>">RSVP For Event</button>
										</form>
										</td>
									
									
									<%}else { %>
										<td>
											<form action="RSVPServlet" method="POST">

											<button disabled class="btn btn-default" type="submit" name="eventId"
												value="<%=eventList.get(eventListIndex).getEventId()%>">Already Going</button>
										</form>
										
										</td>
									
									<%} %>
									
								</tr>
							</tbody>
						</table>
					</div>

					<div class="container" style="height: 50px"></div>

				</div>

				<%
					eventListIndex++;
				%>
				<%
					}
				%>









			</div>
		</main>


		<!-- Page Footer-->
		<footer
			class="section-relative  section-bottom-34 page-footer bg-gray-base context-dark">

		<div class="shell">
			<div class="range range-sm-center text-lg-left">
				<div class="cell-sm-12">
					<div class="range range-xs-center">


						<div
							class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
							<!-- Footer brand-->
							<div class="offset-top-50 text-xs-center text-lg-left">
								<ul class="list-inline">
									<li><a
										href="https://www.facebook.com/BenedictineUniversity/"
										target="_blank"

										class="icon fa fa-facebook icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a href="https://twitter.com/BenU1887" target="_blank"
										class="icon fa fa-twitter icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a
										href="https://plus.google.com/106737408889171586664"
										target="_blank"
										class="icon fa fa-google-plus icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a
										href="https://www.linkedin.com/edu/benedictine-university-18245"
										target="_blank"
										class="icon fa fa-linkedin icon-xxs icon-circle icon-darkest-filled"></a></li>
								</ul>
                  </div>
                  <p class="text-darker offset-top-20">The F.I.R.M &copy; <span id="copyright-year"></span> . <a href="privacy.html">Privacy Policy</a>
                    <!-- {%FOOTER_LINK}-->
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </footer>
	</div>
	<!-- Global Mailform Output-->
	<div id="form-output-global" class="snackbars"></div>
	<!-- PhotoSwipe Gallery-->
	<div tabindex="-1" role="dialog" aria-hidden="true" class="pswp">
		<div class="pswp__bg"></div>
		<div class="pswp__scroll-wrap">
			<div class="pswp__container">
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
			</div>
			<div class="pswp__ui pswp__ui--hidden">
				<div class="pswp__top-bar">
					<div class="pswp__counter"></div>
					<button title="Close (Esc)"
						class="pswp__button pswp__button--close"></button>
					<button title="Share" class="pswp__button pswp__button--share"></button>
					<button title="Toggle fullscreen"
						class="pswp__button pswp__button--fs"></button>
					<button title="Zoom in/out" class="pswp__button pswp__button--zoom"></button>
					<div class="pswp__preloader">
						<div class="pswp__preloader__icn">
							<div class="pswp__preloader__cut">
								<div class="pswp__preloader__donut"></div>
							</div>
						</div>
					</div>
				</div>
				<div
					class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
					<div class="pswp__share-tooltip"></div>
				</div>
				<button title="Previous (arrow left)"
					class="pswp__button pswp__button--arrow--left"></button>
				<button title="Next (arrow right)"
					class="pswp__button pswp__button--arrow--right"></button>
				<div class="pswp__caption">
					<div class="pswp__caption__center"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- Java script-->
	<script>
		var request = new XMLHttpRequest();
		function searchInfo() {
			var name = document.vinform.name.value;
			var url = "/bu-club-central/SearchPageServlet?val=" + name;

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

	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>

</html>