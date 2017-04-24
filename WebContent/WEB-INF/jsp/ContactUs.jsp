<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="edu.ben.bu_club_central.models.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
  <head>
    <!-- Site Title-->
    <title>Events</title>
   
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="keywords" content="intense web design multipurpose template">
    <meta name="date" content="Dec 26">
    <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />
    <!-- Stylesheets-->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu:400,400italic,500,700,700italic">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
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
            <div data-speed="0.2" data-type="media" data-url="images/background-04-1920x750.jpg" class="rd-parallax-layer"></div>
            <div data-speed="0" data-type="html" class="rd-parallax-layer">
              <div class="shell section-top-98   ">
               
              </div>
            </div>
          </section>
        </div>
      </header>
      
      <main class="page-content">
        <section class="section-top-98 section-md-top-110 text-lg-left">
          <div class="shell">
            <div class="range range-xs-center range-xs-center">
              <div class="cell-lg-4">
                <div class="inset-lg-right-80">
                 <img src="img/BenQuad.jpg" width="437" height="437" alt="" class="img-responsive center-block"/>
                  <hr class="divider hr-lg-left-0 bg-red">
                  <p class="offset-top-41 offset-lg-top-50">Please use the contact form to the right for all technical inquiries. Our technical support team would be glad to assist you in using this website.</p>
                  <p class="offset-top-41 offset-lg-top-50"> Due to the large amount of inquires please allow 24 hours for a response from our team. For questions regarding club activites and club requests,
                  please contact the Department of student activties from <a href="MeetTheAdminsServlet">here</a>.
                  <address class="contact-info offset-top-30 offset-lg-top-50">
                    <div class="h6 text-uppercase text-bold text-danger letter-space-none offset-top-none">Club Central Office</div>
                    <p></p>
                    <dl class="offset-top-0">
                      <dt>Telephone:</dt>
                      <dd><a href="callto:#">N/A</a></dd>
                    </dl>
                    <dl>
                      <dt>E-mail:</dt>
                      <dd><a href="mailto:buclubcentral@gmail.com">BUclubcentral@gmail.com</a></dd>
                    </dl>
                  </address>
                  
                </div>
              </div>
              <div class="cell-sm-8 offset-top-66 offset-lg-top-0">
              ${message}
                <h3 class="text-bold">Get in touch</h3>
                <hr class="divider hr-lg-left-0 bg-red">
                <!-- RD Mailform-->
                <form data-form-output="form-output-global" data-form-type="contact" method="post" class="text-left offset-top-50">
                  <div class="range">
                    <div class="cell-lg-6">
                      <div class="form-group">
                      
                        <a href="#" title="Enter your full name" class="masterTooltip"><strong>Name:</strong></a>
                        <input id="contact-us-name"  type="text" name="name"  class="form-control form-control-impressed">
                      </div>
                    </div>
                    <div class="cell-lg-6 offset-top-20 offset-lg-top-0">
                      <div class="form-group">
                        <a href="#" title="Enter your E-mail address" class="masterTooltip"><strong>E-Mail:</strong></a>
                        <input id="contact-us-email" type="email" name="email"  data-constraints="@Required @Email" class="form-control form-control-impressed">
                      </div>
                    </div>
                    <div class="cell-lg-12 offset-top-20">
                      <div class="form-group">
                         <a href="#" title="Write Your Message Here..." class="masterTooltip"><strong>Message:</strong></a>
                        <textarea id="contact-us-message" name="message"  class="form-control form-control-impressed"></textarea>
                      </div>
                    </div>
                  </div>
                  <div class="group-sm text-center text-lg-left offset-top-30">
                    <button type="submit" class="btn btn-danger">Send</button>
                    <button type="reset" class="btn btn-default">Reset</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="offset-top-98 offset-lg-top-124">
            
            
            </div>
          </div>
        </section>
      </main>
      <script>
                      function hide() {
                    	  var checkLetters =  /^[A-Za-z]/;
                    	  if (!checkLetters.test(document.forms["myform"]["fullname"].value)) {
                    		  alert("You must write your full name");
                    		  return false;
                    	  } else if (document.forms["myform"]["email"].value.indexOf("@") == -1 || document.forms["myform"]["email"].value.indexOf(".com") == -1) {
                    		  alert("You must write a valid email address");
                    		  return false;
                    	  } else if (document.forms["myform"]["comment"].value == "") {
                    		  alert("You must write a comment");
                    		  return false;
                    	  }
                    	  var r = confirm("Are you sure this information is correct?");
                    	  if (r == true) {
                    	      x = "Great, thanks for contacting us! You'll receive a reply from us soon.";
                      	      document.getElementById("myform").innerHTML = x;
                    	  } 
                         }
                      
                      </script>
      
      
      
      
      
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
    <!-- Java script-->
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