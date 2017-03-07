<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
<head>
<!-- Site Title-->
<title>Forgot Username</title>

<meta name="format-detection" content="telephone=no">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="keywords" content="intense web design multipurpose template">
<meta name="date" content="Dec 26">
<link rel="icon" type="image/png" href="img/favicon-16x16.png"
	sizes="16x16" />
<!-- Stylesheets-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Montserrat:400,700%7CLato:300,300italic,400,700,900%7CYesteryear">
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
								
								<li><a href="LoginServlet"><span>Sign in</span></a>
								
								<li><a href="ContactUsServlet"><span>Contact Us</span></a>


								</li>
							</ul>
						</div>
					</div>
					<!--RD Navbar Search-->
				
				</div>
			</div>
			</nav>
		</div>
		<!-- Page Content--> <main class="page-content bg-shark-radio">
		<div class="one-page">
			<!-- Login-->
			<section>
			<div class="shell">
				<div class="range">
					<div
						class="section-110 section-cover range range-xs-center range-xs-middle">
						<div class="cell-xs-8 cell-sm-6 cell-md-4">
							<div
								class="panel section-34 section-sm-41 inset-left-20 inset-right-20 inset-sm-left-20 inset-sm-right-20 inset-lg-left-30 inset-lg-right-30 bg-white shadow-drop-md">
								<!-- Icon Box Type 4<span class="icon icon-circle icon-bordered icon-lg icon-default mdi mdi-account-multiple-outline"></span>-->
								<div>
									<div class="offset-top-24 text-darker big text-bold">Forgot your username?</div>
									<p class="text-extra-small text-dark offset-top-4">Fill out some information
									below</p>
								</div>
								<!-- RD Mailform-->
								<form data-form-output="form-output-global"
									data-form-type="contact" method="post"
									class="text-left offset-top-30">
									<div class="form-group">
										<div class="input-group input-group-sm">
											<span class="input-group-addon input-group-addon-inverse"><span
												class="input-group-icon mdi mdi-account-outline"></span></span> <input
												id="login-your-login" placeholder="Your First Name"
												type="text" name="first_name" data-constraints="@Required"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="input-group input-group-sm">
											<span class="input-group-addon input-group-addon-inverse"><span
												class="input-group-icon mdi mdi-account-outline"></span></span> <input
												id="login-your-login" placeholder="Your Last Name"
												type="text" name="last_name" data-constraints="@Required"
												class="form-control">
										</div>
									</div>
									<div class="form-group offset-top-20">
										<div class="input-group input-group-sm">
											<span class="input-group-addon input-group-addon-inverse"><span
												class="input-group-icon mdi mdi-account-outline"></span></span> <input
												id="login-your-id" placeholder="Your BenU ID"
												type="text" name="id_num" data-constraints="@Required"
												class="form-control">
										</div>
									</div>
									<div class="form-group offset-top-20">
										<div class="input-group input-group-sm">
											<span class="input-group-addon input-group-addon-inverse"><i class="material-icons" style="font-size:19px">email</i></span></span> <input
												id="login-your-email" placeholder="Your Email"
												type="text" name="email" data-constraints="@Required"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="input-group input-group-sm">
											<span class="input-group-addon input-group-addon-inverse"><span
												class="input-group-icon mdi mdi-account-outline"></span></span> <input
												id="login-your-login" placeholder="Your New Username"
												type="text" name="username" data-constraints="@Required"
												class="form-control">
										</div>
									</div>
									<button type="submit"
										class="btn btn-sm btn-icon btn-block btn-warning btn btn-danger">
										Reset My Username <span
											class="icon mdi mdi-arrow-right-bold-circle-outline"></span>
									</button>

								</form>
								
								<div
									class="offset-top-30 text-sm-left text-dark text-extra-small">
									<div class="offset-top-0">
										Don't have an account? <a href="RegisterServlet"
											class="text-picton-blue">Sign up here</a>.
									</div>
									
								</div>
								<div name = "error">
								<p class = "text-danger">${error} </p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<div class="one-page-footer">
				<p style="color: rgba(255, 255, 255, 0.3)" class="small">
					The F.I.R.M &copy; <span id="copyright-year"></span> . <a
						href="privacy.html">Privacy Policy</a>
				</p>
			</div>
		</div>
		</main>
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