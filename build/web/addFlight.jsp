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
        <title>Add Flights</title>
        <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
        <!-- Custom CSS -->
        <link href="plugins/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">
        <link rel="stylesheet" href="plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">
        <!-- Custom CSS -->
        <link href="css/style.min.css" rel="stylesheet">
        <link href="./access/css/basic-table.css" rel="stylesheet">

        <style>


            input,
            select {
                padding: 0;
                margin: 0;
                outline: none;
                font-family: Roboto, Arial, sans-serif;
                font-size: 16px;
                color: #eee;
            }
            h1,
            h3 {
                font-weight: 400;
            }

            h1 {
                font-size: 32px;
            }

            h3 {
                color: #1c87c9;
            }

            .main-block,
            .info {
                display: flex;
                flex-direction: column;
            }

            .main-block {
                justify-content: center;
                align-items: center;
                width: 100%;
                min-height: 100%;
                background: url("/uploads/media/default/0001/01/e7a97bd9b2d25886cc7b9115de83b6b28b73b90b.jpeg") no-repeat center;
                background-size: cover;
            }

            form {
                width: 80%;
                padding: 25px;
                margin-bottom: 20px;
                background: black;
            }

            input,
            select {
                padding: 5px;
                margin-bottom: 20px;
                background: transparent;
                border: none;
                border-bottom: 1px solid #eee;
            }

            input::placeholder {
                color: #eee;
            }

            option {
                background: black;
                border: none;
            }

            .metod {
                display: flex;
            }

            input[type=radio] {
                display: none;
            }

            label.radio {
                position: relative;
                display: inline-block;
                margin-right: 20px;
                text-indent: 32px;
                cursor: pointer;
            }

            label.radio:before {
                content: "";
                position: absolute;
                top: -1px;
                left: 0;
                width: 17px;
                height: 17px;
                border-radius: 50%;
                border: 2px solid #1c87c9;
            }

            label.radio:after {
                content: "";
                position: absolute;
                width: 8px;
                height: 4px;
                top: 5px;
                left: 5px;
                border-bottom: 3px solid #1c87c9;
                border-left: 3px solid #1c87c9;
                transform: rotate(-45deg);
                opacity: 0;
            }

            input[type=radio]:checked+label:after {
                opacity: 1;
            }

            button {
                display: block;
                width: 200px;
                padding: 10px;
                margin: 20px auto 0;
                border: none;
                border-radius: 5px;
                background: #1c87c9;
                font-size: 14px;
                font-weight: 600;
                color: #fff;
            }

            button:hover {
                background: #095484;
            }
        </style>
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
                    <div class="main-block">
                        <h1 style="color: orange;">Create Flight</h1>
                        <h3 style="color: red;">${requestScope.error}</h3>
                        <form action="addFlight">
                            <div class="info">
                                <input class="fname" type="text" name="flightId" placeholder="Flight ID">
                                <input type="text" name="departure" placeholder="Departure">
                                <input type="text" name="destination" placeholder="Destination">
                                <input type="text" name="startDate" placeholder="Start Date">
                                <input type="text" name="endDate" placeholder="End Date">
                                <input type="text" name="startTime" placeholder="Start Time">
                                <input type="text" name="endTime" placeholder="End Time">
                                <input type="text" name="gate" placeholder="Gate">
                                <input type="text" name="distanceID" placeholder="Distance_ID">
                                <input type="text" name="seatsB" placeholder="Seats B">
                                <input type="text" name="seatsC" placeholder="Seats C">
                                <button href="ListFlightServlet" class="button">Submit</button>
                            </div>
                        </form>
                    </div>


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

