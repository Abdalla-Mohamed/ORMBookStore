<%-- 
    Document   : header
    Created on : 14-Mar-2016, 18:35:53
    Author     : ElGazzar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
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
    <body>
        <div>
        <!-- Start Top Nav Bar -->
          <section class="top-nav-bar">
            <section class="container-fluid container">
              <section class="row-fluid">
                <section class="span6">
                  <ul class="top-nav">
                    <li><a href="index.jsp" class="active">Home page</a></li>
                    <li><a href="grid-view.jsp">Online Store</a></li>
                    <li><a href="blog.jsp">Blog</a></li>
                    <li><a href="contact.jsp">Contact Us</a></li>
                   </ul>
                </section>
                <section class="span6 e-commerce-list">
                  <ul>
                    <li>Welcome! <a href="checkout.jsp">Login</a> or <a href="checkout.jsp">Create an account</a></li>
                    <li><p>Welcome you are user number ${applicationScope.x+1}</p>
                        <c:set var="x" scope="application" value="${x+1}"/></li>
                  </ul>
                  <div class="c-btn"> <a href="cart.jsp" class="cart-btn">Cart</a>
                    <div class="btn-group">
                      <button data-toggle="dropdown" class="btn btn-mini dropdown-toggle">0 item(s) - $0.00<span class="caret"></span></button>
                      <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                      </ul>
                    </div>
                  </div>
                </section>
              </section>
            </section>
          </section>
          <!-- End Top Nav Bar -->
          <header id="main-header">
            <section class="container-fluid container">
              <section class="row-fluid">
                <section class="span4">
                  <h1 id="logo"> <a href="index.jsp"><img src="images/logo.png" /></a> </h1>
                </section>
                <section class="span8">
                  <ul class="top-nav2">
                    <li><a href="checkout.jsp">My Account</a></li>
                    <li><a href="cart.jsp">My Cart</a></li>
                    <li><a href="checkout.jsp">Checkout</a></li>
                    <li><a href="order-recieved.jsp">Track Your Order</a></li>
                  </ul>
                  <div class="search-bar">
                    <input name="" type="text" value="search entire store here..." />
                    <input name="" type="button" value="Serach" />
                  </div>
                </section>
              </section>
            </section>
            <!-- Start Main Nav Bar -->
            <nav id="nav">
              <div class="navbar navbar-inverse">
                <div class="navbar-inner">
                  <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                  <div class="nav-collapse collapse">
                    <ul class="nav">
                      <li> <a href="grid-view.jsp">Books</a> </li>
                      <li> <a href="grid-view.jsp">NOOK Books</a></li>
                      <li><a href="grid-view.jsp">Textbooks</a></li>
                      <li><a href="grid-view.jsp">News stand</a></li>
                      <li><a href="grid-view.jsp">Teens</a></li>
                      <li><a href="grid-view.jsp">Toys & Games</a></li>
                      <li class="dropdown"> <a class="dropdown-toggle" href="grid-view.jsp" data-toggle="dropdown"><i class="icon-heart"></i> Features<b class="caret"></b> </a>
                        <ul class="dropdown-menu">
                            <li><a href="about-us.jsp">About Us</a></li>
                            <li><a href="blog.jsp">Blog</a></li>
                            <li><a href="blog-detail.jsp">Blog Detail</a></li>
                            <li><a href="grid-view.jsp">Product Grid View</a></li>
                            <li><a href="list-view.jsp">Product List View</a></li>
                            <li><a href="grid-view-without-side-bar.jsp">Product Grid View Without Side Bar</a></li>
                            <li><a href="shortcodes.jsp">Short Codes</a></li>
                            <li><a href="blog-detail.jsp">News</a></li>
                            <li><a href="contact.jsp">Contact Us</a></li>
                        </ul>
                      </li>
                      <li class="dropdown"> <a class="dropdown-toggle" href="grid-view.jsp" data-toggle="dropdown">Movies & TV <b class="caret"></b> </a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Submenu Detail Column 1</a></li>
                          <li><a href="#">Submenu Detail Column 2</a></li>
                          <li><a href="#">Submenu Detail Column 3</a></li>
                        </ul>
                      </li>
                      <li> <a href="grid-view.jsp">Music</a></li>
                      <li> <a href="grid-view.jsp">Gift Cards</a> </li>
                      <li><a href="grid-view.jsp">Deals & Offers</a></li>
                    </ul>
                  </div>
                  <!--/.nav-collapse -->
                </div>
                <!-- /.navbar-inner -->
              </div>
              <!-- /.navbar -->
            </nav>
            <!-- End Main Nav Bar -->
          </header>
        </div>
    </body>
</html>
