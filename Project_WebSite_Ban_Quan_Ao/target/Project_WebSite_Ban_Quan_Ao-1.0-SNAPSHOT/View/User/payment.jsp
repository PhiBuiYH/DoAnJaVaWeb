<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 1/11/2021
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/View/User" var="url"></c:url>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh toán</title>
    <link href="${url}/Content/Site.css" rel="stylesheet" type="text/css" />
    <link href="${url}/Content/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="${url}/Scripts/modernizr-2.6.2.js"></script>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <link href="${url}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${url}/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${url}/Content/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${url}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${url}/Content/Site.css" rel="stylesheet" type="text/css" />
    <link href="${url}/Content/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script type="application/x-javascript">
        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //for-mobile-apps -->
    <link href="${url}/Content/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- Custom Theme files -->
    <link href="${url}/Content/css/style.css" rel='stylesheet' type='text/css' />
    <!-- js -->
    <script src="${url}/Content/js/jquery-1.11.1.min.js"></script>
    <!-- //js -->
    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="${url}/Content/js/move-top.js"></script>
    <script type="text/javascript" src="${url}/Content/js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({ scrollTop: $(this.hash).offset().top }, 1000);
            });
        });
    </script>
    <!-- start-smoth-scrolling -->
    <link href="${url}/Content/css/font-awesome.css" rel="stylesheet">
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Noto+Sans:400,700' rel='stylesheet' type='text/css'>
    <!--- start-rate---->
    <script src="${url}/Content/js/jstarbox.js"></script>
    <link rel="stylesheet" href="${url}/Content/css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
    <!---//End-rate---->
    <style>
        .cool-link {
            display: inline-block;
            color: #000;
            text-decoration: none;
        }

        .cool-link::after {
            content: '';
            display: block;
            width: 0;
            height: 2px;
            background: #000;
            transition: width .3s;
        }

        .cool-link:hover::after {
            width: 100%;
            /*transition: width .3s;*/
        }
    </style>

    <link href="${url}/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${url}/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${url}/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${url}/css/form.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pakhi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <!-- dropdown -->
    <script src="${url}/js/jquery.easydropdown.js"></script>
    <link href="${url}/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="${url}/js/hover_pack.js"></script>
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
<!-- header-section-starts -->
<div class="c-header" id="home">
    <jsp:include page="/View/User/Top-Header.jsp"></jsp:include>
</div>
<!-- start Dresses-page -->
<br/><br/><br/>

<div class="container">
    <div class="spec ">
        <h3 style="color: #eb5367">Thanh toán</h3>
    </div>
    <div class="row">
        <div id="center_column" class="center_column">
            <div class="row">
                <div id="left_column" class="column col-sm-12 col-md-12">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/payment" method="get">

                        <div class="col-sm-6 col-md-6">
                            <div class="detail_ct">
                                <legend>THÔNG TIN LIÊN HỆ</legend>
                                <div class="form-group">
                                    <label class="col-lg-4 control-label">Họ và tên *</label>
                                    <div class="col-lg-8">
                                        <input type="text" required name="fullname" placeholder="Hãy nhập tên của bạn..." class="form-control input-sm field" style="font-family:courier,arial,helvetica; font-weight: bold; width:300px;" value="${cartEntity.getCustomerEntity().getFullname()}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-4 control-label">Email *</label>
                                    <div class="col-lg-8">
                                        <input type="email" required placeholder="Hãy nhập email của bạn..." class="form-control input-sm field" name="c_email" style="font-family:courier,arial,helvetica; font-weight: bold; width:300px;" value="${cartEntity.getCustomerEntity().getEmail()}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-4 control-label">Số điện thoại *</label>
                                    <div class="col-lg-8">
                                        <input type="text" required class="form-control input-sm field" placeholder="Hãy nhập số điện thoại của bạn..." id="phone" name="phone" style="font-family:courier,arial,helvetica; font-weight: bold; width:300px;" value="${cartEntity.getCustomerEntity().getPhone()}">
                                    </div>
                                </div>
                                <legend>ĐỊA CHỈ GIAO HÀNG</legend>
                                <div class="form-group">
                                    <label class="col-lg-4 control-label">Địa chỉ *</label>
                                    <div class="col-lg-8">
                                        <textarea required class="form-control input-sm field"  placeholder="Vui lòng ghi địa chỉ chi tiết..." name="address" rows="5" style="font-family:courier,arial,helvetica; font-weight: bold; height:50px;">${cartEntity.getCustomerEntity().getAddress()}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-4 control-label">Ghi chú</label>
                                    <div class="col-lg-8">
                                        <textarea class="form-control input-sm field" placeholder="Thông tin thêm..." name="note" rows="5" style="font-family:courier,arial,helvetica; font-weight: bold; height:50px;"></textarea>
                                    </div>
                                </div>
                                <legend>PHƯƠNG THỨC THANH TOÁN</legend>
                                <div class="form-group">
                                    <label class="col-lg-4 control-label">Hình thức thanh toán</label>
                                    <div class="col-lg-8">
                                        <div>
                                            <input type="radio" id="online" name="optionPayment" value="online" checked >
                                            <label for="online" style="color: #696763">Trực tuyến</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="offline" name="optionPayment" value="offline" >
                                            <label for="offline" style="color: #696763">Trả khi nhận hàng</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> <div class="col-sm-6 col-md-6">
                        <div class="detail_ct" style="height:auto; min-height:inherit;">
                            <legend>GIỎ HÀNG CỦA BẠN</legend>
                            <table class="table" style="background:#FFF; font-size:18px;">
                                <thead>
                                <tr>
                                    <th>Hình</th>
                                    <th>Sản phẩm</th>
                                    <th>SL</th>
                                    <th>Đơn giá</th>
                                    <th>Thành tiền</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cartEntity.getCartitemEntities()}" var="cartItem" varStatus="loop">
                                <tr style="border-top:1px solid #999;">
                                    <td>
                                        <img src="${pageContext.request.contextPath}/image/${cartItem.getSkuEntity().getProductEntity().getImage()}" width="48">
                                    </td>
                                    <td>
                                        <strong>
                                                ${cartItem.getSkuEntity().getProductEntity().getName()}
                                        </strong>
                                    </td>

                                    <td>${cartItem.getQuantity() }</td>

                                    <td>${cartItem.getSkuEntity().getProductEntity().getPrice()} VNĐ</td>
                                    <td>${cartItem.getSkuEntity().getProductEntity().getPrice()*cartItem.getQuantity() } VNĐ</td>
                                </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td colspan="6">
                                        <a class="btn btn-default hidden-xs" style="float:right;" href="${pageContext.request.contextPath}/member/cart">Quay về</a>
                                        <div class="clr"></div>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                            <fieldset>
                                <legend>Tổng</legend>
                                <table class="table" style="background:#FFF; font-size:20px;">
                                    <tbody>
                                    <tr>
                                        <td align="left">Tổng tiền:</td>
                                        <td style="color:#eb5367;" align="right">${total} VNĐ</td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <td colspan="2">
                                            <input type="submit" style="width:100%; background-color: #eb5367" name="submit_step1_right" class="btn btn-primary" value="Đặt hàng">
                                        </td>
                                    </tr>
                                    </tfoot>
                                </table>
                            </fieldset>
                        </div>
                    </div> <div class="clr"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<br/><br/><br/><br/><br/><br/><br/>

<jsp:include page="/View/User/footer.jsp"></jsp:include>

</body>
</html>