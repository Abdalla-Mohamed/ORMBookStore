<%-- 
    Document   : categorymanage
    Created on : Mar 8, 2016, 7:15:20 AM
    Author     : Abdalla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.helpclasses.BookLists"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookLists" scope="page" class="com.helpclasses.BookLists"/>
<c:set var="books" value="${bookLists.allBooks}"> </c:set> 
<jsp:useBean id="updateBook" scope="session"  class="com.beans.Book"/>


<!DOCTYPE HTML>
<html>
    <%@include file='head.jsp'%>



    <body class="sticky-header left-side-collapsed"  onload="initMap()">
        <section>
            <!-- left side start-->
            <%@include file='left-side.jsp'%>
            <!-- left side end-->

            <!-- main content start-->
            <div class="main-content main-content4">
                <!-- header-starts -->
                <%--<%@include file='header.jsp'%>--%>
                <!-- //header-ends -->
                <div id="page-wrapper">
                    <div class="graphs">
                        <h3 class="blank1">Books manage Forms</h3>
                        <div class="xs tabls">
                            <div class="bs-example4" data-example-id="contextual-table">
                                <div class="form-group">

                                    <form action="#" method="GET">
                                        <div class="input-group input-group-ind">
                                            <input type="text" name="search" class="form-control1 input-search" placeholder="Search...">
                                            <span class="input-group-btn">
                                                <button class="btn btn-success" type="submit"><i class="fa fa-search icon-ser"></i></button>
                                            </span>
                                        </div><!-- Input Group -->
                                    </form>
                                    <div class="clearfix"> </div>
                                </div>
                                <table class="table table-striped table-bordered">
                                    <thead class="alert alert-info">
                                        <tr>
                                            <th>#</th>
                                            <th>Title</th>
                                            <th>price</th> 
                                            <th>Count</th>
                                            <th>Rate</th>
                                            <th>Edit</th>
                                            <th>Delete</th>							
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach  items="${books}" var="book" varStatus="loop" >
                                            <tr ${book.getBCount() le 20?"class=danger":""}>
                                                <th scope="row">${loop.count}</th>
                                                <td>${book.getBName()}</td>
                                                <td>${book.getBPrice()}</td>
                                                <td>${book.getBCount()}</td>
                                                <td>${book.getBRating()}</td>
                                                <!--<td><a href="#"><i class="fa fa-edit"/></a></td>-->
                                                <td>
                                                    <form action="/ORMBookShop/UpdateBookDilog" method="post">
                                                        <input type="hidden" name="ispnRow" value="${book.getBIsbn()}" />
                                                        <button type="submit" class="btn btn-primary fa fa-edit" /> 
                                                    </form>
                                                </td>

                                                <td>
                                                    <!-- <a href="#" class="ask"><i class="fa fa-times"/>
                                                         
                                                      </a>
                                                    -->
                                                    <form  action="/ORMBookShop/BookEditController" method="get" >
                                                        <input type="hidden" name="ispnRow" value="${book.getBIsbn()}" />
                                                        <button type="submit" class="btn btn-primary fa fa-times" /> 
                                                    </form>

                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>



                                <div id="editDailog" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="sign-up">
                                                <form action="/ORMBookShop/BookEditController" method="post">
                                                    <h3>Update book form</h3>
                                                    <p class="creating">Having hands on experience in creating innovative designs,I do offer design 
                                                        solutions which harness.</p>
                                                    <h5>Personal Information</h5>
                                                    <div class="sign-u">
                                                        <div class="sign-up1">
                                                            <h4>Book ISBN* :</h4>
                                                        </div>
                                                        <div class="sign-up2">
                                                            <input name="isbn" type="hidden" placeholder=" " required=" "  value="${updateBook.BIsbn}"/>
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>
                                                    <div class="sign-u">
                                                        <div class="sign-up1">
                                                            <h4>Book Title* :</h4>
                                                        </div>
                                                        <div class="sign-up2">
                                                            <input name="title" type="text" placeholder=" " required=" " value="${updateBook.BName}"/>
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>
                                                    <div class="sign-u">
                                                        <div class="sign-up1">
                                                            <h4>Count* :</h4>
                                                        </div>
                                                        <div class="sign-up2">
                                                            <input name="count" type="number" placeholder=" " min="1"  oninput="validity.valid||(value='');" required=" " value="${updateBook.BCount}" />
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>
                                                    <div class="sign-u">
                                                        <div class="sign-up1">
                                                            <h4>Price* :</h4>
                                                        </div>
                                                        <div class="sign-up2">
                                                            <input name="price" type="number" placeholder=" " required=" " min="1"  oninput="validity.valid||(value='');"  value="${updateBook.BPrice}"/>
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>
                                                    <h6>book Information</h6>
                                                    <div class="sign-u">
                                                        <div class="sign-up1">
                                                            <h4>Description* :</h4>
                                                        </div>
                                                        <div class="sign-up2">
                                                            <input name="description" type="text" placeholder=" " required=" " value="${updateBook.BDescription}" />
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>

                                                    <div class="sign-u">
                                                        <div class="sign-up1">
                                                            <h4>Quote* :</h4>
                                                        </div>
                                                        <div class="sign-up2">
                                                            <input name="quote"  type="text" placeholder=" " required=" " value="${updateBook.BQuote}" />
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>



                                                    <div class="sign-u">
                                                        <div class="sign-up1">
                                                            <h4>Rate* :</h4>
                                                        </div>
                                                        <div class="sign-up2">
                                                            <input name="rate"  type="number" placeholder=" " min="1" max="5" oninput="validity.valid||(value='');" required=" "  value="${updateBook.BRating}" />
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>
                                                    <br>

                                                    <!--<div class="form-group col-md-6">

                                                        <label for="exampleInputFile"><h4>front image* :</h4></label>
                                                        <input type="file" id="exampleInputFile" name="imgFront" value="${updateBook.BFrontImg}" >
                                                        <p class="help-block">Example block-level help text here.</p>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label for="exampleInputFile"><h4>back image* :</h4></label>
                                                        <input type="file" id="exampleInputFile" name="imgBack" value="${updateBook.BBackImg}" >
                                                        <p class="help-block">Example block-level help text here.</p>
                                                    </div>

                                                    <div class="form-group col-md-6">

                                                        <label for="exampleInputFile"><h4>1st Header image* :</h4></label>
                                                        <input type="file" id="exampleInputFile" name="frstHeader" value="${updateBook.BHdr01Img}" >
                                                        <p class="help-block">Example block-level help text here.</p>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label for="exampleInputFile"><h4>back image* :</h4></label>
                                                        <input type="file" id="exampleInputFile" name="scndHeader" value="${updateBook.BHdr02Img}" >
                                                        <p class="help-block">${updateBook.BHdr02Img}</p>
                                                    </div>
                                                    -->
                                                    <div class="sub_home">

                                                        <div class="sub_home_left">
                                                            <input type="submit" value="Save Changes">
                                                        </div>
                                                        <div class="sub_home_right">
                                                            <p>Go Back to <a href="index.jsp">Home</a></p>
                                                        </div>
                                                        <div class="clearfix"> </div>
                                                    </div>

                                                </form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                                    <!--<button class="btn-success btn centerBtn" onclick="sign-up.jsp">Add new Book</button>-->
                                <!-- <a href="#" class="bt_green"><span class="bt_green_lft"></span><strong>Add new item</strong><span class="bt_green_r"></span></a> -->
                                <center> <a href="sign-up.jsp"><input type="button" value="Add New Book"></button> </a></center>
