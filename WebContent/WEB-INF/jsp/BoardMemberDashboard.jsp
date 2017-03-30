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
        						<li><a href="ClubHomepageServlet"><span class="">Club Home Page</span></a>
 							    <li><a href="LogoutServlet"><span class="text-danger">logout</span></a>
 							
      
        
          
        </ul>
      </li>
								
								
                      
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
            <div data-speed="0" data-type="html" class="rd-parallax-layer">
              <div class="shell section-top-98 section-bottom-34 section-md-bottom-66 section-md-98 section-lg-top-110 section-lg-bottom-41">                
              </div>
            </div>
          </section>
        </div>
      </header>
      <!-- Page Contents-->
		<main class="page-content"> <section id="welcome"
			class="section-98 section-sm-110">
		<div class="shell">
			<h1>Board Member Dashboard</h1>

		</div>

		<div class="row">
				${message}
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
						<li role="presentation"><a href="#viewMember"
							aria-controls="viewMember" role="tab" data-toggle="tab">View Club Members</a></li>
							<li role="presentation"><a href="#sendEmail"
							aria-controls="sendEmail" role="tab" data-toggle="tab">Send Emails</a></li>

					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
											<div role="tabpanel" class="tab-pane" id="viewMember">
							<div class="container">
                  <%
			UserDao uDao = new UserDao();
			LinkedList<User> userList = new LinkedList<User>();
			userList = uDao.getAllUsersForClub();
			
			int index = 0;
		%>
								<table class="table table-hover sortable">
									<thead>
										<tr>
                  <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>ID Number</th>
                    <th>E-mail</th>
                    <th></th>
                  </tr>
									</thead>
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
						</div>
					
					
					
					
					
					
					
					
						<div role="tabpanel" class="tab-pane active" id="editEvents">
							<div class="container">
								<%
									LinkedList<Events> eventList = new LinkedList<Events>();
									EventsDao eDao = new EventsDao();
									eventList = eDao.getAllEventsByClubId(((User) session.getAttribute("user")).getClub_id_num());
									int eventListIndex = 0;
									int eventListSize = eventList.size();
								%>
						<div class="row">
							<div class="container" style="height:50px">
								<div class="col-lg-12">
								
								</div>
							</div>
						</div>		
								
								
						<a data-toggle="modal" href="#createModal"><span
							class="icon glyphicon glyphicon-calendar"></span> </a>
						<h4 class="text-danger offset-top-20">Create an Event</h4>
						<p></p>
								<table class="table table-hover sortable">
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
								<table class="table table-hover sortable">
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
											<td><%u = uDao2.getUserByIdNum(commentList.get(commentListIndex).getUserId()); %>
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
							
							<div class="row">
							<div class="container" style="height:50px">
								<div class="col-lg-12">
								
								</div>
							</div>
						</div>
							
							
						<a data-toggle="modal" href="#deleteModal"><span
							class="icon glyphicon glyphicon-modal-window"></span></a>
						<h4 class="text-danger offset-top-20">Create a Post</h4>
						<p></p>
							
							<table class="table table-hover sortable">
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
							
							<table class="table table-hover sortable">
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
						
						<div role="tabpanel" class="tab-pane" id="sendEmail">
							<div class="container">
          			        <%
									LinkedList<Events> eventList3 = new LinkedList<Events>();
									EventsDao eDao3 = new EventsDao();
									eventList3 = eDao3.getAllEventsByClubId(((User) session.getAttribute("user")).getClub_id_num());
									int eventListIndex3 = 0;
									int eventListSize3 = eventList3.size();
								%>
								<table class="table table-hover sortable">
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
											while (eventListIndex3 < eventListSize3) {
										%>
										<tr>
											<td><%=eventList3.get(eventListIndex3).getEventId()%></td>
											<td><%=eventList3.get(eventListIndex3).getEvent_name()%></td>
											<td><%=eventList3.get(eventListIndex3).getLocation()%></td>
											<td><%=eventList3.get(eventListIndex3).getRsvp_count()%></td>
											<td><%=eventList3.get(eventListIndex3).getClub_id_num()%></td>
											<td><form action="BoardMemberEmailEventServlet" method="POST">
													<textarea   style="height: 100px;" 
								placeholder="Type your description for the email here..." type="text"
								name="contentEmail" class="form-control"></textarea>
													<button class="btn btn-warning" type="submit"
														name="sendEmailId"
														value="<%=eventList3.get(eventListIndex3).getEventId()%>">Send Email(s)</button>
												</form></td>
										</tr>

										<%
											eventListIndex3++;
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
							<table class="table table-hover sortable" >
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
						</div>s
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
	<script>
function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
</script>
<script>var stIsIE = /*@cc_on!@*/false;

sorttable = {
  init: function() {
    // quit if this function has already been called
    if (arguments.callee.done) return;
    // flag this function so we don't do the same thing twice
    arguments.callee.done = true;
    // kill the timer
    if (_timer) clearInterval(_timer);

    if (!document.createElement || !document.getElementsByTagName) return;

    sorttable.DATE_RE = /^(\d\d?)[\/\.-](\d\d?)[\/\.-]((\d\d)?\d\d)$/;

    forEach(document.getElementsByTagName('table'), function(table) {
      if (table.className.search(/\bsortable\b/) != -1) {
        sorttable.makeSortable(table);
      }
    });

  },

  makeSortable: function(table) {
    if (table.getElementsByTagName('thead').length == 0) {
      // table doesn't have a tHead. Since it should have, create one and
      // put the first table row in it.
      the = document.createElement('thead');
      the.appendChild(table.rows[0]);
      table.insertBefore(the,table.firstChild);
    }
    // Safari doesn't support table.tHead, sigh
    if (table.tHead == null) table.tHead = table.getElementsByTagName('thead')[0];

    if (table.tHead.rows.length != 1) return; // can't cope with two header rows

    // Sorttable v1 put rows with a class of "sortbottom" at the bottom (as
    // "total" rows, for example). This is B&R, since what you're supposed
    // to do is put them in a tfoot. So, if there are sortbottom rows,
    // for backwards compatibility, move them to tfoot (creating it if needed).
    sortbottomrows = [];
    for (var i=0; i<table.rows.length; i++) {
      if (table.rows[i].className.search(/\bsortbottom\b/) != -1) {
        sortbottomrows[sortbottomrows.length] = table.rows[i];
      }
    }
    if (sortbottomrows) {
      if (table.tFoot == null) {
        // table doesn't have a tfoot. Create one.
        tfo = document.createElement('tfoot');
        table.appendChild(tfo);
      }
      for (var i=0; i<sortbottomrows.length; i++) {
        tfo.appendChild(sortbottomrows[i]);
      }
      delete sortbottomrows;
    }

    // work through each column and calculate its type
    headrow = table.tHead.rows[0].cells;
    for (var i=0; i<headrow.length; i++) {
      // manually override the type with a sorttable_type attribute
      if (!headrow[i].className.match(/\bsorttable_nosort\b/)) { // skip this col
        mtch = headrow[i].className.match(/\bsorttable_([a-z0-9]+)\b/);
        if (mtch) { override = mtch[1]; }
	      if (mtch && typeof sorttable["sort_"+override] == 'function') {
	        headrow[i].sorttable_sortfunction = sorttable["sort_"+override];
	      } else {
	        headrow[i].sorttable_sortfunction = sorttable.guessType(table,i);
	      }
	      // make it clickable to sort
	      headrow[i].sorttable_columnindex = i;
	      headrow[i].sorttable_tbody = table.tBodies[0];
	      dean_addEvent(headrow[i],"click", sorttable.innerSortFunction = function(e) {

          if (this.className.search(/\bsorttable_sorted\b/) != -1) {
            // if we're already sorted by this column, just
            // reverse the table, which is quicker
            sorttable.reverse(this.sorttable_tbody);
            this.className = this.className.replace('sorttable_sorted',
                                                    'sorttable_sorted_reverse');
            this.removeChild(document.getElementById('sorttable_sortfwdind'));
            sortrevind = document.createElement('span');
            sortrevind.id = "sorttable_sortrevind";
            sortrevind.innerHTML = stIsIE ? '&nbsp<font face="webdings">5</font>' : '&nbsp;&#x25B4;';
            this.appendChild(sortrevind);
            return;
          }
          if (this.className.search(/\bsorttable_sorted_reverse\b/) != -1) {
            // if we're already sorted by this column in reverse, just
            // re-reverse the table, which is quicker
            sorttable.reverse(this.sorttable_tbody);
            this.className = this.className.replace('sorttable_sorted_reverse',
                                                    'sorttable_sorted');
            this.removeChild(document.getElementById('sorttable_sortrevind'));
            sortfwdind = document.createElement('span');
            sortfwdind.id = "sorttable_sortfwdind";
            sortfwdind.innerHTML = stIsIE ? '&nbsp<font face="webdings">6</font>' : '&nbsp;&#x25BE;';
            this.appendChild(sortfwdind);
            return;
          }

          // remove sorttable_sorted classes
          theadrow = this.parentNode;
          forEach(theadrow.childNodes, function(cell) {
            if (cell.nodeType == 1) { // an element
              cell.className = cell.className.replace('sorttable_sorted_reverse','');
              cell.className = cell.className.replace('sorttable_sorted','');
            }
          });
          sortfwdind = document.getElementById('sorttable_sortfwdind');
          if (sortfwdind) { sortfwdind.parentNode.removeChild(sortfwdind); }
          sortrevind = document.getElementById('sorttable_sortrevind');
          if (sortrevind) { sortrevind.parentNode.removeChild(sortrevind); }

          this.className += ' sorttable_sorted';
          sortfwdind = document.createElement('span');
          sortfwdind.id = "sorttable_sortfwdind";
          sortfwdind.innerHTML = stIsIE ? '&nbsp<font face="webdings">6</font>' : '&nbsp;&#x25BE;';
          this.appendChild(sortfwdind);

	        // build an array to sort. This is a Schwartzian transform thing,
	        // i.e., we "decorate" each row with the actual sort key,
	        // sort based on the sort keys, and then put the rows back in order
	        // which is a lot faster because you only do getInnerText once per row
	        row_array = [];
	        col = this.sorttable_columnindex;
	        rows = this.sorttable_tbody.rows;
	        for (var j=0; j<rows.length; j++) {
	          row_array[row_array.length] = [sorttable.getInnerText(rows[j].cells[col]), rows[j]];
	        }
	        /* If you want a stable sort, uncomment the following line */
	        //sorttable.shaker_sort(row_array, this.sorttable_sortfunction);
	        /* and comment out this one */
	        row_array.sort(this.sorttable_sortfunction);

	        tb = this.sorttable_tbody;
	        for (var j=0; j<row_array.length; j++) {
	          tb.appendChild(row_array[j][1]);
	        }

	        delete row_array;
	      });
	    }
    }
  },

  guessType: function(table, column) {
    // guess the type of a column based on its first non-blank row
    sortfn = sorttable.sort_alpha;
    for (var i=0; i<table.tBodies[0].rows.length; i++) {
      text = sorttable.getInnerText(table.tBodies[0].rows[i].cells[column]);
      if (text != '') {
        if (text.match(/^-?[�$�]?[\d,.]+%?$/)) {
          return sorttable.sort_numeric;
        }
        // check for a date: dd/mm/yyyy or dd/mm/yy
        // can have / or . or - as separator
        // can be mm/dd as well
        possdate = text.match(sorttable.DATE_RE)
        if (possdate) {
          // looks like a date
          first = parseInt(possdate[1]);
          second = parseInt(possdate[2]);
          if (first > 12) {
            // definitely dd/mm
            return sorttable.sort_ddmm;
          } else if (second > 12) {
            return sorttable.sort_mmdd;
          } else {
            // looks like a date, but we can't tell which, so assume
            // that it's dd/mm (English imperialism!) and keep looking
            sortfn = sorttable.sort_ddmm;
          }
        }
      }
    }
    return sortfn;
  },

  getInnerText: function(node) {
    // gets the text we want to use for sorting for a cell.
    // strips leading and trailing whitespace.
    // this is *not* a generic getInnerText function; it's special to sorttable.
    // for example, you can override the cell text with a customkey attribute.
    // it also gets .value for <input> fields.

    if (!node) return "";

    hasInputs = (typeof node.getElementsByTagName == 'function') &&
                 node.getElementsByTagName('input').length;

    if (node.getAttribute("sorttable_customkey") != null) {
      return node.getAttribute("sorttable_customkey");
    }
    else if (typeof node.textContent != 'undefined' && !hasInputs) {
      return node.textContent.replace(/^\s+|\s+$/g, '');
    }
    else if (typeof node.innerText != 'undefined' && !hasInputs) {
      return node.innerText.replace(/^\s+|\s+$/g, '');
    }
    else if (typeof node.text != 'undefined' && !hasInputs) {
      return node.text.replace(/^\s+|\s+$/g, '');
    }
    else {
      switch (node.nodeType) {
        case 3:
          if (node.nodeName.toLowerCase() == 'input') {
            return node.value.replace(/^\s+|\s+$/g, '');
          }
        case 4:
          return node.nodeValue.replace(/^\s+|\s+$/g, '');
          break;
        case 1:
        case 11:
          var innerText = '';
          for (var i = 0; i < node.childNodes.length; i++) {
            innerText += sorttable.getInnerText(node.childNodes[i]);
          }
          return innerText.replace(/^\s+|\s+$/g, '');
          break;
        default:
          return '';
      }
    }
  },

  reverse: function(tbody) {
    // reverse the rows in a tbody
    newrows = [];
    for (var i=0; i<tbody.rows.length; i++) {
      newrows[newrows.length] = tbody.rows[i];
    }
    for (var i=newrows.length-1; i>=0; i--) {
       tbody.appendChild(newrows[i]);
    }
    delete newrows;
  },

  /* sort functions
     each sort function takes two parameters, a and b
     you are comparing a[0] and b[0] */
  sort_numeric: function(a,b) {
    aa = parseFloat(a[0].replace(/[^0-9.-]/g,''));
    if (isNaN(aa)) aa = 0;
    bb = parseFloat(b[0].replace(/[^0-9.-]/g,''));
    if (isNaN(bb)) bb = 0;
    return aa-bb;
  },
  sort_alpha: function(a,b) {
    if (a[0]==b[0]) return 0;
    if (a[0]<b[0]) return -1;
    return 1;
  },
  sort_ddmm: function(a,b) {
    mtch = a[0].match(sorttable.DATE_RE);
    y = mtch[3]; m = mtch[2]; d = mtch[1];
    if (m.length == 1) m = '0'+m;
    if (d.length == 1) d = '0'+d;
    dt1 = y+m+d;
    mtch = b[0].match(sorttable.DATE_RE);
    y = mtch[3]; m = mtch[2]; d = mtch[1];
    if (m.length == 1) m = '0'+m;
    if (d.length == 1) d = '0'+d;
    dt2 = y+m+d;
    if (dt1==dt2) return 0;
    if (dt1<dt2) return -1;
    return 1;
  },
  sort_mmdd: function(a,b) {
    mtch = a[0].match(sorttable.DATE_RE);
    y = mtch[3]; d = mtch[2]; m = mtch[1];
    if (m.length == 1) m = '0'+m;
    if (d.length == 1) d = '0'+d;
    dt1 = y+m+d;
    mtch = b[0].match(sorttable.DATE_RE);
    y = mtch[3]; d = mtch[2]; m = mtch[1];
    if (m.length == 1) m = '0'+m;
    if (d.length == 1) d = '0'+d;
    dt2 = y+m+d;
    if (dt1==dt2) return 0;
    if (dt1<dt2) return -1;
    return 1;
  },

  shaker_sort: function(list, comp_func) {
    // A stable sort function to allow multi-level sorting of data
    // see: http://en.wikipedia.org/wiki/Cocktail_sort
    // thanks to Joseph Nahmias
    var b = 0;
    var t = list.length - 1;
    var swap = true;

    while(swap) {
        swap = false;
        for(var i = b; i < t; ++i) {
            if ( comp_func(list[i], list[i+1]) > 0 ) {
                var q = list[i]; list[i] = list[i+1]; list[i+1] = q;
                swap = true;
            }
        } // for
        t--;

        if (!swap) break;

        for(var i = t; i > b; --i) {
            if ( comp_func(list[i], list[i-1]) < 0 ) {
                var q = list[i]; list[i] = list[i-1]; list[i-1] = q;
                swap = true;
            }
        } // for
        b++;

    } // while(swap)
  }
}





/* for Mozilla/Opera9 */
if (document.addEventListener) {
    document.addEventListener("DOMContentLoaded", sorttable.init, false);
}

/* for Internet Explorer */
/*@cc_on @*/
/*@if (@_win32)
    document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
    var script = document.getElementById("__ie_onload");
    script.onreadystatechange = function() {
        if (this.readyState == "complete") {
            sorttable.init(); // call the onload handler
        }
    };
/*@end @*/

/* for Safari */
if (/WebKit/i.test(navigator.userAgent)) { // sniff
    var _timer = setInterval(function() {
        if (/loaded|complete/.test(document.readyState)) {
            sorttable.init(); // call the onload handler
        }
    }, 10);
}

/* for other browsers */
window.onload = sorttable.init;

// written by Dean Edwards, 2005
// with input from Tino Zijdel, Matthias Miller, Diego Perini

// http://dean.edwards.name/weblog/2005/10/add-event/

function dean_addEvent(element, type, handler) {
	if (element.addEventListener) {
		element.addEventListener(type, handler, false);
	} else {
		// assign each event handler a unique ID
		if (!handler.$$guid) handler.$$guid = dean_addEvent.guid++;
		// create a hash table of event types for the element
		if (!element.events) element.events = {};
		// create a hash table of event handlers for each element/event pair
		var handlers = element.events[type];
		if (!handlers) {
			handlers = element.events[type] = {};
			// store the existing event handler (if there is one)
			if (element["on" + type]) {
				handlers[0] = element["on" + type];
			}
		}
		// store the event handler in the hash table
		handlers[handler.$$guid] = handler;
		// assign a global event handler to do all the work
		element["on" + type] = handleEvent;
	}
};
// a counter used to create unique IDs
dean_addEvent.guid = 1;

function removeEvent(element, type, handler) {
	if (element.removeEventListener) {
		element.removeEventListener(type, handler, false);
	} else {
		// delete the event handler from the hash table
		if (element.events && element.events[type]) {
			delete element.events[type][handler.$$guid];
		}
	}
};

function handleEvent(event) {
	var returnValue = true;
	// grab the event object (IE uses a global event object)
	event = event || fixEvent(((this.ownerDocument || this.document || this).parentWindow || window).event);
	// get a reference to the hash table of event handlers
	var handlers = this.events[event.type];
	// execute each event handler
	for (var i in handlers) {
		this.$$handleEvent = handlers[i];
		if (this.$$handleEvent(event) === false) {
			returnValue = false;
		}
	}
	return returnValue;
};

function fixEvent(event) {
	// add W3C standard event methods
	event.preventDefault = fixEvent.preventDefault;
	event.stopPropagation = fixEvent.stopPropagation;
	return event;
};
fixEvent.preventDefault = function() {
	this.returnValue = false;
};
fixEvent.stopPropagation = function() {
  this.cancelBubble = true;
}

// Dean's forEach: http://dean.edwards.name/base/forEach.js
/*
	forEach, version 1.0
	Copyright 2006, Dean Edwards
	License: http://www.opensource.org/licenses/mit-license.php
*/

// array-like enumeration
if (!Array.forEach) { // mozilla already supports this
	Array.forEach = function(array, block, context) {
		for (var i = 0; i < array.length; i++) {
			block.call(context, array[i], i, array);
		}
	};
}

// generic enumeration
Function.prototype.forEach = function(object, block, context) {
	for (var key in object) {
		if (typeof this.prototype[key] == "undefined") {
			block.call(context, object[key], key, object);
		}
	}
};

// character enumeration
String.forEach = function(string, block, context) {
	Array.forEach(string.split(""), function(chr, index) {
		block.call(context, chr, index, string);
	});
};

// globally resolve forEach enumeration
var forEach = function(object, block, context) {
	if (object) {
		var resolve = Object; // default
		if (object instanceof Function) {
			// functions have a "length" property
			resolve = Function;
		} else if (object.forEach instanceof Function) {
			// the object implements a custom forEach method so use that
			object.forEach(block, context);
			return;
		} else if (typeof object == "string") {
			// the object is a string
			resolve = String;
		} else if (typeof object.length == "number") {
			// the object is array-like
			resolve = Array;
		}
		resolve.forEach(object, block, context);
	}
};
</script>
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>
</html>