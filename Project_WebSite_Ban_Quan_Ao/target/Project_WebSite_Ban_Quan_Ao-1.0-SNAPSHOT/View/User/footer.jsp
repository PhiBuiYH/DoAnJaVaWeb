<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 1/13/2021
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${url}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Site footer -->
<div class="site-footer">
    <!-- Site footer -->
    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <h6>About</h6>
                    <br/>
                    <p class="text-justify">Pakishop.com <p>Nếu bạn đang tìm kiếm một trang web để mua và bán hàng trực tuyến thì Pakishop.vn là một sự lựa chọn hiệu quả dành cho bạn. Bản chất của Shopee là một social ecommerce platform - nền tảng trang web thương mại điện tử tích hợp mạng xã hội. Điều này cho phép người mua và người bán hàng dễ dàng tương tác, trao đổi thông tin về sản phẩm và chương trình khuyến mãi của shop. Nhờ nền tảng đó, việc mua bán trên PakiShop trở nên nhanh chóng và đơn giản hơn.</p>.</p>
                </div>

                <div class="col-xs-6 col-md-3">
                    <h6>Categories</h6>
                    <ul class="footer-links">
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=1&page=1">Giày nike</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=2&page=1">Giày adidas</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=3&page=1">Áo thun nam</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=4&page=1">Áo thun nữ</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=5&page=1">Áo sơ mi nam</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=6&page=1">Áo sơ mi nữ</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=7&page=1">Quần jean nam</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=8&page=1">Quần jean nữ</a></li>
                        <li><a href="${pageContext.request.contextPath }/product/searchByProperties?cateid=9&page=1">Quần kaki nam</a></li>



                    </ul>
                </div>

                <div class="col-xs-6 col-md-3">
                    <h6>Quick Links</h6>
                    <ul class="footer-links">
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Contribute</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Sitemap</a></li>
                    </ul>
                </div>
            </div>
            <hr>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-sm-6 col-xs-12">
                    <p class="copyright-text">Copyright &copy; 2017 All Rights Reserved by
                        <a href="#">Scanfcode</a>.
                    </p>
                </div>

                <div class="col-md-4 col-sm-6 col-xs-12">
                    <ul class="social-icons">
                        <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                        <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</div>
