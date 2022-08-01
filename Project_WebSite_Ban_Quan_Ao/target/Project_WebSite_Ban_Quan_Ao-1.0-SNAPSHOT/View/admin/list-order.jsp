<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
		 pageEncoding="UTF-8"%>
<c:url value="/View/admin/Static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Order Management</title>
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
					<h2>Order Management</h2>


				</div>
			</div>
			<!-- /. ROW  -->
			<hr />

			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">Advanced Tables</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									   id="dataTables-example">
									<thead>
									<tr>
										<th>index</th>
										<th>ID</th>
										<th>Buyer</th>
										<th>Email</th>
										<th>Date</th>
										<%--<th>Product</th>
										<th>Quantity</th>
										<th>Price</th>--%>
										<th>Sum</th>
										<th>Status</th>
										<th>Action</th>


									</tr>
									</thead>
									<tbody>
									</a>
									<c:set var="index" value="${0}" />
									<c:forEach items="${listCart }" var="cart">
										<tr class="odd gradeX">
											<c:set var="index" value="${index + 1}" />
											<td>${index }</td>
											<td>${cart.id }</td>
											<td>${cart.userEntity.userName }</td>
											<td>${cart.userEntity.email }</td>
											<td>${cart.buyDate }</td>
											<%--<td>${list.product.name }</td>
											<td>${list.quantity }</td>
											<td>$ ${list.product.price }</td>--%>
											<td>
												<c:forEach var="item" items="${cart.getCartitemEntities()}">
													<c:set var="totalPrice"  value="${totalPrice+item.getQuantity() * item.getSkuEntity().getProductEntity().getPrice()}"></c:set>
												</c:forEach>
												${totalPrice} VNĐ
												<c:set var="totalPrice" value="${0}"></c:set>
											</td>
											<td class="center">
												<c:if test="${cart.status==0}">Đang xử lý</c:if>
												<c:if test="${cart.status==1}">Đã duyệt</c:if>
												<c:if test="${cart.status==2}">Đã nhận hàng </c:if>
											</td>


											<td>
												<a
														<%--href="<c:url value='/admin/order/edit?id=${list.id }'/>"--%>
														class="center" data-toggle="modal"  data-target="#oderlist${cart.id}">Detail</a> |
												<a
													href="<c:url value='/admin/order/update?id=${cart.id }'/>"
													class="center">Change</a> | <a
													href="<c:url value='/admin/order/delete?id=${cart.id }&type=admin'/>"
													class="center">Delete
											</a></td>

										</tr>
									</c:forEach>

									</tbody>
								</table>
							</div>

						</div>
					</div>
					<c:forEach items="${listCart}" var="cart">
						<div class="modal fade" id="oderlist${cart.id}">
							<div class="modal-dialog modal-dialog-centered modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Chi  tiết đơn hàng</h4>
									</div>
									<div class="modal-body">
										<table class="table table-condensed">
											<thead>

											<tr class="cart_menu">
												<td class="image">Ảnh</td>
												<td class="description">Tên Sản Phẩm</td>
												<td>Màu sắc</td>
												<td>Size</td>
												<td class="price">Giá</td>
												<td class="quantity">Số Lượng</td>
												<td class="total">Tổng Tiền</td>
											</tr>
											</thead>
											<tbody>
											<c:forEach items="${cart.getCartitemEntities()}" var="item">
												<c:url value="/image/${item.getSkuEntity().getProductEntity().getImage()}" var="imgUrl"></c:url>
												<tr>
													<td class="cart_product">
														<img width="45px" height="45px" src="${imgUrl}" alt="#">
													</td>
													<td class="description">${item.getSkuEntity().getProductEntity().getName()}</td>
													<td>${item.getSkuEntity().getColorEntity().getColorName()}</td>
													<td>${item.getSkuEntity().getSizeEntity().getSizeName()}</td>
													<td class="price">${item.getSkuEntity().getProductEntity().getPrice()}<span>VNĐ</span></td>
													<td class="quantity">${item.getQuantity()}</td>
													<td class="total">${item.getSkuEntity().getProductEntity().getPrice()*item.getQuantity()}<span>VNĐ</span></td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
										<button type="button" class="btn btn-success">OK</button>
									</div>
								</div>
							</div>
						</div> <!-- end modal -->
					</c:forEach>

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