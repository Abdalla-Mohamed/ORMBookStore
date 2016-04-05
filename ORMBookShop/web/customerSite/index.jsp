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
                                                    <div class="bb-custom-wrapper">
                                                        <div id="bb-bookblock" class="bb-bookblock">
                                                            <c:forEach  items="${books}" var="book"  varStatus="loop" >
                                                                <div class="bb-item">
                                                                    <div class="bb-custom-content">
                                                                        <div class="slide-inner">
                                                                            <div class="span4 book-holder"> <a href="book-detail.jsp"><img src="../productImage?imageName=${book.wrapPathBFrontImg()}" alt="Book" /></a>
                                                                                <div class="cart-price">  <span class="price">$${book.getBPrice()}</span> </div>
                                                                            </div>
                                                                            <div class="span8 book-detail">
                                                                                <h2>${book.getBName()}</h2>
                                                                                <!--<strong class="title">by Naguib Mahfouz</strong>--> 
                                                                                <span class="rating-bar"> <img src="images/raing-star2.png" alt="Rating Star" /> </span> 
                                                                                <div class="cap-holder">
                                                                                    ${book.getBDescription()}

                                                                                    <p><img src="images/image27.png" alt="Best Choice" align="right"/></p>
                                                                                    <!--<a href="book-detail.jsp">Read More</a> </div>-->
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                </div>  

                                                            </c:forEach>

                                                        </div>
                                                        <nav class="bb-custom-nav"> <a href="#" id="bb-nav-prev" class="left-arrow">Previous</a> <a href="#" id="bb-nav-next" class="right-arrow">Next</a> </nav>

                                                </section>
                                                <span class="slider-bottom"><img src="images/slider-bg.png" alt="Shadow"/></span> </section>
                                            <section class="span12 wellcome-msg m-bottom first">
                                                <h2>WELCOME TO BookShoppe’.</h2>
                                                <p>Offering a wide selection of books on thousands of topics at low prices to satisfy any book-lover!</p>
                                            </section>
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
                                    $(document).ready(function () {
                                        $('.social_active').hoverdir({});
                                    })
                                    /* ]]> */
                                </script>
                            </body>
                            </html>
