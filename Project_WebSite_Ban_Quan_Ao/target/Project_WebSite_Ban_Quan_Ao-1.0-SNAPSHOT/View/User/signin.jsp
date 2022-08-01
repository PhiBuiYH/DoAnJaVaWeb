<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/View/User" var="url"></c:url>
<c:url value="/User/forgot" var="APIurl"></c:url>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pakhi an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Signin :: w3layouts</title>
    <link href="${url}/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${url}/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${url}/css/style.css" rel="stylesheet" type="text/css" media="all" />
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
<jsp:include page="/View/User/Top-Header.jsp"></jsp:include>
<!-- start login -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li class="home">
                <a href="index.html" title="Go to Home Page"><img src="${url}/images/home.png" alt=""/></a>&nbsp;
                <span>&gt;</span>
            </li>
            <li>
                Signup
            </li>&nbsp;

        </ul>
        <ul class="previous">
            <li><a href="index.html">Back to Previous Page</a></li>
        </ul>
        <div class="clearfix"></div>
    </div>
</div>

<section id="main">
    <div class="login-content">
        <div class="container">
            <div class="login-signup-form">
                <div class="col-md-5 login text-center">
                <form role="form" action="signin" method="post"
                      enctype="multipart/form-data">

                        <h4>login</h4>
                        <br>
                        <br>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Email:
                                <span class="require">*</span>
                            </label>
                            <input type="text" value="" placeholder="Please enter email" name = "email">
                        </div>
                        <div class="clearfix"></div>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Password:
                                <span class="require">*</span>
                            </label>
                            <input type="password" value="" placeholder="Please enter password" name = "password">
                        </div>
                        <div class="clearfix"></div>
                        <div class="sky-form span_99">
                            <label class="checkbox"><input type="checkbox" name="checkbox" >Remember me on this computer </label>
                        </div>
                        <c:if test = "${not empty SignInErr}">
                            <div class = "require">
                                    ${SignInErr}
                            </div>
                        </c:if>
                        <div class="botton1">
                            <input type="submit" value="SIGNIN" class="botton">
                        </div>

                </form>
                <form action="${APIurl}" method="get">
                    <div class="forgetit">
                        <a href="">forgot your password?</a>
                        <input id="emailReset" name="emailReset" type="text" class="text">
                        <%--                            <input id="emailReset" name="emailReset" type="text" class="text" &lt;%&ndash;value="Enter email to reset it" &ndash;%&gt;onfocus="this.value = '';" onblur="if (this.value == 'Enter email to reset it') {this.value = 'Enter email to reset it';}">--%>
                        <input type="submit" value="Submit"  class="botton">
                        <label >${msg}</label>
                    </div>
                </form>
                </div>
                <form role="form" action="signup" method="post"
                      enctype="multipart/form-data">
                    <div class="col-md-5 sign-up text-center">
                        <h4>signup</h4>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Email Id:
                                <span class="require">*</span>
                            </label>
                            <input type="text" value="${email}" placeholder="Please enter email" name = "email">
                        </div>
                        <div class="clearfix"></div>
                        <%--////////////////--%>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                User name:
                                <span class="require">*</span>
                            </label>
                            <input type="text" value="${username}" placeholder="Please enter Username" name = "username">
                        </div>
                        <div class="clearfix"></div>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Phone:
                                <span class="require">*</span>
                            </label>
                            <input type="text" value="${phone}" placeholder="Please enter phone" name = "phone">
                        </div>
                        <div class="clearfix"></div>

                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Address:
                                <span class="require">*</span>
                            </label>
                            <input type="text" value="${address}" placeholder="Please enter address" name = "address">
                        </div>
                        <div class="clearfix"></div>
                        <%--/////////////////////////--%>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Password:
                                <span class="require">*</span>
                            </label>
                            <input type="password" value="" placeholder="Please enter password" name = "password">
                        </div>
                        <div class="clearfix"></div><div class="cus_info_wrap">

                        <label class="labelTop confirmpass">
                            Conform Password:
                            <span class="require">*</span>
                        </label>
                        <input type="password" value="" placeholder="Confirm your password" name = "cfpassword">
                    </div>
                        <c:if test = "${not empty SignUpErr}">
                            <div class = "require">
                                    ${SignUpErr}
                            </div>
                        </c:if>

                        <div class="botton1">
                            <input type="submit" value="SIGNUP" class="botton">
                        </div>
                        <c:if test="${not empty success}">
                            <p>${success}</p>
                        </c:if>
                    </div>
                </form>

                <%--                <% String passError = request.getParameter("passError");--%>
                <%--                    if(passError == null){--%>
                <%--                        passError = "";--%>
                <%--                    }--%>
                <%--                %>--%>
                <%--                <%= passError%>--%>
                <div class="col-md-2 benefits">
                    <h4>Benefits of signup</h4>
                    <p>Manage your purchases anytime: Track your order status and print your vouchers</p>
                    <p>Quick shopping: no need to fill in your contact and shipping details while buying</p>
                    <p>Easy access to member only benefits</p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    </div>
</section>
<div class="contact-section">
    <div class="contact-section-head text-center">
        <h3><span>C</span>ontact Us</h3>
        <p>“let us know your feedbacks and questions”</p>
    </div>
    <div class="contact-form-main">
        <form>
            <label class="span1"></label>
            <input type="text" class="text" value="Name..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name...';}">
            <label class="span2"></label>
            <label class="span3"></label>
            <input type="text" class="text" value="Email..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email...';}">
            <label class="span4"></label>
            <label class="span5"></label>
            <input type="text" class="text" value="Phone..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Phone...';}">
            <label class="span6"></label>
            <label class="span7"></label>
            <textarea onfocus="if(this.value == 'Message...') this.value='';" onblur="if(this.value == '') this.value='Your Message';" >Message...</textarea>
            <label class="span8"></label>
            <input type="submit" value="">
        </form>
    </div>

</div>
<jsp:include page="/View/User/footer.jsp"></jsp:include>

</body>
</html>
