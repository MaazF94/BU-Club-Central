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
    <title>Contact Us</title>
   
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="keywords" content="intense web design multipurpose template">
    <meta name="date" content="Dec 26">
    <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />
    <!-- Stylesheets-->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu:400,400italic,500,700,700italic">
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
     <header class="page-head slider-menu-position">
        <!-- RD Navbar Transparent-->
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
								<a href="HomeServlet"><img class='img-responsive' width='238'
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

				</div>
			</div>
			</nav>
        </div>
        <div class="context-dark">
          <!-- Modern Breadcrumbs-->
          <section class="breadcrumb-modern rd-parallax bg-gray-darkest">
            <div data-speed="0.2" data-type="media" data-url="images/background-04-1920x750.jpg" class="rd-parallax-layer"></div>
            <div data-speed="0" data-type="html" class="rd-parallax-layer">
              <div class="shell section-top-98 section-bottom-34 section-md-bottom-66 section-md-98 section-lg-top-110 section-lg-bottom-41">
             <!--   <h2 class="veil reveal-md-block offset-top-30"><span class="big">Admin Home</span></h2>-->
                
              </div>
            </div>
          </section>
        </div>
      </header>
      <!-- Page Contents-->
      <main class="page-content">
        <section class="section-top-98 section-md-top-110 text-lg-left">
          <div class="shell">
         
            <div class="range range-xs-center range-xs-center">
             <h1>Welcome</h1>
			
               <!-- Put dashboard code here -->
               
               
				<div class="row">
			<div class="container">
				<div class="container" style="height: 100px"></div>
				<div class="col-lg-12">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#editClubs"
							aria-controls="editClubs" role="tab" data-toggle="tab">Edit
								Clubs</a></li>
						<li role="presentation" ><a href="#editEvents"
							aria-controls="editEvents" role="tab" data-toggle="tab">Edit
								Events</a></li>
						<li role="presentation"><a href="#editComments"
							aria-controls="editComments" role="tab" data-toggle="tab">Edit
								Comments</a></li>
						<li role="presentation"><a href="#editPosts"
							aria-controls="editPosts" role="tab" data-toggle="tab">Edit
								Posts</a></li>
						<li role="presentation" ><a href="#editUsers"
							aria-controls="editUsers" role="tab" data-toggle="tab">Edit
								Users</a></li>

					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="editClubs">
					<div class="container">
							<%ClubDao clubDao = new ClubDao();
								LinkedList<Club> clubList = new LinkedList<Club>();
								clubList = clubDao.getAllClubs();
								
								int clubListIndex = 0;
								int clubListSize = clubList.size();
							%>
							
							<table class="table table-hover">
									<thead>
										<tr>
											<th>Club ID Number</th>
											<th>Club Name</th>
											<th>Member count</th>
											<th>Enabled (1)/Disabled (0)</th>
											<th></th>
										</tr>
									</thead>
							<%while (clubListIndex < clubListSize) { %>
								
									<tbody>
										<tr>
											<td><%=clubList.get(clubListIndex).getClub_id_num() %></td>
											<td><%=clubList.get(clubListIndex).getClub_name() %> </td>
											<td><%=clubList.get(clubListIndex).getMemeber_count() %> </td>
											<td><%=clubList.get(clubListIndex).getEnabled() %> </td>
											<td>
												<form action="AdminDeleteClubServlet" method="POST" onsubmit="return confirm('Are you sure you want to disable this club.');">
													<%int clubId = clubList.get(clubListIndex).getClub_id_num();%>
													<button class="btn btn-danger" type="submit" name="disableClubId" value="<%=clubId%>">Disable</button>
												
												</form>
												<form action="AdminEnableClubServlet" method="POST" onsubmit="return confirm('Are you sure you want to enable this club.');">
													<%int clubId2 = clubList.get(clubListIndex).getClub_id_num();%>
													<button class="btn btn-warning" type="submit" name="enableClubId" value="<%=clubId2%>">Enable</button>
												
												</form>
											
											
											</td>
										</tr>
									</tbody>
							
							<%clubListIndex++; %>
							<% }%>
							</table>
						</div>
					</div>
					
						<div role="tabpanel" class="tab-pane " id="editEvents">
							<div class="container">
								<%
									LinkedList<Events> eventList = new LinkedList<Events>();
									EventsDao eDao = new EventsDao();
									eventList = eDao.getAllEvents();
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
											<td><form action="AdminDeleteEventServlet" method="POST" onsubmit="return confirm('Are you sure you want to delete this event.');">
													<button class="btn btn-danger" type="submit"
														name="deleteEventId"
														value="<%=eventList.get(eventListIndex).getEventId()%>">Delete</button>
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
									eventList2 = eDao.getAllEvents();
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
											<td><%u = uDao2.getUserByIdNum(commentList.get(commentListIndex).getUserId()); %>
												<%=u.getFirst_name() + " " + u.getLast_name()%>
											</td>
											<td>
												<form action="AdminDeleteCommentServlet" method="POST" onsubmit="return confirm('Are you sure you want to delete this event.');">
													<button class="btn btn-danger" type="submit"
														name="deleteCommentId" value="<%=commentList.get(commentListIndex).getIdcomment()%>">Delete</button>
												
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
								postList = pDao.getAllPosts();
								
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
												<form action="AdminDeletePostServlet" method="POST">
													<%int postId = postList.get(postListIndex).getIdpost();%>
													<button class="btn btn-danger" type="submit" name="deletePostId" value="<%=postId%>">Delete</button>
												
												</form>
											
											</td>
										</tr>
									</tbody>
							
							<%postListIndex++; %>
							<% }%>
							</table>
						</div>
						
						
						<div role="tabpanel" class="tab-pane " id="editUsers">
							<div class="container">
								<%LinkedList<User> userList = new LinkedList<User>();
									UserDao uDao = new UserDao();
									userList = uDao.getAllUsers();
									
									int userListIndex = 0;
									int userListSize = userList.size();
								
								%>
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Name</th>
											<th>User Name</th>
											<th>ID Number</th>
											<th>Email</th>
											<th>Role ID</th>
											<th>Enabled/Disabled</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody
										style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display:">
										<%
											while (userListIndex < userListSize) {
										%>
										<tr>
											<td><%=userList.get(userListIndex).getFirst_name() + " " + userList.get(userListIndex).getLast_name()%></td>
											<td><%=userList.get(userListIndex).getUsername() %></td>
											<td><%=userList.get(userListIndex).getId_num() %></td>
											<td><%=userList.get(userListIndex).getEmail() %></td>
											<td><%=userList.get(userListIndex).getRole_id() %></td>
											<td><%=userList.get(userListIndex).getEnabled() %></td>
											
											<td><form action="AdminDeleteUserServlet" method="POST" onsubmit="return confirm('Are you sure you want to disable this user.');">
													<button class="btn btn-danger" type="submit" name="deleteUserId"
														<%int userId = userList.get(userListIndex).getId_num();%> value="<%=userId %>">Delete</button>
													
												</form>
												
												<form action="AdminEnableUserServlet" method="POST" onsubmit="return confirm('Are you sure you want to enable this user.');">
													<button class="btn btn-warning" type="submit" name="enableUserId"
														<%int userId2 = userList.get(userListIndex).getId_num();%> value="<%=userId2 %>">Enable</button>
													
												</form>
												
											</td>
											
										</tr>

										<%
											userListIndex++;
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
      </main>
    <!-- Page Footer -->
	<footer class="section-relative section-top-66 section-bottom-34 page-footer bg-gray-base context-dark">
        <div class="shell">
          <div class="range range-sm-center text-lg-left">
            <div class="cell-sm-12">
              <div class="range range-xs-center">
               
                
                 <div class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
                  
                  
                        
                      
                      
  
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
            <button title="Close (Esc)" class="pswp__button pswp__button--close"></button>
            <button title="Share" class="pswp__button pswp__button--share"></button>
            <button title="Toggle fullscreen" class="pswp__button pswp__button--fs"></button>
            <button title="Zoom in/out" class="pswp__button pswp__button--zoom"></button>
            <div class="pswp__preloader">
              <div class="pswp__preloader__icn">
                <div class="pswp__preloader__cut">
                  <div class="pswp__preloader__donut"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
            <div class="pswp__share-tooltip"></div>
          </div>
          <button title="Previous (arrow left)" class="pswp__button pswp__button--arrow--left"></button>
          <button title="Next (arrow right)" class="pswp__button pswp__button--arrow--right"></button>
          <div class="pswp__caption">
            <div class="pswp__caption__center"></div>
          </div>
        </div>
      </div>
    </div>
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
	
	
    
    <script src="js/js/core.min.js"></script>
    <script src="js/js/script.js"></script>
  </body>

</html>