<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="node_modules/bootstrap-icons/font/bootstrap-icons.min.css">

        <!-- Search-Form -->
        <link href=access/Styles/reset-css.css rel="stylesheet" type="text/css"/>
        <link href="access/Styles/jquery-ui-1.8.7.all.css" rel="stylesheet" type="text/css"/>
        <link href=access/Styles/SearchView.css rel="stylesheet" type="text/css"/>


        <title>Select Flight</title>
    </head>
    <body>
        <div class="container justify-content-around" style="margin-top: 150px">
            <form action="SelectFlightServlet" method="post">
                <div class="row">
                    <div class="col-sm-8" style="background-color: blanchedalmond ;">
                        <div class="row">
                            <div class="col-sm-6">
                                <a class="text-danger">Giá vé chưa bao gồm thuế và phí</a>
                                <br>
                                <%-- ==================================================MỘT CHIỀU=================================--%>
                                <a class="text-danger">${Departure} đi ${Destination}</a>
                                <br>
                                <a class="text-primary">Bay ngày: ${StartDate}</a>
                            </div>
                            <div class="col-sm-6 text-white" style="background-color: orange;">
                                <div><a>Bước 1: Chọn chuyến bay chiều đi</a></div>
                                <div><a>Bước 2: Chọn chuyến bay chiều về</a></div>
                                <div><a>Bước 3: Bấm vào nút Tiếp tục</a></div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <table class="search-result" style="width: 100%;">
                                <div id="accordion">
                                    <thead>
                                        <tr class="table-danger">
                                            <th scope="col">Mã chuyến bay &nbsp</th>
                                            <th scope="col">Thời gian</th>
                                            <th scope="col">Giá vé</th>
                                            <th scope="col">Thông tin chi tiết &nbsp</th>
                                            <th scope="col">Chọn chuyến</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%--Bắt đầu tạo chuyến đi--%>
                                        <c:forEach items="${listFlightOne}" var="p">
                                            <tr class="table-info">
                                                <td><a>${p.flightId}</a></td>
                                                <td><strong>${p.startTime} - ${p.endTime} </strong></td>
                                                <td><input class="price" type="text" value="${listTicket.get(0).ticketPrice} VND"
                                                           style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                           disabled></td>
                                                <td><a data-toggle="collapse" data-parent="#accordion" href="#${p.flightId}">Xem chi
                                                        tiết
                                                        <i class="bi bi-plus-square"></i></a>
                                                </td>
                                                <td><input type="radio" name="flightId" value="${p.flightId}" required><label></label>Chọn</td>
                                            </tr>
                                            <tr class="table-success">
                                                <td colspan="12" class="hiddenRow">
                                                    <div class="accordion-body collapse" id="${p.flightId}">
                                                        <table class="table table-striped">
                                                            <thead>
                                                                <tr>
                                                                    <th>Điểm đi</th>
                                                                    <th>Điểm đến</th>
                                                                    <th>Thời gian đi</th>
                                                                    <th>Thời gian đến</th>
                                                                    <th>Loại vé</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>${p.departure}</td>
                                                                    <td>${p.destination}</td>
                                                                    <td>${p.startTime},${p.startDate}</td>
                                                                    <td>${p.endTime},${p.endDate}</td>
                                                                    <td><select name="ticketType"
                                                                                style="background-color: rgb(65, 225, 225); border-radius: 50px; "
                                                                                onchange="getValue(this)">
                                                                            <c:forEach items="${listTicket}" var="f">
                                                                                <option class="${f.ticketPrice} VND" value="${f.ticketTypeId}">${f.ticketType}</option>
                                                                            </c:forEach>
                                                                        </select></td>
                                                                </tr>
                                                            </tbody>
                                                            <thead>
                                                                <tr>
                                                                    <th>Hành khách</th>
                                                                    <th>Số lượng vé</th>
                                                                    <th>Giá mỗi vé</th>
                                                                    <th>VAT</th>
                                                                    <th>Tổng giá</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <tr>
                                                                    <td>Người lớn</td>
                                                                    <td class="numA">${adult}</td>
                                                                    <c:set var="ticketTypePrice" value="${p.flightId}"></c:set>
                                                                    <td><input class="price" type="text" name="typePriceA<c:out value="${ticketTypePrice}"/>"
                                                                               value="${listTicket.get(0).ticketPrice} VND"
                                                                               style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                               readonly>
                                                                    </td>
                                                                    <td>10%</td>
                                                                    <td><input class="totalAdult" type="text" name="totalPriceA<c:out value="${ticketTypePrice}"/>"
                                                                               value="${listTicket.get(0).ticketSumAdult} VND"
                                                                               style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                               readonly>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                            <tbody>
                                                                <c:if test="${kid > 0}">
                                                                    <tr>
                                                                        <td>Trẻ em</td>
                                                                        <td class="numK">${kid}</td>
                                                                        <td><input class="price" type="text" name="typePriceK<c:out value="${ticketTypePrice}"/>"
                                                                                   value="${listTicket.get(0).ticketPrice} VND"
                                                                                   style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                                   readonly></td>
                                                                        <td>10%</td>
                                                                        <td>
                                                                            <input class="totalKid" type="text" name="totalPriceK<c:out value="${ticketTypePrice}"/>"
                                                                                   value="${listTicket.get(0).ticketSumKid} VND"
                                                                                   style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                                   readonly>
                                                                        </td>
                                                                    </tr>
                                                                </c:if>
                                                            </tbody>
                                                            <tbody>
                                                                <c:if test="${baby > 0}">
                                                                    <tr>
                                                                        <td>Trẻ sơ sinh</td>
                                                                        <td>${baby}</td>
                                                                        <td></td>
                                                                        <td></td>
                                                                        <td></td>
                                                                    </tr>
                                                                </c:if>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </td>
                                            </c:forEach>
                                            <%--Kết thúc chuyến đi--%>
                                </div>
                            </table>
                        </div>
                        <%-- ==================================================KHỨ HỒI=================================--%>
                        <c:if test="${EndDate != null}">
                            <a class="text-danger">${Destination} đi ${Departure}</a>
                            <br>
                            <a class="text-primary">Bay ngày: ${EndDate}</a>
                            <div class="panel panel-default">
                                <table class="search-result" style="width: 100%;">
                                    <div id="accordion1">
                                        <thead>
                                            <tr class="table-danger">
                                                <th scope="col">Mã chuyến bay &nbsp</th>
                                                <th scope="col">Thời gian</th>
                                                <th scope="col">Giá vé</th>
                                                <th scope="col">Thông tin chi tiết &nbsp</th>
                                                <th scope="col">Chọn chuyến</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%--Bắt đầu tạo chuyến về--%>
                                            <c:forEach items="${listFlightRound}" var="l">
                                                <tr class="table-info">
                                                    <td><a>${l.flightId}</a></td>
                                                    <td><strong>${l.startTime} - ${l.endTime} </strong></td>
                                                    <td><input class="price" type="text" value="${listTicket.get(0).ticketPrice} VND"
                                                               style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                               disabled></td>
                                                    <td><a data-toggle="collapse" data-parent="#accordion1" href="#${l.flightId}">Xem chi
                                                            tiết
                                                            <i class="bi bi-plus-square"></i></a>
                                                    </td>
                                                    <td><input type="radio" name="flightIdRound" value="${l.flightId}" required><label></label>Chọn</td>
                                                </tr>
                                                <tr class="table-success">
                                                    <td colspan="12" class="hiddenRow">
                                                        <div class="accordion-body collapse" id="${l.flightId}">
                                                            <table class="table table-striped">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Điểm đi</th>
                                                                        <th>Điểm đến</th>
                                                                        <th>Thời gian đi</th>
                                                                        <th>Thời gian đến</th>
                                                                        <th>Loại vé</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>${l.departure}</td>
                                                                        <td>${l.destination}</td>
                                                                        <td>${l.startTime},${l.startDate}</td>
                                                                        <td>${l.endTime},${l.endDate}</td>
                                                                        <td><select
                                                                                style="background-color: rgb(65, 225, 225); border-radius: 50px; "
                                                                                onchange="getValue(this)">
                                                                                <c:forEach items="${listTicket}" var="f">
                                                                                    <option class="${f.ticketPrice} VND" value="${f.ticketTypeId}">${f.ticketType}</option>
                                                                                </c:forEach>
                                                                            </select></td>
                                                                    </tr>
                                                                </tbody>
                                                                <thead>
                                                                    <tr>
                                                                        <th>Hành khách</th>
                                                                        <th>Số lượng vé</th>
                                                                        <th>Giá mỗi vé</th>
                                                                        <th>VAT</th>
                                                                        <th>Tổng giá</th>
                                                                    </tr>
                                                                </thead>
                                                                <c:set var="flightBack" value="${l.flightId}"></c:set>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>Người lớn</td>
                                                                            <td class="numA">${adult}</td>
                                                                        <td><input class="price" type="text" name="typePriceA<c:out value="${flightBack}"/>"
                                                                                   value="${listTicket.get(0).ticketPrice} VND"
                                                                                   style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                                   readonly>
                                                                        </td>
                                                                        <td></td>
                                                                        <td><input class="totalAdult" type="text" name="totalPriceA<c:out value="${flightBack}"/>"
                                                                                   value="${listTicket.get(0).ticketSumAdult}VND"
                                                                                   style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                                   readonly>
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                                <tbody>
                                                                    <c:if test="${kid > 0}">
                                                                        <tr>
                                                                            <td>Trẻ em</td>
                                                                            <td class="numK">${kid}</td>
                                                                            <td><input class="price" type="text" name="typePriceK<c:out value="${flightBack}"/>"
                                                                                       value="${listTicket.get(0).ticketPrice} VND"
                                                                                       style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                                       readonly></td>
                                                                            <td></td>
                                                                            <td>
                                                                                <input class="totalKid" type="text" name="totalPriceK<c:out value="${flightBack}"/>"
                                                                                       value="${listTicket.get(0).ticketSumKid}VND"
                                                                                       style="background-color: rgb(65, 225, 225); border-radius: 50px; width: 120px;"
                                                                                       readonly>
                                                                            </td>
                                                                        </tr>
                                                                    </c:if>
                                                                </tbody>
                                                                <tbody>
                                                                    <c:if test="${baby > 0}">
                                                                        <tr>
                                                                            <td>Trẻ sơ sinh</td>
                                                                            <td>${baby}</td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                    </c:if>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </td>
                                                </c:forEach>
                                            </c:if>
                                            <%--Kết thúc chuyến về--%>
                                </div>
                            </table>
                        </div>
                        <c:if test="${userID!= null}">
                            <div class="submit-flight float-left">
                                <button type="submit" class="btn btn-primary">Tiếp tục</button>
                            </div>
                        </c:if>
                        <c:if test="${userID == null}">
                            <div class="alert alert-warning" role="alert" style="width: 276px">
                                Vui lòng đăng nhập để đặt vé
                            </div
                        </c:if>
                    </div>
                </div>
            </form>

        </div>
    </body>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
    <script src="access/js/select-flights.js"></script>
</html>