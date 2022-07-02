<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<div class="topbar">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-lg-3">
                <nav class="navbar">
                    <!-- <i class="fa-solid fa-bars fa-lg toggle-switch"></i> -->
                    <a href="/ShopOnline/home" class="navbar-brand ms-4"><img src="images/logo.png" class="logo"></a>
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
                            <img src="RetrieveImg?eaID=${sessionScope.userlogged.userid}" alt="avatar"> <span class="online"></span> 
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
