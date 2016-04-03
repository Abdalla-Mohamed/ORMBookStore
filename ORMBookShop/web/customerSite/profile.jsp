<%-- 
    Document   : profile
    Created on : Mar 11, 2016, 3:12:44 PM
    Author     : Hosam
--%>

<%@page import="com.beans.Customer"%>
<%@page import="com.helpclasses.CustomerFavoriteCategories"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Blog</title>
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
<jsp:useBean id="customer" scope="session" type="com.beans.Customer"/>    
<jsp:useBean id="favoriteCat" scope="page" class="com.helpclasses.CustomerFavoriteCategories"/>    
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
        	<h2>My Profile</h2>
            <span class="h-line"></span>
        </div>
        <!-- Start Main Content -->
        <section class="span9 first">
        	<!-- Start Ad Slider Section -->            <!-- End Ad Slider Section -->
            
            <!-- Start Sort by Section -->
          <div class="product_sort">
              
              <a href="update-profile.jsp"><h2>Update Profile</h2></a> 
<div>
    <h3>Welcome <c:out value="${customer.CName}"/></h3>
    <h4>your balance is <c:out value="${customer.CCredit}"/></h4>
    <h4>your current address is <c:out value="${customer.CAddress}"/></h4>
    <h4>your current job is <c:out value="${customer.CJob}"/></h4>
    <h4>your current phone number is <c:out value="${customer.CMobile}"/></h4>
    <h4>-------------------------------------------------------------</h4>
       
    <h3>your favorite categories :</h3>
    <c:set var="id" value="${customer.CId}"/>

    <%--<c:forEach  items="${favoriteCat.getFCategories(id)}" var="row">--%>
     <!--<h4>  <c:out value="${row.getCatName()}"/>  <hr>-->
       <%--</c:forEach>--%>
                </div>
                
            	<div class="row-2"> </div>
            </div>
            <!-- End Sort by Section -->
            
            <!-- Start Blog Post Section -->        	<!-- End Blog Post Section -->
            
            <!-- Start Blog Post Section -->        	<!-- End Blog Post Section -->
            
            <!-- Start Blog Post Section -->
            
        	<!-- End Blog Post Section -->
            
            <!-- End Blog Post Section -->            <!-- End Blog Post Section -->
            
        </section>
        <!-- End Main Content -->
        
        <!-- Start Main Side Bar -->
        <section class="span3">
        	<div class="side-holder">
            	<article class="banner-ad"><img src="images/image20.jpg" alt="Banner Ad" /></article>
            </div>
            
            <!-- Start Shop by Section -->
            <div class="side-holder">
            	<article class="shop-by-list">
                	<h2>Shop by</h2>
                    <div class="side-inner-holder">
                    	<strong class="title">Category</strong>
                    	<ul class="side-list">
                        	<li><a href="#">Fiction (15)</a></li>
                            <li><a href="#">Healthcare (15)</a></li>
                            <li><a href="#">Technology (15)</a></li>
                            <li><a href="#">Science(15)</a></li>
                        </ul>
                        <strong class="title">Price</strong>
                    	<ul class="side-list">
                        	<li><a href="#">$0.00 - $10,00.00 (13)</a></li>
                            <li><a href="#">$10,00.00 - $20,00.00 (2)</a></li>
                        </ul>
                        <strong class="title">Author</strong>
                        <ul class="side-list">
                        	<li><a href="#">Khalid Hoessini (9)</a></li>
                            <li><a href="#">William Blake (2)</a></li>
                            <li><a href="#">Anna Kathrinena (1)</a></li>
                            <li><a href="#">Gray Alvin (3)</a></li>
                        </ul>
                    </div>
                </article>
            </div>
            <!-- End Shop by Section -->
            
            <!-- Start Latest Reviews Section -->
            <div class="side-holder"> </div>
            <!-- End Latest Reviews Section -->
            
            <!-- Start Price Range Section -->
            <div class="side-holder">
            	<article class="price-range">
                	<h2>Price Range</h2>
                    <div class="side-inner-holder">
                    	<p>Select the price range for better search</p>                    	
                        <div id="slider-range"></div>
                        <p> <input type="text" id="amount" class="r-input"> </p>
                    </div>
                </article>
            </div>
            <!-- End Price Range Section -->
            
            <!-- Start Community Poll Section -->
            <div class="side-holder">
            	<article class="price-range">
                	<h2>Community Poll</h2>
                    <div class="side-inner-holder">
                    	<p>Who is your favourite American author?</p>
                    	<label class="radio">
                        	<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                        	Jane Austin
                        </label>
                        <label class="radio">
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                            William Blake
                        </label>
                        <label class="radio">
                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                            Keith Urban
                        </label>
                        <label class="radio">
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                            Anna Smith
                        </label>
                        <a href="#" class="vote-btn">Vote</a>
                    </div>
                </article>
            </div>
            <!-- End Community Poll Section -->
            
        </section>
        <!-- End Main Side Bar -->
    </section>
  </section>
  <!-- End Main Content Holder -->
  <!-- Start Footer Top 1 -->
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
