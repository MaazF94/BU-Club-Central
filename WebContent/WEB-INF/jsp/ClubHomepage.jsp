<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">

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


<head>
<!-- Site Title-->
<title>Club Homepage</title>

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
		<header class="page-head slider-menu-position"> <!-- RD Navbar Transparent-->
		<div class="rd-navbar-wrap">
			<nav data-md-device-layout="rd-navbar-fixed"
				data-lg-device-layout="rd-navbar-static"
				class="rd-navbar container rd-navbar-floated rd-navbar-dark"
				data-lg-auto-height="true" data-md-layout="rd-navbar-fixed"
				data-lg-layout="rd-navbar-static" data-lg-stick-up="true">
			<div class="rd-navbar-inner">
				<!-- RD Navbar Top Panel-->
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

							</ul>
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
		<div class="context-dark">
			<!-- Modern Breadcrumbs-->
			<section class="breadcrumb-modern rd-parallax bg-gray-darkest">

			<div data-speed="0" data-type="html" class="rd-parallax-layer">
				<div
					class="shell section-top-98 section-bottom-34 section-md-bottom-66 section-md-98 section-lg-top-110 section-lg-bottom-41">
					<h2 class="veil reveal-md-block offset-top-30">
						<span class="big"><br> <br> </span>
					</h2>

				</div>
			</div>
			</section>
		</div>
		</header>
		<!-- Page Contents-->
		<div class="jumbotron" style="background-color: #f1eaee">
			<h1>
				<div class="container">
					<h1>${clubName}</h1>
				</div>
			</h1>
			<h5>Number of Club Members: ${clubMembers}</h5>
			<hr>
			<p><b>Number of club members:</b> ${clubMembers}
			<br>
			   <b>Description:</b>
			   <br>
			   ${clubDescription}
			 </p>
			<div class="range range-xs-left range-xs-left">
              <div class="cell-sm-6">
              ${message}
                <h6 style="align:left; padding-left:1px;">Contact a Board Member:</h6>
                <!-- RD Mailform-->
                <form data-form-output="form-output-global" data-form-type="contact" method="post" class="text-left offset-top-20">
                    <div style="width: 75%" class="cell-lg-2">
                      <div class="form-group">
                        <label for="contact-us-name" class="form-label form-label-outside"><strong>Name:</strong></label>
                        <input id="contact-us-name" type="text" name="name"  placeholder="Full Name"  class="form-control form-control-impressed">
                      </div>
                    </div>
                    <div style="padding: 10px; width: 75%" class="cell-lg-2 offset-top-20">
                      <div class="form-group">
                        <label for="contact-us-email" class="form-label form-label-outside"><strong>E-Mail:</strong></label>
                        <input id="contact-us-email" type="email" name="email" placeholder="Your Email Address" data-constraints="@Required @Email" class="form-control form-control-impressed">
                      </div>
                    </div>
                    <div style="padding: 10px; width: 75%" class="cell-lg-6 offset-top-20">
                      <div class="form-group">
                        <label for="contact-us-message" class="form-label form-label-outside"><strong>Message:</strong></label>
                        <textarea id="contact-us-message" name="message" placeholder="Write Your Message Here..." class="form-control form-control-impressed"></textarea>
                      </div>
                    </div>
                  <div class="group-sm text-center text-lg-center offset-top-30">
                    <button type="submit" class="btn btn-danger">Send</button>
                    <button type="reset" class="btn btn-default">Reset</button>
                  </div>
                </form>
              </div>
            </div>
		</div>
		
		            

		<%--div class="row" style="background-color: white">
			<div class="container">
				<div class="col-lg-4"></div>
				<div class="col-lg-4 ">
					<h3>Post Feed</h3>
					<%
						PostDao postDao = new PostDao();

						LinkedList<Post> postList = new LinkedList<Post>();

						postList = postDao.getAllPostsByClubId(((User) session.getAttribute("user")).getClub_id_num());

						//getAllPostsByClubId(((User) session.getAttribute("user")).getClub_id_num());		
						int postListSize = postList.size();
						int postListIndex = 0;
					%>

					<%
						while (postListIndex < postListSize) {
					%>

					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: light-grey">
							<h3 class="panel-title"><%=postList.get(postListIndex).getTitle()%></h3>
						</div>
						<div class="panel-body text-left"><%=postList.get(postListIndex).getContents()%></div>
					</div>

					<%
						postListIndex++;
					%>
					<%
						}
					%>


				</div>
			</div>
		</div> --%>




		<div class="row">
			<div class="container">
				<div class="col-lg-12">
					<h1>Home Page</h1>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="container" style="height: 100px"></div>
		</div>



		<div class="row">



			<div class="container">
				<div class="col-lg-6">
					<%
						EventsDao eDao = new EventsDao();
						LinkedList<Events> eventList = new LinkedList<Events>();
						eventList = eDao.getAllEventsByClubId(((User) session.getAttribute("user")).getClub_id_num());
						int eventListIndex = 0;
						int eventListSize = eventList.size();
					%>


					<table class="table table-hover">
						<thead>
							<tr>
								<th>Event Name</th>
								<th>Location</th>
								<th>RSVP</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								while (eventListIndex < eventListSize) {
							%>
							<tr>
								<td><%=eventList.get(eventListIndex).getEvent_name()%></td>
								<td><%=eventList.get(eventListIndex).getLocation()%></td>
								<td><%=eventList.get(eventListIndex).getRsvp_count()%></td>
								<td>
									<form action="EventDetailsServlet" method="GET">
										<%
											int eventId = eventList.get(eventListIndex).getEventId();
										%>
										<button class="btn" type="submit" name="eventId"
											value="<%=eventId%>">
											<span class="glyphicon glyphicon-calendar"
												style="font-size: 40px"></span>
										</button>

									</form>


								</td>
							</tr>

							<%
								eventListIndex++;
							%>
							<%
								}
							%>
						</tbody>
					</table>



				</div>

				<div class="col-lg-6">
				
							<%PostDao pDao = new PostDao();
								LinkedList<Post> postList = new LinkedList<Post>();
								postList = pDao.getAllPostsByClubId(((User) session.getAttribute("user")).getClub_id_num());
								
								int postListIndex = 0;
								int postListSize = postList.size();
								
							%>
							
							<table class="table table-hover">
									<thead>
										<tr>
											<th>Post Title</th>
											<th>Contents</th>
											<th></th>
										</tr>
									</thead>
							<%while (postListIndex < postListSize) { %>
								
									<tbody>
										<tr>
											<td><%=postList.get(postListIndex).getTitle()%></td>
											<td><%=postList.get(postListIndex).getContents()%></td>
											<td>
												<form action="#" method="GET">
													<%int postId = postList.get(postListIndex).getIdpost();%>
													<button class="btn" type="submit" name="editPostId" value="<%=postId%>">
														<span class="glyphicon glyphicon-comment" style="font-size: 40px"></span></button>
												
												</form>
											
											</td>
										</tr>
									</tbody>
							
							<%postListIndex++; %>
							<% }%>
							</table>
				

			</div>
		</div>
	</div>


	<div class="row">
		<div class="container">
			<div class="col-lg-12">
				<%UserDao uDao = new UserDao();
					LinkedList<User> userList = new LinkedList<User>();
					userList = uDao.getUsersByClub(((User)session.getAttribute("user")).getClub_id_num());
				
					int userListIndex = 0;
					int userListSize = userList.size();
				%>
				
				
				<table class="table table-hover">
									<thead>
										<tr>
											<th>Name</th>
											<th>User Name</th>
											<th>Email</th>
											<th>Role</th>
										</tr>
									</thead>
							<%while (userListIndex < userListSize) { %>
								
									<tbody>
										<tr>
											<td><%=userList.get(userListIndex).getFirst_name() + " " + userList.get(userListIndex).getLast_name()%></td>
											<td><%=userList.get(userListIndex).getUsername()%></td>
											<td><%=userList.get(userListIndex).getEmail()%></td>
											
											<%if(userList.get(userListIndex).getRole_id() == 1) { %>
												<td>General Member</td>
											
											<%} else { %>
												<td>Board Member</td>
											<%} %>
										</tr>
									</tbody>
							
							<%userListIndex++; %>
							<% }%>
							</table>
				
			</div>
		</div>
	</div>


























	<!-- Final div -->
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
						<h6
							class="text-uppercase text-spacing-60 text-center text-lg-left">Twitter
							Feed</h6>
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
									<div data-screen_name="text" class="twitter-name text-bold big"></div>
								</div>
								<div data-twitter-type="tweet" class="twitter-sm">
									<div class="twitter-date text-dark small">
										<span class="icon icon-xxs mdi mdi-twitter text-middle"></span>
										<span data-date="text" class="text-middle"></span>
									</div>
									<div data-tweet="text" class="twitter-text"></div>
									<div data-screen_name="text" class="twitter-name text-bold big"></div>
								</div>
							</div>
						</div>
					</div>


					<div
						class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
						<!-- Footer brand-->
						<div class="footer-brand">
							<a href="../index.html"><img
								src="img/logo_benedictinetransparentwhite.png" width="238"
								height="30" alt="" class="img-responsive reveal-inline-block"></a>
						</div>
						<div class="offset-top-50 text-xs-center text-lg-left">
							<ul class="list-inline">
								<li><a
									href="https://www.facebook.com/BenedictineUniversity/"
									target="_blank"
									class="icon fa fa-facebook icon-xxs icon-circle icon-darkest-filled"></a></li>
								<li><a href="https://twitter.com/BenU1887" target="_blank"
									class="icon fa fa-twitter icon-xxs icon-circle icon-darkest-filled"></a></li>
								<li><a href="https://plus.google.com/106737408889171586664"
									target="_blank"
									class="icon fa fa-google-plus icon-xxs icon-circle icon-darkest-filled"></a></li>
								<li><a
									href="https://www.linkedin.com/edu/benedictine-university-18245"
									target="_blank"
									class="icon fa fa-linkedin icon-xxs icon-circle icon-darkest-filled"></a></li>
							</ul>
						</div>
						<p class="text-darker offset-top-20">
							The F.I.R.M. &copy; <span id="copyright-year"></span> . <a
								href="privacy.html">Privacy Policy</a>
							<!-- {%FOOTER_LINK}-->
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</footer>



	<!-- Java script-->
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