<%-- 
    Document   : index
    Created on : Mar 7, 2016, 8:00:33 PM
    Author     : Hend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="com.helpclasses.BookLists"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookLists" scope="page" class="com.helpclasses.BookLists" />
<c:set var="books" value="${bookLists.allBooks}"> </c:set> 
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Book Store</title>
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
<!-- Start Main Wrapper -->
<div class="wrapper">
  <!-- Start Main Header -->
  <%@include file='header.jsp'%>
  <!-- End Main Header -->
  <!-- Start Main Content Holder -->
  <section id="content-holder" class="container-fluid container">
    <section class="row-fluid">
      <section class="span12 slider">
        <section class="main-slider">
            <c:forEach  items="${books}" var="book" varStatus="loop" >
          <div class="bb-custom-wrapper">
            <div id="bb-bookblock" class="bb-bookblock">
              <div class="bb-item">
                <div class="bb-custom-content">
                  <div class="slide-inner">
                    <div class="span4 book-holder"> <a href="book-detail.jsp"><img src="../productImage?imageName=${book.wrapPathBFrontImg()}" alt="Book" /></a>
                      <!--<div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>-->
                    </div>
                    <div class="span8 book-detail">
                      <h2>${book.getBName()}</h2>
                      <!--<strong class="title">by Naguib Mahfouz</strong>--> 
                      <span class="rating-bar"> <img src="images/raing-star2.png" alt="Rating Star" /> </span> <a href="book-detail.jsp" class="shop-btn">SHOP NOW</a>
                      <div class="cap-holder">
                        <p><img src="images/image27.png" alt="Best Choice" align="right"/>  ${book.getBDescription()}</p>
                        <!--<a href="book-detail.jsp">Read More</a> </div>-->
                    </div>
                  </div>
                </div>
              </div>
              
            </div>
          </div>
          <nav class="bb-custom-nav"> <a href="#" id="bb-nav-prev" class="left-arrow">Previous</a> <a href="#" id="bb-nav-next" class="right-arrow">Next</a> </nav>
                  </c:forEach>

            </section>
        <span class="slider-bottom"><img src="images/slider-bg.png" alt="Shadow"/></span> </section>
      <section class="span12 wellcome-msg m-bottom first">
        <h2>WELCOME TO BookShoppe’.</h2>
        <p>Offering a wide selection of books on thousands of topics at low prices to satisfy any book-lover!</p>
      </section>
    </section>
    <section class="row-fluid ">
      <figure class="span4 s-product">
        <div class="s-product-img"><a href="book-detail.jsp"><img src="imgs/mahfouz/sugar street2.jpg" alt="Image02"/></a></div>
        <article class="s-product-det">
          <h3><a href="book-detail.jsp">السكرية</a></h3>
          <p>الجزء الاخير من ثلاثية<br> نجيب محفوط </p>
          <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
          <div class="cart-price"> <a href="cart.jsp" class="cart-btn2">Add to Cart</a> <span class="price">$129.90</span> </div>
          <span class="sale-icon">Sale</span> </article>
      </figure>
      <figure class="span4 s-product">
        <div class="s-product-img"><a href="book-detail.jsp"><img src="imgs/mahfouz/palace of desire2.jpg" alt="Image02"/></a></div>
        <article class="s-product-det">
          <h3><a href="book-detail.jsp">قصر الشوق</a></h3>
          <p>الجزء الثاني من ثلاثية <br>نجيب محفوظ</p>
          <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
          <div class="cart-price"> <a href="cart.jsp" class="cart-btn2">Add to Cart</a> <span class="price">$44.95</span> </div>
          <span class="sale-icon">Sale</span> </article>
      </figure>
      <figure class="span4 s-product">
        <div class="s-product-img"><a href="book-detail.jsp"><img src="imgs/mahfouz/palace walk 2.jpg" alt="Image02"/></a></div>
        <article class="s-product-det">
          <h3><a href="book-detail.jsp">بين القصرين</a></h3>
          <p>الجزء الاول من ثلاثية<br> نجيب محفوظ</p>
          <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
          <div class="cart-price"> <a href="cart.jsp" class="cart-btn2">Add to Cart</a> <span class="price">$223.00</span> </div>
          <span class="sale-icon">Sale</span> </article>
      </figure>
    </section>
    <!-- Start BX Slider holder -->
    <section class="row-fluid features-books">
      <section class="span12 m-bottom">
        <div class="heading-bar">
          <h2>Featured Books</h2>
          <span class="h-line"></span> </div>
        <div class="slider1">
          <div class="slide"> <a href="book-detail.jsp"><img src="imgs/classics/1984.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">1984</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"> <a href="book-detail.jsp"><img src="imgs/classics/A tale of two cities.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A tale of two cities</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"> <a href="book-detail.jsp"><img src="imgs/classics/Oliver Twist.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">Oliver Twist</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"> <a href="book-detail.jsp"><img src="imgs/classics/to kill a mockingbird.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">To kill a mockingbird</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="imgs/pol&amp;his/The crossing of the Seuz2.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">مذكرات حرب اكتوبر</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="imgs/mahfouz/khan el khalili2.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">خان الخليلي</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image06.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image07.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image08.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image09.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image10.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image06.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image05.jpg" alt="" class="pro-img"/></a> <span class="title"><a href="book-detail.jsp">A Walk Across The Sun</a></span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span>
            <div class="cart-price"> <a class="cart-btn2" href="cart.jsp">Add to Cart</a> <span class="price">$129.90</span> </div>
          </div>
        </div>
      </section>
    </section>
    <!-- End BX Slider holder -->
    <!-- Start Featured Author -->
    <section class="row-fluid m-bottom">
      <section class="span9">
        <div class="featured-author">
          <div class="left"> <span class="author-img-holder"><a href="about-us.jsp"><img src="imgs/ahmed/75168471.jpg" alt=""/></a></span>
            <div class="author-det-box">
              <div class="ico-holder">
                <div id="socialicons" class="hidden-phone"> <a id="social_linkedin" class="social_active" href="#" title="Visit Google Plus page"><span></span></a> <a id="social_facebook" class="social_active" href="#" title="Visit Facebook page"><span></span></a> <a id="social_twitter" class="social_active" href="#" title="Visit Twitter page"><span></span></a> </div>
              </div>
              <div class="author-det"> <span class="title">Featured Author</span> <span class="title2">Dr. AhmedKhalid Tawfik</span>
                <ul class="books-list">
                  <li><a href="book-detail.jsp"><img src="images/image11.jpg" alt=""/></a></li>
                  <li><a href="book-detail.jsp"><img src="images/image12.jpg" alt=""/></a></li>
                  <li><a href="book-detail.jsp"><img src="images/image13.jpg" alt=""/></a></li>
                  <li><a href="book-detail.jsp"><img src="images/image14.jpg" alt=""/></a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="right">
            <div class="current-book"> <strong class="title"><a href="book-detail.jsp">يوتوبيا</a></strong>
              <p>كيف يرى الكاتب المستقبل مع تزايد الفجوة بين افراد المجتمع</p>
              <div class="cart-price"> <a href="cart.jsp" class="cart-btn2">Add to Cart</a> <span class="price">$129.90</span> </div>
            </div>
            <div class="c-b-img"> <a href="book-detail.jsp"><img src="imgs/ahmed/uotobia.jpg" alt="" /></a> </div>
          </div>
        </div>
      </section>
      <section class="span3 best-sellers">
        <div class="heading-bar">
          <h2>Best Sellers</h2>
          <span class="h-line"></span> </div>
        <div class="slider2">
          <div class="slide"><a href="book-detail.jsp"><img src="images/image15.jpg" alt=""/></a>
            <div class="slide2-caption">
              <div class="left"> <span class="title"><a href="book-detail.jsp">Thousand Splendid Miles</a></span> <span class="author-name">by Khalid Housseini</span> </div>
              <div class="right"> <span class="price">$139.50</span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span> </div>
            </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image15.jpg" alt=""/></a>
            <div class="slide2-caption">
              <div class="left"> <span class="title"><a href="book-detail.jsp">Thousand Splendid Miles</a></span> <span class="author-name">by Khalid Housseini</span> </div>
              <div class="right"> <span class="price">$139.50</span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span> </div>
            </div>
          </div>
          <div class="slide"><a href="book-detail.jsp"><img src="images/image15.jpg" alt=""/></a>
            <div class="slide2-caption">
              <div class="left"> <span class="title"><a href="book-detail.jsp">Thousand Splendid Miles</a></span> <span class="author-name">by Mr. Khalid </span> </div>
              <div class="right"> <span class="price">$139.50</span> <span class="rating-bar"><img src="images/rating-star.png" alt="Rating Star"/></span> </div>
            </div>
          </div>
        </div>
      </section>
    </section>
    <!-- End Featured Author -->
    <section class="row-fluid m-bottom">
      <!-- Start Blog Section -->
      <section class="span9 blog-section">
        <div class="heading-bar">
          <h2>Latest from the Blog</h2>
          <span class="h-line"></span> </div>
        <div class="slider3">
          <div class="slide">
            <div class="post-img"><a href="blog-detail.jsp"><img src="images/image18.jpg" alt=""/></a> <span class="post-date"><span>02</span> May</span> </div>
            <div class="post-det">
              <h3><a href="blog-detail.jsp">Our latest arrival is the Spring Summer 2013 Book Fair</a></h3>
              <span class="comments-num">6 comments</span>
              <p>Gluten-free quinoa selfies carles, kogi gentrify retro marfa viral. Aesthetic before they sold out put a bird on it sriracha typewriter. Skateboard viral irony tonx ... </p>
            </div>
          </div>
          <div class="slide">
            <div class="post-img"><a href="blog-detail.jsp"><img src="images/image29.jpg" alt=""/></a> <span class="post-date"><span>24</span> Oct</span> </div>
            <div class="post-det">
              <h3><a href="blog-detail.jsp">Our latest arrival is the Spring Summer 2012 Book Fair</a></h3>
              <span class="comments-num">48 comments</span>
              <p>Gluten-free quinoa selfies carles, kogi gentrify retro marfa viral. Aesthetic before they sold out put a bird on it sriracha typewriter. Skateboard viral irony tonx ... </p>
            </div>
          </div>
          <div class="slide">
            <div class="post-img"><a href="blog-detail.jsp"><img src="images/image30.jpg" alt=""/></a> <span class="post-date"><span>10</span> Aug</span> </div>
            <div class="post-det">
              <h3><a href="blog-detail.jsp">Our latest arrival is the Spring Summer 2011 Book Fair</a></h3>
              <span class="comments-num">24 comments</span>
              <p>Gluten-free quinoa selfies carles, kogi gentrify retro marfa viral. Aesthetic before they sold out put a bird on it sriracha typewriter. Skateboard viral irony tonx ... </p>
            </div>
          </div>
        </div>
      </section>
      <!-- End Blog Section -->
      <!-- Start Testimonials Section -->
      <section class="span3 testimonials">
        <div class="heading-bar">
          <h2>Testimonials</h2>
          <span class="h-line"></span> </div>
        <div class="slider4">
          <div class="slide">
            <div class="author-name-holder"> <img src="images/image19.png" /> </div>
            <strong class="title">Robert Smith <span>Manager</span></strong>
            <div class="slide">
              <p>Lorem ipsum dolor slo onsec nelioro tueraliquet Morbi nec In Curabitur lorem in design Morbi nec In Curabituritus gojus, </p>
            </div>
          </div>
          <div class="slide">
            <div class="author-name-holder"> <img src="images/image19.png" /> </div>
            <strong class="title">Mr. Khalid Hosseini <span>Manager</span></strong>
            <div class="slide">
              <p>Gluten-free quinoa selfies carles, kogi gentrify retro marfa viral. Aesthetic before they sold out put a bird on it sriracha typewriter. Skateboard viral irony tonx ... </p>
            </div>
          </div>
        </div>
      </section>
      <!-- End Testimonials Section -->
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
