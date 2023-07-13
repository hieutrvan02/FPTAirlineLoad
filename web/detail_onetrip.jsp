<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>chọn vé</title>
        <link rel="stylesheet" href="access/css/orderDetail.css"/>
        <link rel="stylesheet" href="access/css/submit.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container mt-5 pt-5" >
            <form action="Verify" method="get" onsubmit="//return validateDateKid(event), validateDateBaby()">
                <div class="count">
                    <p>Thời gian đặt vé còn lại: <span id="countdown"></span></p>
                </div>
                <div class="row">
                    <div class="col-8 ">
                        <div class="content-right bg-light" style="  box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); ">
                            <div class="heading-h3">
                                <h3>
                                    <span>Thông tin chuyến bay</span>
                                </h3>
                            </div>
                            <table class="info_flight" width="100%">
                                <tbody>
                                    <tr>
                                        <td>Chuyến bay:</td>
                                        <td>
                                            <b>Một chiều</b>
                                        </td>
                                        <td>Số lượng hành khách:</td>
                                        <td>
                                            <b>${adult} người lớn, ${kid} trẻ em, ${baby} trẻ sơ sinh</b>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Ngày xuất phát:</td>
                                        <td>
                                            <b>${StartDate}</b>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <br>

                            <table width="97%" style="background: #e7e7e7; margin: 0 10px 10px" cellpadding="0">
                                <tbody>
                                    <tr>
                                        <td>
                                            <span><img style="width: 200px" src="./Img/FPT Airline.png" alt="FPT Airline"/></span>
                                        </td>
                                        <td class="dep-res">
                                            <a>Điểm đi</a> <br>
                                            <strong style="color: #000">${Departure}</strong> <br>

                                        </td>
                                        <td>
                                            <a></a> <br>
                                            <span><img src="./Img/iconPlane.png" alt="alt"/></span>
                                        </td>
                                        <td class="dep-res">
                                            <a>Điểm đến</a> <br>
                                            <strong style="color: #000">${Destination}</strong> <br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td></td>
                                        <td class="ticket-type">
                                            <p>Ngày đi:
                                                <strong style="color: #000">${StartDate}</strong>
                                            </p>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="dieu-kien-ve">
                                <div class="heading-h3" onclick="myFunction()" style="cursor:pointer;">
                                    <h3>
                                        <span>Điều kiện vé</span>
                                        <i style="margin-right:10px; padding-top: 10px; font-size: 18px;float:right;">Bấm để xem chi tiết</i>
                                    </h3>
                                </div>
                                <div id="myDIV" style="display: none">
                                    <strong style="font-size: 18px; margin:0 5%; line-height: 22px; display: inline-block;">Điều kiện vé chiều đi</strong>
                                    <span class="dieu-kien-chieu-di">
                                        <table cellpadding="8" cellspacing="0" height="70" style="table-layout: fixed; padding-left: 10px;">
                                            <colgroup>
                                                <col width="200">
                                                <col width="450">
                                            </colgroup>
                                            <tbody>
                                                <tr>
                                                    <td colspan="2">
                                                        <span style="color: #F44D06; line-height: 32px; padding: 0px;">Điều kiện hành lý  </span>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Hành lý xách tay</td>
                                                    <td>7 kg</td>
                                                </tr>
                                                <tr>
                                                    <td>Hành lý ký gửi</td>
                                                    <td>Vui lòng chọn ở bước sau</td>
                                                </tr>
                                            </tbody>
                                        </table>

                                        <table cellpadding="8" cellspacing="0" height="70" style="table-layout: fixed;">
                                            <colgroup>
                                                <col width="200">
                                                <col width="450">
                                            </colgroup>
                                            <tbody>
                                                <tr>
                                                    <td colspan="2">
                                                        <span style="color: #F44D06; line-height: 32px; padding: 0px;">Điều kiện về vé  </span>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Đổi tên hành khách</td>
                                                    <td>Không được phép</td>
                                                </tr>
                                                <tr>
                                                    <td>Đổi Hành Trình</td>
                                                    <td>Được phép - Thu phí : 500.000 VND + chênh lệch giá vé (nếu có)</td>
                                                </tr>
                                                <tr>
                                                    <td>Bảo lưu</td>
                                                    <td>Không được phép</td>
                                                </tr>
                                                <tr>
                                                    <td>Thời hạn thay đổi (bao gồm thay đổi tên, ngày/chuyến bay, hành trình)</td>
                                                    <td>Trước 12 tiếng so với giờ khởi hành</td>
                                                </tr>
                                                <tr>
                                                    <td>Thay đổi chuyến bay</td>
                                                    <td>Được phép - Thu phí: 500.000 VND + chênh lệch giá vé (nếu có)</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </span>
                                </div>
                            </div>

                            <div class="thong-tin-hanh-ly">
                                <div class="heading-h3">
                                    <h3>
                                        <span>Thông tin hành lý</span>
                                    </h3>
                                </div>
                                <table width="100%" cellpadding="0" cellspacing="0" style="padding: 15px";">
                                    <tbody> 
                                        <!-- hành lý lượt đi -->
                                        <tr style="background: #ffffff">
                                            <td >
                                                <span style="font-size: 14px;  width: 140px;  display: block; margin-left: 20px;">Hành lý lượt đi</span>
                                            </td>
                                            <td>
                                                <!-- người lớn -->
                                                <c:forEach var="list" begin="1" end="${adult}"> 
                                                    <p>
                                                        <span>hành khách thứ ${list}</span>
                                                        <select name="luggageGoA<c:out value="${list}"/>" class="luggageGo" onchange="AddLuggage('luggageGo', 'infoticketGO')">
                                                            <option data="0" value="L0">Không mang hành lý</option>
                                                            <option data="200000" value="L2">Thêm 20Kg hành lý (200,000 VND)</option>
                                                            <option data="300000" value="L3">Thêm 30Kg hành lý (300,000 VND)</option>
                                                            <option data="400000" value="L4">Thêm 40Kg hành lý (400,000 VND)</option>
                                                            <option data="500000" value="L5">Thêm 50Kg hành lý (500,000 VND)</option>
                                                        </select>
                                                    </p>
                                                </c:forEach>
                                                <!-- trẻ em -->
                                                <c:forEach var="list" begin="1" end="${kid}"> 
                                                    <p>
                                                        <span style="margin-right: 35px">trẻ em thứ ${list}</span>
                                                        <select name="luggageGoK<c:out value="${list}"/>" class="luggageGo" onchange="AddLuggage('luggageGo', 'infoticketGO')">
                                                            <option data="0" value="L0">Không mang hành lý</option>
                                                            <option data="200000" value="L2">Thêm 20Kg hành lý (200,000 VND)</option>
                                                            <option data="300000" value="L3">Thêm 30Kg hành lý (300,000 VND)</option>
                                                            <option data="400000" value="L4">Thêm 40Kg hành lý (400,000 VND)</option>
                                                            <option data="500000" value="L5">Thêm 50Kg hành lý (500,000 VND)</option>
                                                        </select>
                                                    </p>
                                                </c:forEach>
                                            </td>

                                        </tr>

                                    </tbody>
                                </table>
                            </div>

                            <div class="heading-h3">
                                <h3>
                                    <span>Thông tin hành khách</span>
                                </h3>
                            </div>
                            <c:forEach var="list" begin="1" end="${adult}"><!-- người lớn -->
                                <table width="100%" cellpadding="0" cellspacing="0" style="padding: 15px; background: #ffffff";">
                                    <tr>      
                                        <td colspan="1">
                                            <b style="font-size: 14px;  width: 140px;  display: block; margin-left: 20px;">Người lớn ${list}</b>
                                        </td>
                                        <td colspan="2">
                                            <c:set var="aNum" value="${list}"/>
                                            <p><input id="fullname" type="text" style="width: 270px" name="nameAdult<c:out value="${aNum}"/>" required></p>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td colspan="1">
                                            <span style="font-size: 14px;  width: 140px;  display: block; margin-left: 20px;">Ngày sinh</span>
                                        </td>
                                        <td>
                                            <input type="date" name="txtDateA<c:out value="${aNum}"/>" id="birthdateAdult" required min="1900-01-01" style="margin-bottom: 10px"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="1">
                                            <span style="font-size: 14px;  width: 140px;  display: block; margin-left: 20px;" >CCCD</span>
                                        </td>
                                        <td>
                                            <p><input name="cccd<c:out value="${aNum}"/>" type="text" style="width: 270px;" required></p>
                                        </td>
                                    </tr>
                                </table>
                            </c:forEach>

                            <c:forEach var="list" begin="1" end="${kid}"><!-- trẻ em -->
                                <table width="100%" cellpadding="0" cellspacing="0" style="padding-top: 150px; ";">
                                    <tr>      
                                        <td colspan="1">
                                            <b style="font-size: 14px;  width: 140px;  display: block; margin-left: 20px;">Trẻ em ${list}</b>
                                        </td>
                                        <td colspan="2">
                                            <c:set var="kNum" value="${list}"/>
                                            <p><input name="nameKid<c:out value="${kNum}"/>" id="fullname" type="text" style="width: 270px;" required></p>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td colspan="1">
                                            <span style="font-size: 14px;  width: 140px;  display: block; margin-left: 20px;">Ngày sinh</span>
                                        </td>
                                        <td>
                                            <input type="date" name="txtDateK<c:out value="${kNum}"/>" id="birthdateKid" required style="margin-bottom: 10px"/>
                                        </td>
                                    </tr>
                                </table>
                            </c:forEach>
                            <div class="thong-tin-khuyen-mai">
                                <div class="heading-h3">
                                    <h3>
                                        <span>Thông tin khuyến mãi</span>
                                    </h3>
                                </div>
                                <table width="100%" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td colspan="1">
                                            <span style="font-size: 14px;  width: 140px;  display: block; margin:0 0 10px 20px;font-weight: 700;">Mã giảm giá</span>
                                        </td>
                                        <td>
                                            <input type="text" name="promotions" style="margin-bottom: 10px"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="submit-flight float-right">
                                <button  type="submit" class="bubbly-button">Đặt vé</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-4 p-0">
                        <div class="price-details">
                            <h3 class="price-details-title">Chi tiết giá</h3>
                            <table id="infoticketGO" width="100%" cellpadding="0" cellspacing="0">
                                <tbody>
                                    <tr>
                                        <td colspan="5" style="color: #f44d06;font-size: 18px;font-weight: bold;">Chi tiết giá vé lượt đi</td>
                                    </tr>
                                    <tr>
                                        <td><span class="sAdult">${adult} Người lớn</span></td>
                                        <td><b>X</b></td>
                                        <td style="text-align: right;">
                                            <b class="color-red typePriceA">
                                                ${ticketTypePrice}
                                            </b>
                                        </td>
                                        <td style="padding:0px;">=</td>
                                        <td style="text-align: right;">
                                            <b class="color-red totalPriceA">
                                            </b>
                                        </td>
                                    </tr>
                                    <c:if test="${kid > 0}">
                                        <tr>
                                            <td><span class="sKid">${kid} trẻ em</span></td>
                                            <td><b>X</b></td>
                                            <td style="text-align: right;">
                                                <b class="color-red typePriceK">
                                                    ${ticketTypePrice}
                                                </b>
                                            </td>
                                            <td style="padding:0px;">=</td>
                                            <td style="text-align: right;">
                                                <b class="color-red totalPriceK">
                                                </b>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <!-- thue phi-->
                                    <tr class="border-airline">
                                        <td colspan="5"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="5" style="font-weight:bold">Thuế và phí</td>
                                    </tr>
                                    <tr>
                                        <td><span>${adult} Người lớn</span></td>
                                        <td><b>X</b></td>
                                        <td style="text-align: right;">
                                            <b class="color-red">
                                                10%
                                            </b>
                                        </td>
                                        <td style="padding:0px;">=</td>
                                        <td style="text-align: right;">
                                            <b class="color-red tiketTotalA">
                                                ${ticketTotalAGo}
                                            </b>
                                        </td>
                                    </tr>
                                    <c:if test="${kid > 0}">
                                        <tr>
                                            <td><span>${kid} trẻ em</span></td>
                                            <td><b>X</b></td>
                                            <td style="text-align: right;">
                                                <b class="color-red">
                                                    10%
                                                </b>
                                            </td>
                                            <td style="padding:0px;">=</td>
                                            <td style="text-align: right;">
                                                <b class="color-red tiketTotalK">
                                                    ${ticketTotalKGo}
                                                </b>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <tr class="border-airline">
                                        <td colspan="5"></td>
                                    </tr>
                                    <tr>
                                        <td><span style="font-weight:bold">Hành Lý</span></td>
                                        <td colspan="4"><span> 
                                                <b class="color-red float-right valuehanhlyld">0,0 VND
                                                </b>
                                            </span></td>
                                    </tr>
                                    <tr class="border-airline">
                                        <td colspan="5"></td>
                                    </tr>
                                    <tr>
                                        <td><span style="font-weight:bold">Tổng giá</span></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td style="font-weight:bold; text-align:right"><span>
                                                <b class="color-red">
                                                    <input type="text" name="totalAmountGo" class="finalTotal" readonly style="max-width: 100px;">
                                                </b></span></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <script type="text/javascript">
            function myFunction() {
                var x = document.getElementById('myDIV');
                if (x.style.display === 'none') {
                    x.style.display = 'block';
                } else {
                    x.style.display = 'none';
                }
            }
        </script>
        <script src="./access/js/orderDetails.js"></script>
        <script>
            CaculatePrice("infoticketGO");
            function AlertPromotion(parameters) {
                if (parameters) {
                    alert("Promotion is not valid");
                }
            }
            AlertPromotion("${promotionInvalid}")
        </script>

        <script>
