<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile | Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/profile.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/fontAwesome.js"></script>

    <!-- Bootstrap 5 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
    <%@include file="topbar.jsp" %>
    <%@include file="header.jsp" %>    
        
    <!-- Profile -->
    <div class="profile">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <div class="image">
                                <img src="RetrieveImg?eaID=${sessionScope.user.userid}" alt="avatar">
                                <span class="edit-box">
                                    <i id="myBtn" class="fa-regular fa-pen-to-square edit-icon"></i>
                                </span>
                                <div class="Popup-img" id="myModal">
                                    <span class="close">&times;</span>
                                    <form action ="UploadImage" method="POST" enctype="multipart/form-data">
                                        <div class="Popup-body">
                                            <div class="Set-pop">
                                                <label for="up-img">Choose file:</label>
                                                <input type="file" name="photo" id="up-img" size="50">
                                                <div class="options">
                                                    <input type="hidden" name="eaID" value="${sessionScope.user.userid}">
                                                    <input type="submit" value="Save">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <h4 class="pt-3">${sessionScope.user.fullname}</h4>
                        </div>
                    </div>
                    <div class="why-text">
                        <button id="myBtn" class="btn"><i class="fa-regular fa-pen-to-square"></i> Edit Profile</button>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="card shadow-sm">
                        <div class="card-header bg-transparent border-0">
                            <div class="title">
                                <h4>Personal information</h4>
                                <i class="fa-regular fa-clone fa-lg"></i> 
                            </div>
                        </div>
                        <div class="card-body pt-0">
                            <table class="table table-bordered">
                                <tr>
                                    <th width="30%">ID</th>
                                    <td width="2%">:</td>
                                    <td><h7>${sessionScope.user.userid}</h7></td>
                                </tr>
                                <tr>
                                    <th width="30%">Name</th>
                                    <td width="2%">:</td>
                                    <td><h7>${sessionScope.user.firstname} ${sessionScope.user.middlename} ${sessionScope.user.lastname}</h7></td>
                                </tr>
                                <tr>
                                    <th width="30%">Phone</th>
                                    <td width="2%">:</td>
                                    <td><h7>${sessionScope.user.phone}</h7></td>
                                </tr>
                                <tr>
                                    <th width="30%">Email</th>
                                    <td width="2%">:</td>
                                    <td><h7>${sessionScope.user.email}</h7></td>
                                </tr>
                                <tr>
                                    <th width="30%">Gender</th>
                                    <td width="2%">:</td>
                                    <td><h7> <c:if test="${sessionScope.user.gender == 1}">
                                        Male
                                    </c:if>
                                    <c:if test="${sessionScope.user.gender == 0}">
                                        Female
                                    </c:if></h7></td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <div class="card shadow-sm mt-3">
                        <div class="card-header bg-transparent border-0">
                            <div>
                                <h4>Account</h4>
                            </div>
                        </div>
                        <div class="card-body pt-0">
                            <table class="table table-bordered">
                                <tr>
                                    <th width="30%">ID</th>
                                    <td width="2%">:</td>
                                    <td><h7>${sessionScope.user.userid}</h7></td>
                                </tr>
                                <tr>
                                    <th width="30%">User Name</th>
                                    <td width="2%">:</td>
                                    <td><h7>${sessionScope.user.username}</h7></td>
                                </tr>
                                <tr>
                                    <th width="30%">Password</th>
                                    <td width="2%">:</td>
                                    <td><h7>${sessionScope.user.password}</h7></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end profile -->

    <!-- Edit Profile -->
    <div class="Popup" id="myModal">
        <span class="close">&times;</span>
        <div class="container Popup-body">
            <div class="Pop-title">
                <h3>Edit Profile</h3>
            </div>
            <div class="options-divider"></div>
            <form action="">
                <div class="Set-pop">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div style="border-right: 1px solid #231f20;">
                                <h5>Account</h5>
                                <div class="options">
                                    <input id="user-name" type="text" name="uname" placeholder="User Name" disabled>
                                </div>
                                <div class="options">
                                    <input id="password" type="password" name="password" placeholder="Password" required>
                                </div>
                                <div class="options">
                                    <input id="password_confirmation" type="password" name="password_confirmation" placeholder="Enter password again" required>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div>
                                <h5>Info</h5>
                                <div class="options">
                                    <div class="auth-actions">
                                        <input type="text" name="" placeholder="Fist Name">
                                        <input type="text" name="" placeholder="Middle Name">
                                        <input type="text" name="" placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="options">
                                    <input id="phone" type="tel" name="phone" placeholder="Phone" required>
                                </div>
                                <div class="options">
                                    <input id="email" type="text" value="Email" disabled>
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
                            </div>
                        </div>
                        <div class="options-divider"></div>
                        <div class="options">
                            <button class="opt-btn" type="submit" name="created">Save</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script src="js/Popup.js"></script>
    
    <%@include file="footer.jsp" %>
</body>
</html>