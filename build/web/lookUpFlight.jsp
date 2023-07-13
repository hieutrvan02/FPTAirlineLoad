<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Look Up Flight</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/account.css"/>
    </head>
    <body>
        <c:set var="information" value="${requestScope.information}" />
        <div class="container" style="margin-top: 150px"> 
            <div class="row">
                <div class="col-12 col-lg-4">
                    <div class="card custom-card">
                        <div class="row card-header"style="margin-left: 0; margin-right: 0">
                            <div class="col-6 col-lg-12"><a href="AccountServlet">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fas fa-info-circle"></i></div>
                                        <div class="col-12 col-lg-9 title"style="padding: 0;color: white"> Tài khoản của tôi</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="PersonalServlet">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fas fa-id-badge"></i></div>
                                        <div class="col-12 col-lg-9 title"style="padding: 0;color: white"> Thông tin cá nhân</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="viewHistoryServlet">
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
                            <div class="col-6 col-lg-12"><a href="#">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fa fa-search"></i></div>
                                        <div class="col-12 col-lg-9 title"style="padding: 0;color: white"> Tra cứu chuyến bay</div>
                                    </div>
                                </a></div> 
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-8">
                    <div class="col-12 col-lg-8" style="background-color: rgb(211, 122, 21);">
                        <h1 style="text-align: center; margin-bottom: 30px;">Tra cứu chuyến bay</h1>
                        <form action="lookUpFlight" method="post">
                            <label for="ticketId"
                                   style="color: #333; background-color: #f5f5f5; padding: 5px 10px; border-radius: 5px;">Mã
                                vé:</label>
                            <input type="text" name="ticketId"
                                   style="padding: 10px; border-radius: 5px; border: 1px solid #ccc;"><br><br>
                            <label for="name"
                                   style="color: #333; background-color: #f5f5f5; padding: 5px 10px; border-radius: 5px;">Họ và Tên</label>
                            <input type="text" name="passengerName"
                                   style="padding: 10px; border-radius: 5px; border: 1px solid #ccc;"><br><br>
                            <button type="submit"
                                    style="padding: 10px 20px; font-size: 16px; border-radius: 5px; background-color: #0077cc; color: #fff;"><i
                                    class="fa fa-search"></i> Tra cứu</button>
                        </form>
                    </div>
                </div>
                <c:if test="${lookUpFlight != null}">
                    <h1>Tên hành khách : ${Name}</h1>
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Mã chuyến bay</th>
                                <th scope="col">Ngày khởi hành</th>
                                <th scope="col">Thời gian khởi hành</th>
                                <th scope="col">Điểm xuất phát</th>
                                <th scope="col">Điểm đến</th>
                                <th scope="col">Ghế</th>
                                <th scope="col">Hạng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lookUpFlight}" var="p">
                                <tr>
                                    <td>${p.flightId}</td>
                                    <td>${p.startDate}</td>
                                    <td>${p.startTime}</td>
                                    <td>${p.departure}</td>
                                    <td>${p.destination}</td>
                                    <td>${p.seat}</td>
                                    <td>${p.ticketType}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </body>
</html>
