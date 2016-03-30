<%-- 
    Document   : order-recieved
    Created on : 15-Mar-2016, 17:29:11
    Author     : ElGazzar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Has Been Recieved</title>
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
        <div class="wrapper">
        <!-- Start Main Header -->
        <!-- Start Top Nav Bar -->
        <%@include file='header.jsp'%>
        
        <!-- Start Main Content Holder -->
        <section id="content-holder" class="container-fluid container">
          <section class="row-fluid">
              <!-- Start Main Content -->
              <section class="span12">
                  <!-- Strat Book Detail Section -->
                  <section class="b-detail-holder">
                      <article class="title-holder">
                         <h4><i class="icon-ok"></i> Your order has been recieved</h4>
                      </article>

                  <!-- Stsrt order recieved Section -->
                      <section class="reviews-section">
                              <figure class="right-sec r-border">
                           <span class="green-t">Thank for your purchase!</span>
                              <p>Your order # is: 100000261.<br />
      You will receive an order confirmation email with details of your order and link to track it’s progress.<br />
      Click here to print a copy of your order confirmation.</p>
                              <a href="grid-view.jsp" class="more-btn ">Continue Shopping</a>
                          </figure>
                              <figure class="left-sec">
                              <div class="r-title-bar">
                                      <strong class="green-t">My Orders</strong>
                              </div>
                              <ul class="order-list">
                                      <li>
                                       <label class="checkbox">
                                      <input type="checkbox"> <span>The Kite Runner</span><br /> by Khalid Hosseini
                                      </label>
                                  </li>
                                  <li>
                                       <label class="checkbox">
                                      <input type="checkbox"> <span>The Kite Runner</span><br /> by Khalid Hosseini
                                      </label>
                                  </li>
                                  <li>
                                       <label class="checkbox">
                                      <input type="checkbox"> <span>The Kite Runner</span><br /> by Khalid Hosseini
                                      </label>
                                  </li>
                                  <li>
                                       <label class="checkbox">
                                      <input type="checkbox"> <span>The Kite Runner</span><br /> by Khalid Hosseini
                                      </label>
                                  </li>                        
                                      <li>
                                          <a href="#">View All</a>
                                  </li>
                              </ul>

                              <a href="cart.jsp" class="grey-btn">+ Add to Cart</a>
                          </figure>
                      </section>
                  <!-- End order recieved Section -->
                  </section>
                  <!-- Strat Book Detail Section -->
              </section>
              <!-- End Main Content -->

          </section>
        </section>
        <!-- End Main Content Holder -->

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
