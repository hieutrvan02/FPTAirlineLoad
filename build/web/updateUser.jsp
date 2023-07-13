<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/updateUser.css"/>
        <title>Update Information</title>
        <script>
            function validateDate(inputDate) {
                var regex = /^\d{4}-\d{2}-\d{2}$/; // Regex pattern for date format (YYYY-MM-DD)
                if (!regex.test(inputDate)) {
                    alert("Sai định dạng. Hãy nhập ngày sinh theo định dạng \"Năm-Tháng-Ngày\"");
                    return false;
                }
                var year = inputDate.split("-")[0];
                var month = inputDate.split("-")[1];
                var day = inputDate.split("-")[2];
                var dateObject = new Date(year, month - 1, day);

                // Kiểm tra ngày không được lớn hơn ngày hiện tại
                var currentDate = new Date();
                if (dateObject > currentDate) {
                    alert("Ngày sinh không thể lớn hơn ngày hiện tại");
                    return false;
                }

                if (
                        dateObject.getFullYear() != year ||
                        dateObject.getMonth() + 1 != month ||
                        dateObject.getDate() != day
                        ) {
                    alert("Sai định dạng. Hãy nhập ngày sinh theo định dạng \"Năm-Tháng-Ngày\"");
                    return false;
                }
                return true;
            }
            function validatePhoneNumber(phoneNumber) {
                var regex = /^0\d{9}$/; // Regex pattern for 10-digit phone number starting with 0
                if (!regex.test(phoneNumber)) {
                    alert("Số điện thoại không hợp lệ. Hãy nhập số điện thoại gồm 10 số và bắt đầu bằng số 0.");
                    return false;
                }
                return true;
            }

            function validateCCCD(cccd) {
                var regex = /^\d{12}$/; // Regex pattern for 12-digit CCCD number
                if (!regex.test(cccd)) {
                    alert("Căn cước công dân không hợp lệ. Hãy nhập căn cước công dân gồm 12 số.");
                    return false;
                }
                return true;
            }
            function validateForm() {
                var birthdayInput = document.getElementById("birthday");
                if (!validateDate(birthdayInput.value)) {
                    birthdayInput.focus();
                    return false;
                }
                var phoneNumberInput = document.getElementById("phone");
                if (!validatePhoneNumber(phoneNumberInput.value)) {
                    phoneNumberInput.focus();
                    return false;
                }

                var cccdInput = document.getElementById("cccd");
                if (!validateCCCD(cccdInput.value)) {
                    cccdInput.focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <c:set var="user" value="${requestScope.user}" />
        <!--        <div class="container" >-->
        <form action="UpdateInformationServlet" method="post" class="was-validated" onsubmit="return validateForm();">
            <div class="container" style="margin-top: 150px">
                <div class="card">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="name">Họ và tên:</label>
                                <input type="text" class="form-control" id="name" value="${user.getName()}" placeholder="Nhập họ và tên" name="namePara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>
                            <div class="form-group">
                                <label for="birthday">Ngày sinh:</label>
                                <input type="text" class="form-control" id="birthday" value="${user.getBirthday()}" placeholder="Nhập ngày sinh(Năm-Tháng-Ngày)" name="birthdayPara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>
                            <div class="form-group">
                                <label for="cccd">Căn cước công dân:</label>
                                <input type="text" class="form-control" id="cccd" value="${user.getCccd()}"placeholder="Nhập căn cước công dân" name="cccdPara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>
                            <div class="form-group">
                                <label for="cccd">Quốc tịch:</label>
                                <input type="text" class="form-control" id="nationality" value="${user.getNationality()}" placeholder="Nhập quốc tịch" name="nationalityPara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>
                            <div class="form-group">
                                <label for="phone">Số điện thoại:</label>
                                <input type="text" class="form-control" id="phone" value="${user.getPhone()}" placeholder="Nhập số điện thoại" name="phonePara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>
                            <div class="form-group">
                                <label for="address">Địa chỉ:</label>
                                <input type="text" class="form-control" id="address" value="${user.getAddress()}" placeholder="Nhập địa chỉ" name="addressPara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>
                            <div class="form-group form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" name="remember" required> Tôi xác nhận thông tin trên là đúng.
                                    <div class="invalid-feedback">Hãy nhấn xác nhận.</div>
                                </label>
                            </div>
                            <button type="submit" class="btn" style="color: white">Cập nhật</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--    </div>-->
    </body>
</html>
