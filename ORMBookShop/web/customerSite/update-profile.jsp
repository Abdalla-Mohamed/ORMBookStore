<%-- 
    Document   : update-profile
    Created on : Mar 11, 2016, 3:14:30 PM
    Author     : Hosam
--%>
<%@page import="com.beans.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.helpclasses.CategoryNames"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="category" scope="page" class="com.helpclasses.CategoryNames"/>
<jsp:useBean id="customer" scope="session" type="com.beans.Customer"/> 
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

                                                    <h2>update your profile</h2>
                                                    <form class="form-horizontal" action="../UpdateCustomerData" method="post">
                                                        <table>
                                                            <input type="hidden" name="cId" value="${customer.CId}">
                                                                <tr><td>Name</td><td><input type="text" name="cName" id="iName" value="${customer.CName}"  pattern=".{3,}" required title="3 characters minimum" ></td></tr>
                                                                <tr><td>password</td><td><input type="text" name="cPassword" id="iPassword" value="${customer.CPassword}"  pattern=".{6,}" required title="6 characters minimum"></td></tr>
                                                                <tr><td>Pone number</td><td><input type="text" name="cMobile" id="iMobile" value="${customer.CMobile}"  pattern="\d{9,}" required title="9 numbers minimum"></td></tr>
                                                                <tr><td>job</td><td><input type="text" name="cJob" id="iJob" value="${customer.CJob}"  pattern=".{3,}" required title="3 characters minimum"></td></tr>
                                                                <tr><td>Address</td><td><input type="text" name="cAddress" id="iAddress" value="${customer.CAddress}"  pattern=".{3,}" required title="3 characters minimum"></td></tr>
                                                                <tr><td></td><td><input type="submit" name="submit" class="vote-btn"></td></tr>
                                                        </table>
                                                    </form>

                                                    <div class="row-2"> </div>
                                                </div>
 <div class="product_sort">

                                                    <h2>update your profile</h2>



                                                    <table>
                                                        <form action="../FavoriteCategories" method="post" class="form-horizontal">
                                                            <tr>
                                                                <td rowspan="1" colspan="3" align="center">  <h4><font color="red" size="large">Interests</font></h4></td>
                                                            </tr>
                                                            <c:forEach  items="${category.categories}" var="row">
                                                                <c:out value="${row.getCatName()}"/>                                                

                                                                <tr><td><c:out value="${row.getCatName()}"/></td>
                                                                    <td><input type="checkbox" name="fCat" value="<c:out value='${row.getCatId()}'/>"></input></td>

                                                                </tr>

                                                            </c:forEach>
                                                            <tr><td><br></td></br></tr>
                                                            <tr><td> 
                                                                    <button type="submit" class="btn btn-info pull-right">Add Categories </button> </td>
                                                            </tr>

                                                        </form>
                                                    </table>


                                                    <div class="row-2"> </div>
                                                </div>

                                                                <br><br><br><br>
                                                                
                                              <div class="product_sort">

                                                    <figure class="span4">
                                                        <div class="cart-option-box">
                                                            <h4><i class="icon-money"></i> Charge your account </h4>
                                                            <p>Enter your coupon code if you have one.</p>
                                                            <form action="" method="post">
                                                            <input type="text" id="inputDiscount" placeholder="">
                                                                <br / class="clearfix">
                                                                    <input type="submit" name="Charge" class="vote-btn" pattern="\d{15,}" required title="15 numbers minimum">
                                                         </div>
                                                    </figure>

                                                </div>
                                                                
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
                                                                        $(document).ready(function () {
                                                                            $('.social_active').hoverdir({});
                                                                        })
                                                                        /* ]]> */
                                                                    </script>
                                                                    </body>
                                                                    </html>
