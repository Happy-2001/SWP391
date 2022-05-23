<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/fontAwesome.js"></script>

    <!-- Bootstrap 5 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
    <div class="Popup" id="myModal">
        <div class="Popup-body">
            <div class="Pop-title">
                <h2>Login</h2>
            </div>
            <form action="login" method="POST">
                <div class="Set-pop">
                    <c:if test="${ms1 ne null}">
                        <p class="alert alert-danger">${ms1}</p>
                    </c:if>
                    <div class="options">
                        <input id="user-name" type="text" name="email" placeholder="Email" required>
                    </div>
                    <div class="options">
                        <input id="user-pass" type="password" name="password" placeholder="Password" required>
                        <i class="fa-regular fa-eye-slash showPass"></i>
                    </div>
                    <div class="save-pass">
                        <label class="save-pass-container">Remember password
                            <input type="checkbox" name="remember">
                            <span class="checkmark"></span>
                        </label>
                    </div>
                    <div class="options">
                        <button class="opt-btn" type="submit" name="created">Go</button>
                    </div>
                    <div class="options-divider"></div>
                    <div class="options">
                        <div class="auth-actions">
                            <a href="register">Register a new account</a>
                            <a href="#">Forgot password?</a>
                        </div>    
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script>
        var x = document.getElementById("user-pass");
        var show = document.querySelector(".showPass");
        show.onclick = () => {     
            if (x.type === "password") {
                x.type = "text";
                show.classList.replace("fa-eye-slash","fa-eye");
            } else {
                x.type = "password";
                show.classList.replace("fa-eye","fa-eye-slash");
            }
        };
        document.addEventListener('DOMContentLoaded', function () {
            Validator({
                form: '#form-2',
                formGroupSelector: '.form-group',
                errorSelector: '.form-message',
                rules: [
                    Validator.isEmail('#email'),
                    Validator.minLength('#password', 6)
                ]
            });
        });
    </script>
</body>
</html>