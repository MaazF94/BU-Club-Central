<!DOCTYPE HTML>

<<<<<<< HEAD
=======
<%@ page import="edu.ben.bu_club_central.models.User"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
<head>
<!-- Site Title-->
<title>Club Central Home</title>
>>>>>>> Sprint3

<%@ page import="edu.ben.bu_club_central.models.User"%>
<!--
	Introspect by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Club Central</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

<<<<<<< HEAD
		<!-- Header -->
			<header id="header">
				<div class="inner">
					<a href="index.html" class="logo">introspect</a>
					<nav id="nav">
						<a href="HomeServlet">Home</a>
						<a href="generic.html">Clubs</a>
						<a href="#">Events</a>
						
						<a href="LoginServlet" class="dropdown">
							
							<%	if (session.getAttribute("user") == null) {
									%> Sign In <%
								} else {
							%>
							<%=((User) session.getAttribute("user")).getFirst_name()%>
							<%
								}
							%>
						
						</a>
					</nav>
=======

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
		<div class="page-loader page-loader-variant-1">
			<div>
				<img class='img-responsive'
					style='margin-top: -20px; margin-left: -18px;' width='280'
					height='67' src='img/BURedTransparent.png' alt='' />
				<div class="offset-top-41 text-center">
					<div class="spinner"></div>
>>>>>>> Sprint3
				</div>
				
			</header>
			<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

		<!-- Banner -->
			<section id="banner">
				<div class="inner">
					<h1>Introspect: <span>A free + fully responsive<br />
					site template by TEMPLATED</span></h1>
					<ul class="actions">
						<li><a href="#" class="button alt">Get Started</a></li>
					</ul>
				</div>
			</section>

		<!-- One -->
			<section id="one">
				<div class="inner">
					<header>
						<h2>Magna Etiam Lorem</h2>
					</header>
					<p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula. Integer adipiscin sem. Nullam quis massa sit amet nibh viverra malesuada. Nunc sem lacus, accumsan quis, faucibus non, congue vel, arcu, erisque hendrerit tellus. Integer sagittis. Vivamus a mauris eget arcu gravida tristique. Nunc iaculis mi in ante.</p>
					<ul class="actions">
						<li><a href="#" class="button alt">Learn More</a></li>
					</ul>
				</div>
			</section>

		<!-- Two -->
			<section id="two">
				<div class="inner">
					<article>
						<div class="content">
							<header>
								<h3>Pellentesque adipis</h3>
							</header>
							<div class="image fit">
								<img src="images/pic01.jpg" alt="" />
							</div>
							<p>Cumsan mollis eros. Pellentesque a diam sit amet mi magna ullamcorper vehicula. Integer adipiscin sem. Nullam quis massa sit amet lorem ipsum feugiat tempus.</p>
						</div>
					</article>
					<article class="alt">
						<div class="content">
							<header>
								<h3>Morbi interdum mol</h3>
							</header>
							<div class="image fit">
								<img src="images/pic02.jpg" alt="" />
							</div>
<<<<<<< HEAD
							<p>Cumsan mollis eros. Pellentesque a diam sit amet mi magna ullamcorper vehicula. Integer adipiscin sem. Nullam quis massa sit amet lorem ipsum feugiat tempus.</p>
						</div>
					</article>
				</div>
			</section>

		<!-- Three -->
			<section id="three">
				<div class="inner">
					<article>
						<div class="content">
							<span class="icon fa-laptop"></span>
							<header>
								<h3>Tempus Feugiat</h3>
							</header>
							<p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna lorem ullamcorper laoreet, lectus arcu.</p>
							<ul class="actions">
								<li><a href="#" class="button alt">Learn More</a></li>
							</ul>
						</div>
					</article>
					<article>
						<div class="content">
							<span class="icon fa-diamond"></span>
							<header>
								<h3>Aliquam Nulla</h3>
							</header>
							<p>Ut convallis, sem sit amet interdum consectetuer, odio augue aliquam leo, nec dapibus tortor nibh sed.</p>
							<ul class="actions">
								<li><a href="#" class="button alt">Learn More</a></li>
							</ul>
						</div>
					</article>
					<article>
					<div class="content">
							<span class="icon fa-laptop"></span>
							<header>
								<h3>Sed Magna</h3>
							</header>
							<p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula.</p>
							<ul class="actions">
								<li><a href="#" class="button alt">Learn More</a></li>
							</ul>
						</div>
					</article>
				</div>
			</section>

		<!-- Footer -->
			<section id="footer">
				<div class="inner">
					<header>
						<h2>Get in Touch</h2>
					</header>
					<form method="post" action="#">
						<div class="field half first">
							<label for="name">Name</label>
							<input type="text" name="name" id="name" />
