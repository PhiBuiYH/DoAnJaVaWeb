<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
		 pageEncoding="UTF-8"%>
<c:url value="/View/admin/Static" var="url"></c:url>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Product Management</title>
	<!-- BOOTSTRAP STYLES-->
	<link href="${url}/css/bootstrap.css" rel="stylesheet" />
	<!-- FONTAWESOME STYLES-->
	<link href="${url}/css/font-awesome.css" rel="stylesheet" />
	<!-- MORRIS CHART STYLES-->

	<!-- CUSTOM STYLES-->
	<link href="${url}/css/custom.css" rel="stylesheet" />
	<!-- GOOGLE FONTS-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans'
		  rel='stylesheet' type='text/css' />
	<!-- TABLE STYLES-->
	<link href="${url}/js/dataTables/dataTables.bootstrap.css"
		  rel="stylesheet" />
</head>
<body>
<div id="wrapper">

	<jsp:include page="/View/admin/nav-bar.jsp"></jsp:include>

	<!-- /. NAV TOP  -->
	<jsp:include page="/View/admin/slide-bar.jsp"></jsp:include>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h2>All Product</h2>
					<h5>You can management product in here</h5>

				</div>
			</div>
			<!-- /. ROW  -->
			<hr />

			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<a href="<c:url value='/admin/product/add?'/>"
					   class="button">ADD</a>
					<div class="panel panel-default">
						<div class="panel-heading">Advanced Tables</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									   id="dataTables-example">
									<thead>
									<tr>
										<th>ID </th>
										<th>Image</th>
										<th>Name</th>
										<th>Price($)</th>
										<th>Category</th>
										<th>Brand</th>
										<th>Description</th>
										<th>Action </th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${proList}" var="pro" >
										<tr class="odd gradeX">
											<td>${pro.getId()}</td>
											<c:url value="/image/${pro.getImage()}" var="imgUrl"></c:url>
											<td><img height="150" width="200" src="${imgUrl}" /></td>

											<td>${pro.getName() }</td>
											<td>${pro.getPrice() }</td>
											<td>${pro.getCategoryEntity().getCateName()}</td>
											<td>${pro.getBrandEntity().getBrandName()}</td>
											<td style="width: 35%">${pro.getDes() } </td>
											<td><a
													href="<c:url value='/admin/sku/list?id=${pro.getId() }'/>"
													class="center">Option</a> | <a
													href="<c:url value='/admin/product/edit?id=${pro.getId() }'/>"
													class="center">Edit</a>
												| <a
														href="<c:url value='/admin/product/delete?id=${pro.getId() }'/>"
														class="center">Delete</a></td>

										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>

						</div>
					</div>
					<!--End Advanced Tables -->
				</div>
			</div>

		</div>

	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${url}/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${url}/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});
</script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>

</body>
</html>