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
<title>Ben Union</title>

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
      <!-- Page Head-->
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
      <!-- End of header -->
      <main class="page-content">
      <!--  This is where the the page contents that you are adding should go -->
      
      <!--Welcome-->
        <section id="welcome" class="section-98 section-sm-110">
          <div class="shell">
            <h1>Ben Union Underground</h1>
            <hr class="divider bg-red">
            <div class="range range-xs-center offset-top-66">
              <div class="cell-lg-8">
                <p>At Ben Union underground, we've got a bunch of stuff for you to play with, such as Mario Kart, classic retro arcade games, and Gigantic Connect Four. These items are available for anyone to use any time. Just stop in and play!</p>
                <p> We also have a few other fun items for you but these require checkout and everything must be returned to the office once you're done playing! These items are:
              </div>
            </div>
          </div>
        </section>
		
        <section>
          <div data-items="1" data-xs-items="2" data-md-items="3" data-lg-items="4" data-nav="false" data-dots="true" data-nav-class="[&quot;owl-prev mdi mdi-chevron-left&quot;, &quot;owl-next mdi mdi-chevron-right&quot;]" class="owl-carousel owl-carousel-default veil-md-owl-dots veil-owl-nav reveal-md-owl-nav">
            <div>
              <!-- Thumbnail Terry-->
              <figure class="thumbnail-terry"><a href=""><img width="480" height="480" src="img/gameroom.jpg" alt=""/></a>
                <figcaption>
                  <div>
                    <h2 class="text-italic text-uppercase text-spacing-20 thumbnail-terry-title">Wii U</h2>
                  </div>
                  <p class="thumbnail-terry-desc offset-top-0"></p><a data-toggle="modal" href="#checkoutWiiUModal" class="btn offset-top-10 offset-md-top-0 btn-danger">Checkout</a>
                </figcaption>
              </figure>
            </div>
            <div>
              <!-- Thumbnail Terry-->
              <figure class="thumbnail-terry"><a href=""><img width="480" height="480" src="img/TableTennisRED.jpg" alt=""/></a>
                <figcaption>
                  <div>
                    <h2 class="text-italic text-uppercase text-spacing-20 thumbnail-terry-title">Pool</h2>
                  </div>
                  <p class="thumbnail-terry-desc offset-top-0"></p><a data-toggle="modal" href="#checkoutPoolModal" class="btn offset-top-10 offset-md-top-0 btn-danger">Checkout</a>
                </figcaption>
              </figure>
            </div>
            <div>
              <!-- Thumbnail Terry-->
              <figure class="thumbnail-terry"><a href=""><img width="480" height="480" src="img/SpiritCase.jpg" alt=""/></a>
                <figcaption>
                  <div>
                    <h2 class="text-italic text-uppercase text-spacing-20 thumbnail-terry-title">Air Hockey</h2>
                  </div>
                  <p class="thumbnail-terry-desc offset-top-0"></p><a data-toggle="modal" href="#checkoutAirHockeyModal" class="btn offset-top-10 offset-md-top-0 btn-danger">Checkout</a>
                </figcaption>
              </figure>
            </div>
            <div>
              <!-- Thumbnail Terry-->
              <figure class="thumbnail-terry"><a href=""><img width="480" height="480" src="img/TableTennisBLUE.jpg" alt=""/></a>
                <figcaption>
                  <div>
                    <h2 class="text-italic text-uppercase text-spacing-20 thumbnail-terry-title">Ping Pong</h2>
                  </div>
                  <p class="thumbnail-terry-desc offset-top-0"></p><a data-toggle="modal" href="#checkoutPingPongModal" class="btn offset-top-10 offset-md-top-0 btn-danger">Checkout</a>
                </figcaption>
              </figure>
            </div> 
          </div>
        </section>
      
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      
      </main>
      <!--End of main page content -->
      
      
      
      
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
    
    <div class="modal fade" id="checkoutWiiUModal" role="dialog">
		<div class="modal-dialog" style="top: 25%;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<a href="#" title="" class="masterTooltip"><strong>Please enter your information!</strong></a></div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action = "ItemCheckoutServlet" method= "POST">
						<div class="form-group offset-top-20">
						<a href="#" title="Enter your full name" class="masterTooltip"><strong>Name:</strong></a>
							<div class="input-group input-group-sm">
							
								<input id="checkout-name"  type="text" name="name"  class="form-control form-control-impressed">								
							</div>
							<a href="#" title="Enter your b-ID number" class="masterTooltip"><strong>Student ID Number: </strong></a>
								
							<div class="input-group input-group-sm">
								<input id="checkout-id"  type="text" name="studentId"  class="form-control form-control-impressed">								
							</div>
							
						</div>
						<button style= "margin-left: 50px; margin-right: 100px;"type="submit" 
							<%String item = "Wii U"; %>
							class="btn btn-info center" name= "itemForCheckout" value="<%=item%>">
								<span class=""></span> Checkout
						</button>
						<button type="button" class="btn btn-danger center" data-dismiss="modal">
							<span class=""></span> Cancel
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="checkoutPoolModal" role="dialog">
		<div class="modal-dialog" style="top: 25%;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<a href="#" title="" class="masterTooltip"><strong>Please enter your information!</strong></a></div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action = "ItemCheckoutServlet" method= "POST">
						<div class="form-group offset-top-20">
						<a href="#" title="Enter your full name" class="masterTooltip"><strong>Name:</strong></a>
							<div class="input-group input-group-sm">
							
								<input id="checkout-name"  type="text" name="name"  class="form-control form-control-impressed">								
							</div>
							<a href="#" title="Enter your b-ID number" class="masterTooltip"><strong>Student ID Number: </strong></a>
								
							<div class="input-group input-group-sm">
								<input id="checkout-id"  type="text" name="studentId"  class="form-control form-control-impressed">								
							</div>
							
						</div>
						<button style= "margin-left: 50px; margin-right: 100px;"type="submit" 
							<%item = "Pool"; %>
							class="btn btn-info center" name= "itemForCheckout" value="<%=item%>">
								<span class=""></span> Checkout
						</button>
						<button type="button" class="btn btn-danger center" data-dismiss="modal">
							<span class=""></span> Cancel
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="checkoutAirHockeyModal" role="dialog">
		<div class="modal-dialog" style="top: 25%;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<a href="#" title="" class="masterTooltip"><strong>Please enter your information!</strong></a></div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action = "ItemCheckoutServlet" method= "POST">
						<div class="form-group offset-top-20">
						<a href="#" title="Enter your full name" class="masterTooltip"><strong>Name:</strong></a>
							<div class="input-group input-group-sm">
							
								<input id="checkout-name"  type="text" name="name"  class="form-control form-control-impressed">								
							</div>
							<a href="#" title="Enter your b-ID number" class="masterTooltip"><strong>Student ID Number: </strong></a>
								
							<div class="input-group input-group-sm">
								<input id="checkout-id"  type="text" name="studentId"  class="form-control form-control-impressed">								
							</div>
							
						</div>
						<button style= "margin-left: 50px; margin-right: 100px;"type="submit" 
							<%item = "Air Hockey"; %>
							class="btn btn-info center" name= "itemForCheckout" value="<%=item%>">
								<span class=""></span> Checkout
						</button>
						<button type="button" class="btn btn-danger center" data-dismiss="modal">
							<span class=""></span> Cancel
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="checkoutPingPongModal" role="dialog">
		<div class="modal-dialog" style="top: 25%;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<a href="#" title="" class="masterTooltip"><strong>Please enter your information!</strong></a></div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action = "ItemCheckoutServlet" method= "POST">
						<div class="form-group offset-top-20">
						<a href="#" title="Enter your full name" class="masterTooltip"><strong>Name:</strong></a>
							<div class="input-group input-group-sm">
							
								<input id="checkout-name"  type="text" name="name"  class="form-control form-control-impressed">								
							</div>
							<a href="#" title="Enter your b-ID number" class="masterTooltip"><strong>Student ID Number: </strong></a>
								
							<div class="input-group input-group-sm">
								<input id="checkout-id"  type="text" name="studentId"  class="form-control form-control-impressed">								
							</div>
							
						</div>
						<button style= "margin-left: 50px; margin-right: 100px;"type="submit" 
							<%item = "Wii U"; %>
							class="btn btn-info center" name= "itemForCheckout" value="<%=item%>">
								<span class=""></span> Checkout
						</button>
						<button type="button" class="btn btn-danger center" data-dismiss="modal">
							<span class=""></span> Cancel
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
    <!-- Java script-->
    <script>
		$(document).ready(function() {
			$("#checkoutWiiUModal").modal();
			$("#checkoutAirHockeyModal").modal();
			$("#checkoutPoolModal").modal();
			$("#checkoutPingPongModal").modal();
		});
	</script>
    <script src="js/js/core.min.js"></script>
    <script src="js/js/script.js"></script>
    
  </body>

</html>