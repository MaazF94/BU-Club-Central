
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ben.bu_club_central.models.User"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubDao"%>
<%@ page import="edu.ben.bu_club_central.models.Club"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
<head>
<!-- Site Title-->
<title>Join A Club</title>

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
        <div><img class='img-responsive' style='margin-top: -20px;margin-left: -18px;' width='280' height='67' src='img/BURedTransparent.png' alt=''/>
          <div class="offset-top-41 text-center">
            <div class="spinner"></div>
          </div>
        </div>
      </div>
      <!-- Page Head-->
      <header class="page-head slider-menu-position">
        <!-- RD Navbar Transparent-->
        <div class="rd-navbar-wrap">
          <nav data-md-device-layout="rd-navbar-fixed" data-lg-device-layout="rd-navbar-static" class="rd-navbar rd-navbar-default rd-navbar-transparent" data-lg-auto-height="true" data-md-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-stick-up="true">
            <div class="rd-navbar-inner">
              <!-- RD Navbar Panel-->
              <div class="rd-navbar-panel">
                <!-- RD Navbar Toggle-->
                <button data-rd-navbar-toggle=".rd-navbar, .rd-navbar-nav-wrap" class="rd-navbar-toggle"><span></span></button>
                <!--Navbar Brand-->
                <div class="rd-navbar-brand"><a href="index.html"><img class='img-responsive' width='40' height='30' src='img/BURedTransparent.png' alt=''/></a></div>
              </div>
               
              <div class="rd-navbar-menu-wrap">
                <div class="rd-navbar-nav-wrap">
                  <div class="rd-navbar-mobile-scroll">
                
                    <!--Navbar Brand Mobile-->
                    <div class="rd-navbar-mobile-brand"><a href="index.html"><img class='img-responsive' width='238' height='30' src='img/BUred.png' alt=''/></a></div>
                    <div class="form-search-wrap">
                      <!-- RD Search Form-->
                      <form action="search-results.html" method="GET" class="form-search rd-search">
                        <div class="form-group">
                          <label for="rd-navbar-form-search-widget" class="form-label form-search-label form-label-sm">Search</label>
                          <input id="rd-navbar-form-search-widget" type="text" name="s" autocomplete="off" class="form-search-input input-sm form-control form-control-gray-lightest input-sm"/>
                        </div>
                        <button type="submit" class="form-search-submit"><span class="mdi mdi-magnify"></span></button>
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
>>>>>>> Frank_Dev
								
								
                      
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
      
      
      
      <script>
                      function hide() {
                    	  var checkLetters =  /^[A-Za-z]/;
                    	  var checkboxes=document.getElementsByName("club");
                    	  if (!checkLetters.test(document.forms["myform"]["fullname"].value)) {
                    		  alert("You must write your full name");
                    		  return false;
                    	  } else if (document.forms["myform"]["email"].value.indexOf("@") == -1 || document.forms["myform"]["email"].value.indexOf(".com") == -1) {
                    		  alert("You must write a valid email address");
                    		  return false;
                    	  } else if ((isNaN(document.forms["myform"]["ID"].value)) || document.forms["myform"]["ID"].value == "" || document.forms["myform"]["ID"].value.length != 7) {
                    		  alert("You must write a valid ID number");
                    		  return false;
                    	  } else if (!$('#myform input:checked').length > 0) {
                    		  alert("You must check at least one checkbox");
                    		  return false;
                    	  }
                    	  var r = confirm("Are you sure this information is correct?");
                    	  if (r == true) {
                    	      x = "Great, thanks for joining! You will now be subscribed to the club(s) that you chose.";
                      	      document.getElementById("myform").innerHTML = x;
                    	  } 
                         }
                      
                      </script>
                      
                      
              <main class="page-content">
        <section class="section-top-98 section-md-top-110 text-lg-left">
          <div class="shell">
            <div class="range range-xs-center range-xs-center">
                    <%
			ClubDao cDao = new ClubDao();
			LinkedList<Club> clubList = new LinkedList<Club>();
			clubList = cDao.displayClub();

			int index = 0;
		%>
              <div class="cell-sm-8 offset-top-66 offset-lg-top-0">
                <h3 class="text-bold">Join A Club</h3>
                <hr class="divider hr-lg-left-0 bg-red">
                <!-- RD Mailform-->
                          <form data-form-output="form-output-global" data-form-type="joinClub" method="post" action="bat/rd-mailform.php" class="rd-mailform text-left offset-top-50">
                  <div class="range">
                    <div class="cell-lg-6">
                      <div class="form-group">
                        <label for="contact-us-name" class="form-label form-label-outside">Name:</label>
                        <input id="contact-us-name" type="text" name="name"  placeholder="Full Name" data-constraints="@Required" class="form-control">
                      </div>
                      
                    </div>
                    <div class="cell-lg-6">
                      <div class="form-group">
                        <label for="contact-us-name" class="form-label form-label-outside">Benedictine Id:</label>
                        <input id="contact-us-name" type="text" name="Id"  placeholder="Benedictine Id Number" data-constraints="@Required" class="form-control">
                      </div>
                      
                    </div>
                    
                    
                    <div class="cell-lg-12 offset-top-20">
                      <div class="form-group">
                        
                        <label for="contact-us-email" class="form-label form-label-outside">E-Mail:</label>
                        <input id="contact-us-email" type="email" name="email" placeholder="Your Email Address" data-constraints="@Required @Email" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="group-sm text-center text-lg-left offset-top-30">
                    <button type="submit" class="btn btn-danger">Send</button>
                    <button type="reset" class="btn btn-default">Reset</button>
                  </div>
                
       
                
              </div>
              <div class="cell-lg-4">
              <h3 class="text-bold">Club list</h3>
              <hr class="divider hr-lg-left-0 bg-red">
            
		<%
							while (index < clubList.size()) {
						%>
              
              <label><input type="checkbox" name="club" value="" /> 	<%
												out.println(clubList.get(index).getClub_name());
											%></label><br>
              
            <%
										index++;
										}
									%>  
                
              </div>
       </form>
              
            </div>
          </div>
          <div class="offset-top-98 offset-lg-top-124">
            
            
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
                      <li><a href="#" class="icon fa fa-facebook icon-xxs icon-circle icon-darkest-filled"></a></li>
                      <li><a href="#" class="icon fa fa-twitter icon-xxs icon-circle icon-darkest-filled"></a></li>
                      <li><a href="#" class="icon fa fa-google-plus icon-xxs icon-circle icon-darkest-filled"></a></li>
                      <li><a href="#" class="icon fa fa-linkedin icon-xxs icon-circle icon-darkest-filled"></a></li>
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