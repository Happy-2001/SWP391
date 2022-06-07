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
            <form action="changepassword" method="POST" class="form" id="form-2">
                <input type="hidden" name="userid" value="${sessionScope.userlogged.userid}">
                <h3 class="heading">Change PassWord</h3>
                <c:if test="${ms1 ne null}">
                    <p class="desc" style="color: red">${ms1}</p>
                </c:if>
                <div class="spacer"></div>
                <div class="form-group">
                    <label for="email" class="form-label">UserName</label>
                    <input id="email" name="username" type="text" value="${sessionScope.userlogged.username}" class="form-control">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Old Password</label>
                    <input id="password" name="oldpassword" type="password" placeholder="Enter old password" class="form-control">
                    <span class="form-message"></span>
                </div> 
                <div class="form-group">
                    <label for="password" class="form-label">New Password</label>
                    <input id="newpasswords" name="newpasswords" type="password" placeholder="Enter new password" class="form-control">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Re - New Password</label>
                    <input name="confirm_password" id="confirm_password" onkeyup="checkPass();" type="password"  placeholder="Enter Re-password" class="form-control">
                    <span id="pass" style="color: red" class="form-message"></span>
                </div>
                <button type="submit" id="submit" class="form-submit">Save</button>
            </form>
        </div>

        <script> function checkPass() {
                var pass = document.getElementById("newpasswords").value;
                var rpass = document.getElementById("confirm_password").value;
                if (pass != rpass) {
                    document.getElementById("submit").disabled = true;

                    document.getElementById("pass").innerHTML = "Entered Password is not matching!! Try Again";
                } else {
                    document.getElementById("pass").innerHTML = "";
                    document.getElementById("submit").disabled = false;
                }
            }</script>
        <script src="js/login.js"></script>

    </body>

</html>