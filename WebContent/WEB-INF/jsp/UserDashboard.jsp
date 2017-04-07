<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ben.bu_club_central.models.User"%>
<%@ page import="edu.ben.bu_club_central.models.Events"%>
<%@ page import="edu.ben.bu_club_central.models.Club"%>
<%@ page import="edu.ben.bu_club_central.models.Comment"%>
<%@ page import="edu.ben.bu_club_central.models.Post"%>
<%@ page import="edu.ben.bu_club_central.daos.UserDao"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubDao"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubMembershipDao"%>
<%@ page import="edu.ben.bu_club_central.models.ClubMembership"%>
<%@ page import="edu.ben.bu_club_central.daos.EventsDao"%>
<%@ page import="edu.ben.bu_club_central.daos.PostDao"%>
<%@ page import="edu.ben.bu_club_central.daos.CommentDao"%>
<%@ page import="edu.ben.bu_club_central.daos.EventNotificationDao"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">

<head>
<!-- Site Title-->
<title>User Dashboard</title>

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
<script src="js/js/sweetalert2.js"></script>
<link rel="stylesheet" type="text/css" href="css/sweetalert2.css">
<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]-->
</head>
<body onload="loggedIn()">
	<!-- Page-->
	<div class="page text-center">
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

								<%
									EventNotificationDao eventNotDao = new EventNotificationDao();
									LinkedList<Events> eventList = eventNotDao
											.getEventNotifications(((User) session.getAttribute("user")).getId_num());
									int eventListIndex = 0;
									int eventListSize = eventList.size();
								%>

								<%
									if (eventList.size() != 0) {
								%>

								<li>
									<div class="dropdown " style="width: 100px">
										<span data-toggle="dropdown"
											class="glyphicon glyphicon-calendar"
											style="color: yellow; font-size: 20px">Notifications</span>
										<ul class="dropdown-menu">

											<%
												while (eventListIndex < eventListSize) {
											%>
											<li><a
												href="EventDetailsServlet?eventId=<%=eventList.get(eventListIndex).getEventId()%>"><%=eventList.get(eventListIndex).getEvent_name()%></a></li>

											<%
												eventListIndex++;
											%>
											<%
												}
											%>


										</ul>
									</div> <%
 	}
 %>

								</li>



								<li class=""><a href="HomeServlet"><span>Home</span></a></li>
								<li><a href="EventServlet"><span>Events</span></a></li>
								<li><a href="ClublistServlet"><span>clubs</span></a></li>

								<li><a href="MeetTheAdminsServlet"><span>About
											Us</span></a></li>
								<li><a href="ContactUsServlet"><span>Contact Us</span></a>
								<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="LoginSevlet"> <%
 	if (session.getAttribute("user") == null) {
 %> <a href="LoginServlet"> Sign In <%
 	} else {
 %> <%=((User) session.getAttribute("user")).getFirst_name()%>
											<span class="caret"></span></a> <%
 	}
 %>

										<ul class="dropdown-menu">
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
											<li><a href="ClubHomepageServlet"><span class="">Club
														Home Page</span></a> <a type="button" href="LogoutServlet"
												class="btn btn-sm btn-info "> <span
													class="glyphicon glyphicon-log-out"></span> Log out
											</a>
										</ul></li>




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
				<div
					class="shell section-top-98 section-bottom-34 section-md-bottom-66 section-md-98 section-lg-top-110 section-lg-bottom-41">
					<!--   <h2 class="veil reveal-md-block offset-top-30"><span class="big">Admin Home</span></h2>-->

				</div>
			</div>
			</section>
		</div>
		</header>
		<!-- Page Contents-->
		<main class="page-content"> <section
			class="section-top-98 section-md-top-110 text-lg-left">
		<div class="shell">

			<div class="range range-xs-center range-xs-center">
				<h1>User Dashboard</h1>

				<!-- Put dashboard code here -->
				<section>
				<div class="shell">
					${message}
					<div class="row">
						<form action="UserEmailsAdminFromDashboardServlet" method="POST">
							<div class="cell-lg-4">
								<div class="inset-lg-left-80">
									<br>
									<p style="float: right; margin: 0; padding: 1em;"
										class="offset-top-41 offset-lg-top-50">
										<textarea name="message"
											placeholder="Need help? Contact the admin..."
											onkeypress="enableUpdateButtonContact()" cols="30" rows="2"
											name="editDescription"></textarea>
										<br>
										<button id="buttonContact" disabled class="btn btn-info"
											type="submit">Contact Admin</button>

									</p>

								</div>
							</div>
						</form>
						<div class="container">
							<div class="container" style="height: 100px"></div>
							<div class="col-lg-12">
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li class="active" role="presentation"><a href="#viewEvents"
										aria-controls="#viewEvents" role="tab" data-toggle="tab">View Events</a></li>
										
									<li role="presentation"><a href="#editPosts"
										aria-controls="#editPosts" role="tab" data-toggle="tab">View
											Posts</a></li>	
									<li role="presentation" ><a
										href="#viewProfile" aria-controls="viewProfile" role="tab"
										data-toggle="tab">View Profile</a></li>
									<li role="presentation"><a href="#viewClub"
										aria-controls="viewClub" role="tab" data-toggle="tab">View
											Current Clubs</a></li>
									<li role="presentation"><a href="#viewPastClub"
										aria-controls="viewPastClub" role="tab" data-toggle="tab">View
											Past Clubs</a></li>
									<li role="presentation"><a href="#eventFeedback"
										aria-controls="#eventFeedback" role="tab" data-toggle="tab">Event
											Feedback</a></li>
								</ul>

								<!-- Tab panes -->
								
								<div class="tab-content">
										<div role="tabpanel" class="tab-pane active" id="viewEvents">
							<div class="container">
								<%
									LinkedList<Events> eventList2 = (LinkedList<Events>) request.getAttribute("eventList2");
									int eventListIndex2 = 0;
									int eventListSize2 = eventList2.size();
								%>


								<table class="table table-hover sortable">
									<thead>
										<tr>
											<th>Event ID</th>
											<th>Event Name</th>
											<th>Location</th>
											<th>RSVP Count</th>
											<th></th>
										</tr>
									</thead>
									<tbody
										style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display:">
										<%
											while (eventListIndex2 < eventListSize2) {
										%>
										<tr>
											<td><%=eventList2.get(eventListIndex2).getEventId()%></td>
											<td><%=eventList2.get(eventListIndex2).getEvent_name()%></td>
											<td><%=eventList2.get(eventListIndex2).getLocation()%></td>
											<td><%=eventList2.get(eventListIndex2).getRsvp_count()%></td>
											<td><form action="EventDetailsServlet" method="GET">
													<button class="btn btn-warning" type="submit"
														name="eventId"
														value="<%=eventList2.get(eventListIndex2).getEventId()%>">Event Info</button>
												</form></td>
										</tr>

										<%
										eventListIndex2++;
										%>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
								
								<div role="tabpanel" class="tab-pane" id="editPosts">
							<div class="container">
								
								<%
									LinkedList<Post> postList = (LinkedList<Post>) request.getAttribute("postList");

									int postListIndex = 0;
									int postListSize = postList.size();
								%>


								<table class="table table-hover ">
									<thead>
										<tr>
											<th>Post ID</th>
											<th>Post Title</th>
											<th>Contents</th>
											<th>Club ID Number</th>
											<th>Posted by</th>
										</tr>
									</thead>
									<%
										while (postListIndex < postListSize) {
									%>

									<tbody>
										<tr>
											<td><%=postList.get(postListIndex).getIdpost()%></td>
											<td><%=postList.get(postListIndex).getTitle()%></td>
											<td><%=postList.get(postListIndex).getContents()%></td>
											<td><%=postList.get(postListIndex).getClub_id_num()%></td>
											<td><%=postList.get(postListIndex).getUser_id_num()%></td>
											
										</tr>
									</tbody>

									<%
										postListIndex++;
									%>
									<%
										}
									%>
								</table>
							</div>
						</div>
								
								
								
									<div role="tabpanel" class="tab-pane" id="eventFeedback">
										<div class="container">
												<%
												LinkedList<Events> eventListFeedback = (LinkedList<Events>) request.getAttribute("eventList");
												int eventListIndexFeedback = 0;
												int eventListSizeFeedback = eventListFeedback.size();
											%>
											<table class="table table-hover">
												<thead>
													<tr>
														<th>Event Name</th>
														<th>Description</th>
														<th>Location</th>
														<th><% %></th>
													</tr>
												</thead>
												<tbody
													style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display:">
													<%
														while (eventListIndexFeedback < eventListSizeFeedback) {
													%>
													<tr>
														<td><%=eventListFeedback.get(eventListIndexFeedback).getEvent_name()%></td>
														<td><%=eventListFeedback.get(eventListIndexFeedback).getDescription()%></td>
														<td><%=eventListFeedback.get(eventListIndexFeedback).getLocation()%></td>
														<td>
															<form action="EventUserFeedbackServlet" method="POST">

																		<br>

																			<textarea name="eventFeedbackMessage"
																				placeholder="Leave Feedback for event that you just attended"
																				 cols="50"
																				rows="7" name="editDescription"></textarea>
																			<br>
																			<button name="eventIdFeedback"
																				value="<%=eventListFeedback.get(eventListIndexFeedback).getEventId()%>"
																				class="btn btn-warning" type="submit">Submit</button>


															</form>

														</td>
													</tr>

													<%
														eventListIndexFeedback++;
													%>
													<%
														}
													%>
												</tbody>
											</table>
												


										</div>
									</div>







									<div role="tabpanel" class="tab-pane" id="viewClub">
										<div class="container">
											<%
												ClubMembershipDao cmDao = new ClubMembershipDao();
												LinkedList<ClubMembership> clubMembershipList = new LinkedList<ClubMembership>();
												clubMembershipList = cmDao.displayUserClubInfo(((User) session.getAttribute("user")).getUser_id());

												int index = 0;
											%>
											<table class="table table-hover">
												<thead>
													<tr>
														<th>Club Name</th>
													</tr>
												</thead>
												<tbody
													style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display:">
													<%
														while (index < clubMembershipList.size()) {
													%>
													<tr>
														<td><%=clubMembershipList.get(index).getClub_name()%></td>
														<td><form action="UserLeavesClubServlet"
																method="post">
																<button class="btn btn-warning" type="submit"
																	name="clubID"
																	value="<%=clubMembershipList.get(index).getClubID()%>">Leave
																	Club</button>
															</form></td>
													</tr>

													<%
														index++;
													%>
													<%
														}
													%>
												</tbody>
											</table>
										</div>
									</div>

									<div role="tabpanel" class="tab-pane" id="viewPastClub">
										<div class="container">
											<%
												ClubMembershipDao cmDao2 = new ClubMembershipDao();
												LinkedList<ClubMembership> clubMembershipList2 = new LinkedList<ClubMembership>();
												clubMembershipList2 = cmDao2.displayUserPastClubInfo(((User) session.getAttribute("user")).getUser_id());
												int index3 = 0;
											%>
											<table class="table table-hover">
												<thead>
													<tr>
														<th>Club Name</th>
													</tr>
												</thead>
												<tbody
													style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display:">
													<%
														while (index3 < clubMembershipList2.size()) {
													%>
													<tr>
														<td><%=clubMembershipList2.get(index3).getClub_name()%></td>
														<td><form action="RejoinClubFromDashboardServlet"
																method="post">
																<button class="btn btn-warning" type="submit"
																	name="club_id_num"
																	value="<%=clubMembershipList2.get(index3).getClubID()%>">Rejoin
																	Club</button>
															</form></td>
													</tr>

													<%
														index3++;
													%>
													<%
														}
													%>
												</tbody>
											</table>
										</div>
									</div>

									<div role="tabpanel" class="tab-pane active" id="viewProfile">
										<div class="container">
											<%
												UserDao uDao = new UserDao();
												LinkedList<User> userList = new LinkedList<User>();
												userList = uDao.displayUsersInfo(((User) session.getAttribute("user")).getUser_id());

												int index2 = 0;
											%>

											<table class="table table-hover sortable">
												<thead>
													<tr>
														<th>Username</th>
														<th>Password</th>
														<th>Email</th>
													</tr>
												</thead>

												<tbody>
													<%
														while (index2 < userList.size()) {
													%>
													<tr>
														<td>
															<form action="EditUsernameServlet" method="POST">
																<textarea onkeypress="enableUpdateButton1()" cols="15"
																	rows="1" name="editUsername"><%=userList.get(index2).getUsername()%></textarea>
																<br>
																<button id="button1" disabled class="btn btn-warning"
																	type="submit">Save Changes</button>
															</form>
														</td>
														<td>
															<form action="EditPasswordServlet" method="POST">
																<textarea onkeypress="enableUpdateButton2()" cols="15"
																	rows="1" name="editPassword"><%=userList.get(index2).getPassword()%></textarea>
																<br>
																<button id="button2" disabled class="btn btn-warning"
																	type="submit">Save Changes</button>
															</form>
														</td>
														<td>
															<form action="EditEmailServlet" method="POST">
																<textarea onkeypress="enableUpdateButton3()" cols="20"
																	rows="1" name="editEmail"><%=userList.get(index2).getEmail()%></textarea>
																<br>
																<button id="button3" disabled class="btn btn-warning"
																	type="submit">Save Changes</button>
															</form>
														</td>
													</tr>
													<%
														index2++;
													%>
													<%
														}
													%>
												</tbody>

											</table>
										</div>
									</div>





								</div>


							</div>
						</div>
					</div>
				</section>

				<div class="cell-sm-8 offset-top-66 offset-lg-top-0"></div>
		</section> </main>
		<!-- Page Footer -->
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
	<script type="text/javascript">
		
		function loggedIn() {
			var calledOnced = '<%=session.getAttribute("loggedIn")%>
		';
			if (calledOnced == 0) {
	<%request.getSession().setAttribute("loggedIn", 1);%>
		calledOnce = 1;
				swal({
					title : 'Logged In Successfully!',
					text : 'This window will close in 4 seconds.',
					timer : 4000
				}).then(function() {
				},
				// handling the promise rejection
				function(dismiss) {
					if (dismiss === 'timer') {
						console.log('I was closed by the timer')
					}
				})
			}

		}
	</script>

	<script>
		function enableUpdateButton1() {

			document.getElementById("button1").disabled = false;

		}

		function enableUpdateButton2() {

			document.getElementById("button2").disabled = false;

		}

		function enableUpdateButton3() {

			document.getElementById("button3").disabled = false;

		}

		function enableUpdateButtonContact() {

			document.getElementById("buttonContact").disabled = false;

		}
	</script>

	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>

</html>