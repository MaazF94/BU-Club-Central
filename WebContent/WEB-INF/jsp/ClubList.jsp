<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ben.bu_club_central.models.User"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubDao"%>
<%@ page import="edu.ben.bu_club_central.daos.ClubMembershipDao"%>
<%@ page import="edu.ben.bu_club_central.models.Club"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
<head>
<style>
/* Style the buttons that are used to open and close the accordion panel */
button.accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    text-align: left;
    border: none;
    outline: none;
    transition: 0.4s;
}

/* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */
button.accordion.active, button.accordion:hover {
    background-color: #ddd;
}

#Notify, #PTable {
    clear: both;
}

#Notify {
    float: right;
    text-align: left;
}

/* Style the accordion panel. Note: hidden by default */
div.panel {
    padding: 0 18px;
    background-color: white;
    display: none;
}

button.accordion:after {
    content: '\02795'; /* Unicode character for "plus" sign (+) */
    font-size: 13px;
    color: #777;
    float: right;
    margin-left: 5px;
}

button.accordion.active:after {
    content: "\2796"; /* Unicode character for "minus" sign (-) */
}

</style>
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
			<div data-speed="0.2" data-type="media"
				data-url="images/background-04-1920x750.jpg"
				class="rd-parallax-layer"></div>
			<div data-speed="0" data-type="html" class="rd-parallax-layer">
				<div class="shell    section-lg-top-110 "></div>
			</div>
			</section>
		</div>
		</header>
		<!-- Page Contents-->
		<section class="section-98 section-sm-110">
          <div class="shell">
            <div class="range range-xs-center range-xs-middle">
              <!-- Simple quote Slider-->
              <div class="cell-sm-9 cell-lg-6 cell-lg-push-6">
                <div data-items="1" data-nav="false" data-dots="false" data-nav-custom=".owl-custom-navigation" class="owl-carousel owl-carousel-classic owl-carousel-class-light shadow-drop-md">
                  <div><img src="img/overviewBU.jpg" width="800" height="600" alt="" class="img-responsive element-fullwidth"></div>
                  
                 
                </div>
              </div>
              <div class="cell-sm-9 cell-lg-6 cell-lg-pull-6 text-lg-left offset-top-66 offset-lg-top-0 inset-lg-right-30">
                <h1>Benedictine Clubs and Organizations</h1>
                <hr class="divider bg-red hr-lg-left-0">
                ${message}
                <%if (session.getAttribute("user") != null) { %>
            <a style="font-size: 20pt;" data-toggle="modal" href="#joinClubsModal"><span
				class="icon glyphicon glyphicon-list"></span><br><b>Join Clubs</b></a>
									
	<div class="modal fade" id="joinClubsModal">
		<div class="modal-dialog" style="top: 25%;">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px; font-size: 20pt;"><b>Do You Want to Join These Clubs?</b></div>
				<div class="modal-body" style="padding: 40px 50px;">
				<form method="GET" action="JoinAClubServlet"
						onsubmit="return confirm('Are you sure you want to join these clubs?');">
						                    <%
			ClubDao cDao = new ClubDao();
			LinkedList<Club> clubs = new LinkedList<Club>();
			clubs = cDao.displayClub();
			int index = 0;
		%>
								<%
							while (index < clubs.size()) {
						%>
              
              <label><input type="checkbox" name="club_id_num" value="<%=clubs.get(index).getClub_id_num()%>" /> 	<%
												out.println(clubs.get(index).getClub_name());
											%></label><br>
              
            <%
										index++;
										}
									%> 

						<button type="submit" class="btn btn-success center">
							<span class="glyphicon glyphicon-ok-sign"></span> Join
						</button>
						<button type="button" class="btn btn-danger center"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-remove-sign"></span> Not Yet
						</button>
						</form>
				</div>
			</div>
		</div>

	</div>
	<%} %>
                  <div class="range range-lg text-left">
					  
              
              <div class="cell-sm-5 cell-sm-6 offset-top-66 offset-sm-top-0">
                <!-- Portfolio-->
                <h3>Sports</h3>
                <%
			ClubDao cDao1 = new ClubDao();
			LinkedList<Club> clubList1 = new LinkedList<Club>();
			clubList1 = cDao1.displayClubByPreference("sports");


			int index1 = 0;
		%>
                <hr>
                <ul class="list list-unstyled">
                 <%
                   if(clubList1.size()>0){
							while (index1 < clubList1.size()) {
						%>
                          <!-- Sitemap-->
                          <li class="post-meta inset-left-10"><form action="ClubHomepageServlet" method="GET">
                          <a type="button" class="btn-xs btn-danger" href="ClubHomepage?club_id_num=<%=(clubList1.get(index1).getClub_id_num())%>"><span class="icon icon-xxs text-middle mdi mdi-run"></a></span>
                           <span class="text-middle-bold"><strong><%=clubList1.get(index1).getClub_name()%></strong></span>
                           </form>
                                  </li>
                                  <hr class="divider bg-gray-darkest hr-lg-left-0">
                          
                          
                          <%
										index1++;
										}
                   }else{%>
                   <span class=""></span> <span class="text-middle">Currently no clubs</span>
                                  
                	   <hr class="divider bg-gray-darkest hr-lg-left-0">
                 <%  }
            	%>   
            	</ul>        
                <div class="offset-top-41">
                  <!-- Blog-->
                  <h3>Movies</h3>
                    <%
			ClubDao cDao2 = new ClubDao();
			LinkedList<Club> clubList2 = new LinkedList<Club>();
			clubList2 = cDao2.displayClubByPreference("movies");


			int index2 = 0;
		%>

                  <hr>
                    <ul class="list list-unstyled">
                    <%
                   if(clubList2.size()>0){
							while (index2 < clubList2.size()) {


						%>
                          <!-- Sitemap-->
                         
                                   <li class="post-meta inset-left-10"><form action="ClubHomepageServlet" method="GET">
                          <a type="button" class="btn-xs btn-danger" href="ClubHomepage?club_id_num=<%=(clubList2.get(index2).getClub_id_num())%>"><span class="icon icon-xxs text-middle mdi mdi-television"></a></span>
                           <span class="text-middle"><strong><%=clubList2.get(index2).getClub_name()%></strong></span>
                           </form>
                                  </li>
                                  <hr class="divider bg-gray-darkest hr-lg-left-0">
                          
                          
                          <%
										index2++;
										}
                   }else{%>
                   <span class=""></span> <span class="text-middle">Currently no clubs</span>
                                  
                	  <hr class="divider bg-gray-darkest hr-lg-left-0">
                 <%  }
            	%>                                  
                     </ul>     
                </div>
                <div class="offset-top-41 ">
                  <!-- Blog-->
                  <h3>Other</h3>
                  <%
			ClubDao cDao3 = new ClubDao();
			LinkedList<Club> clubList3 = new LinkedList<Club>();
			clubList3 = cDao3.displayClubByPreference("other");


			int index3 = 0;
		%>
                  <hr>
                    <ul class="list list-unstyled">
                   <%
                   if(clubList3.size()>0){
							while (index3 < clubList3.size()) {
						%>
                          <!-- Sitemap-->
                         
                            <li class="post-meta inset-left-10"><form action="ClubHomepageServlet" method="GET">
                          <a type="button" class="btn-xs btn-danger" href="ClubHomepage?club_id_num=<%=(clubList3.get(index3).getClub_id_num())%>"><span class="icon icon-xxs text-middle  glyphicon glyphicon-asterisk"></a></span>
                           <span class="text-middle"><strong><%=clubList3.get(index3).getClub_name()%></strong></span>
                           </form>
                                  </li>
                                 <hr class="divider bg-gray-darkest hr-lg-left-0">
                          
                          <%
										index3++;
										}
                   }else{%>
                   <span class=""></span> <span class="text-middle">Currently no clubs</span>
                       <hr class="divider bg-gray-darkest hr-lg-left-0">          
                	   
                 <%  }
            	%>                                    
                     </ul>     
                </div>
              </div>
              <div class="cell-xs-7 cell-sm-4 offset-top-66 offset-sm-top-0">
                <!-- Shop-->
                <h3>Technology</h3>
                  <%
			ClubDao cDao4 = new ClubDao();
			LinkedList<Club> clubList4 = new LinkedList<Club>();
			clubList4 = cDao4.displayClubByPreference("technology");

			int index4 = 0;
		%>
                <hr>
                <ul class="list list-unstyled">
                 <%
                   if(clubList4.size()>0){
							while (index4 < clubList4.size()) {
						%>
                          <!-- Sitemap-->
                          
                                   <li class="post-meta inset-left-10"><form action="ClubHomepageServlet" method="GET">
                          <a type="button" class="btn-xs btn-danger" href="ClubHomepage?club_id_num=<%=(clubList4.get(index4).getClub_id_num())%>"><span class="icon icon-xxs text-middle  mdi mdi-laptop"></a></span>
                           <span class="text-middle"><strong><%=clubList4.get(index4).getClub_name()%></strong></span>
                           </form>
                                  </li>
                                  <hr class="divider bg-gray-darkest hr-lg-left-0">
                          
                          
                          <%
										index4++;
										}
                   }else{%>
                   <span class=""></span> <span class="text-middle">Currently no clubs</span>
                        <hr class="divider bg-gray-darkest hr-lg-left-0">          
                	   
                 <%  }
            	%>           
                      </ul>  
                <div class="offset-top-41">
                  <!-- Components-->
                  <h3>Art</h3>
                    <%
			ClubDao cDao5 = new ClubDao();
			LinkedList<Club> clubList5 = new LinkedList<Club>();
			clubList5 = cDao5.displayClubByPreference("art");

	

			int index5 = 0;
		%>
                <hr>
                <ul class="list list-unstyled">
                 <%
                   if(clubList5.size()>0){
							while (index5 < clubList5.size()) {
						%>
                          <!-- Sitemap-->
                          
                                  
                                   <li class="post-meta inset-left-10"><form action="ClubHomepageServlet" method="GET">
                          <a type="button" class="btn-xs btn-danger" href="ClubHomepage?club_id_num=<%=(clubList5.get(index5).getClub_id_num())%>"><span class="icon icon-xxs text-middle mdi mdi-pencil"></a></span>
                           <span class="text-middle"><strong><%=clubList5.get(index5).getClub_name()%></strong></span>
                           </form>
                                  </li>
                                 <hr class="divider bg-gray-darkest hr-lg-left-0">
                                
                          
                          
                          <%
										index5++;
										}
                   }else{%>
                   <span class=""></span> <span class="text-middle">Currently no clubs</span>
                         <hr class="divider bg-gray-darkest hr-lg-left-0">        
                	   
                 <%  }
            	%>           
                      </ul>    
                </div>
              </div>
             
            </div>
                
               
              </div>
            </div>
          </div>
        </section>
		
		
 
		
		
		
		<!-- Spaces page from footer-->
		<div class="range range-xs-center offset-top-66">
			<div class="cell-md-7"></div>
		</div>
	</div>
	<!-- Page Footer -->
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
	<script src="js/js/core.min.js"></script>
	<script src="js/js/script.js"></script>

	<script>
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
	    acc[i].onclick = function(){
	        /* Toggle between adding and removing the "active" class,
	        to highlight the button that controls the panel */
	        this.classList.toggle("active");

	        /* Toggle between hiding and showing the active panel */
	        var panel = this.nextElementSibling;
	        if (panel.style.display === "block") {
	            panel.style.display = "none";
	        } else {
	            panel.style.display = "block";
	        }
	    }
	}
	</script>
</body>
</html>