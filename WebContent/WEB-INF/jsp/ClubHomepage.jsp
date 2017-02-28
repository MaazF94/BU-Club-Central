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
								<li class=""><a href="HomeServlet"><span>Home</span><span
										class="rd-navbar-label text-middle label-custom label-danger label-xs-custom label-rounded-custom label"></span></a>
								<li><a class="active" href="EventServlet"><span>Events</span></a>
								<li><a href="ClubHomepageServlet"><span>Club</span></a>
								<li><a class="" href="LoginServlet"><span>Sign
											out</span></a>
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
			<div data-speed="0.2" data-type="media" data-url="img/BUSenate.jpg"
				class="rd-parallax-layer"></div>
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
					<%
						ClubDao cDao = new ClubDao();
						Club clubObject = cDao.getClubById(((User) session.getAttribute("user")).getClub_id_num());
						String clubName = clubObject.getClub_name();
						out.print(clubName);
					%>
				</div>
			</h1>
		</div>



		<div class="page-content" style="background-color: grey">
			<div class="jumbotron" style="background-color: white">
				<div class="container">
					<div class="row">
						<div class="col-lg-4">
							<h3>Events Feed</h3>
							<%
								EventsDao eventDao = new EventsDao();

								LinkedList<Events> eventList = new LinkedList<Events>();

								eventList = eventDao.getAllEvents();
								int eventListSize = eventList.size();
								int eventListIndex = 0;
							%>

							<%
								while (eventListIndex < eventListSize) {
							%>

							<div class="panel panel-default">
								<div class="panel-heading" style="background-color: red">
									<h3 class="panel-title"><%=eventList.get(eventListIndex).getEvent_name()%></h3>
								</div>
								<h4>Description:</h4>
								<div class="panel-body text-left"
									style="background-color: #f1eaee"><%=eventList.get(eventListIndex).getDescription()%></div>
								<h4>Location:</h4>
								<div class="panel-body text-left"
									style="background-color: #f1eaee"><%=eventList.get(eventListIndex).getLocation()%></div>
								<div class="panel-body text-left"
									style="background-color: #f1eaee">
									Number of people going:
									<%=eventList.get(eventListIndex).getRsvp_count()%></div>
								<div class="panel-body">
									<form action="RSVPServlet" method="POST">

										<button class="btn btn-default " type="submit" name="eventId"
											value="<%=eventList.get(eventListIndex).getEventId()%>">RSVP</button>
									</form>
									<form action="CommentServlet" method="POST">
										<button class="btn btn-default " type="submit"
											name="commentId_eventId" value="<%=eventList.get(eventListIndex).getEventId()%>">
											<h4>Comment</h4>
										</button>
										<input name="comment" type="text">
									</form>
								</div>

								<div class="container break-text ">
									<div class="row">
										<div class="panel panel-default">
											<table class="table table-fixed ">
												<tbody 
													style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display: block">
													
														
														<%	UserDao userDao = new UserDao();
															User user;
															LinkedList<Comment> commentList = new LinkedList<Comment>(); 
															CommentDao commentDao = new CommentDao(); 
															commentList = commentDao.getCommentsByEventId(eventList.get(eventListIndex).getEventId()); 
															int commentListIndex = 0; 
															int commentListSize = commentList.size(); %>
															
														<%while(commentListIndex < commentListSize) { %>
															<tr>	
															<td class="col-lg-4  " >
																<%user = userDao.getUserByIdNum(commentList.get(commentListIndex).getUserId()); %>
															
																By: <%=user.getFirst_name() %><br>
																<%=commentList.get(commentListIndex).getComment()%>
															</td>
															</tr>
															<%commentListIndex++; %>
														<%	} %>
														




													

												</tbody>
											</table>
										</div>
									</div>
								</div>






							</div>

							<%
								eventListIndex++;
							%>




							<%
								}
							%>


						</div>

						<div class="col-lg-4">
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
								<div class="panel-heading" style="background-color: red">
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
								<a href="../index.html"><img
									src="img/logo_benedictinetransparentwhite.png" width="238"
									height="30" alt="" class="img-responsive reveal-inline-block"></a>
							</div>
							<div class="offset-top-50 text-xs-center text-lg-left">
								<ul class="list-inline">
									<li><a href="#"
										class="icon fa fa-facebook icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a href="#"
										class="icon fa fa-twitter icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a href="#"
										class="icon fa fa-google-plus icon-xxs icon-circle icon-darkest-filled"></a></li>
									<li><a href="#"
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
	</div>



	<!-- Java script-->
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>
</html>