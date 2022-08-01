
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/View/User" var="url"></c:url>
<script type="text/javascript">
    var urlMenu=document.getElementById('dropshoe');
    urlMenu.onchange= function (){
        var UserOption =this.options(this.selectedIndex);
    }

</script>
<div class="rsidebar span_1_of_left">
    <h3>Bộ lọc tìm kiếm</h3>
    <section  class="sky-form">
        <h4>Theo nhà cung cấp</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?brandid=0&page=1">ALL</a></li>
                <c:forEach var="i" items="${listBrand}">
                    <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?brandid=${i.brandId}&page=1">${i.brandName}</a></li>
                </c:forEach>
            </div>
        </div>
    </section>

    <section  class="sky-form">
        <h4>Theo Danh Mục</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?Cateid=0&page=1">ALL</a></li>

                <c:forEach items="${cateList}" var="cate">
                    <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?cateid=${cate.getCateId()}&page=1">${cate.getCateName()}</a></li>
                </c:forEach>
            </div>
        </div>
    </section>

    <section  class="sky-form">
        <h4>Theo giá</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=0&endPrice=10000000&page=1">ALL</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=0&endPrice=100000&page=1">Dưới 100.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=100000&endPrice=200000&page=1">100.000-200.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=200000&endPrice=300000&page=1">200.000-300.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=600000&endPrice=600000&page=1">300.000-600.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=600000&endPrice=1000000&page=1">600.000-1000.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=1000000&endPrice=999999999&page=1">Trên 1000.000</a></li>
            </div>
        </div>
    </section>
    <section  class="sky-form">
        <h4>Theo màu</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=0&page=1">ALL</a></li>
                <c:forEach items="${colorList}" var="color">
                    <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=${color.getColorId()}&page=1">${color.getColorName()}</a></li>

                </c:forEach>
            </div>
        </div>
    </section>


    <section  class="sky-form">
        <h4>Theo Size</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=0&page=1">ALL</a></li>

                <c:forEach items="${sizeList}" var="size">
                    <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=${size.getSizeId()}&page=1">${size.getSizeName()}</a></li>
                </c:forEach>
            </div>
        </div>
    </section>
</div>