=======
							<!-- RD Navbar Nav-->
							<ul class="rd-navbar-nav">

								<li class=""><a href="HomeServlet"><span>Home</span></a></li>
								<li><a href="EventServlet"><span>Events</span></a></li>
								<li><a href="ClublistServlet"><span>clubs</span></a></li>
								
									<li><a href="MeetTheAdminsServlet"><span>About
											Us</span></a></li>
								 <li><a href="ContactUsServlet"><span>Contact Us</span></a>
								 <li><a class="" href="LoginServlet"><span>
										
											<%
												if (session.getAttribute("user") == null) {
											%> Sign In <%
												} else {
											%>
											<%=((User) session.getAttribute("user")).getFirst_name()%>
											<%
												}
											%>


									</span></a></li>

							</ul>
						</div>
					</div>
					<!--RD Navbar Search-->

				</div>
			</div>
			</nav>
		</div>
		<!-- Welcome to Intense--> <section>
		<div data-on="false" data-md-on="true"
			class="bg-gray-base context-dark rd-parallax">
			<div data-speed="0.45" data-type="media" data-url='img/snowyBU.jpg'
				class="rd-parallax-layer"></div>
			<div data-speed="0.3" data-type="html" data-md-fade="true"
				class="rd-parallax-layer">
				<div class="shell">
					<div class="range">
						<div
							class="range range-xs-middle range-xs-center section-cover section-top-124 section-bottom-98 section-sm-top-110 section-sm-bottom-110 context-dark">
							<div class="range range-xs-center">
								<div class="cell-lg-12">
									<div data-caption-animate="fadeInUp" data-caption-delay="300"
										class="text-extra-big text-bold text-italic text-uppercase">WELCOME
										TO CLUB CENTRAL</div>
								</div>
								<div class="cell-lg-9 offset-top-20">
									<h5 data-caption-animate="fadeInUp" data-caption-delay="500"
										class="hidden reveal-xs-block text-light"></h5>
									<div class="group group-xl offset-top-41 offset-sm-top-30">

										<a href="JoinAClubServlet" class="btn btn-danger">JOIN A
											CLUB</a><a href="EventServlet" class="btn btn-danger">Find an
											Event</a>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section> </header>
		<!-- Page Footer-->
		<footer class="section-relative  section-bottom-34 page-footer bg-gray-base context-dark">
		<div class="shell">
			<div class="range range-sm-center text-lg-left">
				<div class="cell-sm-12">
					<div class="range range-xs-center">


						<div
							class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
							<!-- Footer brand-->
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
								The F.I.R.M &copy; <span id="copyright-year"></span> . <a
									href="privacy.html">Privacy Policy</a>
								<!-- {%FOOTER_LINK}-->
							</p>
>>>>>>> Sprint3
						</div>
						<div class="field half">
							<label for="email">Email</label>
							<input type="text" name="email" id="email" />
						</div>
						<div class="field">
							<label for="message">Message</label>
							<textarea name="message" id="message" rows="6"></textarea>
						</div>
						<ul class="actions">
							<li><input type="submit" value="Send Message" class="alt" /></li>
						</ul>
					</form>
					<div class="copyright">
						&copy; Untitled Design: <a href="https://templated.co/">TEMPLATED</a>. Images <a href="https://unsplash.com/">Unsplash</a>
					</div>
				</div>
<<<<<<< HEAD
			</section>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
=======
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
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>

<<<<<<< HEAD
=======

>>>>>>> b8e5e673fbcc6da2df9057b94a6e5e0f9d1c0eab
>>>>>>> Sprint3
</html>