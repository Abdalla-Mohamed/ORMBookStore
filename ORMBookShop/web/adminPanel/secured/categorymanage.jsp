<%-- 
    Document   : categorymanage
    Created on : Mar 8, 2016, 7:15:20 AM
    Author     : Abdalla
--%>
<%@page import="com.helpclasses.CategoryNames"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="category" scope="page" class="com.helpclasses.CategoryNames"/>
<%--<jsp:useBean id="books" scope="session" class="com.helpclasses.BookLists"/>--%>

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
         <%--       <%@include file='header.jsp'%>--%>
                <!-- //header-ends -->
                <div id="page-wrapper">
                    <div class="graphs">
                        <h3 class="blank1">Categories Forms</h3>

                        <div class="col-md-5">

                            <form class="form-horizontal col-sm-12 switch-right-grid" style="padding: 15px;padding-left:  0" action="/OnlineBookShop/CategoryControllrer" method="post">
                                <div class="box-body col-sm-12 " >
                                    <div class="form-group col-sm-12 " style="padding: 0px" >

                                        <label for="inputEmail3" class="col-sm-4 control-label">category name:</label>

                                        <div class="col-sm-8" >
                                            <div class=" input-group  col-sm-12" style="margin-left: 0em;width: 100%">
                                                <span class="input-group-addon">
                                                    <i class="fa fa-tag"></i>
                                                </span>
                                                <input id="newCatName" name="catName" class="form-control1"  type="text" placeholder="category name">
                                            </div>
                                        </div>


                                    </div>




                                </div >
                                <div class="col-sm-11 " >
                                    <button type="submit" class="btn btn-info pull-right">New Category</button>

                                </div>
                            </form>

                        </div>


                        <div class="col-md-1">
                        </div>                            
                        <div class="col-md-5">


                            <form action="../../DeleteCategory" method="post" class="form-horizontal col-sm-12 switch-right-grid" style="padding: 15px;padding-left:  10">
                                <div class="box-body col-sm-12 " >
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label" for="selector1">Categories</label>
                                        <div class="col-sm-9">
                                            <select class="form-control1"  id="deleteCatName" name="deleteCatById">
                                                <option value="0">select category to remove:</option>
                                                <c:forEach  items="${category.categories}" var="row">
                                                    <option value="<c:out value="${row.getCatId()}"/>"><c:out value="${row.getCatName()}"/></option>
                                                </c:forEach>

                                            </select>
                                        </div>
                                    </div>
                                </div >
                                <div class="col-sm-11 " >
                                    <button type="submit" class="btn btn-info pull-right">Delete Category</button>

                                </div>
                            </form>

                        </div>


                        <div class="col-md-12">
                            <br>

                            <form class="form-horizontal col-sm-12 switch-right-grid" style="padding: 15px;padding-left:  0" action="../../AddBookToCat" method="POST">
                                <div class="box-body col-sm-12 " >
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="selector1">categories</label>
                                        <div class="col-sm-9">


                                            <select class="form-control1"  id="deleteCatName" name="catId">
                                                <option value="0">select category :</option>
                                                <c:forEach  items="${category.categories}" var="row">
                                                    <option value="<c:out value="${row.getCatId()}"/>"><c:out value="${row.getCatName()}"/></option>
                                                </c:forEach>
                                            </select>

                                        </div>
                                    </div>
                                </div >

                                <div class="col-sm-5 " >

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Books</label>
                                        <div class="col-sm-9">
                                            <select class="form-control1" multiple="" name="bookId">
                                                <c:set var="id" value="${sessionScope.catN2}"/>
                                                <c:forEach  items="${books.booksWithNoCategory}" var="row">
                                                    <option value="
                                                            <c:out value="${row.getBIsbn()}"/>"><c:out value="${row.getBName()}"/>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                </div>


                                <div class="col-sm-11 " >
                                    <button type="submit" class="btn btn-info pull-right">Add Book</button>

                                </div>
                            </form>

                        </div>

                        <div class="col-md-12">
                            <br>

                            <form class="form-horizontal col-sm-12 switch-right-grid" style="padding: 15px;padding-left:  0" action="../../DeleteBookFromCat" method="POST">
                                <div class="box-body col-sm-12 " >
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="selector1">categories</label>
                                        <div class="col-sm-9">


                                            <select class="form-control1"  id="deleteCatName" name="catNo3" onchange="this.form.submit()">
                                                <option value="0">select category :</option>
                                                <c:forEach  items="${category.categories}" var="row">
                                                    <option value="<c:out value="${row.getCatId()}"/>"><c:out value="${row.getCatName()}"/></option>
                                                </c:forEach>
                                            </select>

                                        </div>
                                    </div>
                                </div >

                                <div class="col-sm-5 " >

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Books</label>
                                        <div class="col-sm-9">
                                            <select class="form-control1" multiple="" name="bookId">
                                                <c:set var="id" value="${sessionScope.catN3}"/>
                                                <c:forEach  items="${books.getBooksByCategory(id)}" var="row">
                                                    <option value="
                                                            <c:out value="${row.getBIsbn()}"/>"><c:out value="${row.getBName()}"/>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                </div>


                                <div class="col-sm-11 " >
                                    <button type="submit" class="btn btn-info pull-right" id="delB" >delete book</button>

                                </div>
                            </form>

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