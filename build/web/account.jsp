<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/account.css"/>
    </head>
    <body>
        <c:set var="user" value="${requestScope.user}" />
        <script>
            // Lấy mật khẩu từ thông tin cá nhân
            var password = "${user.getPassword()}";
            // Độ dài của mật khẩu
            var passwordLength = password.length;
            // Tạo chuỗi dấu sao đại diện
            var maskedPassword = "*".repeat(passwordLength);

            // Gán chuỗi dấu sao đại diện vào phần tử hiển thị mật khẩu
            document.addEventListener("DOMContentLoaded", function () {
                var passwordElement = document.getElementById("password");
                passwordElement.textContent = maskedPassword;
            });
        </script>
        <div class="container" style="margin-top: 150px"> 
            <div class="row">
                <div class="col-12 col-lg-4">
                    <div class="card custom-card">
                        <div class="row card-header" style="margin-left: 0; margin-right: 0"> 
                            <div class="col-6 col-lg-12"><a href="#">
                                    <div class="row" style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3" style="padding: 0;color: white"><i class="fas fa-info-circle"></i></div>
                                        <div class="col-12 col-lg-9 title" style="padding: 0;color: white"> Tài khoản của tôi</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="PersonalServlet">
                                    <div class="row" style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3"style="padding: 0;color: white"><i class="fas fa-id-badge"></i></div>
                                        <div class="col-12 col-lg-9 title"style="padding: 0;color: white"> Thông tin cá nhân</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="viewHistoryServlet">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3" style="padding: 0;color: white"><i class="fa fa-history"></i></div>
                                        <div class="col-12 col-lg-9 title" style="padding: 0;color: white"> Lịch sử đặt vé</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="/FPT/cancelTicket.jsp">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3" style="padding: 0;color: white"><i class="fa fa-ban"></i></div>
                                        <div class="col-12 col-lg-9 title" style="padding: 0;color: white"> Hủy vé</div>
                                    </div>
                                </a></div>
                            <div class="col-6 col-lg-12"><a href="lookUpFlight.jsp">
                                    <div class="row"style="margin-bottom:5px; margin-top: 5px">
                                        <div class="col-12 col-lg-3" style="padding: 0;color: white"><i class="fa fa-search"></i></div>
                                        <div class="col-12 col-lg-9 title" style="padding: 0;color: white"> Tra cứu chuyến bay</div>
                                    </div>
                                </a></div> 
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-8">
                    <div class="card custom-card">
                        <div class=" card-header">
                            <div class=" title">Tài khoản</div>
                        </div>
                        <div class="row custom-card-item">
                            <div class="col-4"><i class="fas fa-id-card fa-fw"></i> ID</div>
                            <div class="col-8 custom-information">${user.getUserID()}</div>
                        </div>
                        <div class="row custom-card-item">
                            <div class="col-4"><i class="fas fa-phone-volume fa-fw"></i> Số điện thoại</div>
                            <div class="col-8 custom-information">${user.getPhone()}</div>
                        </div>
                        <div class="row custom-card-item">
                            <div class="col-4"><i class="fas fa-mail-bulk fa-fw"></i> Email</div>
                            <div class="col-8 custom-information">${user.getEmail()}</div>
                        </div>
                        <div class="row custom-card-item">
                            <div class="col-4"><i class="fas fa-lock fa-fw"></i> Mật khẩu</div>
                            <div class="col-8 custom-information" id="password"></div>
                        </div>
                        <div class="row custom-card-item">
                            <div class="col-4"></div>
                            <div class="col-8 custom-information"><a href="UpdatePasswordServlet"><i class="fas fa-edit fa-fw"></i><span class="title"> Đổi mã pin</span></a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
