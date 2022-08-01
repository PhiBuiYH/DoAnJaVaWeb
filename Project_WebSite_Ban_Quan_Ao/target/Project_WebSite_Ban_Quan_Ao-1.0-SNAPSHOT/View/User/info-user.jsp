<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/View/User" var="url"></c:url>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Quản lí tài khoản</title>

	<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.css">
	<!-- put first the jquery path, otherwise the bootstrap.js won't work-->
	<script src="js/jquery/jquery-3.1.0.js"></script>
	<script src="plugins/bootstrap/js/bootstrap.min.js"></script>


	<link href="${url}/css/bootstrap.css" rel='stylesheet' <%--type='text/css'--%> />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${url}/js/jquery.min.js"></script>
	<!-- Custom Theme files -->
	<link href="${url}/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${url}/css/form.css" rel="stylesheet" <%--type="text/css"--%> media="all" />

	<link href="${url}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${url}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${url}/css/main.css" rel="stylesheet">
	<link href="${url}/css/responsive.css" rel="stylesheet">
	<!-- Custom Theme files -->

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--webfont-->
	<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
	<!-- dropdown -->
	<script src="${url}/js/jquery.easydropdown.js"></script>
	<link href="${url}/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
	<script type="text/javascript" src="${url}/js/hover_pack.js"></script>
	<link rel="stylesheet" href="${url}/css/etalage.css">
	<script src="${url}/js/jquery.etalage.min.js"></script>
	<script>
		jQuery(document).ready(function($){

			$('#etalage').etalage({
				thumb_image_width: 300,
				thumb_image_height: 400,
				source_image_width: 800,
				source_image_height: 1000,
				show_hint: true,
				click_callback: function(image_anchor, instance_id){
					alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
				}
			});

		});
	</script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
</head>

<body>
<div class="c-header" id="home">
	<jsp:include page="/View/User/Top-Header.jsp"></jsp:include>
</div>

<section id="cart_items">
	<div class="container">
		<div class="step-one">
			<h2 class="heading">Quản lí toàn khoản</h2>
		</div>
		<div class="shopper-informations">
			<div class="row">
				<div class="col-sm-6">
					<div class="shopper-info">
						<p>Thông tin tài khoản</p>
						<form action="${pageContext.request.contextPath }/infoController?type=changeInfo" method="post">
							<input readonly name="email"  placeholder="Email" value="${user.getEmail()}">
							<input name="name"  placeholder="Tên" value="${user.getUserName()}">

							<input name="address"  placeholder="Địa chỉ" value="${user.getAddress()}">
							<input name="phonenumber" type="text" placeholder="Số điện thoại" value="${user.getPhone()}">
							<label style="display: block">${msg}</label>
							<button style="width: 150px; height: 30px;color: white; background-color: #ff0000; " type="submit" value="Cập nhật thông tin">Cập nhật thông tin</button>
						</form>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="shopper-info">
						<p>Thay đổi mật khẩu</p>
						<form action="${pageContext.request.contextPath }/infoController?type=changePassword" method="post">
							<label for="oldPassword"></label><input name="oldPassword"  id="oldPassword" type="password" placeholder="Mật khẩu " value="">
							<input name="newPassword" id="newPassword" type="password" placeholder="Mật khẩu mới">
							<input name="confirmPassword" id="confirmPassword" type="password" placeholder="Xác nhận mật khẩu">
							<label style="display: block" >${msgPass}</label>
							<button style="width: 150px; height: 30px;color: white; background-color: #ff0000; " type="submit" value="Đổi mật khẩu">Đổi mật khẩu</button>
						</form>
						<%--						<a class="btn btn-primary" onclick="changePassword()" href="">Đổi mật khẩu</a>--%>
					</div>
				</div>
			</div>
		</div>
		<div class="review-payment">
			<h2>Lịch sử mua hàng</h2>
		</div>

		<div class="table-responsive cart_info">
			<table class="table table-condensed">
				<thead>
				<tr class="cart_menu">
					<td class="image">ID đơn hàng</td>
					<td class="description">Tình trạng</td>
					<td class="price">Ngày mua</td>
					<td class="quantity">Tổng thanh toán</td>
					<td class="total">Action</td>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="cart" items="${carts}">

					<tr>
						<td class="cart_product">
							<h4>#${cart.id}</h4>
						</td>
						<td class="cart_description">
							<h4>
								<c:if test="${cart.status==0}">Đang xử lý</c:if>
								<c:if test="${cart.status==1}">Đã duyệt</c:if>
								<c:if test="${cart.status==2}">Đã nhận hàng </c:if>
							</h4>
						</td>
						<td class="cart_description">
							<h4>${cart.buyDate}</h4>
						</td>
						<td class="cart_description">
<%--							<c:url var="totalPrice"></c:url>--%>

							<c:forEach var="item" items="${cart.getCartitemEntities()}">
								<c:set var="totalPrice"  value="${totalPrice+item.getQuantity() * item.getSkuEntity().getProductEntity().getPrice()}"></c:set>
							</c:forEach>
							<h4> ${totalPrice} VNĐ</h4>
							<c:set var="totalPrice" value="${0}"></c:set>
						</td>
						<td>
							<a class="center" data-toggle="modal"  data-target="#oderlist${cart.id}">Xem Chi Tiết</a> |
							<a	href="<c:url value='/admin/order/delete?id=${cart.id }&type=user'/>"	class="center">Delete	</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>


	</div>


	<%--	<jsp:include page="footer.jsp"></jsp:include>--%>
</section> <!--/#cart_items-->

<jsp:include page="/View/User/footer.jsp"></jsp:include>

<%--<script>
	$("[data-toggle='modal']").modal();
</script>--%>
<c:forEach items="${carts}" var="cart">
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

<script src="${url}/js/jquery.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.scrollUp.min.js"></script>
<script src="${url}/js/jquery.prettyPhoto.js"></script>
<script src="${url}/js/main.js"></script>
<%--------------------------%>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%--------------------------------%>
<script>
	function changePassword() {
		var oldPassword =$('#oldPassword').val();
		var newPassword =$('#newPassword').val();
		var confirmPassword =$('#confirmPassword').val();
		var data ={
			oldPassword:oldPassword,
			password:newPassword,
			confirmation_pwd:confirmPassword
		}
		console.log(data)
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
			enctype: 'multipart/form-data',
			processData:false,
			contentType: 'application/json',
			data:JSON.stringify(data),
			dataType: 'json',
			success: function (result){
				console.log("Success");
			},
			errMode: function (error){
				console.log("Error");
			}

		})

	}
</script>

</body>
</html>
