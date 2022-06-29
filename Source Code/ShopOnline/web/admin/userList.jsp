<%@page import="java.util.List"%>
<%@page import="model.Slide"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin || Shop Online</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/Dashboard.css">
    <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>
    
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
    <body>
        <div class="topbar">
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-lg-3">
                    <nav class="navbar">
                        <!-- <i class="fa-solid fa-bars fa-lg toggle-switch"></i> -->
                        <a href="/ShopOnline/home" class="navbar-brand ms-4"><img src="../images/logo.png" class="logo"></a>
                    </nav>
                </div>
                <div class="col-lg-7">
                    <div class="notify-area">
                        <div class="page-title">Dashboard</div>
                        <div class="t-search">
                            <form action="action">
                                <div class="search-box">
                                    <input type="text" placeholder="Search...">
                                    <i class="fa-solid fa-magnifying-glass fa-sm icon"></i>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="user-head">
                        <div class="notifications">
                            <a href="#"><i class="fa-regular fa-bell icon"></i></a>
                            <span class="badge-num">2</span>
                        </div>
                        <div class="messages">
                            <a href="#"><i class="fa-regular fa-envelope icon"></i></a>
                            <span class="badge-num">1</span>
                        </div>
                        <div class="admin">
                            <div class="admin-avatar" data-bs-toggle="offcanvas" data-bs-target="#setting">
                                <img src="../images/img-1.jpg" alt="admin-avatar"> <span class="online"></span> 
                            </div>
                        </div>
                        <div class="offcanvas offcanvas-end" id="setting">
                            <div class="offcanvas-body">
                                <ul class="menu-links">
                                    <li class="nav-link">
                                        <a href="ProfileUser?userid=${sessionScope.userlogged.userid}">
                                            <span class="nav-link-icon">
                                                <i class="fa fa-eyedropper"></i>
                                            </span>
                                            <span class="text nav-text">Edit Profile</span>
                                        </a> 
                                    </li>
                                    <li class="nav-link">
                                        <a href="#">
                                            <span class="nav-link-icon">
                                                <i class="fa fa-envelope-o"></i>
                                            </span>
                                            <span class="text nav-text">My Inbox</span>
                                        </a> 
                                    </li>
                                    <li class="nav-link">
                                        <a href="#">
                                            <span class="nav-link-icon">
                                                <i class="fa fa-adjust"></i>
                                            </span>
                                            <span class="text nav-text">Task</span>
                                        </a> 
                                    </li>
                                    <li class="nav-link">
                                        <a href="#">
                                            <span class="nav-link-icon">
                                                <i class="fa fa-calendar"></i>
                                            </span>
                                            <span class="text nav-text">Calender</span>
                                        </a> 
                                    </li>
                                    <li class="nav-link">
                                        <a href="#">
                                            <span class="nav-link-icon">
                                                <i class="fa fa-align-right"></i>
                                            </span>
                                            <span class="text nav-text">Balance Report</span>
                                        </a> 
                                    </li>
                                    <li class="nav-link">
                                        <a href="logout">
                                            <span class="nav-link-icon">
                                                <i class="fa fa-sign-out"></i>
                                            </span>
                                            <span class="text nav-text">Log Out</span>
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
        <div class="blog-content">
                                    <div class="title-blog">
                                        <a href="blogdetail?id=${b.id}" class="h3">${b.content}</a>
                                        <p>${b.description}</p>
                                    </div>
                                </div>

        
    </body>
</html>