<!--                            </div>
                            <div class="panel-body1">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">2</th>
                                            <td>Jacob</td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">3</th>
                                            <td>Larry</td>
                                            <td>the Bird</td>
                                            <td>@twitter</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>



                            <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
                                <div class="panel-body no-padding">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr class="warning">
                                                <th>#</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Username</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Mark</td>
                                                <td>Otto</td>
                                                <td>@mdo</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Jacob</td>
                                                <td>Thornton</td>
                                                <td>@fat</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Larry</td>
                                                <td>the Bird</td>
                                                <td>@twitter</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
                                <div class="panel-heading">
                                    <h2>Warning Table</h2>
                                    <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}"><span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span></div>
                                </div>
                                <div class="panel-body no-padding" style="display: block;">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr class="warning">
                                                <th>#</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Username</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Mark</td>
                                                <td>Otto</td>
                                                <td>@mdo</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Jacob</td>
                                                <td>Thornton</td>
                                                <td>@fat</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Larry</td>
                                                <td>the Bird</td>
                                                <td>@twitter</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="bs-example4" data-example-id="simple-responsive-table">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">2</th>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3</th>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div> /.table-responsive 
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">2</th>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3</th>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div> /.table-responsive -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--footer section start-->
            <%@include file='footer.jsp'%>
            <!--footer section end-->
        </section>
        <c:if test="${not (updateBook eq null or  updateBook.BIsbn eq null)  }" >
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#editDailog").modal('show');
                });
            </script>
            <jsp:setProperty name="updateBook" property="BIsbn" value="${null}"/>
        </c:if>

    </body>
</html>
