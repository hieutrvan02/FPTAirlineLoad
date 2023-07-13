<%-- 
    Document   : SignUp
    Created on : May 17, 2023, 7:10:20 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./access/css/login.css"/>
    </head>


    <body>
        <p class="tip">Click on button in image container</p>
        <div class="cont">
            <form action="login" method="post" id="login-form">
                <div class="form sign-in">
                    <h2>Đăng nhập</h2>
                    <label class="form-group">
                        <span>Email</span>
                        <input id="login-email" type="email" name="login-email"/>
                        <span class="form-message"></span>
                    </label>
                    <label class="form-group">
                        <span>Mật khẩu</span>
                        <input id="login-pass" type="password" name="login-pass"/>
                        <span class="form-message"></span>
                    </label>
                    <div class="group">
                        <input id="check" type="checkbox" class="check">
                        <label for="check" class="remember">Ghi nhớ đăng nhập</label>
                    </div>
                    <label>
                        <!--                        <a class="forgot-pass" href="forgot.jsp">Quên mật khẩu?</a>-->
                        <p class="text-danger">${mess}</p>
                    </label>
                    <button type="submit" class="submit">Đăng nhập</button>
                </div>
            </form>   
            <div class="sub-cont">
                <div class="img">
                    <div class="img__text m--up">
                        <h2>Bạn là người mới?</h2>
                        <p>Hãy đăng kí và khám phá những chuyến bay thú vị cùng chúng tôi nào!</p>
                    </div>
                    <div class="img__text m--in">
                        <h2>Bạn đã đăng kí?</h2>
                        <p>Nếu bạn đã có tài khoản, đăng nhập nào!</p>
                    </div>
                    <div class="img__btn">
                        <span class="m--up">Đăng kí</span>
                        <span class="m--in">Đăng nhập</span>
                    </div>
                </div>
                <form action="SignUpServlet" method="post" id="register-form">
                    <div class="form sign-up">
                        <h2>Đồng hành cùng những chuyến đi,</h2>
                        <label class="form-group">
                            <span>Tên</span>
                            <input id="fullname" type="text" name="fullName"/>
                            <span class="form-message"></span>
                        </label>
                        <label class="form-group">
                            <span>Email</span>
                            <input id="email" type="email" name="email"/>
                            <span class="form-message"></span>
                        </label>
                        <label class="form-group">
                            <span>Mật khẩu</span>
                            <input id="password" type="password" name="pass"/>
                            <span class="form-message"></span>
                        </label>
                        <label class="form-group">
                            <span>Nhập lại mật khẩu</span>
                            <input id="password_confirmation" type="password" name="password_confirmation"/>
                            <span class="form-message"></span>

                        </label>
                        <button type="submit" class="submit">Đăng ký</button>
                    </div>
                </form>
            </div>
        </div>
        <script src="./access/js/login.js"></script>
        <script src="./access/js/validator.js"></script>
        <script>
            //Alert
            function displayErrorMessage(mess) {
                if (mess === "Exist") {
                    alert("Tài khoản đã tồn tại");
                } else if (mess === "Success") {
                    alert("Đăng ký tài khoản thành công");
                }
            }
            
            displayErrorMessage("${mess1}")
            
            // Validate
            Validator({
                form: '#register-form',
                formGroupSelector: '.form-group',
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#fullname'),
                    Validator.isRequired('#email'),
                    Validator.isEmail('#email'),
                    Validator.minLength('#password', 6),
                    Validator.isRequired('#password_confirmation'),
                    Validator.isConfirmed('#password_confirmation', function () {
                        return document.querySelector('#register-form #password').value;
                    }, 'Mật khẩu nhập lại không chính xác')
                ]
            })
            Validator({
                form: '#login-form',
                formGroupSelector: '.form-group',
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#login-email'),
                    Validator.isEmail('#login-email'),
                    Validator.isRequired('#login-pass')
                ]
            })
        </script>
    </body>
</html>
