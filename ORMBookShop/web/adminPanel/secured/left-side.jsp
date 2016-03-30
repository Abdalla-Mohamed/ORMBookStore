<%-- 
    Document   : left-side
    Created on : 15-Mar-2016, 18:36:41
    Author     : ElGazzar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <h1><a href="index.jsp">Easy <span>Admin</span></a></h1>
    </div>
    <div class="logo-icon text-center">
        <a href="index.jsp"><i class="lnr lnr-home"></i> </a>
    </div>

    <!--logo and iconic logo end-->
    <div class="left-side-inner">

        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="index.jsp"><i class="lnr lnr-power-switch"></i>
                    <span>Dashboard</span></a></li>

            <li><a href="forms.jsp"><i class="fa fa-credit-card-alt"></i> <span>Forms</span></a></li>
            <li><a href="tables.jsp"><i class="lnr lnr-menu"></i> <span>Tables</span></a></li>              
            <li class="menu-list"><a href="#"><i class="lnr lnr-envelope"></i> <span>MailBox</span></a>
                <ul class="sub-menu-list">
                    <li><a href="inbox.jsp">Inbox</a> </li>
                    <li><a href="compose-mail.jsp">Compose Mail</a></li>
                </ul>
            </li>  
            <li class="menu-list act"><a href="#"><i class="lnr lnr-indent-increase"></i> <span>Menu Levels</span></a>  
                <ul class="sub-menu-list">
                    <li><a href="charts.jsp">Basic Charts</a> </li>
                </ul>
            </li>

            <li class="menu-list"><a href="#"><i class="lnr lnr-book"></i>  <span>Pages</span></a> 
            <li class="menu-list"><a href="#"><i class="fa fa-book"></i>  <span>Pages</span></a> 

            
            <li class="menu-list"><a href="sign-in.jsp"><i class="fa fa-sign-in"></i>  <span>Pages</span></a> 
            <li class="menu-list"><a href="sign-up.jsp"><i class="fa fa-book"></i>  <span>Pages</span></a> 
            <li class="menu-list"><a href="authers.jsp"><i class="fa fa-user"></i>  <span>Pages</span></a> 
            <li class="menu-list"><a href="chargeCard.jsp"><i class="fa fa-money"></i>  <span>Pages</span></a></li>
        </ul>
        <!--sidebar nav end-->
    </div>
</div>
<!-- left side end-->
