<%-- 
    Document   : loginEmployee
    Created on : Jun 15, 2023, 8:37:49 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dăng nhập</title>
        <link rel="stylesheet" href="access/css/loginEmployee.css"/>
    </head>
    <body>
        <form action="loginAdminServlet" method="post">
            <h1>Admin Đăng nhập</h1>
            <div class="inset">
                <p>
                    <label for="email">EMAIL</label>
                    <input type="text" name="email" id="email">
                </p>
                <p>
                    <label for="password">MẬT KHẨU</label>
                    <input type="password" name="password" id="password">
                </p>
                <p class="text-danger">${mess}</p>
                <p>
                    <input type="checkbox" name="remember" id="remember">
                    <label for="remember">Nhớ mật khẩu</label>
                </p>
            </div>
            <p class="p-container">
                <span>Quên mật khẩu ?</span>
                <input type="submit" name="go" id="go" value="Đăng nhập">
            </p>
        </form>
    </body>
</html>
