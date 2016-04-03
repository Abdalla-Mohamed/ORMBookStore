<%-- 
    Document   : book-detail.jsp
    Created on : Mar 7, 2016, 10:46:26 PM
    Author     : Hend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--<jsp:useBean id="book" scope="page" class="com.helpclasses.GetOneBook"/>--%>
<jsp:useBean id="bookdetials" scope="session" type="com.beans.Book"/>    


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Book Detail</title>
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
<style>
/* styles unrelated to zoom */
.zoom { display:inline-block; position: relative; }
.zoom:after { content:''; display:block; width:33px; height:33px; position:absolute; top:0; right:0; background:url(icon.png); }
.zoom img { display: block; }
.zoom img::selection {background-color: transparent;}
#ex2 img:hover { cursor: url(grab.cur), default; }
#ex2 img:active { cursor: url(grabbed.cur), default; }
</style>
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
        	<h2>Book Detail</h2>
            <span class="h-line"></span>
        </div>
        <!-- Start Main Content -->
        <section class="span9 first">
        	<!-- Start Ad Slider Section -->
			<div class="blog-sec-slider">
                <div class="slider5">
                    
                    <div class="slide"><a href="#"><img src="images/image22.jpg" alt=""/></a></div>
                  <div class="slide"><a href="#"><img src="images/image36.jpg" alt=""/></a></div>
                  <div class="slide"><a href="#"><img src="images/image22.jpg" alt=""/></a></div>
                </div>
            </div>
            <!-- End Ad Slider Section -->
            
            <!-- Strat Book Detail Section -->
            <section class="b-detail-holder">
            	<article class="title-holder">
                	<div class="span6">
                    	<h4><strong>The Kite Runner</strong> 
                            <c:out value="${bookdetials.BName}"/>
                        
                        </h4>
                    </div>
                    <div class="span6 book-d-nav">
                    	<ul>
                        	<li><a href="#">2 Reviews</a></li>
                            <li><i class="icon-envelope"></i><a href="#">  Email to a Friend</a></li>
                        </ul>
                    </div>
                </article>
                <div class="book-i-caption">
                <!-- Strat Book Image Section -->
                	<div class="span6 b-img-holder">
                            
                        <span class='zoom' id='ex1'>
                            <img src="../productImage?imageName=${bookdetials.wrapPathBFrontImg()}"  height="219" width="300" id='jack' alt=''/></span>
                    </div>
                <!-- End Book Image Section -->
                
                <!-- Strat Book Overview Section -->    
                    <div class="span6">
                    	<strong class="title">Quick Overview</strong>
                        <p>
                     
                            
                        </p>
                        <p>
                            <c:out value="${bookdetials.BDescription}"/> </p>
                   		<p>Availability: <a href="#">In stock</a></p>
                        <div class="comm-nav">
                        	<strong class="title2">Quantity</strong>
                            <ul>
                                 <form action="/ORMBookShop/AddToCart" method="POST" >
                                     <li><input name="count" type="number" max='${bookdetials.BCount}' /></li><br/><br/><br/>
                                 
                                 
                                 <li class="b-price">   <c:out value="${bookdetials.BPrice}"/>
                          </li>
                                <li><button type="submit" class=" more-btn" >+ Add to Cart</button></li>   
                                <input type="hidden" name="ispnRow" value="${bookdetials.BIsbn}" />
                                 </form>
                            </ul>
                           
                        </div>
                   </div>
                <!-- End Book Overview Section -->
                </div>
                
                <!-- Start Book Summary Section -->
                	<div class="tabbable">
                      <ul class="nav nav-tabs">
                        <li class="active"><a href="#pane1" data-toggle="tab">Book Summary</a></li>
                        <li><a href="#pane2" data-toggle="tab">Additional Information</a></li>
                      </ul>
                      <div class="tab-content">
                        <div id="pane1" class="tab-pane active">
                          <p>   
                             
                          
                          </p>
                          <p>Phasellus sed vehicula justo nunc quis erat vel ante ornare pulvinar cras tristique facilisis tincidunt quisque felis erat iaculis at fringilla vitae rutrum id magna. Nam pharetra scelerisque justo at vehicula aliquam erat volutpat.
