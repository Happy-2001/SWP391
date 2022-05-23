<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login and Register</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="main">
            <form action="login" method="POST" class="form" id="form-2">
                <h3 class="heading">Login</h3>
                <c:if test="${ms1 ne null}">
                    <p class="desc" style="color: red">${ms1}</p>
                </c:if>
                <div class="spacer"></div>
                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" name="email" type="text"  placeholder="VD: email@domain.com" class="form-control" value="">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input id="password" name="password" type="password" placeholder="Enter password" class="form-control" value="">
                    <span class="form-message"></span>
                    <label for="forgot" class="form-label-forgot"><a href="https://github.com/">Quên Mật Khẩu</a></label>
                </div>
                <button class="form-submit">Go</button>
                
            </form>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                Validator({
                    form: '#form-2',
                    formGroupSelector: '.form-group',
                    errorSelector: '.form-message',
                    rules: [
                        Validator.isEmail('#email'),
                        Validator.minLength('#password', 6),
                    ],
                });
            });
        </script>
        <!-- partial -->
        <script src="js/login.js"></script>

    </body>

</html>