<%@ page import="edu.ben.bu_club_central.models.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


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



<html lang="en" class="wide wow-animation smoothscroll scrollTo">


<head>
<!-- Site Title-->
<title>Club Dashboard</title>

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
		<main class="page-content"> <section id="welcome"
			class="section-98 section-sm-110">
		<div class="shell">
			<h1>Welcome</h1>
			<hr class="divider bg-red">
			<div class="range range-xs-center offset-top-66">
				<div class="cell-lg-8">
					<p>Welcome to the homepage! From here you
						can:</p>
				</div>
			</div>
			<div class="range offset-top-98">
				<div class="cell-sm-8 cell-sm-preffix-2 cell-md-4 cell-md-preffix-0">
					<!-- Icon Box Type 5-->
					<div class="box-icon box-icon-bordered">
						<a data-toggle="modal" href="#sendModal"><span
							class="icon glyphicon glyphicon-warning-sign"></span></a>
						<h4 class="text-danger offset-top-20">Edit Club</h4>
						<p></p>
					</div>
				</div>
				<div
					class="cell-sm-8 cell-sm-preffix-2 cell-md-4 cell-md-preffix-0 offset-top-98 offset-md-top-0">
					<!-- Icon Box Type 5-->
					<div class="box-icon box-icon-bordered">
						<a data-toggle="modal" href="#deleteModal"><span
							class="icon glyphicon glyphicon-modal-window"></span></a>
						<h4 class="text-danger offset-top-20">Create a Post</h4>
						<p></p>
					</div>
				</div>
				<div
					class="cell-sm-8 cell-sm-preffix-2 cell-md-4 cell-md-preffix-0 offset-top-98 offset-md-top-0">
					<!-- Icon Box Type 5-->
					<div class="box-icon box-icon-bordered">
						<a data-toggle="modal" href="#createModal"><span
							class="icon glyphicon glyphicon-calendar"></span> </a>
						<h4 class="text-danger offset-top-20">Create an Event</h4>
						<p></p>
					</div>
				</div>
				<div class="range range-xs-center offset-top-66">
				 <section>
                 
          <div class="shell">
           
          <hr class="resp-tabs-list tabs-1 text-center tabs-group-default">
            <div class="offset-sm-top-66 text-left">
              <!-- Responsive-tabs-->
              <div data-type="horizontal" class="responsive-tabs responsive-tabs-classic">
                <ul data-group="tabs-group-default" class="resp-tabs-list tabs-1 text-center tabs-group-default">
                  <li>Current Members</li>
                  <li></li>
                  <li></li>
                  <li></li>
                </ul>
                <div data-group="tabs-group-default" class="resp-tabs-container text-left tabs-group-default">
                  <div>
                  <!-- First toolbar tab -->
                   <!--  <div class="shell">-->
           
            <div class="range offset-sm-top-66">
            
              <div class="8">
                <!-- Classic Responsive Table-->
                  <%
			UserDao uDao = new UserDao();
			LinkedList<User> userList = new LinkedList<User>();
			userList = uDao.getAllUsersForClub();

			int index = 0;
		%>
             
                <table data-responsive="true" class="table table-custom">
              
                  <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>ID Number</th>
                    <th>E-mail</th>
                    <th></th>
                  </tr>
                  
                  <%
							while (index < userList.size()) {
						%>
                  <tr>
             
                    <td><%out.println(userList.get(index).getFirst_name());%></td>
                    <td><%out.println(userList.get(index).getLast_name());%></td>
                     <td><%out.println(userList.get(index).getId_num());%></td>
                    <td><%out.println(userList.get(index).getEmail());%></td>
                    <form action = "DeleteUserServlet" method = "post">
                    
                     <td><button type = "submit" name= "UserID" value = "<%out.println(userList.get(index).getId_num());%>" class="btn btn-warning">Delete</a></td>
                 	</form>
                  </tr>
                  <%
										index++;
										}
									%>
                  
									
                  
                </table>
              </div>
            <!-- </div> -->
          </div>
                  </div>
                  <!-- Second toolbar tab -->
                  <div>
                    <p></p>
                  </div>
                  <!-- Third toolbar tab -->
                  <div>
                    <p></p>
                  </div>
                  <!-- Fourth toolbar tab -->
                  <div>
                   
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
				</div>
				
			</div>

		</div>

		<div class="row">
			<div class="container">
				<div class="container" style="height: 100px"></div>
				<div class="col-lg-12">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#editEvents"
							aria-controls="editEvents" role="tab" data-toggle="tab">Edit
								Events</a></li>
						<li role="presentation"><a href="#editComments"
							aria-controls="editComments" role="tab" data-toggle="tab">Edit
								Comments</a></li>
						<li role="presentation"><a href="#editPosts"
							aria-controls="editPosts" role="tab" data-toggle="tab">Edit
								Posts</a></li>
						<li role="presentation"><a href="#editDescription"
							aria-controls="editDescription" role="tab" data-toggle="tab">Edit
								Description</a></li>

					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="editEvents">
							<div class="container">
								<%
									LinkedList<Events> eventList = new LinkedList<Events>();
									EventsDao eDao = new EventsDao();
									eventList = eDao.getAllEventsByClubId(((User) session.getAttribute("user")).getClub_id_num());
									int eventListIndex = 0;
									int eventListSize = eventList.size();
								%>
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Event ID</th>
											<th>Event Name</th>
											<th>Location</th>
											<th>RSVP Count</th>
											<th>Club ID Number</th>
											<th></th>
										</tr>
									</thead>
									<tbody
										style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display:">
										<%
											while (eventListIndex < eventListSize) {
										%>
										<tr>
											<td><%=eventList.get(eventListIndex).getEventId()%></td>
											<td><%=eventList.get(eventListIndex).getEvent_name()%></td>
											<td><%=eventList.get(eventListIndex).getLocation()%></td>
											<td><%=eventList.get(eventListIndex).getRsvp_count()%></td>
											<td><%=eventList.get(eventListIndex).getClub_id_num()%></td>
											<td><form action="EditEventServlet" method="GET">
													<button class="btn btn-warning" type="submit"
														name="editEventId"
														value="<%=eventList.get(eventListIndex).getEventId()%>">Edit</button>
												</form></td>
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
						</div>








						<div role="tabpanel" class="tab-pane" id="editComments">
							<div class="container">
								<%
									LinkedList<Events> eventList2 = new LinkedList<Events>();
									EventsDao eDao2 = new EventsDao();
									eventList2 = eDao.getAllEventsByClubId(((User) session.getAttribute("user")).getClub_id_num());
									int eventListIndex2 = 0;
									int eventListSize2 = eventList.size();
								%>
								
								<%
									while (eventListIndex2 < eventListSize2) {
								%>
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Event ID: <%=eventList2.get(eventListIndex2).getEventId()%></th>
											<th>Event Name: <%=eventList2.get(eventListIndex2).getEvent_name()%></th>
											<th>Club ID Number: <%=eventList2.get(eventListIndex2).getClub_id_num()%></th>
											
										</tr>
										
										<tr>
											<th>Comment ID</th>
											<th>Comment</th>
											<th>Event ID</th>
											<th>By:</th>
											<th></th>
										</tr>
									</thead>
									<tbody
										style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display: ">
										<%CommentDao cDao = new CommentDao();
											LinkedList<Comment> commentList = new LinkedList<Comment>();
											commentList = cDao.getCommentsByEventId(eventList2.get(eventListIndex2).getEventId());
											UserDao uDao2 = new UserDao();
											User u;
											
											int commentListIndex = 0;
											int commentListSize = commentList.size();
										
										%>
										
										<%while(commentListIndex < commentListSize) { %>
										
										<tr>
											<td><%=commentList.get(commentListIndex).getIdcomment()%></td>
											<td><%=commentList.get(commentListIndex).getComment()%></td>
											<td><%=commentList.get(commentListIndex).getEventId()%></td>
											<td><%u = uDao.getUserByIdNum(commentList.get(commentListIndex).getUserId()); %>
												<%=u.getFirst_name() + " " + u.getLast_name()%>
											</td>
											<td>
												<form action="EditCommentServlet" method="GET">
													<button class="btn btn-warning" type="submit"
														name="editCommentId" value="<%=commentList.get(commentListIndex).getIdcomment()%>">Edit</button>
												
												</form>
											
											</td>
										</tr>
										


										<% 
										commentListIndex++;
										%>
										<%} %>
										
										<%
											eventListIndex2++;
										%>
										<div class="container" style="height:50px"></div>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>


						<div role="tabpanel" class="tab-pane" id="editPosts">
							<%PostDao pDao = new PostDao();
								LinkedList<Post> postList = new LinkedList<Post>();
								postList = pDao.getAllPostsByClubId(((User) session.getAttribute("user")).getClub_id_num());
								
								int postListIndex = 0;
								int postListSize = postList.size();
								
							%>
							
							<table class="table table-hover">
									<thead>
										<tr>
											<th>Post ID</th>
											<th>Post Title</th>
											<th>Contents</th>
											<th>Club ID Number</th>
											<th>Posted by</th>
											<th></th>
										</tr>
									</thead>
							<%while (postListIndex < postListSize) { %>
								
									<tbody>
										<tr>
											<td><%=postList.get(postListIndex).getIdpost()%></td>
											<td><%=postList.get(postListIndex).getTitle()%></td>
											<td><%=postList.get(postListIndex).getContents()%></td>
											<td><%=postList.get(postListIndex).getClub_id_num()%></td>
											<td><%=postList.get(postListIndex).getUser_id_num()%></td>
											<td>
												<form action="EditPostServlet" method="GET">
													<%int postId = postList.get(postListIndex).getIdpost();%>
													<button class="btn btn-warning" type="submit" name="editPostId" value="<%=postId%>">Edit</button>
												
												</form>
											
											</td>
										</tr>
									</tbody>
							
							<%postListIndex++; %>
							<% }%>
							</table>
						</div>
						
						
						
						
						
						
						<div role="tabpanel" class="tab-pane" id="editDescription">
							<%ClubDao cDao = new ClubDao();
								Club clubObject = cDao.getClubById(((User) session.getAttribute("user")).getClub_id_num());
								String clubDescription = clubObject.getClub_description();								
								
							%>
							
							<form  action="EditClubDescriptionServlet" method="post">
							
							<table class="table table-hover">
									<thead>
										<tr>
											<th>Club Description</th>
											<th></th>
										</tr>
									</thead>
								
									<tbody>
										<tr>
											<td> 
											<textarea onkeypress="enableUpdateButton()" cols="45" rows="10" name="editDescription"><%=clubDescription%></textarea>
											<br>
											<button id="button" disabled class="btn btn-warning" type="submit">Save Changes</button>
											</td>
										</tr>
									</tbody>
							
							</table>
							</form>
							
						</div>
						
					</div>


				</div>
			</div>
		</div>

		
		<div class="row">
			<div class="container">
				<div class="col-lg-12" style="height:100px">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="container">
				<div class="col-lg-3" ></div>
				
				<div class="col-lg-6">
					<h3>Filter Events</h3>
					
					<form onclick="sortInfo()" name="vinform" >
						<input type="radio" name="name" value="rsvpIncreasing">Number of People Coming(increasing order) <br>
						<input type="radio" name="name" value="rsvpDecreasing">Number of People Coming(decreasing order) <br>
					</form>
					
					<div class="col-4-lg">
							<table class="table table-hover" >
								<thead>
									<tr>
										<td></td>
										<td></td>
										<td>Event name <span class="glyphicon glyphicon-calendar"></span></td>
										<td>People Coming <span class="glyphicon glyphicon-user"></span></td>
										<td></td>
									</tr>
								</thead>
								<tbody id="sortLocation">

								</tbody>

							</table>
						</div>
					
				</div>
			</div>
		</div>















		</section> </main>

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
	<!-- delete Modal -->
	<div class="modal fade" id="deleteModal" role="dialog">
		<div class="modal-dialog" style="top: 25%;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;"></div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" method="POST" action="CreatePostServlet" onsubmit="return confirm('Are you sure you want create this post.');">
						<div class="form-group">
							<label for="id"><span class="glyphicon glyphicon-pushpin"></span>
								Post Title</label> <input name="postTitle" type="text"
								class="form-control" id="id" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for=""><span class="glyphicon glyphicon-comment"></span>
								Post Description</label>
							<textarea onkeyup="textCounterPost(this,'counterPost',250);" style="height: 100px;" name="postDescription"
								id="comment" placeholder="Enter Description" type="text"
								class="form-control"></textarea>
							<h6 class="pull-right">
							<input disabled maxlength="1" size="1" value="250" id="counterPost">
							Remaining
						</h6>
						</div>

						<button type="submit" class="btn btn-success center">
							<span class="glyphicon glyphicon-pencil"></span> Post
						</button>
						<button type="button" class="btn btn-danger center" data-dismiss="modal">
							<span class="glyphicon glyphicon-trash"></span> Cancel </button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- send Modal -->
	<div class="modal fade" id="sendModal" role="dialog">
		<div class="modal-dialog" style="top: 25%;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;"></div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form">
						<div class="form-group offset-top-20">
							<div class="input-group input-group-sm">
								<span class="input-group-addon input-group-addon-inverse">
									<i class="fa fa-commenting-o" style="font-size: 19px"></i>
								</span>
								<textarea  style="height: 100px;" id="comment"
									placeholder="Type your message here..." type="text"
									name="content" class="form-control"></textarea>
							</div>
						</div>
						<button type="submit" class="btn btn-danger center">
							<span class="icon icon-xxs mdi mdi-email"></span> Send
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- create Modal -->
	<div class="modal fade" id="createModal" role="dialog">
		<div class="modal-dialog" style="top: 25%;">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;"></div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" method="POST" action="CreateEventServlet" onsubmit="return confirm('Are you sure you want create this event.');">
						<div class="form-group">
							<label for="id"><span class="glyphicon glyphicon-calendar"></span> Event
								Title</label> <input type="text" name="event_name" class="form-control"
								id="id" placeholder="Enter Event Title">
						</div>
						<div class="input-group input-group-sm">
							<label for="id"><span class="glyphicon glyphicon-comment"></span> Description</label>
							<textarea onkeyup="textCounterEvent(this,'counterEvent',500);" name="description" style="height: 100px;" id="comment"
								placeholder="Type your description of the event here..." type="text"
								name="content" class="form-control"></textarea>
								<h6 class="pull-right">
							<input disabled maxlength="1" size="1" value="500" id="counterEvent">
							Remaining
						</h6>
						</div>
						<div class="form-group">
							<label for=""><span class="glyphicon glyphicon-globe"></span>
								Location</label> <input name="location" type="text" class="form-control"
								id="location" placeholder="Location of Event">
						</div>




						<button type="submit" class="btn btn-success center">
							<span class="glyphicon glyphicon-ok-circle"></span> Create Event
						</button>
						<button type="button" class="btn btn-danger center" data-dismiss="modal">
							<span class="glyphicon glyphicon-trash"></span> Cancel </button>
            
					</form>
				</div>
			</div>
		</div>
		
	</div>
	<script>
		$(document).ready(function() {
			$("#deleteModal").modal();
			$("#sendModal").modal();
			$("#createModal").modal();
		});
	</script>
	<!-- Java script-->
	<script type="text/javascript">
		
		function loggedIn() {
			var calledOnced = '<%=session.getAttribute("loggedIn") %>';
			if (calledOnced == 0) {
				<%request.getSession().setAttribute("loggedIn", 1); %>
				calledOnce = 1;
				swal({
					  title: 'Logged In Successfully!',
					  text: 'This window will close in 4 seconds.',
					  timer: 4000
					}).then(
					  function () {},
					  // handling the promise rejection
					  function (dismiss) {
					    if (dismiss === 'timer') {
					      console.log('I was closed by the timer')
					    }
					  }
					)
			}
			
		}
	</script>
	
	<script>
	function enableUpdateButton() {

	    document.getElementById("button").disabled = false;

	}
	</script>
	
	<script>
		var request = new XMLHttpRequest();
		function sortInfo() {
			var name = document.vinform.name.value;
			var url = "/bu-club-central/SortPageServlet?val=" + name;

			try {
				request.onreadystatechange = function() {
					if (request.readyState == 4) {
						var val = request.responseText;
						document.getElementById('sortLocation').innerHTML = val;
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
		function textCounterPost(field, field2, maxlimit) {
			var countfield = document.getElementById(field2);
			if (field.value.length > maxlimit) {
				field.value = field.value.substring(0, maxlimit);
				return false;
			} else {
				countfield.value = maxlimit - field.value.length;
			}
		}
	</script>
	
	<script>
		function textCounterEvent(field, field2, maxlimit) {
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