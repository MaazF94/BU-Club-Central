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
         <%if (session.getAttribute("user") != null) { %>
         					<%
												int role_id = ((User) session.getAttribute("user")).getRole_id();
											%>
											<%
												if (role_id == 1) {
											%>
											<li><a href="UserServlet"><span class="">Dash
														Board</span></a> <%
 	} else if (role_id == 2) {
 %>
											<li><a href="BoardMemberDashBoard"><span class="">Dash
														Board</span></a> <%
 	} else {
 %>
											<li><a href="AdminHome"><span class="">Dash
														Board</span></a> <%
 	}
 %>
 <%} %>
        					        <% if (session.getAttribute("user") != null && ((User) session.getAttribute("user")).getRole_id() == 2) { %>
          <li><a href="ClubHomepage?club_id_num=<%=((User) session.getAttribute("user")).getClub_id_num()%>"><span class="">Club Home Page</span></a>
        <%} %>
 							<a type="button" href="LogoutServlet" class="btn btn-sm btn-info ">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </a>
      
        
          
        </ul>
      </li>
								
								
                      <li><a href="#"><span></span></a></li>
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

		
		<!-- Page Content-->
      <main class="page-content section-98 section-sm-110 ">
        <div class="shell ">
          <div class="range range-xs-center ">
            <div class="cell-md-8 cell-md-push-2">
              <div class="inset-md-left-20">
                <!-- Classic Thumbnail-->
                <!-- Classic Gallery Carousel-->
                <!-- Classic Thumbnail-->
                <!-- Embed Video-->
                <!-- Classic Soundcloud Player-->
                <!-- Blog Default Single-->
                
                <section>
                
                <h2 class="text-bold">Upcoming Events</h2>
                <hr class="divider  bg-red">
                <%
						EventsDao eventDao = new EventsDao();
						LinkedList<Events> eventList = new LinkedList<Events>();

						eventList = eventDao.getAllEventsByCategory(request.getParameter("category"));
						int eventListSize = eventList.size();
						int eventListIndex = 0;
						 int noOfRecords = eventList.size();
						int pages = 1;
				         int recordsPerPage = 5;
				        
				        
				        
				        
				        
				         
				         int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
						ClubDao cDao = new ClubDao();
					%>
					<%
						while (eventListIndex < eventListSize) {
					%>
                                  <!-- Post Wide-->
                                  <article class="post post-default text-left well">
                                    <!-- Post Header-->
                                    <div class="header post-header">
                                      <!-- Post Meta-->
                                      <ul class="post-controls list-inline list-inline-sm p text-dark">
                                      <li><h3 class="post-title text-default"><a><%=eventList.get(eventListIndex).getEvent_name()%></a></h3></li>
                                        
                                        <li><span class="text-middle icon-xxs text-picton-red mdi mdi-account-outline text-carrot">&nbsp;</span><%=eventList.get(eventListIndex).getRsvp_count()%><span class="text-middle small"></span></li>
                                        
                                        
                                        <li><span class="text-middle icon-xxs text-picton-red mdi mdi-map-marker-multiple text-carrot">&nbsp;</span><a href="#" class="text-middle small"><span>&nbsp;<%=eventList.get(eventListIndex).getLocation()%></span></a></li>
                                      </ul>
                                      <!-- Post Meta-->
                                      
                                      <!-- Post Media-->
                                      
                                    </div>
                                    <!-- PostContent-->
                                    <section class="post-content offset-top-41">
                                    <p><%= eventList.get(eventListIndex).getDescription() %></p>
                                     
                                    </section>
                                     <a class="offset-top-24 btn btn"><form action="EventDetailsServlet" method="GET">
									<button class="btn btn-info text-red-gray" type="submit" name="eventId"
												value="<%=eventList.get(eventListIndex).getEventId()%>">More
												Info</button>
										</form></a>
										                                  <%if (((User) session.getAttribute("user")) != null) { %>
										
                                      <a class="offset-top-24 btn btn"><%EventRSVPListDao rsvpDao = new EventRSVPListDao(); 
										
										boolean rsvpBoolean = rsvpDao.checkUserRsvpForEvent(eventList.get(eventListIndex).getEventId(), ((User)session.getAttribute("user")).getId_num());
									%>
									
									<%if(!rsvpBoolean) { %>
										
										<form action="RSVPServlet" method="POST">

											<button class="btn btn-default " type="submit" name="eventId"
												value="<%=eventList.get(eventListIndex).getEventId()%>">RSVP For Event</button>
										</form>
										
									
									
									<%}else { %>
										
											<form action="RSVPServlet" method="POST">

											<button disabled class="btn btn-default" type="submit" name="eventId"
												value="<%=eventList.get(eventListIndex).getEventId()%>">Already Going</button>
										</form>
										
										
									
									<%} } %></a>
                                    
                                  </article>
                                  
                  <hr class="hr offset-top-66">
                  <%
					eventListIndex++;
				%>
				<%
					}
				%>
                  
                  
                 
                  <div class="offset-top-66">
                                    <!-- Bootstrap Pagination-->
                                   
                  </div>
                </section>
              </div>
            </div>
    <div class="cell-md-4 cell-md-push-1 offset-top-66 offset-md-top-0">
              <!-- Section Blog Modern-->
              <aside class="text-left">
                
               
                <div class="range offset-top-41">
                  <div class="cell-xs-6 cell-md-12">
                    <!-- Category-->
                    <%
			ClubDao cDao2 = new ClubDao();
			LinkedList<Club> clubList = new LinkedList<Club>();
			clubList = cDao2.getAllClubs();

			int index = 0;
		%>
                    <h6 class="text-uppercase text-spacing-60">Clubs</h6>
                    <div class="text-subline"></div>
                    <ul class="list list-marked offset-top-30">
                    <%
							while (index < clubList.size()) {
								if(eventDao.getAllEventsByClubId(clubList.get(index).getClub_id_num()).size()>0){
						%>
                      <li><form action ="EventpageByClub" method="POST" >
                      <button type="submit" class="btn btn-xs btn-default" name="clubID" value=<%=clubList.get(index).getClub_id_num()%>><span class="text-red"><%
												out.println(clubList.get(index).getClub_name());
											%>(<%= eventDao.getAllEventsByClubId(clubList.get(index).getClub_id_num()).size() %>)</span></button></form></li>
												<%
										
										}
								index++;
							}
									%>
                      
                    </ul>
                    
                  </div>
                  
                </div>
                <!-- Categories -->
                <p class="big text-medium offset-top-41 text-uppercase text-spacing-60">Categories</p>
                <div class="text-subline"></div>
                <div class="offset-top-34">
                                <div class="group-xs">
                                <form action ="SearchByCategory" method="POST" ><button type = "submit" name = "category" value = "Sports" class="btn btn-xs btn-default">Sports</button></form>
                                <form action ="SearchByCategory" method="POST" ><button type = "submit" name = "category" value = "Technology" class="btn btn-xs btn-default">Technology</button></form>
                                <form action ="SearchByCategory" method="POST" ><button type = "submit" name = "category" value = "Movies" class="btn btn-xs btn-default">Movies</button></form>
                                <form action ="SearchByCategory" method="POST" ><button type = "submit" name = "category" value = "Arts" class="btn btn-xs btn-default">Arts</button></form>
                                <form action ="SearchByCategory" method="POST" ><button type = "submit" name = "category" value = "Community" class="btn btn-xs btn-default">Community</button></form>
                                <form action ="SearchByCategory" method="POST" ><button type = "submit" name = "category" value = "Other" class="btn btn-xs btn-default">Other</button></form>
                                </div>
                <!-- Search Form-->
                <h6 class="text-uppercase text-spacing-60">Search</h6>
                <div class="text-subline"></div>
                <div class="offset-top-34">
                                <!-- RD Search Form-->
                               <form action="SearchByEventName" method="POST" class="form-search rd-search">
                                  <div class="form-group">
                                    <label for="blog-sidebar-1-form-search-widget" class="form-label form-search-label form-label-sm">Search</label>
                                    <input id="blog-sidebar-1-form-search-widget" id="EventName" name="EventName" autocomplete="off" class="form-search-input input-sm form-control input-sm">
                                  </div>
                                  <button type="submit" class="form-search-submit"><span class="mdi mdi-magnify"></span></button>
                                </form>

                </div>
              </aside>
            </div>
          </div>
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