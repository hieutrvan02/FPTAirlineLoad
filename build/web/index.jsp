<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FPTAirLine</title>
        <link rel="stylesheet" href="Styles/styles.css">
        <link rel="stylesheet" href="Font/themify-icons/themify-icons.css">

        <!--  -->

        <link href="Styles/reset-css.css" rel="stylesheet" type="text/css"/>
        <link href="Styles/jquery-ui-1.8.7.all.css" rel="stylesheet" type="text/css"/>
        <link href="Styles/SearchView.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="Scripts/jquery-1.7.1.min.js"></script>
    </head>


    <body>
        <div id="slider">
            <form class="form-flight" action="SearchFlightServlet" method="post">
                <div class="container">
                    <div class="MainColumn">
                        <script src="Scripts/jquery-ui.js" type="text/javascript"></script>
                        <div class="SearchBox">
                            <h2 align="center">Đặt Vé Máy Bay</h2>
                            <div class="contentSearchBox">
                                <table width="100%">
                                    <div align="center">
                                        <input name="flight" type="radio" value="1" onclick="undisable()" checked> Khứ hồi
                                        <input name="flight" type="radio" value="2" onclick="disable()"> Một chiều
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <span>Điểm đi</span>
                                        </td>
                                        <td colspan="2">
                                            <span>Điểm đến</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <label>
                                                <select name="departure" class="Des">
                                                    <option value="Hà Nội">(HAN)Hà Nội</option>
                                                    <option value="Hồ Chí Minh">(SGN)Hồ Chí Minh</option>
                                                    <option value="Đà Nẵng">(DAD)Đà Nẵng</option>
                                                    <option value="Nha Trang">(CXR)Nha Trang</option>
                                                    <option value="Đà Lạt">(DLI)Đà Lạt</option>
                                                    <option value="Hải Phòng">(HPH)Hải Phòng</option>
                                                    <option value="Vinh">(VII)Vinh</option>
                                                    <option value="Thanh Hóa">(THD)Thanh Hóa</option>
                                                    <option value="Tam Điệp">(VCL)Tam Điệp</option>
                                                    <option value="Vân Đồn">(VDO)Vân Đồn</option>
                                                    <option value="Quy Nhơn">(UIH)Quy Nhơn</option>
                                                    <option value="Pleiku">(PXU)Pleiku</option>
                                                    <option value="Buôn Mê Thuột">(BMV)Buôn Mê Thuột</option>
                                                    <option value="Đồng Hới">(VDH)Đồng Hới</option>
                                                    <option value="Tuy Hòa">(TBB)Tuy Hòa</option>
                                                    <option value="Cần Thơ">(VCA)Cần Thơ</option>
                                                    <option value="Cà Mau">(CAH)Cà Mau</option>
                                                    <option value="Phú Quốc">(PQC)Phú Quốc</option>
                                                </select>
                                            </label>
                                        </td>
                                        <td colspan="2">
                                            <label>
                                                <select name="destination" class="Des">
                                                    <option value="Hà Nội">(HAN)Hà Nội</option>
                                                    <option value="Hồ Chí Minh">(SGN)Hồ Chí Minh</option>
                                                    <option value="Đà Nẵng">(DAD)Đà Nẵng</option>
                                                    <option value="Nha Trang">(CXR)Nha Trang</option>
                                                    <option value="Đà Lạt">(DLI)Đà Lạt</option>
                                                    <option value="Hải Phòng">(HPH)Hải Phòng</option>
                                                    <option value="Vinh">(VII)Vinh</option>
                                                    <option value="Thanh Hóa">(THD)Thanh Hóa</option>
                                                    <option value="Tam Điệp">(VCL)Tam Điệp</option>
                                                    <option value="Vân Đồn">(VDO)Vân Đồn</option>
                                                    <option value="Quy Nhơn">(UIH)Quy Nhơn</option>
                                                    <option value="Pleiku">(PXU)Pleiku</option>
                                                    <option value="Buôn Mê Thuột">(BMV)Buôn Mê Thuột</option>
                                                    <option value="Đồng Hới">(VDH)Đồng Hới</option>
                                                    <option value="Tuy Hòa">(TBB)Tuy Hòa</option>
                                                    <option value="Cần Thơ">(VCA)Cần Thơ</option>
                                                    <option value="Cà Mau">(CAH)Cà Mau</option>
                                                    <option value="Phú Quốc">(PQC)Phú Quốc</option>
                                                </select>
                                            </label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <span class="text">Ngày đi</span>
                                        </td>
                                        <td colspan="2">
                                            <span>Ngày về</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="34%">
                                            <label>
                                                <input name="startDate" id="datepicker1" width="276"
                                                       placeholder="YYYY-MM-DD" required/>
                                            </label>
                                        </td>
                                        <td width="16%">
                                        </td>
                                        <td width="33%">
                                            <label>
                                                <input name="endDate" id="datepicker2" width="276"
                                                       placeholder="YYYY-MM-DD"required/>
                                            </label>
                                        </td>
                                    </tr>
                                </table>
                                <table width="100%" style="margin-top:10px;">
                                    <tr>
                                        <td width="36%">
                                            Người lớn
                                            <br/>
                                            <span>(&gt;12 tuổi)</span>
                                        </td>
                                        <td width="32%" va>
                                            Trẻ em
                                            <br/>
                                            <span>(2-11 tuổi)</span>
                                        </td>
                                        <td width="32%">
                                            Em bé
                                            <br/>
                                            <span>(&lt;2 tuổi)</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>
                                                <select name="adult" class="Per">
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                </select>
                                            </label>
                                        </td>
                                        <td>
                                            <label>
                                                <select name="kid" class="Per">
                                                    <option value="0">0</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                </select>
                                            </label>
                                        </td>
                                        <td>
                                            <label>
                                                <select name="baby" class="Per">
                                                    <option value="0">0</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                </select>
                                            </label>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div align="center" class="button-search">
                                <input type="submit" value="Search flight" class="searchBtn"/>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>


        <div id="footer">
            <div class="footer-item">
                <div class="footer-item-about">
                    <p class="footer-item-title">FPT Airline</p>
                    <li><a href="">Giới thiệu công ty</a></li>
                    <li><a href="">Đối tác</a></li>
                    <li><a href="">Thông tin truyền thông</a></li>
                    <li><a href="">Trách nhiệm xã hội</a></li>
                </div>

                <div class="footer-item-law">
                    <p class="footer-item-title">Pháp Lý</p>
                    <li><a href="">Các điều kiện và điều khoản</a></li>
                    <li><a href="">Điều lệ vận chuyển</a></li>
                    <li><a href="">Điều kiện sử dụng Cookies</a></li>
                    <li><a href="">Bảo mật thông tin</a></li>
                </div>
                <div class="footer-item-help">
                    <p class="footer-item-title">Hỗ Trợ</p>
                    <li><a href="">Trung tâm trợ giúp</a></li>
                    <li><a href="">Góp ý dịch vụ</a></li>
                    <li><a href="">Chính sách bảo vệ khách hàng</a></li>
                    <li><a href="">Liên hệ chi nhánh của FPTAirline</a></li>
                </div>
                <div class="footer-item-info">
                    <p class="footer-item-title">Liên Hệ Với Chúng Tôi</p>
                    <div class="footer-item-info-icon">
                        <a href=""><img src="access/Icon/facebook.png" alt=""></a>
                        <a href=""><img src="access/Icon/twitter.png" alt=""></a>
                        <a href=""><img src="access/Icon/youtube.png" alt=""></a>
                        <a href=""><img src="access/Icon/zalo.png" alt=""></a>
                    </div>

                    <div class="footer-item-info-list">
                        <p><i class="ti-mobile"></i> Trung tâm chăm sóc khách hàng Hotline (24/7): 1900 1000</p>
                        <p><i class="ti-home"></i> Khu Đô Thị FPT Đà Nẵng, P. Hòa Hải, Q.Ngũ Hành Sơn, TP Đà Nẵng</p>
                        <p><i class="ti-email"></i> Telesales@fptairlines.com</p>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script>
        var date = $('#datepicker1').datepicker({dateFormat: 'yy-mm-dd'}).val();
        var date = $('#datepicker2').datepicker({dateFormat: 'yy-mm-dd'}).val();

        function disable() {
            document.getElementById("datepicker2").disabled = true;
        }

        function undisable() {
            document.getElementById("datepicker2").disabled = false;
        }

        function resetDate() {
            document.getElementById("datepicker2").reset();
        }


    </script>
    <script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>


</html>