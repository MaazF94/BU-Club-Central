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
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Timestamp" %>

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

		<style>
.tooltip {
	display:none;
	position:absolute;
	border:1px solid #333;
	background-color:#161616;
	border-radius:5px;
	padding:10px;
	color:#fff;
	font-size:12px Arial;
}
</style>
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
                <%
					ClubDao clubDao = new ClubDao();
					EventsDao eventDao = new EventsDao();
					Events event = eventDao.getEventByEventId(Integer.parseInt(request.getParameter("eventId")));
					
					EventRSVPListDao rsvpDao = new EventRSVPListDao();
					LinkedList<User> userList = rsvpDao.getAllUsersForEvent(Integer.parseInt(request.getParameter("eventId")));
				%>
                                  <!-- Post Wide-->
                                  <article class="post post-default text-left well">
                                    <!-- Post Header-->
                                    <div class="header post-header">
                                      <!-- Post Meta-->
                                      <ul class="post-controls list-inline list-inline-sm p text-dark">
                                      <li><h3 class="post-title text-default"><a><%=event.getEvent_name()%></a></h3></li>
                                        
                                        <li><span class="text-middle icon-xxs text-picton-red mdi mdi-account-outline text-carrot">&nbsp;</span><%=event.getRsvp_count()%><span class="text-middle small"></span></li>
                                        
                                        
                                        <li><span class="text-middle icon-xxs text-picton-red mdi mdi-map-marker-multiple text-carrot">&nbsp;</span><a href="#" class="text-middle small"><span>&nbsp;<%=event.getLocation()%></span></a></li>
                                      
                                                                              <li><a href="#" class=" masterToolTip text-middle icon-xxs text-picton-red mdi mdi-account-outline text-carrot " title="Number of people coming">&nbsp;</a><%=event.getRsvp_count()%><span class="text-middle small"></span></li>
                                        
                                        
                                        <li><span class=" masterToolTip text-middle icon-xxs text-picton-red mdi mdi-map-marker-multiple text-carrot" title="Location of the event">&nbsp;</span><a href="#" class="text-middle small"><span>&nbsp;<%=event.getLocation()%></span></a></li>
                                      </ul>
                                        
                                      <!-- Post Meta-->
                                      
                                      <!-- Post Media-->
                                      
                                    </div>
                                    <!-- PostContent-->
                                    <section class="post-content offset-top-41">
                                    <p><%= event.getDescription() %></p>
                                     
                                    </section>
                                    </article>
                                    <%if (((User) session.getAttribute("user")) != null) { %>
                    <h6 class="pull-sm-left">Please Join Us:</h6>
                    <ul class="list-inline small pull-sm-right p offset-top-0 text-sm-right">
                      <li>
										
                                      <a class="offset-top-24 btn btn"><%
										
										boolean rsvpBoolean = rsvpDao.checkUserRsvpForEvent(event.getEventId(), ((User)session.getAttribute("user")).getId_num());
									%>
									
									<%if(!rsvpBoolean) { %>
										
										<form action="RSVPServlet" method="POST">

											<button class="btn btn-default " type="submit" name="eventId"
												value="<%=event.getEventId()%>">RSVP For Event</button>
										</form>
										
									
									
									<%}else { %>
										
											<form action="RSVPServlet" method="POST">

											<button disabled class="btn btn-default" type="submit" name="eventId"
												value="<%=event.getEventId()%>">Already Going</button>
										</form>
										
										
									
									<%} } %></a></li>
                      
                    </ul>
                                         <div id="comments"></div>
                  <hr class="offset-top-66">
                  <h4 class="offset-top-66 text-uppercase text-spacing-120 text-left text-bold">Comments</h4>
                  <div class="offset-top-41 well">
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
                                                     
                                    <!-- Box Comment-->
                                    <div class="box-comment text-left box-comment-outboxed bg-gray-lightest">
                                      <div class="media">
                                        
                                        <div class="media-body">
                                          <header class="box-comment-header unit unit-vertical unit-spacing-xxs unit-md unit-md-horizontal unit-md-inverse unit-md-middle unit-md-align-right">
                                            <div class="unit-left unit-grow-1">
                                              <ul class="box-comment-meta list-inline list-inline-sm text-dark">
                                                <li><span class="box-comment-icon mdi mdi-clock"></span>
                                               <% SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                               SimpleDateFormat sdfOut = new SimpleDateFormat("h:mm a  MMM d, ''yy");
                                               String input = commentList.get(commentListIndex).getCreatedOn();
                                               Date date = sdfIn.parse(input);%>
                                             
                                                  <time datetime="2016-01-01 text-white"><%=sdfOut.format(date) %></time>
                                             
                                                
                                                </li>
                                                <%if (((User) session.getAttribute("user")) != null) { %>
                                                <li><form action ="LikeServlet" method = "POST" ><button class = "btn-info" type = "submit" name = "commentID" id = "commentID" value =<%=commentList.get(commentListIndex).getIdcomment() %> ><span class="box-comment-icon mdi mdi-thumb-up-outline"></span> Like</button></form></li>
                                                <li><a href="#"><span class=""></span>Current likes: <%=commentDao.getNumOfLikes(commentList.get(commentListIndex).getIdcomment()) %></a></li>
                                              </ul>
                                              <%} %>
                                            </div>
                                            <div class="unit-body">
                                              <h6 class="box-comment-title"><%
													user = userDao.getUserByIdNum(commentList.get(commentListIndex).getUserId());
												%> By: <%=user.getFirst_name()%></h6>
                                            </div>
                                          </header>
                                          <section class="box-comment-body">
                                            <p><%=commentList.get(commentListIndex).getComment()%></p>
                                          </section>
                                        </div>
                                      </div>
                                    </div>
                                    <%
											commentListIndex++;
										%>
										<%
											}
										%>
                  </div>
                  <h4 class="offset-top-34 text-uppercase text-spacing-120 text-left text-bold">Leave a comment</h4>
                  <form action="CommentServlet" method="POST" class="rd-mailform offset-top-10 text-left well">
                    <div class="form-group">
                      <textarea class="form-control"
							onkeyup="textCounter(this,'counter',250);" rows="4" cols="30"
							name="comment"
							placeholder="Enter your comment here... 250 Characters max"></textarea>
                    </div>
                    <div class="group-sm text-center text-lg-left offset-top-30">
                      <button class="btn btn-md btn-primary" type="submit"
							name="commentId_eventId"
							value="<%=Integer.parseInt(request.getParameter("eventId"))%>">Comment
						</button>
                    <h6 class="pull-right">
							<input disabled maxlength="1" size="1" class= "" value="250" id="counter">
							Remaining
						</h6>
                    </div>
                    
                  </form>                                                   
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
			clubList = cDao2.displayClub();

			int index = 0;
		%>
                    <h6 class="text-uppercase text-spacing-60">Clubs</h6>
                    <div class="text-subline"></div>
                    <ul class="list list-marked offset-top-30">
                    <%
							while (index < clubList.size()) {
						%>
                      <li><form action ="EventpageByClub" method="POST" >
                      <button type="submit" name="clubID" value=<%=clubList.get(index).getClub_id_num()%>><span class="text-dark"><%
												out.println(clubList.get(index).getClub_name());
											%>(<%= eventDao.getAllEventsByClubId(clubList.get(index).getClub_id_num()).size() %>)</span></button></form></li>
												<%
										index++;
										}
									%>
                      
                    </ul>
                    
                  </div>
                  
                </div>
                     <div class="range offset-top-41">
                  <div class="cell-xs-6 cell-md-12">
                    <!-- Category-->
                    <h6 class="text-uppercase text-spacing-60">Users Going</h6>
                    <div class="text-subline"></div>
                        <%
                         int rsvpIndex = 0;
              			int rsvpListSize = userList.size();
              		
              		%>
              		
	
                   <ul class="list list-marked offset-top-30">
                    <%while(rsvpIndex < rsvpListSize) { %>
                    <li><a href="#"><%=userList.get(rsvpIndex).getFirst_name() + " " + userList.get(rsvpIndex).getLast_name() %><span class="text-dark"></span></a></li>
                     <%rsvpIndex++; %>
						<%} %>           
                      
                    </ul>
                  </div>
                  
                  
                  
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
					<div class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
					<br>
					<p><b>Some Useful links</b></p>
					<a href= "HomeServlet">Home</a><br>
					<a href= "EventServlet">Events</a><br>
					<a href= "clublistServlet">Clubs</a><br>
					<a href= "ContactUsServlet">Contact Us</a><br>
					<a href= "MeetTheAdminsServlet">About Us</a><br>
					<a href= "BenUnionServlet">Bendictine Underground</a><br>
					</div>
					
						<div class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
							<!-- Footer brand-->
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
								<img src="img/Entrance.jpg" width = "80%" height = "80%">
							<p class="text-darker offset-top-20">
								The F.I.R.M &copy; <span id="copyright-year"></span> . <a
									href="privacy.html">Privacy Policy</a>
									<a style="color: white;" href="FAQServlet">Frequently Asked Questions</a>
								<!-- {%FOOTER_LINK}-->
							</p>
						</div>
					</div>
					<div class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
						<br>
						<br>
						<br>
						<a href= "loginServlet">Login</a><br>
						<a href= "RegisterServlet">Register</a><br>
						<a href= "forgotPasswordServlet">Forgot Password?</a><br>
						<a href= "forgotUsernameServlet">Forot Username?</a><br>
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
		 <script type="text/javascript">
$(document).ready(function() {
// Tooltip only Text
$('.masterTooltip').hover(function(){
        // Hover over code
        var title = $(this).attr('title');
        $(this).data('tipText', title).removeAttr('title');
        $('<p class="tooltip"></p>')
        .text(title)
        .appendTo('body')
        .fadeIn('slow');
}, function() {
        // Hover out code
        $(this).attr('title', $(this).data('tipText'));
        $('.tooltip').remove();
}).mousemove(function(e) {
        var mousex = e.pageX + 20; //Get X coordinates
        var mousey = e.pageY + 10; //Get Y coordinates
        $('.tooltip')
        .css({ top: mousey, left: mousex })
});
});
</script>
</body>

</html>