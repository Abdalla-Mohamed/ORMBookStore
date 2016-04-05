<%-- 
    Document   : categorymanage
    Created on : Mar 8, 2016, 7:15:20 AM
    Author     : Abdalla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<%@include file='head.jsp'%>
<%@page import="com.beans.Customer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="customer" scope="page" class="com.daos.Customer_Dao"/>

<body class="sticky-header left-side-collapsed"  onload="initMap()">
	<section>
		<!-- left side start-->
		<%@include file='left-side.jsp'%>
			<!-- left side end-->

			<!-- main content start-->
			<div class="main-content main-content4">
				<!-- header-starts -->
				<%@include file='header.jsp'%>
				<!-- //header-ends -->
				<div id="page-wrapper">
					<div class="graphs">
						<h3 class="blank1">Customer Table</h3>
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
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>id</th>
											<th>name</th> 
											<th>email</th>
											<th>mobile</th>
											<th>credit</th>							
										</tr>
									</thead>
									<tbody>
                                                                             <c:set var="count" value="0" scope="page" />
                                                                             <c:forEach  items="${customer.allCustomers}" var="row">
                                                                                     <c:set var="count" value="${count + 1}" scope="page"/>
										<tr class="active">
                                                                                
											<th scope="row"><c:out value="${count}"/></th>
											<td><c:out value="${row.getCId()}"/></td>
											<td><c:out value="${row.getCName()}"/></td>
											<td><c:out value="${row.getCEmail()}"/></td>
											<td><c:out value="${row.getCMobile()}"/></td>
											<td><c:out value="${row.getCCredit()}"/></td>
                                                                                 
										</tr>
										</c:forEach>
									</tbody>
								</table>
								<!--<button class="btn-success btn centerBtn">Add new Book</button>-->
								<!-- <a href="#" class="bt_green"><span class="bt_green_lft"></span><strong>Add new item</strong><span class="bt_green_r"></span></a> -->
							</div>
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