<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 12/27/2020
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/View/User" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Pakhi an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Contact :: w3layouts</title>
    <link href="${url}css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${url}js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${url}css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pakhi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <!-- dropdown -->
    <script src="${url}js/jquery.easydropdown.js"></script>
    <link href="css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/hover_pack.js"></script>
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
<%--<!-- header-section-starts -->
<div class="c-header" id="home">
    <div class="top-header">
        <div class="container">
            <div class="logo">
                <a href="index.html"><img src="images/logo.png" alt="" /></a>
            </div>
            <div class="header-top-right">
                <!-- start search-->
                <div class="search-box">
                    <div id="sb-search" class="sb-search">
                        <form>
                            <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                            <input class="sb-search-submit" type="submit" value="">
                            <span class="sb-icon-search"> </span>
                        </form>
                    </div>
                </div>
                <!-- search-scripts -->
                <script src="js/classie.js"></script>
                <script src="js/uisearch.js"></script>
                <script>
                    new UISearch( document.getElementById( 'sb-search' ) );
                </script>
                <!-- //search-scripts -->

                <a href="cart.html"><i class="cart"></i></a>
            </div>
            <div class="navigation">
                <div>
                    <label class="mobile_menu" for="mobile_menu">
                        <span>Menu</span>
                    </label>
                    <input id="mobile_menu" type="checkbox">
                    <ul class="nav">
                        <li class="active"><a href="index.html">Home</a></li>
                        <li class="dropdown1"><a href="#">Dresses</a>
                            <ul class="dropdown2">
                                <li><a href="products.html">Dress Materials</a></li>
                                <li><a href="products.html">Kurta & Kurti</a></li>
                                <li><a href="products.html">Sarees</a></li>
                                <li><a href="products.html">Chudidars</a></li>
                            </ul>
                        </li>
                        <li class="dropdown1"><a href="#">Bags</a>
                            <ul class="dropdown2">
                                <li><a href="products.html">Latest</a></li>
                                <li><a href="products.html">Leather Bags</a></li>
                                <li><a href="products.html">Hand Bags</a></li>
                            </ul>
                        </li>
                        </li>
                        <li class="dropdown1"><a href="#">Shoes</a>
                            <ul class="dropdown2">
                                <li><a href="products.html">Sports Shoes</a></li>
                                <li><a href="products.html">Casual Shoes</a></li>
                                <li><a href="products.html">Formal Shoes</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">Contact US</a></li>
                        <div class="clearfix"></div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>--%>
<!-- start Contact-page -->
<!-- content-section-starts -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li class="home">
                <a href="index.html" title="Go to Home Page"><img src="images/home.png" alt=""/></a>&nbsp;
                <span>&gt;</span>
            </li>
            <li>
                Contact
            </li>
        </ul>
        <ul class="previous">
            <li><a href="index.html">Back to Previous Page</a></li>
        </ul>
        <div class="clearfix"></div>
    </div>
</div>

<div class="container">
    <div class="contact">
        <div class="contact_info">
            <h2>get in touch</h2>
            <div class="contact-map">
                <iframe width="100%" height="250" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                            src="https://goo.gl/maps/JgjT9idEFpthAR4D9<%--https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;
                            hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;
                            aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;
                            sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;
                            hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;
                            t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed--%>"></iframe><br><small>

                        <a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;
                        geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;
                        sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;
                        hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;
                        ll=26.275636,-80.087265" style="color:#777777;text-align:left;font-size:13px;">View Larger Map</a></small>
            </div>
        </div>
        <div class="contact-form">
            <h2>Contact Us</h2>
<%--            <c:url value="" var="contactURL"></c:url>--%>
            <form method="post" action="${pageContext.request.contextPath}/contactController">
                <div>
                    <span><label>Name</label></span>
                    <span><input id="name" name="userName" type="text" class="textbox"></span>
                </div>
                <div>
                    <span><label>E-mail</label></span>
                    <span><input name="userEmail" type="text" class="textbox"></span>
                </div>
                <div>
                    <span><label>Mobile</label></span>
                    <span><input name="userPhone" type="text" class="textbox"></span>
                </div>
                <div>
                    <span><label>Subject</label></span>
                    <span><textarea id="subj" name="userMsg"> </textarea></span>
                </div>
                <div>
                    <label style="color: green">${infoMsg}</label>
                    <span><input type="submit" class="" value="Submit us"></span>
                </div>
            </form>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

<!-- content-section-ends -->

<jsp:include page="/View/User/footer.jsp"></jsp:include>
</body>
</html>