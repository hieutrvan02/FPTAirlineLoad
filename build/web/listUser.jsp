<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords"
              content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
        <meta name="description"
              content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
        <meta name="robots" content="noindex,nofollow">
        <title>Ample Admin Lite Template by WrapPixel</title>
        <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
        <!-- Custom CSS -->
        <link href="plugins/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">
        <link rel="stylesheet" href="plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">
        <!-- Custom CSS -->
        <link href="css/style.min.css" rel="stylesheet">
        <link href="./access/css/basic-table.css" rel="stylesheet">
    </head>
    <body>
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Main wrapper - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
             data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
            <%@include file="NavEmployee.jsp" %>
            <!-- ============================================================== -->
            <!-- End Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page wrapper  -->
            <!-- ============================================================== -->
            <div class="page-wrapper">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->

                <% if (!isAdmin) { %>
                <div class="page-breadcrumb bg-white">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title"></h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                            <div class="d-md-flex">
                                <ol class="breadcrumb ms-auto">
                                    <li><a href="listPromotionServlet" class="fw-normal">Xem danh sách mã giảm giá</a></li>
                                </ol>
                                <a href="createPromotion.jsp"
                                   class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Tạo mã giảm giá</a>
                            </div>
                        </div>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <% }%>

                <!-- ============================================================== -->
                <!-- NỘI DUNG THAY ĐỔI Ở TRONG container-fluid-->
                <!-- ============================================================== -->
                <jsp:useBean id="cusList" class="Model.dao.UserDAO"/>
                <c:set var="page" value="${param.page}"/>

                <c:if test="${page == null}">
                    <c:set var="page" value="1"/>
                </c:if>
                <c:set var="pageSize" value="5"/>
                <c:set var="listCustomer" value="${cusList.getCustomerByPage(page)}"/>
                <c:set var="maxPage" value="${cusList.getMaxPage(pageSize, cusList.getCustomer().size())}"/>
                <div class="container-fluid">
                    <!-- ============================================================== -->
                    <!-- Start Page Content -->
                    <!-- ============================================================== -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <h3 class="box-title">Danh sách người dùng</h3>
                                <div class="table-responsive">
                                    <table class="table text-nowrap">
                                        <thead>
                                            <tr>
                                                <th class="border-top-0">Email</th>
                                                <th class="border-top-0">Full Name</th>
                                                <th class="border-top-0">Gender</th>
                                                <th class="border-top-0">Birthday</th>
                                                <th class="border-top-0">Phone</th>
                                                <th class="border-top-0">Address</th>
                                                <th class="border-top-0">Nationality</th>
                                                <th class="border-top-0">CCCD</th>
                                                <th class="border-top-0"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="cus" items="${listCustomer}">
                                                <c:if test="${not empty cus.email}">
                                                    <tr>
                                                        <td>${cus.email}</td>
                                                        <td>${cus.name}</td>
                                                        <td>
                                                            ${fn:contains(cus.gender, 'F')?'Female':'Male'}
                                                        </td>
                                                        <td>${cus.birthday}</td>
                                                        <td>${cus.phone}</td>
                                                        <td>${cus.address}</td>
                                                        <td>${cus.nationality}</td>
                                                        <td>${cus.cccd}</td>
                                                        <td><button><a href="editCustomer.jsp?id=${cus.userID}">Chỉnh sửa</a></button></td>
                                                        <td><button><a href="EditCustomerServlet?id=${cus.userID}">Xoá</a></button></td>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:if test="${not empty listCustomer}">
                        <div>
                            <ul class="pagination">
                                <c:if test="${page>1}">
                                    <li><input type="hidden"><a href="listUser.jsp"><<</a></li>
                                    <li><input type="hidden"><a href="listUser.jsp?page=${page!=1?page-1:1}"><</a></li>
                                    </c:if>
                                    <c:forEach begin="1" end="${maxPage}" var="i">
                                    <li><a class="${page == i?'active':''}" href="listUser.jsp?page=${i}">${i}</a></li>
                                    </c:forEach>
                                    <c:if test="${page<maxPage}">
                                    <li><input type="hidden"><a href="listUser.jsp?page=${page!=maxPage?page+1:maxPage}">></a></li>
                                    <li><input type="hidden"><a href="listUser.jsp?page=${maxPage}">>></a></li>
                                    </c:if>
                            </ul>
                        </div>
                    </c:if>
                    <!-- ============================================================== -->
                    <!-- End PAge Content -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Right sidebar -->
                    <!-- ============================================================== -->
                    <!-- .right-sidebar -->
                    <!-- ============================================================== -->
                    <!-- End Right sidebar -->
                    <!-- ============================================================== -->
                </div>
                <!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <footer class="footer text-center"> 2021 © Ample Admin brought to you by <a
                        href="https://www.wrappixel.com/">wrappixel.com</a>
                </footer>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Page wrapper  -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
        <script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/app-style-switcher.js"></script>
        <script src="plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
        <!--Wave Effects -->
        <script src="js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="js/sidebarmenu.js"></script>
        <!--Custom JavaScript -->
        <script src="js/custom.js"></script>
        <!--This page JavaScript -->
        <!--chartis chart-->
        <script src="plugins/bower_components/chartist/dist/chartist.min.js"></script>
        <script src="plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
        <script src="js/pages/dashboards/dashboard1.js"></script>
    </body>
</html>
