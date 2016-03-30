<%-- 
    Document   : grid-view
    Created on : Mar 7, 2016, 10:18:28 PM
    Author     : Hend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.helpclasses.BookLists"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookLists" scope="page" class="com.helpclasses.BookLists" />
<c:set var="books" value="${bookLists.allBooks}"> </c:set> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Grid View</title>
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
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" /><!-- Font Awesome iE7 Css -->
<noscript>
<link rel="stylesheet" type="text/css" href="css/noJS.css" />
</noscript>
<!-- Css Files End -->
</head>
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
        	<h2>Grid View</h2>
            <span class="h-line"></span>
        </div>
        <!-- Start Main Content -->
        <section class="span9 first">
        	 <!--Start Ad Slider Section--> 
			<div class="blog-sec-slider">
                <div class="slider5">
                  <div class="slide"><a href="#"><img src="images/image22.jpg" alt=""/></a></div>
                  <div class="slide"><a href="#"><img src="images/image22.jpg" alt=""/></a></div>
                  <div class="slide"><a href="#"><img src="images/image22.jpg" alt=""/></a></div>
                </div>
            </div>
            <!-- End Ad Slider Section 
            
            <!-- Start Grid View Section -->
            <div class="product_sort">
                <div class="row-1">
                	<div class="left">
                    	<span class="s-title">Sort by</span>
                        <span class="list-nav">
                        	<select name="">
                            	<option>Position</option>
                                <option>Position 2</option>
                                <option>Position 3</option>
                                <option>Position 4</option>
                            </select>
                        </span>
                    </div>
                    <div class="right">
                    	<span>Show</span>
                        <span>
                        	<select name="">
                            	<option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </span>
                        <span>per page</span>
                    </div>
                </div>
            	<div class="row-2">
                	<span class="left">Items 1 to 9 of 15 total</span>
                	<ul class="product_view">
                		<li>View as:</li>
                    	<li>
                        	<a class="grid-view" href="grid-view.jsp">Grid View</a>
                        </li>
                		<li>
                        	<a class="list-view" href="list-view.jsp">List View</a>
                        </li>
                	</ul>
                </div>
            </div>
            <div class="grid-holder features-books" >

                <c:forEach  items="${books}" var="book" varStatus="loop" >
                    <div class=" slide col-sm-4"  >
                     <form method="POST"   action="../ShowBookDetails1"  >
                         <input type="hidden"  name="ispnRow" value="${book.getBIsbn()}" />
                         <button type="submit" style="border: none"><img src="../productImage?imageName=${book.getBFrontImg()}" style="float: left" alt="" class="pro-img "/></button>
                     </form>
                    <span class="title"><a >${book.getBName()}</a></span>
                    <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                    <div class="cart-price">
                        <form action="/OnlineBookShop/AddToCart" method="POST">
                            <button type="submit" class="cart-btn2" style="border: none">Info</button>
                            <span class="price">${book.getBPrice()}</span>
                            <input type="hidden" name="ispnRow" value="${book.getBIsbn()}" />
                            <input name="count" type="hidden" value="1" />
                        </form>
                      
                        
              		</div>
                </div>
                
                </c:forEach>
            
            
            </div>
            
            <div class="blog-footer col-md-12" style="float: left">
            	<div class="pagination" >  
                  <ul>  
                    <li><a href="#">Prev</a></li>  
                    <li class="active">  
                      <a href="#">1</a>  
                    </li>  
                    <li><a href="#">2</a></li>  
                    <li><a href="#">3</a></li>  
                    <li><a href="#">4</a></li>  
                    <li><a href="#">Next</a></li>  
                  </ul>  
                </div>
                
            	<ul class="product_view" style="float: right">
               	
               		<li>View as:</li>
                    <li><a class="grid-view" href="cart.jsp">Grid View</a></li>
                	<li><a class="list-view" href="list-view.jsp">List View</a></li>
               </ul>
            </div>
            
            <!-- End Grid View Section -->
            
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
                        	<li><a href="grid-view.jsp">Fiction (15)</a></li>
                            <li><a href="grid-view.jsp">Healthcare (15)</a></li>
                            <li><a href="grid-view.jsp">Technology (15)</a></li>
                            <li><a href="grid-view.jsp">Science(15)</a></li>
                        </ul> 
                        <strong class="title">Price</strong>
                    	<ul class="side-list">
                        	<li><a href="#">$0.00 - $10,00.00 (13)</a></li>
                            <li><a href="#">$10,00.00 - $20,00.00 (2)</a></li>
                        </ul>
                        <strong class="title">Author</strong>
                        <ul class="side-list">
                        	<li><a href="book-detail.jsp">Khalid Hoessini (9)</a></li>
                            <li><a href="book-detail.jsp">William Blake (2)</a></li>
                            <li><a href="book-detail.jsp">Anna Kathrinena (1)</a></li>
                            <li><a href="book-detail.jsp">Gray Alvin (3)</a></li>
                        </ul>
                    </div>
                </article>
            </div> 
            <!-- End Shop by Section -->
            
            <!-- Start Latest Reviews Section -->
            <div class="side-holder">
            	<article class="l-reviews">
                	<h2>Latest Reviews</h2>
                    <div class="side-inner-holder">
                    	<article class="r-post">
                        	<div class="r-img-title">
                            	<img src="images/image21.jpg" />
                            	<div class="r-det-holder">
                                	<strong class="r-author"><a href="book-detail.jsp">The Kite Runner</a></strong>
                                	<span class="r-by">by Khalid Hoessini</span>
                                    <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                                </div>
                            </div>
                            <span class="r-type">Vivamus bibendum massa</span>
                            <p>“ Suspendisse tortor lacus, suscipit eget pharetra sed, ornare sed elit. Curabitur mollis, justo sit amet fermentum ” </p>
                            <span class="r-author">Review by BookShoppe’</span>
                        </article>
                        <article class="r-post">
                        	<div class="r-img-title">
                            	<img src="images/image21.jpg" />
                            	<div class="r-det-holder">
                                	<strong class="r-author"><a href="book-detail.jsp">The Kite Runner</a></strong>
                                	<span class="r-by">by Khalid Hoessini</span>
                                    <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                                </div>
                            </div>
                            <span class="r-type">Vivamus bibendum massa</span>
                            <p>“ Suspendisse tortor lacus, suscipit eget pharetra sed, ornare sed elit. Curabitur mollis, justo sit amet fermentum ” </p>
                            <span class="r-author">Review by BookShoppe’</span>
                        </article>
                    </div>
                </article>
            </div>
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
