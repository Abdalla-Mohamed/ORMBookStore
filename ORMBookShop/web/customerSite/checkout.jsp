<%-- 
    Document   : checkout
    Created on : Mar 7, 2016, 9:56:57 PM
    Author     : Hend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Checkout</title>
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<!--[if lt IE 9]>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<meta name="viewport" content="width=device-width">
<!-- Css Files Start -->
<link href="css/style.css" rel="stylesheet" type="text/css" /><!-- All css -->
<link href="css/bs.css" rel="stylesheet" type="text/css" /><!-- Bootstrap Css -->
<link rel="stylesheet" type="text/css" href="css/main-slider.css" /><!-- Main Slider Css -->
<!--[if lte IE 10]><link rel="stylesheet" type="text/css" href="css/customIE.css" /><![endif]-->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" /><!-- Font Awesome Css -->
<link href="css/font-awesome-ie7.css" rel="stylesheet" type="text/css" /><!-- Font Awesome iE7 Css -->
<noscript>
<link rel="stylesheet" type="text/css" href="css/noJS.css" />
</noscript>
<!-- Css Files End -->
</head>
<body>
<body>
<!-- Start Main Wrapper -->
<div class="wrapper">
  <!-- Start Main Header -->
  <!-- Start Top Nav Bar -->
  <%@include file='header.jsp'%>
  <!-- End Main Header -->
  <!-- Start Main Content Holder -->
  <section id="content-holder" class="container-fluid container">
    <section class="row-fluid">
      <div class="heading-bar">
        <h2>Checkout</h2>
        <span class="h-line"></span> </div>
      <!-- Start Main Content -->
      <section class="checkout-holder">
        <section class="span9 first">
          <!-- Start Accordian Section -->
          <div class="accordion" id="accordion2">
            <div class="accordion-group">
              <div class="accordion-heading"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"> Log In </a></div>
              <div id="collapseOne" class="accordion-body collapse in">
                <div class="accordion-inner">
<div class="span5 check-method-right"> <strong class="green-t">Login</strong>
                    <p>Already registered? Please log in below:</p>
                    <form class="form-horizontal" action="../Login" method="post">
                      <div class="control-group">
                        <label class="control-label" for="IEmail">Email Address <sup>*</sup></label>
                        <div class="controls">
                            <input type="email" name="cEmail" id="IEmail" placeholder="enter your email" required>
                        </div>
                      </div>
                      <div class="control-group">
                        <label class="control-label" for="IPassword">Password <sup>*</sup></label>
                        <div class="controls">
                            <input type="password" name="cPassword" pattern=".{6,}" required title="6 characters minimum" id="IPassword" placeholder="password" required>
                        </div>
                      </div>
                      <p><a href="#">Forgot your password?</a></p>
                      <div class="control-group">
                        <div class="controls">
                          <button type="submit" class="more-btn">Login</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            <div class="accordion-group">
              <div class="accordion-heading"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo"> New User  </a> </div>
              <div id="collapseTwo" class="accordion-body collapse">
                <div class="accordion-inner">
                	<strong class="green-t">Sign Up now</strong>
                        <form class="form-horizontal" action="../Signup" method="post">
                        <ul class="billing-form">
                            <li>   
                              <div class="control-group">
                                <label class="control-label" for="iName">Name <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="cName" pattern=".{3,}" required title="3 characters minimum" id="iName" placeholder="enter your name here" required>
                                </div>
                              </div>
                              <div class="control-group">
                                <label class="control-label" for="iPassword">Password<sup>*</sup></label>
                                <div class="controls">
                                    <input type="password" name="cPassword" pattern=".{6,}" required title="6 characters minimum" id="iPassword" placeholder="password" required>
                                </div>
                              </div>
                              
                            </li>
                            <li>   
                              <div class="control-group">
                                <label class="control-label" for="iJob">Job<sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="cJob" pattern=".{3,}" required title="3 characters minimum" id="iJob" placeholder="your Job" required>
                                </div>
                              </div>
                              <div class="control-group">
                                <label class="control-label" for="IEmail">Email Address<sup>*</sup></label>
                                <div class="controls">
                                    <input type="email" name="cEmail" id="IEmail" placeholder="Email" required>
                                </div>
                              </div>
                            </li>
                            <li>   
                              <div class="control-group">
                                <label class="control-label" for="iAddress">Address<sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="cAddress" pattern=".{3,}" required title="3 characters minimum" id="iAddress" placeholder="your address" class="address-field" required>
                                </div>
                              </div>
                            
                           
                          </li>
                            <li>   
                              <div class="control-group">
<div class="controls">
  
  
</div>
  
  								<div class="control-group">
                                <label class="control-label" for="iMobile">Mobile <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="cMobile" pattern="\d{9,}" required title="9 numbers minimum" id="iMobile" placeholder="" required>
                                </div>
</div>
                           <br><br>   <div class="control-group"> 
<div class="controls"> <strong class="green-t">* Required Fields</strong>
                            </div>
                              </div>
  
                              </div>
</li>
                            
                       	  <li>
                            	<div class="control-group">
                                <div class="controls">
                                  <button type="submit" class="more-btn">Continue</button>
                                </div>
                              </div>
                            </li>
                        </ul>
                    </form>
                </div>
              </div>
            </div>
</div>
          <!-- End Accordian Section -->
        </section>
</section>
      <!-- End Main Content -->
    </section>
  </section>
  <!-- End Main Content Holder -->
  <!-- Start Footer Top 1 -->  <!-- End Footer Top 1 -->
  <!-- Start Footer Top 2 -->  <!-- End Footer Top 2 -->
  <!-- Start Main Footer -->
  <%@include file='footer.jsp'%>
  <!-- End Main Footer -->
</div>
<!-- End Main Wrapper -->
<!-- JS Files Start -->
<script type="text/javascript" src="js/lib.js"></script><!-- lib Js -->
<script type="text/javascript" src="js/modernizr.js"></script><!-- Modernizr -->
<script type="text/javascript" src="js/easing.js"></script><!-- Easing js -->
<script type="text/javascript" src="js/bs.js"></script><!-- Bootstrap -->
<script type="text/javascript" src="js/bxslider.js"></script><!-- BX Slider -->
<script type="text/javascript" src="js/input-clear.js"></script><!-- Input Clear -->
<script src="js/range-slider.js"></script><!-- Range Slider -->
<script src="js/jquery.zoom.js"></script><!-- Zoom Effect -->
<script type="text/javascript" src="js/bookblock.js"></script><!-- Flip Slider -->
<script type="text/javascript" src="js/custom.js"></script><!-- Custom js -->
<script type="text/javascript" src="js/social.js"></script><!-- Social Icons -->
<!-- JS Files End -->
<noscript>
<style>
	#socialicons>a span { top: 0px; left: -100%; -webkit-transition: all 0.3s ease; -moz-transition: all 0.3s ease-in-out; -o-transition: all 0.3s ease-in-out; -ms-transition: all 0.3s ease-in-out; transition: all 0.3s 	ease-in-out;}
	#socialicons>ahover div{left: 0px;}
	</style>
</noscript>
<script type="text/javascript">
  /* <![CDATA[ */
  $(document).ready(function() {
  $('.social_active').hoverdir( {} );
})
/* ]]> */
</script>
</body>
</html>
