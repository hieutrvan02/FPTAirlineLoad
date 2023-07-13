<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/bill.css"/>
    </head>
    <body>
        <c:set var="bill" value="${requestScope.bill}" />
        <c:set var="user" value="${requestScope.user}" />
        <c:set var="flightType" value="${requestScope.flightType}" />
        <div class="container" style="margin-top: 150px"> 
            <div class="card">
                <div class="card-header">
                    <div class="title">Xác nhận đặt vé</div>
                </div>
                <div class="row custom-card-item">
                    <div class="col-12" style="font-weight: bold;margin-top: 10px;margin-bottom: 10px;font-size: 20px"> FPT Airlines xin chân thành cảm ơn quý khách ${user.getName()}</div>
                </div>
                <div>
                    <div class="row custom-card-item">
                        <div class="col-12" style="font-style: italic"> Chúng tôi sẽ liên lac với số điện thoại ${user.getPhone()}</div>
                    </div>
                    <div class="row custom-card-item">
                        <div class="col-12" style="font-style: italic"> Đồng thời gửi 1 thông tin về đơn đặt vé vào email ${user.getEmail()}</div>
                    </div>
                </div>
                <hr style="border-width: 1px; border-style: solid; border-color: #F44D06">
                <div class="row custom-card-item">
                    <div class="col-4"> Mã đơn đặt vé</div>
                    <div class="col-8 custom-information">${bill.getOrderID()} </div>
                </div>
                <div class="row custom-card-item">
                    <div class="col-4"> Tổng giá</div>
                    <div class="col-8 custom-information">${bill.getTotalAmount()}</div>
                </div>
                <div class="row custom-card-item">
                    <div class="col-4"> Điểm khởi hành</div>
                    <div class="col-8 custom-information">${bill.getDeparture()}</div>
                </div>
                <div class="row custom-card-item">
                    <div class="col-4"> Lúc</div>
                    <div class="col-8 custom-information">${bill.getStartTime()} ${bill.getStartDate()}</div>
                </div>
                <div class="row custom-card-item">
                    <div class="col-4"> Điểm đến</div>
                    <div class="col-8 custom-information">${bill.getDestination()}</div>
                </div>
                <div class="row custom-card-item">
                    <div class="col-4"> Lúc</div>
                    <div class="col-8 custom-information">${bill.getEndTime()} ${bill.getEndDate()}</div>
                </div>
                <div class="row custom-card-item">
                    <div class="col-4"> Loại vé</div>
                    <div class="col-8 custom-information">${flightType}</div>
                </div>
                <hr style="border-width: 1px; border-style: solid; border-color: #F44D06">
                <div class="row custom-card-item">
                    <div class="col-12" style="font-style: italic; padding-bottom: 10px"> Quý khách vui lòng kiểm tra email để lấy vé điện tử.</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
