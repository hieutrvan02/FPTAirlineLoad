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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="./css/payment.css"/>
    </head>
    <body>
        <div class="container" style="margin-top: 150px">
            <div id="accordion">
                <div class="card">
                    <div class="card-header">
                        <a class="card-link" data-toggle="collapse" href="#collapseOne" >
                            Lấy vé trực tiếp tại FPT Airlines
                        </a>
                    </div>
                    <div id="collapseOne" class="collapse show" data-parent="#accordion">
                        <div class="card-body">
                            Khu đô thị FPT City, Ngũ Hành Sơn, Đà Nẵng 550000
                            <a href="BillServlet" class="btn btn-info" role="button">Thanh toán trực tiếp</a>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
                            Phương thức thanh toán
                        </a>
                    </div>
                    <div id="collapseTwo" class="collapse" data-parent="#accordion">
                        <div class="card-body">
                            <div style="font-style: italic">
                                Quý khách chuyển tiền với nội dung: Họ tên không dấu_Số điện thoại (Ví dụ: VANVIETTHIENKIM_0708368007 )
                            </div>
                            <hr style="border-width: 1px; border-style: solid; border-color: #F44D06">
                            <div class="row">
                                <div class="col-2">
                                    <img src="./Img/VCBLogo.jpg"/>
                                </div>
                                <div class="col-5">
                                    <span>Ngân hàng Vietcombank</span>
                                    <div class="row">
                                        <div class="col-6">Chủ tài khoản:</div>
                                        <div class="col-6">Văn Viết Thiên Kim</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6">Số tài khoản:</div>
                                        <div class="col-6">0161001761257</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6">Chi nhánh:</div>
                                        <div class="col-6">Thừa Thiên Huế</div>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <img src="./Img/VCB_QR.jpg"/>
                                </div>
                                <div class="col-2">
                                    <a href="BillServlet" class="btn btn-info" role="button">Chọn</a>
                                </div>
                            </div>
                            <hr style="border-width: 1px; border-style: solid; border-color: #F44D06">
                            <div class="row">
                                <div class="col-2">
                                    <img src="./Img/Techcombank_Logo.png"/>
                                </div>
                                <div class="col-5">
                                    <span>Ngân hàng Techcombank</span>
                                    <div class="row">
                                        <div class="col-6">Chủ tài khoản:</div>
                                        <div class="col-6">Văn Viết Thiên Kim</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6">Số tài khoản:</div>
                                        <div class="col-6">19070531900013</div>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <img src="./Img/Tech_QR.jpg"/>
                                </div>
                                <div class="col-2">
                                    <a href="BillServlet" class="btn btn-info" role="button">Chọn</a>
                                </div>
                            </div>
                            <hr style="border-width: 1px; border-style: solid; border-color: #F44D06">
                            <div class="row">
                                <div class="col-2">
                                    <img src="./Img/MoMo_Logo.png"/>
                                </div>
                                <div class="col-5">
                                    <span>Ví điện tử Momo</span>
                                    <div class="row">
                                        <div class="col-6">Chủ tài khoản:</div>
                                        <div class="col-6">Văn Viết Thiên Kim</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6">Số tài khoản:</div>
                                        <div class="col-6">0708368007</div>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <img src="./Img/Momo_QR.jpg">
                                </div>
                                <div class="col-2">
                                    <a href="BillServlet" class="btn btn-info" role="button">Chọn</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
