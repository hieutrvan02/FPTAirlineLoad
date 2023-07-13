<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/createEmployee.css"/>
        <title>Create Employee</title>
        <script>
            function checkEmail() {
                var email = document.getElementById("email").value;
                var emails = "${emails}"; // Lấy danh sách email từ JSP
                if (emails.includes(email)) {
                    alert("Email đã tồn tại.");
                    document.getElementById("email").value = ""; // Xóa giá trị email
                    return false;
                }
                return true;
            }
            function checkPassword() {
                var password = document.getElementById("password").value;
                if (password.length < 6) {
                    alert("Mật khẩu phải ít nhất 6 ký tự.");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>

        <c:set var="emails" value="${requestScope.emails}" />
        <form action="CreateEmployeeServlet" method="post" onsubmit="return checkEmail() && checkPassword();">
            <div class="container">
                <div class="card">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="text" class="form-control" id="email" placeholder="Nhập email" name="emailPara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu:</label>
                                <input type="password" class="form-control" id="password" placeholder="Nhập mật khẩu" name="passwordPara" required>
                                <div class="invalid-feedback">Hãy nhập trường này.</div>
                            </div>

                            <div class="form-group form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" name="remember" required> Tôi xác nhận thông tin trên là đúng.
                                    <div class="invalid-feedback">Hãy nhấn xác nhận.</div>
                                </label>
                            </div>
                            <button type="submit" class="btn" style="color: white">Tạo</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>

    </body>
</html>
