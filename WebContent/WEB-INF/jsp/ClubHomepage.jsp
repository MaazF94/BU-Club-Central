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
		<div class="jumbotron" style="background-color: #f1eaee">
			<h1>
				<div class="container">
					<h1  class="text-danger" >${clubName}</h1>
				</div>
				
			</h1>
							              ${message}
			
			<h5>Number of Club Members: ${clubMembers}</h5>
			

			<br>
			   <b>Description:</b>
			   <br>
			   <p>${clubDescription}</p>
			 
			 <br>
			   <b>Advisor: </b>
			   <br>
			   <p>${advisorName}</p>
			   
			   			<div class="container">
				<div class="col-lg-4"></div>
				
			</div>
			
			<div class="container">
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
										<button type="submit" class="btn btn-info" name="postId" value="<%=postList.get(postListIndex).getIdpost()%>"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">
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
											<button class="btn btn-success" type="submit" value="<%=postList.get(postListIndex).getIdpost()%>" name="postIdForComment">Comment</button>
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
		class="section-relative section-top-66 section-bottom-34 page-footer bg-gray-base context-dark">
	<div class="shell">
		<div class="range range-sm-center text-lg-left">
			<div class="cell-sm-12">
				<div class="range range-xs-center">
					


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