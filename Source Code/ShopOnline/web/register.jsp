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
                    <h2>Register Account</h2>
                </div>

                <form action="register" method="POST" class="form" id="form-1">
                    <c:if test="${ms2 ne null}">
                        <p class="desc" style="color: red">${ms2}</p>
                    </c:if>
                    <div class="Set-pop">
                        <div class="options">
                            <input value="${username}" onkeyup="userName()"  id="user-name" type="text" name="username" placeholder="User Name" required>
                        </div>
                        <div class="options">
                            <div class="auth-actions">
                                <input value="${firstname}" onkeyup="firstName()" id="firstname" type="text" name="firstname" placeholder="First Name" required>
                                <input value="${middlename}" onkeyup="middleName()" id="middlename" type="text" name="middlename" placeholder="Middle Name" required>
                                <input value="${lastname}" onkeyup="lastName()" id="lastname" type="text" name="lastname" placeholder="Last Name" required>
                            </div>
                        </div>
                        <div class="options">
                            <input value="${phone}" onkeyup="Phone()" id="phone" type="tel" name="phone" placeholder="Phone" required>
                        </div>
                        <div class="options">
                            <input value="${email}" onkeyup="Email()" id="email" type="text" name="email" placeholder="Email" required>
                        </div>
                        <div class="options">
                            <input value="${password}" onkeyup="passWord()" id="password" type="password" name="password" placeholder="Password" required>
                            <i class="fa-regular fa-eye-slash showPass"></i>
                        </div>
                        <div class="options">
                            <input value="${password_confirmation}" onkeyup="password_Confirmation()" id="password_confirmation" type="password" name="password_confirmation" placeholder="Enter password again" required>
                            <i class="fa-regular fa-eye-slash showPass"></i>
                        </div>
                        <div class="save-pass">
                            <div id="genderdiv" class="auth-actions" >
                                <label class="save-pass-container">Male
                                    <input class="checkbox" id="gender1" name="gender" type="radio" value="1"  ${gender1}>
                                    <span class="radio-mark"></span>
                                </label>
                                <label class="save-pass-container">Female
                                    <input class="checkbox" id="gender0" name="gender" type="radio" value="0" ${gender0}>
                                    <span class="radio-mark"></span>
                                </label>
                            </div>

                        </div>
                        <div class="options" onclick="submitAccount()">
                            <input type="button" value="Go"  />
                        </div>
                        <div class="options-divider"></div>
                        <div class="options" style="text-align: center;">
                            <a href="login" style="font-size: 18px;">Login</a>
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
                    show[0].classList.replace("fa-eye-slash", "fa-eye");
                } else {
                    x.type = "password";
                    show[0].classList.replace("fa-eye", "fa-eye-slash");
                }
            };

            show[1].onclick = () => {
                if (y.type === "password") {
                    y.type = "text";
                    show[1].classList.replace("fa-eye-slash", "fa-eye");
                } else {
                    y.type = "password";
                    show[1].classList.replace("fa-eye", "fa-eye-slash");
                }
            };


        </script>
        <script>
            function userName() {
                var username = document.getElementById('user-name').value;
                if (!/^[a-z0-9]{8,16}$/.test(username)) {
                    document.getElementById('user-name').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('user-name').style.border = '1px solid #ccc';
                    return true;
                }
            }
            function firstName() {
                var firstname = document.getElementById('firstname').value;
                if (!/^[a-zA-Z ]+/.test(firstname)) {
                    document.getElementById('firstname').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('firstname').style.border = '1px solid #ccc';
                    return true;
                }
            }
            function lastName() {

                var lastname = document.getElementById('lastname').value;
                if (!/^[a-zA-Z ]+/.test(lastname)) {
                    document.getElementById('lastname').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('lastname').style.border = '1px solid #ccc';
                    return true;
                }
            }
            function middleName() {
                var middlename = document.getElementById('middlename').value;
                if (!/^[a-zA-Z ]+/.test(middlename)) {
                    document.getElementById('middlename').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('middlename').style.border = '1px solid #ccc';
                    return true;
                }
            }
            function Phone() {
                var phone = document.getElementById('phone').value;
                if (!/((09|03|07|08|05)+([0-9]{8})\b)/g.test(phone)) {
                    document.getElementById('phone').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('phone').style.border = '1px solid #ccc';
                    return true;
                }
            }
            function Email() {
                var email = document.getElementById('email').value;
                if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
                    document.getElementById('email').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('email').style.border = '1px solid #ccc';
                    return true;
                }
            }
            function passWord() {
                var password = document.getElementById('password').value;
                if (!/^([a-zA-Z0-9_]|.){8,}$/.test(password)) {
                    document.getElementById('password').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('password').style.border = '1px solid #ccc';
                    return true;
                }
            }
            function password_Confirmation() {
                var password_confirmation = document.getElementById('password_confirmation').value;
                var password = document.getElementById('password').value;
                if (!/^([a-zA-Z0-9_]|.){8,}$/.test(password_confirmation) || password_confirmation !== password) {
                    document.getElementById('password_confirmation').style.border = '1px solid red';
                    return false;
                } else {
                    document.getElementById('password_confirmation').style.border = '1px solid #ccc';
                    return true;
                }
            }

            function submitAccount() {
             
                var username = userName();
                var firstname = firstName();
                var middlename = middleName();
                var lastname = lastName();
                var phone = Phone();
                var email = Email();
                var password = passWord();
                var password_confirmation = password_Confirmation();
                var gender1 = document.getElementById('gender1').checked;
                var gender0 = document.getElementById('gender0').checked;
                if(gender0 === false && gender1 === false){
                    document.getElementById('genderdiv').style.borderBottom = '1px solid red';
                }
                if (username === false || firstname === false || middlename === false || lastname === false || phone ===  false || email === false || passWord === false || password_confirmation === false || gender1 === false && gender0 === false) {
                    alert("Please fill information!");


                } else{
                    document.getElementById('form-1').submit();
                }



            }
        </script>
    </body>
</html>