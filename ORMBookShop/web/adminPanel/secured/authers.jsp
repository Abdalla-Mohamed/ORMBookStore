<%-- 
    Document   : categorymanage
    Created on : Mar 8, 2016, 7:15:20 AM
    Author     : Abdalla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<jsp:useBean id="auth" scope="page" class="com.helpclasses.GetAuthers"/>



<!DOCTYPE HTML>
<html>
    
<%@include file='head.jsp'%>

    <body class="sticky-header left-side-collapsed"  onload="initMap()">




        <section>
            <!-- left side start-->
            <%@include file='left-side.jsp'%>
            <!-- left side end-->

            <!-- main content start-->
            <div class="main-content main-content3">
                <!-- header-starts -->
                <%@include file='header.jsp'%>
                <!-- //header-ends -->
                <div id="page-wrapper">
                    <div class="graphs">
                        <h3 class="blank1">Authors Forms</h3>

                        <div class="col-md-5">
                            <!-- Horizontal Form -->
                            <div >

                                <form method="POST" action='../../AuthorControllrer' class="form-horizontal col-sm-10 switch-right-grid" style="padding: 15px;padding-left:  0">
                                    <div class="box-body col-sm-12 " >
                                        <div class="form-group col-sm-12 " style="padding: 0px" >

                                            <label for="inputEmail3" class="col-sm-4 control-label">Author Name:</label>

                                            <div class="col-sm-8" >
                                                <div class=" input-group  col-sm-12" style="margin-left: 0em;width: 100%">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-usd"></i>
                                                    </span>
                                                    <input name="autherName" class="form-control1"  type="text" placeholder="enter author name">
                                                </div>
                                            </div>


                                        </div>

                                        <div class="form-group col-sm-12 " style="padding: 0px" >

                                            <label for="inputEmail3" class="col-sm-4 control-label">About Author:</label>

                                            <div class="col-sm-8" >
                                                <div class=" input-group  col-sm-12" style="margin-left: 0em;width: 100%">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-clone"></i>
                                                    </span>
                                                    <!--<input name="cardCount" class="form-control1"  type="text" placeholder="Card Count ">-->
                                                    <textarea rows="10" class="form-control1 control2"  name="aboutAuther"></textarea>

                                                </div>
                                            </div>


                                        </div>



                                    </div >
                                    <div class="col-sm-12 " >
                                        <button type="submit" class="btn btn-info pull-right"   >Add Author </button>

                                    </div>
                                </form>
                            </div>

                        </div>

                        <div class="bs-example4 col-md-6" data-example-id="contextual-table">
                            <div class="form-group">

                                <form action="#" method="POST">
                                    <div class="input-group input-group-ind">
                                        <input type="text" name="search" class="form-control1 input-search" placeholder="Search...">
                                        <span class="input-group-btn">
                                            <button class="btn btn-success" type="submit"><i class="fa fa-search icon-ser"></i></button>
                                        </span>
                                    </div><!-- Input Group -->
                                </form>
                                <div class="clearfix"> </div>
                            </div>





                            <table class="table table table-striped">
                                <thead class="alert alert-info">
                                    <tr >
                                        <th>#</th>
                                        <th>Name</th>
                                        <th>About</th> 
                                        <th>Books count</th>
                                        <th>Edit</th>
                                        <th>Delete</th>							
                                    </tr>
                                </thead>
                                <tbody>


                                    <%--
                                    
                                    
                                    getAuthers  is  method in class GetAuthers  that retrive all data 
                                    here in jsp translated into {id.authers}
                                    
                                    
                                    
                                    --%>
                                    <c:forEach  items="${auth.authers}" var="row">

                                        <tr>

                                            <td><c:out value="${row.getAuthId()}" /></td>
                                            <td><c:out value="${row.getAuthName()}" /></td>
                                            <td><c:out value="${row.getAuthAbout()}" /></td>
                                            <td><c:out value="not support" /></td>
                                            <td><a herf="#" ><i class ="fa fa-edit"/></a></td>
                                            <td><a  herf="#" /><i  class ="fa fa-times"/></td>


                                        </tr>
                                    </c:forEach>





                                </tbody>




                            </table>
                            <!-- <a href="#" class="bt_green"><span class="bt_green_lft"></span><strong>Add new item</strong><span class="bt_green_r"></span></a> -->
                        </div>


                    </div>

                </div>


            </div>
            <!--footer section start-->
            <%@include file='footer.jsp'%>
            <!--footer section end-->
        </section>

    </body>
</html>