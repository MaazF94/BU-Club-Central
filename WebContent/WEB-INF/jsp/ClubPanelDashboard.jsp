<%@ page import="edu.ben.bu_club_central.models.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="wide wow-animation smoothscroll scrollTo">
  <head>
    <!-- Site Title-->
    <title>Club Dashboard</title>
   
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="keywords" content="intense web design multipurpose template">
    <meta name="date" content="Dec 26">
    <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />
    <!-- Stylesheets-->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu:400,400italic,500,700,700italic">
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
          <nav data-md-device-layout="rd-navbar-fixed" data-lg-device-layout="rd-navbar-static" class="rd-navbar container rd-navbar-floated rd-navbar-dark" data-lg-auto-height="true" data-md-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-stick-up="true">
            <div class="rd-navbar-inner">
              <!-- RD Navbar Top Panel-->
              <!-- RD Navbar Panel -->
              <div class="rd-navbar-panel">
                <!-- RD Navbar Toggle-->
                <button data-rd-navbar-toggle=".rd-navbar, .rd-navbar-nav-wrap" class="rd-navbar-toggle"><span></span></button>
                <!-- RD Navbar Top Panel Toggle-->
                <button data-rd-navbar-toggle=".rd-navbar, .rd-navbar-top-panel" class="rd-navbar-top-panel-toggle"><span></span></button>
                <!--Navbar Brand-->
                
              </div>
              <div class="rd-navbar-menu-wrap">
                <div class="rd-navbar-nav-wrap">
                  <div class="rd-navbar-mobile-scroll">
                    <!--Navbar Brand Mobile-->
                   
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
        					<%int role_id = ((User) session.getAttribute("user")).getRole_id(); %>
        						<%if (role_id == 1) { %>
        							<li><a href=UserServlet><span class="">Dash Board</span></a>
        						<%}else if (role_id == 2) { %>
        							<li><a href="BoardMemberDashBoard"><span class="">Dash Board</span></a>
        						<%}else { %>
        							<li><a href="AdminHome"><span class="">Dash Board</span></a>
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
                <div class="rd-navbar-search rd-navbar-search-top-panel"><a data-rd-navbar-toggle=".rd-navbar-inner,.rd-navbar-search" href="#" class="rd-navbar-search-toggle mdi"><span></span></a>
                  <form action="search-results.html" method="GET" class="rd-navbar-search-form search-form-icon-right rd-search">
                    <div class="form-group">
                      <label for="rd-navbar-search-form-input" class="form-label">Type and hit enter...</label>
                      <input id="rd-navbar-search-form-input" type="text" name="s" autocomplete="off" class="rd-navbar-search-form-input form-control form-control-gray-lightest"/>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </nav>
        </div>
        <div class="context-dark">
          <!-- Modern Breadcrumbs-->
          <section class="breadcrumb-modern rd-parallax bg-gray-darkest">
            <div data-speed="0.2" data-type="media" data-url="img/BUSenate.jpg" class="rd-parallax-layer"></div>
            <div data-speed="0" data-type="html" class="rd-parallax-layer">
              <div class="shell section-top-98 section-bottom-34 section-md-bottom-66 section-md-98 section-lg-top-110 section-lg-bottom-41">
                <h2 class="veil reveal-md-block offset-top-30"><span class="big"><br> <br> </span></h2>
                
              </div>
            </div>
          </section>
        </div>
      </header>
      <!-- Page Contents-->
      <main class="page-content">
        <section id="welcome" class="section-98 section-sm-110">
          <div class="shell">
            <h1>Welcome</h1>
            <hr class="divider bg-red">
            <div class="range range-xs-center offset-top-66">
              <div class="cell-lg-8">
                <p>Welcome to the Benedictine Senate homepage! From here you can:</p>
              </div>
            </div>
            <div class="range offset-top-98">
              <div class="cell-sm-8 cell-sm-preffix-2 cell-md-4 cell-md-preffix-0">
                <!-- Icon Box Type 5-->
                <div class="box-icon box-icon-bordered"><a data-toggle="modal" href="#sendModal"><span class="icon icon-outlined icon-sm icon-dark-filled mdi mdi-email"></span></a>
                  <h4 class="text-danger offset-top-20">Send an E-mail</h4>
                  <p></p>
                </div>
              </div>
              <div class="cell-sm-8 cell-sm-preffix-2 cell-md-4 cell-md-preffix-0 offset-top-98 offset-md-top-0">
                <!-- Icon Box Type 5-->
                <div class="box-icon box-icon-bordered"><a data-toggle="modal" href="#deleteModal"><span class="icon icon-outlined icon-xs icon-dark-filled mdi mdi-account"></span></a>
                  <h4 class="text-danger offset-top-20">Join the Club!</h4>
                  <p></p>
                </div>
              </div>
              <div class="cell-sm-8 cell-sm-preffix-2 cell-md-4 cell-md-preffix-0 offset-top-98 offset-md-top-0">
                <!-- Icon Box Type 5-->
                <div class="box-icon box-icon-bordered"><a data-toggle="modal" href="#createModal"><span class="icon icon-outlined icon-sm icon-dark-filled mdi mdi-calendar-check thumbnail:hover"></span> </a>
                  <h4 class="text-danger offset-top-20">RSVP for an Event</h4>
                  <p></p>
                </div>
              </div>
            </div>
          </div>
        </section>
      </main>
    <!-- Page Footer-->
      <footer class="section-relative section-top-66 section-bottom-34 page-footer bg-gray-base context-dark">
        <div class="shell">
          <div class="range range-sm-center text-lg-left">
            <div class="cell-sm-12">
              <div class="range range-xs-center">
                <div class="cell-xs-10 cell-sm-3 text-left cell-sm-push-4 cell-sm-10 cell-lg-3 offset-sm-top-50 offset-lg-top-0 cell-lg-push-2">
                  <!-- Twitter Feed-->
                  <h6 class="text-uppercase text-spacing-60 text-center text-lg-left">Twitter Feed</h6>
                  <div class="offset-top-20">
                    <div data-twitter-username="templatemonster" data-twitter-date-hours=" hours ago" data-twitter-date-minutes=" minutes ago" class="twitter">
                      <div data-twitter-type="tweet" class="twitter-sm">
                        <div class="twitter-date text-dark small"><span class="icon icon-xxs mdi mdi-twitter text-middle"></span> <span data-date="text" class="text-middle"></span>
                        </div>
                        <div data-tweet="text" class="twitter-text"></div>
                        <div data-screen_name="text" class="twitter-name text-bold big"></div>
                      </div>
                      <div data-twitter-type="tweet" class="twitter-sm">
                        <div class="twitter-date text-dark small"><span class="icon icon-xxs mdi mdi-twitter text-middle"></span> <span data-date="text" class="text-middle"></span>
                        </div>
                        <div data-tweet="text" class="twitter-text"></div>
                        <div data-screen_name="text" class="twitter-name text-bold big"></div>
                      </div>
                    </div>
                  </div>
                </div>
               
                
                <div class="cell-xs-10 cell-sm-3 offset-top-66 cell-sm-push-1 offset-sm-top-0 cell-sm-6 cell-lg-3 cell-lg-push-1">
                  <!-- Footer brand-->
                  <div class="footer-brand"><a href="../index.html"><img src="img/logo_benedictinetransparentwhite.png" width="238" height="30" alt="" class="img-responsive reveal-inline-block"></a></div>
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
                  <p class="text-darker offset-top-20">The F.I.R.M. &copy; <span id="copyright-year"></span> . <a href="privacy.html">Privacy Policy</a>
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
            <button title="Close (Esc)" class="pswp__button pswp__button--close"></button>
            <button title="Share" class="pswp__button pswp__button--share"></button>
            <button title="Toggle fullscreen" class="pswp__button pswp__button--fs"></button>
            <button title="Zoom in/out" class="pswp__button pswp__button--zoom"></button>
            <div class="pswp__preloader">
              <div class="pswp__preloader__icn">
                <div class="pswp__preloader__cut">
                  <div class="pswp__preloader__donut"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
            <div class="pswp__share-tooltip"></div>
          </div>
          <button title="Previous (arrow left)" class="pswp__button pswp__button--arrow--left"></button>
          <button title="Next (arrow right)" class="pswp__button pswp__button--arrow--right"></button>
          <div class="pswp__caption">
            <div class="pswp__caption__center"></div>
          </div>
        </div>
      </div>
    </div>
<!-- delete Modal -->
  <div class="modal fade" id="deleteModal" role="dialog">
    <div class="modal-dialog" style="top:25%;">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="id"><span class="glyphicon glyphicon-user"></span> Member ID</label>
              <input type="text" class="form-control" id="id" placeholder="Enter ID">
            </div>
            <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-eye-open"></span> Member E-mail</label>
              <input type="text" class="form-control" id="email" placeholder="Enter email">
            </div>
            
            <button type="submit" class="btn btn-danger center"><span class="icon icon-xxs mdi mdi-delete"></span> Join</button>
          </form>
        </div>
      </div>
    </div>
  </div> 
  
  <!-- send Modal -->
  <div class="modal fade" id="sendModal" role="dialog">
    <div class="modal-dialog" style="top:25%;">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group offset-top-20">
                <div class="input-group input-group-sm"><span class="input-group-addon input-group-addon-inverse"> <i class="fa fa-commenting-o" style="font-size:19px"></i></span>
                  <textarea style="height:100px;" id="comment" placeholder="Type your message here..." type="text" name="content"class="form-control"></textarea> 
                </div>
              </div>
            <button type="submit" class="btn btn-danger center"><span class="icon icon-xxs mdi mdi-email"></span> Send</button>
          </form>
        </div>
      </div>
    </div>
  </div> 
  
<!-- create Modal -->
  <div class="modal fade" id="createModal" role="dialog">
    <div class="modal-dialog" style="top:25%;">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="id"><span class="glyphicon glyphicon-user"></span>Event Date</label>
              <input type="text" class="form-control" id="id" placeholder="Enter ID">
            </div>
            <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-eye-open"></span> Event Name</label>
              <input type="text" class="form-control" id="email" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="id"><span class="glyphicon glyphicon-user"></span> Location</label>
              <input type="text" class="form-control" id="id" placeholder="Enter ID">
            </div>
            
            <button type="submit" class="btn btn-danger center"><span class="icon icon-xxs mdi mdi-delete"></span> RSVP</button>
          </form>
        </div>
      </div>
    </div>
  </div>   
<script>
$(document).ready(function(){
        $("#deleteModal").modal();
        $("#sendModal").modal();
        $("#createModal").modal();
    });
</script>
    <!-- Java script-->
    <script src="js/js/core.min.js"></script>
    <script src="js/js/script.js"></script>
  </body>
</html>