Quisque vulputate justo eu mattis interdum magna erat porta risus tincidunt </p>
                        </div>
                        <div id="pane2" class="tab-pane">
                        <h4>Pane 2 Content</h4>
                          <p> and so on ...</p>
                        </div>
                      </div><!-- /.tab-content -->
                    </div><!-- /.tabbable -->
                <!-- End Book Summary Section -->
            
            <!-- Start BX Slider holder -->  
            <section class="related-book">
            <div class="heading-bar">
            	<h2>Related Books</h2>
                <span class="h-line"></span>
            </div>
            <div class="slider6">
                      <div class="slide">
                        <a href="book-detail.jsp"><img src="images/image05.jpg" alt="" class="pro-img"/></a>
                        <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span>
                        <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                        <div class="cart-price">
                            <a class="cart-btn2" href="cart.jsp">Add to Cart</a>
                            <span class="price">$129.90</span>
                        </div>
                      </div>
                      <div class="slide">
                        <a href="book-detail.jsp"><img src="images/image06.jpg" alt="" class="pro-img"/></a>
                        <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span>
                        <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                        <div class="cart-price">
                            <a class="cart-btn2" href="cart.jsp">Add to Cart</a>
                            <span class="price">$129.90</span>
                        </div>
                      </div>
                      <div class="slide">
                        <a href="book-detail.jsp"><img src="images/image07.jpg" alt="" class="pro-img"/></a>
                        <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span>
                        <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                        <div class="cart-price">
                            <a class="cart-btn2" href="cart.jsp">Add to Cart</a>
                            <span class="price">$129.90</span>
                        </div>
                      </div>
                      <div class="slide">
                        <a href="book-detail.jsp"><img src="images/image08.jpg" alt="" class="pro-img"/></a>
                        <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span>
                        <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                        <div class="cart-price">
                            <a class="cart-btn2" href="cart.jsp">Add to Cart</a>
                            <span class="price">$129.90</span>
                        </div>
                      </div>
                    </div>
               </section>
            <!-- End BX Slider holder -->
            
            <!-- Stsrt Customer Reviews Section -->
            	<section class="reviews-section">
                	<figure class="left-sec">
                    	<div class="r-title-bar">
                        	<strong>Customer Reviews</strong>
                        </div>
                        <ul class="review-list">
                        	<li>
                            	<span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                            	<em class="">The Kite Runner</em>
                            	<p>“ Suspendisse tortor lacus, suscipit eget pharetra sed, ornare sed elit. Curabitur mollis, justo sit amet fermentum ” Review by Bookshoppe’</p>
                            </li>
                            <li>
                            	<span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
                            	<em class="">The Kite Runner</em>
                            	<p>“ Suspendisse tortor lacus, suscipit eget pharetra sed, ornare sed elit. Curabitur mollis, justo sit amet fermentum ” Review by Bookshoppe’</p>
                            </li>
                        </ul>
                        <a href="#" class="grey-btn">Write Your Own Review</a>
                    </figure>
                	<figure class="right-sec">
                    	<div class="r-title-bar">
                        	<strong>Write Your Own Review</strong>
                        </div>
                        <ul class="review-f-list">
                        	<li>
                            	<label>Your name *</label>
                                <input name="" type="text" />
                            </li>
                            <li>
                            	<label>Summary of your review *</label>
                            	<input name="" type="text" />
                            </li>
                            <li>
                            	<label>Your review *</label>
                                <textarea name="" cols="2" rows="20"></textarea>
                            </li>
                            <li>
                            	<label>How do you rate this book? *</label>
                                <div class="rating-list">
                                	<div class="rating-box">
                                    	<label class="radio">
                                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                        Star 1
                                    </label>
                                    </div>
                                    <label class="radio">
                                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                                        Star 2
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                        Star 3
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                                        Star 4
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                                        Star 5
                                    </label>
                                </div>
                            </li>
                        </ul>
                        <a href="#" class="grey-btn left-btn">Write Your Own Review</a>
                    </figure>
                </section>
            <!-- End Customer Reviews Section -->
            </section>
            <!-- Strat Book Detail Section -->
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
<script>
$(document).ready(function(){
	$('#ex1').zoom();		 
});
</script>
</body>
</html>
