<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login and Register</title>
        <link rel="stylesheet" href="css/login.css">
        <!-- Bootstrap 5 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="main">
            <form action="register" method="POST" class="form" id="form-1">
                <h3 class="heading">Register</h3>
                <c:if test="${ms2 ne null}">
                    <p class="desc" style="color: red">${ms2}</p>
                </c:if>
                <div class="spacer"></div>


                <div class="form-group">
                    <label for="username" class="form-label">Username</label>
                    <input id="username" name="username" type="text" placeholder="Enter username" class="form-control">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="fullname" class="form-label">First name</label>
                    <input id="fullname" name="firstname" type="text" placeholder="VD: Nguyen" class="form-control">
                    <span class="form-message"></span>
                </div>
                
                <div class="form-group">
                    <label for="fullname" class="form-label">Middle name</label>
                    <input id="fullname" name="middlename" type="text" placeholder="VD:Van" class="form-control">
                    <span class="form-message"></span>
                </div>
                
                <div class="form-group">
                    <label for="fullname" class="form-label">Last name</label>
                    <input id="fullname" name="lastname" type="text" placeholder="VD:A" class="form-control">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="phone" class="form-label">Phone</label>
                    <input id="phone" name="phone" type="text" placeholder="VD: 0987654321" class="form-control">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" name="email" type="text" placeholder="VD: email@domain.com" class="form-control">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input id="password" name="password" type="password" placeholder="Enter password" class="form-control">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="password_confirmation" class="form-label">Enter password again</label>
                    <input id="password_confirmation" name="password_confirmation" placeholder="Reenter password" type="password"
                           class="form-control">
                    <span class="form-message"></span>
                </div>

                <div class="form-control">
                    <label for="gender_confirmation" class="form-label">Gender: </label>
                    <input id="gender_confirmation" name="gender" type="radio" value="1"> Male
                    <input id="gender_confirmation" name="gender" type="radio" value="0"> Female
                </div>

                <button type="submit" class="form-submit">GO</button>
            </form>

        </div>

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
        <!-- partial -->
        <script src="js/login.js"></script>

    </body>

</html>