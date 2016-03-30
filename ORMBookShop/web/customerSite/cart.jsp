<%-- 
    Document   : cart
    Created on : Mar 7, 2016, 10:36:32 PM
    Author     : Hend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.helpclasses.CartController"%>
<%@page import="com.beans.Book"%>
<%@page import="com.beans.Cart"%>
<%@page import="com.beans.Customer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="CartController" scope="page" class="com.helpclasses.CartController" />
<jsp:useBean id="customer" scope="session" type="com.beans.Customer" />
<c:set var="cartList" value="${CartController.getCustomerCart(customer.CId) }"> </c:set> 
<c:set var="total" value="0"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Cart</title>
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
                                            <!-- Start Main Content -->
                                            <section class="span12 cart-holder">
                                                <div class="heading-bar">
                                                    <h2>SHOPPING CART</h2>
                                                    <span class="h-line"></span>
                                                    <a href="#" class="more-btn">proceed to checkout</a>
                                                </div>
                                                <div class="cart-table-holder">
                                                    <table width="100%" border="0" cellpadding="10">
                                                        <tr>
                                                            <!--<th width="14%">&nbsp;</th>-->
                                                            <th width="20%" align="left">Product Name</th>
                                                            <th width="6%"></th>
                                                            <th width="10%">Unit Price</th>
                                                            <th width="10%">Quantity</th>
                                                            <th width="10%">Available Quantity</th>
                                                            <th width="12%">Subtota</th>
                                                            <th width="5%">&nbsp;</th>
                                                        </tr>

                                                        <c:forEach items="${cartList}" var="cartItem" varStatus="loobIndex" >
                                                            <tr bgcolor="#FFFFFF" class=" product-detail">
                                                                <td valign="top"><img width="100%" src="../productImage?imageName=${cartItem.getBook().getBFrontImg()}" /></td>
                                                                <td align="center" valign="center">${cartItem.getBook().getBName()}</td>
                                                                <td align="center" valign="center"><a href="#">Edit</a></td>
                                                                <td align="center" valign="center">${cartItem.getBook().getBPrice()}</td>
                                                                <td align="center" valign="center"><input name="" type="number" step="any" max="${cartItem.getBook().getBCount()}" value="${cartItem.getCBCount()}" readonly='true' /></td>
                                                                <td align="center" valign="center"><input name="" type="text" value="${cartItem.getBook().getBCount()}" readonly="true" /></td>
                                                                <td align="center" valign="center">${cartItem.getBook().getBPrice()*cartItem.getCBCount()}</td>
                                                                <td align="center" valign="center"><a href="#"> <i class="icon-trash"></i></a></td>
                                                            </tr>
                                                            <c:set var="total" value="${total+(cartItem.getBook().getBPrice()*cartItem.getCBCount())}"/>
                                                        </c:forEach>  


                                                    </table>

                                                </div>

                                                <figure class="span4 first">
                                                    <!--            	<div class="cart-option-box">
                                                                    
                                                                    </div>-->
                                                </figure>
                                                <figure class="span4">
                                                    <div class="cart-option-box">
                                                        <h4><i class="icon-money"></i> DISCOUNT CODES</h4>
                                                        <p>Enter your coupon code if you have one.</p>
                                                        <input type="text" id="inputDiscount" placeholder="">
                                                            <br />
                                                            <div class="clearfix">
                                                                <a href="#" class="more-btn">apply coupon</a>
                                                                </div>
                                                                </figure>
                                                                <figure class="span4 price-total">
                                                                    <div class="cart-option-box">
                                                                        <table width="100%" border="0" cellpadding="10" class="total-payment">
                                                                            <tr>
                                                                                <td width="55%" align="right"><strong>your credit</strong></td>
                                                                                <td width="45%" align="left">$${customer.CCredit}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="right"><strong class="large-f">CART TOTAL</strong></td>
                                                                                <td align="left"><strong class="large-f">$${total}</strong></td>
                                                                            </tr>
                                                                        </table>
                                                                        <hr />
                                                                          <c:if test="${ customer.CCredit lt total }">

                                                                        <p style="color: red">you don't have enough credit</p>
                                                                        </c:if>
                                                                       
                                                                        <c:if test="${ customer.CCredit ge total }">
                                                                            <a href="../CheckoutProcess?customer=${customer.CId}&total=${total}" class="more-btn">proceed to checkout</a>
                                                                        </c:if>
                                                                    </div>
                                                                </figure>
                                                                </section>
                                                                <!-- End Main Content -->
                                                              
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
