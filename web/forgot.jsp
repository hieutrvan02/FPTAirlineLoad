<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đổi mất khẩu</title>
        <link rel="stylesheet" href="access/css/login.css">
    </head>

    <body>

        <p class="tip">Click on button in image container</p>
        <div class="cont">
            <form action="changepassword" method="post">
                <div class="form sign-in">
                    <h2>Quên mật khẩu</h2>
                    <label>
                        <p class="text-danger">${mess}</p>
                        <span>Email</span>
                        <input type="email" name="email"/>
                        <label>
                            <span>Mật khẩu mới</span>
                            <input type="password" name="new_pass"/>
                        </label>
                        <label>
                            <span>Nhập lại mật khẩu</span>
                            <input type="password" name="password_confirmation"/>
                        </label>
                    </label>
                    <button type="submit" class="submit">Xác nhận</button>
                </div>
            </form>   

            <div class="sub-cont">
                <div class="img">
                    <div class="img__text m--up">
                        <h2>New here?</h2>
                        <p>Sign up and discover great amount of new opportunities!</p>
                    </div>
                    <div class="img__text m--in">
                        <h2>One of us?</h2>
                        <p>If you already has an account, just sign in. We've missed you!</p>
                    </div>
                    <div class="img__btn">
                        <span class="m--up">Sign Up</span>
                        <span class="m--in">Sign In</span>
                    </div>
                </div>

                <div class="form sign-up">
                    <h2>Time to feel like home,</h2>
                    <label>
                        <span>Name</span>
                        <input type="text" />
                    </label>
                    <label>
                        <span>Email</span>
                        <input type="email" />
                    </label>
                    <label>
                        <span>Password</span>
                        <input type="password" />
                    </label>
                    <button type="submit" class="submit">Sign Up</button>
                    <button type="button" class="fb-btn">Join with <span>facebook</span></button>
                </div>
            </div>
        </div>

        <a href="https://dribbble.com/shots/3306190-Login-Registration-form" target="_blank" class="icon-link">
            <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/256/Dribbble-icon.png">
        </a>
        <a href="https://twitter.com/NikolayTalanov" target="_blank" class="icon-link icon-link--twitter">
            <img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png">
        </a>

        <script src="access/js/login.js"></script>

    </body>
</html>