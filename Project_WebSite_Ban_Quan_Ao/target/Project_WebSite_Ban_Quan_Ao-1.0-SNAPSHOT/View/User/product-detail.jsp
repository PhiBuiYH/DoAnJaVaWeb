<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 12/15/2020
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<c:url value="/View/User" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Pakhi an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Single :: w3layouts</title>
    <link href="${url}/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${url}/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${url}/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${url}/css/form.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${url}/css/main.css" rel="stylesheet" type="text/css" media="all" />
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
<!-- header-section-starts -->
<div class="c-header" id="home">

</div>
<jsp:include page="/View/User/Top-Header.jsp"></jsp:include>
<!-- start-single-page -->
<!-- content -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li class="home">
                <a href="index.html" title="Go to Home Page"><img src="images/home.png" alt=""/></a>&nbsp;
                <span>&gt;</span>
            </li>
            <li>
                Sales
            </li>&nbsp;
            <span>&gt;</span>
            <li>products</li>
        </ul>
        <ul class="previous">
            <li><a href="index.html">Back to Previous Page</a></li>
        </ul>
        <div class="clearfix"></div>
    </div>
</div>
<c:url value="/image/${product.getImage()}" var="imgUrl"></c:url>
<!-- start content -->
<div class="women_main">
    <div class="container">

        <div class="row single">
            <div class="col-md-9 span-single">
                <div class="single_left">
                    <div class="grid images_3_of_2">
                        <ul id="etalage">

                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image" src="${imgUrl}" class="img-responsive" />
                                    <img class="etalage_source_image" src="${imgUrl}" class="img-responsive"
                                         title="" />
                                </a>
                            </li>
                            <li>
                                <img class="etalage_thumb_image" src="${imgUrl}" class="img-responsive"  />
                                <img class="etalage_source_image" src="${imgUrl}" class="img-responsive"  />
                            </li>

                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="desc1 span_3_of_2">
                        <h3>${product.getName() }</h3>
                        <p>${product.getPrice() }
                        <form action="${pageContext.request.contextPath}/member/cart/add" method="get">
                        <select name="pId" hidden>
                            <option value="${product.getId()}"></option>
                        </select>
                        <div class="det_nav">
                            <div class="product-configuration">
                                <!-- Cable Configuration -->
                                <div class="cable-config">
                                    <span>Màu</span>
                                    <div class="cable-choose">
                                        <select name="color" style="width: 50%">
                                            <c:forEach items="${listColor}" var="sku" >
                                                <option  value="${sku}"><c:out value="${sku}"/> </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="product-configuration">
                                <!-- Cable Configuration -->
                                <div class="cable-config">
                                    <span>Size</span>
                                    <div class="cable-choose">
                                        <select name="size" style="width: 50%">
                                            <c:forEach items="${listSize}" var="sku" >
                                                <option  name="btnsize"  value="${sku}"><c:out value="${sku}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                            </div>
                        <div class="cart_quantity">
                            <label for="quantity">Số lượng:</label>
                            <input type="number" id="quantity" name="quantity" min="1" max="${maxquantity}" value="1"/>
                        </div>
                        <br/>
                        </div>

                        <div class="btn_form" style="width: 50%">
                            <input type="submit" style="font-weight: 500; color: #ffff; text-transform: uppercase; background-image: initial;
                            background-position-x: initial;
                            background-position-y: initial;
                            background-size: initial;
                            background-repeat-x: initial;
                            background-repeat-y: initial;
                            background-attachment: initial;
                            background-origin: initial;
                            background-clip: initial;
                            background-color: rgb(235, 83, 103);" value="Thêm vào giỏ">
                <!--            <a href="${pageContext.request.contextPath}/member/cart/add?pId=${product.getId() }">add to bag</a>
                        </div>
                        <div class="btn_form" style="width: 50%">
                            <a href="${pageContext.request.contextPath}/member/cart/add?pId=${product.getId() }">buy now</a> -->
                        </div>

                    </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="single-bottom1">
                    <h6>Details</h6>
                    <p class="prod-desc">${product.getDes() }</p>
                </div>
                <div class="single-bottom2">
                    <div class="det_nav">
                        <h4>related products :</h4>
                        <ul>
                            <c:forEach items="${RelateProductList}" var="pro">
                                <c:url value="/image/${pro.getImage()}" var="imgUrlrelate"></c:url>
                                <li><a href="<c:url value='/product/detail?id=${pro.id }'/>">
                                    <img style="height: 150px; width: 150px" src="${imgUrlrelate}" class="img-responsive" alt=""/></a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <jsp:include page="/View/User/Search_right.jsp"></jsp:include>
        </div></div></div>
<!-- end content -->
<!-- content-section-ends -->
<jsp:include page="/View/User/footer.jsp"></jsp:include>
</body>
</html>