<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
<head>
<!-- Site Title-->
<title>Computer Science Club</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
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
		<div class="page-loader page-loader-variant-1">
			<div>
				<img class='img-responsive'
					style='margin-top: -20px; margin-left: -18px;' width='280'
					height='67' src='img/BURedTransparent.png' alt='' />
				<div class="offset-top-41 text-center">
					<div class="spinner"></div>
				</div>
			</div>
		</div>
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
						<a href="index.html"><img class='img-responsive' width='40'
							height='30' src='img/BURedTransparent.png' alt='' /></a>
					</div>
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
								<li class=""><a href="HomeServlet"><span>Home</span><span
										class="rd-navbar-label text-middle label-custom label-danger label-xs-custom label-rounded-custom label"></span></a>
								<li class=""><a href="MeetTheAdminsServlet"><span>About
											Us</span><span
										class="rd-navbar-label text-middle label-custom label-danger label-xs-custom label-rounded-custom label"></span></a>
								<li><a href="EventServlet"><span>Events</span></a>
								<li><a href="ClublistServlet"><span>clubs</span></a>
								<li><a href="LoginServlet"><span>Sign
											in</span></a>
								<li><a href="ContactUsServlet"><span>Contact Us</span></a>


								</li>
							</ul>
						</div>
					</div>
					<!--RD Navbar Search-->
					<div class="rd-navbar-search">
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
							<!--button(type="submit").rd-navbar-search-form-submit.mdi.mdi-magnify-->
						</form>
						<!--div.rd-navbar-live-search-results-->
						<!--button(data-rd-navbar-toggle=".rd-navbar-search, .rd-navbar-inner, .rd-navbar-live-search-results").rd-navbar-search-toggle-->
						<!--  span-->
					</div>
				</div>
			</div>
			</nav>
		</div>
		<!-- Welcome to Intense--> <section>
		<div data-on="false" data-md-on="true"
			class="bg-gray-base context-dark rd-parallax">
			<div data-speed="0.3" data-type="html" data-md-fade="true"
				class="rd-parallax-layer">
				<div class="shell">
					<div class="range">
						<div
							class="range range-xs-middle range-xs-center section-cover section-top-124 section-bottom-98 section-sm-top-110 section-sm-bottom-110 context-dark">
							<div class="range range-xs-center">
								<div class="cell-lg-12">
									<div data-caption-animate="fadeInUp" data-caption-delay="300"
										class="text-extra-big text-bold text-italic text-uppercase">COMPUTER
										SCIENCE CLUB</div>
								</div>
								<div class="cell-lg-9 offset-top-20">
									<h5 data-caption-animate="fadeInUp" data-caption-delay="500"
										class="hidden reveal-xs-block text-light"></h5>
									<div class="group group-xl offset-top-41 offset-sm-top-30">
										<a style="color: white;" href="#myPopup" data-rel="popup"
											class="btn btn-danger">JOIN OUR CLUB</a> <a
											style="color: white;" href="EventServlet"
											class="btn btn-danger">Find an Event</a>
									</div>
									<div data-role="popup" id="myPopup" class="ui-content"
										style="min-width: 250px;">
										<form method="post" action="demoform.asp">
											<div>
												<h3>Join Our Club:</h3>
												<div>
													<input id="fullname" placeholder="Your Full Name"
														type="text" name="fullname" data-constraints="@Required"
														class="form-control"> <input id="ID"
														placeholder="Your BenU ID Number" type="text" name="ID"
														data-constraints="@Required" class="form-control">
													<input id="emailaddress" placeholder="Your Email Address"
														type="text" name="email" data-constraints="@Required"
														class="form-control">

													<button style="color: white; background: #FF3333;"
														id="submit" type="button"
														class="btn btn-sm btn-icon btn-block btn-warning btn btn-danger">
														Submit <span
															class="icon mdi mdi-arrow-right-bold-circle-outline"></span>
													</button>
												</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	</header>

	<!-- First Grid -->
	<div data-on="false" data-md-on="true"
		class="bg-gray-base context-dark rd-parallax">
		<div class="shell">
			<h1 style="padding: 15px; color: red;">About Our Club</h1>
			<h6 class="range">This is information about the club.
				Information can include GBM time/days, board member information,
				events, etc. This is information about the club. Information can
				include GBM time/days, board member information, events, etc.This is
				information about the club. Information can include GBM time/days,
				board member information, events, etc.This is information about the
				club. Information can include GBM time/days, board member
				information, events, etc.This is information about the club.
				Information can include GBM time/days, board member information,
				events, etc.This is information about the club. Information can
				include GBM time/days, board member information, events, etc.This is
				information about the club. Information can include GBM time/days,
				board member information, events, etc.</h6>
		</div>
	</div>

	<!-- Second Grid -->
	<div data-on="false" data-md-on="true"
		class="bg-gray-base context-dark rd-parallax">
		<div style="padding: 30px;" class="shell">
			<h1 style="top-margin: 15px; color: red;">Latest News</h1>
			<h6 class="range">This is information about the club.
				Information can include GBM time/days, board member information,
				events, etc.This is information about the club. Information can
				include GBM time/days, board member information, events, etc.This is
				information about the club. Information can include GBM time/days,
				board member information, events, etc.This is information about the
				club. Information can include GBM time/days, board member
				information, events, etc.This is information about the club.
				Information can include GBM time/days, board member information,
				events, etc.</h6>
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
	<!-- Java script-->
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>
</body>
</html>