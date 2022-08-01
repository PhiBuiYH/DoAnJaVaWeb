<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/View/User" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Pakhi an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Products :: w3layouts</title>
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
<!-- content-section-starts -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li class="home">
                <a href="index.html" title="Go to Home Page"><img src="${url}/images/home.png" alt=""/></a>&nbsp;
                <span>&gt;</span>
            </li>
            <li>
                Dresses
                <span>&gt;</span>
            </li><li>
            <span class="red">&nbsp;Clothes&nbsp;</span>
        </li>
        </ul>
        <ul class="previous">
            <li><a href="index.html">Back to Previous Page</a></li>
        </ul>
        <div class="clearfix"></div>
    </div>
</div>
<div class="container">
    <div class="ft-ball">
        <div class="cont span_2_of_3">
            <div class="mens-toolbar">
                <div class="sort">
                    <div class="sort-by">
                        <label>Sort By</label>
                        <select>
                            <option value="">
                                Popularity               </option>
                            <option value="">
                                Price : High to Low               </option>
                            <option value="">
                                Price : Low to High               </option>
                        </select>
                        <a href=""><img src="${url}/images/arrow2.gif" alt="" class="v-middle"></a>
                    </div>
                </div>
                <div class="pager">
                    <div class="limiter visible-desktop">
                        <label>Show</label>
                        <select>
                            <option value="" selected="selected">
                                9                </option>
                            <option value="">
                                15                </option>
                            <option value="">
                                30                </option>
                        </select> per page
                    </div>
                    <ul class="dc_pagination dc_paginationA dc_paginationA06">
                        <li><a href="#" class="previous">Pages</a></li>
                        <c:forEach var = "i" begin = "1" end = "${numOfPages}">
                            <li><a href="<c:url value='/product/category?cate_id=${cate_id}&page=${i}'/>">${i}</a></li>
                        </c:forEach>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>

            <c:forEach items="${productList}" var="pro">
                <div class="box1">
                    <div class="col_1_of_single1 span_1_of_single1">
                        <div class="view1 view-fifth1">
                            <div class="top_box">
                                <h3 class="m_1">${pro.getName() }</h3>
                                <p class="m_2">${pro.getCategoryEntity().getCateName()}</p>
                                <a href="<c:url value='/product/detail?id=${pro.id }'/>">
                                    <div class="grid_img">
                                        <c:url value="/image/${pro.getImage()}" var="imgUrl"></c:url>
                                        <div class="css3"><img height="250" width="200" src="${imgUrl}" alt=""/></div>
                                        <div class="mask1">
                                            <div class="info">Quick View</div>
                                        </div>
                                    </div>
                                    <div class="price">${pro.getPrice() }</div>
                                </a>
                            </div>
                        </div>
                        <ul class="list2">
                            <li>
                                <img src="${url}/images/plus.png" alt=""/>
                                <ul class="icon1 sub-icon1 profile_img">
                                    <li><a class="active-icon c1" href="${pageContext.request.contextPath }/member/cart/add?pId=${pro.getId() }">Add To Bag </a>
                                        <ul class="sub-icon1 list">
                                            <li><h3>Decription</h3><a href=""></a></li>
                                            <li><p>${pro.getDes() }<a href=""></a></p></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <jsp:include page="/View/User/Search_right.jsp"></jsp:include>
        <div class="clearfix"></div>
    </div>
</div>
<!-- content-section-ends -->
<jsp:include page="/View/User/footer.jsp"></jsp:include>
</body>
</html>