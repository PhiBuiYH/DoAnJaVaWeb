<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/View/User" var="url"></c:url>
<c:url value="/contactController" var="CCUrl"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Pakhi an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Home :: w3layouts</title>
    <link href="${url}/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${url}/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${url}/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${url}/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- dropdown -->
    <script src="js/jquery.easydropdown.js"></script>

    <script src="js/scripts.js" type="text/javascript"></script>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>

</head>
<body>
<!-- header-section-starts -->
<div class="header" id="home">
    <jsp:include page="/View/User/Top-Header.jsp"></jsp:include>
    <div class="banner">
        <div class="signing text-right">
            <div class="container">
                <div class="sign-in">
                    <c:choose>
                        <c:when test="${not empty email}">
                            <a href="">${user}</a>

                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath }/User/signin">Sign In</a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="sign-up1">
                    <c:choose>
                        <c:when test="${not empty email}">
                            <a href="${pageContext.request.contextPath }/User/signout">Sign Out</a>

                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath }/User/signup">Sign Up</a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="banner-info text-center">
            <i class="shipping"></i>
            <h3>Shopping Place For Girls</h3>
            <p></p>
            <a href="${pageContext.request.contextPath }/user/product/list?page=1">All Products</a>
        </div>
    </div>
</div>
<div class="content">
    <div class="features-section" >
        <div class="features-section-head text-center">
            <h3><span>S</span>ản phẩm nổi nật</h3>
            <p>“Sản phẩm của tuần”</p>
        </div>
        <div class="features-section-grids" >
            <div class="features-section-grid" style=";width:50%;left: 25%;" >
                <c:url value="/image/${allproduct.get(0).getImage()}" var="imgUrl1"></c:url>
                <img src="${imgUrl1}" alt="" style="height: 650px"/>
                <div class="girl-info" style="height: 200px">
                    <div class="lonovo">
                        <div class="dress" style="width: 500px">
                            <h4>${allproduct.get(0).getName()}</h4>
                            <p>${allproduct.get(0).getDes()}</p>
                        </div>
                        <div class="priceindollers">
                            <h3><a style="text-decoration: underline black">đ</a> <span>${allproduct.get(0).getPrice() }</span></h3>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="products-section">
            <div class="products-section-head text-center">
                <h3><span>P</span>roducts</h3>
                <p>“check out our products”</p>
            </div>
            <div class="products-section-grids">
                <ul id="filters" class="clearfix">
                    <li><span class="filter active" data-filter="app card icon web" onclick="window.location='${pageContext.request.contextPath }/Home'">ALL</span></li>
                    <li><span class="filter" data-filter="app" onclick="window.location='${pageContext.request.contextPath }/Home?cateid=giày'">Giày</span></li>
                    <li><span class="filter" data-filter="app" onclick="window.location='${pageContext.request.contextPath }/Home?cateid=quần'">Quần </span></li>
                    <li><span class="filter" data-filter="app" onclick="window.location='${pageContext.request.contextPath }/Home?cateid=áo'">áo</span></li>

                </ul>
                <div id="portfoliolist">
                    <%-- ///////////////////////////////////////--%>
                    <c:forEach items="${productList}" var="pro">
                        <c:url value="/image/${pro.getImage()}" var="imgUrl"></c:url>
                        <div class="portfolio card mix_all"  data-cat="card" style=" position:relative;height: 550px; display: inline-block; opacity: 1;">
                            <div class="portfolio-wrapper">
                                <a href="<c:url value='/product/detail?id=${pro.id }'/>" class="b-link-stripe b-animate-go  thickbox">
                                    <img style="height: 350px ;width: 280px" src="${imgUrl}" class="img-responsive" alt="" />
                                    <div class="b-wrapper">
                                        <div class="atc"><p>View Detail</p>
                                        </div><div class="clearfix">
                                    </div><h2 class="b-animate b-from-left    b-delay03 ">
                                        <img src="${imgUrl}" class="img-responsive go" alt=""/></h2>
                                    </div></a>
                                <div class="title" style="position: relative; ">
                                    <div class="colors">
                                        <h4>${pro.getName() }</h4>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>
                            </div>

                            <div style="position: absolute; bottom: 0px">
                                <h3><span><a style="text-decoration: underline black">đ</a></span>${pro.getPrice() }</h3>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
                <div class="more">
                    <div class="seemore">
                        <a href="${pageContext.request.contextPath }/user/product/list?page=1">See More</a>
                    </div>

                    <div class="clearfix"></div>
                </div>
            </div>
            <!-- script-for-portfolio -->
            <script type="text/javascript">
                jQuery(document).ready(function($) {
                    $(".scroll").click(function(event){
                        event.preventDefault();
                        $('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
                    });
                });
            </script>

            <script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
            <script type="text/javascript">
                $(function () {

                    var filterList = {

                        init: function () {

                            // MixItUp plugin
                            // http://mixitup.io
                            $('#portfoliolist').mixitup({
                                targetSelector: '.portfolio',
                                filterSelector: '.filter',
                                effects: ['fade'],
                                easing: 'snap',
                                // call the hover effect
                                onMixEnd: filterList.hoverEffect()
                            });

                        },
                        hoverEffect: function () {
                            $('#portfoliolist .portfolio').hover(
                                function () {
                                    $(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
                                    $(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');
                                },
                                function () {
                                    $(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
                                    $(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');
                                }
                            );

                        }

                    };

                    // Run the show!
                    filterList.init();
                });
            </script>


        </div>
    </div>
    <div class="container">

    </div>
    <div class="container">
    </div>
    <div class="contact-section">
        <div class="contact-section-head text-center">
            <h3><span>C</span>ontact Us</h3>
            <p>“let us know your feedbacks and questions”</p>
        </div>
        <div class="contact-form-main">
            <form action="${CCUrl}" method="post">
                <label class="span1"></label>
                <input name="userName" type="text" class="text" value="Name..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name...';}">
                <label class="span2"></label>
                <label class="span3"></label>
                <input name="userEmail" type="text" class="text" value="Email..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email...';}">
                <label class="span4"></label>
                <label class="span5"></label>
                <input name="userPhone" type="text" class="text" value="Phone..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Phone...';}">
                <label class="span6"></label>
                <label class="span7"></label>
                <textarea name="userMsg" onfocus="if(this.value == 'Message...') this.value='';" onblur="if(this.value == '') this.value='Your Message';" >Message...</textarea>
                <label class="span8"></label>
                <input type="submit" value="">
            </form>
        </div>

    </div>
</div>
<jsp:include page="/View/User/footer.jsp"></jsp:include>
</body>
</html>
