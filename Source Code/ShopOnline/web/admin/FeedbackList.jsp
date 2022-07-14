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
                            <a href="/ShopOnline/MyOrderController">
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
                <div class="content ">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="row mb-4">
                                <div class="col-md-7 d-flex">
                                    <div class="me-3">
                                        <div class="input-group">
                                            <div class="input-group-text bg-white">
                                                <input class="form-check-input todo-check-all mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
                                            </div>
                                            <button class="btn btn-light bg-white dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false"></button>
                                            <div class="dropdown-menu" style="margin: 0px;">
                                                <a class="dropdown-item" href="#">Favourites</a>
                                                <a class="dropdown-item" href="#">Done</a>
                                                <a class="dropdown-item" href="#">Deleted</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dropdown">
                                        <a href="#" class="btn bg-white" data-bs-toggle="dropdown" aria-expanded="false">
                                            <i class="fa-solid fa-list-ul fa-xs me-2"></i> Order by
                                        </a>
                                        <div class="dropdown-menu" style="margin: 0px;">
                                            <a class="dropdown-item" href="#">Date</a>
                                            <a class="dropdown-item" href="#">User</a>
                                            <a class="dropdown-item" href="#">Subject</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <form class="mt-4 mt-md-0">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Search todo list">
                                            <button class="btn btn-light bg-white" type="submit">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                
                            <div class="todo-list">
                                <ul class="list-group gap-3">
                                    <c:forEach items="${fblist}" var="feedb">
                                        <li class="list-group-item <c:if test="${feedb.status == 0}">todo-completed</c:if>">
                                            <div class="flex-shrink-0">
                                                <input class="form-check-input" id="form-check" type="checkbox" value="${feedb.fbID}">
                                            </div>
                                            <div class="flex-shrink-0">
                                                <i class="fa-regular fa-star"></i>
                                            </div>
                                            <div class="flex-grow-1">
                                                <div class="d-flex justify-content-between align-items-center">
                                                    <h6 class="text-truncate p-0 m-0" style="color: #05b171;">
                                                        ${feedb.user.firstname} ${feedb.user.middlename} ${feedb.user.lastname}
                                                    </h6>
                                                    <div class="ps-3 d-flex">
                                                        <span class="text-nowrap text-muted">${feedb.createDate}</span>
                                                        <div class="dropdown ms-3">
                                                            <a href="#" class="btn btn-floating btn-sm" data-bs-toggle="dropdown">
                                                                <i class="fa-solid fa-ellipsis"></i>
                                                            </a>
                                                            <div class="dropdown-menu dropdown-menu-end" style="margin: 0px;">
                                                                <a class="dropdown-item" href="#">Mark as unread</a>
                                                                <a class="dropdown-item" href="#">Done</a>
                                                                <a class="dropdown-item text-danger" href="#">Delete</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="text-muted d-flex justify-content-between">
                                                    <div class="text-truncate">
                                                        ${feedb.description}
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            
                            <script>
                                var checkB = document.querySelectorAll("#form-check");
                                var box = document.querySelectorAll(".list-group-item");
                                for (let i=0; i<checkB.length; i++){
                                    box[i].onclick = function() {
                                        window.location.href = "FeedbackDetails?fbID="+checkB[i].value;
                                    };
                                }
                            </script>
                
                            <nav aria-label="Page navigation">
                                <c:if test="${countPage != null}">
                                    <ul class="pagination justify-content-center mt-4">
                                        <li class="page-item">
                                            <a class="page-link" href="?page=1" aria-label="Previous">
                                                <i class="fa-solid fa-angles-left fa-xs"></i>
                                            </a>
                                        </li>
                                        <c:forEach begin="1" end="${countPage}" var="p">
                                            <li class="page-item ${p == PAGE ? "active":""}"><a class="page-link" href="?page=${p}">${p}</a></li>
                                        </c:forEach>
                                        <li class="page-item">
                                            <a class="page-link" href="?page=${countPage}" aria-label="Next">
                                                <i class="fa-solid fa-angles-right fa-xs"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </c:if>
                            </nav>
                        </div>
                        <div class="col-md-3">
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-pills flex-column gap-2">
                                        <li class="nav-item">
                                            <a class="nav-link active d-flex align-items-center" href="#">
                                                <i class="fa-solid fa-list-ul fa-xs me-3"></i>
                                                All
                                                <span class="badge bg-primary ms-auto">${AllTask}</span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link d-flex align-items-center" href="#">
                                                <i class="fa-solid fa-list-check fa-sm me-3"></i>My Task
                                                <span class="badge bg-primary ms-auto">${AllTask - Done}</span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">
                                                <i class="fa-regular fa-heart fa-sm me-3"></i>Favorites
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link d-flex align-items-center" href="#">
                                                <i class="fa-regular fa-circle-check fa-sm me-3"></i>
                                                Done
                                                <span class="badge bg-primary ms-auto">${Done}</span>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link d-flex align-items-center" href="#">
                                                <i class="fa-solid fa-trash fa-sm me-3"></i> Deleted
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
