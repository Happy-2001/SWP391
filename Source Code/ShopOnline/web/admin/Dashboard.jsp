<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <div class="admin-avatar" data-bs-toggle="collapse" data-bs-target="#setting">
                                <img src="../images/img-1.jpg" alt="admin-avatar"> <span class="online"></span> 
                            </div>
                        </div>
                        <div class="dropdown-ls collapse" id="setting">
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
                                    <hr style="margin: 0;"></hr>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 menu-bar">
                <div class="menu">
                    <ul class="menu-links">
                        <li class="nav-link">
                            <a class="active" href="#">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-chart-simple"></i>
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
                            <a href="Customers.jsp">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-user-group fa-xl"></i>
                                </span>
                                <span class="text nav-text">Customers</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="/ShopOnline/message">
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
                            <a data-bs-toggle="collapse" href="#sub-list3">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-comment-dots fa-xl"></i>
                                </span>
                                <span class="text nav-text">Feedback</span>
                                <span class="sub-menu-arrow">
                                    <i class="fa-solid fa-arrow-right-long"></i>
                                </span>
                            </a>
                            <ul class="collapse" id="sub-list3">
                                <li><a href="#">Feedback List</a></li>
                                <li><a href="#">Feedback Details</a></li>
                            </ul>
                        </li>
        
                        <li class="nav-link">
                            <a href="account.html">
                                <span class="nav-link-icon">
                                    <i class="fa-solid fa-circle-user fa-xl"></i>
                                </span>
                                <span class="text nav-text">Accounts</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9 main">
            </div>
        </div>
    </div>
</body>
</html>
