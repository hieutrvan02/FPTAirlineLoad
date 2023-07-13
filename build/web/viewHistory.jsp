<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View History</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="./css/personal.css"/>
        <link rel="stylesheet" href="./css/history.css"/>
    </head>
    <body>
        <c:set var="information" value="${requestScope.information}" />
        <div class="container" style="margin-top: 150px"> 
            <div class="row">
                <div class="col-12 col-lg-4">
                    <div class="card custom-card">
                        <div class="row card-header"style="margin-left: 0; margin-right: 0">
                            <div class="col-6 col-lg-12"><a href="AccountServlet">
                                    <div class="row " style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fas fa-info-circle"></i></div>
                                        <div class="col-12 col-lg-9"style="padding: 0;color: white"> Tài khoản của tôi</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="PersonalServlet">
                                    <div class="row "style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fas fa-id-badge"></i></div>
                                        <div class="col-12 col-lg-9"style="padding: 0;color: white"> Thông tin cá nhân</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="#">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fa fa-history"></i></div>
                                        <div class="col-12 col-lg-9 title"style="padding: 0;color: white"> Lịch sử đặt vé</div>
                                    </div>
                                </a></div>  
                            <div class="col-6 col-lg-12"><a href="/FPT/cancelTicket.jsp">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fa fa-ban"></i></div>
                                        <div class="col-12 col-lg-9 title"style="padding: 0;color: white"> Hủy vé</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="lookUpFlight.jsp">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fa fa-search"></i></div>
                                        <div class="col-12 col-lg-9 title"style="padding: 0;color: white"> Tra cứu chuyến bay</div>
                                    </div>
                                </a></div> 
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-8">
                    <div class="container" style="text-align:center;">
                        <table id="myTable" class="table" style="border: 1px solid #dee2e6;">
                            <thead class="dark">
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col">Ngày</th>
                                    <th scope="col">Mã giao dịch</th>
                                    <th scope="col">Mã giảm giá</th>
                                    <th scope="col">Thuế</th>
                                    <th scope="col">Số tiền</th>
                                </tr>
                            </thead>
                            <tbody class=".table tbody">
                                <c:forEach items="${listOrder}" var="p">
                                    <tr>
                                        <td>${p.date}</td>
                                        <td>${p.orderID}</td>
                                        <td>${p.promotionID}</td>
                                        <td>${p.tax}</td>
                                        <td>${p.totalAmount}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    const table = document.querySelector('.table tbody');
    const rows = table.querySelectorAll('tr');

// loop through each row and add an "STT" column
    rows.forEach((row, index) => {
        const sttColumn = document.createElement('td');
        sttColumn.textContent = index + 1;
        row.insertBefore(sttColumn, row.firstElementChild);
    });
    $(document).ready(function () {
        $('#myTable').DataTable();
    });
    $(document).ready(function () {
        if ($.fn.DataTable.isDataTable('#myTable')) {
            $('#myTable').DataTable().destroy();
        }
        $('#myTable').DataTable({
            "pagingType": "full_numbers",
            "pageLength": 10,
            "lengthMenu": [10, 25, 50, 75, 100]
        });
    });
</script>
</html>