//            function validateDateKid(event) {
//                event.preventDefault(); // Ngăn chặn chuyển trang mặc định
//
//                var selectedDate = new Date(document.getElementById("birthdateKid").value);
//                var today = new Date();
//                var minDate = new Date();
//                minDate.setFullYear(today.getFullYear() - 11); // Giới hạn từ 11 tuổi trở lại
//                minDate.setDate(minDate.getDate() - 365 * 2); // Giới hạn từ 2 năm trước ngày hiện tại (không chính xác 730 ngày)
//
//                if (selectedDate < minDate || selectedDate > today) {
//                    alert("Vui lòng chọn ngày sinh trẻ em hợp lệ!");
//                    return false;
//                }
//
//                // Ngày sinh hợp lệ, cho phép chuyển trang
//                // document.getElementById("formId").submit(); // Gửi form
//                // window.location.href = "new-page.html"; // Chuyển trang
//
//                return true;
//            }
        </script>

        <script>
            function validateDateBaby() {
                var selectedDate = new Date(document.getElementById("birthdateBaby").value);
                var today = new Date();
                var minDate = new Date();
                minDate.setFullYear(today.getFullYear() - 2); // Giới hạn từ 2 tuổi trở lại
                minDate.setDate(minDate.getDate() + 1); // Giới hạn từ 1 ngày sau ngày hiện tại
                if (selectedDate < minDate || selectedDate > today) {
                    alert("Vui lòng chọn ngày sinh trẻ sơ sinh hợp lệ!");
                    return false;
                }
                return true;
            }
        </script>

        <script>
            function countdown() {
                var countDownDate = new Date();
                countDownDate.setMinutes(countDownDate.getMinutes() + 5); // Tăng thời gian lên

                var countdownTimer = setInterval(function () {
                    var now = new Date().getTime();
                    var distance = countDownDate - now;

                    if (distance < 0) {
                        clearInterval(countdownTimer);
                        showAlert();
                    } else {
                        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                        var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                        document.getElementById("countdown").innerHTML = minutes + " phút " + seconds + " giây";
                    }
                }, 1000);
            }

            function showAlert() {
                alert("Đã hết thời gian đặt vé, vui lòng trở về trang trước để chọn lại vé!")
                window.history.back();
            }

            // Gọi hàm countdown khi tải xong trang
            window.onload = countdown;
        </script>
        <script src="access/js/submit.js"></script>
    </body>
</html>
