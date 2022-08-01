<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<c:url value="/View/admin/Static" var="url"></c:url>
<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li class="text-center"><%--<img src="${url}/img/find_user.png"
										 class="user-image img-responsive" />--%></li>


			<li><a class="active-menu" href="${pageContext.request.contextPath }/admin"><i
					class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/product/list"><i class="fa fa-shopping-bag fa-3x"></i>
				Product Management</a></li>

			<li><a href="${pageContext.request.contextPath }/admin/user/list"><i class="fa fa-user-circle-o fa-3x"></i>
				USER Management</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/order/list"><i
					class="fa fa-shopping-cart fa-3x"></i> Order Management</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/category/list"><i class="fa fa-briefcase fa-3x"></i>
				Category Management</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/brand/list"><i
					class="fa fa-object-group fa-3x"></i> Brand management</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/color/list"><i
					class="fa fa-paint-brush fa-3x"></i> Color management</a></li>
			<li><a href="${pageContext.request.contextPath }/admin/size/list"><i
					class="fa fa-sort-numeric-asc fa-3x"></i> Size management</a></li>

			<li><a href="${pageContext.request.contextPath }/admin/contact/list"><i
					class="fa fa-fax fa-3x"></i> Contact Management</a></li>
			
		</ul>

	</div>

</nav>