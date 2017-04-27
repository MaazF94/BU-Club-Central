<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">

<%@ page import="edu.ben.bu_club_central.models.User"%>
<%@ page import="edu.ben.bu_club_central.models.Events"%>
<%@ page import="edu.ben.bu_club_central.models.Club"%>
<%@ page import="edu.ben.bu_club_central.models.Comment"%>
<%@ page import="edu.ben.bu_club_central.models.PostComments"%>
<%@ page import="edu.ben.bu_club_central.models.Post"%>
<%@ page import="edu.ben.bu_club_central.daos.UserDao"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubDao"%>
<%@ page import="edu.ben.bu_club_central.daos.EventsDao"%>
<%@ page import="edu.ben.bu_club_central.daos.PostDao"%>
<%@ page import="edu.ben.bu_club_central.daos.CommentDao"%>
<%@ page import="edu.ben.bu_club_central.daos.PostCommentDao"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubMembershipDao"%>


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
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3);
     clear: both; text-align:center; position: relative; z-index:1;"><a href=
     "http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg"
      border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, 
      safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]-->
</head>
<body>
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
						<a href="index.html"><img class='img-responsive' width='40'
							height='30' src='img/BURedTransparent.png' alt='' /></a>
					</div>


				<div class="rd-navbar-menu-wrap">
					<div class="rd-navbar-nav-wrap">
						<div class="rd-navbar-mobile-scroll">


							<!--Navbar Brand Mobile-->
							<div class="rd-navbar-mobile-brand">
								<a href="index.html"><img class='img-responsive' width='238'
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
              <div class="shell section-top-98   ">
               
              </div>
            </div>
          </section>
        </div>
      </header>
		<!-- Page Contents-->
		<div class="jumbotron" style="background-color: #ffffff">
		<section class="section-98 section-sm-110">
          <div class="shell">
            <div class="range range-xs-center range-xs-Left">
              <!-- Simple quote Slider-->
              
              <div class="cell-sm-9 cell-lg-6 cell-lg-pull-6 text-lg-right offset-top-66 offset-lg-top-0 inset-lg-left-30">
                <h1  class="text-danger" >${clubName}</h1>
                <hr class="divider bg-red hr-lg-right-0">
                <p class="offset-top-50 text-sm-left">${clubDescription}</p>
                <div class="offset-top-20">
                	<%
						if (((User) session.getAttribute("user")) != null) {
						ClubMembershipDao cmDao = new ClubMembershipDao();
						int user_id = ((User) session.getAttribute("user")).getUser_id();
						int club_id = (int) request.getAttribute("club_id_num");
						String club_name = (String) request.getAttribute("clubName");
						
						boolean isInClub = cmDao.checkIfUserInClub(club_id, user_id);
						if (!isInClub) {%>
						<form action = "JoinAClubServlet" method="GET">
						<a type="button" class="btn btn-info" href="JoinAClubServlet?club_id_num=<%=(club_id)%>">Join <%
																		out.println(club_name);
																	%></a></form>
						<%
						} else {
							%>
						<a type="button" class="btn btn-warning" 
						href="LeaveClubFromClublistServlet?clubID=<%=(club_id)%>">Leave <%
																		out.println(club_name);
																	%></a>
						<%
						}
						}
					%> 
                </div>
                
              </div>
              
              <div class="cell-sm-9 cell-lg-6 cell-lg-push-6">
              <%int id = (int) request.getAttribute("club_id_num"); %>
                <div data-items="1" data-nav="false" data-dots="false" data-nav-custom=".owl-custom-navigation" class="owl-carousel owl-carousel-classic owl-carousel-class-light shadow-drop-md">
                    <div><img src="/images?club_id_num=<%=id%> }" width="570" height="321" alt="" class="img-responsive element-fullwidth"></div>               
                  </div>
              </div>
            </div>
          </div>
        </section>
        <section>
			<hr class="divider bg-red hr-lg-center-0">
  		</section>
			<section class="section-98 section-sm-110">
		          <div class="shell">
		            <div class="range range-xs-center">
		              <div class="cell-xs-10 cell-sm-5">
		                <!-- Member block type 5-->
		                <div class="member-block-type-5 inset-md-right-20">           
		                	<div style= "">
								<div style="margin: auto">
									<h1>			
									 <%String meetingLoc = (String) request.getAttribute("meetingLoc");
									 String meetingFreq = (String) request.getAttribute("meetingFreq");
									 String meetingTime = (String) request.getAttribute("meetingTime");
									 %>
									 <p><b>Meeting Time:</b> <%=meetingTime%><br>
									<b>Meeting Location:</b> <%=meetingLoc%><br>
									<b>How Often We Meet:</b> <%=meetingFreq%></p>
									</h1>
								</div>
								
								<br>
								<br>
								<br>
									              
					   <%String broadcast = (String) request.getAttribute("broadcast"); %>
					   			  <div class="" style="float: right; font-family:sans-serif;-webkit-font-smoothing:antialiased;font-size:14px;line-height:1.4;margin:0;padding:0;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%;">
								    <table border="0" cellpadding="0" cellspacing="0" class="body" style="border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;">
								      <tr>
								        <td style="font-family:sans-serif;font-size:14px;vertical-align:top;">&nbsp;</td>
								        <td class="container" style="font-family:sans-serif;font-size:14px;vertical-align:top;display:block;max-width:580px;padding:10px;width:580px;Margin:0 auto !important;">
								          <div class="content" style="box-sizing:border-box;display:block;Margin:0 auto;max-width:580px;padding:10px;">
								            <!-- START CENTERED WHITE CONTAINER -->
								            <span class="preheader" style="color:transparent;display:none;height:0;max-height:0;max-width:0;opacity:0;overflow:hidden;mso-hide:all;visibility:hidden;width:0;">Here Is Our Latest Update!</span>
								            <table class="main" style="border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;background:#fff;border-radius:3px;width:100%;">
								              <!-- START MAIN CONTENT AREA -->
								              <tr>
								                <td class="wrapper" style="font-family:sans-serif;font-size:14px;vertical-align:top;box-sizing:border-box;padding:20px;">
								                  <table border="0" cellpadding="0" cellspacing="0" style="border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;">
								                    <tr>
								                      <td style="font-family:sans-serif;font-size:14px;vertical-align:top;">
								                        <p style="font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;"><b>Latest Update,</b></p>
								                        <p style="font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;"><%=broadcast%></p>
								                      </td>
								                    </tr>
								                  </table>
								                </td>
								              </tr>
								              <!-- END MAIN CONTENT AREA -->
								            </table>
								          </div>
								        </td>
								        <td style="font-family:sans-serif;font-size:14px;vertical-align:top;">&nbsp;</td>
								      </tr>
								    </table>
								  </div>
								  <div class="cell-xs-10 cell-sm-7 text-sm-left">
					                <h5 class="offset-top-4">${clubName} Board Members</h5>
					                <hr class="divider bg-red hr-sm-left-0">
					                <p class="offset-top-50 text-left"><b>Board Member 1</b> <br>
										President<br>
									<a style="color: red;" href="">email1@ben.edu</a><br>
									</p>
									<p class="offset-top-50 text-left"><b>Board Member 2</b>
									<br>Vice-President<br>
									<a style="color: red;" href="">email2@ben.edu</a><br>
									</p>
									<p class="offset-top-50 text-left"><b>Board Member 3</b>
									<br>Treasurer<br>
									<a style="color: red;" href="">email3@ben.edu</a><br>
									</p>
									<p class="offset-top-50 text-left"><b>Board Member 4</b>
									<br>Secretary<br>
									<a style="color: red;" href="">email4@ben.edu</a><br>
									</p>
								</div>
		  				</div>
                </div>
              </div>
              <div class="cell-xs-10 cell-sm-7 text-sm-left">
                	<h3>Post Feed (Click button for more info)</h3>	
								<%
									LinkedList<Post> postList = (LinkedList<Post>) request.getAttribute("postList");

									int postListIndex = 0;
									int postListSize = postList.size();
								%>
								
								<%while (postListIndex < postListSize) { %>

									<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#<%=postList.get(postListIndex).getIdpost()%>">
										<%=postList.get(postListIndex).getTitle() %>  </button>
									
									<br>	
									
									

									<div id="<%=postList.get(postListIndex).getIdpost()%>" class="collapse">
									<form action="LikePostServlet" method="post">
									<%int club_id  = (int) request.getAttribute("club_id_num"); %>
										<button type="submit" class="btn btn-info" name="postId" value="<%=postList.get(postListIndex).getIdpost() + " " + club_id%>"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">
										<%=postList.get(postListIndex).getNumOfLikes() + " "%>	Like</span></button>
									</form>
									<br>
									<%=postList.get(postListIndex).getContents() %>
									
									
									
									
									
									<div class="container">
									<div class="col-lg-2"></div>
									<div class="col-lg-8">
										<%PostCommentDao postCDao = new PostCommentDao();
											LinkedList<PostComments> commentList = postCDao.getAllCommentsForPost(postList.get(postListIndex).getIdpost());
										int postCommentIndex = 0; 
										int postCommentListSize = commentList.size();
										
										%>
										
										<form action="PostCommentServlet" method="POST">
											<textarea rows="4" cols="20" placeholder="leave a comment" name="comment"></textarea>
											<br>
											<button class="btn btn-success" type="submit" value="<%=postList.get(postListIndex).getIdpost() + " " + club_id%>" name="postIdForComment">Comment</button>
										</form>
										
										<br>
										<br>
										<table class="table table-hover sortable">
									<thead>
										<tr>
											<th>Comment</th>
											<th>By</th>
										</tr>
									</thead>
									<tbody
										style="max-height: 300px; overflow-y: auto; overflow-x: hidden; display:">
										<%
											while (postCommentIndex < postCommentListSize) {
											
											UserDao uDao = new UserDao();
											User u = uDao.getUserByIdNum(commentList.get(postCommentIndex).getUser_id_num());
												
										%>
										<tr>
											<td><%=commentList.get(postCommentIndex).getComment()%></td>
											<td><%=u.getFirst_name() + " " + u.getLast_name()%></td>
										</tr>

										<%
										postCommentIndex++;
										%>
										<%
											}
										%>
									</tbody>
								</table>
									</div>
									
									</div>
									</div>
									<br>

								<%postListIndex++; %>
								<%} %>
			</div>
			</div>
			</div>
        </section> 
        </section> </header><section id="welcome" class="section-98 section-sm-110">
          <div class="shell">
            <h5>Some of Our Upcoming Events!</h5>
            <hr class="divider bg-red">
            <div class="range range-xs-center offset-top-66">
              <div class="cell-lg-8">
                <p></p>
              </div>
            </div>
            <div class="range offset-top-98">
            <%
									LinkedList<Events> eventList = new LinkedList<Events>();
									EventsDao eDao = new EventsDao();
									eventList = eDao.getAllEventsByClubId((int)request.getAttribute("club_id_num"));
									int eventListIndex = 0;
									
								%>
								
								<%
									while (eventListIndex < eventList.size()) {
								%>
					
              <div class="cell-sm-8 cell-sm-preffix-2 cell-md-4 cell-md-preffix-0">
                <!-- Icon Box Type 5-->
            
                <div class="box-icon box-icon-bordered well"><span class="icon icon-outlined icon-sm icon-dark-filled mdi mdi-account-multiple"></span>
                  <h4 class="text-danger offset-top-20"><%=eventList.get(eventListIndex).getEvent_name()%></h4>
                  <p><%= eventList.get(eventListIndex).getDescription() %></p>
                  <form action="EventDetailsServlet" method="GET">
									<button class="btn btn-danger text-red-gray" type="submit" name="eventId"
												value="<%=eventList.get(eventListIndex).getEventId()%>">More
												Info</button>
										</form>
                </div>
                
              </div>
              <%
					eventListIndex++;
				%>
				<%
					}
				%>
              
              
            </div>
          </div>
        </section>
			
			   
			   	<!--<form action = "UserEmailsBMServlet" method="POST">
              <div class="cell-lg-4">
                <div class="inset-lg-left-80">
                  <p style="float: center; margin: 0; padding: 1em;" class="offset-top-41 offset-lg-top-50">
                  <textarea name = "message" placeholder="Need help? Contact a board member..." onkeypress="enableUpdateButtonContact()" cols="30" rows="2" name="editDescription"></textarea>
                  <br>
                  <button id="buttonContact" disabled class="btn btn-info" type="submit">Contact Admin</button>
                  
				  </p>
                  
              </div>
              </div>
              </form> -->
          
			   
			
		</div>
		<!--<section class="section-98 section-sm-110">
          <div class="shell">
            <h1>Board Members</h1>
            <hr class="divider bg-danger">
            <div class="range range-xs-center offset-sm-top-66">
              <div class="cell-sm-10 cell-lg-12">
                <div class="range">
                  <div class="cell-sm-6 cell-lg-3 offset-top-66 offset-xs-top-0">
                    <div class="box-member"><img src="img/image_part_001.jpg" alt="" class="img-responsive"/>
                      <h5 class="text-bold offset-top-20"><a href="">Becca Thomas</a> <small class="text-danger">President</small>
                      </h5>
                    </div>
                    <p class="offset-lg-top-0 text-muted">a short one sentence description of Becca Thomas</p>
                  </div>
                  <div class="cell-sm-6 cell-lg-3 offset-top-66 offset-sm-top-0 offset-lg-top-0">
                    <div class="box-member"><img src="img/image_part_002.jpg" alt="" class="img-responsive"/>
                      <h5 class="text-bold offset-top-20"><a href="about-coach.html">Raza Mohammed</a> <small class="text-danger">Vice President</small>
                      </h5>
                    </div>
                    <p class="offset-lg-top-0 text-muted">A short one sentence description of Raza Mohammed.</p>
                  </div>
                  <div class="cell-sm-6 cell-lg-3 offset-top-66 offset-lg-top-0">
                    <div class="box-member"><img src="img/image_part_003.jpg" alt="" class="img-responsive"/>
                      <h5 class="text-bold offset-top-20"><a href="about-coach.html">Joel Sandoval</a> <small class="text-danger">Secretary</small>
                      </h5>
                    </div>
                    <p class="offset-lg-top-0 text-muted">A short one sentence description of Joel Sandoval</p>
                  </div>
                  <div class="cell-sm-6 cell-lg-3 offset-top-66 offset-lg-top-0">
                    <div class="box-member"><img src="img/image_part_004.jpg" alt="" class="img-responsive"/>
                      <h5 class="text-bold offset-top-20"><a href="about-coach.html">Frank Rooks</a> <small class="text-danger">Treasurer</small>
                      </h5>
                    </div>
                    <p class="offset-lg-top-0 text-muted">A short one sentence description of Frank Rooks</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>-->





















	<!-- Final div -->
	</div>

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


	<!-- Java script-->
		<script>
	function enableUpdateButtonContact() {

	    document.getElementById("buttonContact").disabled = false;

	}
	</script>
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
	
	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function(){
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
        } else {
            panel.style.display = "block";
        }
    }
}
</script>
	
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>
</html>