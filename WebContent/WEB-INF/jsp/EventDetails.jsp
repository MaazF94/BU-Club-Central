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

		<!-- End of header -->
	



<!-- Page Content-->
      <main class="page-content section-98 section-sm-110">
        <div class="shell">
          <div class="range range-xs-center">
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
                                  <article class="post post-default text-left">
                                    <!-- Post Header-->
                                    <div class="header post-header">
                                      <!-- Post Meta-->
                                      <ul class="post-controls list-inline list-inline-sm p text-dark">
                                        
                                        <li><a href="#" class=" masterToolTip text-middle icon-xxs text-picton-red mdi mdi-account-outline text-carrot " title="Number of people coming">&nbsp;</a><%=event.getRsvp_count()%><span class="text-middle small"></span></li>
                                        
                                        
                                        <li><span class=" masterToolTip text-middle icon-xxs text-picton-red mdi mdi-map-marker-multiple text-carrot" title="Location of the event">&nbsp;</span><a href="#" class="text-middle small"><span>&nbsp;<%=event.getLocation()%></span></a></li>
                                      </ul>
                                      <!-- Post Meta-->
                                      <h3 class="post-title"><a href="#"><%=event.getEvent_name()%></a></h3>
                                      <!-- Post Media-->
                                      <div class="post-media offset-top-34">
                                        
                                      </div>
                                    </div>
                                    <!-- PostContent-->
                                    <section class="post-content offset-top-41">
                                      <p><%=event.getDescription()%></p>
                                      
                                    </section>
                                  </article>
                  <footer class="offset-top-50 text-sm-left clearfix">
                    <h6 class="pull-sm-left">Please Join Us:</h6>
                    <ul class="list-inline small pull-sm-right p offset-top-0 text-sm-right">
                      <li><form action="RSVPServlet" method="POST">

									<button class="btn btn-default " type="submit" name="eventId"
										value="<%=Integer.parseInt(request.getParameter("eventId"))%>">RSVP</button>
								</form></li>
                      
                    </ul>
                  </footer>
                  
                  
                  <div id="comments"></div>
                  <hr class="offset-top-66">
                  <h4 class="offset-top-66 text-uppercase text-spacing-120 text-left text-bold">Comments</h4>
                  <div class="offset-top-41">
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
                                    <div class="box-comment text-left box-comment-outboxed">
                                      <div class="media">
                                        
                                        <div class="media-body">
                                          <header class="box-comment-header unit unit-vertical unit-spacing-xxs unit-md unit-md-horizontal unit-md-inverse unit-md-middle unit-md-align-right">
                                            <div class="unit-left unit-grow-1">
                                              <ul class="box-comment-meta list-inline list-inline-sm text-dark">
                                                <li><span class="box-comment-icon mdi mdi-clock"></span>
                                                  <time datetime="2016-01-01">Feb 17, 7:34</time>
                                                </li>
                                                <li><a href="#like"><span class="box-comment-icon mdi mdi-thumb-up-outline"></span> Like</a></li>
                                                <li><a href="#reply"><span class="box-comment-icon mdi mdi-message-outline"></span> Reply</a></li>
                                              </ul>
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
                  <form action="CommentServlet" method="POST" class="rd-mailform offset-top-10 text-left">
                    <div class="form-group">
                      <label for="comment-message" class="form-label form-label-outside">Message:</label>
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
                    <h6 class="text-uppercase text-spacing-60">Clubs</h6>
                    <div class="text-subline"></div>
                    <ul class="list list-marked offset-top-30">
                      <li><a href="#">Computer Science  <span class="text-dark">(0)</span></a></li>
                      
                    </ul>
                  </div>
                  
                  
                  
                </div>
                <!-- Search Form-->
                <h6 class="text-uppercase text-spacing-60">Search</h6>
                <div class="text-subline"></div>
                <div class="offset-top-34">
                                <!-- RD Search Form-->
                               <form name="vinform">
								<input placeholder="Enter title of event" type="text"
									name="name" onkeyup="searchInfo()">
							</form>

                </div>
              </aside>
            </div>
          </div>
        </div>
        
          <div class="row">
          	<div class="container">
          		<div class="col-lg-12">
          			<table>
                  	<thead>
                  		<tr>
                  			<th><h1>Users Going</h1></th>
                  		</tr>
                  	</thead>
                  	<tbody>
                  		<% int rsvpIndex = 0;
                  			int rsvpListSize = userList.size();
                  		
                  		%>
                  		<%while(rsvpIndex < rsvpListSize) { %>
                  		<tr>
                  			<td><%=userList.get(rsvpIndex).getFirst_name() + " " + userList.get(rsvpIndex).getLast_name() %> </td>
                  		</tr>
                  		
                  		<%rsvpIndex++; %>
						<%} %>                  		
                  		
                  	</tbody>
                  
                  
                  </table>
          		</div>
          	</div>
          </div>
        
      </main>
      
     

























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