<%-- 
    Document   : categorymanage
    Created on : Mar 8, 2016, 7:15:20 AM
    Author     : Abdalla
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.beans.ChargingCardList" %>
<jsp:useBean id="chargingCardList" scope="page" class="com.beans.ChargingCardList"/>    


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
           <%--    <%@include file='header.jsp'%>--%>
                <!-- //header-ends -->
                <div id="page-wrapper">
                    <div class="graphs">
                        <h3 class="blank1">Charge Cards Forms</h3>

                        <div class="col-md-5">
                            <!-- Horizontal Form -->
                            <div >

                                <form method="POST" action='../../ChargingCardController' class="form-horizontal col-sm-10 switch-right-grid" style="padding: 15px;padding-left:  0">
                                    <div class="box-body col-sm-12 " >
                                        Add Cards to Database:<br><br>
                                        <div class="form-group col-sm-12 " style="padding: 0px" >

                                            <label for="inputEmail3" class="col-sm-4 control-label">Card Value:</label>

                                            <div class="col-sm-8" >
                                                <div class=" input-group  col-sm-12" style="margin-left: 0em;width: 100%">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-usd"></i>
                                                    </span>
                                                    <select name="cardValue">
                                                        <option>5</option>
                                                        <option>10</option>
                                                        <option>25</option>
                                                        <option>50</option>
                                                        <option>100</option>
                                                        <option>200</option>
                                                    </select>
                                                   
                                                </div>
                                            </div>


                                        </div>

                                        <div class="form-group col-sm-12 " style="padding: 0px" >

                                            
                                            <label for="inputEmail3" class="col-sm-4 control-label">Count:</label>

                                            <div class="col-sm-8" >
                                                <div class=" input-group  col-sm-12" style="margin-left: 0em;width: 100%">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-clone"></i>
                                                    </span>
                                                    <select name="cardCount">
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                        <option>4</option>
                                                        <option>5</option>
                                                        <option>6</option>
                                                        <option>7</option>
                                                        <option>8</option>
                                                        <option>9</option>
                                                        <option>10</option>
                                                        

                                                    </select>
                                                </div>
                                            </div>


                                        </div>



                                    </div >
                                    <div class="col-sm-12 " >
                                        <button type="submit" class="btn btn-info pull-right">generate</button>

                                    </div>
                                </form>
                            </div>

                        </div>

                        <div class="bs-example4 col-md-6" data-example-id="contextual-table">
                            <div class="form-group">

                                <form action="#" method="GET">
                                    <div class="input-group input-group-ind">
<!--                                        <input type="text" name="search" class="form-control1 input-search" placeholder="Search...">
                                        <span class="input-group-btn">
                                            <button class="btn btn-success" type="submit"><i class="fa fa-search icon-ser"></i></button>
                                        </span>-->

                                    Card Numbers<br>
                                    </div><!-- Input Group -->
                                </form>
                                <div class="clearfix"> </div>
                            </div>
                            <table class="table table table-striped">
                                <thead class="alert alert-info">
                                    <tr >
                                        <th>Number</th>
                                        <th>price</th> 
                                        <th>Count</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <c:forEach items="${chargingCardList.amountList}" var="charge" varStatus="loopCounter">
                                    <tr >
                                        <th scope="row">${loopCounter.count}</th>
                                        <td><c:out value="${charge.getCardAmount()}"/></td>
                                        <td><c:out value="${charge.getCountAmount()}"/></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!--<button class="btn-success btn centerBtn">Add new Book</button>-->
                            <!-- <a href="#" class="bt_green"><span class="bt_green_lft"></span><strong>Add new item</strong><span class="bt_green_r"></span></a> -->
                        </div>

                    <div class="col-md-5">
                        <div >

                                <form method="POST" action='../../ChargingCardController' class="form-horizontal col-sm-10 switch-right-grid" style="padding: 15px;padding-left:  0">
                                    <div class="box-body col-sm-12 " >
                                        <div class="form-group col-sm-12 " style="padding: 0px" >

                                            Show your Card Numbers for selling:<br><br>
                                            <label for="inputEmail3" class="col-sm-4 control-label">Card Value:</label>

                                            <div class="col-sm-8" >
                                                <div class=" input-group  col-sm-12" style="margin-left: 0em;width: 100%">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-usd"></i>
                                                    </span>
                                                    <select name="selectCardValue">
                                                        <option>5</option>
                                                        <option>10</option>
                                                        <option>25</option>
                                                        <option>50</option>
                                                        <option>100</option>
                                                        <option>200</option>
                                                    </select>
                                                   
                                                </div>
                                            </div>


                                        </div>

                                        <div class="form-group col-sm-12 " style="padding: 0px" >

                                            <label for="inputEmail3" class="col-sm-4 control-label">Count:</label>

                                            <div class="col-sm-8" >
                                                <div class=" input-group  col-sm-12" style="margin-left: 0em;width: 100%">
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-clone"></i>
                                                    </span>
                                                    <select name="selectCardCount">
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                        <option>4</option>
                                                        <option>5</option>
                                                        <option>6</option>
                                                        <option>7</option>
                                                        <option>8</option>
                                                        <option>9</option>
                                                        <option>10</option>
                                                        

                                                    </select>
                                                </div>
                                            </div>


                                        </div>



                                    </div >
                                    <div class="col-sm-12 " >
                                        <button type="submit" class="btn btn-info pull-right">Select</button>

                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                        <div class="bs-example4 col-md-6" data-example-id="contextual-table">
                            <div class="form-group">

                                <form action="#" method="GET">
                                    <div class="input-group input-group-ind">
<!--                                        <span class="input-group-btn">
                                            <button class="btn btn-success" type="submit"><i class="fa fa-search icon-ser"></i></button>
                                        </span>-->

                                    Card Numbers<br>
                                    </div><!-- Input Group -->
                                </form>
                                <div class="clearfix"> </div>
                            </div>
                            <table class="table table table-striped">
                                <thead class="alert alert-info">
                                    <tr >
                                        <th>#</th>
                                        <th>Number</th>
                                        
                                
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <c:forEach items="${sessionScope.charger}" var="change" varStatus="loopCounter">
                                    <tr >
                                        <th scope="row">${loopCounter.count}</th>
                                        <td><c:out value="${change.getCardNumber()}"/></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!--<button class="btn-success btn centerBtn">Add new Book</button>-->
                            <!-- <a href="#" class="bt_green"><span class="bt_green_lft"></span><strong>Add new item</strong><span class="bt_green_r"></span></a> -->
                        </div>

                        
                    </div>

                </div>


            </div>            <!--footer section start-->
            <%@include file='footer.jsp'%>
            <!--footer section end-->
        </section>
    </body>
</html>