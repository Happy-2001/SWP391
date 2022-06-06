<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register | Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/login.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
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
            <form action="">
                <div class="Set-pop">
                    <div class="options">
                        <input id="user-name" type="text" name="uname" placeholder="User Name" required>
                        <span class="form-message"></span>
                    </div>
                    <div class="options">
                        <div class="auth-actions">
                            <input id="full-name" type="text" name="firstname" placeholder="First Name" required>
                            <span class="form-message"></span>
                            <input id="full-name" type="text" name="middlename" placeholder="Middle Name">
                            <span class="form-message"></span>
                            <input id="full-name" type="text" name="lastname" placeholder="Last Name" required>
                            <span class="form-message"></span>
                        </div>
                    </div>
                    <div class="options">
                        <input id="phone" type="tel" name="phone" placeholder="Phone" required>
                        <span class="form-message"></span>
                    </div>
                    <div class="options">
                        <input id="email" type="text" name="email" placeholder="Email" required>
                        <span class="form-message"></span>
                    </div>
                    <div class="options">
                        <input id="password" type="password" name="password" placeholder="Password" required>
                        <i class="fa-regular fa-eye-slash showPass"></i>
                        <span class="form-message"></span>
                    </div>
                    <div class="options">
                        <input id="password_confirmation" type="password" name="password_confirmation" placeholder="Enter password again" required>
                        <i class="fa-regular fa-eye-slash showPass"></i>
                        <span class="form-message"></span>
                    </div>
                    <div class="save-pass">
                        <div class="auth-actions">
                            <label class="save-pass-container">Male
                                <input class="checkbox" name="gender" type="radio" value="1">
                                <span class="radio-mark"></span>
                            </label>
                            <label class="save-pass-container">Female
                                <input class="checkbox" name="gender" type="radio" value="0">
                                <span class="radio-mark"></span>
                            </label>
                        </div>
                    </div>
                    <div class="options">
                        <button class="opt-btn" type="submit" name="created">Go</button>
                    </div>
                    <div class="options-divider"></div>
                    <div class="options" style="text-align: center;">
                        <a href="#" style="font-size: 18px;">Login</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script>
        var x = document.getElementById("password"),
            y = document.getElementById("password_confirmation");
        const show = document.querySelectorAll(".showPass");
        
        show[0].onclick = () => {     
            if (x.type === "password") {
                x.type = "text";
                show[0].classList.replace("fa-eye-slash","fa-eye");
            } else {
                x.type = "password";
                show[0].classList.replace("fa-eye","fa-eye-slash");
            }
        };

        show[1].onclick = () => {     
            if (y.type === "password") {
                y.type = "text";
                show[1].classList.replace("fa-eye-slash","fa-eye");
            } else {
                y.type = "password";
                show[1].classList.replace("fa-eye","fa-eye-slash");
            }
        };
    </script>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        Validator({
            form: '#form-1',
            formGroupSelector: '.form-group',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired('#fullname', 'Enter your fullname'),
                Validator.isEmail('#email'),
                Validator.minLength('#password', 6),
                Validator.minLength('#username', 6),
                Validator.isRequired('#password_confirmation'),
                Validator.isConfirmed('#password_confirmation', function () {
                    return document.querySelector('#form-1 #password').value;
                }, 'Mật khẩu nhập lại không chính xác')
            ]
        });
    });
</script>
</body>

</html>