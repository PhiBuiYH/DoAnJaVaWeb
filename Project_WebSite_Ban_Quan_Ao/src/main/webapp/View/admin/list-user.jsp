<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/View/admin/Static" var="url"></c:url>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Management</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- MORRIS CHART STYLES-->

    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->

    <link href="${url}/js/dataTables/dataTables.bootstrap.css"
          rel="stylesheet" />
    <link rel="stylesheet" href="Static/js/morris/morris-0.4.3.min.css">

</head>
<body>

<div id="wrapper">

    <jsp:include page="/View/admin/nav-bar.jsp"></jsp:include>

    <!-- /. NAV TOP  -->
    <jsp:include page="/View/admin/slide-bar.jsp"></jsp:include>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>List User</h2>
                    <h5>You can edit , add, delete User</h5>

                </div>
            </div>
            <!-- /. ROW  -->
            <hr />

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <a href="<c:url value='/admin/user/add?'/>"
                       class="button">ADD</a>
                    <div class="panel panel-default">
                        <div class="panel-heading">Advanced Tables</div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover"
                                       id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Avatar</th>
                                        <th>Email</th>
                                        <th>User Name</th>
                                        <th>Address</th>
                                        <th>Phone</th>
                                        <th>permission</th>
                                        <th>Action</th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${userList }" var="user">
                                        <tr class="odd gradeX">
                                            <td>${user.getId() }</td>
                                            <c:url value="/image/${user.getAvatar()}" var="imgUrl"></c:url>
                                            <td><img height="70" width="90" src="${imgUrl}" /></td>
                                            <td>${user.getEmail() }</td>
                                            <td>${user.getUserName() }</td>
                                            <td>${user.getAddress() }</td>
                                            <td>${user.getPhone() }</td>
                                            <td class="center"><c:choose>
                                                <c:when test="${user.getPermission() ==1 }">
                                                    Admin
                                                </c:when>
                                                <c:otherwise>Client</c:otherwise>
                                            </c:choose></td>

                                            <td><a href="<c:url value='/admin/user/edit?id=${user.id }'/>"
                                                   class="center">Edit</a> |
                                                <a href="<c:url value='/admin/user/delete?id=${user.id }'/>"
                                                   class="center">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
        </div>

    </div>
    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${url}/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${url}/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>

</body>
</html>

