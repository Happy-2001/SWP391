<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin || Sneaker Store</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/Dashboard.css">
    <link rel="stylesheet" href="../css/Feedback.css">
    <script src="../js/fontAwesome.js" crossorigin="anonymous"></script>
    
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
    <%@include file="Topbar.jsp" %>
        
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 menu-bar">
                <div class="menu">
                    <ul class="menu-links">
                        <li class="nav-link">
                            <a href="dashboard">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-chart-simple fa-xl"></i>
                                </span>
                                <span class="text nav-text">Dashboard</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-receipt fa-xl"></i>
                                </span>
                                <span class="text nav-text">Orders</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-box fa-xl"></i>
                                </span>
                                <span class="text nav-text">Products</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="CusController">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-user-group fa-xl"></i>
                                </span>
                                <span class="text nav-text">Customers</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="message">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-envelope fa-xl"></i>
                                </span>
                                <span class="text nav-text">Chats</span>
                                <span class="badge bg-success rounded-circle ms-auto">1</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-bell fa-xl"></i>
                                </span>
                                <span class="text nav-text">Notifications</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a class="active" href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-comment-dots"></i>
                                </span>
                                <span class="text nav-text">Feedback</span>
                            </a>
                        </li>
        
                        <li class="nav-link">
                            <a href="account.html">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-circle-user fa-xl"></i>
                                </span>
                                <span class="text nav-text">Accounts</span>
                            </a>
                        </li>
                        
                        <li class="nav-link">
                            <a href="SuppliersController">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-truck-arrow-right"></i>
                                </span>
                                <span class="text nav-text">Suppliers</span>
                            </a>
                        </li>
                        
                        <li class="nav-link">
                            <a href="slider">
                                <span class="nav-link-icon">
                                <i class="fa-solid fa-sliders"></i>
                                </span>
                                <span class="text nav-text">Manage Slider</span>
                               
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <!-- ------------ Main Content -------------- -->
            <div class="col-lg-9 main">
                <div class="content">
                    <div aria-label="breadcrumb" class="mb-3">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item">
                                <i class="fa-solid fa-globe fa-sm"></i>
                                <a href="dashboard">Dashboard</a>
                            </li>
                            <li class="breadcrumb-item">
                                <a href="FeedbackAd">Feedback</a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">Feedback Details</li>
                        </ul>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex align-items-center my-4">
                                <div class="d-flex align-items-center">
                                    <div class="avatar me-3">
                                        <img src="../RetrieveImg?eaID=${mfb.user.userid}" class="rounded-circle" alt="image">
                                    </div>
                                    <div>
                                        <h6 class="mb-1 p-0">
                                            ${mfb.user.firstname} ${mfb.user.middlename} ${mfb.user.lastname}
                                            <span class="d-sm-inline fw-normal d-none text-muted ms-2">&lt;${mfb.user.email}&gt;</span>
                                        </h6>
                                        <span class="small text-muted">${mfb.user.username}</span>
                                    </div>
                                </div>
                                <div class="ms-auto d-none d-md-flex align-items-center gap-3">
                                    <a href="#" style="color: #666;">
                                        <i class="fa-solid fa-star favorite" style="color: #faae42;"></i>
                                    </a>
                                    <span class="text-muted">${mfb.createDate}</span>
                                    <div class="dropdown">
                                        <a href="#" data-bs-toggle="dropdown" class="btn btn-sm" aria-haspopup="true" aria-expanded="false">
                                            <i class="fa-solid fa-ellipsis"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-end" style="margin: 0px;">
                                            <a href="#" class="dropdown-item">Mark as unread</a>
                                            <a href="#" class="dropdown-item">Mark as done</a>
                                            <a href="#" class="dropdown-item text-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-4">
                                <div class="mb-3">
                                    Feedback for order num:
                                    <a href="#" style="color: #ff6e40;">
                                        <em>#1</em>
                                    </a>
                                </div>
                                <div class="mb-4">
                                    <div>
                                        <strong>Feedback</strong>
                                    </div>
                                    <div>
                                        <p>${mfb.description}</p>
                                    </div>
                                    <div>
                                        <strong>Star Rating</strong>
                                        <div class="star-rate">
                                            <c:forEach begin="1" end="${mfb.rating}">
                                                <i class="fa-solid fa-star"></i>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="Attachments mb-3">
                                    <h6 class="mb-3">Attachments</h6>
                                    <div class="d-flex gap-3">
                                        <div class="image">
                                            <img src="${mfb.photo1}" onError="this.onerror=null;this.src='../images/camera-icon-bg.jpg';">
                                        </div>
                                        <div class="image">
                                            <img src="${mfb.photo2}" onError="this.onerror=null;this.src='../images/camera-icon-bg.jpg';">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-3">Reply</h6>
                            <c:if test="${mfb.note ne null}">
                                <div class="mb-3 p-3" style="border: 1px dashed #666;;">
                                    <span class="text-muted">${mfb.updateDate}</span>
                                    <p class="p-0 m-0">${mfb.note}</p>
                                </div>
                            </c:if>
                            <form action="FeedbackDetails" method="POST">
                                <div class="fb-reply mb-3">
                                    <input type="hidden" name="fbID" value="${mfb.fbID}">
                                    <textarea name="reply" id="ql-editor" placeholder="Type something... " onkeyup="req()"></textarea>
                                    <span id="left">Remaining 1000 fillable characters</span>
                                </div>
                                <div class="del-btn">
                                    <button type="submit" class="btn">Send</button>
                                </div>
                            </form>
                        </div>
                        <script>
                            const messArea = document.getElementById("ql-editor"),
                                num = document.getElementById("left");

                            function req(){
                                var mess = messArea.value;
                                var required = 1000;
                                var left = required - mess.length;

                                if(left > 0){
                                    num.innerHTML = "Remaining " + left + " fillable characters";
                                    return false;
                                }

                                num.innerHTML = "0";
                                return true;
                            };
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
